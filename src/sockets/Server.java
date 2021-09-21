package sockets;

import sockets.Conexion;
import java.net.*;
import java.io.*;

public class Server extends Conexion //Se hereda de conexión para hacer uso de los sockets y demás
{
    public Server() throws IOException{super("server");} //Se usa el constructor para servidor de Conexion

    public void startServer()//Método para iniciar el servidor
    {
        try
        {
            System.out.println("Esperando..."); //Esperando conexión

            cs = ss.accept(); //Accept comienza el socket y espera una conexión desde un cliente

            System.out.println("Cliente en línea");

            //Se obtiene el flujo de salida del cliente para enviarle mensajes
            //salidaCliente = new DataOutputStream(cs.getOutputStream());
            
            //Se le envía un mensaje al cliente usando su flujo de salida
            //salidaCliente.writeUTF("Petición recibida y aceptada");

            DataInputStream din = new DataInputStream(cs.getInputStream());
            //Se obtiene el flujo entrante desde el cliente
            //BufferedReader entrada = new BufferedReader(new InputStreamReader(System.in));
            mensajeServidor = "";
            while(!mensajeServidor.equals("stop")) //Mientras haya mensajes desde el cliente
            {
            	mensajeServidor = din.readUTF();
            	if(!mensajeServidor.equals("stop"))
            	{
            		System.out.println(mensajeServidor);
            	}
            }
            

            System.out.println("Fin de la conexión");

            ss.close();//Se finaliza la conexión con el cliente
        }
        catch (Exception e)
        {
        	System.out.println(e);
            System.out.println(e.getMessage());
        }
    }
}
