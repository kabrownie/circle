
import java.net.*;
import java.io.*;

public class server extends Thread {
    private static ServerSocket serverSocket;

    public server(ServerSocket port) throws IOException {
        serverSocket = new ServerSocket(6000);

    }

    public void run() {
        while (true) {
            try {
                System.out.println("Waiting for client on port " + serverSocket.getLocalPort() + "...");
                Socket server = serverSocket.accept();
                System.out.println("Just connected to " + server.getRemoteSocketAddress());
                DataInputStream in = new DataInputStream(server.getInputStream());

                    Double pi = 3.142;

               Double x = in.readDouble();
              System.out.println("radius recieved");
                Double area = (pi * Math.pow(x, 2));
                DataOutputStream out = new DataOutputStream(server.getOutputStream());

                System.out.println(area);
                out.writeDouble(area);

                server.close();

            } catch (IOException e) {
                e.printStackTrace();
                break;
            }
        }
    }

    public static void main(String[] args) {



        try {
            Thread t = new server((serverSocket));
            t.start();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

}