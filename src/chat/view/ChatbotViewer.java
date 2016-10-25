package chat.view;

import javax.swing.JOptionPane;
import javax.swing.ImageIcon;

public class ChatbotViewer
{
	private ImageIcon chatBotIcon;
	private String windowMessage;
	public ChatbotViewer()
	{
		chatBotIcon = new ImageIcon(getClass().getResource("images/chatbot.png"));
		windowMessage = "Hello from chatbot!";
	}
	
	
	
	public String collectResponse(String question) 
	{
		String response = "";
		
		response = JOptionPane.showInputDialog(null, question, windowMessage, JOptionPane.INFORMATION_MESSAGE, chatBotIcon, null, "Type here please!").toString();
				
		return response;
	}
	
	public void displayMessage(String message)
	{
		JOptionPane.showMessageDialog(null, message, windowMessage, JOptionPane.PLAIN_MESSAGE, chatBotIcon);
	}
	
	public int collectUserOption(String question)
	{
		int response = 0;
		
		response = JOptionPane.showConfirmDialog(null, question);
		
		return response;
	}
}
