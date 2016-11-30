package chat.view;

import javax.swing.JOptionPane;
import javax.swing.ImageIcon;

public class ChatbotViewer
{
	private ImageIcon chatBotIcon;
	private String windowMessage;
	public ChatbotViewer()
	{
		//chatBotIcon = new ImageIcon(getClass().getResource("images/chatbot.png"));
		windowMessage = "SwagBot";
	}
	
	
	/**
	 * Gets a text response from the user
	 * @param question the question to ask the user or prompt
	 * @return the user's response
	 */
	public String collectResponse(String question) 
	{
		String response = "";
		
		response = JOptionPane.showInputDialog(null, question, windowMessage, JOptionPane.INFORMATION_MESSAGE, chatBotIcon, null, "Type here please!").toString();
				
		return response;
	}
	/**
	 * Display a message to the user
	 * @param message the message to show
	 */
	public void displayMessage(String message)
	{
		JOptionPane.showMessageDialog(null, message, windowMessage, JOptionPane.PLAIN_MESSAGE, chatBotIcon);
	}
	/**
	 * Ask the user a question and have them click a button for response
	 * @param question the question to ask
	 * @return the response the user clicked.
	 */
	public int collectUserOption(String question)
	{
		int response = 0;
		
		response = JOptionPane.showConfirmDialog(null, question);
		
		return response;
	}

}

