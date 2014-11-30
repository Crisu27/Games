package gamess;

import java.util.Random;
import java.util.Scanner;

public class GuessingGame2
{
    public void gsg2()
    {
        System.out.println("Start Guessing game! ");
        System.out.println("Round 2-Computer Guess");
        System.out.println("Choose your number!");
        Scanner in = new Scanner(System.in);
        int k = in.nextInt();

        System.out.println("");
        System.out.println("Guess the number. Computer, type your choice!" );

        Random rand = new Random();
        int randomNum = rand.nextInt(100);
        int l = 0;

        while(randomNum !=k)
        {
            randomNum = rand.nextInt(100);
            System.out.println(randomNum);
            if (randomNum < k)
            {
                System.out.println("Higher");
            }
            else if (randomNum > k)
            {
                System.out.println("Lower");
            }
            l++;
        }
        System.out.println("No.of attempts " +l);

        if (randomNum == k)
        {
            System.out.println("");
            System.out.println("Congrats! You guessed the number!");
        }

    }
}
