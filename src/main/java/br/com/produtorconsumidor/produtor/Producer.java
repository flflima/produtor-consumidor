package br.com.produtorconsumidor.produtor;

import br.com.produtorconsumidor.buffer.Buffer;
import java.util.Random;

public class Producer extends Thread {

    private final int id;
    private final Buffer buffer;
    private final Random random = new Random();

    public Producer(int id, Buffer buffer) {
        this.id = id;
        this.buffer = buffer;
    }

    @Override
    public void run() {
        for (int i = 1; i <= 100; i++) {
            buffer.put(id, i);
            try {
                sleep(random.nextInt() * 100L);
            } catch (InterruptedException e) {
                e.printStackTrace();
                Thread.currentThread().interrupt();
            }
        }
    }
}
