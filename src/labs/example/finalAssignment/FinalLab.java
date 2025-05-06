/*
@author: Jada Sapp
@Date: 4/28/2025
@purpose: Final Lab Assignment
*/

package labs.example.finalAssignment;

import java.net.URI;
import java.net.URISyntaxException;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.net.HttpURLConnection;
import java.net.URL;
import java.nio.charset.StandardCharsets;
import java.util.Scanner;

public class FinalLab {

    private static final String apiEndpoint = "https://generativelanguage.googleapis.com/v1beta/models/gemini-2.0-flash:generateContent";
    private final String apiKey;

    public FinalLab(String apiKey) {
        this.apiKey = apiKey;
    }
    public String callChatbotAPI(String userInput) throws IOException, URISyntaxException
    {
        try
        {
            String requestMethod = "POST";
            String fullUrlString = apiEndpoint + "?key=" + apiKey;

            URL url = new URI(fullUrlString).toURL();
            HttpURLConnection connection = (HttpURLConnection) url.openConnection();
            connection.setRequestMethod(requestMethod);
            connection.setRequestProperty("Content-Type", "application/json; utf-8");
            connection.setRequestProperty("Accept", "application/json");
            connection.setDoOutput(true);

            String jsonInputString = "{\r\n" +
                                "    \"contents\": [\r\n" +
                                "      {\r\n" +
                                "        \"parts\": [\r\n" +
                                "          {\r\n" +
                                "            \"text\": \"" + userInput + "\"" + "\r\n" +
                                "          }\r\n" +
                                "        ]\r\n" +
                                "      }\r\n" +
                                "    ]\r\n" +
                                "  }";

            try (OutputStream os = connection.getOutputStream()) {
                byte[] input = jsonInputString.getBytes(StandardCharsets.UTF_8);
                os.write(input, 0, input.length);
            }

            BufferedReader br = new BufferedReader(new InputStreamReader(connection.getInputStream(), StandardCharsets.UTF_8));
            StringBuilder response = new StringBuilder();
            String responseLine;
            
            while ((responseLine = br.readLine()) != null) {
                response.append(responseLine);
            }
            String[] finalResponse = response.toString().split("\"");
            String finishedResponse = finalResponse[9];
            return finishedResponse;
        } catch (IOException e) {
            e.printStackTrace();
        }
        return "Error: Unable to get a response from the chatbot API.";
    }

    public static void main(String[] args) {
        
        String apiKey = "AIzaSyCIy3yw1tcLMys2zbhfPtdgVUrqWmA6AT0";
        Scanner scanner = new Scanner(System.in);
        FinalLab apiClient = new FinalLab(apiKey);
        while (scanner != null) {
            System.out.println("Enter 'exit' to quit the program.");
            System.out.print("You: ");
            String userInput = scanner.nextLine();
            
            if (userInput.equalsIgnoreCase("exit")) {
                System.out.println("Exiting the program.");
                scanner.close();
                return;
            }
            try {
                String response = apiClient.callChatbotAPI(userInput);
                System.out.println("Chatbot response: " + response);
            } catch (IOException e) {
                e.printStackTrace();
            } catch (URISyntaxException e) {
                e.printStackTrace();
            }
        }
    }
}
