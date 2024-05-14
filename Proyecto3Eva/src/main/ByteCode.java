package main;

public class ByteCode {
	private ENUM_BYTECODE name;
	private int param;

	public ByteCode(ENUM_BYTECODE bc) {
		this.name = bc;
		this.param = -1;
	}
	
	public ByteCode(ENUM_BYTECODE bc, int i) {
		this.name = bc;
		this.param = i;
	}
	
	public ENUM_BYTECODE getBC() {
		return this.name;
	}
	
	public int getParam() {
		return this.param;
	}
}
