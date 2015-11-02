import java.util.Scanner;


public class Test3 {

	public static int up(int a,int b){
		if(a%b==0)
			return a/b;
		else
			return ((a/b) +1);
	}
	public static void main(String[] args){
		
		int n;
		System.out.print("Enter number of jobs:");
		Scanner s = new Scanner(System.in);
		n = s.nextInt();
		
		Jobs[] j = new Jobs[n];
		
		System.out.print("Enter jobs details:\n");
		for(int i=0;i<n;i++){
			j[i] = new Jobs();
			System.out.print("Enter execution time of task "+(i+1)+" : ");
			j[i].c=s.nextInt();
			System.out.print("Enter period of task "+(i+1)+" : ");
			j[i].p=s.nextInt();
			j[i].s=i;
		}
		
		int[] a = new int[n]; //response time for each job according to the test.
		for(int i=0;i<n;i++){
			a[i] = 0;
		}
		for(int i=0;i<n;i++){
			a[0] = a[0] + j[i].c;
		}
		int temp=0;
		for(int i=1;i<n;i++){
			for(int k=0;k<n-1;k++){
				temp = temp + (up(a[i-1],j[k].p)*j[k].c);
			}
			a[i] = temp + j[n-1].c;
			temp=0;
		}
		SRTF sch = new SRTF();
		if(a[n-1]<=j[n-1].p){
			System.out.print("Yse! Its Schedulable!\nExecution sequence :\n");
			for(int i=0;i<n;i++)
				System.out.print("Process "+(i+1)+"\n");
		}
		else{
			System.out.print("The task set is not schedulable!\n");
		}
	}
}
