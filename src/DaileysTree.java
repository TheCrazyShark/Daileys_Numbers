import java.util.HashMap;
import java.util.Map;

public class DaileysTree {
    private Node root;
    private int treeDepth;
    private int highestValue;
    private HashMap<Integer, Integer> hmap;
    private int missingNums[];

    public DaileysTree(int depth) {
        treeDepth = depth;
        highestValue = 0;
        hmap = new HashMap<Integer, Integer>();
        hmap.put(1,1);
        hmap.put(2,1);

        // Initialize Root
        Node newNode = new Node();
        newNode.iData = 3;
        newNode.nodeDepth = 1;
        newNode.grandParent = 2;
        newNode.greatGrandParent = 1;
        root = newNode;

        build(root); // Start recursive building
    }

    // Recursively build entire tree
    public void build(Node current) {
        Node newLeftNode = new Node();    // make new node
        Node newRightNode = new Node();
        Node parent;
        int count;

        // Checks current value & puts number into hashmap or increment count if value already exists
        if (hmap.get(current.iData) == null) {
            hmap.put(current.iData, 1);
        } else {
            count = hmap.get(current.iData);
            count++;
            hmap.put(current.iData, count);
        }

        while(current.nodeDepth != treeDepth && current.leftChild == null && current.rightChild == null) {
            parent = current;

            // Make Left Node
            newLeftNode.iData = parent.iData + parent.greatGrandParent; // Parent + parent’s grandparent
            newLeftNode.nodeDepth = parent.nodeDepth + 1;
            parent.leftChild = newLeftNode;

            // Make Right Node
            newRightNode.iData = parent.iData + parent.grandParent; // Parent + parent’s parent
            newRightNode.nodeDepth = parent.nodeDepth + 1;
            parent.rightChild = newRightNode;

            // Assign new grandparent/great grandparent values
            newLeftNode.greatGrandParent = parent.grandParent;
            newLeftNode.grandParent = parent.iData;
            newRightNode.greatGrandParent = parent.grandParent;
            newRightNode.grandParent = parent.iData;

            // Get new highest value
            if(parent.rightChild.iData > highestValue) {
                highestValue = current.rightChild.iData;
            }

            // Build out tree left and right
            build(parent.leftChild);
            build(parent.rightChild);
        }
    }

    // Determine the missing numbers as well as display the count of every numbers
    public void findNumbers() {
        // Check if every number to highest value is in hashmap, if not add it w/ count 0
        for(int i=1; i<=highestValue; i++) {
            if (hmap.get(i) == null) {
                hmap.put(i, 0);
            }
        }

        // Print out all missing numbers
        System.out.print("Missing: ");
        for (int key : hmap.keySet()) {
            if(hmap.get(key) == 0) {
                System.out.print(key + " ");
            }
        }

        // Print out counts of all numbers
        System.out.println("\nCounts");
        for( Map.Entry<Integer, Integer> entry : hmap.entrySet() ){
            System.out.println( entry.getKey() + ": " + entry.getValue() );
        }
    }

    // Start recursive traversal based on type
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