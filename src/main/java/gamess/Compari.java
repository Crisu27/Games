package gamess;

import java.util.Scanner;

public class Compari
{
    public void numere()
    {
        System.out.println("Introduceti primul numar");
        Scanner in = new Scanner(System.in);
        int a = in.nextInt();
        System.out.println("Numarul ales este "+a);

        System.out.println("Introduceti al doilea numar");
        int b = in.nextInt();
        System.out.println("Numarul ales este " +b);

        System.out.println("Introduceti al treilea numar");
        int c = in.nextInt();
        System.out.println("Numarul ales este " +c);

        System.out.println("Numerele in ordinea crescatoare: ");

        if((a<=b) && (a<=c))
        {
            System.out.println(a);
            if(b<=c)
            {
                System.out.println(b);
                System.out.println(c);
            }
            else if(b>c)
            {
                System.out.println(c);
                System.out.println(b);
            }
        }
        else if((a>b) && (a>c))
        {
            if(b<=c)
            {
                System.out.println(b);
                System.out.println(c);
            }
            else if(b>c)
            {
                System.out.println(c);
                System.out.println(b);
            }
            System.out.println(a);
        }


    }
}
