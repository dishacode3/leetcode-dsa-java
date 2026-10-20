package BinaryTree;
public class BalancedBinaryTree {

    static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int val) {
            this.val = val;
        }
    }

    public static boolean isBalanced(TreeNode root) {
        return checkHeight(root) != -1;
    }

    private static int checkHeight(TreeNode root) {
        if (root == null) {
            return 0;
        }

        int leftHeight = checkHeight(root.left);

        if (leftHeight == -1) {
            return -1;
        }

        int rightHeight = checkHeight(root.right);

        if (rightHeight == -1) {
            return -1;
        }

        if (Math.abs(leftHeight - rightHeight) > 1) {
            return -1;
        }

        return 1 + Math.max(leftHeight, rightHeight);
    }

    public static void main(String[] args) {

        // Balanced tree
        TreeNode root = new TreeNode(3);
        root.left = new TreeNode(9);
        root.right = new TreeNode(20);
        root.right.left = new TreeNode(15);
        root.right.right = new TreeNode(7);

        System.out.println("Tree 1 balanced: " + isBalanced(root));

        // Unbalanced tree
        TreeNode root2 = new TreeNode(1);
        root2.left = new TreeNode(2);
        root2.left.left = new TreeNode(3);
        root2.left.left.left = new TreeNode(4);

        System.out.println("Tree 2 balanced: " + isBalanced(root2));
    }
}