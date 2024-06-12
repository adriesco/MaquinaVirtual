package main;

public class CPU {
	private Memory memoria;
	private OpenStack pila;
	private boolean isHalt;

	public CPU() {
		this.memoria = new Memory();
		this.pila = new OpenStack();
		this.isHalt = false;
	}

	/**
	 * Se encarga de dirigir los bytecodes
	 * 
	 * @param _instr
	 * @return
	 */
	public boolean execute(ByteCode instruccion) {
		switch (instruccion.getName()) {
		case ADD:
			return sumaPila();
		case PUSH:
			return this.pila.push(instruccion.getParam());
		case LOAD:
			return loadMemoria(instruccion.getParam());
		case STORE:
			return storeMemoria(instruccion.getParam());
		case SUB:
			return restarPila();
		case MUL:
			return multiplicarPila();
		case DIV:
			return dividirPila();
		case OUT:
			return outPila();
		case HALT:
			return haltPrograma();
		default:
			return false;
		}
	}

	/**
	 * Pregunta si el "programa" debe detenerse
	 * 
	 * @return
	 */
	public boolean isHalt() {
		return this.isHalt;
	}

	/**
	 * toString
	 * 
	 * @return
	 */
	public String toString() {
		return "\nEstado de la CPU:\n" + memoria.toString() + "\n" + pila.toString() + "\n-----------------";
	}

	/**
	 * Elimina alguna ejecución del programa
	 */
	public void runCPU() {
		this.isHalt = false;
	}

	/**
	 * Limpia la memoria (diferenciar de reset)
	 */
	public void erase() {
		this.memoria = new Memory();
		this.pila = new OpenStack();
	}

	/**
	 * Añade un elemento a la pila
	 * 
	 * @param _n
	 * @return
	 */
	public boolean push(int _n) {
		runCPU();
		this.pila.push(_n);
		return true;
	}

	/**
	 * Suma los 2 ultimos de la pila
	 * 
	 * @return
	 */
	public boolean sumaPila() {
		runCPU();
		if (!this.pila.isEmpty()) {
			int e1 = this.pila.pop();
			if (!this.pila.isEmpty()) {
				int e2 = this.pila.pop();
				int result = e1 + e2;
				this.pila.push(result);
				return true;
			} else {
				this.pila.push(e1);
				return false;
			}
		} else {
			return false;
		}
	}

	/**
	 * Resta los 2 ultimos de la pila
	 * 
	 * @return
	 */
	public boolean restarPila() {
		runCPU();
		if (!this.pila.isEmpty()) {
			int e1 = this.pila.pop();
			if (!this.pila.isEmpty()) {
				int e2 = this.pila.pop();
				int result = e1 - e2;
				this.pila.push(result);
				return true;
			} else {
				this.pila.push(e1);
				return false;
			}
		} else {
			return false;
		}
	}

	/**
	 * Multiplica los 2 ultimos de la pila
	 * 
	 * @return
	 */
	public boolean multiplicarPila() {
		runCPU();
		if (!this.pila.isEmpty()) {
			int e1 = this.pila.pop();
			if (!this.pila.isEmpty()) {
				int e2 = this.pila.pop();
				int result = e1 * e2;
				this.pila.push(result);
				return true;
			} else {
				this.pila.push(e1);
				return false;
			}
		} else {
			return false;
		}
	}

	/**
	 * Divide los 2 ultimos de la pila
	 * 
	 * @return
	 */
	public boolean dividirPila() {
		runCPU();
		if (!this.pila.isEmpty()) {
			int e1 = this.pila.pop();
			if (!this.pila.isEmpty()) {
				int e2 = this.pila.pop();
				int result = e1 / e2;
				this.pila.push(result);
				return true;
			} else {
				this.pila.push(e1);
				return false;
			}
		} else {
			return false;
		}
	}

	/**
	 * Guarda un valor en la memoria
	 * 
	 * @param _pos
	 * @return
	 */
	public boolean storeMemoria(int _pos) {
		runCPU();
		this.memoria.write(_pos, this.pila.pop());
		return true;
	}

	/**
	 * Carga un valor de la memoria
	 * 
	 * @param _pos
	 * @return
	 */
	public boolean loadMemoria(int _pos) {
		runCPU();
		this.pila.push(this.memoria.read(_pos));
		return true;
	}

	/**
	 * Devuelve el primer elemento de la pila
	 * 
	 * @return
	 */
	public boolean outPila() {
		runCPU();
		int temp = this.pila.pop();
		this.pila.push(temp);
		System.out.println("La cima de la pila es: " + temp);
		return true;
	}

	/**
	 * Detiene el "programa"
	 * 
	 * @return
	 */
	public boolean haltPrograma() {
		this.isHalt = true;
		return true;
	}

	/**
	 * Resetea la pila y crea unas nuevas
	 * 
	 * @return
	 */
	public boolean reset() {
		this.pila = new OpenStack();
		this.memoria = new Memory();
		return true;
	}

}