package Project;

import java.util.*;

public class Graph {
    private int _row;
    private int _col;
    private int[][] _matrix;
    private LinkedList<Integer> adjacent[]; //Adjacency List

    public Graph(int row, int col){
        _row = row;
        _col = col;
        _matrix = new int[_row + 1][_col + 1];
    }

    public int getRows(){ return _row; }
    public int getCol(){ return _col; }
    public int[][] getMatrix(){ return _matrix; }

    public void setRows(int row){ _row = row; }
    public void setCol(int col){ _col = col; }
    public void setMatrix(int[][] matrix){ _matrix = matrix; }

    public void makeEdge(int row, int col, int edge){
        try{
            _matrix[row][col] = edge;
        }
        catch(ArrayIndexOutOfBoundsException ex){
            System.out.println("The vertices do not exist.");
        }
    }

    public int getEdge(int to, int from){
        return _matrix[to][from];
    }

    //Update graph based on watched movies and dislikes
    public void updateGraph(int to, int from){
        _matrix[to][from] = 0;
    }

    //Check if graph is bipartite return true if yes
    public boolean isBipartite(int G[][], int source, int vertices){
        int[] colors = new int[vertices];
        //Assign -1 to indicate no color assigned
        for(int i = 0; i < vertices; i++){
            colors[i] = -1;
        }

        LinkedList<Integer> queue = new LinkedList<>();
        queue.add(source);

        while(queue.size() != 0){
            int u = queue.poll();
            if(G[u][u] == 1)
                return false;

            for(int v = 0; v < vertices; v++){
                if(G[u][v] == 1 && colors[v] == -1){
                    colors[v] = 1 - colors[u];
                    queue.add(v);
                }
                else if(G[u][v] == 1 && colors[v] == colors[u])
                    return false;
            }
        }
        return true;
    }

    //Search graph using BFS
    void BFS(int row, int col){
        //Mark all nodes as not visited
        boolean visited [][] = new boolean [_row][_col];

        //Make Queue
        LinkedList<Integer> queue = new LinkedList<>();

        //Mark current node as visited
        visited[row][col] = true;
        queue.add(row, col);

        while(queue.size() != 0){
            //Dequeue columns
            col = queue.poll();

            Iterator<Integer> i = adjacent[col].listIterator();
            while(i.hasNext()){
                int n = i.next();
                if(!visited[n][col]){
                    visited[n][col] = true;
                    queue.add(n);
                }
            }
        }
    }
}
