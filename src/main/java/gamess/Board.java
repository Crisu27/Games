package gamess;

import java.util.Scanner;

public class Board
{
    String[][]matrice = new String[8][8];
    int see=0; //verify if Player 1 wins - x
    int see2=0; //verify if Player 2 wins - 0

    public void display(String[][]matrice)
    {
        System.out.println("  1   2   3   4   5   6   7   8");
        for(int row=0; row<8; row++)
        {

            for (int column = 0; column < 8; column++)
            {
                System.out.print(matrice[row][column]);
            }

            System.out.println();
        }
    }

    public int complete(int choice, int player)
    {
        boolean won=false;
        String pl;
        int ret=0;
        for (int row = 0; row < 8; row++)

            if (matrice[7 - row][choice - 1] == " [] ")
            {
                if(player==1)
                {
                    pl="  x ";
                    matrice[7 - row][choice - 1] = "  x ";
                    //won=win_horizontal(pl);
                    //won=win_vertical(pl);
                    //won=win_downleft(pl);
                    won=win_downright(pl);
                    if(won==true)
                    {
                        ret=1;
                    }
                        break;

                }
                else if(player==2)
                {
                    pl="  0 ";
                    matrice[7 - row][choice - 1] = "  0 ";
                    //win_horizontal(pl);
                    //win_vertical(pl);
                    //won=win_downleft(pl);
                    won=win_downright(pl);
                    if(won==true)
                    {
                        ret=1;
                    }
                        break;

                }
            }
        if (ret==1)
        {
            return player;
        }
        else
        {
            return 0;
        }
    }


    public boolean win_horizontal(String player)
    {
        for (int row = 0; row < 8; row++)

            for (int column = 0; column < 8; column++)
            {
                if (matrice[row][column].equals(player))
                {
                    see++;
                    if (see == 4)
                    {
                        display(matrice);
                        //System.out.println("You won the game!");
                        break;
                    }
                } else if (!matrice[row][column].equals(player))
                    see = 0;
            }
        if (see != 4)
        {
            display(matrice);
            return false;
        }
        else return true;
    }

    private boolean win_vertical(String player)
    {
        for(int column=0; column<8; column++)

            for(int row=0; row<8; row++)
            {
                if (matrice[row][column].equals(player))
                {
                    see++;
                    //System.out.println(see);
                    if (see == 4)
                    {
                        display(matrice);
                        //System.out.println("You won the game!");
                        break;
                    }
                }
                else if ((matrice[row][column] != player)&&(see!=4))
                    see = 0;
            }

        if(see!=4)
        {
            display(matrice);
            return false;
        }
        else return true;

    }


    public boolean win_downleft(String player)
    {
        int position=0;

        for (int row = 0; row < 8; row++)
        {
            for (int column = 3; column < 8; column++)
            {
                position=0;

                while (matrice[row - position][column - position].equals(player) && position < 4)
                {
                    position++;
                    //System.out.println("row" + (row - position) + " column " + (column - position) + " " + position);

                    if (column - position < 0)
                    {
                        break;
                    }
                }
                if (position==4)
                {
                    //System.out.println("You won the game!");
                    break;
                }
            }
        }

        if(position!=4)
        {
            display(matrice);
            return false;
        }
        else return true;

    }

    public boolean win_downright(String player)
    {
        int position=0;

        for (int row = 0; row < 8; row++)
        {
            for (int column = 3; column < 8; column++)
            {
                position=0;

                while (matrice[row - position][column - position].equals(player) && position < 4)
                {
                    position++;
                    //System.out.println("row" + (row - position) + " column " + (column - position) + " " + position);

                    if (column - position < 0)
                    {
                        break;
                    }
                }
                if (position==4)
                {
                    //System.out.println("You won the game!");
                    break;
                }
            }
        }

        if(position!=4)
        {
            display(matrice);
            return false;
        }
        else return true;

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
        int fin = 0;

        while((see!=4)&&(see2!=4))
        {
            move++;
            if(move%2!=0)
            {
                System.out.println("Player 1 choose the column!");
                choice = in.nextInt();
                player=1;
                fin = complete(choice, player);
                if(fin!=0)
                {
                    System.out.print(" Player " + fin + " won the game!");
                    break;
                }

            } else if(move%2==0)
            {
                System.out.println("Player 2 choose the column!");
                choice = in.nextInt();
                player=2;
                fin = complete(choice, player);
                if(fin!=0)
                {
                    System.out.print(" Player " + fin + " won the game!");
                    break;
                }
            }
        }
    }
}
