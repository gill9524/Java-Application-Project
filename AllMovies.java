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



        list.setModel(model);
        //Add movies to list
        model.addElement(new AllMovies.Movies("A Team", 1));
        model.addElement(new AllMovies.Movies("B Team", 5));
        model.addElement(new AllMovies.Movies("C Team", 2));
        model.addElement(new AllMovies.Movies("D Team", 7));
        model.addElement(new AllMovies.Movies("E Team", 3));
        model.addElement(new AllMovies.Movies("F Team", 8));
        model.addElement(new AllMovies.Movies("G Team", 5));
        model.addElement(new AllMovies.Movies("H Team", 1));
        model.addElement(new AllMovies.Movies("I Team", 9));
        model.addElement(new AllMovies.Movies("J Team", 5));
        model.addElement(new AllMovies.Movies("K Team", 5));
        model.addElement(new AllMovies.Movies("L Team", 5));
        model.addElement(new AllMovies.Movies("M Team", 5));
        model.addElement(new AllMovies.Movies("N Team", 5));
        model.addElement(new AllMovies.Movies("O Team", 5));
        model.addElement(new AllMovies.Movies("P Team", 5));
        model.addElement(new AllMovies.Movies("Q Team", 5));
        model.addElement(new AllMovies.Movies("R Team", 5));
        model.addElement(new AllMovies.Movies("S Team", 5));
        model.addElement(new AllMovies.Movies("T Team", 5));
        model.addElement(new AllMovies.Movies("U Team", 5));
        model.addElement(new AllMovies.Movies("V Team", 5));
        model.addElement(new AllMovies.Movies("X Team", 5));
        model.addElement(new AllMovies.Movies("Y Team", 2));
        model.addElement(new AllMovies.Movies("Z Team", 5));
        model.addElement(new AllMovies.Movies("1 Team", 5));
        model.addElement(new AllMovies.Movies("2 Team", 9));
        model.addElement(new AllMovies.Movies("3 Team", 5));
        model.addElement(new AllMovies.Movies("4 Team", 7));
        model.addElement(new AllMovies.Movies("5 Team", 6));
        model.addElement(new AllMovies.Movies("6 Team", 5));
        model.addElement(new AllMovies.Movies("7 Team", 3));
        model.addElement(new AllMovies.Movies("8 Team", 4));

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


    } //End function 1

}
