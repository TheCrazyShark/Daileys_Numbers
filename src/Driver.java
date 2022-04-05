import java.util.Scanner;

public class Driver {
    public static int treeDepth;
    public static BinaryTree DaileysTree;
    public static Scanner input = new Scanner(System.in);

    public static void main(String[] args) {
        System.out.println("Please enter the depth of the tree: ");
        treeDepth = input.nextInt();
    }

    // Build the tree
    public static void buildTree() {

    }

    // Continue to ask the user if they want preorder, inorder, postorder tree traversal
    public static void Menu() {
        int menuNumber = 0;
        boolean quit = false;
        String order = "";

        while(quit != true) {
            System.out.println("What order do you want to traverse the tree?\n1) PreOrder\n2) InOrder\n3) PostOrder\n4) Exit");
            menuNumber = input.nextInt();

            switch(menuNumber){
                case(1):
                    order = "PreOrder";
                    break;
                case(2):
                    order = "InOrder";
                    break;
                case(3):
                    order = "PostOrder";
                    break;
                case(4):
                    order = null;
                    quit = true;
                    break;
            }

            System.out.println("Order Choice: " + order);
            determineNumbers();
        }
    }

    // Determine the missing numbers as well as the count of every numbers
    public static void determineNumbers() {

    }
}