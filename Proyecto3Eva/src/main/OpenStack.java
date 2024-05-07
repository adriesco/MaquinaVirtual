package main;

import java.util.Iterator;

public class OpenStack {
	private final int MAX_STACK = 200;
	private int[] Stack = new int[MAX_STACK];
	private int Elements = 0;

	/**
	 * Constructora que inicializa los atributos.
	 */
	public OpenStack() {
		this.Stack = new int[MAX_STACK];
		this.Elements = 0;
	}

	/**
	 * Metodo que comprueba si la pila esta vacia o no
	 * 
	 * @return
	 */
	public boolean isEmpty() {
		if (this.Elements > 0) {
			return false;
		} else
			return true;
	}

	/**
	 * Metodo que mete los numeros en el array
	 * 
	 * @param num
	 * @return
	 */
	public boolean push(int num) {
		if (this.Elements < this.MAX_STACK) {
			this.Stack[Elements] = num;
			this.Elements++;
			return true;
		} else
			return false;
	}

	/**
	 * Metodo que coge el ultimo elemento
	 * 
	 * @return
	 */
	public int pop() {
		int temp = this.Stack[Elements];
		if (isEmpty() == false) {
			this.Elements--;
			return temp;
		} else
			return -1;
	}

	/**
	 * Metodo que retorna el elemento en la cima pero no elimina
	 * 
	 * @return
	 */
	public int getCima() {
		if (isEmpty() == false) {
			return this.Stack[Elements - 1];
		} else
			return -1;
	}

	/**
	 * Metodo que coge el contenido del array y lo convierte en string
	 */
	public String toString() {
		String texto = "";
		if (isEmpty() == false) {
			for (int i = 0; i < this.Elements; i++) {
				texto += this.Stack[i] + " ";
			}
			return texto;
		} else
			return null;
	}
}
