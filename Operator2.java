/**
 * Abstract class for all operators
 * Operators can evaluate and have a 3-address equivalent
 * @author Barrett Otte
 * @version 1.0
 * @since 2017-08-02
 */
package project2;

import javax.swing.JOptionPane;

public abstract class Operator2 
{
    abstract public int evaluate(int x, int y);
    abstract public String toInstruction();
}

class AddOperator extends Operator2
{
    
    
   
    public int evaluate(int x, int y)
    {
        return x + y;
    }
    
    
    public String toString()
    {
        return "+";
    }
    
 
    public String toInstruction()
    {
        return "Add";
    }
}

 class SubOperator extends Operator2
{
    
    public int evaluate(int x, int y)
    {
        return Math.abs(x - y);
    }
    
    
    public String toString()
    {
        return "-";
    }
    
    public String toInstruction()
    {
        return "Sub";
    }
}
 
 class MulOperator extends Operator2
 {
     
     
     public int evaluate(int x, int y)
     {
         return x * y;
     }
     
    
     public String toString()
     {
         return "*";
     }
     
    
     public String toInstruction()
     {
         return "Mul";
     }
     
 }
 
 class DivOperator extends Operator2
 {
     
    
     public int evaluate(int x, int y)
     {
         if(y == 0)
         {
             JOptionPane.showMessageDialog(null, "Cannot Divide by Zero.", "DivideByZero", JOptionPane.ERROR_MESSAGE);
             throw new ArithmeticException("Cannot Divide by Zero");
         }
         return x / y;
     }
     
     
    
     public String toString()
     {
         return "/";
     }
     
    
     public String toInstruction()
     {
         return "Div";
     }
 }


