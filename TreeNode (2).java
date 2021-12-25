//import java.io.*;

public class TreeNode {
    String value;
    TreeNode left;
    TreeNode right;

    public TreeNode(String value){ //Constructing a leaf
        this.value = value;
        this.left = null;
        this.right = null;
    }

    public TreeNode(String value, TreeNode left, TreeNode right){ //Construct a tree node with left and right children
        this.value = value;
        this.left = left;
        this.right = right;
    }

    public TreeNode getLeft() {
        return left;
    }
    public TreeNode getRight() {
        return right;
    }

    public boolean isLeaf(){
        return left == null && right == null;
    }

//    //Pre-order Traversal implementation
//    public void preOrder(BufferedWriter out) throws IOException{
//        System.out.println(this.value);
//        if (this.left != null){ //Test to see if left subtree exists
//            this.left.preOrder(); //recursive print call
//        }
//        if (this.right != null){ //Separate if statements because whether left or right sub trees are null is independent of each other
//            this.right.preOrder();
//        }
//    }
//}
}
