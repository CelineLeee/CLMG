import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        while (sc.hasNext()) {
            String command = sc.next();

            if ("binomial".equals(command)) {
                int n = sc.nextInt();
                int k = sc.nextInt();
                System.out.print(PascalTriangle.computeBinomialCoef(n, k));

                // TODO Fill your code to compute and print a binomial coefficient.

            } else if ("draw".equals(command)) {
                int n = sc.nextInt();
                PascalTriangle.drawPascalTriangle(n);

                // TODO Fill your code to print a Pascal's triangle.

            } else {
                throw new AssertionError("Invalid input!");
            }
        }
    }

}
