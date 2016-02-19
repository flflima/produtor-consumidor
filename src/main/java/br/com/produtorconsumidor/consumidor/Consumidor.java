package br.com.produtorconsumidor.consumidor;

import br.com.produtorconsumidor.buffer.Buffer;

public class Consumidor extends Thread
{

	private int idConsumidor;
	private Buffer buffer;
	
	public Consumidor(int idConsumidor, Buffer buffer) 
	{
		this.idConsumidor = idConsumidor;
		this.buffer = buffer;
	}

	@Override
	public void run() 
	{
		for (int i = 1; i <= 100; i++) 
		{
			buffer.get(idConsumidor);
			try 
			{
				sleep((int)(Math.random() * 1000));
			}
			catch (InterruptedException e) 
			{
				e.printStackTrace();
			}

		}
	}
}
