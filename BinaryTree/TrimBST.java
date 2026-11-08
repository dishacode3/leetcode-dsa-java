package BinaryTree;
// Definition for a binary tree node.
class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;
    TreeNode() {}
    TreeNode(int val) { this.val = val; }
    TreeNode(int val, TreeNode left, TreeNode right) {
        this.val = val;
        this.left = left;
        this.right = right;
    }
}

public class TrimBST {
    public TreeNode trimBST(TreeNode root, int low, int high) {
        if (root == null) {
            return null;
        }

        if (root.val < low) {
            return trimBST(root.right, low, high);
        }

        if (root.val > high) {
            return trimBST(root.left, low, high);
        }

        root.left = trimBST(root.left, low, high);
        root.right = trimBST(root.right, low, high);

        return root;
    }

    // Helper method to print the tree (Pre-order traversal) for testing
    public static void printPreorder(TreeNode node) {
        if (node == null) {
            System.out.print("null ");
            return;
        }
        System.out.print(node.val + " ");
        printPreorder(node.left);
        printPreorder(node.right);
    }

    // Main method to test locally in VS Code
    public static void main(String[] args) {
        TrimBST solution = new TrimBST();

        // Example tree: [3, 0, 4, null, 2, null, null, 1]
        // Represented manually:
        TreeNode root = new TreeNode(3);
        root.left = new TreeNode(0);
        root.right = new TreeNode(4);
        root.left.right = new TreeNode(2);
        root.left.right.left = new TreeNode(1);

        int low = 1;
        int high = 3;

        TreeNode trimmedRoot = solution.trimBST(root, low, high);

        System.out.print("Trimmed Tree (Preorder): ");
        printPreorder(trimmedRoot);
        System.out.println();
    }
}