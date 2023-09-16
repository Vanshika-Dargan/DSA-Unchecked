import java.util.*;
class Pair{
    int first;
    int second;
    Pair(int first,int second){
        this.first=first;
        this.second=second;
    }
}
class Graph{
private List<List<Pair>> adj;
private int V;
Graph(int V){
   this.V=V;
   adj=new ArrayList<>();
   for(int i=0;i<V;i++){
    adj.add(new ArrayList<>());
   }
}
void addEdge(int src,int dest,int weight){
    adj.get(src).add(new Pair(dest,weight));
    adj.get(dest).add(new Pair(src,weight));
}
void shortestPath(int src){
    int dist[]=new int[V];
    Arrays.fill(dist,Integer.MAX_VALUE);
    PriorityQueue<Pair> minHeap=new PriorityQueue<>(Comparator.comparingInt(a->a.first));
    minHeap.offer(new Pair(0,src));
    dist[src]=0;
    while(!minHeap.isEmpty()){
        Pair p=minHeap.poll();
        int curr_dist=p.first;
        int node=p.second;
        for(Pair neighbors:adj.get(node)){
            int new_dist=neighbors.second+curr_dist;
            if(new_dist<dist[neighbors.first]){
                dist[neighbors.first]=new_dist;
                minHeap.offer(new Pair(new_dist,neighbors.first));
            }
        }
    }
for(int i=0;i<V;i++){
System.out.println(dist[i]+" ");
}
}
}
public class DijkstraAlgorithm {
    public static void main(String[] args) {
        int V=9;
        Graph g=new Graph(V);
        g.addEdge(0, 1, 4);
        g.addEdge(0, 7, 8);
        g.addEdge(1, 2, 8);
        g.addEdge(1, 7, 11);
        g.addEdge(2, 3, 7);
        g.addEdge(2, 8, 2);
        g.addEdge(2, 5, 4);
        g.addEdge(3, 4, 9);
        g.addEdge(3, 5, 14);
        g.addEdge(4, 5, 10);
        g.addEdge(5, 6, 2);
        g.addEdge(6, 7, 1);
        g.addEdge(6, 8, 6);
        g.addEdge(7, 8, 7);
 
        g.shortestPath(0);
    }
}
