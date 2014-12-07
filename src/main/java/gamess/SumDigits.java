package gamess;

import java.util.Scanner;

public class SumDigits
{
    public void digits()
    {
        System.out.println("Enter digits");
        Scanner in = new Scanner(System.in);
        int sir2 = in.nextInt();

        //System.out.println("Digits sum is: " + sir2);
        int sum = 0;
        int count_digits = 1;
        int count = 1;
        int work = sir2;

        while(work/10 !=0)
        {
            count_digits++;
            work = work/10;
        }
        System.out.println(sir2 + " has " + count_digits + " digits ");
        int power = 1;

        String[]character = new String[count_digits];
        for(count=1; count<=count_digits-1; count++)
        {
            power=power*10;
        }
        //System.out.println(power);
        work = sir2;

        while(power !=0)
        {
            sum = sum + work/power;
            character[(count_digits-1)-(count-1)] = Integer.toString(work/power);
            count --;
            work = work%power;
            power = power/10;
        }
        System.out.print("The sum of digits = ");
        for (int i=0; i<character.length; i++)
        {
            if (i!=character.length- 1)
            System.out.print(character[i]+" + ");

            else if(i==character.length-1)
                System.out.print(character[i]+ " = " + sum);
        }
    }
}
