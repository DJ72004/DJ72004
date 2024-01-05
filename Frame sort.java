import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.Scanner;

class Frame{
    public static void main(String[] args) {
        List<int [] > frames = new ArrayList<>();
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter the Number of Packets");
        int n = sc.nextInt();
        Random rd = new Random();
        for(int i = 0;i<n;i++){
            System.out.println("Data For Packet " +(i+1));
            frames.add(new int[]{sc.nextInt() , rd.nextInt(10000)});
        }
        System.out.println("Original Order of frames");
        for(int []curr : frames)
            System.out.println(curr[0] +" "+curr[1]);
        System.out.println("After Frame Sorting at server side");
        System.out.println(frames.get(0)[0] + " "+frames.get(0)[1]);
        int val = frames.get(0)[1];
        for(int i =1;i<n;i++)
            System.out.println(frames.get(i)[0] + " "+(++val));
        sc.close();
    }    
}
