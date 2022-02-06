package br.com.produtorconsumidor.buffer;

public class Buffer {

    private static final int TOTAL = 10;
    private final int[] items = new int[TOTAL];

    public Buffer() {
        for (int i = 0; i < TOTAL; i++) {
            items[i] = -1;
        }
    }

    public synchronized void put(int id, int value) {
        while (isFull()) {
            System.out.println(">> Buffer está cheio! <<");
            try {
                System.out.println(">> Produtor " + id + " aguardando...");
                wait();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        push(value);
        System.out.println("Produtor " + id + " criando " + value + "...");
        notifyAll();
    }

    private boolean isFull() {
        return items[TOTAL - 1] > -1;
    }

    private int getEmptyPosition() {
        for (int i = 0; i < TOTAL; i++) {
            if (items[i] == -1) {
                return i;
            }
        }
        return TOTAL - 1;
    }

    public synchronized void get(int id) {
        while (isEmpty()) {
            System.out.println(">> Buffer está vazio! <<");
            try {
                System.out.println(">> Consumidor " + id + " aguardando...");
                wait();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }

        int value = pop();
        System.out.println("Consumidor " + id + " consumindo " + value + "...");
        notifyAll();
    }

    private boolean isEmpty() {
        return items[0] == -1;
    }

    private void push(int value) {
        items[getEmptyPosition()] = value;
    }

    private int pop() {
        for (int i = TOTAL-1; i >= 0; i--) {
            if (items[i] > -1) {
                int value = items[i];
                items[i] = -1;
                return value;
            }
        }
        return -1;
    }
}
