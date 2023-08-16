import java.util.ArrayList;
public class DFS{

    static ArrayList<Integer> dfs(ArrayList<ArrayList<Integer>> graph,int i,boolean[] visited,ArrayList<Integer> res){
        visited[i]=true;
        res.add(i);
        for(int neighbor:graph.get(i)){
            if(!visited[neighbor]){
                dfs(graph,neighbor,visited,res);
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
        addEdge(graph,1,2);
        addEdge(graph,1,3);
        addEdge(graph,3,4);

        ArrayList<Integer> res=new ArrayList<>();
        boolean visited[]=new boolean[V];
        for(int i=0;i<V;i++){
        if(!visited[i]){
            dfs(graph,i,visited,res);
        }
        }
        System.out.println(res);
    }
    
}