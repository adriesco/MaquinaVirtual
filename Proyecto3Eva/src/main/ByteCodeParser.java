package main;

public class ByteCodeParser {

	public static ByteCode parse(String s) {
		String[] a = s.split(" ");
		switch (a.length) {
		case 1:
			if (a[0].equalsIgnoreCase("PUSH")) {
				return new ByteCode(ENUM_BYTECODE.PUSH, Integer.parseInt(a[1]));
			}else if (a[0].equalsIgnoreCase("LOAD")) {
				return new ByteCode(ENUM_BYTECODE.LOAD, Integer.parseInt(a[1]));
			}else if (a[0].equalsIgnoreCase("STORE")) {
				return new ByteCode(ENUM_BYTECODE.STORE, Integer.parseInt(a[1]));
			}
		case 2:
			if(a[0].equalsIgnoreCase("add")) {
				return new ByteCode(ENUM_BYTECODE.ADD);
			}else if (a[0].equalsIgnoreCase("DIV")) {
				return new ByteCode(ENUM_BYTECODE.DIV);
			}else if (a[0].equalsIgnoreCase("MUL")) {
				return new ByteCode(ENUM_BYTECODE.MUL);
			}else if (a[0].equalsIgnoreCase("SUB")) {
				return new ByteCode(ENUM_BYTECODE.SUB);
			}else if(a[0].equalsIgnoreCase("OUT")) {
				return new ByteCode(ENUM_BYTECODE.OUT);
			}else if (a[0].equalsIgnoreCase("HALT")) {
				return new ByteCode(ENUM_BYTECODE.HALT);
			}
		default:
			return null;
		}
	}

}