/**
 * Created by Toxblh on 26.12.13.
 */
import java.io.*;
import java.net.InetAddress;
import java.net.Socket;

public class Client {
    private static final int port = 8888;
    private static final String addr = "127.0.0.1";

    public static void main(String[] ar) {
        try {
            InetAddress ipAdress = InetAddress.getByName(addr);
            System.out.println("Connect to "+addr + ":"+port);
            Socket socket = new Socket(ipAdress, port);
            System.out.println("Open socket");
            InputStream sin = socket.getInputStream();
            OutputStream sout = socket.getOutputStream();

            DataInputStream in = new DataInputStream(sin);
            DataOutputStream out = new DataOutputStream(sout);

            BufferedReader key = new BufferedReader(new InputStreamReader(System.in));
            String line = null;
            System.out.println("Type you message...");
            System.out.println();

            while (true) {
                line = key.readLine();
                System.out.println("Send your mess");
                out.writeUTF(line);
                out.flush();
                System.out.println("Your mess send");
                line = in.readUTF();
                System.out.println("Server answer: " + line);
                System.out.println();
            }
        } catch (Exception x) {
            x.printStackTrace();
        }
    }
}