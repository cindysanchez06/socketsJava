package main;

import java.io.IOException;
import sockets.Client;


//Clase principal que hará uso del cliente
public class mainClient
{
    public static void main(String[] args) throws IOException
    {
    	try {
    	    Client cli = new Client(); //Se crea el cliente

            cli.startClient(); //Se inicia el cliente
    	}
    	catch(Exception e){
    		System.out.println(e.getMessage());
    	}
    }
}
