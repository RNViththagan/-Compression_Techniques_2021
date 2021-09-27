// 27.9.2021
import java.util.Scanner;
public class ArithmeticCoding{
	public static void main(String args[]){
		float L=0;
		float H=1;
		float R=1;
		Scanner input = new Scanner(System.in);
		System.out.print("Enter Head prob : ");
		float ph = input.nextFloat();
		System.out.print("Enter order ");
		String y=input.next();
		char array1[] = new char[y.length()];
		for(int i=0;i<array1.length;i++){
			array1[i] = y.charAt(i);
			if(array1[i]>96)
				array1[i]-=32;
		}
		//array1= new char[]{'T','H','T'};
		int count=0;
		while(count<array1.length){
			H = L + R * getSV('H',count,array1,ph);
			L = L + R * getSV('L',count,array1,ph);			
			R = H-L;
			count++;
		}
		System.out.println("L : "+ L);
		System.out.println("H : "+ H);		
		System.out.println("R : "+ R);

	}
	public static float getSV(char val,int index,char array[],float ph){
		float Sl_H=0;
		float Sh_H=ph;
		float Sl_T=ph;
		float Sh_T=1;
		
		if(val=='L'){
			if(array[index]=='T')
				return Sl_T;
			else
				return Sl_H;

		}
		else if(val=='H'){
			if(array[index]=='T')
				return Sh_T;
			else
				return Sh_H;
		}
		return 0;
	}
}
