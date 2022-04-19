import java.io.File;  // Import the File class
import java.io.FileNotFoundException;  // Import this class to handle errors
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner; // Import the Scanner class to read text files
import java.lang.NumberFormatException;
public class HomeWorkOne {
    public static void main(String[] args){
        String fromFile = null;
        float x = 0f;
        float a = 0f;
        boolean isAinit = false;
        float b = 0f;
        boolean isBinit = false;

        // We look to the arguments given
        for (int i = 0; i < args.length / 2; i++) {
            switch(args[i  * 2]){
                case "-x":
                    try {
                        x = Float.parseFloat(args[2 * i + 1]);
                    } catch (NumberFormatException e) {
                        System.out.println("Invalid x value, taking x = 0");
                        x = 0f;
                    }
                    break;
                case "-f":
                    fromFile = args[i * 2 + 1];
                    break;
                case "-a":
                    try {
                        a = Float.parseFloat(args[2 * i + 1]);
                        isAinit = true;
                    } catch (NumberFormatException e) {
                        System.out.println("Invalid a value. Skipping");
                    }
                    break;
                case "-b":
                    try {
                        b = Float.parseFloat(args[2 * i + 1]);
                        isBinit = true;
                    } catch (NumberFormatException e) {
                        System.out.println("Invalid b value. Skipping");
                    }
                    break;
             }
        }
        List<Polynomial> polynomials = new ArrayList<>();

        if(fromFile != null){
            try {
                File polyFile = new File(fromFile);
                Scanner myReader = new Scanner(polyFile);
                while (myReader.hasNextLine()) {
                    String polynomial = myReader.nextLine();
                    try {
                    polynomials.add(new Polynomial(polynomial));
                    } catch (NumberFormatException e) {
                        System.out.println("A polynomial was invalid, let's ignore it");
                    }
                }
                myReader.close();
            } catch (FileNotFoundException e) {
                System.out.println("File not found");
            }
        }  else {
            Scanner lineScanner = new Scanner(System.in);
            System.out.println("Please enter polynomials one by one on separated lines");
            System.out.println("form of polynomials : 3.x^4+2.x^2-3");
            System.out.println("Once finish type \"exit\"");

            while(true) {
                String polynomial = lineScanner.nextLine();
                if(polynomial.equals("exit")) {
                    break;
                }
                try {
                    polynomials.add(new Polynomial(polynomial));
                } catch (NumberFormatException e) {
                    System.out.println("This polynomial has an invalid format, let's ignore it");
                }

            }
        }

        if(polynomials.size() > 0) {
            // Now we have our list of polynomials, for each of them we compute the value with x
            float result = 0f;
            for (Polynomial polynomial : polynomials) {
                result += polynomial.compute(x);
            }
            //But we want the average result so :
            result = result / polynomials.size();
            System.out.println("Average result for x = " + x + " : " + result);
            System.out.println(a + " " + b);
            if (isAinit && isBinit) {
                //If a and b have been past we will try to calculate each roots
                float averageRoot = 0f;
                try {
                    for (Polynomial polynomial : polynomials) {
                        averageRoot += polynomial.findRoot(a, b);
                    }
                    averageRoot = averageRoot / polynomials.size(); //We only look for 1 root per polynomial
                    System.out.println("Average roots of all polynomials for x = " + x + " : " + averageRoot);

                } catch (IOException e) {
                    System.out.println("One or more roots couldn't be calculated. The average could not be calculated");
                }
            }
        }
        System.out.println("End of program");
    }

}

