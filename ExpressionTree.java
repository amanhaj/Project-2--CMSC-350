package project2;

import java.io.FileWriter;
import java.io.IOException;
import java.util.Stack;
import javax.swing.JOptionPane;

/*
* Author: Amanda Hajati
* FileName: ExpressionTree.java
* Course: CMSC 350 6381
* Date Completed: 2/10/2019
*/
public class ExpressionTree {
    private Node root;
    private Stack<Node> nodeStack;
    private String threeAddressInstruction;
    private static char operator;
    private static char invalidToken;
    private boolean isSet = false;
    
    /*
     * Initialize node stack
     */
    public ExpressionTree() {
    	
        nodeStack = new Stack<Node>();
        threeAddressInstruction = "";
    }
    
    public void convertToInfix(String input) {
    	
        if(input.isEmpty()) {
        	
            JOptionPane.showMessageDialog(null, "Input is empty");
            
        }
        
        int operatorCount = 0;

        for(int i = 0; i < input.length(); i++) {
        	
        	/*
        	 * convert input string to char tokens
        	 */
            char c = input.charAt(i);
            
            /*
             * if the token is an operator, set operator and push into stack
             */
            if(isOperator(c)) {
            	
            	setOperator(c);
            	OperatorMethods opM = new OperatorMethods();
                String op =   opM.toString(c);
                Node right = nodeStack.pop();
                Node left = nodeStack.pop();
                nodeStack.push(new OperatorNode(op, left, right));
                createInstruction(op, left, right, operatorCount);
                operatorCount++;
            /*
             * if token is not whitespace and then if its a number, push into stack    
             */
            } else if(!Character.isWhitespace(c)) {
            	
                if(Character.isDigit(c)) {
                    
                    nodeStack.push(new OperandNode(Integer.parseInt(Character.toString(c))));
                
            } else {
            	
            	setInvalidToken(c);
            }
        }
    }     
        root = nodeStack.lastElement();
        
        fileWriter(threeAddressInstruction,  "ThreeAddressInstructions.txt");
    }
   
    /*
     * check if character is an operator
     */
    public static boolean isOperator(char c) {
    	
        return c == '+' || c == '-' || c == '*' || c == '/';
    }
     
    /*
     * make the operator token avaliable to the operator class
     */
    public static void setOperator(char o) {
    	
     operator = o;
    	
    }
    
    public static String getOperator() {
    	
    	return String.valueOf(operator);
    }
    
    /*
     * get any invalid tokens
     */
    public void setInvalidToken(char o) {
    	
    	invalidToken = o;
    	isSet = true;
    }
    
    public String getInvalidToken() {
    	
    	return String.valueOf(invalidToken);
    }
    
    /*
     * boolean returns true if an invalid token has been entered
     */
    public boolean invalid()  {
    	
    	return isSet;
    }
   
    /*
     * method called in P2_Main action handler that to set the result
     */
     public String infix() {
    	
        if(root == null) {
        	
        	JOptionPane.showMessageDialog(null,"Infix Expression NULL");
        	
            return "";
        } 
        
        return root.inOrder();
    } 
    
     /*
      * method to construct the string that will go to file
      */
    private void createInstruction(String op, Node left, Node right, int opCount) {
    	
        OperatorMethods operator = new OperatorMethods();
    	String c = String.valueOf(getOperator());
    	
    	/*
    	 * Check the value of c to return the correct value to the address instruction
    	 */
    	
    	if (c.equals("+")) {
    		
    		threeAddressInstruction +=   System.lineSeparator() + operator.instructionAdd() + " R" + opCount  + " ";
    	
    	} else if (c.equals ("-")) {
    		
    		threeAddressInstruction +=  System.lineSeparator() + operator.instructionSub() + " R" + opCount  + " ";
    		
    	} else if (c.equals("*")) {
    		
    		threeAddressInstruction += System.lineSeparator() + operator.instructionMul() + " R" + opCount  + " ";
    		
    	} else if (c.equals("/")) {
    		
    		threeAddressInstruction += System.lineSeparator() + operator.instructionDiv() + " R" + opCount  + " ";
    	}
    	
    	/*
    	 * if the token is an operand
    	 */
        if(left instanceof OperandNode) {
        	
        	threeAddressInstruction += left.inOrder() + " ";
        	
            if(right instanceof OperandNode) {
            	
            	threeAddressInstruction += right.inOrder() + " \n";
            	
            } else {
            	
            	threeAddressInstruction += "R" + (opCount-1) + " \n";
            }
        /*
         * if the token is and operator
         */
        } else if(left instanceof OperatorNode) {
        	
            opCount += (opCount <= 2) ? 1 : 0;
            threeAddressInstruction += "R" + (opCount-2) + " ";
            
            if(right instanceof OperatorNode) {
            	
            	threeAddressInstruction += "R" + (opCount-1) + " \n";
            	
            } else {
            	
            	threeAddressInstruction += right.inOrder() + " \n";
            }
        }
        
    }
    
    /*
     * method to write to the file
     */
    private void fileWriter(String input, String fileName)
    {
        try (FileWriter w = new FileWriter(fileName, true)) {
        	
        	
        	if (isSet == false) {
        		
            w.write(input);
            w.write(System.getProperty( "line.separator" ));
            JOptionPane.showMessageDialog(null,"Three Address Instructions Written to " + fileName + ".");
            
        	}
        }
        
        catch(IOException e){
        	
        }
    }
    
}