package main;


public class ByteCodeParser {

    /**
     * Devuelve un ByteCode basado en dos cadenas de texto.
     * 
     * @param a la cadena que representa el nombre del ByteCode.
     * @param b la cadena que representa el parámetro del ByteCode.
     * @return una instancia de ByteCode basada en las cadenas de texto proporcionadas, o null si el nombre no es válido.
     */
    public static ByteCode parse(String a, String b) {
        switch (a.toLowerCase()) {
            case "push":
                return new ByteCode(ENUM_BYTECODE.PUSH, Integer.parseInt(b));
            case "load":
                return new ByteCode(ENUM_BYTECODE.LOAD, Integer.parseInt(b));
            case "store":
                return new ByteCode(ENUM_BYTECODE.STORE, Integer.parseInt(b));
        } 
        return null;
    }

    /**
     * Devuelve un ByteCode basado en una cadena de texto.
     * 
     * @param s la cadena que representa el nombre del ByteCode.
     * @return una instancia de ByteCode basada en la cadena de texto proporcionada, o null si el nombre no es válido.
     */
    public static ByteCode parse(String s) {
        switch (s.toLowerCase()) {
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
        } 
        return null;
    }
}