import java.io.FileWriter;
import java.io.IOException;
import java.time.LocalDateTime;

public class Logger {
    // Name of the file where all log messages will be written
    private static final String LOGFILE = "log.txt"; // LOGFILE = "log.txt"

    public static void log(String message) {
        // Use FileWriter to open log.txt.
        // true = append mode
        // false = overwrite mode (rewrite the whole file every time)
        try (FileWriter fw = new FileWriter(LOGFILE, true)) {
            // write current time and the log message to log.txt
            fw.write("[" + LocalDateTime.now() + "]" + message + "\n");

            // Error detection, such as missing files, no enough memory...
        } catch (IOException e) {
            System.out.println("Error writing log message");
        }
    }
}
