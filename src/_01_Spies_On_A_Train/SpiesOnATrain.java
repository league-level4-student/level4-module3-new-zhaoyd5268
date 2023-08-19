package _01_Spies_On_A_Train;

import java.util.HashMap;

import _00_Intro_to_Linked_Lists.LinkedList;
import _00_Intro_to_Linked_Lists.Node;

public class SpiesOnATrain {

	/*
	 * A spy has made off with important intel from your intelligence agency! You
	 * know the spy is somewhere on this train(LinkedList). Your job is to find the
	 * suspect that matches the description given to you by the list of clues(the
	 * array).
	 * 
	 * Walk through the train, questioning each of the passengers about what they
	 * have seen and return the name of the most likely suspect.
	 * 
	 * The results are randomly generated each time so you should have a general
	 * case solution that carefully compares the clues to each passenger's
	 * testimony. Remember to use String methods to break up the passengers'
	 * statements.
	 */
	String findIntel(LinkedList<TrainCar> train, String[] clues) {
		String suspect = "";
		Node<TrainCar> whatOn = train.getHead();
		for (int j = 0; j < 14; j++) {
			train.print();
			for (int i = 0; i < clues.length; i++) {
				System.out.println(clues[i]);
			}
			String s = whatOn.getValue().questionPassenger();
			System.out.println(s);
			String[] newS = s.split("I saw ");
			String[] nameAndEvidence = newS[1].split(" ");
			String[] EvidenceArray = newS[1].split(nameAndEvidence[0]);
			String Evidence = EvidenceArray[1].trim();
			System.out.println(Evidence);
			for (int i = 0; i < clues.length; i++) {
				if (Evidence.equalsIgnoreCase(clues[i])) {
					suspect = EvidenceArray[0];
					
				} else {
					System.out.println(suspect);

				}

			}
			
			whatOn = whatOn.getNext();
			
		}
		return suspect;
	}
}
