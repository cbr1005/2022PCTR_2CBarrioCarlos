package simulador_juego;

import java.util.Hashtable;

public class Juego implements IJuego {
    private int contadorEnemigosTotales;
    private Hashtable<Integer, Integer> contadoresEnemigosTipo;
    private Hashtable<Integer, Integer> contadoresEliminadosTipo;
    private final int MAXENEMIGOS;
    private final int MINENEMIGOS = 0;

    public Juego(int maxEnemigos, int tipos) {
        this.MAXENEMIGOS = maxEnemigos;
        this.contadoresEnemigosTipo = new Hashtable<>();
        this.contadoresEliminadosTipo = new Hashtable<>();
        for (int i = 0; i < tipos; i++) {
            contadoresEnemigosTipo.put(i, 0);
            contadoresEliminadosTipo.put(i, 0);
        }
    }

    @Override
    public synchronized void generarEnemigo(int tipo) {
        comprobarAntesDeGenerar(tipo);
        contadorEnemigosTotales++;
        contadoresEnemigosTipo.put(tipo, contadoresEnemigosTipo.get(tipo) + 1);
        imprimirInfo(tipo, "Generado");
        notifyAll();
    }

    @Override
    public synchronized void eliminarEnemigo(int tipo) {
        comprobarAntesDeEliminar(tipo);
        contadorEnemigosTotales--;
        contadoresEnemigosTipo.put(tipo, contadoresEnemigosTipo.get(tipo) - 1);
        contadoresEliminadosTipo.put(tipo, contadoresEliminadosTipo.get(tipo) + 1);
        imprimirInfo(tipo, "Eliminado");
        notifyAll();
    }

    public synchronized void imprimirInfo(int tipo, String accion) {
        System.out.println(accion + " enemigo tipo " + tipo + " --> Enemigos totales: " + contadorEnemigosTotales);
        for (int i : contadoresEnemigosTipo.keySet()) {
            System.out.println("----> Enemigos tipo " + i + ": " + contadoresEnemigosTipo.get(i) + " ------ [Eliminados:" + contadoresEliminadosTipo.get(i) + "]");
        }
    }

    private synchronized void comprobarAntesDeGenerar(int tipo) {
        while (contadorEnemigosTotales >= MAXENEMIGOS || (tipo > 0 && contadoresEnemigosTipo.get(tipo - 1) == 0)) {
            try {
                wait();
            } catch (InterruptedException e) {
                Thread.currentThread().interrupt();
            }
        }
    }

    private synchronized void comprobarAntesDeEliminar(int tipo) {
        while (contadoresEnemigosTipo.get(tipo) == 0) {
            try {
                wait();
            } catch (InterruptedException e) {
                Thread.currentThread().interrupt();
            }
        }
    }
}
