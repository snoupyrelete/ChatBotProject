package chat.model;

import java.util.ArrayList;

/**
 * Base version of the 2015 Chatbot class. Only stub methods are provided.
 * Students will complete methods as part * of the project. * @author Cody
 * Henrichsen * @version 1.0 10/14/15
 */
public class Chatbot
{
	/**
	 * An ArrayList of memes
	 */
	private ArrayList<String> memesList;
	/**
	 * An ArrayList of Political Topics
	 */
	private ArrayList<String> politicalTopicList;
	/**
	 * The name to create the bot with
	 */
	private String userName;
	/**
	 * the 'secret' topic that the bot will respond to if the user
	 * guesses it: such as "video games"
	 */
	private String content;

	/**
	 * Constructor for an instance of the Chatbot with the supplied 
	 * username. 
	 * @param userName The username for the chatbot.
	 */
	public Chatbot(String userName)
	{
		memesList = new ArrayList<String>(); 
		politicalTopicList = new ArrayList<String>();
		buildMemesList();
		buildPoliticalTopicsList();
		this.userName = userName;
		this.content = "video games";
	}
	/**
	 * Currently unused
	 */
	public void start()
	{
		
	}
	/**
	 * Adds several memes to the memesList ArrayList
	 */
	private void buildMemesList()
	{
		//.equalsIgnoreCase
		memesList.add("doge");
		memesList.add("cute animals");
		memesList.add("grumpy cat");
		memesList.add("dat boi");
		memesList.add("willy wonka");
		memesList.add("harambe");
		memesList.add("john cena");
		memesList.add("mr skeltal");
		memesList.add("pupper");
		memesList.add("pepe");
		memesList.add("neckbeard");
		memesList.add("shrek");
		memesList.add("arthur");
		memesList.add("m'lady");
		memesList.add("fedora");
		memesList.add("illuminati");
		memesList.add("anonymous");
		memesList.add("cringe");
	}
	/*
	 * Adds several political topics to the PoliticalTopicList ArrayList
	 */
	private void buildPoliticalTopicsList()
	{
		//.equals
		politicalTopicList.add("Democrat");
		politicalTopicList.add("Republican");
		politicalTopicList.add("11/8/16");
		politicalTopicList.add("conservative");
		politicalTopicList.add("Clinton");
		politicalTopicList.add("Trump");
		politicalTopicList.add("Kaine");
		politicalTopicList.add("Pence");
		politicalTopicList.add("Stein");
		politicalTopicList.add("Johnson");
		politicalTopicList.add("election");
		politicalTopicList.add("vote");
		politicalTopicList.add("Donald");
		politicalTopicList.add("Hillary");
		politicalTopicList.add("terrorism");
		politicalTopicList.add("ISIS");
		politicalTopicList.add("healthcare");
		politicalTopicList.add("America");
		politicalTopicList.add("United States");
		politicalTopicList.add("corruption");
		politicalTopicList.add("scandal");
		politicalTopicList.add("sexual harassment");
		politicalTopicList.add("make America great again");
		politicalTopicList.add("third party");
		politicalTopicList.add("canidate");
		politicalTopicList.add("liberal");
	
	}

	/**
	 * Checks the length of the supplied string.
	 * @param currentInput the input to check the length of
	 * @return A boolean value based on the length of the supplied String. 
	 * True if length != 0 or != null, otherwise false
	 */
	public boolean lengthChecker(String currentInput)
	{
		boolean hasLength = false;
		
		if (currentInput != null && !currentInput.equals(""))
		{
			hasLength = true;
		}
		return hasLength;
	}

