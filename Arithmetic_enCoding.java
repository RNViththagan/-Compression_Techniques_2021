// 27.9.2021
import java.util.Scanner;
import java.lang.Math;
public class Arithmetic_enCoding{
	public static void main(String args[]){
		//a .5
		//b .25
		//c .25
		//abc
		//baca
		float L=0;
		float H=1;
		float R=1;
		Scanner input = new Scanner(System.in);
		System.out.print("Enter order ");
		String y=input.next();
		//String y = "baca";
		int chcount = y.length();
		char array1[] = new char[y.length()];
		for(int i=0;i<array1.length;i++){
			array1[i] = y.charAt(i);
		}
		char array2[]=new char[50];
		int array3[]=new int[50];
		int count=0;
		for(int i=0;i<array1.length;i++){
			if(i==0){
				array2[count] = array1[i];
				array3[count]++;
				count++;
				continue;
			}
			boolean flag=true;
			for(int j=0;j<count;j++){
				if(array1[i] == array2[j]){
					array3[j]++;
					flag=false;
				}
			}
			if(flag){
				array2[count]=array1[i];
				array3[count]++;				
				count++;
			}

		}
		for(int i=0;i<count;i++){
			System.out.println("array2["+i+"] : "+ array2[i]+" "+array3[i]);
		}
		System.out.println("--------");
		
		Bubblesort(array3,array2,count);
		for(int i=0;i<count;i++){
			System.out.println("array2["+i+"] : "+ array2[i]+" "+array3[i]);
		}
		System.out.println("--------");
		float symbolvalues[][]=new float[count][2];
		float lw=0;
		for(int i=0;i<count;i++){
			for(int j=0;j<2;j++){
				symbolvalues[i][0]=lw;
				symbolvalues[i][1]=lw+(float)array3[i]/chcount;	
				if(j==1)
					lw=symbolvalues[i][1];
			}
		}
		for(int i=0;i<count;i++){
			System.out.println("array2["+i+"] : "+ array2[i]+" "+array3[i]+" "+symbolvalues[i][0]+" "+symbolvalues[i][1]);
		}
		System.out.println("--------");


		//float array3[]= new float[]{2,3,2};
		int countA=0;
		while(countA<array1.length){
			H = L + R * getSV(1,array1[countA],symbolvalues,array2,count);
			L = L + R * getSV(0,array1[countA],symbolvalues,array2,count);			
			R = H-L;
			countA++;
		}
		System.out.println("L : "+ L);
		System.out.println("H : "+ H);		
		System.out.println("R : "+ R);
		System.out.println("\n"+L+"<= code < "+H+"\n");
		// binaray code generation
		int code=0;
		int k=0;
		while(value(code,k)<L){	
			k++;		
			if(k!=1) code*=10;
			
			code++;
			if(value(code,k)>H){
				code--;
			}			
			//System.out.println(code+"  "+value(code,k)+" "+(value(code,k)<L));
		}
		System.out.println("code is : "+code+"\n");

	}
	public static float value(int code,int k){
		int codet = code;
		int rem=0;
		float value=0;
		for(int i=0;i<k;i++){
			rem=codet%10;
			codet/=10;
			//System.out.println("codet"+codet);
			value+=rem*Math.pow(2,-(k-i));
		}
		return value;
	}
	public static float getSV(int val,char charlet,float symbolvalues[][],char charray[],int count){
		for(int i=0;i<count;i++){
			if(charray[i]==charlet){
				return symbolvalues[i][val];
			}
		}
		return val;

	}
	public static void Bubblesort(int indarray[],char charray[],int arlength)
	{
		int loop=0;
		int tempind=0;
		char tempch=' ';
		while(loop<arlength-1)
		{
			int i=0;
			while(i<arlength-1-loop)
			{
				if(indarray[i]<indarray[i+1])
				{
					tempind = indarray[i];
					tempch = charray[i];
					indarray[i] = indarray[i+1];
					charray[i] = charray[i+1];
					indarray[i+1] = tempind;
					charray[i+1] = tempch;
				}
				i++;
			}
			loop++;
		}
	}
}
	