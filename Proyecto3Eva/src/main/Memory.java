package main;

public class Memory {
	private Integer[] memory;
	private final int MAX_NUM;
	private int size;
	private boolean isEmpty;

	/**
	 * Constructor por defecto que inicializa la memoria con una capacidad máxima de
	 * 10 elementos.
	 */
	public Memory() {
		this.MAX_NUM = 10;
		this.memory = new Integer[MAX_NUM];
		this.size = 10;
		this.isEmpty = true;
	}

	/**
	 * Redimensiona la memoria si la posición dada es mayor o igual que el tamaño
	 * actual de la memoria.
	 * 
	 * @param pos la posición que se quiere acceder o modificar.
	 */
	private void resize(int pos) {
		if (pos >= this.size) {
			this.isEmpty = false;
			Integer[] new_memory = new Integer[pos * 2];
			if (this.size >= 0)
				System.arraycopy(this.memory, 0, new_memory, 0, this.size);
			this.memory = new_memory;
		}
	}

	/**
	 * Devuelve una representación en forma de cadena de la memoria. Complejidad
	 * O(n).
	 * 
	 * @return una cadena que representa el contenido de la memoria.
	 */
	public String toString() {
		String cadena = "Memoria: ";
		if (isEmpty) {
			return cadena += "---";
		} else {
			for (int i = 0; i < this.memory.length; i++) {
				if (this.memory[i] != null) {
					cadena += (" [" + i + "]: " + this.memory[i] + " ");
				}
			}
			return cadena;
		}
	}

	/**
	 * Escribe un valor en una posición específica de la memoria.
	 * 
	 * @param pos   la posición donde se quiere escribir el valor.
	 * @param value el valor que se quiere escribir en la memoria.
	 * @return true si el valor se escribió con éxito, false si la posición es
	 *         negativa.
	 */
	public boolean write(int pos, int value) {
		if (pos >= 0) {
			this.isEmpty = false;
			resize(pos);
			this.memory[pos] = value;
			return true;
		} else {
			return false;
		}
	}

	/**
	 * Lee un valor de una posición específica de la memoria.
	 * 
	 * @param _pos la posición de la que se quiere leer el valor.
	 * @return el valor en la posición dada, o -1 si la posición es negativa o el
	 *         valor es nulo.
	 */
	public int read(int _pos) {
		if (this.memory[_pos] != null && _pos >= 0) {
			return this.memory[_pos];
		} else {
			return -1;
		}
	}
}