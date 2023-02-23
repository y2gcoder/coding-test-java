package cheatsheets;

import java.util.Scanner;

public class Euclidean {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int num1 = scan.nextInt();
        int num2 = scan.nextInt();
        System.out.println("gcd: "+gcd(num1, num2));
        System.out.println("lcm: "+lcm(num1, num2));
    }

    private static int gcd(int p, int q) {
        if (q == 0) return p;
        return gcd(q, p % q);
    }

    private static int lcm(int p, int q) {
        return p * q / gcd(p, q);
    }
}
