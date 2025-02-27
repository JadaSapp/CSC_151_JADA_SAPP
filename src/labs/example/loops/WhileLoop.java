/*
@author: Jada Sapp
@Date: 2/24/2025
@purpose: Creating loops
*/

package labs.example.loops;

public class WhileLoop{
    public void WhileLoop(){
        
    }

    private void executeWhileLoop() {
        int number = 0;
        while (number < 10) {
            number = number + 1;
        }
        System.out.println("Number of loops is " + (number-1) + " and is now completed.");
    }

    public void callWhileLoop(){
        executeWhileLoop();
    }
}