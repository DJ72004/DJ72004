import java.io.*;
import java.net.*;
public class TCPC{
    public static void main(String []args) throws Exception{
        Socket s1=new Socket("127.0.0.1",4000);
        System.out.println("Enter the file name");
        BufferedReader re=new BufferedReader(new InputStreamReader(System.in));
        String name=re.readLine();
        OutputStream os1=s1.getOutputStream();
        PrintWriter pwrite1=new PrintWriter(os1,true);
        pwrite1.println(name);
        InputStream is1=s1.getInputStream();
        BufferedReader nread1=new BufferedReader(new InputStreamReader(is1));
        String str1;
        while((str1=nread1.readLine())!=null){
            System.out.println(str1);
        }
        s1.close();
        re.close();
       pwrite1.close();
       nread1.close();

    }

}
