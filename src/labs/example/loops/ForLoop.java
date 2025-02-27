/*
@author: Jada Sapp
@Date: 2/26/2025
@purpose: Loop creating
*/

package labs.example.loops;

import java.lang.Math;

public class ForLoop {
    public void ForLoop(){
    }

    private void executeForLoop() {
        for (int number = 0;number < 20; number++)
        {
            System.out.println("Loop interations: " + number);
        }
    }
    
    private int sumTwoNumbers(int a, int b) {
        int sum = a + b;
        return sum;
    }

    private int sumLoopCounter(int count){
        int sum2 = 0;
        for(int l = 1; l<count; l++){
            sum2 = l + count;
        }
        return sum2;
    }

    private void printMultiplicationTable(int value){
        int result = 0;
        for (int x = 0; x < 13; x++){
            result = x * value;
            System.out.println("The multiplication table is " + value + " times " + x + " equals " + result);
        }
    }

    public int callSumLoopCounter(int count){
        return sumLoopCounter(count);
    }

    public void callPrintMultiplicationTable(int value){
        printMultiplicationTable(value);
    }

    public void callingForLoop(){
        executeForLoop();
    }

    public int twoNumbers(int a, int b){
        int result;
        result = sumTwoNumbers(a, b);
        return result;
    }
}