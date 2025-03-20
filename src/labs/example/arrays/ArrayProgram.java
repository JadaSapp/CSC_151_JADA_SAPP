/*
@author: Jada Sapp
@Date: 3/17/2025
@purpose: Working on Lab 10 for JAVA Programming
*/

package labs.example.arrays;

public class ArrayProgram{
    public void ArrayProgram(){
    }

    public void arraysLengthAndValue(){
        boolean value = false;
        int[] firstArray = {24, 17, 30, 15, 26, 16};
        int[] secondArray = {24, 17, 30, 15, 27, 17};

        if (firstArray.length == secondArray.length){
            value = true;
            for (int x = 0; x < firstArray.length; x++){
                if (firstArray[x] != secondArray[x]){
                    value = false;
                }
            }
            if(value){
                System.out.println("These arrays do have the same values.");
            } 
            else{
                System.out.println("These arrays do NOT have the same values.");
            }

            System.out.println("These arrays are the same length.");
        }
        else{
            System.out.println("These arrays do NOT have the same length OR value");
        }
    }

    public void threeArrays(){
        int[] arr1 = {29, 9, 32, 1, 17, 23, 54, 67, 64, 77, 41, 53, 97, 47, 91, 3, 75, 90, 28, 58, 10, 52, 43, 100, 14};
        int[] arr2 = {30, 88, 36, 57, 35, 44, 32, 24, 9, 15, 59, 16, 2, 74, 79, 47, 76, 40, 26, 75, 28, 80, 14, 92, 52};
        int[] arr3 = {25, 59, 7, 72, 84, 63, 39, 51, 32, 34, 16, 92, 30, 9, 79, 11, 46, 43, 57, 42, 15, 40, 6, 78, 19};

        int sum1 = 0;
        int sum2 = 0;
        int sum3 = 0;

        for (int x = 0; x < arr1.length; x++){
            sum1 = arr1[x] + sum1;
            sum2 = arr2[x] + sum2;
            sum3 = arr3[x] + sum3;
        } 

        System.out.println("Array 1 sum is: " + sum1 + " Array 2 sum is: " + sum2 + " Array 3 sum is: " + sum3);

        if(sum1 > sum2 && sum1 > sum3){
            System.out.println("Array 1 is the highest value with: " + sum1);
        }
        if(sum2 > sum1 && sum2 > sum3){
            System.out.println("Array 2 is the highest value with: " + sum2);
        }
        if(sum3 > sum1 && sum3 > sum2){
            System.out.println("Array 3 is the highest value with: " + sum3);
        }
    }

    public void highestValueOfArrays(){
        int[] myArray = {40, 13, 68, 95, 99, 48, 98, 6, 75, 62, 11, 81, 9, 51, 15, 66, 31, 14, 92, 52, 77, 72, 37, 8, 86, 73, 38, 83, 50, 91, 84, 74, 26, 4, 18, 41, 42, 36, 90, 61, 17, 5, 30, 19, 89, 69, 21, 79, 49, 44};
        int hightesValueOfArrays = myArray[0];
        for(int x = 0; x < myArray.length; x++){
            if(myArray[x] > hightesValueOfArrays){
                hightesValueOfArrays = myArray[x];
            }
        }
        System.out.println("Highest Value in myArray: " + hightesValueOfArrays);

    }

    public void creditCardChecker(){
        int [] cardNumber = {4, 7, 6, 0, 4, 9, 9, 9, 6, 6, 8, 4, 9, 7, 5, 0};
        int [] workingCardNumber = {4, 7, 6, 0, 4, 9, 9, 9, 6, 6, 8, 4, 9, 7, 5, 0};
        int summedNumber = 0;
        for (int x = cardNumber.length -2; x + 1 > 0; x = x-2){
            workingCardNumber[x] = cardNumber[x] * 2;
            if(workingCardNumber[x] > 9){
                workingCardNumber[x] = (workingCardNumber[x] % 10) + 1;
            }
        }

        for(int x = 0; x < workingCardNumber.length; x++){
            summedNumber = workingCardNumber[x] + summedNumber;
        }

        System.out.println("Credit Card ");
        for(int x = 0; x < cardNumber.length; x++){
            System.out.print(cardNumber[x]);
        }

        if((summedNumber % 10) == 0){
            System.out.print(" is valid. \n");
        }
        else{
            System.out.print(" is NOT valid. \n");
        }
    }
}