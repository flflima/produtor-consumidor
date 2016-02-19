package br.com.produtorconsumidor;

import br.com.produtorconsumidor.buffer.Buffer;
import br.com.produtorconsumidor.consumidor.Consumidor;
import br.com.produtorconsumidor.produtor.Produtor;

public class Main 
{

	public static void main(String[] args) 
	{
		Buffer buffer = new Buffer();
		Produtor p1 = new Produtor(1, buffer);
		Consumidor c1 = new Consumidor(1, buffer);
		
		p1.start();
		c1.start();
		
		Produtor p2 = new Produtor(2, buffer);
		Consumidor c2 = new Consumidor(2, buffer);
		
		p2.start();
		c2.start();
	}

}
