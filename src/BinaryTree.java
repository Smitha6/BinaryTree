
import org.omg.CORBA.Any;

import java.util.*; // Needed for level-order print routine
/**
 * BinaryTree class
 * 
 * Implements an unbalanced binary tree - this is not a search tree.
 * @author mccauleyr
 *
 * @param <AnyType>
 */
public class BinaryTree<AnyType> extends HW5_AbstractClass<AnyType> {

    // Basic node stored in unbalanced binary search trees
    private static class BinaryNode<AnyType>
    {
            // Constructors
        BinaryNode( AnyType theElement )
        {
            this( theElement, null, null );
        }

        BinaryNode( AnyType theElement, BinaryNode<AnyType> lt, BinaryNode<AnyType> rt )
        {
            element  = theElement;
            left     = lt;
            right    = rt;
        }

        AnyType element;            // The data in the node
        BinaryNode<AnyType> left;   // Left child
        BinaryNode<AnyType> right;  // Right child
    }

    /** The tree root - the tree class instance variable. */
    private BinaryNode<AnyType> root;

    // Create an empty binary tree
    public BinaryTree() {
    	root = null;
    }
    
    public BinaryTree(AnyType rootElement) {
    	root = new BinaryTree.BinaryNode<AnyType>(rootElement);
    }
    
    // Build a binary tree from existing binary trees, adding a new root value
    // Either or both subtrees could be null
    public BinaryTree(AnyType rootElement, BinaryTree<AnyType> leftTree, BinaryTree<AnyType> rightTree) {
    	 root = new BinaryTree.BinaryNode<AnyType>(rootElement, leftTree.root, rightTree.root);
    }
    
    /* 
     * Public interface to preorder traversal - uses private
     * recursive helper method to accomplish job.
     */
    public void printTreePreOrder () {
    	printTreePreorder(root);
    }
    
    /**
     * private recursive method to print tree contents in preorder
     * @param t
     */
    private void printTreePreorder(BinaryTree.BinaryNode<AnyType> t) {
    	if (t != null) {
    		System.out.println(t.element); // assumes element printable
    		printTreePreorder(t.left);
    		printTreePreorder(t.right);
    	}
    }



    //Todo printTreeInOrder DONE (test more)
    /**
     * printTreeInOrder: Prints the tree in order
     * <Precondition – if applicable>
     */
    public void printTreeInOrder(){
        printTreeInOrder(root);

    }
    private void printTreeInOrder(BinaryNode<AnyType> node){
         if (node != null){

             printTreeInOrder(node.left);

             if (node.element != null)
                 System.out.println(node.element);

             printTreeInOrder(node.right);
         }
    }


    //Todo printTreePostOrder DONE (test more)
    /**
     * printTreePostOrder: Prints the tree in post order
     */
    public void printTreePostOrder(){
        printTreePostOrder(root);
    }
    private void printTreePostOrder(BinaryNode<AnyType> node){
        if (node != null){

            printTreePostOrder(node.left);

            printTreePostOrder(node.right);

            if (node.element != null)
                System.out.println(node.element);

        }
    }


    //Todo size DONE (test more)
    /**
     * size: returns the size of the tree
     */
    public int size(){
        return size(root);
    }
    private int size(BinaryNode<AnyType> node){
        if (node == null)
            return 0;
        return 1 + size(node.left) + size(node.right);
    }


    //Todo depth
    /**
     * depth: Returns the depth of a node
     * given the data of that node
     */
    public int depth(AnyType x){
        if(root == null)
            return 0;

        //might have to use stack


        return 1;

    }




    /**
     * Internal method to compute height of a subtree.
     * Outsiders currently cannot access this method.
     * @param t the node that roots the subtree.
     */
    private int height( BinaryNode<AnyType> t )
    {
        if( t == null )
            return -1;
        else
            return 1 + Math.max( height( t.left ), height( t.right ) );    
    }
    
    /**
     * Does a level-order traversal, printing out a tree that looks
     * something like a tree
     */
    public void printTreeLevelOrder() {
    	printTreeLevelOrder(root);
    }

    /** 
     * Output all nodes, level by level
     * @ param node - the node that roots the current subtree
     */
    private void printTreeLevelOrder(BinaryNode<AnyType> node) {
    	System.out.println("\n============ Start of tree ============");
        if (node == null) {
           System.out.print(" - ");
        }
        else {
          //Queue that holds the nodes on the current level
          Queue<BinaryNode<AnyType>> thisLevel = new LinkedList<>();
          //Queue that holds the nodes on the next level
          Queue<BinaryNode<AnyType>> nextLevel = new LinkedList<>(); 
          //put the root on the current level's queue
          thisLevel.add(node);
          int h = height(root);
          int levelTotal = 0;  //keeps track of the total levels printed so we don't  pass the height and print a billion "null"s
          while(!thisLevel.isEmpty()&& (levelTotal<= h))
          {

              while (!thisLevel.isEmpty()) // print nodes at current level
              {
                 if (thisLevel.peek() != null)
                 {
                    System.out.print(thisLevel.peek().element + " ");
                    // if there is a left pointer , put on next level; if none, put a null
                    node = thisLevel.peek().left; // look at the left pointer of node
                    nextLevel.add(node); 
                    node = thisLevel.remove().right; // get right pointer and remove node
                    nextLevel.add(node); 
                 }
                 else
                 {
                    System.out.print(" - ");
                    nextLevel.add(null); 
                    nextLevel.add(null);
                    thisLevel.remove();
                 }
              }  // end while (!thisLevel.isEmpty())
              // Moving to the next level, copy nodes to thisLevel so we know to 
              // advance level count and line in output
              while (!nextLevel.isEmpty())
              {
                    thisLevel.add(nextLevel.remove());
              } // end while (!nextLevel.isEmpty()
              System.out.println(); 
              levelTotal++;
          } // end while(!thisLevel.isEmpty()&& (levelTotal<= h))
        System.out.println("=========== end of tree ============="); // an extra line feed to separate this prinout of from next
      }

    }

    // Test program
    public static void main( String [ ] args )
    {
    	BinaryTree<String> tree1 = new BinaryTree<>("hello");
    	tree1.printTreeLevelOrder();
     	BinaryTree<String> tree2 = new BinaryTree<>();
    	tree2.printTreeLevelOrder();
     	BinaryTree<String> tree3 = new BinaryTree<>("Charleston",tree1, tree2);
     	tree3.printTreeLevelOrder();
     	tree3 = new BinaryTree<>("there", new BinaryTree<>("wow"), tree3);
        tree3.printTreeLevelOrder();
    	tree3.printTreePreOrder(); // Can't tell the structure of the tree
    	System.out.println("==========================");
    	tree3.printTreeLevelOrder();  
    }
}
