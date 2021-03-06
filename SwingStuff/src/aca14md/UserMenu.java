package aca14md;
/*
 * This class server as the GUI
 * component of the user menu to
 * be displayed in the screen.
 * Similar to BoardGUI, this class
 * was created to keep the menu
 * more independent from the 
 * GraphicalDisplay class.
 * 
 * Lecturer: Richard Clayton
 * Written By: Matheus Gomes
 * Last Written: 13/05/2015
 */

import java.awt.Dimension;
import java.awt.Font;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import javax.swing.*;

public class UserMenu extends JPanel {
	
	// Instance variables needed to set settings
	private JComboBox<String> typeOne, typeTwo;
	private JTextField nameTwo, nameOne;
	private JPanel submitArea;
	private JButton startButton;
	private JComboBox<String> delayOption;
	private JLabel gameMessage;
	
	// Get methods needed
	public Object getPlayerOneType(){return typeOne.getSelectedItem();}
	public Object getPlayerTwoType(){return typeTwo.getSelectedItem();}
	public String getPlayerOneName(){return nameOne.getText();}
	public String getPlayerTwoName(){return nameTwo.getText();}
	public JPanel getButtonArea(){return submitArea;}
	public JButton getCurrentButton(){return (JButton) submitArea.getComponent(0);}
	public JLabel getMessageLabel(){return gameMessage;}
	public JComboBox<String> getDelayBox(){return delayOption;}
	
	public UserMenu(int width, int height){
		
		// Boiler code for settings
		Dimension size = new Dimension(width, height);
		setSize(size);
		setPreferredSize(size); // Size for packing
		setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));
		
		
		
		// Size for every part of the UI
		Dimension panelSize = new Dimension((int) (size.width*0.9), size.height/4);
		
		// Create the logo Test/Image
		JLabel logo = new JLabel("Chess Game");
		logo.setFont(new Font(logo.getFont().getName(), Font.BOLD, 32));
		logo.setAlignmentX(CENTER_ALIGNMENT);
		logo.setSize(panelSize);
		add(logo);
		
		// JPanel to hold certain areas of the menu
		JPanel playerOneOptions = new JPanel();
		JPanel playerTwoOptions = new JPanel();
		submitArea = new JPanel();
		JPanel delayArea = new JPanel();
		JPanel gameState = new JPanel();
		
		playerOneOptions.setLayout(new GridBagLayout());
		playerTwoOptions.setLayout(new GridBagLayout());
		submitArea.setLayout(new GridBagLayout());
		gameState.setLayout(new GridBagLayout());
		delayArea.setLayout(new GridBagLayout());
		
		playerOneOptions.setSize(panelSize);
		playerTwoOptions.setSize(panelSize);
		submitArea.setSize(panelSize);
		gameState.setSize(panelSize);
		delayArea.setSize(panelSize);
		
		// Create constraints object for JPanel
		GridBagConstraints constraints = new GridBagConstraints();
		
		
		// Create Components needed for player one JPanel
		JLabel titleOne = new JLabel("Player One (White):");
		typeOne = new JComboBox<String>();
			typeOne.addItem("Human");
			typeOne.addItem("Random");
			typeOne.addItem("Aggressive");
		nameOne = new JTextField("PlayerOne");
		
		// Add these components with constraints
		constraints.gridx = 0;
		constraints.gridy = 0;
		constraints.weightx = 1;
		constraints.fill = GridBagConstraints.HORIZONTAL;
		constraints.insets = new Insets(10,10,10,10);
		playerOneOptions.add(titleOne, constraints);
		
		constraints.gridx = 0;
		constraints.gridy = 1;
		constraints.weightx = 0.6;
		constraints.fill = GridBagConstraints.HORIZONTAL;
		playerOneOptions.add(typeOne, constraints);
		
		constraints.gridx = 1;
		constraints.gridy = 1;
		constraints.weightx = 0.4;
		constraints.fill = GridBagConstraints.HORIZONTAL;
		playerOneOptions.add(nameOne, constraints);
		
		
		
		// Create Components needed for player one JPanel
		JLabel titleTwo = new JLabel("Player Two (black):");
		typeTwo = new JComboBox<String>();
			typeTwo.addItem("Random");
			typeTwo.addItem("Human");
			typeTwo.addItem("Aggressive");
		nameTwo = new JTextField("PlayerTwo");
		
		// Add these components with constraints
		constraints.gridx = 0;
		constraints.gridy = 2;
		constraints.insets = new Insets(10,10,10,10);
		playerOneOptions.add(titleTwo, constraints);
		
		constraints.gridx = 0;
		constraints.gridy = 3;
		constraints.weightx = 0.6;
		constraints.fill = GridBagConstraints.HORIZONTAL;
		playerOneOptions.add(typeTwo, constraints);
		
		constraints.gridx = 1;
		constraints.gridy = 3;
		constraints.weightx = 0.4;
		constraints.fill = GridBagConstraints.HORIZONTAL;
		playerOneOptions.add(nameTwo, constraints);
		
		
		// Adding the delay area
		JLabel textThree = new JLabel("Turn delay (AI mainly)");
		delayOption = new JComboBox<>();
			delayOption.addItem("None");
			delayOption.addItem("0.5 second");
			delayOption.addItem("1 second");
			
		constraints.weightx = 1;
		constraints.gridx = 0;
		constraints.gridy = 4;
		constraints.fill = GridBagConstraints.BOTH;
		delayArea.add(textThree, constraints);
		
		constraints.gridy = 5;
		delayArea.add(delayOption, constraints);
			
		// Adding the message area (game state area)
		gameMessage = new JLabel("Enter options and start the game!");
		constraints.weightx = 1;
		constraints.gridx = 0;
		constraints.gridy = 6;
		constraints.fill = GridBagConstraints.HORIZONTAL;
		gameState.add(gameMessage, constraints);
		
		// Finally add Start button
		startButton = new JButton("Start Game!");
		constraints.weightx = 1;
		constraints.fill = GridBagConstraints.BOTH;
		submitArea.add(startButton, constraints);
		
		
		// Adding players options
		add(playerOneOptions);
		add(playerTwoOptions);
		add(delayArea);
		add(gameState);
		add(submitArea);
	}
}
