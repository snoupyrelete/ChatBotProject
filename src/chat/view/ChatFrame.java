package chat.view;

import javax.swing.JFrame;
import java.awt.Dimension;
import chat.controller.ChatController;
import javax.swing.JLabel;

public class ChatFrame extends JFrame
{
	private ChatController baseController;
	private ChatPanel chatPanel;
	
	public ChatFrame(ChatController baseController)
	{
		super();
		this.baseController = baseController;
		chatPanel = new ChatPanel(baseController);
		setupFrame();
	}
	
	private void setupFrame()
	{
		this.setContentPane(chatPanel);
		this.setTitle("Chatbot Window");
		this.setSize(new Dimension(500, 500));
		this.setVisible(true);
	}
}
