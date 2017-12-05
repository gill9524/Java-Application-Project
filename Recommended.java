import javax.swing.*;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.*;
import java.util.ArrayList;
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
    //Function to read, write, or delete recommended items in file
    // Action 0 is read, 1 is write, 2 is delete
    public List<String> RandomAccessFileEx( List<String> data1, String data,  int action)
    throws IOException{

         String Filepath = "/Volumes/Transcend/IdeaProjects/src/Recommended.txt";

         File inputFile = new File("/Volumes/Transcend/IdeaProjects/src/Recommended.txt");
         File tempFile = new File("/Volumes/Transcend/IdeaProjects/src/tempFile.txt");


            String line = null;

            List<String> recommendedList = new ArrayList<String>();

            //Write to Data file
            if(action == 1) {

                FileWriter filewriter = new FileWriter(Filepath, true);

                BufferedWriter bufferedWriter = new BufferedWriter(filewriter);

                for (int i = 0; i < data1.size(); i++) {
                    bufferedWriter.write(data1.get(i));
                    bufferedWriter.newLine();

                }
                System.out.println("File written successfully");

                bufferedWriter.close();


            }
            //Read Data from file
            else if (action == 0)
            {
                BufferedReader bufferReader = new BufferedReader(new FileReader(Filepath));
                //Reads all lines from file
                while((line = bufferReader.readLine()) != null)
                {
                    recommendedList.add(line);
                }
                bufferReader.close();
                return recommendedList;
            }

            //Delete data from file
            else if (action == 2) {
                System.out.println("Delete completed");

                String lineToRemove = data;
                String currentLine;
                BufferedReader bufferedReader = new BufferedReader(new FileReader(Filepath));

                FileWriter filewriter = new FileWriter("/Volumes/Transcend/IdeaProjects/src/tempFile.txt");

                BufferedWriter bufferedWriter = new BufferedWriter(filewriter);


                while((currentLine = bufferedReader.readLine()) != null) {
                    String trimmedLine = currentLine.trim();
                    if(trimmedLine.equals(lineToRemove)) continue;
                    bufferedWriter.write(currentLine);
                    bufferedWriter.newLine();




                }

                bufferedWriter.close();
                bufferedReader.close();

                tempFile.renameTo(inputFile);

            }


            return recommendedList;
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
        frame.setSize(900,650);
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


                List<String> recommendedList = new ArrayList<String>();
                List<String> listToWrite = new ArrayList<String>();

                try{
                    recommendedList = RandomAccessFileEx( listToWrite, "A team" , 2);

                }
                catch(IOException ie) {
                    ie.printStackTrace();
                }

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
                Recommended.Movies movieSelected = list.getSelectedValue(); //Receives information on movie
                System.out.println("Movie " + movieSelected.getName() + " disliked");


                //Fill in code to send rating of the selected movie
                // to a function that will return movies
                // to be added into the recommendations list via some algorithm

            }
        });

        //dislike Button end

        //like Button Begin
        likeButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                //String ratingInput = inputRating.getText();
                //int rating = Integer.parseInt(ratingInput);


                int index = list.getSelectedIndex();    //Receives position of selected movie
                Recommended.Movies movieSelected = list.getSelectedValue(); //Receives information on movie
                System.out.println("Movie " + movieSelected.getName() + " liked");

                List<String> recommendedList = new ArrayList<String>();
                List<String> listToWrite = new ArrayList<String>();
                listToWrite.add("A team");
                listToWrite.add("B team");
                listToWrite.add("C team");
                listToWrite.add("D team");
                listToWrite.add("E team");
                listToWrite.add("F team");

                try{
                    recommendedList = RandomAccessFileEx( listToWrite, "" , 1);

                }
                catch(IOException ie) {
                ie.printStackTrace();
                }

                //Fill in code to send rating of the selected movie
                // to a function that will return movies
                // to be added into the recommendations list via some algorithm

            }
        });

        //like Button end

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
