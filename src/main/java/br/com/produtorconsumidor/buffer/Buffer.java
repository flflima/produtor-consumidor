package br.com.produtorconsumidor.buffer;

public class Buffer 
{
	private int conteudo;
	private boolean disponivel;

	public synchronized void put(int id, int valor)
	{
		while (disponivel)
		{
			try 
			{
				wait();
			}
			catch (InterruptedException e) 
			{
				e.printStackTrace();
			}
		}
		
		disponivel = true;
		
		this.conteudo  = valor;
		System.out.println("Produtor " + id +" criando " + conteudo + " ...");
		
		notifyAll();
	}

	public synchronized void get(int id) 
	{
		while (!disponivel)
		{
			try 
			{
				wait();
			}
			catch (InterruptedException e) 
			{
				e.printStackTrace();
			}
		}
		
		disponivel = false;
		
		System.out.println("Consumidor " + id + " consumindo " + conteudo + " ...\n");
		
		notifyAll();
	}

}
