

import java.awt.*;
import java.awt.event.*;
import java.io.IOException;
import javax.swing.*;

public class Intro {

    private JPanel panel1;
    private JButton recommendedMoviesButton;
    private JButton showAllMoviesButton;
    private JButton exitButton;

    public Intro()
    {




        recommendedMoviesButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Recommended object3 = new Recommended();

                object3.fun1();
            }
        });
        exitButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
            System.exit(0);
            }
        });
        showAllMoviesButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                AllMovies object2 = new AllMovies();
                object2.fun1();
            }
        });
    }

    public void fun1()
    {
        //Create and set up the window.
        JFrame frame = new JFrame("PopCorn Time");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setContentPane(new Intro() .panel1);
        JLabel emptyLabel = new JLabel("");
        emptyLabel.setPreferredSize(new Dimension(600, 450));

        frame.setSize(600,450);
        //Display the window.
        //frame.pack();
        frame.setVisible(true);



    }



}
