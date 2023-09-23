package _06_How_Many_Are_Smaller_Than_Me;

import _03_Intro_to_Binary_Trees.Node;
import _05_Intro_to_AVL_Trees.AVLNode;
import _05_Intro_to_AVL_Trees.AVLTree;

public class HowManyAreSmallerThanMe {

	 /*
	 * Given an AVLTree filled with the random numbers from 1 to 20, and a single
	 * number within the AVL Tree, figure out how many numbers in the AVLTree are
	 * smaller than the provided number and return the result.
	 * 
	 * You may want to create a helper method to search through the AVLTree and
	 * count iteratively or recursively.
	 */
	static int counter = 0;
	public int howManyAreSmallerThanMe(AVLTree<Integer> avlTree, int me) {
		System.out.println(me);
		avlTree.printVertical();
		helpmepls(avlTree.getRoot(), me);
		return counter;
	}

	public static void helpmepls(AVLNode<Integer> avlNode, int number) {
		if (avlNode != null) {
			if (avlNode.getValue() < number) {
				counter+=1;
			}
			helpmepls(avlNode.getLeft(), number);
			helpmepls(avlNode.getRight(), number);

		}

	}
}
