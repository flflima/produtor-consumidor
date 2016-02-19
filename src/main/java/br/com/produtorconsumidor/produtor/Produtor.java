package br.com.produtorconsumidor.produtor;

import br.com.produtorconsumidor.buffer.Buffer;

public class Produtor extends Thread 
{
	private int idProdutor;
	private Buffer buffer;
	
	public Produtor(int idProdutor, Buffer buffer) 
	{
		this.idProdutor = idProdutor;
		this.buffer = buffer;
	}

	@Override
	public void run() 
	{
		for (int i = 1; i <= 100; i++)
		{
			buffer.put(idProdutor, i);	
			try 
			{
				sleep((int)(Math.random() * 100));
			}
			catch (InterruptedException e) 
			{
				e.printStackTrace();
			}
		}
	}
}
