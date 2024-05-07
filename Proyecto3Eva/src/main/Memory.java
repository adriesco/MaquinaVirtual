package main;

public class Memory {
	private int Max_memory;
	private int size = 5;
	private Integer[] memory = new Integer[size];
	private boolean empty;

	/**
	 * Constructor de la clase Memory.
	 */
	public Memory() {
		this.empty = true;
	}

	/**
	 * Métodopara redimensionar el array de memoria si es necesario.
	 * 
	 * @param pos La posición a la que se intenta acceder en la memoria.
	 */
	private void resize(int pos) {
		if (pos >= size) {
			this.empty = false;
			Integer[] array2 = new Integer[pos * 2];
			for (int i = 0; i < this.memory.length; i++) {
				array2[i] = this.memory[i];
			}
			this.memory = array2;
		}
	}

	/**
	 * Escribe un entero en la posición especificada de la memoria.
	 * 
	 * @return true si se escribe , false si la posición es inválida.
	 */
	public boolean write(int pos, int x) {
		if (pos >= 0) {
			this.resize(pos);
			this.memory[pos] = x;
			return true;
		} else {
			return false;
		}
	}

	/**
	 * Lee el numero almacenado en la posición especificada de la memoria.
	 * 
	 * @param pos La posición de la que se desea leer el numero.
	 * @return El entero almacenado en la posición especificada
	 */
	public Integer read(int pos) {
		if (this.memory[pos] == null) {
			return -1;
		} else {
			return this.memory[pos];
		}
	}

	/**
	 * Retorna una representación en cadena de la memoria.
	 * 
	 * @return Una cadena que representa los enteros almacenados en la memoria,
	 *         separados por espacios, o null si la memoria está vacía.
	 */
	public String toString() {
		String texto = "";
		if (!empty) {
			for (int i = 0; i < memory.length; i++) {
				if (this.memory[i] == null) {

				} else {
					texto += this.memory[i] + " ";
				}
			}
			return texto;
		} else {
			return null;
		}
	}
}