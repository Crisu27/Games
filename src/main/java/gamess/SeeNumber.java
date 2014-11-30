package gamess;

import java.util.Scanner;

public class SeeNumber
{
    public void number()
    {
        System.out.println("Start Prime Numbers game!");
        System.out.println("Select the upper bound:");
        Scanner in = new Scanner(System.in);
        int x = in.nextInt();

        System.out.println( "The number is " +x );

        int y;
        int z = 1;
        int w = 0;



        for( y = 1; y <= x; y++)
        {
            //System.out.println("Numarul " +y+ " are divizori: ");
            w = 0;
            for (z =1 ; z <=y; z++)
            {

                if (y%z == 0)
                {
                    w++;
                    if (w >2)
                    break;

                }
            }
            //System.out.println(w);
            if (w <=2)
            {
                System.out.println(y + " este prim");
            }
        }
    }


}
