import java.util.Scanner;

public class TesterStudent {

	public static void main(String[] args) {

		
		//user(client) of Student class
		
       //IACSD having 240 student
		
		//how we can use class?
		//Create an object of the class
		//DataType objectName
		//ClassName objectName
		
		Student studObj1;//declaration created on stack
		
		//object must be instantiaated using new key word
		
		studObj1=new Student();//allocating memory on heap to store rollno name addr m1m2m3
		//private are not visible here
		//only public are visible outside 
        studObj1.result();//through public methods we can indirectly  accessing private data members
        
		
		Scanner sc=new Scanner(System.in);
		int a=sc.nextInt();//
		
		
	}

}
