import java.util.*;

public class Graph {
    private int _vertices;
    private int[][] _matrix;

    private Queue<Node> _queue;
    static ArrayList<Node> _node = new ArrayList();

    public Graph(){
        _queue = new LinkedList<Node>();
    }

    public Graph(int vertices){
        _vertices = vertices;
        _matrix = new int[_vertices + 1][_vertices + 1];
        //_queue = new LinkedList<Node>();
    }

    public int getVertices(){ return _vertices; }
    public int[][] getMatrix(){ return _matrix; }

    public void setVertices(int vertices){ _vertices = vertices; }
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

    public ArrayList<Node> findAdjacent(int matrix[][], Node x){
        int index = -1;

        ArrayList<Node> adjacent = new ArrayList<>();
        for(int i = 0; i < _node.size(); i++){
            if(_node.get(i).equals(x)){
                index = i;
                break;
            }
        }

        if(index != -1){
            for(int j = 0; j < matrix[index].length; j++){
                if(matrix[index][j] == 1){
                    adjacent.add(_node.get(j));
                }
            }
        }
        return adjacent;
    }

    //Search graph using BFS
    public List<String> BFS(int matrix[][], Node node){
        //Mark all nodes as not visited
        _queue.add(node);
        node._visited = true;

        List<String> recommend = new ArrayList<>();

        int j = 0;
        while(_queue.size() != 0){
            //Dequeue source vertex
            Node current = _queue.remove();
            recommend.add(current._data);

            ArrayList<Node> adjacent = findAdjacent(matrix, current);
            for(int i = 0; i < adjacent.size(); i++){
                Node n = adjacent.get(i);
                if(n != null && !n._visited){
                    _queue.add(n);
                    n._visited = true;
                }
            }
            j++;
        }

        return recommend;
    }
}
