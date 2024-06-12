package main;

public class ByteCode {
	private ENUM_BYTECODE name;
	private int param;

	public ByteCode(ENUM_BYTECODE enumBytecode) {
		this.name = enumBytecode;
	}

	public ByteCode(ENUM_BYTECODE enumBytecode, int param) {
		this.param = param;
		this.name = enumBytecode;
	}

	/**
	 * to String de bytecode
	 * 
	 * @return
	 */
	public String toString() {
		return this.name.toString() + " " + param;
	}

	/**
	 * devuleve el nombre
	 * 
	 * @return
	 */
	public ENUM_BYTECODE getName() {
		return this.name;
	}

	/**
	 * devuleve el parametro
	 * 
	 * @return
	 */
	public int getParam() {
		return this.param;
	}

}
