package joculetee;

import gamess.*;

import java.util.Scanner;

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
        System.out.println("5 - or other number to exit");

        Scanner in = new Scanner(System.in);
        int x = in.nextInt();

        if(x ==1)
        {
            SeeNumber prim = new SeeNumber();
            prim.number();
        }
        else if(x==2)
        {
            fibonaci fb = new fibonaci();
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
        }else
        {
            Compari cpr = new Compari();
            cpr.numere();
        }

    }

}
