/*
@author: Jada Sapp
@Date: 2/24/2025
@purpose: Main class for WhileLoop.java
*/

package labs.example.loops;

public class Main {
  public static void main(String[] args){
    WhileLoop whileLoop = new WhileLoop();
    ForLoop forLoop = new ForLoop();

    whileLoop.callWhileLoop();
    forLoop.callingForLoop();
    
    int a = 9;
    int b = 15;
    int sum = forLoop.twoNumbers(a,b);
    System.out.println("Decremented sum is " + --sum);
    
    int sum2 = forLoop.callSumLoopCounter(25);
    System.out.println("The sum for loop counter is: " + sum2);
    forLoop.callPrintMultiplicationTable(10);

    }
}