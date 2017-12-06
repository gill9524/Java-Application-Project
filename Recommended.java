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

<<<<<<< HEAD
        String Filepath = "/Volumes/Transcend/IdeaProjects/src/Recommended.txt";

        File inputFile = new File("/Volumes/Transcend/IdeaProjects/src/Recommended.txt");
        File tempFile = new File("/Volumes/Transcend/IdeaProjects/src/tempFile.txt");
=======
        String Filepath = "/Users/MAG/SJSU/2017Fall/CMPE 130/Project/130Project/Recommended.txt";

        File inputFile = new File("/Users/MAG/SJSU/2017Fall/CMPE 130/Project/130Project/Recommended.txt");
        File tempFile = new File("/Users/MAG/SJSU/2017Fall/CMPE 130/Project/130Project/tempFile.txt");
>>>>>>> Mike-branch


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
            System.out.println("Successful");

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
            System.out.println("Successful");

            String lineToRemove = data;
            String currentLine;
            BufferedReader bufferedReader = new BufferedReader(new FileReader(Filepath));

<<<<<<< HEAD
            FileWriter filewriter = new FileWriter("/Volumes/Transcend/IdeaProjects/src/tempFile.txt");
=======
            FileWriter filewriter = new FileWriter("/Users/MAG/SJSU/2017Fall/CMPE 130/Project/130Project/tempFile.txt");
