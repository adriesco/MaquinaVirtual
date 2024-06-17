package main;


public class CommandParser {

	/**
	 * Parsea un string y lo convierte en un comando.
	 * 
	 * @param i la cadena de texto que representa el comando.
	 * @return el comando correspondiente si se reconoce, null en caso contrario.
	 */
	public static Command parse(String i) {
		String[] partir = i.toLowerCase().split(" ");
		switch (partir[0]) {
		case "help":
			return new Command(ENUM_COMMAND.HELP);
		case "quit":
			return new Command(ENUM_COMMAND.QUIT);
		case "run":
			return new Command(ENUM_COMMAND.RUN);
		case "reset":
			return new Command(ENUM_COMMAND.RESET);
		case "newinst":
			if (partir.length == 3) {
				return new Command(ENUM_COMMAND.NEWINST, ByteCodeParser.parse(partir[1], partir[2]));
			} else if (partir.length == 2) {
				return new Command(ENUM_COMMAND.NEWINST, ByteCodeParser.parse(partir[1]));
			}
		case "replace":
			return new Command(ENUM_COMMAND.REPLACE, Integer.parseInt(partir[1]));
		default:
			return null;
		}
	}
}