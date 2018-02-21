package duelObjects;
import java.util.Vector;

public abstract class Interactable {
	public Card card;
	public Player controller;
	public Player owner;
	
	public Vector<InteractableType> types;
}
