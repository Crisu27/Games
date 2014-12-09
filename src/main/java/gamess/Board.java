package Jocurilee;

import java.util.Scanner;

public class Board
{
    String[][]matrice = new String[8][8];

    public void Matrix(String[][]matrice)
    {
        System.out.println("  1   2   3   4   5   6   7   8");
        for(int row=0; row<8; row++)
        {

            for (int column = 0; column < 8; column++)
                System.out.print(matrice[row][column]);

            System.out.println();
        }

    }

    public void tick()
    {

        for(int row=0; row<8; row++)
            for(int column=0; column<8; column++)
                matrice[row][column]=" [] ";

        Matrix(matrice);

        Scanner in = new Scanner(System.in);
        int move = 0;// verifica daca e par sau impar pt succesiunea playerilor
        int choice = 0;// optiunile playerilor
        int helpcount = 0;// pune un singur x/0 dupa ce s-a ales optiunea


        while(move<=10)
        {
            move++;
            if(move%2!=0)
            {
                System.out.println("Player 1 choose the column!");
                choice = in.nextInt();
                helpcount = 0;

                for(int row=0; row<8; row++)
                    for(int column=0; column<8; column++)
                    {
                        if(column ==choice-1)
                        {
                            if(matrice[7-row][column] == " [] ")
                            {
                                while(helpcount!=1)
                                {
                                    matrice[7-row][column] = "  x ";
                                    helpcount++;
                                }
                            }

                        }
                    }


                Matrix(matrice);

            }
            else if(move%2==0)
            {
                System.out.println("Player 2 choose the column!");
                choice = in.nextInt();
                helpcount = 0;

                for(int row=0; row<8; row++)
                    for(int column=0; column<8; column++)
                    {
                        if(column ==choice-1)
                        {
                            if(matrice[7-row][column] == " [] ")
                            {
                                while(helpcount!=1)
                                {
                                    matrice[7-row][column] = "  0 ";
                                    helpcount++;
                                }
                            }

                        }
                    }

                Matrix(matrice);
            }
        }
    }

}
