import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;


import java.io.IOException;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class AllMovies {
    private JButton goBackButton;

    public AllMovies()  {
        goBackButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Intro object1 = new Intro();
                object1.fun1();
            }
        });
    }

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



        //GUI
        //--------------------------------------------------------------------------------
        //Create and set up the window.
        JFrame frame = new JFrame("AllMovies Movies");

        JButton goBackButton = new JButton("Go Back");
        JButton deleteButton = new JButton("Delete");
        JButton rateButton = new JButton("Rate");


        //Delete Button
        deleteButton.setActionCommand("Delete");
        goBackButton.setActionCommand("Go Back");
        rateButton.setActionCommand("Rate");



        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        //frame.setContentPane(new AllMovies() .goBackButton);

        JLabel emptyLabel = new JLabel("");

        //Declaration of panel and list
        JList<AllMovies.Movies> list = new JList();
        DefaultListModel<AllMovies.Movies> model = new DefaultListModel<> ();

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

        //Add Movies to list
        list.setModel(model);
        //Read file in
        try {

            readFile inputFile = new readFile();
            String[] lines = inputFile.readLines("/Volumes/Transcend/IdeaProjects/src/myFile.txt");
            for(String line : lines) {
                System.out.println(line);
                //display to list
                model.addElement(new AllMovies.Movies(line, 1));

            }

        } catch(IOException ie) {
            ie.printStackTrace();
        }



        list.getSelectionModel().addListSelectionListener(e -> {
            AllMovies.Movies m = list.getSelectedValue();
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
                AllMovies.Movies movieSelected = list.getSelectedValue(); //Receives information on movie



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
        //-----------------------------------------------------------------------------------------
        //GUI END

    } //End function 1

}
