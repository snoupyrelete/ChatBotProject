package chat.view;

import java.awt.Color;
import chat.controller.ChatController;
import chat.controller.FileController;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import java.io.File;
/**
 * The ChatPanel to display the GUI to the user
 * @author Dylan Robson
 * @version 1.0 11/22/16
 */
public class ChatPanel extends JPanel
{

	private ChatController baseController;
	private JTextField entryField;
	//private JTextArea displayText;
	private JTextPane chatPane;
	private SpringLayout baseLayout;
	private JCheckBox checkBox;
	private JScrollPane scrollPane;
	
	private JButton enterButton;
	private JButton searchTwitterButton;
	private JButton sendTweetButton;
	private JButton saveButton;
	private JButton loadButton;
	private JButton moneyButton;
	
	private JFileChooser fileChooser;
	/**
	 * Constructor to create a new ChatPanel with several components.
	 * @param baseController the ChatController used to communicate with the controller
	 */
	public ChatPanel(ChatController baseController)
	{
		super();
		this.baseController = baseController;
		
		baseLayout = new SpringLayout();
		entryField = new JTextField("\n");
		entryField.setToolTipText("Enter Here!");
		//displayText = new JTextArea("What do you want to talk about?");
		checkBox = new JCheckBox("Change Color!");
		scrollPane = new JScrollPane();
		enterButton = new JButton("Chat!");
		searchTwitterButton = new JButton("Search");
		sendTweetButton = new JButton("Tweet");
		saveButton = new JButton("Save");
		loadButton = new JButton("Load");
		moneyButton = new JButton("$$$");
		chatPane = new JTextPane();
		baseLayout.putConstraint(SpringLayout.NORTH, chatPane, 25, SpringLayout.NORTH, this);
		baseLayout.putConstraint(SpringLayout.WEST, chatPane, 50, SpringLayout.WEST, this);
		baseLayout.putConstraint(SpringLayout.SOUTH, chatPane, -400, SpringLayout.SOUTH, this);
		baseLayout.putConstraint(SpringLayout.EAST, chatPane, -100, SpringLayout.EAST, this);
		
		
		fileChooser = new JFileChooser();
		fileChooser.setCurrentDirectory(new File("/Users/drob8896"));
		
		

		setupDisplayText();
		setupPanel();
		setupLayout();
		setupListeners();
	}
	/**
	 * A helper method to set the displayText as not editable and not enabled. - Also adds scrollPane view port
	 */
	private void setupDisplayText()
	{
		chatPane.setEditable(false);
		chatPane.setEnabled(false);
		chatPane.setContentType("text/html");
		Color background = Color.red;
		
		chatPane.setBorder(BorderFactory.createLineBorder(background, 2));
		
//		chatPane.setWrapStyleWord(true);
//		chatPane.setLineWrap(true);
		entryField.setToolTipText("Enter here!");
		
		scrollPane.setViewportView(chatPane);
		scrollPane.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED);
		scrollPane.setHorizontalScrollBarPolicy(JScrollPane.HORIZONTAL_SCROLLBAR_NEVER);
	}
	/**
	 * Sets up the panel with its layout, a background color, and adds any components 
	 * to the panel.
	 */
	private void setupPanel() 
	{
		this.setLayout(baseLayout);
		this.setBackground(Color.RED);
		
		this.add(entryField);
		this.add(checkBox);
		this.add(scrollPane);
		
		this.add(enterButton);
		this.add(searchTwitterButton);
		this.add(sendTweetButton);
		this.add(saveButton);
		this.add(loadButton);
		this.add(moneyButton);
		
		saveButton.setToolTipText("Put name in textfiled to name the file");
	
	}
	/**
	 * A code dump helper method for keeping all the constraint code in a contained area.
	 */
	private void setupLayout()
	{

		entryField.setHorizontalAlignment(SwingConstants.CENTER);
		entryField.setBackground(Color.ORANGE);
		baseLayout.putConstraint(SpringLayout.NORTH, scrollPane, 25, SpringLayout.NORTH, this);
		baseLayout.putConstraint(SpringLayout.SOUTH, scrollPane, 125, SpringLayout.NORTH, this);
		baseLayout.putConstraint(SpringLayout.NORTH, entryField, 36, SpringLayout.SOUTH, scrollPane);
		baseLayout.putConstraint(SpringLayout.WEST, entryField, 0, SpringLayout.WEST, scrollPane);
		baseLayout.putConstraint(SpringLayout.EAST, entryField, 0, SpringLayout.EAST, scrollPane);
		baseLayout.putConstraint(SpringLayout.WEST, scrollPane, 50, SpringLayout.WEST, this);
		baseLayout.putConstraint(SpringLayout.EAST, scrollPane, -100, SpringLayout.EAST, this);
		baseLayout.putConstraint(SpringLayout.NORTH, searchTwitterButton, -3, SpringLayout.NORTH, scrollPane);
		baseLayout.putConstraint(SpringLayout.WEST, searchTwitterButton, -95, SpringLayout.EAST, this);
		baseLayout.putConstraint(SpringLayout.EAST, searchTwitterButton, -30, SpringLayout.EAST, this);
		baseLayout.putConstraint(SpringLayout.NORTH, sendTweetButton, 5, SpringLayout.SOUTH, searchTwitterButton);
		baseLayout.putConstraint(SpringLayout.WEST, sendTweetButton, 6, SpringLayout.EAST, scrollPane);
		baseLayout.putConstraint(SpringLayout.EAST, sendTweetButton, 71, SpringLayout.EAST, scrollPane);
		baseLayout.putConstraint(SpringLayout.NORTH, enterButton, 6, SpringLayout.SOUTH, loadButton);
		baseLayout.putConstraint(SpringLayout.NORTH, loadButton, 6, SpringLayout.SOUTH, saveButton);
		baseLayout.putConstraint(SpringLayout.WEST, loadButton, 655, SpringLayout.WEST, this);
		baseLayout.putConstraint(SpringLayout.EAST, loadButton, -30, SpringLayout.EAST, this);
		baseLayout.putConstraint(SpringLayout.NORTH, saveButton, 6, SpringLayout.SOUTH, sendTweetButton);
		baseLayout.putConstraint(SpringLayout.WEST, saveButton, 6, SpringLayout.EAST, scrollPane);
		baseLayout.putConstraint(SpringLayout.EAST, saveButton, 0, SpringLayout.EAST, enterButton);
		baseLayout.putConstraint(SpringLayout.WEST, enterButton, 6, SpringLayout.EAST, entryField);
		baseLayout.putConstraint(SpringLayout.EAST, enterButton, -29, SpringLayout.EAST, this);
		baseLayout.putConstraint(SpringLayout.NORTH, checkBox, 17, SpringLayout.SOUTH, entryField);
		baseLayout.putConstraint(SpringLayout.WEST, checkBox, 0, SpringLayout.WEST, entryField);
		baseLayout.putConstraint(SpringLayout.NORTH, moneyButton, -1, SpringLayout.NORTH, checkBox);
		baseLayout.putConstraint(SpringLayout.WEST, moneyButton, 6, SpringLayout.EAST, checkBox);
		
	}
	/**
	 * adds ActionListeners to the enterButton and checkBox, to send text to the chatbot and
	 * change the background color, respectively.
	 */
	private void setupListeners()
	{
		enterButton.addActionListener(new ActionListener()
		{
			public void actionPerformed(ActionEvent selection)
			{
				
				String userInput = entryField.getText();
				String chatbotResponse = baseController.useChatbotCheckers(userInput);
				String currentText = chatPane.getText();
				
				chatPane.setText(currentText + "\nYou said: " + userInput + "\n"+ "Chatbot says: " + chatbotResponse + "\n");
				chatPane.setCaretPosition(chatPane.getCaretPosition());
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
		saveButton.addActionListener(new ActionListener()
		{
			public void actionPerformed(ActionEvent click)
			{
				int result = fileChooser.showSaveDialog(baseController.getBaseFrame());

				
				if (result == JFileChooser.APPROVE_OPTION)
				{
					String selectedFile = fileChooser.getSelectedFile().toString();
					FileController.saveFile(baseController, selectedFile, chatPane.getText());
				}
				
				//String fileName = entryField.getText();
				
				
			}
				
		});
		
		loadButton.addActionListener(new ActionListener()
		{
			public void actionPerformed(ActionEvent click)
			{
				int result = fileChooser.showOpenDialog(baseController.getBaseFrame());
				
				if (result == JFileChooser.APPROVE_OPTION)
				{
					File selectedFile = fileChooser.getSelectedFile();
					String saved = FileController.readFile(baseController, selectedFile);
					chatPane.setText(saved);
				}
				
				//String fileName = entryField.getText().trim();
//				String saved = FileController.readFile(baseController, fileName + ".txt");
//				displayText.setText(saved);
			}
		});
		
		sendTweetButton.addActionListener(new ActionListener()
		{		
			public void actionPerformed(ActionEvent click)
			{
				baseController.useTwitter(entryField.getText());
			}
		});
		
		searchTwitterButton.addActionListener(new ActionListener()
		{
			public void actionPerformed(ActionEvent click)
			{
				String results = baseController.searchTwitterUser(entryField.getText());
				chatPane.setText(results + chatPane.getText());
			}
		});
		moneyButton.addActionListener(new ActionListener()
		{
			public void actionPerformed(ActionEvent click)
			{
					baseController.searchForProgramming();
					chatPane.setText(results + chatPane.getText());
			}
				
		});
	}
	/**
	 * Generates a random RGB color and sets the panel's background to
	 * the generated color.
	 */
	private void changeBackground()
	{
		int red = (int) (Math.random() * 256);
		int green = (int) (Math.random() * 256);
		int blue = (int) (Math.random() * 256);
		
		this.setBackground(new Color(red, green, blue));
	}
}
