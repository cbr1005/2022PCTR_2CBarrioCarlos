package simulador_juego;

public class SistemaLanzador {

    public static void main(String[] args) {
        int maxEnemigos = 10;
        int tiposEnemigos = 4;
        int enemigosPorTipo = 4;
        Juego juego = new Juego(maxEnemigos, tiposEnemigos);

        for (int i = 0; i < tiposEnemigos; i++) {
            for (int j = 0; j < enemigosPorTipo; j++) {
                new Thread(new ActividadEnemiga(i, juego)).start();
                new Thread(new ActividadAliada(i, juego)).start();
            }
        }
    }
}
