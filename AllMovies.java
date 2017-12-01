import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;


import java.io.IOException;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.*;
import java.util.List;

public class AllMovies {

    String titles[] = new String[100];

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
    //Hello
    
    //Class for movies
    public class Movies{
        String title;
        String year;
        String score;
        String rating;
        String genres[] = new String[8];

        // Constructors
        public Movies(String movieTitle, String releaseYear, String movieScore, String movieRating, String genre1, String genre2, String genre3, String genre4, String genre5, String genre6, String genre7, String genre8){
            this.title = movieTitle;
            this.year = releaseYear;
            this.score = movieScore;
            this.rating = movieRating;
            this.genres[0] = genre1;
            this.genres[1] = genre2;
            this.genres[2] = genre3;
            this.genres[3] = genre4;
            this.genres[4] = genre5;
            this.genres[5] = genre6;
            this.genres[6] = genre7;
            this.genres[7] = genre8;

        }

        public Movies(String movieTitle, String releaseYear, String movieScore, String movieRating, String genre1, String genre2, String genre3, String genre4, String genre5, String genre6, String genre7){
            this(movieTitle, releaseYear, movieScore, movieRating, genre1, genre2, genre3, genre4, genre5, genre6, genre7, null);
        }

        public Movies(String movieTitle, String releaseYear, String movieScore, String movieRating, String genre1, String genre2, String genre3, String genre4, String genre5, String genre6){
            this(movieTitle, releaseYear, movieScore, movieRating, genre1, genre2, genre3, genre4, genre5, genre6, null, null);
        }

        public Movies(String movieTitle, String releaseYear, String movieScore, String movieRating, String genre1, String genre2, String genre3, String genre4, String genre5){
            this(movieTitle, releaseYear, movieScore, movieRating, genre1, genre2, genre3, genre4, genre5, null, null, null);
        }

        public Movies(String movieTitle, String releaseYear, String movieScore, String movieRating, String genre1, String genre2, String genre3, String genre4){
            this(movieTitle, releaseYear, movieScore, movieRating, genre1, genre2, genre3, genre4, null, null, null, null);
        }

        public Movies(String movieTitle, String releaseYear, String movieScore, String movieRating, String genre1, String genre2, String genre3){
            this(movieTitle, releaseYear, movieScore, movieRating, genre1, genre2, genre3, null, null, null, null, null);
        }

        public Movies(String movieTitle, String releaseYear, String movieScore, String movieRating, String genre1, String genre2){
            this(movieTitle, releaseYear, movieScore, movieRating, genre1, genre2, null, null, null, null, null, null);
        }

        public Movies(String movieTitle, String releaseYear, String movieScore, String movieRating, String genre1){
            this(movieTitle, releaseYear, movieScore, movieRating, genre1, null, null, null, null, null, null, null);
        }


        // Getters for all attributes
        public String getTitle(){
            return title;
        }

        public String getYear(){
            return year;
        }

        public String getScore(){
            return score;
        }

        public String getRating(){
            return rating;
        }

        public String[] getGenres(){
            return genres;
        }

        // Set score
        public void setScore(String movieScore){
            score = movieScore;
        }

