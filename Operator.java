package project2;

/*
* Author: Amanda Hajati
* FileName: Operator.java
* Course: CMSC 350 6381
* Date Completed: 2/10/2019
*/
public abstract class Operator {}

class OperatorMethods extends Operator {
 
	/*
	 * returns the correct operator
	 */
    public String toString(char c) {
    	
    	switch (c) {
    	
    	case '+':
    	return "+";
        
    	case '-':
    	return "-";
    	
    	case '*':
    	return "*";
    	
    	}
    	return "/";
    }
   
	/*
	 * the following methods return the correct string for the three address instructions.
	 */
    public String instructionAdd() {
        return "Add";
    }
    
    public String instructionSub() {
		return "Sub";
    }
    
    public String instructionMul() {
		return "Mul";
    }
    
    public String instructionDiv() {
		return "Div";
    }
}
