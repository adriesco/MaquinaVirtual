package main;

public class CommandParser {
	public static Command parse(String s) {
		String[] a = s.split(" ");
		switch (a.length) {
		case 1: {
			if(a[0].equalsIgnoreCase("help"))
				return new Command(ENUM_COMMAND.HELP);
			else if(a[0].equalsIgnoreCase("quit"))
				return new Command(ENUM_COMMAND.QUIT);
			else if(a[0].equalsIgnoreCase("run"))
				return new Command(ENUM_COMMAND.RUN);
			else if(a[0].equalsIgnoreCase("reset"))
				return new Command(ENUM_COMMAND.RESET);
		}
		case 2:
			if(a[0].equalsIgnoreCase("replace"))
				return new Command(ENUM_COMMAND.REPLACE);
		case 3:
			if(a[0].equalsIgnoreCase("newinst"))
				return new Command(ENUM_COMMAND.NEWINST);
		default:
			return null;
		}
	}

	
}