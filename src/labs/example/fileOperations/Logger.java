/*
@author: Jada Sapp
@Date: 3/31/2025
@purpose: Lab 12 Assignment
*/

package labs.example.fileOperations;

import java.io.*;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.*;

public class Logger{
    private static final String FILE_PATH = "T:/CSC_151_JADA_SAPP/src/labs/example/fileOperations/FileOperator.java";
    private static final String ERROR_FILE = FILE_PATH + "logs/api_error.log";

    public static void main(String[] args) throws IOException{
        BufferedReader file = openErrorLog();
        getCountOfErrorTypes(file);
        file.close();

        BufferedReader file2 = openErrorLog();
        getMemoryLimitExceededCount(file2);
        file2.close();
    }

    private static void readAPI(){
        File log_file = new File(ERROR_FILE);
        try{
            String line = "";
            if(log_file.exists()){
                BufferedReader br = new BufferedReader(new FileReader(ERROR_FILE));
                while ((line = br.readLine()) != null){
                    System.out.println(line);
                }
                br.close();
            }
        }
        catch(IOException e){
            System.out.println(e);
        }
    }

    private static BufferedReader openErrorLog() throws IOException{
        BufferedReader br = new BufferedReader(new FileReader(ERROR_FILE));

        return br;
    }

    private static void getCountOfErrorTypes(BufferedReader file) throws IOException{
        int errors = 0;
        int warns = 0;
        int infos = 0;
        int debugs = 0;
        String line = "";

        while((line = file.readLine()) != null){
            String[] lineValue = line.split(" ");
            switch(lineValue[2]){
                case "[ERROR]":
                    errors = errors + 1;
                    break;
                case "[WARN]":
                    warns = warns + 1;
                    break;
                case "[INFO]":
                    infos = infos + 1;
                    break;
                case "[DEBUG]":
                    debugs = debugs + 1;
                    break;
            }
        }
        System.out.println("Total Amount of Errors is " + errors);
        System.out.println("Total Amount of Warns is " + warns);
        System.out.println("Total Amount of Infos is " + infos);
        System.out.println("Total Amount of Debugs is " + debugs);
    }

    private static void getMemoryLimitExceededCount(BufferedReader file) throws IOException{
        ArrayList <String> endPointList = new ArrayList<String>();
        int getMemoryLimitExceededCount = 0;
        String ling = "";

        while((line = file.readLine()) != null){
            String[] lineValue = line.split(" ");
            System.out.println(lineValue[5]);

            if(lineValue[5].equals("Memory")){
                memoryLimitExceededCount = memoryLimitExceededCount + 1;
                System.out.println(lineValue[13]);
                endPointList.add(lineValue[13]);
            }
        }
        System.out.println("Memory Limit Exceeded Count: " + memoryLimitExceededCount);
        for(String endPoint: endPointList){
            System.out.println(endPoint);
        }
    }
}