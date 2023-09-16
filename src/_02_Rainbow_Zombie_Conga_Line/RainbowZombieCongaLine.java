package _02_Rainbow_Zombie_Conga_Line;

import java.awt.Color;

import _00_Intro_to_Linked_Lists.LinkedList;
import _00_Intro_to_Linked_Lists.Node;

public class RainbowZombieCongaLine {

	/*
	 * You are hosting a rainbow zombie conga dance party! Zombies are not very
	 * smart(maybe that's why they crave brains) and need your help to direct them
	 * through the choreography.
	 * 
	 * Each method is a dance move you will need to implement.
	 * 
	 * When you think you've gotten your zombies trained well enough you can start
	 * the party by running the main method in RainbowZombieDanceParty and typing
	 * how many rounds you want in the console to see if they followed your
	 * choreography correctly.
	 * 
	 * Note: The party will always start with a rainbow brains and every 5 rounds
	 * the head and tail of the dance line will be removed.
	 */

	private LinkedList<Zombie> congaLine;
	private ZombieHatColor[] zombieHats;

	public RainbowZombieCongaLine() {

		congaLine = new LinkedList<Zombie>();
		zombieHats = ZombieHatColor.values();

	}

	// Make the passed in zombie the first Zombie in the conga line!
	public void engine(Zombie dancer) {
		Node<Zombie> head = congaLine.getHead();
		Node<Zombie> newDancer = new Node<Zombie>(dancer);
		congaLine.setHead(newDancer);
		head.setPrev(newDancer);
		newDancer.setNext(head);
	}

	// Make the passed in zombie the last Zombie in the conga line!
	public void caboose(Zombie dancer) {
		Node<Zombie> tail = congaLine.getTail();
		Node<Zombie> newDancer = new Node<Zombie>(dancer);
		congaLine.setTail(newDancer);
		tail.setNext(newDancer);
	}

	// Place the zombie at the designated position in the conga line!
	public void jumpInTheLine(Zombie dancer, int position) {
		Node<Zombie> currentNode = congaLine.getHead();
		Node<Zombie> whatOn = congaLine.getHead();
		Node<Zombie> d = new Node<Zombie>(dancer);

		for (int i = 0; i < position; i++) {
			currentNode = whatOn;
			whatOn = whatOn.getNext();
		}
		d.setPrev(currentNode);
		d.setNext(whatOn);
		currentNode.setNext(d);
		whatOn.setPrev(d);
	}

	/*
	 * Remove all zombies with the same hat color as the passed in zombie from the
	 * conga line!
	 */
	public void everyoneOut(Zombie dancer) {
		Node<Zombie> temporary = congaLine.getHead();
		for (int i = 0; i < congaLine.size(); i++) {
			if (temporary.getValue().getZombieHatColor() == (dancer.getZombieHatColor())) {
				congaLine.remove(i);
				
			} else {
				temporary = temporary.getNext();
			}
		}
	}

	/*
	 * Remove the first zombie with the same hat color as the passed in zombie from
	 * the conga line!
	 */
	public void youAreDone(Zombie dancer) {
		Node<Zombie> whatOn = congaLine.getHead();
		for (int i = 0; i < congaLine.size(); i++) {
			if (whatOn.getValue().getZombieHatColor() == (dancer.getZombieHatColor())) {
				congaLine.remove(i);
				break;
			}
			whatOn = whatOn.getNext();
		}
	}

	/*
	 * Make two more zombies with the same hat color as the passed in zombie and add
	 * one to the front, one to the end and one in the middle.
	 */
	public void brains(Zombie dancer) {
		Node<Zombie> d = new Node<Zombie>(dancer);
		Node<Zombie> d1 = new Node<Zombie>(dancer);
		Node<Zombie> head = congaLine.getHead();
		Node<Zombie> tail = congaLine.getTail();
		congaLine.setHead(d);
		d.setNext(head);
		head.setPrev(d);
		congaLine.setTail(d1);
		tail.setNext(d1);
		d1.setPrev(tail);
		jumpInTheLine(dancer, congaLine.size() / 2);
	}

	/*
	 * Add the passed in zombie to the front and then add one zombie of each hat
	 * color to the end of the line.
	 */
	public void rainbowBrains(Zombie dancer) {
		Zombie Zombie = new Zombie(ZombieHatColor.R);
		Zombie Zombie1 = new Zombie(ZombieHatColor.O);
		Zombie Zombie2 = new Zombie(ZombieHatColor.Y);
		Zombie Zombie3 = new Zombie(ZombieHatColor.G);
		Zombie Zombie4 = new Zombie(ZombieHatColor.B);
		Zombie Zombie5 = new Zombie(ZombieHatColor.I);
		Zombie Zombie6 = new Zombie(ZombieHatColor.V);    		
		Node <Zombie> head = new Node <Zombie> (dancer);
    		Node <Zombie> tail = new Node <Zombie> (Zombie6);
    		congaLine.setHead(head);
			congaLine.setTail(tail);
    			Node <Zombie> x = new Node <Zombie> (Zombie1);
    			x.setPrev(head);
    			head.setNext(x);
    			x.setNext(tail);
    			Node <Zombie> x1 = new Node <Zombie> (Zombie2);
    			x1.setPrev(x);
    			x.setNext(x1);
    			x1.setNext(tail);
    			Node <Zombie> x2 = new Node <Zombie> (Zombie3);
    			x2.setPrev(x1);
    			x1.setNext(x2);
    			x2.setNext(tail);
    			Node <Zombie> x3 = new Node <Zombie> (Zombie4);
    			x3.setPrev(x2);
    			x2.setNext(x3);
    			x3.setNext(tail);
    			Node <Zombie> x4 = new Node <Zombie> (Zombie5);
    			x4.setPrev(x3);
    			x3.setNext(x4);
    			x4.setNext(tail);
    }

	public LinkedList<Zombie> getCongaLine() {
		return congaLine;
	}
}
