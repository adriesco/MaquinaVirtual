package main;

import java.io.ObjectInputStream.GetField;
import java.util.Iterator;

public class OpenStack {
	private final int MAX_STACK = 200;
	private int[] Stack = new int[MAX_STACK];
	private int Elements = 0;

	public boolean isEmpty() {
		if(Elements > 0) {
			return false;
		}else
			return true;
	}

	public boolean push(int num) {
		if (this.Elements < this.MAX_STACK) {
			this.Stack[Elements] = num;
			this.Elements++;
			return true;
		}else
			return false;
	}

	public int pop() {
		int temp = this.Stack[Elements -1];
		if(isEmpty() == false) {
			this.Elements--;
			return temp;
		}else
			return -1;
	}
	
	public int getCima() {
		if(isEmpty() == false) {
			return this.Stack[Elements -1];
		}else
			return -1;
	}
	
	public String toString() {
		String texto = "";
		if (isEmpty() == false) {
			for(int i = 0; i < Elements; i++) {
				texto += this.Stack[i] + " ";
			}
			return texto;
		}else
			return "vacia";
	}
	
	public void erase() {
		this.Stack = new int[MAX_STACK];
		this.Elements = 0;
	}
	
	public int getElemts() {
		return this.Elements;
	}

}