>>>>>>> Mike-branch

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


        //Make Graph
        int vertices = 150;

        //Initialize Graph
        Graph graph = new Graph(vertices);
        for(int i = 0; i < vertices; i++){
            for(int j = 0; j < vertices; j++){
                graph.makeEdge(i, j, 0);
            }
        }

        //User1
        //graph.makeEdge(0, 0, 1);
        graph.makeEdge(0, 7, 1);
        graph.makeEdge(0, 8, 1);
        graph.makeEdge(0, 10, 1);
        graph.makeEdge(0, 14, 1);
        graph.makeEdge(0, 19, 1);
        graph.makeEdge(0, 20, 1);
        graph.makeEdge(0, 21, 1);
        graph.makeEdge(0, 42, 1);
        graph.makeEdge(0, 45, 1);
        graph.makeEdge(0, 46, 1);
        graph.makeEdge(0, 54, 1);
        graph.makeEdge(0, 72, 1);
        graph.makeEdge(0, 86, 1);

        graph.makeEdge(7, 0, 1);
        graph.makeEdge(8, 0, 1);
        graph.makeEdge(10, 0, 1);
        graph.makeEdge(14, 0, 1);
        graph.makeEdge(19, 0, 1);
        graph.makeEdge(20, 0, 1);
        graph.makeEdge(21, 0, 1);
        graph.makeEdge(42, 0, 1);
        graph.makeEdge(45, 0, 1);
        graph.makeEdge(46, 0, 1);
        graph.makeEdge(54, 0, 1);
        graph.makeEdge(72, 0, 1);
        graph.makeEdge(86, 0, 1);

        //User2
        //graph.makeEdge(1, 1, 1);
        graph.makeEdge(1, 2, 1);
        graph.makeEdge(1, 3, 1);
        graph.makeEdge(1, 5, 1);
        graph.makeEdge(1, 17, 1);
        graph.makeEdge(1, 18, 1);
        graph.makeEdge(1, 24, 1);
        graph.makeEdge(1, 32, 1);
        graph.makeEdge(1, 39, 1);
        graph.makeEdge(1, 43, 1);
        graph.makeEdge(1, 49, 1);
        graph.makeEdge(1, 55, 1);
        graph.makeEdge(1, 62, 1);
        graph.makeEdge(1, 66, 1);
        graph.makeEdge(1, 69, 1);
        graph.makeEdge(1, 71, 1);
        graph.makeEdge(1, 76, 1);
        graph.makeEdge(1, 77, 1);

        graph.makeEdge(2, 1, 1);
        graph.makeEdge(3, 1, 1);
        graph.makeEdge(5, 1, 1);
        graph.makeEdge(17, 1, 1);
        graph.makeEdge(18, 1, 1);
        graph.makeEdge(24, 1, 1);
        graph.makeEdge(32, 1, 1);
        graph.makeEdge(39, 1, 1);
        graph.makeEdge(43, 1, 1);
        graph.makeEdge(49, 1, 1);
        graph.makeEdge(55, 1, 1);
        graph.makeEdge(62, 1, 1);
        graph.makeEdge(66, 1, 1);
        graph.makeEdge(69, 1, 1);
        graph.makeEdge(71, 1, 1);
        graph.makeEdge(76, 1, 1);
        graph.makeEdge(77, 1, 1);

        //User3
        graph.makeEdge(2, 4, 1);
        graph.makeEdge(2, 23, 1);
        graph.makeEdge(2, 33, 1);
        graph.makeEdge(2, 36, 1);
        graph.makeEdge(2, 41, 1);
        graph.makeEdge(2, 70, 1);
        graph.makeEdge(2, 80, 1);
        graph.makeEdge(2, 83, 1);
        graph.makeEdge(2, 87, 1);
        graph.makeEdge(2, 92, 1);
        graph.makeEdge(2, 95, 1);

        graph.makeEdge(4, 2, 1);
        graph.makeEdge(23, 2, 1);
        graph.makeEdge(33, 2, 1);
        graph.makeEdge(36, 2, 1);
        graph.makeEdge(41, 2, 1);
        graph.makeEdge(70, 2, 1);
        graph.makeEdge(80, 2, 1);
        graph.makeEdge(83, 2, 1);
        graph.makeEdge(87, 2, 1);
        graph.makeEdge(92, 2, 1);
        graph.makeEdge(95, 2, 1);

        //User4
        //graph.makeEdge(103, 3, 1);
        graph.makeEdge(3, 5, 1);
        graph.makeEdge(3, 17, 1);
        graph.makeEdge(3, 19, 1);
        graph.makeEdge(3, 32, 1);
        graph.makeEdge(3, 46, 1);
        graph.makeEdge(3, 49, 1);
        graph.makeEdge(3, 64, 1);
        graph.makeEdge(3, 67, 1);
        graph.makeEdge(3, 68, 1);
        graph.makeEdge(3, 73, 1);
        graph.makeEdge(3, 89, 1);

        graph.makeEdge(5, 3, 1);
        graph.makeEdge(17, 3, 1);
        graph.makeEdge(19, 3, 1);
        graph.makeEdge(32, 3, 1);
        graph.makeEdge(46, 3, 1);
        graph.makeEdge(49, 3, 1);
        graph.makeEdge(64, 3, 1);
        graph.makeEdge(67, 3, 1);
        graph.makeEdge(68, 3, 1);
        graph.makeEdge(73, 3, 1);
        graph.makeEdge(89, 3, 1);

        //User5
        graph.makeEdge(4, 0, 1);
        graph.makeEdge(4, 7, 1);
        graph.makeEdge(4, 10, 1);
        graph.makeEdge(4, 20, 1);
        graph.makeEdge(4, 41, 1);
        graph.makeEdge(4, 42, 1);
        graph.makeEdge(4, 44, 1);
        graph.makeEdge(4, 45, 1);
        graph.makeEdge(4, 54, 1);
        graph.makeEdge(4, 74, 1);
        graph.makeEdge(4, 81, 1);
        graph.makeEdge(4, 86, 1);

        graph.makeEdge(0, 4, 1);
        graph.makeEdge(7, 4, 1);
        graph.makeEdge(10, 4, 1);
        graph.makeEdge(20, 4, 1);
        graph.makeEdge(41, 4, 1);
        graph.makeEdge(42, 4, 1);
        graph.makeEdge(44, 4, 1);
        graph.makeEdge(45, 4, 1);
        graph.makeEdge(54, 4, 1);
        graph.makeEdge(74, 4, 1);
        graph.makeEdge(81, 4, 1);
        graph.makeEdge(86, 4, 1);

        //User6
        graph.makeEdge(5, 9, 1);
        graph.makeEdge(5, 13, 1);
        graph.makeEdge(5, 25, 1);
        graph.makeEdge(5, 31, 1);
        graph.makeEdge(5, 34, 1);
        graph.makeEdge(5, 37, 1);
        graph.makeEdge(5, 52, 1);
        graph.makeEdge(5, 56, 1);
        graph.makeEdge(5, 59, 1);
        graph.makeEdge(5, 61, 1);
        graph.makeEdge(5, 75, 1);
        graph.makeEdge(5, 85, 1);
        graph.makeEdge(5, 94, 1);
        graph.makeEdge(5, 96, 1);
        graph.makeEdge(5, 98, 1);
        graph.makeEdge(5, 99, 1);

        graph.makeEdge(9, 5, 1);
        graph.makeEdge(13, 5, 1);
        graph.makeEdge(25, 5, 1);
        graph.makeEdge(31, 5, 1);
        graph.makeEdge(34, 5, 1);
        graph.makeEdge(37, 5, 1);
        graph.makeEdge(52, 5, 1);
        graph.makeEdge(56, 5, 1);
        graph.makeEdge(59, 5, 1);
        graph.makeEdge(61, 5, 1);
        graph.makeEdge(75, 5, 1);
        graph.makeEdge(85, 5, 1);
        graph.makeEdge(94, 5, 1);
        graph.makeEdge(96, 5, 1);
        graph.makeEdge(98, 5, 1);
        graph.makeEdge(99, 5, 1);

        //User7
        graph.makeEdge(6, 11, 1);
        graph.makeEdge(6, 12, 1);
        graph.makeEdge(6, 14, 1);
        graph.makeEdge(6, 16, 1);
        graph.makeEdge(6, 21, 1);
        graph.makeEdge(6, 48, 1);
        graph.makeEdge(6, 56, 1);
        graph.makeEdge(6, 59, 1);
        graph.makeEdge(6, 61, 1);
        graph.makeEdge(6, 72, 1);
        graph.makeEdge(6, 80, 1);
        graph.makeEdge(6, 88, 1);
        graph.makeEdge(6, 94, 1);
        graph.makeEdge(6, 96, 1);
        graph.makeEdge(6, 97, 1);

        graph.makeEdge(11, 6, 1);
        graph.makeEdge(12, 6, 1);
        graph.makeEdge(14, 6, 1);
        graph.makeEdge(16, 6, 1);
        graph.makeEdge(21, 6, 1);
        graph.makeEdge(48, 6, 1);
        graph.makeEdge(56, 6, 1);
        graph.makeEdge(59, 6, 1);
        graph.makeEdge(61, 6, 1);
        graph.makeEdge(72, 6, 1);
        graph.makeEdge(80, 6, 1);
        graph.makeEdge(88, 6, 1);
        graph.makeEdge(94, 6, 1);
        graph.makeEdge(96, 6, 1);
        graph.makeEdge(97, 6, 1);

        //User8
        graph.makeEdge(7, 12, 1);
        graph.makeEdge(7, 14, 1);
        graph.makeEdge(7, 16, 1);
        graph.makeEdge(7, 26, 1);
        graph.makeEdge(7, 38, 1);
        graph.makeEdge(7, 48, 1);
        graph.makeEdge(7, 66, 1);
        graph.makeEdge(7, 79, 1);
        graph.makeEdge(7, 88, 1);
        graph.makeEdge(7, 97, 1);

        graph.makeEdge(12, 7, 1);
        graph.makeEdge(14, 7, 1);
        graph.makeEdge(16, 7, 1);
        graph.makeEdge(26, 7, 1);
        graph.makeEdge(38, 7, 1);
        graph.makeEdge(48, 7, 1);
        graph.makeEdge(66, 7, 1);
        graph.makeEdge(79, 7, 1);
        graph.makeEdge(88, 7, 1);
        graph.makeEdge(97, 7, 1);

        //User9
        graph.makeEdge(8, 6, 1);
        graph.makeEdge(8, 11, 1);
        graph.makeEdge(8, 12, 1);
        graph.makeEdge(8, 26, 1);
        graph.makeEdge(8, 48, 1);
        graph.makeEdge(8, 53, 1);
        graph.makeEdge(8, 67, 1);
        graph.makeEdge(8, 72, 1);
        graph.makeEdge(8, 79, 1);
        graph.makeEdge(8, 91, 1);

        graph.makeEdge(6, 8, 1);
        graph.makeEdge(11, 8, 1);
        graph.makeEdge(12, 8, 1);
        graph.makeEdge(26, 8, 1);
        graph.makeEdge(48, 8, 1);
        graph.makeEdge(53, 8, 1);
        graph.makeEdge(67, 8, 1);
        graph.makeEdge(72, 8, 1);
        graph.makeEdge(79, 8, 1);
        graph.makeEdge(91, 8, 1);

        //User10
        graph.makeEdge(9, 4, 1);
        graph.makeEdge(9, 8, 1);
        graph.makeEdge(9, 22, 1);
        graph.makeEdge(9, 30, 1);
        graph.makeEdge(9, 36, 1);
        graph.makeEdge(9, 38, 1);
        graph.makeEdge(9, 40, 1);
        graph.makeEdge(9, 41, 1);
        graph.makeEdge(9, 51, 1);
        graph.makeEdge(9, 53, 1);
        graph.makeEdge(9, 58, 1);
        graph.makeEdge(9, 63, 1);
        graph.makeEdge(9, 70, 1);
        graph.makeEdge(9, 77, 1);
        graph.makeEdge(9, 78, 1);
        graph.makeEdge(9, 83, 1);
        graph.makeEdge(9, 87, 1);
        graph.makeEdge(9, 90, 1);
        graph.makeEdge(9, 95, 1);

        graph.makeEdge(4, 9, 1);
        graph.makeEdge(8, 9, 1);
        graph.makeEdge(22, 9, 1);
        graph.makeEdge(30, 9, 1);
        graph.makeEdge(36, 9, 1);
        graph.makeEdge(38, 9, 1);
        graph.makeEdge(40, 9, 1);
        graph.makeEdge(41, 9, 1);
        graph.makeEdge(51, 9, 1);
        graph.makeEdge(53, 9, 1);
        graph.makeEdge(58, 9, 1);
        graph.makeEdge(63, 9, 1);
        graph.makeEdge(70, 9, 1);
        graph.makeEdge(77, 9, 1);
        graph.makeEdge(78, 9, 1);
        graph.makeEdge(83, 9, 1);
        graph.makeEdge(87, 9, 1);
        graph.makeEdge(90, 9, 1);
        graph.makeEdge(95, 9, 1);

        Node node0 = new Node ("The Wizard of Oz");
        Node node1 = new Node ("Citizen Kane");
        Node node2 = new Node ("The Third Man");
        Node node3 = new Node ("Get Out");
        Node node4 = new Node ("Mad Max");
        Node node5 = new Node ("The Cabinet of Dr. Caligari");
        Node node6 = new Node ("All About Eve");
        Node node7 = new Node ("Inside Out");
        Node node8 = new Node ("Metropolis");
        Node node9 = new Node ("The Godfather");
        Node node10 = new Node ("E.T. The Extra-Terrestrial");
        Node node11 = new Node ("Modern Times");
        Node node12 = new Node ("It Happened One Night");
        Node node13 = new Node ("Moonlight");
        Node node14 = new Node ("Singin' in the Rain");
        Node node15 = new Node ("Spotlight");
        Node node16 = new Node ("Casablanca");
        Node node17 = new Node ("Psycho");
        Node node18 = new Node ("Laura");
        Node node19 = new Node ("Nosferatu, A Symphony of Horror");
        Node node20 = new Node ("Snow White and the seven Dwarfs");
        Node node21 = new Node ("A Hard Day's Night");
        Node node22 = new Node ("Dunkirk");
        Node node23 = new Node ("Wonder Woman");
        Node node24 = new Node ("North By Northwest");
        Node node25 = new Node ("Boyhood");
        Node node26 = new Node ("The Big Sick");
        Node node27 = new Node ("La Grande Illusion");
        Node node28 = new Node ("The Battle of Algiers");
        Node node29 = new Node ("The Maltese Falcon");
        Node node30 = new Node ("King Kong");
        Node node31 = new Node ("12 Years a Slave");
        Node node32 = new Node ("Repulsion");
        Node node33 = new Node ("Gravity");
        Node node34 = new Node ("Sunset Boulevard");
        Node node35 = new Node ("Rashomon");
        Node node36 = new Node ("Logan");
        Node node37 = new Node ("Selma");
        Node node38 = new Node ("The Adventures of Robin Hood");
        Node node39 = new Node ("Rear Window");
        Node node40 = new Node ("Taxi Driver");
        Node node41 = new Node ("Star Wars: Episode VII - The Force Awakens");
        Node node42 = new Node ("Toy Story 3");
        Node node43 = new Node ("Argo");
        Node node44 = new Node ("Zootopia");
        Node node45 = new Node ("Toy Story 2");
        Node node46 = new Node ("The Bride of Frankenstein");
        Node node47 = new Node ("M");
        Node node48 = new Node ("The Philadelphia Story");
        Node node49 = new Node ("Alien");
        Node node50 = new Node ("Hell or High Water");
        Node node51 = new Node ("Seven Samurai");
        Node node52 = new Node ("Bicycle Thieves");
        Node node53 = new Node ("The Treasure of the Sierra Madre");
        Node node54 = new Node ("Up");
        Node node55 = new Node ("Arrival");
        Node node56 = new Node ("12 Angry Men");
        Node node57 = new Node ("The 400 Blows");
        Node node58 = new Node ("Baby Driver");
        Node node59 = new Node ("All Quiet on the Western Front");
        Node node60 = new Node ("Army of Shadows");
        Node node61 = new Node ("A Streetcar Named Desire");
        Node node62 = new Node ("The Night of the Hunter");
        Node node63 = new Node ("Lawrence of Arabia");
        Node node64 = new Node ("The Babadook");
        Node node65 = new Node ("The Conformist");
        Node node66 = new Node ("Vertigo");
        Node node67 = new Node ("Dr. Strangelove Or How I Learned to Stop Worrying and Love the Bomb");
        Node node68 = new Node ("Frankenstein");
        Node node69 = new Node ("Tough of Evil");
        Node node70 = new Node ("The Dark Knight");
        Node node71 = new Node ("Rebecca");
        Node node72 = new Node ("La La Land");
        Node node73 = new Node ("Rosemary's Baby");
        Node node74 = new Node ("Finding Nemo");
        Node node75 = new Node ("The Wrestler");
        Node node76 = new Node ("L.A. Confidential");
        Node node77 = new Node ("The 39 Steps");
        Node node78 = new Node ("The Good, the Bad and the Ugly");
        Node node79 = new Node ("Gone With the Wind");
        Node node80 = new Node ("Spiderman: Homecoming");
        Node node81 = new Node ("The Jungle Book");
        Node node82 = new Node ("Open City");
        Node node83 = new Node ("Skyfall");
        Node node84 = new Node ("Tokyo Story");
        Node node85 = new Node ("Manchester by the Sea");
        Node node86 = new Node ("Pinocchio");
        Node node87 = new Node ("War for the Planet of the Apes");
        Node node88 = new Node ("On the Waterfront");
        Node node89 = new Node ("It Follows");
        Node node90 = new Node ("Apocalypse Now");
        Node node91 = new Node ("High Noon");
        Node node92 = new Node ("Jaws");
        Node node93 = new Node ("The Wages of Fear");
        Node node94 = new Node ("The Last Picture Show");
        Node node95 = new Node ("Harry Potter and the Deathly Hallows - Part 2");
        Node node96 = new Node ("The Grapes of Wrath");
        Node node97 = new Node ("Roman Holiday");
        Node node98 = new Node ("I Am Not Your Negro");
        Node node99 = new Node ("Man on Wire");


        Node node100 = new Node("");
        Node node101 = new Node("");
        Node node102 = new Node("");
        Node node103 = new Node("");
        Node node104 = new Node("");
        Node node105 = new Node("");
        Node node106 = new Node("");
        Node node107 = new Node("");
        Node node108 = new Node("");
        Node node109 = new Node("");

        graph._node.add(node0);
        graph._node.add(node1);
        graph._node.add(node2);
        graph._node.add(node3);
        graph._node.add(node4);
        graph._node.add(node5);
        graph._node.add(node6);
        graph._node.add(node7);
        graph._node.add(node8);
        graph._node.add(node9);
        graph._node.add(node10);
        graph._node.add(node11);
        graph._node.add(node12);
        graph._node.add(node13);
        graph._node.add(node14);
        graph._node.add(node15);
        graph._node.add(node16);
        graph._node.add(node17);
        graph._node.add(node18);
        graph._node.add(node19);
        graph._node.add(node20);
        graph._node.add(node21);
        graph._node.add(node22);
        graph._node.add(node23);
        graph._node.add(node24);
        graph._node.add(node25);
        graph._node.add(node26);
        graph._node.add(node27);
        graph._node.add(node28);
        graph._node.add(node29);
        graph._node.add(node30);
        graph._node.add(node31);
        graph._node.add(node32);
        graph._node.add(node33);
        graph._node.add(node34);
        graph._node.add(node35);
        graph._node.add(node36);
        graph._node.add(node37);
        graph._node.add(node38);
        graph._node.add(node39);
        graph._node.add(node40);
        graph._node.add(node41);
        graph._node.add(node42);
        graph._node.add(node43);
        graph._node.add(node44);
        graph._node.add(node45);
        graph._node.add(node46);
        graph._node.add(node47);
        graph._node.add(node48);
        graph._node.add(node49);
        graph._node.add(node50);
        graph._node.add(node51);
        graph._node.add(node52);
        graph._node.add(node53);
        graph._node.add(node54);
        graph._node.add(node55);
        graph._node.add(node56);
        graph._node.add(node57);
        graph._node.add(node58);
        graph._node.add(node59);
        graph._node.add(node60);
        graph._node.add(node61);
        graph._node.add(node62);
        graph._node.add(node63);
        graph._node.add(node64);
        graph._node.add(node65);
        graph._node.add(node66);
        graph._node.add(node67);
        graph._node.add(node68);
        graph._node.add(node69);
        graph._node.add(node70);
        graph._node.add(node71);
        graph._node.add(node72);
        graph._node.add(node73);
        graph._node.add(node74);
        graph._node.add(node75);
        graph._node.add(node76);
        graph._node.add(node77);
        graph._node.add(node78);
        graph._node.add(node79);
        graph._node.add(node80);
        graph._node.add(node81);
        graph._node.add(node82);
        graph._node.add(node83);
        graph._node.add(node84);
        graph._node.add(node85);
        graph._node.add(node86);
        graph._node.add(node87);
        graph._node.add(node88);
        graph._node.add(node89);
        graph._node.add(node90);
        graph._node.add(node91);
        graph._node.add(node92);
        graph._node.add(node93);
        graph._node.add(node94);
        graph._node.add(node95);
        graph._node.add(node96);
        graph._node.add(node97);
        graph._node.add(node98);
        graph._node.add(node99);
        graph._node.add(node100);
        graph._node.add(node101);
        graph._node.add(node102);
        graph._node.add(node103);
        graph._node.add(node104);
        graph._node.add(node105);
        graph._node.add(node106);
        graph._node.add(node107);
        graph._node.add(node108);
        graph._node.add(node109);



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

                int[][] graph1 = graph.getMatrix();

                Graph userGraph = new Graph();
                if(index == 0) listToWrite = userGraph.BFS(graph1, node0);
                else if(index == 1) listToWrite = userGraph.BFS(graph1, node1);
                else if(index == 2) listToWrite = userGraph.BFS(graph1, node2);
                else if(index == 3) listToWrite = userGraph.BFS(graph1, node3);
                else if(index == 4) listToWrite = userGraph.BFS(graph1, node4);
                else if(index == 5) listToWrite = userGraph.BFS(graph1, node5);
                else if(index == 6) listToWrite = userGraph.BFS(graph1, node6);
                else if(index == 7) listToWrite = userGraph.BFS(graph1, node7);
                else if(index == 8) listToWrite = userGraph.BFS(graph1, node8);
                else if(index == 9) listToWrite = userGraph.BFS(graph1, node9);
                else if(index == 10) listToWrite = userGraph.BFS(graph1, node10);
                else if(index == 11) listToWrite = userGraph.BFS(graph1, node11);
                else if(index == 12) listToWrite = userGraph.BFS(graph1, node12);
                else if(index == 13) listToWrite = userGraph.BFS(graph1, node13);
                else if(index == 14) listToWrite = userGraph.BFS(graph1, node14);
                else if(index == 15) listToWrite = userGraph.BFS(graph1, node15);
                else if(index == 16) listToWrite = userGraph.BFS(graph1, node16);
                else if(index == 17) listToWrite = userGraph.BFS(graph1, node17);
                else if(index == 18) listToWrite = userGraph.BFS(graph1, node18);
                else if(index == 19) listToWrite = userGraph.BFS(graph1, node19);
                else if(index == 20) listToWrite = userGraph.BFS(graph1, node20);
                else if(index == 21) listToWrite = userGraph.BFS(graph1, node21);
                else if(index == 22) listToWrite = userGraph.BFS(graph1, node22);
                else if(index == 23) listToWrite = userGraph.BFS(graph1, node23);
                else if(index == 24) listToWrite = userGraph.BFS(graph1, node24);
                else if(index == 25) listToWrite = userGraph.BFS(graph1, node25);
                else if(index == 26) listToWrite = userGraph.BFS(graph1, node26);
                else if(index == 27) listToWrite = userGraph.BFS(graph1, node27);
                else if(index == 28) listToWrite = userGraph.BFS(graph1, node28);
                else if(index == 29) listToWrite = userGraph.BFS(graph1, node29);
                else if(index == 30) listToWrite = userGraph.BFS(graph1, node30);
                else if(index == 31) listToWrite = userGraph.BFS(graph1, node31);
                else if(index == 32) listToWrite = userGraph.BFS(graph1, node32);
                else if(index == 33) listToWrite = userGraph.BFS(graph1, node33);
                else if(index == 34) listToWrite = userGraph.BFS(graph1, node34);
                else if(index == 35) listToWrite = userGraph.BFS(graph1, node35);
                else if(index == 36) listToWrite = userGraph.BFS(graph1, node36);
                else if(index == 37) listToWrite = userGraph.BFS(graph1, node37);
                else if(index == 38) listToWrite = userGraph.BFS(graph1, node38);
                else if(index == 39) listToWrite = userGraph.BFS(graph1, node39);
                else if(index == 40) listToWrite = userGraph.BFS(graph1, node40);
                else if(index == 41) listToWrite = userGraph.BFS(graph1, node41);
                else if(index == 42) listToWrite = userGraph.BFS(graph1, node42);
                else if(index == 43) listToWrite = userGraph.BFS(graph1, node43);
                else if(index == 44) listToWrite = userGraph.BFS(graph1, node44);
                else if(index == 45) listToWrite = userGraph.BFS(graph1, node45);
                else if(index == 46) listToWrite = userGraph.BFS(graph1, node46);
                else if(index == 47) listToWrite = userGraph.BFS(graph1, node47);
                else if(index == 48) listToWrite = userGraph.BFS(graph1, node48);
                else if(index == 49) listToWrite = userGraph.BFS(graph1, node49);
                else if(index == 50) listToWrite = userGraph.BFS(graph1, node50);
                else if(index == 51) listToWrite = userGraph.BFS(graph1, node51);
                else if(index == 52) listToWrite = userGraph.BFS(graph1, node52);
                else if(index == 53) listToWrite = userGraph.BFS(graph1, node53);
                else if(index == 54) listToWrite = userGraph.BFS(graph1, node54);
                else if(index == 55) listToWrite = userGraph.BFS(graph1, node55);
                else if(index == 56) listToWrite = userGraph.BFS(graph1, node56);
                else if(index == 57) listToWrite = userGraph.BFS(graph1, node57);
                else if(index == 58) listToWrite = userGraph.BFS(graph1, node58);
                else if(index == 59) listToWrite = userGraph.BFS(graph1, node59);
                else if(index == 60) listToWrite = userGraph.BFS(graph1, node60);
                else if(index == 61) listToWrite = userGraph.BFS(graph1, node61);
                else if(index == 62) listToWrite = userGraph.BFS(graph1, node62);
                else if(index == 63) listToWrite = userGraph.BFS(graph1, node63);
                else if(index == 64) listToWrite = userGraph.BFS(graph1, node64);
                else if(index == 65) listToWrite = userGraph.BFS(graph1, node65);
                else if(index == 66) listToWrite = userGraph.BFS(graph1, node66);
                else if(index == 67) listToWrite = userGraph.BFS(graph1, node67);
                else if(index == 68) listToWrite = userGraph.BFS(graph1, node68);
                else if(index == 69) listToWrite = userGraph.BFS(graph1, node69);
                else if(index == 70) listToWrite = userGraph.BFS(graph1, node70);
                else if(index == 71) listToWrite = userGraph.BFS(graph1, node71);
                else if(index == 72) listToWrite = userGraph.BFS(graph1, node72);
                else if(index == 73) listToWrite = userGraph.BFS(graph1, node73);
                else if(index == 74) listToWrite = userGraph.BFS(graph1, node74);
                else if(index == 75) listToWrite = userGraph.BFS(graph1, node75);
                else if(index == 76) listToWrite = userGraph.BFS(graph1, node76);
                else if(index == 77) listToWrite = userGraph.BFS(graph1, node77);
                else if(index == 78) listToWrite = userGraph.BFS(graph1, node78);
                else if(index == 79) listToWrite = userGraph.BFS(graph1, node79);
                else if(index == 80) listToWrite = userGraph.BFS(graph1, node80);
                else if(index == 81) listToWrite = userGraph.BFS(graph1, node81);
                else if(index == 82) listToWrite = userGraph.BFS(graph1, node82);
                else if(index == 83) listToWrite = userGraph.BFS(graph1, node83);
                else if(index == 84) listToWrite = userGraph.BFS(graph1, node84);
                else if(index == 85) listToWrite = userGraph.BFS(graph1, node85);
                else if(index == 86) listToWrite = userGraph.BFS(graph1, node86);
                else if(index == 87) listToWrite = userGraph.BFS(graph1, node87);
                else if(index == 88) listToWrite = userGraph.BFS(graph1, node88);
                else if(index == 89) listToWrite = userGraph.BFS(graph1, node89);
                else if(index == 90) listToWrite = userGraph.BFS(graph1, node90);
                else if(index == 91) listToWrite = userGraph.BFS(graph1, node91);
                else if(index == 92) listToWrite = userGraph.BFS(graph1, node92);
                else if(index == 93) listToWrite = userGraph.BFS(graph1, node93);
                else if(index == 94) listToWrite = userGraph.BFS(graph1, node94);
                else if(index == 95) listToWrite = userGraph.BFS(graph1, node95);
                else if(index == 96) listToWrite = userGraph.BFS(graph1, node96);
                else if(index == 97) listToWrite = userGraph.BFS(graph1, node97);
                else if(index == 98) listToWrite = userGraph.BFS(graph1, node98);
                else if(index == 99) listToWrite = userGraph.BFS(graph1, node99);

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