public class BinaryTree {
    public BinaryTree root; 
 
    public static class BinaryTree { 
        BinaryTree left; 
        BinaryTree right; 
        int data;

        BinaryTree(int newData) { 
            left = null; 
            right = null; 
            data = newData; 
        } 
    }
    
    public static BinaryTree createFromData (BinaryTree rootData, BinaryTree leftSubtree, BinaryTree rightSubtree) {
        rootData.left = leftSubtree;
        rootData.right = rightSubtree;
    }
    
    public int size(BinaryTree tree) {
        if ( tree == null)
            return(0);
        else {
            return (size(tree.left) + 1 + size(tree.right));
        }
    }
    
    public void add (int data) {
        root = add(root, data);
    }
    
    public BinaryTree add(BinaryTree tree, int data) {
        if (tree==null) {
            tree = new BinaryTree(data);
        }
        else {
            if (data <= tree.data) {
                tree.left = add(tree.left, data);
            }
            else {
                tree.right = add(tree.right, data);
            }
        }
        return(tree);
    }
    
    public void printInorder() {
        printInOrder(root);
        System.out.println();
    }
    
    public void printInOrder(BinaryTree tree) {
        if ( tree == null) return;
        printInOrder(tree.left);
        System.out.println(tree.data + " ");
        printInOrder(tree.right);
    }
     
}