
package main;

public class Command {
	
	private ENUM_COMMAND command;
	private ByteCode instruction;
	private int replace;
	
	public Command(ENUM_COMMAND c) {
		this.command = c;
	}
}
