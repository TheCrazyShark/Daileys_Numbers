public class Node {
    public Node leftChild;
    public Node rightChild;
    public int iData; // Key

    public void displayNode() {
        System.out.print('{');
        System.out.print(iData);
        System.out.print("} ");
    }
}
