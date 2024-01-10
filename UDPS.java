import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;
import java.util.Scanner;

class UDPS{
    public static void main(String[] args) throws Exception{
        Scanner sc = new Scanner(System.in);
        DatagramSocket dgs = new DatagramSocket();
        InetAddress cladd = InetAddress.getByName("127.0.0.1");
        String msg ; 
        byte [] buff;
        System.out.println("Enter the Message to send");
        while (true) {
            msg = sc.nextLine();
            buff = msg.getBytes();
            DatagramPacket dgp = new DatagramPacket(buff, buff.length , cladd , 4000);
            dgs.send(dgp);
            if(msg.equalsIgnoreCase("exit"))
                break;
        }
        sc.close();
        dgs.close();
    }
}
