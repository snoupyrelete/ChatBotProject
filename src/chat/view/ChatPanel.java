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
		entryField = new JTextField("\n");
		entryField.setToolTipText("Enter Here!");
		displayText = new JTextArea("What do you want to talk about?");
		enterButton = new JButton("Enter!");
		checkBox = new JCheckBox("Change Color!");
		
		
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
		entryField.setHorizontalAlignment(SwingConstants.CENTER);
		entryField.setBackground(Color.ORANGE);
		baseLayout.putConstraint(SpringLayout.EAST, entryField, 0, SpringLayout.EAST, displayText);
		baseLayout.putConstraint(SpringLayout.WEST, displayText, 124, SpringLayout.WEST, this);
		baseLayout.putConstraint(SpringLayout.EAST, displayText, -124, SpringLayout.EAST, this);
		baseLayout.putConstraint(SpringLayout.NORTH, entryField, 6, SpringLayout.SOUTH, displayText);
		baseLayout.putConstraint(SpringLayout.WEST, entryField, 0, SpringLayout.WEST, displayText);
		baseLayout.putConstraint(SpringLayout.NORTH, checkBox, 6, SpringLayout.SOUTH, enterButton);
		baseLayout.putConstraint(SpringLayout.EAST, checkBox, -179, SpringLayout.EAST, this);
		baseLayout.putConstraint(SpringLayout.NORTH, enterButton, 4, SpringLayout.SOUTH, entryField);
		baseLayout.putConstraint(SpringLayout.WEST, enterButton, 0, SpringLayout.WEST, entryField);
		baseLayout.putConstraint(SpringLayout.EAST, enterButton, 0, SpringLayout.EAST, entryField);
	}
	
	private void setupListeners()
	{
		enterButton.addActionListener(new ActionListener()
		{
			public void actionPerformed(ActionEvent selection)
			{
				displayText.setText(baseController.useChatbotCheckers(entryField.getText()));
				entryField.setText("");
			}
		});
		checkBox.addActionListener(new ActionListener()
		{
			public void actionPerformed(ActionEvent selection)
			{
				changeBackground();
			}
		});
	}
	
	private void changeBackground()
	{
		int red = (int) (Math.random() * 256);
		int green = (int) (Math.random() * 256);
		int blue = (int) (Math.random() * 256);
		
		this.setBackground(new Color(red, green, blue));
	}
}
