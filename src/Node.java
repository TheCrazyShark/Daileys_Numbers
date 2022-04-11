public class Node {
    //public Node grandparent;
    //public Node parent;
    public Node leftChild;
    public Node rightChild;
    public int iData; // Key
    public int nodeDepth;

    public void displayNode() {
        System.out.print('{');
        System.out.print(iData);
        System.out.print("} ");
    }
}