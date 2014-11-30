package gamess;

import java.util.Random;
import java.util.Scanner;

public class GuessingGame1
{
    public void gsg1()
    {
        System.out.println("Start Guessing game! ");
        System.out.println("Round 1-Player Guess");
        System.out.println("");

        Random rand = new Random();
        int randomNum = rand.nextInt(100);

        //System.out.println(randomNum);
        System.out.println("Guess the number. Type your choice!");
        Scanner in = new Scanner(System.in);
        int j = in.nextInt();

        while(randomNum !=j)
        {
            if (randomNum > j)
            {
                System.out.println("Higher");
                j = in.nextInt();
            }
            else if (randomNum < j)
            {
                System.out.println("Lower");
                j = in.nextInt();
            }
        }
        if (randomNum == j)
        {
            System.out.println("Congrats! You guessed the number!");
        }


    }


}
