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



    public void fun1()
    {


        //Create and set up the window.
        JFrame frame = new JFrame("Recommended Movies");

        JButton goBackButton = new JButton("Go Back");
        JButton deleteButton = new JButton("Delete");
        JButton rateButton = new JButton("Rate");

        // Button
        deleteButton.setActionCommand("Delete");
        goBackButton.setActionCommand("Go Back");
        rateButton.setActionCommand("Rate");


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
        model.addElement(new Recommended.Movies("A Team", 1));
        model.addElement(new Recommended.Movies("B Team", 5));
        model.addElement(new Recommended.Movies("C Team", 2));
        model.addElement(new Recommended.Movies("D Team", 7));
        model.addElement(new Recommended.Movies("E Team", 3));
        model.addElement(new Recommended.Movies("F Team", 8));
        model.addElement(new Recommended.Movies("G Team", 5));
        model.addElement(new Recommended.Movies("H Team", 1));
        model.addElement(new Recommended.Movies("I Team", 9));
        model.addElement(new Recommended.Movies("J Team", 5));
        model.addElement(new Recommended.Movies("K Team", 5));
        model.addElement(new Recommended.Movies("L Team", 5));
        model.addElement(new Recommended.Movies("M Team", 5));
        model.addElement(new Recommended.Movies("N Team", 5));
        model.addElement(new Recommended.Movies("O Team", 5));
        model.addElement(new Recommended.Movies("P Team", 5));
        model.addElement(new Recommended.Movies("Q Team", 5));
        model.addElement(new Recommended.Movies("R Team", 5));
        model.addElement(new Recommended.Movies("S Team", 5));
        model.addElement(new Recommended.Movies("T Team", 5));
        model.addElement(new Recommended.Movies("U Team", 5));
        model.addElement(new Recommended.Movies("V Team", 5));
        model.addElement(new Recommended.Movies("X Team", 5));
        model.addElement(new Recommended.Movies("Y Team", 2));
        model.addElement(new Recommended.Movies("Z Team", 5));
        model.addElement(new Recommended.Movies("1 Team", 5));
        model.addElement(new Recommended.Movies("2 Team", 9));
        model.addElement(new Recommended.Movies("3 Team", 5));
        model.addElement(new Recommended.Movies("4 Team", 7));
        model.addElement(new Recommended.Movies("5 Team", 6));
        model.addElement(new Recommended.Movies("6 Team", 5));
        model.addElement(new Recommended.Movies("7 Team", 3));
        model.addElement(new Recommended.Movies("8 Team", 4));

        list.getSelectionModel().addListSelectionListener(e -> {
           Movies m = list.getSelectedValue();
           label.setText("Name: " + m.getName() + "         Rating: " + m.getRating());
        });

        //Creating panel
        splitPane.setLeftComponent(new JScrollPane(list));
        panel.add(label);

        //Textfield Rating Decleration
        final JTextField inputRating = new JTextField(50);
        panel.add(inputRating);
        inputRating.setText("Enter Rating");
        inputRating.setBounds(5,370,100,20);

        splitPane.setRightComponent(panel);

        panel.setLayout(null);
        //Set position of buttons and Movie Descriptions
        goBackButton.setBounds(120,400,100,20);
        deleteButton.setBounds(236,400,100,20);
        rateButton.setBounds(5, 400, 100, 20);
        label.setBounds(80, 5, 300, 40);
        //Create buttons on top of panel
        panel.add(goBackButton);
        panel.add(deleteButton);
        panel.add(rateButton);



        //Delete Button begin
        deleteButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

                int index = list.getSelectedIndex();
                model.remove(index);

                int size = model.getSize();


                if(size == 0) {
                    deleteButton.setEnabled(false);
                }
                else  {
                    if(index == model.getSize()) index--;
                }

                list.setSelectedIndex(index);
                list.ensureIndexIsVisible(index);

            }
        });

        //Delete Button end

        //Rate Button Begin
        rateButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String ratingInput = inputRating.getText();
                int rating = Integer.parseInt(ratingInput);


                int index = list.getSelectedIndex();    //Receives position of selected movie
                Movies movieSelected = list.getSelectedValue(); //Receives information on movie



                //Fill in code to send rating of the selected movie
                // to a function that will return movies
                // to be added into the recommendations list via some algorithm

            }
        });

        //Rate Button end

        //Go Back Button Begin
        goBackButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Intro object1 = new Intro();
                object1.fun1();
            }
        });
        //Go back Button end

    } //End function 1


}
