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
    private static final String FILE_PATH = "T:/CSC_151_JADA_SAPP/src/labs/example/fileOperations/";
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
        catch(Exception e){
            System.out.println(e);
        }
    }

    public static BufferedReader openErrorLog() throws IOException{
    BufferedReader br = new BufferedReader(new FileReader(ERROR_FILE));

    return br;
    }

    
    private static void getCountOfErrorTypes(BufferedReader file) throws IOException{
        int error_count = 0;
        int warn_count = 0;
        int info_count = 0;
        int debug_count = 0;
        String line = "";

        while((line = file.readLine()) != null){
            String[] lineValue = line.split(" ");
            switch(lineValue[2]){
                case "[ERROR]":
                    error_count = error_count + 1;
                    break;
                case "[WARN]":
                    warn_count = warn_count + 1;
                    break;
                case "[INFO]":
                    info_count = info_count + 1;
                    break;
                case "[DEBUG]":
                    debug_count = debug_count + 1;
                    break;
            }
        }
        System.out.println("Total Amount of Errors is " + error_count);
        System.out.println("Total Amount of Warns is " + warn_count);
        System.out.println("Total Amount of Infos is " + info_count);
        System.out.println("Total Amount of Debugs is " + debug_count);
    }

    private static void getMemoryLimitExceededCount(BufferedReader file) throws IOException{
        ArrayList <String> endPointList = new ArrayList<String>();
        int memoryLimitExceededCount = 0;
        String line = "";

        while((line = file.readLine()) != null){
            String[] lineValue = line.split(" ");
            if(lineValue[5].equals("Memory")){
                memoryLimitExceededCount = memoryLimitExceededCount + 1;
                endPointList.add(lineValue[13]);
            }
        }
        System.out.println("Memory Limit Exceeded Count is: " + memoryLimitExceededCount);
        for(String endPoint: endPointList){
            System.out.println(endPoint);
        }
    }
}
