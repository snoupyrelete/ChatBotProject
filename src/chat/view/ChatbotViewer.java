package chat.view;

import javax.swing.JOptionPane;
import javax.swing.ImageIcon;
public class ChatbotViewer
{
	private String windowMessage;
	private ImageIcon ChatIcon;
	
	public ChatbotViewer()
	{
		windowMessage = "This message is from chatbot!";
		ChatIcon = new ImageIcon(getClass().getResource("images/chatbot.png"));
	}
	public String collectResponse(String question) 
	{
		String response = "";
		
		response = JOptionPane.showInputDialog(null, question);
				
		return response;
	}
	
	public void displayMessage(String message)
	{
		JOptionPane.showMessageDialog(null, message);
	}
	
	public int collectUserOption(String question)
	{
		int response = 0;
		
		response = JOptionPane.showConfirmDialog(null, question);
		
		return response;
	}
}
