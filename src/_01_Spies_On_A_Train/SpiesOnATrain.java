package _01_Spies_On_A_Train;

import java.util.ArrayList;
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
		String suspect = "noofin happened";
		Node<TrainCar> whatOn = train.getHead();
		HashMap<String, Integer> h = new HashMap<String, Integer>();
		ArrayList<String> listOfSuspects = new ArrayList<String>();
		for (int j = 0; j < train.size(); j++) {
			String st = whatOn.getValue().questionPassenger();
			String[] newS = st.split("I saw ");
			String[] EvidenceArray = newS[1].split(" ");
			String evidence = EvidenceArray[1];
			for (int i = 1; i < EvidenceArray.length - 1; i++) {
				evidence = evidence + " " + EvidenceArray[i + 1];
			}
			evidence = evidence.replace(".", "");
			for (int i = 0; i < clues.length; i++) {
				if (evidence.equalsIgnoreCase(clues[i])) {
					if (h.containsKey(EvidenceArray[0])) {
						int newnumber = h.get(EvidenceArray[0]);
						h.put(EvidenceArray[0], newnumber+1);
					} else {
						listOfSuspects.add(EvidenceArray[0]);
						h.put(EvidenceArray[0], 0);
					}

				}
			}
			
			if (whatOn.getNext() != null) {
				whatOn = whatOn.getNext();
			}

			
		}
		for (int i = 0; i < h.size(); i++) {
			if (h.get(listOfSuspects.get(i)) == 2) {
				suspect = listOfSuspects.get(i);
			}
		}
		return suspect;
	}
}
