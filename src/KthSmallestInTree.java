
class KthSmallestInTree extends ASolution{
    @Override
    void runSolution() {
    	populateTree(10);
    	inOrderTraversal();
    }

    private int count = 0;
    private int k = 0;
    private TreeNode kth;

    public int kthSmallest(TreeNode root, int k) {
        this.k = k;
        visitNode(root);
        return kth.val;
    }

    private void visitNode(TreeNode node) {
        if (node == null)
            return;
        if (k == count)
            return;

        visitNode(node.left);
        count++;
        if (count == k) {
            kth = node;
        }
        visitNode(node.right);
    }
}