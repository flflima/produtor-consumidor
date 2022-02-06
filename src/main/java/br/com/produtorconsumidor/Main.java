package br.com.produtorconsumidor;

import br.com.produtorconsumidor.buffer.Buffer;
import br.com.produtorconsumidor.consumidor.Consumer;
import br.com.produtorconsumidor.produtor.Producer;

public class Main {
    public static void main(String[] args) {
        Buffer buffer = new Buffer();
        Producer p1 = new Producer(1, buffer);
        Consumer c1 = new Consumer(1, buffer);

        p1.start();
        c1.start();

        Producer p2 = new Producer(2, buffer);
        Consumer c2 = new Consumer(2, buffer);

        p2.start();
        c2.start();
    }
}
