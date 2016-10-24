package chat.model;

import java.util.ArrayList;

/**
 * Base version of the 2015 Chatbot class. Only stub methods are provided.
 * Students will complete methods as part * of the project. * @author Cody
 * Henrichsen * @version 1.0 10/14/15
 */
public class Chatbot
{
	private ArrayList<String> memesList;
	private ArrayList<String> politicalTopicList;
	private String userName;
	private String content;

	/**
	 * * Creates an instance of the Chatbot with the supplied username. * @param
	 * userName The username for the chatbot.
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
	 * * Checks the length of the supplied string. Returns false if the supplied
	 * String is empty or null, otherwise returns true. * @param currentInput * @return
	 * A true or false based on the length of the supplied String.
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
	 * * Checks if the supplied String matches the content area for this Chatbot
	 * instance.
	 * 
	 * @param currentInput
	 *            The supplied String to be checked. * @return Whether it
	 *            matches the content area.
	 */
	public boolean contentChecker(String currentInput)
	{
		boolean hasContent = false;
		
		if (currentInput.contains(content)) 
		{
			hasContent = true;
		}
		
		return hasContent;
	}

	/**
	 * * Checks if supplied String matches ANY of the topics in the
	 * politicalTopicsList. Returns true if it does find a match and false if it
	 * does not match.
	 * 
	 * @param currentInput
	 *            The supplied String to be checked. * @return Whether the
	 *            String is contained in the ArrayList.
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
	 * * Checks to see that the supplied String value is in the current
	 * memesList variable.
	 * 
	 * @param currentInput
	 *            The supplied String to be checked. * @return Whether the
	 *            supplied String is a recognized meme.
	 */
	public boolean memeChecker(String currentInput)
	{
		boolean isMeme = false;
		for (int i = 0; i < memesList.size(); i++) 
		{
			//memesList.ge
			if (currentInput.equalsIgnoreCase(memesList)) 
			{
				isMeme = true;
			}
		}
		return isMeme;
	}

	/**
	 * * Returns the username of this Chatbot instance. * @return The username
	 * of the Chatbot.
	 */
	public String getUserName()
	{
		return userName;
	}

	/**
	 * * Returns the content area for this Chatbot instance. * @return The
	 * content area for this Chatbot instance.
	 */
	public String getContent()
	{
		return content;
	}

	/**
	 * * Getter method for the memesList object. * @return The reference to the
	 * meme list.
	 */
	public ArrayList<String> getMemesList()
	{
		return memesList;
	}

	/**
	 * * Getter method for the politicalTopicList object. * @return The
	 * reference to the political topic list.
	 */
	public ArrayList<String> getPoliticalTopicList()
	{
		return politicalTopicList;
	}

	/**
	 * * Updates the content area for this Chatbot instance. * @param content
	 * The updated value for the content area.
	 */
	public void setContent(String content)
	{
		this.content = content;
	}
}
