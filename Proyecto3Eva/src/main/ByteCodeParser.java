package main;

public class ByteCodeParser {

    /**
     * devuelve el bytecode 
     * @param b
     * @param a
     * @return
     */
    public static ByteCode parse(String a, String b) {
        switch (a.toLowerCase()) {
            case "push":
                return new ByteCode(ENUM_BYTECODE.PUSH, Integer.parseInt(b));
            case "load":
                return new ByteCode(ENUM_BYTECODE.LOAD, Integer.parseInt(b));
            case "store":
                return new ByteCode(ENUM_BYTECODE.STORE, Integer.parseInt(b));
        } return null;
    }

    /**
     * devuelve el bytecode 
     * @param _s
     * @return
     */
    public static ByteCode parse(String _s) {
        switch (_s.toLowerCase()) {
            case "add":
                return new ByteCode(ENUM_BYTECODE.ADD);
            case "sub":
                return new ByteCode(ENUM_BYTECODE.SUB);
            case "mul":
                return new ByteCode(ENUM_BYTECODE.MUL);
            case "div":
                return new ByteCode(ENUM_BYTECODE.DIV);
            case "out":
                return new ByteCode(ENUM_BYTECODE.OUT);
            case "halt":
                return new ByteCode(ENUM_BYTECODE.HALT);
        } return null;
    }
}