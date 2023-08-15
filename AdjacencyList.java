import java.util.ArrayList;

public class AdjacencyList{

    static void addEdge(ArrayList<ArrayList<Integer>> graph,int src,int dst){
        graph.get(src).add(dst);
        graph.get(dst).add(src);
    }
    public static void main(String[] args) {
        
        ArrayList<ArrayList<Integer>> graph=new ArrayList<>();
        int V=5;
        for(int i=0;i<V;i++){
            graph.add(new ArrayList<>());
        }

        addEdge(graph,0,1);
        addEdge(graph,0,2);
        addEdge(graph,1,2);
        printGraph(graph);
    }
    static void printGraph(ArrayList<ArrayList<Integer>> graph){
        int V=graph.size();
        for(int src=0;src<V;src++){
            for(int dst:graph.get(src)){
                System.out.println(src+" -> "+dst);
            }
        }
    }
}