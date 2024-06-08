package main;

public class Command {
	
	private ENUM_COMMAND command;
    private ByteCode instruction;
    private Integer replace;

    public Command() {
        this.command = null;
    }

    public Command(ENUM_COMMAND _command) {
        this.command = _command;
    }

    public Command(ENUM_COMMAND _command, ByteCode _instruction) {
        this.command = _command;
        this.instruction = _instruction;
    }

    public Command(ENUM_COMMAND _command, Integer _replace) {
        this.command = _command;
        this.replace = _replace;
    }

    /**
     * Devuelve la instrucción
     * @return
     */
    public ByteCode getInstruction() {
        return instruction;
    }

    /**
     * Devuelve el argumento del replace
     * @return
     */
    public Integer getReplace() {
        return replace;
    }
	
	public boolean execute(Engine _engine) {
        switch (this.command) {
            case HELP:
                return _engine.commandHelp();
            case QUIT:
                return _engine.commandEnd();
            case RUN:
                return _engine.commandRun();
            case NEWINST:
                return _engine.commandNewinst(this);
            case RESET:
                return _engine.commandReset();
            case REPLACE:
                return _engine.commandReplace(this);
            default:
                return false;
        }
    }
}