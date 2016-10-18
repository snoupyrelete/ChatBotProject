package chat.controller;

import chat.model.Chatbot;
import chat.view.ChatbotViewer;

public class ChatbotController
{
	private Chatbot stupidBot;
	private ChatbotViewer display;
	
	public ChatbotController()
	{
		stupidBot = new Chatbot("ROBO-BOT-AUTONOMOUS-MECHANICAL-AI-LEARNING-HUMAN-TALK-MACHINE-TO-ACQUIRE-CURRENCY-AND-HUMAN-FEMALES");
		display = new ChatbotViewer();
	}
	
	public void start() 
	{
		String response = "words";
		while (stupidBot.lengthChecker(response))
		{
			response = display.collectResponse("Give me something");
		}
		
	}
}
