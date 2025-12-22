import java.util.Scanner;
class MatrixOps {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int r = sc.nextInt();
        int c = sc.nextInt();
        int[][] a = new int[r][c];
        int[][] b = new int[r][c];

        for (int i = 0; i < r; i++)
            for (int j = 0; j < c; j++)
                a[i][j] = sc.nextInt();
        for (int i = 0; i < r; i++)
            for (int j = 0; j < c; j++)
                b[i][j] = sc.nextInt();
        for (int i = 0; i < r; i++) {
            for (int j = 0; j < c; j++)
                System.out.print(a[i][j] + b[i][j] + " ");
            System.out.println();
        }
        for (int i = 0; i < r; i++) {
            for (int j = 0; j < c; j++)
                System.out.print(a[i][j] - b[i][j] + " ");
            System.out.println();
        }
        for (int i = 0; i < r; i++) {
            for (int j = 0; j < c; j++)
                System.out.print(a[j][i] + " ");
            System.out.println();
        }
        boolean square = r == c;
        boolean diagonal = true, identity = true;
        for (int i = 0; i < r; i++)
            for (int j = 0; j < c; j++)
                if (i != j && a[i][j] != 0) diagonal = false;
        for (int i = 0; i < r; i++)
            for (int j = 0; j < c; j++)
                if ((i == j && a[i][j] != 1) || (i != j && a[i][j] != 0))
                    identity = false;

        System.out.println(square);
        System.out.println(diagonal);
        System.out.println(identity);
    }
}
