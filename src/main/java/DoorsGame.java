import com.aparapi.Kernel;
import com.aparapi.Range;

import java.util.Scanner;

public class DoorsGame {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        final long[] winCount = new long[1];
        final int n = scanner.nextInt();

        Kernel kernel = new Kernel() {
            public void run() {
                final int winDore = (int) (Math.random() * 3);
                final int selectedDore = (int) (Math.random() * 3);
                int openedDoreIndex = (int) (Math.random() * 3);

                while (openedDoreIndex == winDore || openedDoreIndex == selectedDore) {
                    openedDoreIndex = (int) (Math.random() * 3);
                }

                if (3 - selectedDore - openedDoreIndex == winDore) {
                    winCount[0]++;
                }
            }
        };

        kernel.execute(Range.create(n));

        System.out.println((double) winCount[0] / n);

        kernel.dispose();
    }
}
