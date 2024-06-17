package main;


public class ByteCodeProgram {
	private ByteCode[] program;
	private int numElements;
	private int size;

	/**
	 * Constructor que inicializa el programa con un tamaño por defecto de 10.
	 */
	public ByteCodeProgram() {
		this.size = 10;
		this.program = new ByteCode[this.size];
		this.numElements = 0;
	}

	/**
	 * Devuelve una representación en forma de cadena del programa almacenado.
	 * 
	 * @return una cadena que representa el programa almacenado.
	 */
	@Override
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
	 * Redimensiona el array de ByteCodes si es necesario.
	 * 
	 * @param numElements el número de elementos actuales en el programa.
	 */
	private void resize(int numElements) {
		ByteCode[] new_program = new ByteCode[numElements * 2];
		for (int i = 0; i < this.program.length; i++) {
			new_program[i] = this.program[i];
		}
		this.program = new_program;
	}

	/**
	 * Añade un ByteCode al programa.
	 * 
	 * @param _byteCode el ByteCode a añadir.
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
	 * Reemplaza un ByteCode en una posición específica del programa.
	 * 
	 * @param _byteCode el ByteCode a reemplazar.
	 * @param _i        la posición donde reemplazar el ByteCode.
	 * @return true si el reemplazo fue exitoso, false en caso contrario.
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
	 * Ejecuta el programa almacenado.
	 * 
	 * @param cpu la CPU que ejecutará el programa.
	 * @return una cadena con el estado de la máquina tras ejecutar cada
	 *         instrucción.
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
	 * Resetea el programa, eliminando todas las instrucciones almacenadas.
	 */
	public void reset() {
		this.numElements = 0;
		this.program = new ByteCode[this.size];
	}
}