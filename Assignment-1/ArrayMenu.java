import java.util.Scanner;
class ArrayMenu {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] a = new int[n];
        for (int i = 0; i < n; i++) a[i] = sc.nextInt();
        int ch = sc.nextInt();
        switch (ch) {
            case 1:
                int pos = sc.nextInt();
                int val = sc.nextInt();
                for (int i = n - 1; i > pos; i--) a[i] = a[i - 1];
                a[pos] = val;
                break;
            case 2:
                int d = sc.nextInt();
                for (int i = d; i < n - 1; i++) a[i] = a[i + 1];
                break;
            case 3:
                int key = sc.nextInt();
                for (int i = 0; i < n; i++)
                    if (a[i] == key) System.out.println(i);
                break;
            case 4:
                int k = sc.nextInt();
                int l = 0, r = n - 1;
                while (l <= r) {
                    int m = (l + r) / 2;
                    if (a[m] == k) { System.out.println(m); break; }
                    else if (a[m] < k) l = m + 1;
                    else r = m - 1;
                }
                break;
            case 5:
                int max = a[0];
                for (int i = 1; i < n; i++) if (a[i] > max) max = a[i];
                System.out.println(max);
                break;
            case 6:
                int even = 0, odd = 0;
                for (int i = 0; i < n; i++)
                    if (a[i] % 2 == 0) even++; else odd++;
                System.out.println(even + " " + odd);
                break;
            case 7:
                for (int i = 1; i < n; i++) {
                    int temp = a[i], j = i - 1;
                    while (j >= 0 && a[j] > temp) {
                        a[j + 1] = a[j];
                        j--;
                    }
                    a[j + 1] = temp;
                }
                for (int i = 0; i < n; i++) System.out.print(a[i] + " ");
        }
    }
}
