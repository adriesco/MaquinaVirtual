package main;

import java.util.Scanner;

/**
 * La clase Engine representa el motor que gestiona la ejecución de un programa de código byte a través de una CPU.
 * Permite la ejecución de comandos como iniciar, detener, mostrar ayuda, ejecutar, añadir y reemplazar instrucciones de bytecode.
 */
public class Engine {
    private ByteCodeProgram program;
    private boolean end;
    private CPU cpu;

    /**
     * Constructor por defecto que inicializa el motor con un nuevo programa y una nueva CPU.
     */
    public Engine() {
        program = new ByteCodeProgram();
        end = false;
        cpu = new CPU();
    }

    /**
     * Limpia la consola.
     */
    public void clearScreen() {
        System.out.print("\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n");
    }

    /**
     * Comienza la ejecución del motor, leyendo comandos desde la entrada estándar.
     */
    public void start() {
        Scanner sc = new Scanner(System.in);

        while (!this.end) {
            String instruccion = sc.nextLine();
            Command comando = CommandParser.parse(instruccion);
            System.out.println("Comienza la ejecución de [" + instruccion.toUpperCase() + "]");
            if (comando != null) {
                if (comando.execute(this)) {

                } else {
                    System.out.println("No se ha podido ejecutar, ejecución incorrecta.");
                }
            } else {
                System.out.println("No se ha podido ejecutar, comando incorrecto.");
            }
        }
    }

    /**
     * Comando que finaliza el programa.
     * 
     * @return true si el comando se ejecuta correctamente.
     */
    public boolean commandEnd() {
        System.out.println("Maquina Apagada");
        this.end = true;
        return true;
    }

    /**
     * Comando que muestra la pantalla de ayuda.
     * 
     * @return true si el comando se ejecuta correctamente.
     */
    public boolean commandHelp() {
        System.out.println("HELP" + ": Muestra esta ayuda\n" + "QUIT" + ": Cierra la aplicacion\n" + "RUN"
                + ": Ejecuta el programa\n" + "NEWINST BYTECODE" + ": Introduce una nueva instrucción al programa\n"
                + "RESET" + ": Vacia el programa actual\n" + "REPLACE N"
                + ": Reemplaza la instruccion N por la solicitada al usuario");
        return true;
    }

    /**
     * Comando que ejecuta el programa.
     * 
     * @return true si el comando se ejecuta correctamente.
     */
    public boolean commandRun() {
        System.out.println(this.program.runProgram(this.cpu));
        System.out.println(this.program.toString());
        return true;
    }

    /**
     * Comando que añade un ByteCode al programa.
     * 
     * @param _comando el comando que contiene la nueva instrucción de bytecode.
     * @return true si el comando se ejecuta correctamente, false en caso contrario.
     */
    public boolean commandNewinst(Command _comando) {
        if (_comando.getInstruction() != null) {
            this.program.addByteCode(_comando.getInstruction());
            System.out.println(this.program.toString());
            return true;
        } else {
            return false;
        }
    }

    /**
     * Comando que resetea el programa.
     * 
     * @return true si el comando se ejecuta correctamente.
     */
    public boolean commandReset() {
        if (this.cpu.reset()) {
            clearScreen();
            System.out.println("Borrando el estado de la máquina");
            this.program.reset();
        } else {
            System.out.println("Algo ha fallado");
        }
        return true;
    }

    /**
     * Comando que reemplaza un ByteCode del programa.
     * 
     * @param _comando el comando que contiene la posición de reemplazo.
     * @return true si el comando se ejecuta correctamente, false en caso contrario.
     */
    public boolean commandReplace(Command comando) {
        if (comando != null) {
            Scanner sc = new Scanner(System.in);
            String instruccion = sc.nextLine();
            String[] particion = instruccion.split(" ");
            if (particion.length == 1) {
                ByteCode x = ByteCodeParser.parse(particion[0]);
                if (x != null) {
                    this.program.replaceByteCode(x, comando.getReplace());
                } else {
                    return false;
                }
            } else {
                ByteCode x = ByteCodeParser.parse(particion[0], particion[1]);
                if (x != null) {
                    this.program.replaceByteCode(x, comando.getReplace());
                } else {
                    return false;
                }
            }
            System.out.println(this.program.toString());
            return true;
        } else {
            System.out.println(this.program.toString());
            return false;
        }
    }
}