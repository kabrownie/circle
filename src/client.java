
import java.net.*;
import java.io.*;
import java.util.Scanner;

public class client {
    public static void main(String[] args) {
        Scanner userInput = new Scanner(System.in);

        String serverName;
        serverName ="localhost";
        System.out.println("Connected to localhost server :)");

        System.out.println("Enter server  Port Number: ");
        String port;
        port = userInput.next();

        try {
            System.out.println("Connecting to " + serverName + " on port " + port);
            Socket client = new Socket(serverName, Integer.parseInt(port));
            System.out.println("Just connected to " + client.getRemoteSocketAddress());
            OutputStream outToServer = client.getOutputStream();
            DataOutputStream out = new DataOutputStream(outToServer);

            System.out.println("Enter the radius of the circle: ");

//userInput.nextInt();
          Double x = userInput.nextDouble();

//  System.out.println("hello");

            out.writeDouble(x);


            DataOutputStream os = new DataOutputStream(client.getOutputStream());
            BufferedReader is = new BufferedReader(new InputStreamReader(client.getInputStream()));

            InputStream inFromServer = client.getInputStream();
            DataInputStream in = new DataInputStream(inFromServer);
            System.out.println("Server responds: " + in.read());
//            client.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}