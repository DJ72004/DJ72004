import java.net.DatagramPacket;
import java.net.DatagramSocket;

class UDPC {
    public static void main(String[] args) throws Exception{
        DatagramSocket dgs = new DatagramSocket(4000);
        String msg;
        byte [] buff;
        System.out.println("Connection Success");
        while (true) {
            buff = new byte[65555];
            DatagramPacket dgp = new DatagramPacket(buff, buff.length);
            dgs.receive(dgp);
            msg = new String(buff);
            System.out.println(msg);
            if(msg.equalsIgnoreCase("exit")){
                dgs.close();
                break;
            }
        }
        
    }    
}
