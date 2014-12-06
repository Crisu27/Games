package gamess;

import java.util.Scanner;

public class Factorialprime
{
    public void factorialnumber()
    {
        System.out.println("Start Factorialprime game!");
        System.out.println("Select your factorial number: ");
        Scanner in = new Scanner(System.in);
        int no_insert = in.nextInt();

        System.out.println( "The number is " +no_insert );

        int factor = 0;
        int power = 0;

        for(factor = 2; factor<=no_insert; factor++)
        {
            while (no_insert%factor ==0)
            {
                no_insert = no_insert/factor;
                power++;
            }
            if(power !=0)
            System.out.println(factor + (" ^ ") + power);
            power = 0;
        }
    }
}
