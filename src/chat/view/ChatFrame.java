package chat.view;

import javax.swing.JFrame;
import java.awt.Dimension;
import chat.controller.ChatController;
import javax.swing.JLabel;
/**
 * The ChatFrame to hold the Panel to show GUI to the user.
 * @author Dylan Robson
 * @version 1.0 11/22/16
 */
public class ChatFrame extends JFrame
{
	/**
	 * The controller used to create the panel
	 */
	private ChatController baseController;
	/**
	 * The panel that goes within the frame
	 */
	private ChatPanel chatPanel;
	/**
	 * Constructs the ChatFrame and initializes its panel
	 * @param baseController the controller to be used in the construction of the ChatPanel
	 */
	public ChatFrame(ChatController baseController)
	{
		super();
		this.baseController = baseController;
		chatPanel = new ChatPanel(baseController);
		setupFrame();
	}
	/**
	 * A helper method to set the panel to be placed within the ChatFrame
	 * and to properly size and show the frame itself.
	 */
	private void setupFrame()
	{
		this.setContentPane(chatPanel);
		this.setTitle("Chatbot Window");
		this.setSize(new Dimension(750, 500));
		this.setVisible(true);
	}
}
