package gamess;

import javax.swing.*;
import javax.swing.border.Border;
import java.awt.*;
import java.awt.event.*;

public class BoardGUI extends JFrame
{

    private JPanel panel1;
    private JButton OKButton;
    private JTextField playerSelectYourColumnTextField;
    private JPanel Board;
    private JLabel lbl;
    private JButton newgame;
    final JLabel[][] label = new JLabel[8][8];
    Border border = BorderFactory.createLineBorder(Color.BLACK, 1);
    Board j = new Board();

    int move=0;

    public  BoardGUI() throws HeadlessException
    {
        Board.setSize(400, 400);
        Board.setLayout(new GridLayout(8, 8, 5, 5));

        Board.setComponentOrientation(ComponentOrientation.LEFT_TO_RIGHT);
        for (int i = 0; i < label.length; i++) {
            for (int j = 0; j < label.length; j++) {
                label[i][j] = new JLabel();
                label[i][j].setHorizontalTextPosition(JLabel.CENTER);
                label[i][j].setVerticalTextPosition(JLabel.CENTER);
                label[i][j].setBorder(border);
                label[i][j].setText(" [ ] ");
                Board.add(label[i][j], i, j);
            }
        }



       /* OKButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                //Scanner in = new Scanner(System.in);
                //int ch = in.nextInt();
                int ch = Integer.parseInt(playerSelectYourColumnTextField.getText());
                JOptionPane.showMessageDialog(null," Clicked OK!! "+" Coloana selectata este: "+ch );
                label[5][5].setText(" x ");
                label[5][5].setBackground(Color.red);
                label[5][5].setOpaque(true);





            }
        });*/

        newgame.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                JOptionPane.showMessageDialog(null, "START NEW GAME", "New Game",JOptionPane.QUESTION_MESSAGE);
                Board.setComponentOrientation(ComponentOrientation.LEFT_TO_RIGHT);
                for (int i = 0; i < label.length; i++) {
                    for (int j = 0; j < label.length; j++) {
                        label[i][j].setForeground(Color.GRAY);
                        label[i][j].setText(" [ ] ");
                        label[i][j].setBackground(Color.gray);
                        label[i][j].setOpaque(false);

                    }

                }
                OKButton.setVisible(true);
                playerSelectYourColumnTextField.setVisible(true);
                lbl.setText("Player 1 choose the column!");
                newgame.setVisible(false);

            }
        });



        final BoardGUI self = this;
        OKButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                int player=0;
                int winner = 0;

                int choice = Integer.parseInt(playerSelectYourColumnTextField.getText());
                move++;
                if (move%2==0)

                {
                    lbl.setText("Player 1 choose the column!");
                    player = 2;
                }


                else if (move%2!=0)
                {
                    lbl.setText("Player 2 choose the column!");
                    player =1;
                }

                winner =j.complete(choice,player,self);

                if (winner!=0) {
                    JOptionPane.showMessageDialog(null, "Player " + player + " won the game", "WINNNER", JOptionPane.WARNING_MESSAGE);
                    OKButton.setVisible(false);
                    playerSelectYourColumnTextField.setVisible(false);
                    lbl.setText("Player " + player + " won the game");
                    newgame.setVisible(true);
                    move=0;

                  }


            }
        });

    /*    OKButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

                move++;
                int choice = 0;// players` option
                int player = 0;
                int fin = 0;
                if (move % 2 != 0) {

                    choice = Integer.parseInt(playerSelectYourColumnTextField.getText());
                    player = 1;
                    fin = complete(choice, player);
                    if (fin != 0) {
                        JOptionPane.showMessageDialog(null, "Player " + player + " won the game","WINNNER",JOptionPane.WARNING_MESSAGE);
                        OKButton.setVisible(false);
                        playerSelectYourColumnTextField.setVisible(false);
                        lbl.setText("Player " + player + " won the game");
                        newgame.setVisible(true);



                    }else  start(move);

                } else if (move % 2 == 0) {

                    choice = Integer.parseInt(playerSelectYourColumnTextField.getText());
                    player = 2;

                    fin = complete(choice, player);
                    if (fin != 0) {
                       JOptionPane.showMessageDialog(null, "Player " + player + " won the game","WINNNER",JOptionPane.WARNING_MESSAGE);
                        OKButton.setVisible(false);
                        playerSelectYourColumnTextField.setVisible(false);
                        lbl.setText("Player " + player + " won the game");
                        newgame.setVisible(true);

                    }else  start(move);

                }
                  playerSelectYourColumnTextField.setText(null)
            }
        });
*/

        panel1.addComponentListener(new ComponentAdapter() {
        });
        playerSelectYourColumnTextField.addKeyListener(new KeyAdapter()
        { @Override
          public void keyPressed(KeyEvent e)
            {
                if(e.getKeyCode()==KeyEvent.VK_ENTER)
                {
                    //JOptionPane.showMessageDialog(null," Pressed");
                    OKButton.doClick();
                }
            }
        });
    }



    /*
    int see=0;
    int see2=0;
    int move = 0;// check the turn of the players
    public void start(int move)

    {
        if (move % 2 != 0) {

            lbl.setText("Player 2 choose the column!");

        } else if (move % 2 == 0)
        {
            lbl.setText("Player 1 choose the column!");
        }

        }


    public int complete(int choice, int player) {
        boolean wonh = false;
        boolean wonv = false;
        boolean wondl = false;
        boolean wondr = false;
        String pl="";
        String txt = "";

        for (int row = 0; row < 8; row++) {
            txt = label[row][choice - 1].getText();

            if (txt == " [ ] ") {
                switch (player) {
                    case 1:
                        pl = "  x ";
                        label[row][choice - 1].setForeground(Color.ORANGE);
                        label[row][choice - 1].setText("  x ");
                        label[row][choice - 1].setBackground(Color.ORANGE);
                        label[row][choice - 1].setOpaque(true);

                        wonh = win_horizontal(pl);
                        wonv = win_vertical(pl);
                          wondl = win_downleft(pl);
                          wondr = win_downright(pl);

                          if ((wonh == true) || (wonv == true) || (wondl == true) || (wondr == true)) {
                              return player;
                          }

                        break;
                    case 2:
                        pl = "  o ";
                        label[row][choice - 1].setForeground(Color.PINK);
                        label[row][choice - 1].setText("  o ");

                        label[ row][choice - 1].setBackground(Color.PINK);
                        label[row][choice - 1].setOpaque(true);
                       wonh = win_horizontal(pl);
                        wonv = win_vertical(pl);
                        wondl = win_downleft(pl);
                       wondr = win_downright(pl);

                       if ((wonh == true) || (wonv == true) || (wondl == true) || (wondr == true)) {
                           return player;
                       }

                        break;
                }
                break;
            }
        }
        return 0;
    }
    public boolean win_horizontal(String player)
    {
        for (int row = 0; row < 8; row++) {
            for (int column = 0; column < 8; column++) {
                if (label[row][column].getText()==player) {
                    see++;
                   if (see == 4) {

                        break;
                    }
                } else if (!label[row][column].equals(player))
                    see = 0;
            }
            if (see == 4) {
                break;
            }
        }
        if (see != 4)
        {

            return false;
        }
        else return true;
    }
    private boolean win_vertical(String player)
    {
        for(int column=0; column<8; column++) {
            for (int row = 0; row < 8; row++) {
                if (label[row][column].getText()==player) {
                    see++;

                    if (see == 4) {

                        break;
                    }
                } else if (label[row][column].getText()!=player && (see != 4))
                    see = 0;
            }
            if (see == 4) {
                break;
            }
        }

        if(see!=4)
        {
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

                while (label[row - position][column - position].getText()==player && position < 4)
                {
                    position++;

                    if ((column - position < 0)||(row-position<0))
                    {
                        break;
                    }
                }
                if (position==4)
                {
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

                while (label[row-position][column + position].getText()==player && position < 4)
                {
                    position++;


                    if ((column + position >7)||(row-position<0))
                    {
                        break;
                    }
                }
                if (position==4)
                {

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

            return false;
        }
        else return true;

    }*/



    public void colorCell(int row, int column, String player) {

        if ( player == "  x ") {

            label[row][column].setForeground(Color.ORANGE);
            label[row][column].setText("  x ");
            label[row][column].setBackground(Color.ORANGE);
            label[row][column].setOpaque(true);
        }
        else if (player =="  o "){
            label[row][column].setForeground(Color.PINK);
            label[row][column].setText("  o ");
            label[ row][column].setBackground(Color.PINK);
            label[row][column].setOpaque(true);
        }

    }




    public static void main(String[] args)
    {
        JFrame frame = new JFrame("Game");
        frame.setContentPane(new BoardGUI().panel1);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);


        //frame.setSize(800,800);


        /*Panel panel1=new Panel();
        Label[][] label = new Label[8][8];

        panel1.setSize(400,400);
        panel1.setLayout(new GridLayout(8,8,5,5));

        panel1.setComponentOrientation(ComponentOrientation.LEFT_TO_RIGHT);
        for (int i = 0; i<label.length; i++)
            for (int j = 0; j< label.length;j++)
            {
                label[i][j]=new Label();
                label[i][j].setText(" [ ] ");
                panel1.add(label[i][j],i,j);

            }

        Panel panel2=new Panel();
        JLabel textLabel = new JLabel("Welcome - Start game!",SwingConstants.CENTER);

        JTextField txt = new JTextField();

        JButton bot =new JButton();
        bot.setText(" OK ");

        panel2.add(textLabel);

        panel2.add(txt);
        panel2.add(bot);

        frame.getContentPane().add(panel2, BorderLayout.NORTH);
        frame.getContentPane().add(panel1, BorderLayout.CENTER);*/





        frame.pack();
        frame.setLocationRelativeTo(null);
        frame.setAlwaysOnTop(true);
        frame.setVisible(true);
        frame.setAlwaysOnTop(false);




    }
}



