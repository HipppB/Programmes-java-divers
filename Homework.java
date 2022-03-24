import java.io.IOException;
import java.util.Arrays;

public class Homework {

    public static void main(String[] args) throws IOException {
        int[] myNum = {10, 20, 30, 40};

        enlargeArray(myNum);
    }
    public static void enlargeArray(int[] numbers) {
        float[] myNum = new float[numbers.length + numbers.length - 1];
        for (int i = 0; i < numbers.length * 2 - 1; i++) {
            if((i + 1) % 2 == 0) {
                myNum[i] = (numbers[i/2] + numbers[ i/2 + 1]) / 2;
            } else {
                myNum[i] = numbers[i/2];
            }
        }
        System.out.println(Arrays.toString(myNum));

    }
}
