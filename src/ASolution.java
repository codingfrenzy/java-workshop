/**
 * Created by prasanthnair on 8/17/16.
 */
public abstract class ASolution {

    // BST template
    public class TreeNode {
        TreeNode left;
        TreeNode right;
        int val;

        TreeNode(int k){
            val = k;
        }
    }
    public TreeNode root;

    public void populateTree(int size){
        for(int i = 0; i < size; i++){
            int rand = (int) (Math.random() * 100);
            System.out.println(rand);
            insertBST(rand);
        }
    }

    public void insertBST(int k){
        if(root == null){
            root = new TreeNode(k);
            root.val = k;
            return;
        }
        insertBSTHelper(root, k);
    }

    private void insertBSTHelper(TreeNode node, int k){
        if (node == null){
            return;
        }

        TreeNode left = node.left;
        TreeNode right = node.right;

        if (k < node.val){
            if(left != null){
                insertBSTHelper(left, k);
            } else {
                left = new TreeNode(k);
                node.left = left;
            }
        } else if (k > node.val){
            if(right != null){
                insertBSTHelper(right, k);
            } else {
                right = new TreeNode(k);
                node.right = right;
            }
        }
    }

    public void inOrderTraversal() {
        inOrderTraversal(root);
        System.out.println();
    }

    public void inOrderTraversal(TreeNode node) {
        if (node == null)
            return ;
        inOrderTraversal(node.left);
        System.out.print(node.val + ", ");
        inOrderTraversal(node.right);
    }

    /*
    ONE LINE PRINTS
     */
    void println(String s){
        System.out.println(s);
    }

    void println(char s){
        System.out.println(s);
    }

    void println(float s){
        System.out.println(s);
    }

    void println(int s){
        System.out.println(s);
    }

    void println(boolean s){
        System.out.println(s);
    }

    /*
    SAME LINE PRINTS
     */
    void print(String s){
        System.out.println(s);
    }

    void print(char s){
        System.out.println(s);
    }

    void print(float s){
        System.out.println(s);
    }

    void print(int s){
        System.out.println(s);
    }

    void print(boolean s){
        System.out.println(s);
    }

    abstract void runSolution();
}
