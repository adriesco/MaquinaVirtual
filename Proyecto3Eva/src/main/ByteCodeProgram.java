package main;

import java.util.Iterator;

public class ByteCodeProgram {
	private int elemts;
	private int size;
	private ByteCode[]program;
	
	public ByteCodeProgram() {
		this.size = 1;
		this.elemts = 0;
		this.program = new ByteCode[size];
	}
	
	private void resize() {
		if(this.elemts == this.size) {
			ByteCode a[] = new ByteCode[this.size * 2];
			for(int i = 0; i < this.size; i++) {
				if(i < this.size) {
					a[i] = this.program[i];
				}else {
					a[i] = null;
				}
			}
			this.program = a;
			this.size = a.length;
		}
	}
	
	public void setInstruction(ByteCode bc) {
		this.resize();
		this.program[this.elemts] = bc;
		this.elemts++;
	}
	
	public String toString() {
		String texto = "";
		for(int i = 0; i < this.elemts; i++) {
			if (this.program[(i +1)- 1].getParam() == -1) {
				texto +=  i +": "+ this.program[(i + 1) - 1].getBC() + "\n";
			}else {
				texto += i +": "+ this.program[i].getBC() + " " + this.program[i].getParam() + "\n";
			}
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
	
	public void reset() {
		this.program = new ByteCode[size];
		this.elemts = 0;
		this.size = 1;
	}
	
	public String runProgram(CPU cpu) {
		String s = "";
		for(int i = 0; i < this.elemts; i++) {
			if(!cpu.isHalt() && cpu.execute(this.program[i])) {
				if (this.program[i].getParam() != -1)
					s += "\nEl estado de la maquina despues de ejecutar " + this.program[i].getBC() + " " + this.program[i].getParam() + " es:\n\nCPU estado:\n" + cpu.toString() + "\n";
				else {
					s += "\nEl estado de la maquina despues de ejecutar " + this.program[i].getBC() +" es:\n\nCPU estado:\n" + cpu.toString() + "\n";
				}
			}else if(!cpu.isHalt())
				s += "Fallo: ejecucion incorrecta del comando";
		}
		cpu.erase();
		cpu.runCPU();
		return s;
	}
}