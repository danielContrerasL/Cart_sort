package logic;

import java.util.Random;

import structure.Stack;
import entity.Card;
import entity.Type;
import entity.Values;

public class Logic {

	private Stack<Card> stack;

	public Logic() {
		stack = new Stack<Card>();
		createDeck();
	}

	private void createDeck() {
		for (Type type : Type.values()) {
			for (Values value : Values.values()) {
				stack.push(new Card(type, value));
			}
		}
	}

	public void unSort(int size, int times) {
		Stack<Card>[] stackArray = new Stack[size];
		for (int i = 0; i < stackArray.length; i++) {
			stackArray[i] = new Stack<Card>();
		}
		Random r = new Random();
		while (!(stack.isEmpty())) {
			stackArray[r.nextInt(stackArray.length)].push(stack.pop());
		}
		for (int i = 0; i < stackArray.length; i++) {
			while (!(stackArray[i].isEmpty())) {
				stack.push(stackArray[i].pop());
			}
		}
		times--;
		if (times <= 0)
			unSort(size, times);
	}

	public void toSort() {
		Stack<Card> stackClub = new Stack<Card>();
		Stack<Card> stackHearth = new Stack<Card>();
		Stack<Card> stackDiamont = new Stack<Card>();
		Stack<Card> stackSword = new Stack<Card>();

		while (!stack.isEmpty()) {
			switch (Type.valueOf(stack.getTop().getInfo().getType().name())) {
			case CORAZON:
				stackHearth.push(stack.pop());
				break;
			case DIAMANTE:
				stackDiamont.push(stack.pop());
				break;
			case PICA:
				stackSword.push(stack.pop());
				break;
			case TREBOL:
				stackClub.push(stack.pop());
				break;
			}
		}

		for (int i = 0; i < 6; i++) {

			stackClub = ordenar(stackClub);

		}

		while (!stackClub.isEmpty()) {
			System.out.println(stackClub.pop());
		}
	}

	private Stack<Card> ordenar(Stack<Card> deckOfCard) {
		Stack<Card> stackOne = new Stack<Card>();
		Stack<Card> stackTwo = new Stack<Card>();

		while (!deckOfCard.isEmpty()) {
			if (stackOne.isEmpty()) {
				stackOne.push(deckOfCard.pop());
			} else {
				if (deckOfCard.getTop().getInfo().getValue().getIndex() > stackOne
						.getTop().getInfo().getValue().getIndex()) {
					stackOne.push(deckOfCard.pop());
				} else {
					stackTwo.push(deckOfCard.pop());
				}

			}
		}

		while (!stackTwo.isEmpty() || !stackOne.isEmpty()) {
			if (stackOne.isEmpty()) {
				deckOfCard.push(stackTwo.pop());
			} else if (stackTwo.isEmpty()) {
				deckOfCard.push(stackOne.pop());
			} else {
				if (stackOne.getTop().getInfo().getValue().getIndex() > stackTwo
						.getTop().getInfo().getValue().getIndex()) {
					deckOfCard.push(stackOne.pop());
				} else {
					deckOfCard.push(stackTwo.pop());
				}
			}
		}
		return deckOfCard;
	}

	public void print() {
		System.out
				.println("^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^");
		Card auxiliarCard;
		Stack<Card> auxiliarStack = new Stack<Card>();
		while (!(stack.isEmpty())) {
			auxiliarCard = stack.pop();
			System.out.println(auxiliarCard.toString());
			auxiliarStack.push(auxiliarCard);
		}
		stack = auxiliarStack;
		System.out
				.println("_______________________________________________________________________");
	}

	public static void main(String[] args) {
		Logic l = new Logic();
		for (int i = 0; i < 10; i++) {
			l.unSort(15, 12);
		}
		l.toSort();
		// l.print();

	}

}
