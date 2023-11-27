package org.iesalandalus.programacion.reyajedrez;

import org.iesalandalus.programacion.reyajedrez.modelo.Color;
import org.iesalandalus.programacion.reyajedrez.modelo.Direccion;
import org.iesalandalus.programacion.utilidades.Entrada;

public class Consola {
    private Consola() {
        // Constructor privado para evitar la instanciación de la clase.
    }
    public static void mostrarMenu() {
        System.out.println("Menú:");
        System.out.println("1. Crear rey por defecto");
        System.out.println("2. Crear rey eligiendo el color");
        System.out.println("3. Mover");
        System.out.println("4. Salir");
    }
    public static int elegirOpcionMenu() {
        int opcion;

        do {
            System.out.println("Elige una opción:");
            opcion= Entrada.entero();
        } while (opcion<1 || opcion>4);
        return opcion;
    }
    public static Color elegirColor () {
        char colorRey;
        Color opcion=null;

        do {
            System.out.println("Elegir un color (B/N):");
            colorRey=Entrada.caracter();
        } while (colorRey != 'B' && colorRey != 'N');

        if (colorRey == 'B') {
            opcion=Color.BLANCO;
        } else  {
            opcion=Color.NEGRO;
        }
        return opcion;
    }
    public static void mostrarDirecciones() {
        System.out.println("Menú de direcciones:");
        System.out.println("1. NORTE");
        System.out.println("2. NORESTE");
        System.out.println("3. ESTE");
        System.out.println("4. SURESTE");
        System.out.println("5. SUR");
        System.out.println("6. SUROESTE");
        System.out.println("7. OESTE");
        System.out.println("8. NOROESTE");
        System.out.println("9. ENROQUE_CORTO");
        System.out.println("10. ENROQUE_LARGO");
    }
    public static Direccion elegirDireccion() {
        Direccion direccion = null;
        int opcion;

        do {
            System.out.println("Elige una opcion del 1 al 10:");
            opcion = Entrada.entero();
        } while (opcion < 1 || opcion > 10);

        switch (opcion) {
            case 1:
                direccion = Direccion.NORTE;
                break;
            case 2:
                direccion = Direccion.NOROESTE;
                break;
            case 3:
                direccion = Direccion.ESTE;
                break;
            case 4:
                direccion = Direccion.SURESTE;
                break;
            case 5:
                direccion = Direccion.SUR;
                break;
            case 6:
                direccion = Direccion.SUROESTE;
                break;
            case 7:
                direccion = Direccion.OESTE;
                break;
            case 8:
                direccion = Direccion.NOROESTE;
                break;
            case 9:
                direccion = Direccion.ENROQUE_CORTO;
                break;
            case 10:
                direccion = Direccion.ENROQUE_LARGO;
                break;
        }
        return direccion;
    }
    public static void despedida() {
        System.out.println("¡Hasta luego!");
    }
}
