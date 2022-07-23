import java.util.Scanner;

public class TestStringArray {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		String a;
		a = "Pune";
		System.out.println(a);

		a = "IACSD";
		System.out.println(a);
		//
		String[] studNames;// declaration
		studNames = new String[10];// 5 names

		System.out.println("1:Add Name 2: Show All Names 3:Find Name 4:edit name 5:Exit");

		boolean flag = true;
		Scanner sc = new Scanner(System.in);
		String name;
		int ch;
		int index = 0;
		while (flag == true) {
			System.out.println("Enter Choice");
			ch = sc.nextInt();
			switch (ch) {
			case 1:
				if (index < studNames.length) {
					System.out.println("Enter Name:");
					name = sc.next();// accept name from user
					studNames[index] = name;
					index = index + 1;// or index ++
				} else {
					System.out.println("Array  Is Full");
				}
				break;
			case 2:
				
				System.out.println("---Names----");
				for (int i = 0; i < index; i++) {
					System.out.print(studNames[i] + "  ");
				}
				System.out.println();
				break;
			case 3:System.out.println("Enter Name To Serach:");
			       name=sc.next();//
			       for(int i=0;i<index;i++)
			       {//studNames[i].equals(name);//studNames[i]==name
			    	//for string chking use equals   
			    	   if(studNames[i].equals(name))//equal Method by String class to compair
			    	   {
			    		   System.out.println("Present");
			    	   }
			    	   
			       }
				break;
			case 4://
				System.out.println("Enter Name To Edit:");
			       name=sc.next();//new name
			       for(int i=0;i<index;i++)
			       {//studNames[i].equals(name);//studNames[i]==name
			    	//for string chking use equals   
			    	   if(studNames[i].equals(name))//equal Method by String class to compair
			    	   {
			    		   System.out.println("Enter New Name:");
			    		   name=sc.next();
			    		   studNames[i]=name;
			    		   System.out.println("Name updated");
				    		  
			    		   
			    	   }
			    	   
			       }
				break;
			case 5:flag=false;
				break;

			}// switch
		} // while
System.out.println("------------end-----------");
	}

}
