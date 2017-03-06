package chat.model;

import javax.naming.AuthenticationException;

import chat.controller.ChatController;
import twitter4j.TwitterException;
import twitter4j.TwitterFactory;
import twitter4j.Twitter;
import twitter4j.Status;

import java.util.List;
import java.util.Scanner;
import java.util.ArrayList;
public class CTECTwitter 
{
	private ChatController baseController;
	private Twitter chatbotTwitter;
	private List<Status> statusList;
	private List<String> ignoredWords;
	
	public CTECTwitter(ChatController baseController)
	{
		this.baseController = baseController;
		this.statusList = new ArrayList<Status>();
		this.ignoredWords = new ArrayList<String>();
		createIgnoredWordsList();
		this.chatbotTwitter = TwitterFactory.getSingleton();
		
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
	
	public void searchTweets()
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
	
	public String getMostCommonWord()
	{
		return null;
	}
	
	/*
	* PRIVATE
	*/
	
	// Helper
	private void createIgnoredWordsList()
	{
		Scanner commonWords = new Scanner("commonWords.txt");
		while (commonWords.hasNextLine())
		{
			ignoredWords.add(commonWords.next());
		}
		commonWords.close();
		
		System.out.println(ignoredWords.toString());
	}
	
	// Helper
	private void getTweets(String username)
	{
		
	}
}
