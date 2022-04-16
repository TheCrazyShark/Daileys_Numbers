public class Node {
    public Node leftChild;
    public Node rightChild;
    public int iData; // Key
    public int nodeDepth;
    public int grandParent;
    public int greatGrandParent;

    public void displayNode() {
        System.out.print('{');
        System.out.print(iData);
        System.out.print("} ");
    }
}