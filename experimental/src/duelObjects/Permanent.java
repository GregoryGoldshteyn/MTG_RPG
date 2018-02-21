package duelObjects;
import java.util.Vector;

public abstract class Permanent extends Interactable{

	public Vector<Counter> counters;
	public Vector<Effect>[] effects;
	
	//Stuff that creatures need
	public int basePower;
	public int baseToughness;
	public int effectivePower;
	public int effectiveToughness;
	public int damage;
	
}
