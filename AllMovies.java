import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class AllMovies {
    private JButton goBackButton;

    public AllMovies() {
        goBackButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Intro object1 = new Intro();
                object1.fun1();
            }
        });
    }

    public void fun1()
    {
        //Create and set up the window.
        JFrame frame = new JFrame("All Movies");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setContentPane(new AllMovies() .goBackButton);

        JLabel emptyLabel = new JLabel("");
        //emptyLabel.setPreferredSize(new Dimension(600, 450));
        frame.getContentPane().add(emptyLabel, BorderLayout.CENTER);

        //Display the window.
        frame.setSize(600,450);
       // frame.pack();
        frame.setVisible(true);
    }
}
