package simulador_juego;

import java.util.Random;
import java.util.concurrent.TimeUnit;

public class ActividadAliada implements Runnable {
    private final int tipoEnemigo;
    private final IJuego juego;

    public ActividadAliada(int tipo, IJuego juego) {
        this.tipoEnemigo = tipo;
        this.juego = juego;
    }

    @Override
    public void run() {
        try {
            Random rand = new Random();
            TimeUnit.MILLISECONDS.sleep(rand.nextInt(4000) + 1000);
            juego.eliminarEnemigo(tipoEnemigo);
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
        }
    }
}
