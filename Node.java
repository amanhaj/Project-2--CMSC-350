package project2;

/*
* Author: Amanda Hajati
* FileName: Node.java
* Course: CMSC 350 6381
* Date Completed: 2/10/2019
*/
public interface Node {
	
    public String inOrder();
    public String postOrder();
}

 class OperandNode implements Node {
   
    private int value;
    
    public OperandNode(int v) {
        this.value = v;
    }
    
    public int evaluate() {
        return value;
    }
    
    
    public String inOrder() {
        return String.valueOf(value);
    }
    
    
    public String postOrder(){
        return String.valueOf(value);
    }
}

 class OperatorNode implements Node {
    
    private Node left, right;
    private String operator;
    
    
    public OperatorNode(String op, Node l, Node r) {
        this.operator = op;
        this.left = l;
        this.right = r;
    }
  
    public String inOrder() {
        String lVal = left.inOrder();
        String rVal = right.inOrder();
        return "(" + lVal + " " + operator + " " + rVal + ")";
    }

   
    public String postOrder() {
        String lVal = left.postOrder();
        String rVal = right.postOrder();
        return lVal + " " + rVal + " " + operator;
    }
}