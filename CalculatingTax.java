import java.util.Scanner;
public class CalculatingTax {
    public static void main(String[] args)
    {
        System.out.println("Tax Calculator App");
        System.out.println("****WELCOME****");

        Scanner s=new Scanner(System.in);
        int n;
        System.out.print("Enter total number of person: ");
        n=s.nextInt();
        s.nextLine();
        String[] N = new String[n]; //Name
        long[] I = new long[n]; //Income
        for(int i=0 ; i<n;i++)
        {
            System.out.print(i+1+ " Enter the Name: ");
            N[i] = s.nextLine();
            System.out.print("Enter "+N[i]+"'s Annual Income: ");
            I[i] = s.nextLong();
            s.nextLine();
        }
        System.out.println("Names with liable taxes");
        System.out.println("__________****___________");
        for(int j=0 ; j<n;j++)
        {
            calculateTax(N[j], I[j]);
        }
    }
    public static void calculateTax(String n,Long i)
    {
        int t; //Tax payable
        if(i>=300000)
        {
            t = (int)(i * 0.02);
        }
        else if(i >= 100000)
        {
            t = (int)(i * 0.01);
        }
        else
        {
            t=0;
        }
        System.out.println(n+ "'s Tax is: "+ t);
    }
}