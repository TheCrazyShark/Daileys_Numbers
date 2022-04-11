public class DaileysTree {
    private Node root;
    private int treeDepth;

    public DaileysTree(int depth) {
        treeDepth = depth;

        // Initialize Root
        Node newNode = new Node();
        newNode.iData = 3;
        newNode.nodeDepth = 1;
        root = newNode;

        build(root, 2, 1); // Start recursive building
    }

    // Determine the missing numbers as well as the count of every numbers
    public void findNumbers() {
        /*
            1. Create map
            2. Loop through every value in the tree
            3. For every value in the tree, check if value exists in the map
                4. If no, create new value in the tree with count 1
                5. If yes, add 1 to the value's count
         */

        // Map: geeksforgeeks.org/implementing-associate-array-in-java/
        return;
    }

    public void build(Node current, int grandParentV,  int greatGrandParentV) {
        Node newLeftNode = new Node();    // make new node
        Node newRightNode = new Node();
        Node parent;
        Node grandParent = new Node();
        Node greatGrandParent = new Node();

        while(current.nodeDepth != treeDepth) {
            parent = current;
            grandParent.iData = grandParentV;
            greatGrandParent.iData = greatGrandParentV;

            // Add Left Child
            //current = parent.leftChild;
            if(parent.leftChild == null) { // if end of the line, insert on left
                newLeftNode.iData = parent.iData + greatGrandParent.iData; // Parent + parent’s grandparent
                newLeftNode.nodeDepth = parent.nodeDepth + 1;

                parent.leftChild = newLeftNode;
                System.out.print(newLeftNode.iData + " " + grandParentV + " " + greatGrandParentV + "\n");
                build(parent.leftChild, grandParent.iData, greatGrandParent.iData);
            }

            // Add Right Child
            //current = parent.rightChild;
            if(parent.rightChild == null) { // if end of the line insert on right
                newRightNode.iData = parent.iData + grandParent.iData; //parent + parent’s parent
                newRightNode.nodeDepth = parent.nodeDepth + 1;

                parent.rightChild = newRightNode;
                System.out.print(newRightNode.iData + " " + grandParentV + " " + greatGrandParentV + "\n");
                build(parent.rightChild, parent.iData , grandParent.iData);
            }
        }
    }

    public void traverse(int traverseType) {
        switch(traverseType) {
            case 1: System.out.print("\nPreorder traversal: ");
                preOrder(root);
                break;
            case 2: System.out.print("\nInorder traversal:  ");
                inOrder(root);
                break;
            case 3: System.out.print("\nPostorder traversal: ");
                postOrder(root);
                break;
        }
        System.out.println();
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