import java.util.*;
public class fab {
    public static void main(String args[]){
        Scanner sc = new Scanner(System.in); 
        int n = sc.nextInt();
        int Arr[] = new int[n];
        
        Arr[1] = 1;
        for(int i=2 ;i<n; i++){
            Arr[i] = Arr[i-1]+Arr[i-2];
        }

        for(int i=0 ;i<n; i++){
            System.out.print(Arr[i]+" ");
        }
    }
}
