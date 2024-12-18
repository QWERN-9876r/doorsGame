import com.aparapi.Kernel;
import com.aparapi.Range;

import java.util.ArrayList;
import java.util.Random;
import java.util.Scanner;

public class DorsGame {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        final long[] winCount = new long[1];
        final int N = scanner.nextInt();

        Kernel kernel = new Kernel() {
            public void run() {
                final int winDore = (int) Math.round(Math.random() * 2);
                int selectedDore = (int) Math.round(Math.random() * 2);
                int openedDoreIndex = 3 - selectedDore - winDore;

                if (3 - selectedDore - openedDoreIndex == winDore) {
                    winCount[0]++;
                }
            }
        };

        kernel.execute(Range.create(N));

        System.out.println((double) winCount[0] / N);

        kernel.dispose();
    }
}
