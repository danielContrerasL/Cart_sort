package entity;

public class Card {
	private static int CONT_ID = 0;
	private int id;
	private Type type;
	private Values value;
	
	public Card(Type type, Values value) {
		id = CONT_ID++;
		this.type = type;
		this.value = value;
	}
	
	public int getId() {
		return id;
	}
	
	public Type getType() {
		return type;
	}
	
	public Values getValue() {
		return value;
	}
	
	@Override
	public String toString() {
		return id + " " + value +" " + type;
	}

}
