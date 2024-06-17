package main;


public class Command {

    private ENUM_COMMAND command;
    private ByteCode instruction;
    private Integer replace;

    /**
     * Constructor por defecto que inicializa el comando como nulo.
     */
    public Command() {
        this.command = null;
    }

    /**
     * Constructor que inicializa el comando con un valor específico.
     * 
     * @param command el comando a ser inicializado.
     */
    public Command(ENUM_COMMAND command) {
        this.command = command;
    }

    /**
     * Constructor que inicializa el comando y una instrucción ByteCode.
     * 
     * @param command el comando a ser inicializado.
     * @param instruction la instrucción ByteCode asociada.
     */
    public Command(ENUM_COMMAND command, ByteCode instruction) {
        this.command = command;
        this.instruction = instruction;
    }

    /**
     * Constructor que inicializa el comando y un índice de reemplazo.
     * 
     * @param command el comando a ser inicializado.
     * @param replace el índice de reemplazo.
     */
    public Command(ENUM_COMMAND command, Integer replace) {
        this.command = command;
        this.replace = replace;
    }

    /**
     * Devuelve la instrucción ByteCode asociada al comando.
     * 
     * @return la instrucción ByteCode.
     */
    public ByteCode getInstruction() {
        return instruction;
    }

    /**
     * Devuelve el índice de reemplazo asociado al comando.
     * 
     * @return el índice de reemplazo.
     */
    public Integer getReplace() {
        return replace;
    }

    /**
     * Ejecuta el comando utilizando el motor proporcionado.
     * 
     * @param engine el motor que ejecutará el comando.
     * @return true si el comando se ejecutó correctamente, false en caso contrario.
     */
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