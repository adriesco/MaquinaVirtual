package main;

/**
 * La clase ByteCode representa una instrucción de ByteCode con un nombre y un
 * parámetro opcional.
 */
public class ByteCode {
	private ENUM_BYTECODE name;
	private int param;

	/**
	 * Constructor que inicializa el ByteCode con un nombre.
	 * 
	 * @param enumBytecode el nombre del ByteCode.
	 */
	public ByteCode(ENUM_BYTECODE enumBytecode) {
		this.name = enumBytecode;
	}

	/**
	 * Constructor que inicializa el ByteCode con un nombre y un parámetro.
	 * 
	 * @param enumBytecode el nombre del ByteCode.
	 * @param param        el parámetro del ByteCode.
	 */
	public ByteCode(ENUM_BYTECODE enumBytecode, int param) {
		this.param = param;
		this.name = enumBytecode;
	}

	/**
	 * Devuelve una representación en forma de cadena del ByteCode.
	 * 
	 * @return una cadena que representa el ByteCode.
	 */
	@Override
	public String toString() {
		return this.name.toString() + " " + param;
	}

	/**
	 * Devuelve el nombre del ByteCode.
	 * 
	 * @return el nombre del ByteCode.
	 */
	public ENUM_BYTECODE getName() {
		return this.name;
	}

	/**
	 * Devuelve el parámetro del ByteCode.
	 * 
	 * @return el parámetro del ByteCode.
	 */
	public int getParam() {
		return this.param;
	}
}