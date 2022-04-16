import java.util.Scanner;

public class Driver {
    public static int treeDepth;
    public static DaileysTree DaileysTree;
    public static Scanner input = new Scanner(System.in);

    public static void main(String[] args) {
        do {
            System.out.println("Please enter the depth of the tree (between 2-26): ");
            treeDepth = input.nextInt();
        } while(treeDepth < 2 && treeDepth > 26);

        DaileysTree = new DaileysTree(treeDepth);
        Menu();
        DaileysTree.findNumbers();
    }

    // Continue to ask the user if they want preorder, inorder, postorder tree traversal
    public static void Menu() {
        int menuNumber = 0;
        boolean quit = false;
        String order = "";

        while (quit != true) {
            System.out.println("What order do you want to traverse the tree?\n1) PreOrder\n2) InOrder\n3) PostOrder\n4) Exit Order Selection");
            menuNumber = input.nextInt();

            switch (menuNumber) {
                case (1):
                    DaileysTree.traverse(menuNumber);
                    order = "PreOrder";
                    System.out.println("Order Choice: " + order);
                    break;
                case(2):
                    DaileysTree.traverse(menuNumber);
                    order = "InOrder";
                    System.out.println("Order Choice: " + order);
                    break;
                case(3):
                    DaileysTree.traverse(menuNumber);
                    order = "PostOrder";
                    System.out.println("Order Choice: " + order);
                    break;
                case (4):
                    quit = true;
                    break;
            }
        }
    }
}