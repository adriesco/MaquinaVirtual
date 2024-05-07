
package main;

public class CPU {
	private OpenStack o; 
	private Memory m; 
	private boolean pause;
	
	public CPU() {
		this.pause = false;
		this.m = new Memory();
		this.o = new OpenStack();
	}
	
	public boolean execute(ByteCode bc) {
		
	}
}
