package main;

public class Command {

	private ENUM_COMMAND command;
	private ByteCode instruction;
	private Integer replace;

	public Command() {
		this.command = null;
	}

	public Command(ENUM_COMMAND command) {
		this.command = command;
	}

	public Command(ENUM_COMMAND command, ByteCode instruction) {
		this.command = command;
		this.instruction = instruction;
	}

	public Command(ENUM_COMMAND command, Integer replace) {
		this.command = command;
		this.replace = replace;
	}

	/**
	 * Devuelve la instrucción
	 * 
	 * @return
	 */
	public ByteCode getInstruction() {
		return instruction;
	}

	/**
	 * Devuelve el argumento del replace
	 * 
	 * @return
	 */
	public Integer getReplace() {
		return replace;
	}

	public boolean execute(Engine engine) {
		switch (this.command) {
		case HELP:
			return engine.commandHelp();
		case QUIT:
			return engine.commandEnd();
		case RUN:
			return engine.commandRun();
		case NEWINST:
			return engine.commandNewinst(this);
		case RESET:
			return engine.commandReset();
		case REPLACE:
			return engine.commandReplace(this);
		default:
			return false;
		}
	}
}