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

public class FinalLab{
  private static final String apiEndpoint = "https://generativelanguage.googleapis.com/v1beta/models/gemini-pro:generateContent";
  private final String apiKey;

  public FinalLab(String apiKey){
    this.apiKey = apiKey;
  }

  public String callChatBotAPI(String userInput) throws IOException, URISyntaxException
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

      String jsonInputString = "{\n" +
                          "  \"contents\": [\n" +
                          "    {\n" +
                          "      \"parts\": [\n" +
                          "        { \"text\": \"" + inputText.replace("\"", "\\\"") + "\" }\n" +
                          "      ]\n" +
                          "    }\n" +
                          "  ]\n" +
                          "}";

    try (OutputStream os = connection.getOutputStream()){
      byte[] input = jsonInputString.getBytes(StandardCharsets.UTF_8);
      os.wite(input,0, input.length);
    }

    BufferedReader br = new BufferedReader(new InputStreamReader(connection.getInputStream(), StandardCharsets.UTF_8));
    StringBuilder response = new StringBuilder();
    String responseLine;

    while ((responseLine = br.readLine()) != null){
      response.append(responseLine);
    }
    String[] finalResponse = response.toString[].split("\"");
    String finishedResponse = finalResponse[9];
    return finishedResponse;
    } catch(IOException e) {
      e.printStackTrace();
    }
    return "Error: Unable to get response from chatbot, please try again.";
  }
  public static void main(String[] args){
    String apiKey = "AIzaSyCIy3yw1tcLMys2zbhfPtdgVUrqWmA6AT0";
    Scanner scanner = new Scanner (System.in);
    FinalLab apiClient = new FinalLab(apiKey);
    while(scanner != null){
      System.out.println("Enter 'exit to quit the program.");
      System.out.println("You: ");
      String userInput = scanner.nextLine();

      if (userInput.equalsIgnoreCase("exit")){
        System.out.println("Exiting the program. Thank you for using the ChatBot!");
        scanner.close();
        return;
      }
      try{
        String response = apiClient.callChatbotAPI(userInput);
        System.out.println("Chatbot response: " + response);
      } catch (IOException e){
        e.printStackTrace();
      } catch (IOException e){
        e.printStackTrace();
      }
    }
  }
}

/*public class FinalLab {

    private static final String API_KEY = "AIzaSyCIy3yw1tcLMys2zbhfPtdgVUrqWmA6AT0";
    private static final String ENDPOINT = "https://generativelanguage.googleapis.com/v1beta/models/gemini-pro:generateContent?key=" + API_KEY;

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Gemini ChatBot is ready. Type 'exit' to quit.");

        while (true) {
            System.out.print("You: ");
            String userInput = scanner.nextLine();

            if (userInput.equalsIgnoreCase("exit")) {
                System.out.println("Chat ended.");
                break;
            }

            try {
                String response = sendToGemini(userInput);
                System.out.println("Gemini: " + response);
            } catch (Exception e) {
                System.out.println("Error communicating with Gemini: " + e.getMessage());
            }
        }

        scanner.close();
    }

    private static String sendToGemini(String inputText) throws IOException, URISyntaxException {
        URI uri = new URI(ENDPOINT);
        HttpURLConnection connection = (HttpURLConnection) uri.toURL().openConnection();

        connection.setRequestMethod("POST");
        connection.setDoOutput(true);
        connection.setRequestProperty("Content-Type", "application/json; charset=UTF-8");

        String jsonInput = "{\n" +
                "  \"contents\": [\n" +
                "    {\n" +
                "      \"parts\": [\n" +
                "        { \"text\": \"" + inputText.replace("\"", "\\\"") + "\" }\n" +
                "      ]\n" +
                "    }\n" +
                "  ]\n" +
                "}";

        try (OutputStream os = connection.getOutputStream()) {
            byte[] input = jsonInput.getBytes(StandardCharsets.UTF_8);
            os.write(input);
        }

        int status = connection.getResponseCode();
        BufferedReader reader = new BufferedReader(new InputStreamReader(
                status >= 200 && status < 300 ? connection.getInputStream() : connection.getErrorStream(),
                StandardCharsets.UTF_8
        ));

        StringBuilder responseText = new StringBuilder();
        String line;
        while ((line = reader.readLine()) != null) {
            responseText.append(line);
        }
        reader.close();

        return extractReplyText(responseText.toString());
    }

    private static String extractReplyText(String json) {
    // Look for "text":" in the nested JSON structure
    int textIndex = json.indexOf("\"text\":\"");
    if (textIndex == -1) return "No response text found.";

    int start = textIndex + 8;
    int end = json.indexOf("\"", start);
    if (start == -1 || end == -1) return "Error parsing response.";

    return json.substring(start, end).replace("\\n", "\n").replace("\\\"", "\"");
}

}
*/

