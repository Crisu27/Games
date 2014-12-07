package gamess;

import java.util.Scanner;

public class Arithmetic
{
    public void math()
    {
        System.out.println("java Arithmetic ");
        String[]sir = new String[3];
        Scanner in = new Scanner(System.in);
        System.out.println( "Enter first number");
        int numbers = in.nextInt();
        sir[0] = Integer.toString(numbers);
        System.out.println("Enter second number");
        numbers = in.nextInt();
        sir[1] = Integer.toString(numbers);
        System.out.println("Enter the operation");
        String op = in.next();
        sir[2] = op;

        System.out.println("The array is: " + sir[0] + ' ' + sir[1] + ' ' + sir[2]);

        int result = 0;

        switch (sir[2].charAt(0))
        {
            case '+' : result = Integer.parseInt(sir[0])+
                                Integer.parseInt(sir[1]);
                break;
            case '-' : result = Integer.parseInt(sir[0])-
                                Integer.parseInt(sir[1]);
                break;
            case '*' : result = Integer.parseInt(sir[0])*
                                Integer.parseInt(sir[1]);
                break;
            case '/' : result= Integer.parseInt(sir[0])/
                               Integer.parseInt(sir[1]);

        }
        System.out.println(sir[0] + sir[2] + sir[1] + "=" + result);
    }

}
