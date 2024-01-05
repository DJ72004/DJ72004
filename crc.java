import java.util.Scanner;

public class Crc {
    static String crc(String data ,String poly,boolean check){
        int n = data.length();
        int m = poly.length();
        if (!check){
            for(int i=0;i<n-m+1;i++)
                data += "0";
        }
        String b = "",rem = "",a = "",zeros = "";
        
        for(int i=0;i<m;i++)
            zeros += "0";
        
        for(int i=0;i<n;i++){
            try{
                if(i == 0){
                    a = data.substring(0, m);
                }
                else{
                    a = rem.substring(1) + String.valueOf(data.charAt(i+m-1));
                }
                if(a.charAt(0) == '1')
                    b = poly;
                else
                    b = zeros;

                rem = "";
                for(int j=0;j<m;j++)
                    rem += b.charAt(j) == a.charAt(j) ? "0" : "1";
            }catch(StringIndexOutOfBoundsException exception){
                break;
            }
        }
        return rem.substring(1);
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter the Data Word");
        String data = sc.next();
        System.out.println("Enter the Generating Polynomial ");
        String poly = sc.next();
        sc.close();
        data += crc(data , poly , false);
        System.out.println(data);
        String check = crc(data , poly , true);
        if(check.contains("1"))
            System.out.println("The String Is Manupliated at Reciever End ");
        else    
            System.out.println("Data Word is Not Manupliated at reciever End");
            
    }
}
