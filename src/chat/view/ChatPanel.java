package chat.view;

import java.awt.Color;

import chat.controller.ChatController;

import javax.swing.*;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;


public class ChatPanel extends JPanel
{
	private ChatController baseController;
	private JTextField entryField;
	private JTextArea displayText;
	private SpringLayout baseLayout;
	private JButton enterButton;
	private JCheckBox checkBox;
	//private JImage chatImage;
	
	public ChatPanel(ChatController baseController)
	{
		super();
		this.baseController = baseController;
		
		baseLayout = new SpringLayout();
		entryField = new JTextField("Enter here!");
		displayText = new JTextArea("What do you want to talk about?");
		enterButton = new JButton("Enter!");
		checkBox = new JCheckBox("Check it!");
		
		setupDisplayText();
		setupPanel();
		setupLayout();
		setupListeners();
	}
	
	private void setupDisplayText()
	{
		displayText.setEditable(false);
		displayText.setEnabled(false);
		displayText.setWrapStyleWord(true);
		displayText.setLineWrap(true);
	}
	private void setupPanel() 
	{
		this.setLayout(baseLayout);
		this.setBackground(Color.RED);
		
		//entryField.isEnabled();
		
	
		this.add(entryField);
		this.add(displayText);
		this.add(enterButton);
		this.add(checkBox);
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
		baseLayout.putConstraint(SpringLayout.WEST, enterButton, 180, SpringLayout.WEST, this);
		baseLayout.putConstraint(SpringLayout.SOUTH, enterButton, -22, SpringLayout.NORTH, displayText);
		baseLayout.putConstraint(SpringLayout.NORTH, checkBox, 21, SpringLayout.SOUTH, entryField);
		baseLayout.putConstraint(SpringLayout.WEST, checkBox, 0, SpringLayout.WEST, enterButton);
	}
	
	private void setupListeners()
	{
		enterButton.addActionListener(new ActionListener()
		{
			public void actionPerformed(ActionEvent selection)
			{
				//displayText.setText("You want to talk about: \'" + entryField.getText() + "\'");
				displayText.setText(baseController.useChatbotCheckers(entryField.getText()));
			}
		});
	}
}
