package main;


public class OpenStack {
	private int[] stack;
	private int num_elements;
	private int MAX_NUM;

	/**
	 * Constructor por defecto que inicializa la pila con una capacidad máxima de 10
	 * elementos.
	 */
	public OpenStack() {
		this.MAX_NUM = 10;
		this.num_elements = 0;
		this.stack = new int[MAX_NUM];
	}

	/**
	 * Comprueba si la pila está vacía.
	 * 
	 * @return true si la pila está vacía, false en caso contrario.
	 */
	public boolean isEmpty() {
		return this.num_elements == 0;
	}

	/**
	 * Añade un elemento a la cima de la pila.
	 * 
	 * @param _elemento el elemento a añadir a la pila.
	 * @return true si el elemento se añadió con éxito, false si la pila está llena.
	 */
	public boolean push(int _elemento) {
		if (this.num_elements < MAX_NUM) {
			this.stack[this.num_elements] = _elemento;
			this.num_elements++;
			return true;
		} else {
			return false;
		}
	}

	/**
	 * Devuelve y elimina el elemento en la cima de la pila.
	 * 
	 * @return el elemento en la cima de la pila, o -1 si la pila está vacía.
	 */
	public int pop() {
		if (isEmpty()) {
			return -1;
		} else {
			int ultimo = this.stack[this.num_elements - 1];
			this.num_elements--;
			return ultimo;
		}
	}

	/**
	 * Devuelve una representación en forma de cadena de la pila.
	 * 
	 * @return una cadena que representa el contenido de la pila.
	 */
	public String toString() {
		String cadena = "Pila: ";
		if (isEmpty()) {
			return cadena += "---";
		} else {
			for (int i = 0; i < this.num_elements; i++) {
				cadena += (" " + this.stack[i] + " ");
			}
			return cadena;
		}
	}
}