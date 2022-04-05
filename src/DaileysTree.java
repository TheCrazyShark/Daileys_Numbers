public class DaileysTree {
    private Node root;

    public DaileysTree() {
        root = null;
    }

    // Create Children
    public void createChildren(int key) {
        // Get parent node
        // Calculate left child, calculate right child
    }

    // Finds all instances of a specified number
    public int findNumbers(int number) {
        int count = 0;

        return count;
    }

    // PreOrder Traversal
    private void preOrder(Node localRoot) {
        if(localRoot != null) {
            System.out.print(localRoot.iData + " ");
            preOrder(localRoot.leftChild);
            preOrder(localRoot.rightChild);
        }
    }
    // InOrder Traversal
    private void inOrder(Node localRoot) {
        if(localRoot != null) {
            inOrder(localRoot.leftChild);
            System.out.print(localRoot.iData + " ");
            inOrder(localRoot.rightChild);
        }
    }
    // PostOrder Traversal
    private void postOrder(Node localRoot) {
        if(localRoot != null) {
            postOrder(localRoot.leftChild);
            postOrder(localRoot.rightChild);
            System.out.print(localRoot.iData + " ");
        }
    }
}