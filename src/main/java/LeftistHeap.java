public class LeftistHeap {
    private Node root;

    // Constructor
    public LeftistHeap() {
        root = null;
    }

    // Node class
    private class Node {
        int key;
        int rank;
        Node left;
        Node right;

        // Constructor for Node
        Node(int key) {
            this.key = key;
            rank = 1;
            left = null;
            right = null;
        }
    }

    // Merge operation
    private Node merge(Node h1, Node h2) {
        if (h1 == null) return h2;
        if (h2 == null) return h1;

        // Ensure h1 has larger root
        if (h1.key > h2.key) {
            Node temp = h1;
            h1 = h2;
            h2 = temp;
        }

        h1.right = merge(h1.right, h2);

        // Ensure leftist property
        if (h1.left == null || h1.left.rank < h1.right.rank) {
            Node temp = h1.left;
            h1.left = h1.right;
            h1.right = temp;
        }

        // Update rank
        if (h1.right == null || (h1.left != null && h1.left.rank > h1.right.rank)) {
            h1.rank = h1.right != null ? h1.right.rank + 1 : 1;
        } else {
            h1.rank = h1.left.rank + 1;
        }

        return h1;
    }

    // Insert operation
    public void insert(int key) {
        Node newNode = new Node(key);
        root = merge(root, newNode);
    }

    // Delete operation (deleting min key)
    public int deleteMin() {
        if (root == null) {
            throw new IllegalStateException("Heap is empty");
        }

        int min = root.key;
        root = merge(root.left, root.right);
        return min;
    }

    // Method to check if the heap is empty
    public boolean isEmpty() {
        return root == null;
    }

    // Method to get the minimum key without deleting it
    public int findMin() {
        if (root == null) {
            throw new IllegalStateException("Heap is empty");
        }
        return root.key;
    }

    // Method to print the heap (for testing purposes)
    public void printHeap() {
        printHeap(root);
    }

    private void printHeap(Node node) {
        if (node != null) {
            System.out.print(node.key + " ");
            printHeap(node.left);
            printHeap(node.right);
        }
    }
}