package br.com.produtorconsumidor.buffer;

public class Buffer 
{
	private int itens = 0;
	private int capacidadeTotal = 10;

	public synchronized void put(int id, int valor)
	{
		while (itens >= capacidadeTotal)
		{
			try 
			{
				System.out.println(">> Produtor " + id +" aguardando...\n");
				wait();
			}
			catch (InterruptedException e) 
			{
				e.printStackTrace();
			}
		}
		
		itens++;

		System.out.println("Produtor " + id +" criando " + itens + "...\n");
		
		notifyAll();
	}

	public synchronized void get(int id) 
	{
		while (itens <= 0)
		{
			try 
			{
				System.out.println(">> Consumidor " + id +" aguardando...\n");
				wait();
			}
			catch (InterruptedException e) 
			{
				e.printStackTrace();
			}
		}
		
		System.out.println("Consumidor " + id + " consumindo " + itens + "...\n");
		
		itens--;
		
		notifyAll();
	}

}
