import java.util.Random;

public class Main extends Thread {
    public static void main(String[] args) {
        int[][] matrix = new int[3][4];
        Random random = new Random();

        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 4; j++) {
                matrix[i][j] = random.nextInt(101);
            }
        }

        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 4; j++) {
                System.out.print(matrix[i][j] + " ");
            }
            System.out.println();
        }

        for (int row = 0; row < matrix.length; row++) {
            final int currentRow = row;

            Thread thread = new Thread(new Runnable() {
                @Override
                public void run() {
                    int sum = 0;
                    for (int num : matrix[currentRow]) {
                        sum += num;
                    }
                    System.out.println("Sum of row " + currentRow + ": " + sum);
                }
            });

            thread.start();

        }
    }
}