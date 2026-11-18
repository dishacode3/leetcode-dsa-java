package BinaryTree;

public class MaximumDifferenceAncestor {

    static class TreeNode {
        int val;
        TreeNode left, right;

        TreeNode(int val) {
            this.val = val;
        }
    }

    static int dfs(TreeNode root, int minVal, int maxVal) {

        if (root == null) {
            return maxVal - minVal;
        }

        minVal = Math.min(minVal, root.val);
        maxVal = Math.max(maxVal, root.val);

        int left = dfs(root.left, minVal, maxVal);
        int right = dfs(root.right, minVal, maxVal);

        return Math.max(left, right);
    }

    static int maxAncestorDiff(TreeNode root) {

        if (root == null) return 0;

        return dfs(root, root.val, root.val);
    }

    public static void main(String[] args) {

        TreeNode root = new TreeNode(8);

        root.left = new TreeNode(3);
        root.right = new TreeNode(10);

        root.left.left = new TreeNode(1);
        root.left.right = new TreeNode(6);

        root.left.right.left = new TreeNode(4);
        root.left.right.right = new TreeNode(7);

        System.out.println(
            "Maximum Difference: " +
            maxAncestorDiff(root)
        );
    }
}
