
package main;

public enum ENUM_BYTECODE {
	PUSH(1), LOAD(1), STORE(1), ADD, SUB, MUL, DIV, OUT, HALT, REPLACE;

	private int valueArg;

	/**
	 * Constructora
	 */
	ENUM_BYTECODE() {
		this(0);
	}

	/**
	 * Constructora
	 * 
	 * @param n
	 */
	ENUM_BYTECODE(int n) {
		this.valueArg = n;
	}

	/**
	 * Devuelve el número de parámetros que tiene una instrucción
	 * 
	 * @return
	 */
	public int getValueArg() {
		return this.valueArg;
	}
}
