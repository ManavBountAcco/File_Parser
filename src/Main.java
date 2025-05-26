//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
public class Main {
    public static void main(String[] args)  throws IOException {
                Path filePath = Path.of(".//input.txt");
                String content = Files.readString(filePath);
                System.out.println(content);
        //code to read and generate By manav>
        //Approach : -> String -> O(n) read -> Add in Set -> add in output.txt if not generate else overwrite


    }
}