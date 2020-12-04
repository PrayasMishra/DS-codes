import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;

public class GCD {
    public static int calcGCD(int a, int b) {
        if (a==0)
            return b;
        if (b==0)
            return a;
        if (a==b)
            return a;
        if (a>b)
            return calcGCD(a-b, b);

        return calcGCD(a, b-a);
    }

    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        System.out.println("enter a and b: ");
        int a = Integer.parseInt(br.readLine());
        int b = Integer.parseInt(br.readLine());
        int gcd = calcGCD(a,b);
        System.out.println("gcd("+a+","+b+") = "+gcd);

        br.close();
    }
}
