package _05_Intro_to_AVL_Trees;

import _03_Intro_to_Binary_Trees.BinaryTree;
import _03_Intro_to_Binary_Trees.Node;

public class AVLTreeDemo {

    /*
     * An AVLTree is a special BinaryTree that is capable of balancing itself.
     * With a regular binary tree, depending on the elements inserted, you might
     * have a root with one very long right branch and one very long left branch
     * with nothing else in between.
     * 
     * 1.) Read through the AVLNode and AVLTree. Notice that the methods are
     * similar to those in BinaryTree with two important distinctions:
     * 
     * a) Each Node has a balance factor that keeps track of how many levels
     * "down" it is relative to the rest of the tree.
     * 
     * b) There are "rotate" helper methods used when a given node gets too
     * unbalanced(> 1 level out of sync with the rest of the tree) to rotate
     * branches back into place.
     * 
     * 2.) Create a BinaryTree and an AVLTree.
     * 
     * 3.) Insert the same values into both trees and observe how they differ
     * using the print method. Make sure the values you pick unbalance the
     * binary tree.
     * 
     * 4.) Try removing elements from both and see how they change using one of
     * the print methods.
     */

    public static void main(String[] args) {
    	BinaryTree <Integer> bt = new BinaryTree <Integer> ();
    	AVLTree <Integer> avlt = new AVLTree <Integer> ();
    	int root = 4;
    	int babLroot = 7;
    	int babRroot = 12;
    	int babXroot = 55555;
    	Node <Integer> n = new Node <Integer> (root);
    	Node <Integer> n1 = new Node <Integer> (babLroot);
    	Node <Integer> n2 = new Node <Integer> (babRroot);
    	Node <Integer> n3 = new Node <Integer> (babXroot);
    	n.setRight(n1);
    	n.setRight(n2);
    	n2.setRight(n3);
    	bt.insert(root);
    	bt.insert(babLroot);
    	bt.insert(babRroot);
    	bt.insert(babXroot);
    	avlt.insert(root);
    	avlt.insert(babLroot);
    	avlt.insert(babRroot);
    	avlt.insert(babXroot);
    	bt.printVertical();
    	avlt.printVertical();
    	bt.delete(4);
    	avlt.delete(7);
    	bt.printVertical();
    	avlt.printVertical();
    }

}
