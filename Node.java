package GenericTree;
//way1
import java.util.ArrayList;

class Node{
    int data;
    ArrayList<Node> children;
    Node(int data)
    {
        this.data=data;
        this.children=new ArrayList<Node>();
    }
}


//first child/next sibling representation
class Node2{
    int data;
    Node firstChild;
    Node nextSibling;
}