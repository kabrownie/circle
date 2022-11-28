
import java.net.*;
import java.io.*;
import java.util.Scanner;

public class server extends Thread {
    private ServerSocket serverSocket;

    public server(int port) throws IOException {
        serverSocket = new ServerSocket(port);

    }

    public void run() {
        while (true) {
            try {
                System.out.println("Waiting for client on port " + serverSocket.getLocalPort() + "...");
                Socket server = serverSocket.accept();
                System.out.println("Just connected to " + server.getRemoteSocketAddress());
                DataInputStream in = new DataInputStream(server.getInputStream());

                    double pi = 3.142;

               double x = in.readInt();
              System.out.println("radius recieved");
                double area = (pi * x *x);
                DataOutputStream out = new DataOutputStream(server.getOutputStream());

                // System.out.println(sum);
                out.writeDouble(area);

                server.close();

            } catch (IOException e) {
                e.printStackTrace();
                break;
            }
        }
    }

    public static void main(String[] args) {

        Scanner userInput = new Scanner(System.in);
        System.out.println("Please specify a port number (1~65535): ");
        String port;
        port = userInput.next();

        try {
            Thread t = new server(Integer.parseInt(port));
            t.start();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

}