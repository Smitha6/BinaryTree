public class HW5 {
    /**
     * Homework 5, Summer 2018
     * main: Tests the BinaryTree class
     * @author A. Smith
     */
    public static void main(String args[]){

        //tests on empty tree
        BinaryTree<Character> empty = new BinaryTree<>();

        System.out.println("---Print tree InOrder on empty tree---");
        empty.printTreeInOrder();

        System.out.println("---Print tree PostOrder on empty tree---");
        empty.printTreePostOrder();

        System.out.println("Tree size on empty = " + empty.size());

        System.out.println("Depth of node with value " + 'a' + " on empty =  " + empty.depth('a'));




        //builds tree
        BinaryTree<Character> d = new BinaryTree<>('d');
        BinaryTree<Character> e = new BinaryTree<>('e');
        BinaryTree<Character> g = new BinaryTree<>('g');
        BinaryTree<Character> subLeft = new BinaryTree<>('b',d,e);
        BinaryTree<Character> subRight = new BinaryTree<>('f',g,empty);
        BinaryTree<Character> right = new BinaryTree<>('c',empty,subRight);
        BinaryTree<Character> tree = new BinaryTree<>('a',subLeft,right);

        System.out.print("---Testing built tree---");
        tree.printTreeLevelOrder();




        System.out.println("---Print tree InOrder---");
        tree.printTreeInOrder();

        System.out.println("---Print tree PostOrder---");
        tree.printTreePostOrder();

        System.out.println("\nTree size = " + tree.size());

        char letter = 'a';
        System.out.println("\nDepth of node with value " + letter + " = " + tree.depth(letter));
        letter = 'b';
        System.out.println("\nDepth of node with value " + letter + " = " + tree.depth(letter));
        letter = 'c';
        System.out.println("\nDepth of node with value " + letter + " = " + tree.depth(letter));
        letter = 'd';
        System.out.println("\nDepth of node with value " + letter + " = " + tree.depth(letter));
        letter = 'e';
        System.out.println("\nDepth of node with value " + letter + " = " + tree.depth(letter));
        letter = 'f';
        System.out.println("\nDepth of node with value " + letter + " = " + tree.depth(letter));
        letter = 'g';
        System.out.println("\nDepth of node with value " + letter + " = " + tree.depth(letter));

        letter = 'z';
        System.out.println("\nDepth of node with value " + letter + " = " + tree.depth(letter));

    }
}
