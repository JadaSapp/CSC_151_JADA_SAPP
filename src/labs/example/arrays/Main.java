/*
@author: Jada Sapp
@Date: 3/3/2025
@purpose: Creating a main file for ArrayOperations
*/

package labs.example.arrays;

// Week 10 Lab Below

public class Main {
  public static void main(String[] args){
    ArrayProgram arrayProgram = new ArrayProgram();
    System.out.println("Scenario 1:");
    arrayProgram.arraysLengthAndValue();

    System.out.println("------");

    System.out.println("Scenario 2: ");
    arrayProgram.threeArrays();

    System.out.println("------");
    
    System.out.println("Scenario 3: ");
    arrayProgram.highestValueOfArrays();

    System.out.println("------");
    
    System.out.println("Scenario 4: ");
    arrayProgram.creditCardChecker();
  }
}






  /*
      Week 8 Lab
    ArrayOperations arrayOperations = new ArrayOperations();

    arrayOperations.createNewArray(5);
    arrayOperations.sortArray();
    arrayOperations.getDaysAndMonths();
    }
  */
