package Jocurilee;

import javax.swing.*;
import java.awt.*;

public class BoardGUI extends JFrame
{

    private JPanel panel1;
    private JButton OKButton;
    private JTextField playerSelectYourColumnTextField;

    public static void main(String[] args)
    {
        JFrame frame = new JFrame("Game");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        frame.setSize(2000,2000);


        Panel panel1=new Panel();
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
        frame.getContentPane().add(panel1, BorderLayout.CENTER);




        frame.setLocationRelativeTo(null);
        frame.pack();
        frame.setVisible(true);


    }
}



