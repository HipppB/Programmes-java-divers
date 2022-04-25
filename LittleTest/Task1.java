package LittleTest;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Task1 {
    public static void main(String[] args) {
        System.out.println("Please enter your text :");
        Scanner scanner = new Scanner(System.in);
        List<String> lines = new ArrayList<>();

        while(scanner.hasNextLine() ) {
            String line = scanner.nextLine();
            if(line.equals("") || line == null) {
                break;
            }
            lines.add(line);
        }
        int nbCaracter = 0;
        int nbLine = lines.size();
        int nbWord = 0;
        for (String oneLine: lines) {
            nbCaracter += oneLine.length();
            nbWord += oneLine.split(" ").length;
        }
        System.out.println("Number of caracters : " + nbCaracter);
        System.out.println("Number of words : " + nbWord);
        System.out.println("Number of lines : " + nbLine);
    }
}
