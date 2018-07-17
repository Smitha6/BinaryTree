public class HW5 {
    /**
     * main: Tests the BinaryTree class
     */
    public static void main(String args[]){

        //tests on empty tree
        BinaryTree<Character> empty = new BinaryTree<>();

        System.out.println("---Print tree InOrder on empty tree---");
        empty.printTreeInOrder();

        System.out.println("---Print tree PostOrder on empty tree---");
        empty.printTreePostOrder();

        System.out.println("Tree size on empty = " + empty.size());




        //builds tree
        BinaryTree<Character> d = new BinaryTree<>('d');
        BinaryTree<Character> e = new BinaryTree<>('e');
        BinaryTree<Character> g = new BinaryTree<>('g');
        //BinaryTree<Character> h = new BinaryTree<>('h');
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



    }
}
