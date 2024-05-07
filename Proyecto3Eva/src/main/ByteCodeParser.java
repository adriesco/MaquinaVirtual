
package main;

public class ByteCodeParser {

	public static ByteCode parse(String s) {
		String[] a = s.split(" ");
		switch (a.length) {
		case 3:
			if (a[0].equalsIgnoreCase("newinst") && a[1].equalsIgnoreCase("push")) {
				return new ByteCode(ENUM_BYTECODE.PUSH);
			}else if (a[0].equalsIgnoreCase("newinst") && a[1].equalsIgnoreCase("load")) {
				return new ByteCode(ENUM_BYTECODE.LOAD);
			}else if (a[0].equalsIgnoreCase("newinst") && a[1].equalsIgnoreCase("store")) {
				return new ByteCode(ENUM_BYTECODE.STORE);
			}
		case 2:
			if (a[0].equalsIgnoreCase("newinst") && a[1].equalsIgnoreCase("add")) {
				return new ByteCode(ENUM_BYTECODE.ADD);
			}else if (a[0].equalsIgnoreCase("newinst") && a[1].equalsIgnoreCase("div")) {
				return new ByteCode(ENUM_BYTECODE.DIV);
			}else if (a[0].equalsIgnoreCase("newinst") && a[1].equalsIgnoreCase("mul")) {
				return new ByteCode(ENUM_BYTECODE.MUL);
			}else if (a[0].equalsIgnoreCase("newinst") && a[1].equalsIgnoreCase("sub")) {
				return new ByteCode(ENUM_BYTECODE.SUB);
			}else if(a[0].equalsIgnoreCase("newinst") && a[1].equalsIgnoreCase("out")) {
				return new ByteCode(ENUM_BYTECODE.OUT);
			}else if (a[0].equalsIgnoreCase("newinst") &&a[1].equalsIgnoreCase("halt")) {
				return new ByteCode(ENUM_BYTECODE.HALT);
			}
		default:
			return null;
		}
	}
}
