package BasicAlgo;
import java.util.ArrayList;
import java.util.Queue;
import java.util.LinkedList;

public class BFS{

    static ArrayList<Integer> bfs(ArrayList<ArrayList<Integer>> graph,int i, boolean[] visited,ArrayList<Integer> res){
        Queue<Integer> q=new LinkedList<>();
        q.offer(i);
        visited[i]=true;
        while(!q.isEmpty()){
            int node=q.poll();
            res.add(node);
            for(int neighbor:graph.get(node)){
                if(!visited[neighbor]){
                    q.offer(neighbor);
                    visited[neighbor]=true;
                }
            }
        }
        return res;
    }
    static void addEdge(ArrayList<ArrayList<Integer>> graph,int src,int dest){
        graph.get(src).add(dest);
        graph.get(dest).add(src);
    }
    public static void main(String[] args) {
        ArrayList<ArrayList<Integer>> graph=new ArrayList<>();
        int V=5;
        for(int i=0;i<V;i++){
            graph.add(new ArrayList<>());
        }
        addEdge(graph,0,1);
        addEdge(graph,0,2);
        addEdge(graph,3,4);
        
        ArrayList<Integer> res=new ArrayList<>();
        boolean visited[]=new boolean[V];
        for(int i=0;i<V;i++){
            if(!visited[i]){
                bfs(graph,i,visited,res);
            }
        }
        System.out.println(res);
    }
}