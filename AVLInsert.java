
public class AVLInsert {

   Node insert(Node root,int val){
   
    // normal bst insertion
    if(root==null){
        root=new Node(val);
        return root;
    }
    if(val<root.data){
        root.left=insert(root.left,val);
    }
    else if(val>root.data){
        root.right=insert(root.right,val);
    }
    else{
    return root;
    }

    root.height=1+Math.max(height(root.left),height(root.right));
    
    int height_diff=diffOfHeights(root);

    if(height_diff>1 && val<root.left.data){
    return rightRotate(root);
    }
    if(height_diff<-1 && val>root.right.data){
    return leftRotate(root);
    }
    if(height_diff>1 && val>root.left.data){
        root.left=leftRotate(root.left);
        return rightRotate(root);
    }
    if(height_diff<-1 && val<root.right.data){
        root.right=rightRotate(root.right);
        return leftRotate(root);
    }
    return root;
   }
   
   int height(Node node){
    if(node==null)
    return 0;
    return node.height;
   }
   int diffOfHeights(Node node){
    return height(node.left)-height(node.right);
   }

   Node leftRotate(Node node){
   Node right=node.right;
   Node right_left=right.left;
   node.right=null;
   
   right.left=node;
   node.right=right_left;

   node.height=1+Math.max(height(node.left),height(node.right));
   right.height=1+Math.max(height(right.left),height(right.right));
   return right;
   }
   Node rightRotate(Node node){
   Node left=node.left;
   Node left_right=left.right;
   node.left=null;

   left.right=node;
   node.left=left_right;

   node.height=1+Math.max(height(node.left),height(node.right));
   left.height=1+Math.max(height(left.right),height(left.left));
   return left;
   }
   void inorder(Node root){
    if(root!=null){
    inorder(root.left);
    System.out.println(root.data+"->"+root.height);;
    inorder(root.right);
    }
   }
   public static void main(String[] args) {
    AVLInsert obj=new AVLInsert();
    Node root=null;
    root=obj.insert(root,10);
    root=obj.insert(root,20);
    root=obj.insert(root,30);
    obj.inorder(root);
   }
}

/*Time Complexity: Since avl tree is height balance bst
for each node insert takes O(log n) at worst
hence for n nodes it will be n*log n

Space Complexity:O(1)
*/