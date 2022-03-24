import java.io.IOException;
import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) throws IOException {
        // twoNumber();
        // computeCircle(23);
        // getWeekDay(1);
        // numberList();
        // codeRomain();
        // System.out.println(Math.random());
        // int[] myNum = {10, 20, 30, 40};
        // Homework.enlargeArray(myNum);
        //new TpNote();
        Polynomial polynome = new Polynomial("x^4+3.x^2+4.x+3");
        polynome.compute(8);
        polynome.compute(20);
        polynome.compute(0);


        //polynome.getPolynomial();
        //polynome.getPolynomialFactors();
    }
    public static void codeRomain() {
        Scanner sc = new Scanner(System.in);
        int n = 0;
        float val = 0;
        float[] arr = {};
        while (true) {

            System.out.println("Enter a number: ");
            n += 1;
            float input = sc.nextFloat(); //input
            val += input;
            arr = Arrays.copyOf(arr, arr.length + 1); //+1 element to the array
            arr[arr.length - 1] = input; // Assign the user input to the element

            if (input == 0) {
                System.out.println("End of the Program");
                break;
            } else {
                // Computing the average
                float average = (val / n); //average
                String straverage = String.format("%.2f", average); //2 decimals
                System.out.println("Average: " + straverage); //printing the average
                System.out.println(Arrays.toString(arr)); //printing the array

                // 2nd biggest and behavior
                if (arr.length >= 2) {
                    // Determine the 2nd biggest one
                    int size = arr.length; // size of the array
                    float second = arr[size - 2]; //2nd biggest element
                    System.out.println("Second biggest number: " + Arrays.toString(new float[]{second})); //print

                    // Determining the behavior of the input
                    System.out.println(arr);
                    float element = (float) Array.getFloat(arr, n - 1); //Problème de type d'élement
                    System.out.println(element);
                }
            }
        }
    }
    public static void twoNumber() throws java.io.IOException {
        Scanner scan = new Scanner(System.in);
        System.out.print ("Please enter a number: ");
        float a = scan.nextFloat();
        scan.nextLine();
        System.out.print ("Please enter an other number: ");
        float b = scan.nextFloat();
        scan.nextLine();

        System.out.println("a = " + a + " and b = " + b);
        System.out.printf("a + b = %.2f%n", a + b);

        System.out.printf("a - b = %.2f%n", a - b);
        if(b != 0) {
            System.out.printf("a / b = %.2f%n", a / b);
        }
        else {
            System.out.println("Division of a by b is not possible by 0.");
        }
        System.out.printf("a * b = %.2f%n", a * b);
    }
    public static void computeCircle(float radius) {
        double area =  (3.14 * radius * radius);
        double perimeter =  (2 * 3.14 * radius);
        System.out.printf("Circle radius : %.3f%n",radius);
        System.out.printf("Circle perimeter : %.3f%n", perimeter);
        System.out.printf("Circle area : %.3f%n", area);
        System.out.println();
    }
    public static String getWeekDay(int dayNumber) {
        String[] weekDays = {"Monday", "Tuesday", "Wednesday", "Thursday", "Friday", "Saturday", "Sunday" };
        return weekDays[(dayNumber - 1) % 7];
    }
    public static void numberList() throws IOException{
        ArrayList<Integer> numberList = new ArrayList<Integer>();
        Scanner scan = new Scanner(System.in);
        int lastNumber;
        do {
            lastNumber = scan.nextInt();
            scan.nextLine();
            if(lastNumber != 0) {
                numberList.add(lastNumber);
            }
        } while(lastNumber != 0);


        System.out.println("final list : " + numberList.toString());
        float average = averageFromList(numberList);
        boolean isNaN = Float.isNaN(average);
        if(isNaN) {
            System.out.printf("Average Number is not calculable");

        } else {
            System.out.printf("Average Number : %.2f%n", averageFromList(numberList));
        }
        float[] maximums = getMax(numberList);
        float[] minimums = getMins(numberList);
        System.out.println("The maximum of the list is : " + maximums[0]);
        System.out.println("The Second maximum of the list is : " + maximums[1]);
        System.out.println("The minimum of the list is : " + minimums[0]);
        System.out.println("The Second minimum of the list is : " + minimums[1]);
        System.out.println("Globaly the entries are " + getGlobalVar(numberList));
    }
    public static float averageFromList(ArrayList<Integer>  numberList) {
        float sum;
        sum = numberList.stream().mapToInt(n -> n).sum();
        return sum / numberList.size();
    }
    public static float[] getMax(ArrayList<Integer>  numberList) {
        float max = Collections.max(numberList);
        float secondeMax = Collections.min(numberList);
        for (int i = 0; i < numberList.size() ; i++) {
            if(numberList.get(i) > max) {
                secondeMax = max;
                max = numberList.get(i);

            }
            else if (numberList.get(i) > secondeMax && numberList.get(i) != max) {
                secondeMax = numberList.get(i);
            }

        }

        return new float[]{max, secondeMax};
    }
    public static float[] getMins(ArrayList<Integer>  numberList) {
        float min = Collections.min(numberList);
        float secondMin = Collections.max(numberList);
        for (int i = 0; i < numberList.size() ; i++) {
            if(numberList.get(i) < min) {
                secondMin = min;
                min = numberList.get(i);

            }
            else if (numberList.get(i) < secondMin && numberList.get(i) != min) {
                secondMin = numberList.get(i);
            }

        }

        return new float[]{min, secondMin};
    }
    public static String getGlobalVar(ArrayList<Integer>  numberList) {
       if(numberList.get(0) > numberList.get(numberList.size() - 1)){
           return "decreasing";
       } else if (numberList.get(0) > numberList.get(numberList.size() - 1)) {
           return "increasing";
       } else {
           return "constant";
       }
    }


}
