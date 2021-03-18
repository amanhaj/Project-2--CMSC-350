package project2;

import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.EmptyStackException;
import java.util.NoSuchElementException;

import javax.swing.JOptionPane;

/*
* Author: Amanda Hajati
* FileName: P2_Main.java
* Course: CMSC 350 6381
* Date Completed: 2/10/2019
*/

/*
 * second class to handle the actions of the button
 */
public class P2_Main implements ActionListener  {
	
	public void actionPerformed(ActionEvent event) {
		
	    if (event.getSource() == P2_GUI.getButton()) {
	    	
	    	try {
	    		
	            ExpressionTree tree = new ExpressionTree();
	            tree.convertToInfix(P2_GUI.getInput());
	            System.out.println(tree.getInvalidToken());	
	            
	            /*
	             * the result will only be set if no invalid tokens have been entered
	             */
	            if (tree.invalid() == false) {
	            	
	            P2_GUI.setResult("" + tree.infix());
	            
	            }  else {
	            	
	            	throw new Exception();
	            }
	            
		    } catch (EmptyStackException e) {
		    
		    	JOptionPane.showMessageDialog(null,"Enter Postfix Expression Only");
		    	
		    } catch (NoSuchElementException f) {
		    	
		    	ExpressionTree tree = new ExpressionTree();
		    	JOptionPane.showMessageDialog(null, "Invalid token found in expression : " + tree.getInvalidToken());
            	P2_GUI.setResult("");
            	P2_GUI.setInput("");
            	
		    } 	catch (Exception g) {
		    	
		    	ExpressionTree tree = new ExpressionTree();
		    	JOptionPane.showMessageDialog(null, "Invalid token found in expression : " + tree.getInvalidToken());
            	P2_GUI.setResult("");
            	P2_GUI.setInput("");
		    }
	/*
	 * clear data if user clicks the textbar again after evaluating expression
	 */
	P2_GUI.getInputField().addMouseListener(new MouseAdapter() {
		@Override
		public void mouseClicked(MouseEvent e) {
			P2_GUI.setInput("");
			P2_GUI.setResult("");
			
		    }
	});}
	}

/*
 * main
 */
public static void main(String[] args) {
	EventQueue.invokeLater(new Runnable() {
		@SuppressWarnings("static-access")
		public void run() {
		
			try {
				
				try {
					P2_GUI frame = new P2_GUI();
					frame.setVisible(true);
					
				} catch (Throwable t ) {
					t.printStackTrace();
				}
			} catch (Exception  e) {
				e.printStackTrace();
		  }}	
		 
	});
}}

	

