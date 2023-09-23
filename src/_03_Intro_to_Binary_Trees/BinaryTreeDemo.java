package _03_Intro_to_Binary_Trees;

public class BinaryTreeDemo {

    /*
     * A Binary Tree is a data structure that makes use of nodes and references
     * like a LinkedList, but instead of the nodes pointing to a previous node
     * or next node in an unorderd list they each points to two child nodes that
     * are below them in the hierarchy.
     * 
     * Some important properties of BinaryTree are:
     * 
     * -The left node is always a smaller value than its parent and the right
     * node is always a larger value. This is a property you have seen in some
     * form already via Binary Search.
     * 
     * -Empty nodes are null references.
     * 
     * -The parent node at the very top of the tree is called the root.
     * 
     * 1. Read through the BinaryTree and Node classes.
     * 
     * 2. Create a BinaryTree of any type you like.
     * 
     * 3. Try using some BinaryTree methods to insert, search for, delete and
     * print elements.
     * 
     * 4. Save the root into a Node Object and use references to traverse
     * through the BinaryTree and perform an operation on every element(You may
     * choose to do this recursively or iteratively). Then print it out to see
     * if it worked.
     * 
     */

    public static void main(String[] args) {
    	BinaryTree <String> bt = new BinaryTree <String> ();
    	String root = "JROOT";
    	String babLroot = "AROOT";
    	String babRroot = "ZROOT";
    	Node <String> n = new Node <String> (root);
    	Node <String> n1 = new Node <String> (babLroot);
    	Node <String> n2 = new Node <String> (babRroot);
    	n.setLeft(n1);
    	n.setRight(n2);
    	bt.insert(root);
    	bt.insert(babLroot);
    	bt.insert(babRroot);
    	System.out.println(bt.getRoot().getValue());
    	System.out.println(bt.search("bLoot"));
    	helpmepls(bt.getRoot());
    	bt.printHorizontal();
    }
    public static void helpmepls(Node <String> hmp) {
    	if (hmp != null) {
    		hmp.setValue("oof!");
    		helpmepls(hmp.getLeft());
        	helpmepls(hmp.getRight());
    	}
    	
    }

}
