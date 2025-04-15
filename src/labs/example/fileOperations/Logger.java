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

        BufferedReader file3 = openErrorLog();
        getDiskSpaceErrorsWithIPAddress(file3);
        file3.close();
        
        BufferedReader httpAccessOffSet = openErrorLog("http_access.log");
        getGMTOffset(httpAccessOffSet);
        httpAccessOffSet.close();
        
        BufferedReader httpAccessCode = openErrorLog("http_access.log");
        getHTTPCode(httpAccessCode);
        httpAccessCode.close();
        
        BufferedReader httpAccessSizes = openErrorLog("http_access.log");
        getResponseSizes(httpAccessSizes);
        httpAccessSizes.close();

        BufferedReader httpAccessMethods = openErrorLog("http_access.log");
        groupHTTPMethodsAndEndPoints(httpAccessMethods);
        httpAccessMethods.close();
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

    private static void getDiskSpaceErrorsWithIPAddress(BufferedReader file) throws IOException{
        String line = "";
        int lineNumber = 0;

        while((line = file.readLine()) != null){
            String[] lineValue = line.split(" ");
            if(lineValue[5].equals("Disk")){
                System.out.println("The Disk Space error on line " + lineNumber + " for the IP Address: " + lineValue[3]);
            }
            lineNumber = lineNumber + 1;
        }
    }

    private static BufferedReader openErrorLog(String fileName) throws IOException{
        BufferedReader br = new BufferedReader(new FileReader(FILE_PATH + "logs/" + fileName));
        return br;
    }

    private static void getGMTOffset(BufferedReader file)throws IOException{
        ArrayList <Integer> offsetCountingList = new ArrayList<>();
        ArrayList <String> offSetList = new ArrayList<String>();
        String offSet = "";
        String line = "";
        int index = 0;

        while((line = file.readLine()) != null){
            String[] lineValue = line.split(" ");
            offSet = lineValue[4].replace("]", "");
            if(offSetList.contains(offSet) == false){
                offSetList.add(offSet);
                offsetCountingList.add(1);
            }
            else{
                index = offSetList.indexOf(offSet);
                offsetCountingList.set(index,(offsetCountingList.get(index) + 1));
            }
        }
        for (int x = 0; x < offSetList.size(); x++){
            System.out.println("The Time is: " + offSetList.get(x) + " while Count is: " + offsetCountingList.get(x));
        }
    }

    private static void getHTTPCode(BufferedReader file)throws IOException{
        String line = "";
        int fiveHundredCounting = 0;
        int fourHundredCounting = 0;
        int threeHundredCounting = 0;
        int twoHundredCounting = 0;
        
        while((line = file.readLine()) != null){
            String[] lineValue = line.split(" ");
            char[] response = lineValue[8].toCharArray();

            switch(response[0]){
                case '5':
                    fiveHundredCounting = fiveHundredCounting + 1;
                    break;
                case '4':
                    fourHundredCounting = fourHundredCounting + 1;
                    break;
                case '3':
                    threeHundredCounting = threeHundredCounting + 1;
                    break;
                case '2':
                    twoHundredCounting = twoHundredCounting + 1;
                    break;
            }
        }
        System.out.println("5xx Errors: " + fiveHundredCounting);
        System.out.println("4xx Errros: " + fourHundredCounting);
        System.out.println("3xx Errors: " + threeHundredCounting);
        System.out.println("2xx Errors: " + twoHundredCounting);
    }

    private static void getResponseSizes(BufferedReader file)throws IOException{
        String line = "";
        int greaterCounting = 0;
        
        while((line = file.readLine()) != null){
            String[] lineValue = line.split(" ");
            if(Integer.parseInt(lineValue[9]) > 3900){
                greaterCounting = greaterCounting + 1;
            }
        }
        System.out.print("The amount of log lines have a response size > 3900 is : " + greaterCounting);
    }

    private static void groupHTTPMethodsAndEndPoints(BufferedReader file)throws IOException{
        String line = "";
        ArrayList <String> verbs = new ArrayList <String>();
        String verb = "";

        while((line = file.readLine()) != null){
            String [] lineValue = line.split(" ");
            verb = lineValue[5].replace("\"", "");
            if(verbs.contains(verb) == false){
                verbs.add(verb);
            }
        } 
        System.out.println("The Verbs Are: ");
        for(int x = 0; x < verbs.size(); x++){
            System.out.println("-" + verbs.get(x));
        }
    }
}

