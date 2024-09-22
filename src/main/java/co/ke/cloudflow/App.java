package co.ke.cloudflow;
import java.util.Scanner;
import java.util.Random;
/**
 * Hello world!
 * 1. Easiest test where your solutions differs
 * 2. Integer overflow
 * 3. max tests
 *
 *
 */
public class App {

    private static long maxPairwiseProduct(long[] numbers) {

        int size = numbers.length;
        long maxValue = 0;

        for (int i = 0; i < size; i++) {
            for (int j = i + 1; j < size; j++) {
                if (maxValue < numbers[i] * numbers[j])
                    maxValue = numbers[i] * numbers[j];
            }
        }

        return maxValue;
    }

    private static long maxPairwiseProductFast(long[] numbers) {

        int maxIndex1 = -1;

        for (int i = 0; i < numbers.length; i++) {
            if (maxIndex1 == -1 || numbers[i] > numbers[maxIndex1])
                maxIndex1 = i;
        }

        int maxIndex2 = -1;
        for (int j = 0; j < numbers.length; j++) {
            if ((j != maxIndex1) && (maxIndex2 == -1 || numbers[j] > numbers[maxIndex2]))
                maxIndex2 = j;
        }

        return numbers[maxIndex1] * numbers[maxIndex2];
    }


    public static void main( String[] args )  {

//        Scanner scanner = new Scanner(System.in);
//        System.out.print("Enter the size : ");
//        int n = scanner.nextInt();
//        long[] numbers = new long[n];
//        for (int i = 0; i < n; i++) {
//            numbers[i] = scanner.nextInt();
//        }


        while(true) {
            Random rand = new Random();
            long[] numbers = new long[rand.nextInt(100)  + 2];
            for (int i = 0; i < numbers.length; i++) {
                numbers[i] = rand.nextInt(100000) + 1;
            }

            long maxValue1 = maxPairwiseProductFast(numbers);
            long maxValue2 = maxPairwiseProduct(numbers);

            if (maxValue1 != maxValue2) {
                System.out.println("Wrong Answer: maxValue1: " + maxValue1 + ", maxValue2: " + maxValue2);
                break;
            } else {
                System.out.println("Correct Answer: maxValue1: " + maxValue1 + ", maxValue2: " + maxValue2);
            }
        }


        // scanner.close();
    }
}
