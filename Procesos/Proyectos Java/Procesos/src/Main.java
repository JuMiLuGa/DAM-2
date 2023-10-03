import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

// Press Shift twice to open the Search Everywhere dialog and type `show whitespaces`,
// then press Enter. You can now see whitespace characters in your code.
public class Main {
    public static void main(String[] args) throws IOException, InterruptedException {


        List<String> commands = new ArrayList<>();
        commands.add("notepad.exe");
        ProcessBuilder pb = new ProcessBuilder(commands);
        Process process = pb.start();
        process.waitFor();

        List<String> commands2 = new ArrayList<String>();
        commands2.add("C:\\Program Files\\Google\\Chrome\\Application\\chrome.exe");
        commands2.add("www.twitter.com");
        ProcessBuilder pb2 = new ProcessBuilder(commands2);
        Process process2 = pb2.start();
        process2.waitFor();

        BufferedReader stdInput = new BufferedReader(new InputStreamReader(process.getInputStream()));
        String s=null;

        while ((s = stdInput.readLine()) != null) {
            System.out.println(s);
        }
    }
}