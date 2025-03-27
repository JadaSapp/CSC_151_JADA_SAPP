/*
@author: Jada Sapp
@Date: 3/24/2025
@purpose: Lab 11 Assignment
*/

package labs.example.fileOperations;

import java.io.*;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.*;

public class FileOperations{
    private static final String FILE_PATH = "T:/CSC_151_JADA_SAPP/src/labs/example/fileOperations/FileOperator.java";
    private static final String FILE_NAME = "src/labs/example/fileoperations/users.csv";
    private static final String ERROR_LOG_FILE = FILE_PATH + "csv_error.log";

    public static void openFile(){
        openCSVFile();
    }

    private static void openCSVFile(){
        File csv_file = new File(FILE_NAME);
        File log_file = new File(ERROR_LOG_FILE);

        try{
            BufferedWriter csv_file_writer = new BufferedWriter (new FileWriter(ERROR_LOG_FILE,true));
            String line = "";
            int count = 0;
            int grade = 0;
            int average = 0;
            System.out.println(line);
            if(csv_file.exists() && log_file.exists()){
                BufferedReader br = new BufferedReader (new FileReader(FILE_NAME));
                while((line = br.readLine()) != null){
                    if(count > 0){
                        String[] value = line.split(",");
                        int number = value.length - 1;
                        grade = Integer.parseInt(value[1]) + Integer.parseInt(value[2]) + Integer.parseInt(value[3]);
                        average = grade / number;
                        System.out.println(value[0] + "'s average grade " + average);
                    }
                    count++;
                    grade = 0;
                    average = 0;
                }
                csv_file_writer.close();
            }
        }
        catch(IOException e){
            System.out.println(e);
        }
    }
}