	/**
	 * Checks if the supplied String matches the content area for this Chatbot
	 * instance.
	 * @param currentInput The supplied String to be checked.
	 * @return A boolean value indicating whether it matches the content area or not.
	 */
	public boolean contentChecker(String currentInput)
	{
		boolean hasContent = false;
		
		if (currentInput.toLowerCase().contains(content.toLowerCase())) 
		{
			hasContent = true;
		}
		
		return hasContent;
	}
	/**
	 * Checks to see if the input is a tweet, with either '#' or '@'
	 * @param currentInput the String to check
	 * @return a boolean value if the input was a tweet
	 */
	public boolean twitterChecker(String currentInput)
	{
		boolean isTweet = false;
		int indexOfHashtag = -1;
		int indexOfAtSign = -1;
		
		indexOfHashtag = currentInput.indexOf("#");
		indexOfAtSign = currentInput.indexOf("@");
		
		if(indexOfHashtag != -1 && !currentInput.substring(indexOfHashtag + 1, indexOfHashtag + 2).equals(" "))
		{
			isTweet = true;
		} else if (indexOfAtSign != -1 && !currentInput.substring(indexOfAtSign + 1, indexOfAtSign + 2).equals(" "))
		{
			isTweet = true;
		}
		return isTweet;
	}
	

	
	/**
	 * Checks to see if the input is valid HTML
	 * @param currentInput the String to check
	 * @return a boolean value based on the input being valid HTML or not.
	 */
	public boolean inputHTMLChecker(String currentInput)
	{
		String input = currentInput.toLowerCase();
		boolean isValidHTML = false;
		if (input.startsWith("<B>") && input.endsWith("</B>"))
		{
			isValidHTML = true;
		} else if (input.startsWith("<I>") && input.endsWith("</i>"))
		{
			isValidHTML = true;
		} else if (input.startsWith("<P>"))
		{
			isValidHTML = true;
		} else if (input.startsWith("<A HREF="))
		{
			isValidHTML = true;		
		}
		return isValidHTML;
	}
	/**
	 * Checks to see if the user quit
	 * @param currentInput The String to check
	 * @return A boolean value indicating if the user wanted to quit or not
	 */
	public boolean quitChecker(String currentInput)
	{
		boolean userInitiatedQuit = false;
		if(currentInput.equals("quit"))
		{
			userInitiatedQuit = true;
		}
		return userInitiatedQuit;
	}
	/**
	 * Checks if the input was a preset of a certain combination of non-real worlds
	 * @param currentInput the input to check
	 * @return a boolean value based on if the input was keyboard mash or not.
	 */
	public boolean keyboardMashChecker(String currentInput)
	{
		boolean isMash = false;
		if(currentInput.equals("sdf") || currentInput.equals("dfg") || currentInput.equals("cvb") || currentInput.equals(",./"))
		{
			isMash = true;
		}
			return isMash; 
	}

	/**
	 * Checks if supplied String matches ANY of the topics in the
	 * politicalTopicsList. Returns true if it does find a match and false if it
	 * does not match.
	 * @param currentInput The supplied String to be checked. 
     * @return A boolean value indicating whether the String is 
     * contained in the PoliticalTopicList
	 */
	public boolean politicalTopicChecker(String currentInput)
	{
		boolean isPoliticalTopic = false;
		if (politicalTopicList.contains(currentInput))
		{
			isPoliticalTopic = true;
		}
		return isPoliticalTopic;
	}

	/**
	 * Checks to see that the supplied String value is in the current
	 * memesList variable.
	 * @param currentInput The supplied String to be checked. 
	 * @return a boolean value indicating whether the 
	 * supplied String is a recognized meme from the memesList.
	 */
	public boolean memeChecker(String currentInput)
	{
		boolean isMeme = false;
		for (int i = 0; i < memesList.size(); i++) 
		{
			if (currentInput.equalsIgnoreCase(memesList.get(i))) 
			{
				isMeme = true;
			}
		}
		return isMeme;
	}

	public String getUserName()
	{
		return userName;
	}
	public String getContent()
	{
		return content;
	}
	public ArrayList<String> getMemesList()
	{
		return memesList;
	}
	public ArrayList<String> getPoliticalTopicList()
	{
		return politicalTopicList;
	}
	public void setContent(String content)
	{
		this.content = content;
	}
}
