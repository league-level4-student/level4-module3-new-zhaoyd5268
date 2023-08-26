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
		for (int k = 0; k < train.size(); k++) {
			for (int j = 0; j < train.size(); j++) {
				train.print();
				for (int i = 0; i < clues.length; i++) {
					System.out.println(clues[i]);
				}
				String st = whatOn.getValue().questionPassenger();
				System.out.println(st);
				String[] newS = st.split("I saw ");
				String[] EvidenceArray = newS[1].split(" ");
				String evidence = EvidenceArray[1];
				for (int i = 1; i < EvidenceArray.length - 1; i++) {
					evidence = evidence + " " + EvidenceArray[i + 1];
				}
				evidence = evidence.replace(".", "");
				System.out.println(evidence);
				for (int i = 0; i < clues.length; i++) {
					if (evidence.equalsIgnoreCase(clues[i])) {
						suspect = EvidenceArray[0];
					}
				}
				whatOn = whatOn.getNext();
			}
			System.out.println(suspect);
		}
		System.out.println(suspect);
		return suspect;
	}
}
