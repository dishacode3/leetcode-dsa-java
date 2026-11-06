package BinaryTree;
// Save this file as DeleteNodeBST.java

class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;
    
    TreeNode() {}
    
    TreeNode(int val) { 
        this.val = val; 
    }
    
    TreeNode(int val, TreeNode left, TreeNode right) {
        this.val = val;
        this.left = left;
        this.right = right;
    }
}

public class DeleteNodeBST {
    public TreeNode deleteNode(TreeNode root, int key) {
        if (root == null) {
            return null;
        }

        // Stage 1: Search for the node to remove
        if (key < root.val) {
            root.left = deleteNode(root.left, key);
        } else if (key > root.val) {
            root.right = deleteNode(root.right, key);
        } else {
            // Stage 2: Node found
            
            // Case 1 & 2: Node has 0 or 1 child
            if (root.left == null) {
                return root.right;
            } else if (root.right == null) {
                return root.left;
            }

            // Case 4: Node has 2 children
            // Find the in-order successor (min value in the right subtree)
            TreeNode successor = findMin(root.right);
            
            // Replace current node's value with successor's value
            root.val = successor.val;
            
            // Delete the successor from the right subtree
            root.right = deleteNode(root.right, successor.val);
        }

        return root;
    }

    // Helper method to find the minimum node in a subtree
    private TreeNode findMin(TreeNode node) {
        while (node.left != null) {
            node = node.left;
        }
        return node;
    }

    // Optional: A simple main method to test your code in VS Code
    public static void main(String[] args) {
        DeleteNodeBST solver = new DeleteNodeBST();

        // Constructing tree: [5,3,6,2,4,null,7]
        TreeNode root = new TreeNode(5);
        root.left = new TreeNode(3);
        root.right = new TreeNode(6);
        root.left.left = new TreeNode(2);
        root.left.right = new TreeNode(4);
        root.right.right = new TreeNode(7);

        // Delete key 3
        root = solver.deleteNode(root, 3);

        System.out.println("Node deleted successfully!");
    }
}