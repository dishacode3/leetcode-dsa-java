package BinaryTree;
public class ValidateBST {

    static class TreeNode {
        int val;
        TreeNode left, right;

        TreeNode(int val) {
            this.val = val;
        }
    }

    public static boolean isValidBST(TreeNode root) {
        return validate(root, Long.MIN_VALUE, Long.MAX_VALUE);
    }

    private static boolean validate(
            TreeNode node, long min, long max) {

        if (node == null) {
            return true;
        }

        if (node.val <= min || node.val >= max) {
            return false;
        }

        return validate(node.left, min, node.val)
            && validate(node.right, node.val, max);
    }

    public static void main(String[] args) {

        TreeNode root = new TreeNode(10);

        root.left = new TreeNode(5);
        root.right = new TreeNode(15);

        root.right.left = new TreeNode(12);
        root.right.right = new TreeNode(20);

        System.out.println(isValidBST(root));

        // Invalid BST example
        TreeNode root2 = new TreeNode(10);

        root2.left = new TreeNode(5);
        root2.right = new TreeNode(15);

        root2.right.left = new TreeNode(6);
        root2.right.right = new TreeNode(20);

        System.out.println(isValidBST(root2));
    }
}