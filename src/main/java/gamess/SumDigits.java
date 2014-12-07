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
        for(count=1; count<=count_digits-1; count++)
        {
            power=power*10;
        }
        //System.out.println(power);
        work = sir2;

        while(power !=0)
        {
            sum = sum + work/power;
            work = work%power;
            power = power/10;
        }

        System.out.println("The sum of digits = "+ sum);
    }

}
