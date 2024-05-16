package main;

public class Memory {
	private int Max_memory;
	private int size;
	private Integer[] memory;
	private boolean empty;
	
	public Memory() {
		size = 5;
		memory = new Integer[size];
		this.empty = true;
	}
	
	private void resize (int pos) {
		if(pos >= size) {
			this.empty = false;
			Integer[] array2 = new Integer[pos*2];
			for (int i = 0; i < this.memory.length; i++) {
				if(i < this.size) {
					array2[i] = this.memory[i];
				}else {
					array2[i] = null;
				}
	        }
			this.memory = array2;
			this.size = array2.length;
		}
	}
	
	public boolean write(int pos, Integer x) {
		if(pos >= 0) {
			this.resize(pos);
			this.memory[pos] = x;
			return true;
		}else {
			return false;
		}
	}
	
	public Integer read(int pos) {
		if (this.memory[pos] == null) {
			return -1;
		}else {
			return this.memory[pos];
		}
	}
	
	public String toString() {
			String texto = "";
			if (empty == false) {
				for(int i = 0; i < memory.length; i++) {
					if (this.memory[i] == null) {
						
					}else {
						texto += "[" + i + "]" + this.memory[i] + " ";
					}
				}
				return texto;
			}else
				return "vacia";
	}
	
	public void erase() {
		this.memory = new Integer[size];
	}
}