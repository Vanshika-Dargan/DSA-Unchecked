import java.util.ArrayList;
public class AdjacencyWeighted {
    
    static class Node{
        int dst;
        int weight;
        Node(int dst,int weight){
            this.dst=dst;
            this.weight=weight;
        }
    }
    static void addEdge(ArrayList<ArrayList<Node>> graph,int src,int dst,int weight){
        graph.get(src).add(new Node(dst,weight));
    }
    public static void main(String[] args) {
        ArrayList<ArrayList<Node>> graph=new ArrayList<>();
        int V=5;
        for(int i=0;i<V;i++){
            graph.add(new ArrayList<Node>());
        }
       addEdge(graph,1,2,9);
       addEdge(graph,1,4,2);
       addEdge(graph,0,4,8);
       printGraph(graph);
    }
static void printGraph(ArrayList<ArrayList<Node>> graph){
    int V=graph.size();
    for(int i=0;i<V;i++){
        for(Node node:graph.get(i)){
            System.out.println(i+ "-> "+node.dst+","+node.weight);
        }
    }
}
}
