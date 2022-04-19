import java.io.IOException;

public class TpNote {
    public static void main(String[] args) throws IOException {
        //System.out.println("Hello World");
        //croix(6);
        voyelles("Hello World");
        //Book test = new Book("Test", "SuperAuteur", 2202);
        //Book test2 = new Book("Test2", "SuperAuteu2r", 2003);

        //System.out.println(test.getDescription());
        //System.out.println(test2.getDescription());

    }
    public static void croix(int n) {
        for (int i = 0; i < n/2 ; i++) {
            for (int j = 0; j < i ; j++) {
                System.out.print(" ");
            }
            System.out.print("*");
            for (int j = 0; j < n - 2 - 2*i; j++) {
                System.out.print(" ");
            }
            System.out.println("*");
        }
        if ((int) n/2 * 2 != n ) {
            for (int j = 0; j < n - 2 - 2*j/2; j++) {
                System.out.print(" ");
            }
            System.out.println("*");
        }
        for (int i = 0; i < n/2  ; i++) {

            for (int j = 0; j < n/2 - 1 -i; j++) {
                System.out.print(" ");
            }
            System.out.print("*");
            for (int j = 0; j < 2*i  + 1 ; j++) {
                if(j != 0 || (int) n/2 * 2 != n) {
                    System.out.print(" ");
                }
            }
            System.out.println("*");
        }
    }
    public static void voyelles(String mot) {
        char[] voyelles = {'a', 'e', 'i', 'o', 'u', 'y'};
        mot = mot.toLowerCase();
        boolean first = true;
        for (char letter: mot.toCharArray()) {
            for (int i = 0; i < voyelles.length; i++) {
                if (letter == voyelles[i]) {
                    if (first) {
                    System.out.print(letter);
                    first = false;
                    } else {
                        System.out.print(" " + letter);

                    }
                }
            }
        }
    }
}
