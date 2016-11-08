package chat.view;

import java.awt.Color;
import chat.controller.ChatController;
import javax.swing.*;

public class ChatPanel extends JPanel
{
	private ChatController baseController;
	private JTextField entryField;
	private JTextArea displayText;
	private SpringLayout baseLayout;
	private JButton enterButton;
	
	public ChatPanel(ChatController baseController)
	{
		super();
		this.baseController = baseController;
		
		baseLayout = new SpringLayout();
		entryField = new JTextField("Enter here!");
		
		displayText = new JTextArea("What do you want to talk about?");
		enterButton = new JButton("Enter!");
		setupPanel();
		setupLayout();
		setupListeners();
	}
	
	private void setupPanel() 
	{
		this.setLayout(baseLayout);
		this.setBackground(Color.RED);
		entryField.isEnabled();
		this.add(entryField);
		this.add(displayText);
		this.add(enterButton);
	}
	
	private void setupLayout()
	{
		baseLayout.putConstraint(SpringLayout.SOUTH, displayText, -170, SpringLayout.SOUTH, this);
		baseLayout.putConstraint(SpringLayout.NORTH, entryField, 6, SpringLayout.SOUTH, displayText);
		baseLayout.putConstraint(SpringLayout.WEST, displayText, 124, SpringLayout.WEST, this);
		entryField.setHorizontalAlignment(SwingConstants.CENTER);
		baseLayout.putConstraint(SpringLayout.WEST, entryField, 124, SpringLayout.WEST, this);
		baseLayout.putConstraint(SpringLayout.EAST, entryField, -124, SpringLayout.EAST, this);
		entryField.setBackground(Color.ORANGE);
	}
	
	private void setupListeners()
	{
		
	}
}
