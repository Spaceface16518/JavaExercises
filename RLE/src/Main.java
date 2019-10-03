import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        System.out.println(args[0]);

        File file = new File(args[1]);
        Scanner scanner;
        try {
            scanner = new Scanner(file);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }

        StringBuilder input = new StringBuilder();

        while (scanner.hasNextLine()) {
            String line = scanner.nextLine();
            input.append(line);
        }

        // TODO: encode data

        System.out.println(input.toString());
    }
}
