package sockets;

import java.io.DataOutputStream;
import java.io.IOException;
import sockets.Conexion;

public class Client extends Conexion
{
    public Client() throws IOException{super("client");} //Se usa el constructor para cliente de Conexion

    public void startClient() //Método para iniciar el cliente
    {
        try
        {
            //Flujo de datos hacia el servidor
            salidaServidor = new DataOutputStream(cs.getOutputStream());

            //Se enviarán dos mensajes
            for (int i = 0; i < 2; i++)
            {
   
            	System.out.println("enviando mensaje");
                //Se escribe en el servidor usando su flujo de datos
                salidaServidor.writeUTF("Este es el mensaje número " + (i+1) + " desde ip 192.168.20.52 a ip 192.168.20.51 \n");
                //salidaServidor.flush();
                
            }
            salidaServidor.writeUTF("stop");
            cs.close();//Fin de la conexiónte

        }
        catch (Exception e)
        {
            System.out.println(e.getMessage());
        }
    }
}