        @Override
        public String toString() {
            return title;
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
        JButton dislikeButton = new JButton("Dislike");
        JButton likeButton = new JButton("Like");

        //Delete Button
        deleteButton.setActionCommand("Delete");
        goBackButton.setActionCommand("Go Back");
        dislikeButton.setActionCommand("Dislike");
        likeButton.setActionCommand("Like");


        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        //frame.setContentPane(new AllMovies() .goBackButton);

        JLabel emptyLabel = new JLabel("");

        //Declaration of panel and list
        JList<AllMovies.Movies> list = new JList();
        DefaultListModel<AllMovies.Movies> model = new DefaultListModel<> ();


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

        //Add Movies to list
        list.setModel(model);

        /*Read file in
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
        */

        //Add movies to list

        HashMap<String, Movie> library = new HashMap<String, Movie>();

        library.put("The Wizard of Oz", new Movie("The Wizard of Oz", "1939", "9.4", "G", "Classics", "Kids", "Family", "Musical", "Performing Arts", "Science Fiction", "Fantasy"));
        library.put("Citizen Kane", new Movie("Citizen Kane", "1941", "9.4", "PG", "Classics", "Drama", "Mystery", "Suspense"));
        library.put("The Third Man", new Movie("The Third Man", "1949", "9.3", "NR", "Classics", "Mystery", "Suspense"));
        library.put("Get Out", new Movie("Get Out", "2017", "8.3", "R", "Comedy", "Horror", "Mystery", "Suspense"));
        library.put("Mad Max: Fury Road", new Movie("Mad Max: Fury Road", "2015", "8.6", "R", "Action", "Adventure", "Science Fiction", "Fantasy"));
        library.put("The Cabinet of Dr. Caligari", new Movie("The Cabinet of Dr. Caligari", "1920", "9.3", "NR", "Art House", "International", "Classics", "Horror", "Mystery", "Suspense"));
        library.put("All About Eve", new Movie("All About Eve", "1950", "9.1", "PG", "Classics", "Comedy", "Drama"));
        library.put("Inside Out", new Movie("Inside Out", "2015", "8.9", "PG", "Animation", "Kids", "Family"));
        library.put("Metropolis", new Movie("Metropolis", "1927", "9.1", "PG-13", "Action", "Adventure", "Art House", "International", "Classics", "Drama", "Science Fiction", "Fantasy"));
        library.put("The Godfather", new Movie("The Godfather", "1972", "9.2", "R", "Drama"));
        library.put("E.T. The Extra-Terrestrial", new Movie("E.T. The Extra-Terrestrial", "1982", "9.2", "PG", "Kids", "Family", "Science Fiction", "Fantasy"));
        library.put("Modern Times", new Movie("Modern Times", "1936", "9.0", "G", "Classics", "Comedy"));
        library.put("It Happened One Night", new Movie("It Happened One Night", "1934", "8.9", "NR", "Classics", "Comedy", "Romance"));
        library.put("Moonlight", new Movie("Moonlight", "2016", "9.0", "R", "Drama"));
        library.put("Singin' in the Rain", new Movie("Singin' in the Rain", "1952", "9.2", "G", "Classics", "Comedy", "Musical", "Performing Arts", "Romance"));
        library.put("Spotlight", new Movie("Spotlight", "2015", "8.8", "R", "Drama", "Mystery", "Suspense"));
        library.put("Casablanca", new Movie("Casablanca", "1942", "9.3", "PG", "Classics", "Drama", "Romance"));
        library.put("Psycho", new Movie("Psycho", "1960", "9.2", "R", "Classics", "Horror", "Mystery", "Suspense"));
        library.put("Laura", new Movie("Laura", "1944", "8.8", "NR", "Classics", "Mystery", "Suspense"));
        library.put("Nosferatu, A Symphony of Horror", new Movie("Nosferatu, A Symphony of Horror", "1922", "9.0", "NR", "Horror", "Art House", "International", "Classics", "Horror", "Science Fiction", "Fantasy"));
        library.put("Snow White and the seven Dwarfs", new Movie("Snow White and the seven Dwarfs", "1937", "8.8", "G", "Animation", "Classics", "Kids", "Family", "Science Fiction", "Fantasy"));
        library.put("A Hard Day's Night", new Movie("A Hard Day's Night", "1964", "8.5", "G", "Classics", "Comedy", "Musical", "Performing Arts"));
        library.put("Dunkirk", new Movie("Dunkirk", "2017", "8.6", "PG-13", "Action", "Adventure", "Drama"));
        library.put("Wonder Woman", new Movie("Wonder Woman", "2017", "7.6", "PG-13", "Action", "Adventure", "Drama", "Science Fiction", "Fantasy"));
        library.put("North By Northwest", new Movie("North By Northwest", "1959", "9.0", "NR", "Classics", "Mystery", "Suspense"));
        library.put("Boyhood", new Movie("Boyhood", "2014", "9.2", "R", "Drama"));
        library.put("The Big Sick", new Movie("The Big Sick", "2017", "8.2", "R", "Comedy", "Romance"));
        library.put("La Grande Illusion", new Movie("La Grande Illusion", "1938", "9.4", "NR", "Art House", "International", "Classics", "Drama"));
        library.put("The Battle of Algiers", new Movie("The Battle of Algiers", "1967", "9.1", "NR", "Art House", "International", "Drama"));
        library.put("The Maltese Falcon", new Movie("The Maltese Falcon", "1941", "9.0", "PG", "Drama", "Mystery", "Suspense"));
        library.put("King Kong", new Movie("King Kong", "1933", "9.0", "G", "Action", "Adventure", "Classics", "Horror"));
        library.put("12 Years a Slave", new Movie("12 Years a Slave", "2013", "8.9", "R", "Drama"));
        library.put("Repulsion", new Movie("Repulsion", "1965", "8.9", "NR", "Drama", "Classics", "Horror", "Mystery", "Suspense"));
        library.put("Gravity", new Movie("Gravity", "2013", "9.0", "PG-13", "Drama", "Science Fiction", "Fantasy"));
        library.put("Sunset Boulevard", new Movie("Sunset Boulevard", "1950", "9.3", "G", "Classics", "Drama"));
        library.put("Rashomon", new Movie("Rashomon", "1951", "9.3", "NR", "Art House", "International", "Classics", "Drama", "Mystery", "Suspense"));
        library.put("Logan", new Movie("Logan", "2017", "7.9", "R", "Action", "Adventure", "Drama", "Science Fiction", "Fantasy"));
        library.put("Selma", new Movie("Selma", "2015", "8.7", "PG-13", "Drama"));
        library.put("The Adventures of Robin Hood", new Movie("The Adventures of Robin Hood", "1938", "8.9", "PG", "Adventure", "Action", "Adventure", "Classics", "Romance"));
        library.put("Rear Window", new Movie("Rear Window", "1954", "8.9", "PG", "Classics", "Drama", "Mystery", "Suspense"));
        library.put("Taxi Driver", new Movie("Taxi Driver", "1976", "9.0", "R", "Drama", "Mystery", "Suspense"));
        library.put("Star Wars: Episode VII - The Force Awakens", new Movie("Star Wars: Episode VII - The Force Awakens", "2015", "8.2", "PG-13", "Action", "Adventure", "Science Fiction", "Fantasy"));
        library.put("Toy Story 3", new Movie("Toy Story 3", "2010", "8.9", "G", "Animation", "Comedy", "Kids", "Family", "Science Fiction", "Fantasy"));
        library.put("Argo", new Movie("Argo", "2012", "8.4", "R", "Drama", "Mystery", "Suspense"));
        library.put("Zootopia", new Movie("Zootopia", "2016", "8.0", "PG", "Action", "Adventure", "Animation", "Comedy"));
        library.put("Toy Story 2", new Movie("Toy Story 2", "1999", "8.6", "G", "Animation", "Comedy", "Kids", "Family", "Science Fiction", "Fantasy"));
        library.put("The Bride of Frankenstein", new Movie("The Bride of Frankenstein", "1935", "9.1", "NR", "Classics", "Horror", "Science Fiction", "Fantasy", "Special Interest"));
        library.put("M", new Movie("M", "1931", "9.2", "NR", "Art House", "International", "Drama", "Mystery", "Suspense"));
        library.put("The Philadelphia Story", new Movie("The Philadelphia Story", "1940", "8.8", "NR", "Classics", "Comedy", "Romance"));
        library.put("Alien", new Movie("Alien", "1979", "9.0", "R", "Drama", "Mystery", "Suspense", "Science Fiction", "Fantasy"));
        library.put("Hell or High Water", new Movie("Hell or High Water", "2016", "8.5", "R", "Drama", "Mystery", "Suspense"));
        library.put("Seven Samurai", new Movie("Seven Samurai", "1956", "9.3", "G", "Action", "Adventure", "Art House", "International", "Classics", "Drama"));
        library.put("Bicycle Thieves", new Movie("Bicycle Thieves", "1949", "9.1", "NR", "Drama"));
        library.put("The Treasure of the Sierra Madre", new Movie("The Treasure of the Sierra Madre", "1948", "9.0", "NR", "Action", "Adventure", "Classics", "Drama", "Western"));
        library.put("Up", new Movie("Up", "2009", "8.7", "PG", "Action", "Adventure", "Animation", "Comedy", "Kids", "Family"));
        library.put("Arrival", new Movie("Arrival", "2016", "8.4", "PG-13", "Drama", "Mystery", "Suspense", "Science Fiction", "Fantasy"));
        library.put("12 Angry Men", new Movie("12 Angry Men", "1957", "9.0", "NR", "Classics", "Drama"));
        library.put("The 400 Blows", new Movie("The 400 Blows", "1959", "9.3", "NR", "Art House", "International", "Classics", "Drama"));
        library.put("Baby Driver", new Movie("Baby Driver", "2017", "8.0", "R", "Action", "Adventure", "Comedy", "Drama"));
        library.put("All Quiet on the Western Front", new Movie("All Quiet on the Western Front", "1930", "9.0", "PG", "Western", "Classics", "Drama"));
        library.put("Army of Shadows", new Movie("Army of Shadows", "1969", "8.6", "NR", "Art House", "International", "Drama"));
        library.put("A Streetcar Named Desire", new Movie("A Streetcar Named Desire", "1951", "8.7", "PG", "Classics", "Drama"));
        library.put("The Night of the Hunter", new Movie("The Night of the Hunter", "1955", "9.1", "PG", "Drama", "Mystery", "Suspense"));
        library.put("Lawrence of Arabia", new Movie("Lawrence of Arabia", "1962", "9.1", "PG", "Action", "Adventure", "Classics", "Drama"));
        library.put("The Babadook", new Movie("The Babadook", "2014", "8.2", "NR", "Drama", "Horror", "Mystery", "Suspense"));
        library.put("The Conformist", new Movie("The Conformist", "1970", "8.9", "R", "Art House", "International", "Drama"));
        library.put("Vertigo", new Movie("Vertigo", "1958", "8.8", "PG", "Classics", "Drama", "Mystery", "Suspense", "Romance"));
        library.put("Dr. Strangelove Or How I Learned to Stop Worrying and Love the Bomb", new Movie("Dr. Strangelove Or How I Learned to Stop Worrying and Love the Bomb", "1964", "9.1", "PG", "Classics", "Comedy", "Science Fiction", "Fantasy"));
        library.put("Frankenstein", new Movie("Frankenstein", "1931", "8.7", "NR", "Classics", "Horror", "Science Fiction", "Fantasy", "Special Interest"));
        library.put("Tough of Evil", new Movie("Tough of Evil", "1958", "8.9", "PG-13", "Classics", "Drama", "Mystery", "Suspense"));
        library.put("The Dark Knight", new Movie("The Dark Knight", "2008", "8.6", "PG-13", "Action", "Adventure", "Drama", "Science Fiction", "Fantasy"));
        library.put("Rebecca", new Movie("Rebecca", "1940", "8.7", "NR", "Classics", "Drama", "Mystery", "Suspense"));
        library.put("La La Land", new Movie("La La Land", "2016", "8.6", "PG-13", "Comedy", "Drama", "Musical", "Performing Arts"));
        library.put("Rosemary's Baby", new Movie("Rosemary's Baby", "1968", "8.8", "R", "Classics", "Horror", "Mystery", "Suspense"));
        library.put("Finding Nemo", new Movie("Finding Nemo", "2003", "8.7", "G", "Animation", "Comedy", "Kids", "Family"));
        library.put("The Wrestler", new Movie("The Wrestler", "2008", "8.4", "R", "Drama"));
        library.put("L.A. Confidential", new Movie("L.A. Confidential", "1977", "8.8", "R", "Drama", "Mystery", "Suspense"));
        library.put("The 39 Steps", new Movie("The 39 Steps", "1935", "8.9", "NR", "Action", "Adventure", "Classics", "Mystery", "Suspense"));
        library.put("The Good, the Bad and the Ugly", new Movie("The Good, the Bad and the Ugly", "1966", "8.8", "R", "Western"));
        library.put("Gone With the Wind", new Movie("Gone With the Wind", "1939", "8.6", "G", "Drama", "Classics", "Romance"));
        library.put("Spiderman: Homecoming", new Movie("Spiderman: Homecoming", "2017", "7.6", "PG-13", "Action", "Adventure", "Drama", "Science Fiction", "Fantasy"));
        library.put("The Jungle Book", new Movie("The Jungle Book", "2016", "7.8", "PG", "Action", "Adventure", "Kids", "Family"));
        library.put("Open City", new Movie("Open City", "1946", "9.1", "NR", "Art House", "International", "Drama"));
        library.put("Skyfall", new Movie("Skyfall", "2012", "8.2", "PG-13", "Action", "Adventure", "Mystery", "Suspense"));
        library.put("Tokyo Story", new Movie("Tokyo Story", "1953", "9.7", "G", "Art House", "International", "Drama"));
        library.put("Manchester by the Sea", new Movie("Manchester by the Sea", "2016", "8.9", "R", "Drama"));
        library.put("Pinocchio", new Movie("Pinocchio", "1940", "9.1", "G", "Animation", "Kids", "Family", "Musical", "Performing Arts", "Science Fiction", "Fantasy"));
        library.put("War for the Planet of the Apes", new Movie("War for the Planet of the Apes", "2017", "8.1", "PG-13", "Action", "Adventure", "Drama"));
        library.put("On the Waterfront", new Movie("On the Waterfront", "1954", "9.1", "NR", "Classics", "Drama", "Romance"));
        library.put("It Follows", new Movie("It Follows", "2015", "8.1", "R", "Horror"));
        library.put("Apocalypse Now", new Movie("Apocalypse Now", "1979", "8.9", "R", "Action", "Adventure", "Drama"));
        library.put("High Noon", new Movie("High Noon", "1952", "8.8", "PG", "Mystery", "Suspense", "Western"));
        library.put("Jaws", new Movie("Jaws", "1975", "9.2", "PG", "Action", "Adventure", "Drama", "Mystery", "Suspense"));
        library.put("The Wages of Fear", new Movie("The Wages of Fear", "1953", "8.9", "NR", "Art House", "International", "Drama", "Mystery", "Suspense"));
        library.put("The Last Picture Show", new Movie("The Last Picture Show", "1971", "9.1", "R", "Classics", "Drama"));
        library.put("Harry Potter and the Deathly Hallows - Part 2", new Movie("Harry Potter and the Deathly Hallows - Part 2", "2011", "8.3", "PG-13", "Action", "Adventure", "Drama", "Kids", "Family", "Mystery", "Suspense", "Science Fiction"));
        library.put("The Grapes of Wrath", new Movie("The Grapes of Wrath", "1940", "9.0", "G", "Classics", "Drama"));
        library.put("Roman Holiday", new Movie("Roman Holiday", "1953", "8.4", "NR", "Classics", "Comedy", "Drama", "Romance"));
        library.put("I Am Not Your Negro", new Movie("I Am Not Your Negro", "2017", "8.9", "PG-13", "Documentary"));
        library.put("Man on Wire", new Movie("Man on Wire", "2008", "8.4", "PG-13", "Documentary", "Special Interest"));

        // Inserting movie titles into the list
        int count = 0;
        for(Map.Entry<String, Movie> entry:library.entrySet()){
            String movie;
            Movie m = entry.getValue();
            movie = m.getTitle();
            model.addElement(new AllMovies.Movies(m.getTitle(),m.getYear() , m.getScore(), m.getRating(), ""));

            // Titles get inserted into a single "Titles" array for easy access
            titles[count] = movie;
            count++;

        }
        
        //Make Graph
        int row = 12;
        int col = 100;
        
        //Initialize Graph
        Graph graph = new Graph(row, col);
        
        //User1
        graph.makeEdge(0, 0, 1);
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
        
        //User2
        graph.makeEdge(1, 1, 1);
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
        
        //User4
        graph.makeEdge(3, 3, 1);
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
        
        JLabel label = new JLabel();

        // Populating the movie info section on the screen
        list.getSelectionModel().addListSelectionListener(e -> {
            AllMovies.Movies m = list.getSelectedValue();
            label.setText("<html>Name: " + m.getTitle()+ " <br>Rating: " + m.getRating()
             + "<br>Year: " + m.getYear() + "<br>Score: " + m.getScore() + "</html>");
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

        //Display information
        label.setBounds(80, 5, 450, 80);
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

        //dislike Button Begin
        dislikeButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                //String ratingInput = inputRating.getText();
                //int rating = Integer.parseInt(ratingInput);


                int index = list.getSelectedIndex();    //Receives position of selected movie
                AllMovies.Movies movieSelected = list.getSelectedValue(); //Receives information on movie
                System.out.println("Movie " + movieSelected.getTitle() + " disliked");


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
                AllMovies.Movies movieSelected = list.getSelectedValue(); //Receives information on movie
                System.out.println("Movie " + movieSelected.getTitle() + " liked");


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
        //-----------------------------------------------------------------------------------------
        //GUI END

    } //End function 1

}
