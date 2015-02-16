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

    public int complete(int choice, int player) {
        boolean wonh = false;
        boolean wonv = false;
        boolean wondl = false;
        boolean wondr = false;
        String pl="";
        for (int row = 0; row < 8; row++)

            if (matrice[7 - row][choice - 1] == " [] ") {
                switch (player) {
                    case 1:
                        pl = "  x ";
                        matrice[7 - row][choice - 1] = "  x ";
                        wonh = win_horizontal(pl);
                        wonv = win_vertical(pl);
                        wondl = win_downleft(pl);
                        wondr = win_downright(pl);
                        display(matrice);
                        if ((wonh == true) || (wonv == true) || (wondl == true) || (wondr == true)) {
                                    return player;
                                }

                        break;
                    case 2:
                        pl = "  o ";
                        matrice[7 - row][choice - 1] = "  o ";
                        wonh = win_horizontal(pl);
                        wonv = win_vertical(pl);
                        wondl = win_downleft(pl);
                        wondr = win_downright(pl);
                        display(matrice);
                        if ((wonh == true) || (wonv == true) || (wondl == true) || (wondr == true)) {
                                    return player;
                                }

                        break;
                }
                break;
            }

        return 0;
    }


      /*  String pl;
           for (int row = 0; row < 8; row++)

            if (matrice[7 - row][choice - 1] == " [] ")
            {
                if(player==1)
                {
                    pl="  x ";
                    matrice[7 - row][choice - 1] = "  x ";
                   wonh=win_horizontal(pl);
                   wonv=win_vertical(pl);
                   wondl=win_downleft(pl);
                    wondr=win_downright(pl);
                    display(matrice);
                    if((wonh==true)||(wonv==true)||(wondl==true)||(wondr==true))
                    {
                        return player;
                    }
                        break;

                }
                else if(player==2)
                {
                    pl="  0 ";
                    matrice[7 - row][choice - 1] = "  0 ";
                    wonh=win_horizontal(pl);
                    wonv=win_vertical(pl);
                    wondl=win_downleft(pl);
                    wondr=win_downright(pl);
                    display(matrice);
                    if((wonh==true)||(wonv==true)||(wondl==true)||(wondr==true))
                    {
                        return player;
                    }
                        break;

                }
            }
        return 0;
    }*/


    public boolean win_horizontal(String player)
    {
        for (int row = 0; row < 8; row++) {
            for (int column = 0; column < 8; column++) {
                if (matrice[row][column].equals(player)) {
                    see++;
                     if (see == 4) {
                        // display(matrice);
                        //System.out.println("You won the game!");
                        break;
                    }
                } else if (!matrice[row][column].equals(player))
                    see = 0;
            }
            if (see == 4) {
                break;
            }
        }
        if (see != 4)
        {
            //display(matrice);
            return false;
        }
        else return true;
    }

    private boolean win_vertical(String player)
    {
        for(int column=0; column<8; column++) {
            for (int row = 0; row < 8; row++) {
                if (matrice[row][column].equals(player)) {
                    see++;
                    //System.out.println(see);
                    if (see == 4) {
                        // display(matrice);
                        //System.out.println("You won the game!");
                        break;
                    }
                } else if (!matrice[row][column].equals(player) && (see != 4))
                    see = 0;
            }
            if (see == 4) {
                break;
            }
        }

        if(see!=4)
        {
           // display(matrice);
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

                    if ((column - position < 0)||(row-position<0))
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
            if (position==4)
            {
                 break;
            }
        }

        if(position!=4)
        {
            //display(matrice);
            return false;
        }
        else return true;

    }

    public boolean win_downright(String player)
    {
        int position=0;

        for (int row = 0; row < 8; row++)
        {
            for (int column = 0; column < 5; column++)
            {
                position=0;

                while (matrice[row-position][column + position].equals(player) && position < 4)
                {
                    position++;
                  //  System.out.println("row" + (row-position) + " column " + (column + position) + " " + position);

                    if ((column + position >7)||(row-position<0))
                    {
                        break;
                    }
                }
                if (position==4)
                {
                    //System.out.println("You won the game!");
                   // display(matrice);
                    break;
                }
            }
            if (position==4)
            {
                break;
            }
        }

        if(position!=4)
        {
            //display(matrice);
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
        String setBold = "\033[1m";


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
                {  System.out.println(setBold);
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
                {  System.out.println(setBold);
                    System.out.print(" Player " + fin + " won the game!");
                    break;
                }
                /*
                String setBold = "\033[1mThis keeps it bold.";
                System.out.println(setBold);
                String boldGrayLine = "\033[1mThis is a BOLD line\033[0m";
                System.out.println(boldGrayLine);*/

            }
        }
    }


}
