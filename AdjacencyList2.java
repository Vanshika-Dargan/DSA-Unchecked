import java.util.ArrayList;
public class AdjacencyList2 {
    
    static void addEdge(ArrayList<Integer> graph[],int src,int dst){
     graph[src].add(dst);
     graph[dst].add(src);
    }
    public static void main(String[] args) {
        
        int V=5;
        @SuppressWarnings("unchecked")
        ArrayList<Integer>[] graph=new ArrayList[V];
        for(int i=0;i<V;i++){
            graph[i]=new ArrayList<Integer>();
        }
        addEdge(graph,0,1);
        addEdge(graph,0,2);
        addEdge(graph,1,2);
        printGraph(graph);
    }
    static void printGraph(ArrayList<Integer> graph[])
    {
        int V=graph.length;
        for(int i=0;i<V;i++){
            for(int j:graph[i]){
                System.out.println(i+" -> "+j);
            }
        }
    }
}
