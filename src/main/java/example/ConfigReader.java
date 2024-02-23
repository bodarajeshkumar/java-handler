import org.json.JSONObject;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class ConfigReader {

    public static void main(String[] args) {
        // File paths
        String configFile = "/projects/allScripts/config.json";
        String logFile = "/projects/allScripts/test.log";

        try {
            // Read the JSON file
            BufferedReader reader = new BufferedReader(new FileReader(configFile));
            StringBuilder jsonData = new StringBuilder();
            String line;
            while ((line = reader.readLine()) != null) {
                jsonData.append(line);
            }
            reader.close();

            // Parse JSON data
            JSONObject jsonObject = new JSONObject(jsonData.toString());

            // Extract message from JSON
            String message = jsonObject.getString("message");

            // Get current timestamp
            LocalDateTime now = LocalDateTime.now();
            DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
            String timestamp = now.format(formatter);

            // Append message and timestamp to log file
            FileWriter writer = new FileWriter(logFile, true);
            writer.write("[" + timestamp + "] " + message + " --from java\n");
            writer.close();

            System.out.println("Message appended to " + logFile);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
