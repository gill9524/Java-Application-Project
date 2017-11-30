import javax.swing.*;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;
import java.util.Map;
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
        JButton dislikeButton = new JButton("Dislike");
        JButton likeButton = new JButton("Like");

        // Button
        deleteButton.setActionCommand("Delete");
        goBackButton.setActionCommand("Go Back");
        dislikeButton.setActionCommand("Dislike");
        likeButton.setActionCommand("Like");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        //frame.setContentPane(new Recommended() .goBackButton);
        JLabel emptyLabel = new JLabel("");

        // Declaration of panel and list
        JList<Movie> list = new JList();
        DefaultListModel<Movie> model = new DefaultListModel<> ();
        JLabel label = new JLabel();
        JPanel panel = new JPanel();
        JSplitPane splitPane = new JSplitPane();
        //emptyLabel.setPreferredSize(new Dimension(600, 450));
        frame.getContentPane().add(emptyLabel, BorderLayout.CENTER);


        //Display the window.
        // frame.pack();
        frame.add(splitPane);
        frame.setSize(900,650);
        frame.setVisible(true);
        splitPane.setDividerLocation(.4);
        list.setModel(model);

        // Add movies to list
        model.addElement(new Movie("Two Brothers: Pt. II", "2033", "9.9", "R", "Action"));
        model.addElement(new Movie("Mad Max: Fury Road", "2015", "8.6", "R", "Action", "Adventure", "Science Fiction", "Fantasy"));
        model.addElement(new Movie("Get Out", "2017", "8.3", "R", "Comedy", "Horror", "Mystery", "Suspense"));
        model.addElement(new Movie("The Third Man", "1949", "9.3", "NR", "Classics", "Mystery", "Suspense"));
        model.addElement(new Movie("Citizen Kane", "1941", "9.4", "PG", "Classics", "Drama", "Mystery", "Suspense"));
        model.addElement(new Movie("The Wizard of Oz", "1939", "9.4", "G", "Classics", "Kids", "Family", "Musical", "Performing Arts", "Science Fiction", "Fantasy"));

        // Populate movie info on Right panel
        list.getSelectionModel().addListSelectionListener(e -> {
           Movie m = list.getSelectedValue();
           label.setText("Name: " + m.getTitle() + "         Score: " + m.getScore());
        });

        //Creating panel
        splitPane.setLeftComponent(new JScrollPane(list));
        panel.add(label);

        /*Textfield Rating Decleration
        final JTextField inputRating = new JTextField(50);
        panel.add(inputRating);
        inputRating.setText("Enter Rating");
        inputRating.setBounds(5,370,100,20);
        */
        splitPane.setRightComponent(panel);

        panel.setLayout(null);
        //Set position of buttons and Movie Descriptions
        goBackButton.setBounds(280,580,100,20);
        deleteButton.setBounds(420,580,100,20);
        dislikeButton.setBounds(5, 580, 100, 20);
        likeButton.setBounds(140, 580, 100, 20);

        label.setBounds(80, 5, 300, 40);
        //Create buttons on top of panel
        panel.add(goBackButton);
        panel.add(deleteButton);
        panel.add(dislikeButton);
        panel.add(likeButton);



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

        //Dislike Button Begin
        dislikeButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                //String ratingInput = inputRating.getText();
                //int rating = Integer.parseInt(ratingInput);


                int index = list.getSelectedIndex();    //Receives position of selected movie
                Movie movieSelected = list.getSelectedValue(); //Receives information on movie
                System.out.println("Movie " + movieSelected.getTitle() + " disliked");


                //Fill in code to send rating of the selected movie
                // to a function that will return movies
                // to be added into the recommendations list via some algorithm

            }
        });

        //dislike Button end

        //Dislike Button Begin
        likeButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                //String ratingInput = inputRating.getText();
                //int rating = Integer.parseInt(ratingInput);


                int index = list.getSelectedIndex();    //Receives position of selected movie
                Movie movieSelected = list.getSelectedValue(); //Receives information on movie
                System.out.println("Movie " + movieSelected.getTitle() + " liked");


                //Fill in code to send rating of the selected movie
                // to a function that will return movies
                // to be added into the recommendations list via some algorithm

            }
        });

        //dislike Button end

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
