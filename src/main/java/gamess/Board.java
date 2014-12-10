package gamess;

import java.util.Scanner;

public class Board
{
    String[][]matrice = new String[8][8];
    int see=0;
    int see2=0;

    public void display(String[][]matrice)
    {
        System.out.println("  1   2   3   4   5   6   7   8");
        for(int row=0; row<8; row++)
        {

            for (int column = 0; column < 8; column++)
                System.out.print(matrice[row][column]);

            System.out.println();
        }
    }

    public void complete(int choice, int player)
    {
        for (int row = 0; row < 8; row++)

            if (matrice[7 - row][choice - 1] == " [] ")
            {
                if(player==1)
                {
                    matrice[7 - row][choice - 1] = "  x ";
                    win(matrice);
                    break;
                }
                else if(player==2)
                {
                    matrice[7 - row][choice - 1] = "  0 ";
                    win(matrice);
                    break;
                }
            }
    }

    public void win(String[][]matrice)
    {
        for(int row=0; row<8; row++)

            for(int column=0; column<8; column++)
            {
                if (matrice[row][column] == "  x ")
                {
                    see++;
                    if (see == 4) {
                        display(matrice);
                        System.out.println("You win the game!");
                        break;
                    }
                }
                else if (matrice[row][column] != "  x ")
                    see = 0;
            }

        for(int row=0; row<8; row++)

            for(int column=0; column<8; column++)
            {
                if(matrice[row][column]=="  0 ")
                {
                    see2++;
                    if(see2==4)
                    {
                        display(matrice);
                        System.out.println("You win the game");
                        break;
                    }
                }
                else if(matrice[row][column]!="  0 ")
                    see2=0;

            }
        if((see!=4)&&(see2!=4))
            display(matrice);
    }

    public void tick()
    {
        for(int row=0; row<8; row++)
            for(int column=0; column<8; column++)
                matrice[row][column]=" [] ";

        display(matrice);

        Scanner in = new Scanner(System.in);
        int move = 0;// check the turn of the players
        int choice = 0;// players` option
        int player = 0;

        while((see!=4)&&(see2!=4))
        {
            move++;
            if(move%2!=0)
            {
                System.out.println("Player 1 choose the column!");
                choice = in.nextInt();
                player=1;
                complete(choice, player);

            } else if(move%2==0)
            {
                System.out.println("Player 2 choose the column!");
                choice = in.nextInt();
                player=2;
                complete(choice, player);
            }
        }
    }
}
