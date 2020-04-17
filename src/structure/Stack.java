package structure;

/**
 * 
 * @author Daniel Felipe Contreras Lopez
 * @author daniel.contreras@uptc.edu.co
 * @author cldfrkr@hotmail.com
 * @param <T>
 */
public class Stack<T> extends Node<T> {

	private Node<T> top;

	/**
	 * Crea un Pila Vacia
	 */
	public Stack() {
		this.top = null;
	}

	/**
	 * Agrega Un nuevo nodo a la Pila
	 * 
	 * @param info
	 *            Tipo T
	 */
	public void push(T info) {
		this.top = new Node<T>(info, this.top);
	}
	
	/**
	 * Retira el ultimo elemento de la Pila
	 * 
	 * @return Info Tipo T
	 */
	public T pop() {
		if (!(this.top == null)) {
			T aux = this.top.getInfo();
			this.top = this.top.getNext();
			return aux;
		}
		return null;
	}
	
	public void clear() {
		while (top != null) {
			pop();
		}
	}
	
	public boolean isEmpty() {
		return this.top == null;
	}

	public Node<T> getTop() {
		return this.top;
	}

}
