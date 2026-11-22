package BinaryTree;

import java.util.*;

public class MaximumWidthOfBinaryTree {

    static class TreeNode {
        int val;
        TreeNode left, right;

        TreeNode(int val) {
            this.val = val;
        }
    }

    static class Pair {
        TreeNode node;
        long index;

        Pair(TreeNode node, long index) {
            this.node = node;
            this.index = index;
        }
    }

    public static int widthOfBinaryTree(TreeNode root) {

        if (root == null) {
            return 0;
        }

        Queue<Pair> queue = new LinkedList<>();

        queue.offer(new Pair(root, 0));

        int maxWidth = 0;

        while (!queue.isEmpty()) {

            int size = queue.size();

            long minIndex = queue.peek().index;

            long first = 0;
            long last = 0;

            for (int i = 0; i < size; i++) {

                Pair current = queue.poll();

                long index = current.index - minIndex;

                if (i == 0) {
                    first = index;
                }

                if (i == size - 1) {
                    last = index;
                }

                if (current.node.left != null) {
                    queue.offer(new Pair(
                        current.node.left, 2 * index + 1
                    ));
                }

                if (current.node.right != null) {
                    queue.offer(new Pair(
                        current.node.right, 2 * index + 2
                    ));
                }
            }

            maxWidth = Math.max(
                maxWidth, (int)(last - first + 1)
            );
        }

        return maxWidth;
    }

    public static void main(String[] args) {

        TreeNode root = new TreeNode(1);

        root.left = new TreeNode(3);
        root.right = new TreeNode(2);

        root.left.left = new TreeNode(5);
        root.left.right = new TreeNode(3);

        root.right.right = new TreeNode(9);

        System.out.println(widthOfBinaryTree(root));
    }
}
