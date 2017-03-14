package chat.model;

import javax.naming.AuthenticationException;

import chat.controller.ChatController;
import twitter4j.TwitterException;
import twitter4j.TwitterFactory;
import twitter4j.Twitter;
import twitter4j.Status;
import twitter4j.GeoLocation;
import twitter4j.Paging;
import twitter4j.Query;
import twitter4j.QueryResult;

import java.util.List;
import java.util.Scanner;
import java.text.DecimalFormat;
import java.util.ArrayList;

public class CTECTwitter 
{
	private ChatController baseController;
	private Twitter chatbotTwitter;
	private List<Status> statusList;
	private List<String> tweetedWords;
	
	//private List<String> ignoredWords;
	
	public CTECTwitter(ChatController baseController)
	{
		this.baseController = baseController;
		this.statusList = new ArrayList<Status>();
		this.tweetedWords = new ArrayList<String>();
		this.chatbotTwitter = TwitterFactory.getSingleton();
		//createIgnoredWordsList();
		
		//sendTweet("I, DROB just tweeted from my Java Chatbot program 2017! #APCSRocks @CTECNow Thanks @cscheerleader & @codyhenrichsen! @ChatbotCTEC");
	}
	
	public void sendTweet(String tweet)
	{
		try 
		{
			chatbotTwitter.updateStatus(tweet);
		}
		catch (TwitterException tweetError)
		{
			baseController.handleErrors(tweetError);
		}
		catch (Exception error)
		{
			baseController.handleErrors(error);
		}
	}
	
	public void searchTweets(String username)
	{
		try
		{
//			for (int index = 0; index < 5; index++)
//			{
//				chatbotTwitter.search()
//			}
		}
		catch (Exception e)
		{
			
		}
	}
	
	public String getMostCommonWord(String user)
	{
		String results = "";
		
		getTweets(user);
		turnStatusesToWords();
		
		removeAllBoringWords();
		removeEmptyText();

		//results += "There are " + tweetedWords.size() + " words in the tweets from " + user;
		results += calculatePopularWordAndCount();
		results += queryForProgramming();
		return results;
	}

	private void getTweets(String username)
	{
		statusList.clear();
		tweetedWords.clear();
		
		Paging statusPage = new Paging(1,100);
		int page = 1;
		
		while(page <= 10)
		{
			statusPage.setPage(page);
			try
			{
				statusList.addAll(chatbotTwitter.getUserTimeline(username, statusPage));

			}
			catch (TwitterException searchTweetError)
			{
				baseController.handleErrors(searchTweetError);
				page = Integer.MAX_VALUE;
			}
			
			page++;
		}
		
		//chatbotTwitter.getUserTimeline();
		
	}
	
	private String [] createIgnoredWordArray()
	{
		String [] boringWords;
		
		int wordCount = 0;
		Scanner wordScanner = new Scanner(this.getClass().getResourceAsStream("commonWords.txt"));
		while(wordScanner.hasNextLine())
		{
			wordScanner.nextLine();
			wordCount++;
		}
		
		boringWords = new String [wordCount];
		wordScanner.close();
		
		wordScanner = new Scanner(this.getClass().getResourceAsStream("commonWords.txt"));
		for(int index = 0; index < boringWords.length; index++)
		{
			boringWords[index] = wordScanner.nextLine();
		}
		
		wordScanner.close();
		return boringWords;	
	}
	
	private void turnStatusesToWords()
	{
		for(Status currentStatus : statusList)
		{
			String tweetText = currentStatus.getText();
			String [] tweetWords = tweetText.split(" ");
			for (int index = 0; index < tweetWords.length; index++)
			{
				tweetedWords.add(removePunctuation(tweetWords[index]));
			}
		}
	}
	
	private void removeAllBoringWords()
	{
		String [] boringWords = createIgnoredWordArray();
		for(int index = 0; index < tweetedWords.size(); index++)
		{
			for(int boringIndex = 0; boringIndex < boringWords.length; boringIndex++)
			{
				if(tweetedWords.get(index).equalsIgnoreCase(boringWords[boringIndex]))
				{
					tweetedWords.remove(index);
					index--;
					boringIndex = boringWords.length;
				}
			}
		}
	}
	
	private String calculatePopularWordAndCount()
	{
		String info = "";
		String popWord = "";
		int popIndex = 0;
		int popCount = 0;
		
		for(int index = 0; index < tweetedWords.size(); index++)
		{
			int currentPop = 0;
			for(int searched = index + 1; searched < tweetedWords.size(); searched++)
			{
				if(tweetedWords.get(index).equalsIgnoreCase(tweetedWords.get(searched)) && !tweetedWords.get(index).equals(popWord))
				{
					currentPop++;
				}
			}
			if(currentPop > popCount)
			{
				popIndex = index;
				popCount = currentPop;
				popWord = tweetedWords.get(index);
			}
		}
		
		info = "The most popular word is: " + popWord + " occuring " + popCount + " times out of " + tweetedWords.size() + " (" + (DecimalFormat.getPercentInstance().format(((double) popCount)/tweetedWords.size()) + ")");
		return info;
	}
	
	private void removeEmptyText()
	{
		for(int index = tweetedWords.size() - 1; index >= 0; index--)
		{
			if(tweetedWords.get(index).trim().equals(""))
			{
				tweetedWords.remove(index);
			}
		}
	}
	
	private String removePunctuation(String currentString)
	{
		String punctuation = ".,'?!:;\"(){}^[]<>-";
				
		String scrubbedString = "";
		for (int i = 0; i < currentString.length(); i++)
		{
			if (punctuation.indexOf(currentString.charAt(i)) == -1)
			{
				scrubbedString += currentString.charAt(i);
			}
		}
		return scrubbedString;
		
	}
	
	public String queryForProgramming()
	{
		String results = "";
		String [] queryWords = {"for sale", "garage sale", "ksl classifieds",
				"classifieds", "selliing","yard sale", "selling", "antique", 
				"vintage", "estate sale", "free", "reward", "compensation", "pay",
				"physical labor"};
		for (int index = 0; index < queryWords.length; index++)
		{
			Query query = new Query(queryWords[index]);
			query.setCount(250);
			query.setGeoCode(new GeoLocation(40.587521, -111.869178), 20, Query.MILES);
			query.setSince("2017-1-1");
			try
			{
				QueryResult result = chatbotTwitter.search(query);
				//results += "Count : " + result.getTweets().size() + "\n";
				for (Status tweet : result.getTweets())
				{
					// TODO: How to split by pipe?? too slow!
					results += "|" + "@"+ tweet.getUser().getScreenName()+ ": " + tweet.getText(); 
				}
			
			}
			catch (TwitterException e)
			{
				baseController.handleErrors(e);
			}
		}
		//results = "<font color=\"green\">" + results + "</font>";
		return results; 
	}
}
