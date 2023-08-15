public class AdjacencyMatrix{

    static void addEdge(int graph[][],int src,int dst){
        graph[src][dst]=1;
        graph[dst][src]=1;
    }
    public static void main(String args[]){
        int V=5;
        int graph[][]=new int[V][V];

        addEdge(graph,0,1);
        addEdge(graph,0,2);
        addEdge(graph,1,2);
    }
}

