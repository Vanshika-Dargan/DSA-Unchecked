import java.util.ArrayList;
import java.util.List;
import java.util.Arrays;
class Solution {
    private int timer=1;
    public List<List<Integer>> criticalConnections(int n, List<List<Integer>> connections) {
    List<List<Integer>> adj=new ArrayList<>();
    for(int i=0;i<n;i++){
        adj.add(new ArrayList<>());
    }
    for(List<Integer> c:connections){
        int src=c.get(0);
        int dest=c.get(1);
        adj.get(src).add(dest);
        adj.get(dest).add(src);
    }
    List<List<Integer>> res=new ArrayList<>();
    int min[]=new int[n];
    int step[]=new int[n];
    boolean vis[]=new boolean[n];
    dfs(0,-1,adj,min,step,vis,res);
    return res;
    }
    void dfs(int node,int parent,List<List<Integer>> adj,int[] min,int[] step,boolean[] vis,List<List<Integer>> res){
    vis[node]=true;
    min[node]=step[node]=timer;
    timer++;
    for(int n:adj.get(node)){
        if(n==parent) continue;
        if(!vis[n]){
            dfs(n,node,adj,min,step,vis,res);
            min[node]=Math.min(min[node],min[n]);
            if(step[node]<min[n])
            res.add(Arrays.asList(node,n));
        }
        else{
            min[node]=Math.min(min[node],min[n]);
        }
    }
    }
}


public class BridgesInAGraph {
    public static void main(String[] args){
    int n=4;
    int edges[][]={{0,1},{1,2},{2,0},{1,3}};
    List<List<Integer>>connections=new ArrayList<>();
    for(int i=0;i<n;i++){
        connections.add(new ArrayList<>());
    }
    for(int i=0;i<n;i++){
        connections.get(i).add(edges[i][0]);
        connections.get(i).add(edges[i][1]);
    }
    Solution obj=new Solution();
    List<List<Integer>> bridges=obj.criticalConnections(n,connections);
    for(int i=0;i<bridges.size();i++){
        System.out.print(bridges.get(i).get(0)+" "+bridges.get(i).get(1));
        System.out.println();
    }

}
}
