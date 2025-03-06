/*
@author: Jada Sapp
@Date: 3/3/2025
@purpose: Creating ArrayOperations to do Lab 8 (Java)
*/

package labs.example.arrays;

public class ArrayOperations{
    public void ArrayOperations(){

    }
    public void createNewArray(int defaultValues){
        int[] array = new int[defaultValues];
        for (int x=0; x < array.length; x++){
            array[x] = defaultValues;
        }

        for (int x=0; x < array.length;x++){
            array[x] = array[x] + x;
        }

        displayArray(defaultValues, array);
    }

    private void displayArray(int YOUR_ARRAY_LENGTH_HERE, int[] array){
        System.out.println("I created a new array and it now has " + YOUR_ARRAY_LENGTH_HERE + " items in it.");
        System.out.println("The array items and their values are listed below: ");

        for (int x=0; x < array.length; x++){
            System.out.println(array[x]);
        }
    }

    public static void sortArray(){
        int[] values = {88, 35, 43, 94, 38, 64, 58, 16, 25, 77, 4, 19, 50, 89, 51, 65, 31, 98, 7, 97, 87, 95, 56, 24, 70, 69, 42, 22, 14, 53, 81, 40, 44, 78, 83, 11, 41, 34, 82, 21, 32, 27, 17, 90, 49, 5, 84, 48, 37, 68};
        for (int x=0;x < values.length-1;x++){
            if (values[x] > values[x+1]){
                int randomNumbers = values[x+1];
                values[x+1] = values[x];
                values[x] = randomNumbers;

                x = -1;
            }
        }
    
        System.out.println("The sorted list would be: ");
        for(int y = 0; y < values.length;y++){
            System.out.println(values[y]);
        }
    }

    public void getDaysAndMonths(){
        System.out.println("");
        int[] days = {31,28,31,30,31,30,31,31,30,31,30,31};
        String[] months = {"January", "February", "March", "April", "May", "June", "July", "August", "September", "October", "November", "December"};
        for (int x=0;x < days.length;x++){
            System.out.println("The amount of days in " + months[x] + " is " + days[x]);
        }
    }
}