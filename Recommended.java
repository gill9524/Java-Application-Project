import javax.swing.*;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.*;
import java.util.ArrayList;
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

        // Declaration of panel and list
        JList<String> list = new JList();
        DefaultListModel<String> model = new DefaultListModel<> ();
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


        //like Button Begin
        likeButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                //String ratingInput = inputRating.getText();
                //int rating = Integer.parseInt(ratingInput);


                int index = list.getSelectedIndex();    //Receives position of selected movie
                // Movie movieSelected = list.getSelectedValue(); //Receives information on movie
                // System.out.println("Movie " + movieSelected.getTitle() + " liked");

                List<String> recommendedList = new ArrayList<String>();
                List<String> listToWrite = new ArrayList<String>();


                //**************** Call The Algorithm Here ****************//
                //*********Get the result into listToWrite array *********//

                //Calls function to write data from array to file
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

        //read from file to add into list
        List<String> RecoList = new ArrayList<String>();
        try{
            RecoList = RandomAccessFileEx( RecoList, "" , 0);

        }
        catch(IOException ie) {
            ie.printStackTrace();
        }

        // Add movies to list
        for(int i = 0; i < RecoList.size(); i++)
        {
            model.addElement(RecoList.get(i));

        }
        /*
        model.addElement(new Movie("Two Brothers: Pt. II", "2033", "9.9", "R", "Action"));
        model.addElement(new Movie("Mad Max: Fury Road", "2015", "8.6", "R", "Action", "Adventure", "Science Fiction", "Fantasy"));
        model.addElement(new Movie("Get Out", "2017", "8.3", "R", "Comedy", "Horror", "Mystery", "Suspense"));
        model.addElement(new Movie("The Third Man", "1949", "9.3", "NR", "Classics", "Mystery", "Suspense"));
        model.addElement(new Movie("Citizen Kane", "1941", "9.4", "PG", "Classics", "Drama", "Mystery", "Suspense"));
        model.addElement(new Movie("The Wizard of Oz", "1939", "9.4", "G", "Classics", "Kids", "Family", "Musical", "Performing Arts", "Science Fiction", "Fantasy"));
        */
        // Populate movie info on Right panel
        list.getSelectionModel().addListSelectionListener(e -> {
           String m = list.getSelectedValue();
           label.setText("Name: " + m);//.getTitle() + "         Score: " + m.getScore());
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
        likeButton.setBounds(140, 580, 100, 20);

        label.setBounds(80, 5, 300, 40);
        //Create buttons on top of panel
        panel.add(goBackButton);
        panel.add(deleteButton);
        panel.add(likeButton);



        //Delete Button begin
        deleteButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

                String selectedValue = list.getSelectedValue();

                List<String> recommendedList = new ArrayList<String>();
                List<String> listToWrite = new ArrayList<String>();

                try{
                    recommendedList = RandomAccessFileEx( listToWrite, selectedValue , 2);

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
