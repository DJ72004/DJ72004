import java.net.*;
public class TCPS{
    public static void main(String []args) throws Exception{
    ServerSocket ss=new ServerSocket(4000);
    
    System.out.println("Server connected ");
    Socket s=ss.accept();
    System.out.println("connectiomn successful waiting file name ");
    InputStream is=s.getInputStream();
    BufferedReader nread=new BufferedReader(new InputStreamReader(is));
    String sname=nread.readLine();
    OutputStream os=s.getOutputStream();
    PrintWriter pwrite=new PrintWriter(os,true);
    try{
        BufferedReader contread=new BufferedReader(new FileReader(sname));
        String str;
        while((str=contread.readLine())!=null)
            pwrite.println(str);
        contread.close();

    }
    catch(FileNotFoundException e){
        System.out.println("Connection lost ");
    }
    finally{
        System.out.println(" closing COnnection ");
        pwrite.close();
        nread.close();
        s.close();
        ss.close();
    }
}
}
