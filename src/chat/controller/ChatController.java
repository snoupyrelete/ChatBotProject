package chat.controller;

import chat.model.Chatbot;
import chat.view.ChatFrame;
import chat.view.ChatPanel;
import chat.view.ChatbotViewer;

public class ChatController
{
	private Chatbot stupidBot;
	private ChatbotViewer display;
	private ChatFrame chatFrame;
	
	public ChatController()
	{
		stupidBot = new Chatbot("ROBO-BOT-AUTONOMOUS-MECHANICAL-AI-LEARNING-HUMAN-TALK-MACHINE-TO-ACQUIRE-CURRENCY-AND-HUMAN-FEMALES");
		display = new ChatbotViewer();
		chatFrame = new ChatFrame(this);
	}
	
	public void start() 
	{
//		String response = display.collectResponse("Give me something");
//		while (stupidBot.lengthChecker(response))
//		{
//			display.displayMessage(useChatbotCheckers(response));
//			response = display.collectResponse("You want to talk about " + response +"? Tell me more...");
//		}
		
	}
	
	public String useChatbotCheckers(String input) 
	{
		String checkedInput = "";
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
		
		return checkedInput;
	}
	
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
			randomTopic = "?!!?!?!?!?";
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
