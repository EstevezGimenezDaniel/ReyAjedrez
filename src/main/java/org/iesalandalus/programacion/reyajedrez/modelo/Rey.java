package org.iesalandalus.programacion.reyajedrez.modelo;

import javax.naming.OperationNotSupportedException;

public class Rey {
    private Color color;
    private Posicion posicion;
    private int totalMovimientos;

    public Rey() {
        this.color = Color.BLANCO;
        this.posicion = new Posicion(1, 'e');
        this.totalMovimientos = 0;
    }

    public Rey(Color color) {
        this.color = color;
        if (color == Color.BLANCO) {
            this.posicion = new Posicion(1, 'e');
        } else {
            this.posicion = new Posicion(8, 'e');
        }
        this.totalMovimientos = 0;
    }

    public Color getColor() {
        return color;
    }

    public void setColor(Color color) {
        if (color == null) {
            throw new NullPointerException("El color no es correcto");
        } else {
            this.color = color;
        }

    }
    public Posicion getPosicion() {
        return posicion;
    }

    public void setPosicion(Posicion posicion) {
        if (posicion == null) {
            throw new NullPointerException("La posicion no es valida");
        }
        this.posicion = posicion;
    }

    public int getTotalMovimientos() {
        return totalMovimientos;
    }

    public void setTotalMovimientos(int totalMovimientos) {
        if (totalMovimientos < 0) {
            throw new IllegalArgumentException("El número de movimientos no puede ser negativo.");
        }
        this.totalMovimientos = totalMovimientos;
    }

    public void mover(Direccion direccion) throws OperationNotSupportedException {
        int nFila = posicion.getFila();
        char nColumna = posicion.getColumna();

        switch (direccion) {
            case NORTE:
                nFila++;
                break;
            case NORESTE:
                nFila++;
                nColumna++;
                break;
            case ESTE:
                nColumna++;
                break;
            case SURESTE:
                nFila--;
                nColumna++;
                break;
            case SUROESTE:
                nFila--;
                nColumna--;
                break;
            case SUR:
                nFila--;
                break;
            case OESTE:
                nColumna--;
                break;
            case NOROESTE:
                nFila++;
                nColumna--;
                break;
            case ENROQUE_CORTO:
                nColumna++;
                nColumna++;
                comprobarEnroque();
                break;
            case ENROQUE_LARGO:
                nColumna--;
                nColumna--;
                comprobarEnroque();
                break;
            default:
                throw new NullPointerException("Error:El movimiento no puede ser nulo.");
        }

        if ((nFila < 1 || nFila > 8) && (nColumna < 'a' || nColumna > 'h')) {
            throw new OperationNotSupportedException("ERROR: El Rey se sale del tablero.");
        } else {

            setPosicion(new Posicion(nFila, nColumna));
            totalMovimientos++;
        }
    }

    private void comprobarEnroque () throws OperationNotSupportedException {
        Rey vBlanco = new Rey();
        vBlanco.setPosicion(new Posicion(1,'e'));
        Rey vNegro = new Rey();
        vNegro.setPosicion(new Posicion(8, 'e'));

        if (getColor().equals(Color.BLANCO) && (getPosicion().equals(vBlanco.getPosicion())) && (getTotalMovimientos()==0)) {

        } else if (getColor().equals((Color.NEGRO)) && (getPosicion().equals(vNegro.getPosicion())) && (getTotalMovimientos()==0)) {

        }else {
            throw new OperationNotSupportedException("ERROR: No esta en la casilla inicial o ya se ha movido el rey anteriormente.");
        }
    }

    public String toString() {
        return "El Rey de color: " + color +
                ". " + posicion +
                "Total de movimientos:" + totalMovimientos;
    }

}

