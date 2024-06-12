package main;

public class ByteCodeProgram {
	private ByteCode[] program;
	private int numElements;
	private int size;

	public ByteCodeProgram() {
		this.size = 10;
		this.program = new ByteCode[this.size];
		this.numElements = 0;
	}

	/**
	 * toString
	 * 
	 * @return
	 */
	public String toString() {
		String chain = "Programa almacenado:\n";
		for (int i = 0; i < this.numElements; i++) {
			if (this.program[i].getParam() == 0) {
				chain += i + ": " + this.program[i].getName() + "\n";
			} else {
				chain += i + ": " + this.program[i].getName() + " " + this.program[i].getParam() + "\n";
			}
		}
		return chain;
	}

	/**
	 * Cambia el tamaño del array de Bytecodes Complejidad 0(n)
	 * 
	 * @param numElements
	 */
	private void resize(int numElements) {
		ByteCode[] new_program = new ByteCode[numElements * 2];
		for (int i = 0; i < this.program.length; i++) {
			new_program[i] = this.program[i];
		}
		this.program = new_program;
	}

	/**
	 * Añade un bytecode al array
	 * 
	 * @param _byteCode
	 */
	public void addByteCode(ByteCode _byteCode) {
		if (this.numElements >= this.program.length) {
			resize(this.numElements);
			this.program[this.numElements] = _byteCode;
			this.numElements++;
		} else {
			this.program[this.numElements] = _byteCode;
			this.numElements++;
		}
	}

	/**
	 * Reemplaza un bytecode
	 * 
	 * @param _byteCode
	 * @param _i
	 * @return
	 */
	public boolean replaceByteCode(ByteCode _byteCode, int _i) {
		if (_i >= this.numElements || _i <= -1) {
			return false;
		} else {
			this.program[_i] = _byteCode;
			return true;
		}
	}

	/**
	 * Ejecuta el "programa" Complejidad 0(n)
	 * 
	 * @param _cpu
	 * @return
	 */
	public String runProgram(CPU cpu) {
		String mensaje = "";
		for (int i = 0; i < this.numElements; i++) {
			if (!cpu.isHalt() && cpu.execute(this.program[i])) {
				mensaje += "\n-----------------\nEl estado de la máquina tras ejecutar " + this.program[i].getName()
						+ " " + this.program[i].getParam() + " es:\n" + cpu.toString() + "\n";
			} else if (!cpu.isHalt()) {
				mensaje += ("No se ha podido ejecutar, ejecución incorrecta");
			}
		}
		cpu.erase();
		cpu.runCPU();
		return mensaje;
	}

	/**
	 * Resetea el array
	 */
	public void reset() {
		this.numElements = 0;
		this.program = new ByteCode[this.size];
	}
}