/**
 * Created by Toxblh on 26.12.13.
 */
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.ServerSocket;
import java.net.Socket;

public class Server {
    private static final int port = 8888;

    public static void main(String[] args) {
        try {
            ServerSocket ss = new ServerSocket(port);
            System.out.println("Wait client..");
            Socket socket = ss.accept();
            System.out.println("Client finded");
            System.out.println();

            InputStream sin = socket.getInputStream();
            OutputStream sout = socket.getOutputStream();

            DataInputStream in = new DataInputStream(sin);
            DataOutputStream out = new DataOutputStream(sout);

            String line = null;
            while (true) {
                line = in.readUTF();
                System.out.println("Client send: " + line);
                out.writeUTF(line);
                out.flush();
                System.out.println("Wait next..");
                System.out.println();
            }
        } catch (Exception x) {
            x.printStackTrace();
        }
    }
}
