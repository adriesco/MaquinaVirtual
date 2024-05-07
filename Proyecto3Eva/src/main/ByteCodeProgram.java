
package main;

import java.util.Iterator;

public class ByteCodeProgram {
	private int elemts;
	private final int size = 1;
	private ByteCode[]program;
	
	public ByteCodeProgram() {
		this.program = new ByteCode[size];
		this.elemts = 0;
	}
	
	private void resize() {
		if (this.elemts >= this.size) {
			ByteCode[] a = new ByteCode[size*2];
			for(int i = 0; i < this.program.length; i++) {
				a[i] = this.program[i];
			}
			this.program = a;
		}
	}
	
	public void setInstruction(ByteCode bc) {
		this.resize();
		this.program[this.elemts] = bc;
		this.elemts++;
	}
	
	public String toString() {
		String texto = "";
		for(int i = 0; i < this.program.length; i++) {
			texto += this.program[i] + " ";
		}
		return texto;
	}
	
	public boolean setInstructionPosition(ByteCode bc, int pos) {
		if (pos >= 0 && pos < this.size) {
			this.program[pos] = bc;
			return true;
		}else
			return false;
	}
}
