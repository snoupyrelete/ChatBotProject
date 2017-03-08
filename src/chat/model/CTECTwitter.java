package chat.model;

import javax.naming.AuthenticationException;

import chat.controller.ChatController;
import twitter4j.TwitterException;
import twitter4j.TwitterFactory;
import twitter4j.Twitter;
import twitter4j.Status;
import twitter4j.Paging;

import java.util.List;
import java.util.Scanner;
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

		results += "There are " + tweetedWords.size() + " words in the tweets from " + user;
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
				tweetedWords.add(tweetWords[index]);
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
	
	private void removeEmptyText()
	{
		for(int index = 0; index < tweetedWords.size(); index++)
		{
			if(tweetedWords.get(index).trim().equals(""))
			{
				tweetedWords.remove(index);
				index--;
			}
		}
	}
	
	
	
	

	
	
}
