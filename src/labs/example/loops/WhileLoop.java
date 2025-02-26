/*
@author: Jada Sapp
@Date: 2/24/2025
@purpose: Creating loops
*/

package labs.example.loops;

public class WhileLoop {

    private static void executeWhileLoop() {
        int number = 1;
        while (number <= 10) {
            System.out.println("Iteration: " + number);
            number++;
        }
    System.out.println("Number of loops is " + (number-1) + " and is now completed.");
    }
}