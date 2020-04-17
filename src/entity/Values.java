package entity;

public enum Values {

	A(1, 1),TWO(2,2),THREE(3,3),FOUR(4,4),FIVE(5,5),SIX(6,6),SEVEN(7,7),EIGHT(8,8),NINE(9,9),TEN(10,10),J(10,11),Q(10,12),K(10,13);
	private int value;
	private int index;
	
	private Values(int value, int index){
	this.value = value;	
	this.index = index;
	}
	
	public int getValue() {
		return value;
	}
	public int getIndex() {
		return index;
	}
}