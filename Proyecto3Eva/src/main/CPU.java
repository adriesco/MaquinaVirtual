package main;

public class CPU {
	private Memory memoria;
	private OpenStack pila;
	private boolean isHalt;

	/**
	 * Constructor por defecto que inicializa la memoria, la pila y el estado de la
	 * CPU.
	 */
	public CPU() {
		this.memoria = new Memory();
		this.pila = new OpenStack();
		this.isHalt = false;
	}

	/**
	 * Ejecuta una instrucción de bytecode.
	 * 
	 * @param instruccion la instrucción de bytecode a ejecutar.
	 * @return true si la instrucción se ejecuta correctamente, false en caso
	 *         contrario.
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
	 * Pregunta si el "programa" debe detenerse.
	 * 
	 * @return true si la CPU está en estado de detención, false en caso contrario.
	 */
	public boolean isHalt() {
		return this.isHalt;
	}

	/**
	 * Devuelve una representación en forma de cadena del estado de la CPU.
	 * 
	 * @return una cadena que representa el estado de la CPU.
	 */
	public String toString() {
		return "\nEstado de la CPU:\n" + memoria.toString() + "\n" + pila.toString() + "\n-----------------";
	}

	/**
	 * Reinicia la ejecución del programa.
	 */
	public void runCPU() {
		this.isHalt = false;
	}

	/**
	 * Limpia la memoria y la pila.
	 */
	public void erase() {
		this.memoria = new Memory();
		this.pila = new OpenStack();
	}

	/**
	 * Añade un elemento a la pila.
	 * 
	 * @param _n el elemento a añadir a la pila.
	 * @return true si el elemento se añade correctamente.
	 */
	public boolean push(int _n) {
		runCPU();
		this.pila.push(_n);
		return true;
	}

	/**
	 * Suma los dos últimos elementos de la pila.
	 * 
	 * @return true si la suma se realiza correctamente.
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
	 * Resta los dos últimos elementos de la pila.
	 * 
	 * @return true si la resta se realiza correctamente.
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
	 * Multiplica los dos últimos elementos de la pila.
	 * 
	 * @return true si la multiplicación se realiza correctamente.
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
	 * Divide los dos últimos elementos de la pila.
	 * 
	 * @return true si la división se realiza correctamente.
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
	 * Guarda un valor en la memoria.
	 * 
	 * @param _pos la posición de la memoria donde se va a guardar el valor.
	 * @return true si el valor se guarda correctamente.
	 */
	public boolean storeMemoria(int _pos) {
		runCPU();
		this.memoria.write(_pos, this.pila.pop());
		return true;
	}

	/**
	 * Carga un valor de la memoria.
	 * 
	 * @param _pos la posición de la memoria de la que se va a cargar el valor.
	 * @return true si el valor se carga correctamente.
	 */
	public boolean loadMemoria(int _pos) {
		runCPU();
		this.pila.push(this.memoria.read(_pos));
		return true;
	}

	/**
	 * Muestra el primer elemento de la pila.
	 * 
	 * @return true si el elemento se muestra correctamente.
	 */
	public boolean outPila() {
		runCPU();
		int temp = this.pila.pop();
		this.pila.push(temp);
		System.out.println("La cima de la pila es: " + temp);
		return true;
	}

	/**
	 * Detiene el "programa".
	 * 
	 * @return true si el programa se detiene correctamente.
	 */
	public boolean haltPrograma() {
		this.isHalt = true;
		return true;
	}

	/**
	 * Resetea la pila y la memoria.
	 * 
	 * @return true si se resetean correctamente.
	 */
	public boolean reset() {
		this.pila = new OpenStack();
		this.memoria = new Memory();
		return true;
	}
}