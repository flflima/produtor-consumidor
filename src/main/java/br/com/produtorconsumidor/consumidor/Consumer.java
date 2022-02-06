package br.com.produtorconsumidor.consumidor;

import br.com.produtorconsumidor.buffer.Buffer;
import java.util.Random;

public class Consumer extends Thread {

    private final int id;
    private final Buffer buffer;
    private final Random random = new Random();

    public Consumer(int id, Buffer buffer) {
        this.id = id;
        this.buffer = buffer;
    }

    @Override
    public void run() {
        for (int i = 1; i <= 100; i++) {
            buffer.get(id);
            try {
                sleep(random.nextInt() * 10000L);
            } catch (InterruptedException e) {
                e.printStackTrace();
                Thread.currentThread().interrupt();
            }
        }
    }
}
