limport java.util.ArrayList;
import java.util.Scanner;

public class Leaky {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter the Number of Packets");
        int  n = sc.nextInt();
        ArrayList <Integer> arr = new ArrayList<>();
        System.out.println("Enter the Bucket Size");
        int  b = sc.nextInt();
        System.out.println("Enter the Out Rate");
        int  out = sc.nextInt();
        int val;
        for(int i =0;i<n;i++){
            val = sc.nextInt();
            if(val <= b)
                arr.add(val);
            
        }
        System.out.println("The Packets are coming out in the order of ");
        for(int i =0;i<arr.size();){
            val = arr.get(i);
            if(val <= out){
                System.out.println(val);
                i++;
            }
            else{
                arr.set(i, val - out);
                System.out.println(out);
            }
        }
        sc.close();
    }
}
