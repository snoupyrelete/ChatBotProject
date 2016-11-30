package chat.controller;

import chat.model.Chatbot;
import chat.view.ChatFrame;
import chat.view.ChatPanel;
import chat.view.ChatbotViewer;
/**
 * The controller class for chatbot, which communicates between the model and view.
 * @author drob8896
 * @version 1.0 11/22/16
 */
public class ChatController
{
	/**
	 * The Chatbot model to be created to communicate with the user
	 */
	private Chatbot stupidBot;
	/**
	 * Deprecated-Previously used to display text to user
	 */
	private ChatbotViewer display;
	/**
	 * The current GUI to show response and input to the user.
	 */
	private ChatFrame chatFrame;
	/**
	* Constructor for the controller, which creates a Chatbot model, ChatbotViewer and chatFrame.
	*/
	public ChatController()
	{
		stupidBot = new Chatbot("ROBO-BOT-AUTONOMOUS-MECHANICAL-AI-LEARNING-HUMAN-TALK-MACHINE-TO-ACQUIRE-CURRENCY-AND-HUMAN-FEMALES");
		display = new ChatbotViewer();
		chatFrame = new ChatFrame(this);
	}
	/**
	 * Called from the runner, not yet implemented.
	 */
	public void start()
	{
		
	}
	/**
	* Uses all of the chatbot model's checkers to create a response
	* to the user's input.
	* @param input The input to check with all the checkers.
	* @return the chatbot's response.
	*/
	public String useChatbotCheckers(String input) 
	{
		String checkedInput = "";
		if (!stupidBot.quitChecker(input))
		{
			if (stupidBot.memeChecker(input))
			{
				checkedInput += "\nYou like memes!\n";
			}
			if(stupidBot.contentChecker(input))
			{
				checkedInput += "\nYou kow my secret topic!\n";
			}
			if(stupidBot.politicalTopicChecker(input))
			{
				checkedInput += "\nYou like politics\n";
			}
			if(stupidBot.twitterChecker(input))
			{
				checkedInput += "\nYou like to tweet\n";
			}
			if(stupidBot.inputHTMLChecker(input))
			{
				checkedInput += "You like HTML...I guess?";
			}
			if(checkedInput.length() == 0)
			{
				checkedInput = "I don't know what" + input + " is";
			}
		checkedInput += " " + randomTopicGenerator();
		}
		else 
		{
			display.displayMessage("Thanks for chatting. Talk to you soon ;)");
			System.exit(0);
		}
		return checkedInput;
	}
	/**
	* Creates a random topic from a set list, in the event the user doesn't enter a valid
	* input, such as an empty string.
	* @return a String containing the random Topic that the chatBot will talk about.
	*/
	private String randomTopicGenerator()
	{
		String randomTopic = "";
		int random = (int) (Math.random() * 7);
		
		switch(random)
		{
		case 0:
			randomTopic = "I like video games!";
			break;
		case 1:
			randomTopic = "Football = true";
			break;
		case 2:
			randomTopic = "Futbol = false";
			break;
		case 3:
			randomTopic = "code?";
			break;
		case 4:
			randomTopic = "I am a robot! What are you?";
			break;
		case 5:
			randomTopic = "What's your name?";
			break;
		case 6:
			randomTopic = "Futbol = false";
			break;
		default:
			randomTopic = "OH, NO WHAT'S GOING ON THIS SHOULDN'T BE HAPPENING!";
			break;
		}
		return randomTopic;
	}
	
	public ChatFrame getBaseFrame()
	{
		return chatFrame;
	}
	public Chatbot getChatbot()
	{
		return stupidBot;
	}
}
