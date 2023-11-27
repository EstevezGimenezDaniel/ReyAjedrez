package org.iesalandalus.programacion.reyajedrez;

import org.iesalandalus.programacion.reyajedrez.modelo.Direccion;
import org.iesalandalus.programacion.reyajedrez.modelo.Rey;

import javax.naming.OperationNotSupportedException;

public class MainApp {
    public static void main(String[] args) {
        int opcion;

        do {
            Consola.mostrarMenu();
            opcion=Consola.elegirOpcionMenu();
            ejecutarOpcion(opcion);
            mostrarRey();
            System.out.println("---------------------");
        }while (opcion!=4);


    }

    private static Rey rey;

    private static void ejecutarOpcion (int opcion) {

        switch (opcion) {
            case 1:
                crearReyDef();
                break;
            case 2:
                crearReyColor();
                break;
            case 3:
                mover();
                break;
            case 4:
                Consola.despedida();
                break;
        }
    }

    private static void crearReyDef() {
        rey = new Rey();
    }

    private static void crearReyColor () {
        rey = new Rey(Consola.elegirColor());
    }

    private static void mover() {

        Direccion direccion = null;
        Consola.mostrarDirecciones();
        System.out.println("¿Hacia qué dirección quieres ir?");
        direccion = Consola.elegirDireccion();

        try {
            rey.mover(direccion);
        }
        catch (OperationNotSupportedException e) {
            System.out.println(e.getMessage());
        }
    }
    private static void mostrarRey ()  {
        System.out.println(rey.toString());
    }

}
