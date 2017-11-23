import javax.swing.*;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;
import javax.swing.JScrollPane;
import javax.swing.SwingUtilities;
import javax.swing.DefaultListModel;



public class Recommended {

    private JButton goBackButton;



    //Class for movies
    private class Movies{
        String name;
        int rating;

        public Movies(String name, int rating){
            this.name = name;
            this.rating = rating;
        }

        public String getName() {
            return name;
        }

        public int getRating() {
            return rating;
        }

        public void setName() {
            this.name = name;
        }

        public void setRating() {
            this.rating = rating;
        }

        @Override
        public String toString() {
            return name;
        }



    }
/*
    public Recommended() {

        //Go Back Button Listener
        goBackButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Intro object1 = new Intro();
                object1.fun1();
            }
        });
    }
*/


    public void fun1()
    {


        //Create and set up the window.
        JFrame frame = new JFrame("Recommended Movies");

        JButton goBackButton = new JButton("Go Back");
        JButton rateButton = new JButton("Rate!");



        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        //frame.setContentPane(new Recommended() .goBackButton);

        JLabel emptyLabel = new JLabel("");

        //Declaration of panel and list
        JList<Movies> list = new JList();
        DefaultListModel<Movies> model = new DefaultListModel<> ();

        JLabel label = new JLabel();
        JPanel panel = new JPanel();

        JSplitPane splitPane = new JSplitPane();


        //emptyLabel.setPreferredSize(new Dimension(600, 450));
        frame.getContentPane().add(emptyLabel, BorderLayout.CENTER);


        //Display the window.
        // frame.pack();
        frame.add(splitPane);
        frame.setSize(600,450);
        frame.setVisible(true);

        splitPane.setDividerLocation(.4);



        list.setModel(model);
        //Add movies to list
        model.addElement(new Movies("A Team", 1));
        model.addElement(new Movies("A Team", 5));
        model.addElement(new Movies("A Team", 2));
        model.addElement(new Movies("A Team", 7));
        model.addElement(new Movies("A Team", 3));
        model.addElement(new Movies("A Team", 8));
        model.addElement(new Movies("A Team", 5));
        model.addElement(new Movies("A Team", 1));
        model.addElement(new Movies("A Team", 9));
        model.addElement(new Movies("A Team", 5));
        model.addElement(new Movies("A Team", 5));
        model.addElement(new Movies("A Team", 5));
        model.addElement(new Movies("A Team", 5));
        model.addElement(new Movies("A Team", 5));
        model.addElement(new Movies("A Team", 5));
        model.addElement(new Movies("A Team", 5));
        model.addElement(new Movies("A Team", 5));
        model.addElement(new Movies("A Team", 5));
        model.addElement(new Movies("A Team", 5));
        model.addElement(new Movies("A Team", 5));
        model.addElement(new Movies("A Team", 5));
        model.addElement(new Movies("A Team", 5));
        model.addElement(new Movies("A Team", 5));
        model.addElement(new Movies("A Team", 2));
        model.addElement(new Movies("A Team", 5));
        model.addElement(new Movies("A Team", 5));
        model.addElement(new Movies("A Team", 9));
        model.addElement(new Movies("A Team", 5));
        model.addElement(new Movies("A Team", 7));
        model.addElement(new Movies("A Team", 6));
        model.addElement(new Movies("A Team", 5));
        model.addElement(new Movies("A Team", 3));
        model.addElement(new Movies("A Team", 4));

        list.getSelectionModel().addListSelectionListener(e -> {
           Movies m = list.getSelectedValue();
           label.setText("Name: " + m.getName() + "         Rating: " + m.getRating());
           panel.add(rateButton);
        });

        //Creating panel
        splitPane.setLeftComponent(new JScrollPane(list));
        panel.add(label);

        splitPane.setRightComponent(panel);

        panel.setLayout(null);
        //Set position of buttons and Movie Descriptions
        goBackButton.setBounds(120,400,100,20);
        rateButton.setBounds(800,20,100,20);
        label.setBounds(80, 5, 300, 40);
        //Create buttons on top of panel
        panel.add(goBackButton);

    }

    private void createUIComponents() {
        // TODO: place custom component creation code here

    }
}
