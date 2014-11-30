package gamess;

import java.util.Scanner;

public class fibonaci
{
    public void fib()
    {
        System.out.println("Start Fibonacci game! ");
        System.out.println("Select the upper bound:");
        Scanner in = new Scanner(System.in);
        int a = in.nextInt();

        System.out.println("Number is " +a);

        int b = 0;
        int c = 1;

        System.out.println( " Fibonaci:");

        while (b+c <=a)
        {
            System.out.println(b+c);
            c=b+c;
            b=c-b;
        }
    }
}
