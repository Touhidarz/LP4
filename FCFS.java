import java.util.*;
class FCFS{
    public static void main(String args[]){
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter no. of Process: ");
        int n = sc.nextInt();
        
        int arrTime[] = new int[n];
        int brstTime[] = new int[n];
        int cmplTime[] = new int[n];
        int taTime[] = new int[n];
        int wtTime[] = new int[n];

        System.out.println("Enter Arrival Time of each Process:");
        for(int i=0; i<n; i++){
            arrTime[i] = sc.nextInt();
        }

        System.out.println("Enter Burst Time of each Process:");
        for(int i=0; i<n; i++){
            brstTime[i] = sc.nextInt();
        }

        for(int i=0; i<n; i++){
            if(i==0){
                cmplTime[i] = brstTime[i] ;
            }

            else{
                if(arrTime[i] > cmplTime[i-1]){
                    cmplTime[i] = brstTime[i] + arrTime[i];
                }
                else{
                    cmplTime[i] = cmplTime[i-1] + brstTime[i];
                }
            }

            taTime[i] = cmplTime[i] - arrTime[i];
            wtTime[i] = taTime[i] - brstTime[i];
        }

        System.out.println("Process"+"\tarrivalTime"+"\tburstTime"+"\tcompletionTime"+"\tturnAroundTime"+"\twaitingTime");
        for(int i=0; i<n; i++){
            System.out.println("p"+i+"\t"+arrTime[i]+"\t"+brstTime[i]+"\t"+cmplTime[i]+"\t"+taTime[i]+"\t"+wtTime[i]);
        }
        

        sc.close();
    }
}