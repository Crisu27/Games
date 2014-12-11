package joculetee;

import gamess.*;

import java.util.Scanner;

import static gamess.Count.count;
import static gamess.Factorial.factorial;
import static gamess.Factorial2.fact;

public class Joculete
{
    public static void main(String[] args)
    {
        System.out.println("Welcome!");
        System.out.println("");
        System.out.println("Choose the game!");
        System.out.println("");
        System.out.println("1 - Prime Numbers");
        System.out.println("2 - Fibonacci");
        System.out.println("3 - Guessing game-Computer guess");
        System.out.println("4 - Guessing game-Player guess");
        System.out.println("5 - Factorial game");
        System.out.println("6 - Factorial 2 game");
        System.out.println("7 - Count game");
        System.out.println("8 - Factorialprime game");
        System.out.println("9 - Calculate grades average");
        System.out.println("10 - Calculate grades average, minimun, maximum");
        System.out.println("11 - java Arithmetic ");
        System.out.println("12 - Sum Digits ");
        System.out.println("13 - Puissance 4 ");
        System.out.println("14 - or other number to exit");

        Scanner in = new Scanner(System.in);
        int x = in.nextInt();

        if(x ==1)
        {
            SeeNumber prim = new SeeNumber();
            prim.number();
        }
        else if(x==2)
        {
            Fibonaci fb = new Fibonaci();
            fb.fib();
        }
        else if(x==3)
        {
            GuessingGame1 gg = new GuessingGame1();
            gg.gsg1();

        }
        else if(x==4)
        {
            GuessingGame2 gg2 = new GuessingGame2();
            gg2.gsg2();
        }
        else if (x==5)
        {
            //Factorial fct = new Factorial();
            //fct.facto();
            System.out.println("Start Factorial game!");
            System.out.println("Select the number:");
            //Scanner in = new Scanner(System.in);
            int z= in.nextInt();
            System.out.println( "The number is " +z );
            System.out.println("Factorial of " + z + " is: " + factorial(z));

        }
        else if (x==6)
        {
            System.out.println("Start Factorial 2 game!");
            System.out.println("Select the number:");
            int l= in.nextInt();
            System.out.println( "The number is " +l );
            System.out.println("Factorial of " + l + " is: " + fact(l));
        }
        else if(x==7)
        {
            System.out.println("Add your number: ");
            String m = in.next();
            System.out.println("Number is: " +m);
            System.out.println("");
            String num = m;

            System.out.println("Steps number");
            int n = in.nextInt();

            for(int i =1;i <=n; i++)
            {
                System.out.println(num);
                num = count(num);
            }
        }
        else if (x==8)
        {
            Factorialprime pr = new Factorialprime();
            pr.factorialnumber();
        }
        else if (x==9)
        {
            GradesStatistics avr = new GradesStatistics();
            avr.average();
        }
        else if (x==10)
        {
            GradesStatistics2 gr2 = new GradesStatistics2();
            gr2.average2();
        }
        else if (x==11)
        {
            Arithmetic art = new Arithmetic();
            art.math();
        }
        else if(x==12)
        {
            SumDigits sum = new SumDigits();
            sum.digits();
        }
        else if(x==13)
        {
            Board brd = new Board();
            brd.tick();
        }
    }
}
