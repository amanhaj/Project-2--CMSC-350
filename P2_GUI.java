package project2;

import javax.swing.*;
import java.awt.*;

/*
* Author: Amanda Hajati
* FileName: P2_GUI.java
* Course: CMSC 350 6381
* Date Completed: 2/10/2019
*/

public class P2_GUI extends JFrame {
	private static final long serialVersionUID = 1L;
	
	/*
	 * create the variables for the GUI
	 */
	 private JPanel panel;
	 private JLabel inputLabel;
	 private static JTextField input;
	 private static JButton button;
	 private JLabel resultLabel;
	 private static JTextField resultText;
	//create string to store the user input
	 private static String s;
	
/*
 * create getters and setters to make variables accessible to other classes
 */
public static JButton getButton() {
	return button;
	
}

public static JTextField getResultText() {
	return resultText;
}

public static String getInput() {
	s = String.valueOf(input.getText());
	return s;
}

public static JTextField getInputField() {
	return input;
}

public static void setResult(String result) {
	resultText.setText(result);
}

public static void setInput(String inputS) {
	input.setText(inputS);
}
	 
/*
 * design the GUI
 */
public P2_GUI() {
	
	setFont(new Font("Arial", Font.PLAIN, 16));
	setTitle("Three Address Generator");
	setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	setBounds(500, 200, 500, 175);
	
	/*
	 * initialize components of GUI panel
	 */
    panel = new JPanel();
    panel.setLayout(null);
	setContentPane(panel);
	inputLabel = new JLabel("Enter Postfix Expression");
	input = new JTextField("");
    button = new JButton("Construct Tree");
    resultLabel = new JLabel("Infix Expression");
    resultText = new JTextField();
    
    /*
     * set result as uneditable
     */
    resultText.setText("");
    resultText.setEditable(false);
    
    /*
     * add components to panel
     */
    panel.add(inputLabel);
    panel.add(input);
    panel.add(button);
    panel.add(resultLabel);
    panel.add(resultText);
    
    /*
     * set fonts
     */
    inputLabel.setFont(new Font("Arial", Font.BOLD, 12));
    input.setFont(new Font("Arial", Font.PLAIN, 12));
    button.setFont(new Font("Arial", Font.BOLD, 12));
    resultLabel.setFont(new Font("Arial", Font.BOLD, 12));
    resultText.setFont(new Font("Arial", Font.PLAIN, 12));
    
    /*
     * set layout for each component
     */
    inputLabel.setBounds(10, 8, 200, 25);
    input.setBounds(160, 8, 320, 25);
    button.setBounds(175, 57, 150, 30);
    resultLabel.setBounds(30, 100, 100, 25);
    resultText.setBounds(130, 100, 320, 25);
    
    /*
     * set columns for textfields
     */
    input.setColumns(20);
    resultText.setColumns(20);
    
    /*
     * add action listeners for evaluate button
     */
    P2_Main handler = new P2_Main();
    button.addActionListener(handler);
	
}

}


