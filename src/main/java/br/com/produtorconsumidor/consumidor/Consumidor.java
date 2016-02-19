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
		for (int i = 1; i <= 10; i++) 
		{
			buffer.get(idConsumidor);	
		}
	}
}
