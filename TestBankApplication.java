import java.util.Scanner;

public class TestBankApplication {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		BankAccount[] axisBank = new BankAccount[5];
		//
		System.out.println("1 :create account 2: display Account 3:names  4: credilt limt 5:edit climit");
		boolean flag = true;
		int index = 0;
		Scanner sc = new Scanner(System.in);
		while (flag == true) {
			System.out.println("Enter Choice:");
			int ch = sc.nextInt();
			switch (ch) {
			case 1:
				if (index < axisBank.length) {
					System.out.println("Enter ActId NAme  Balance CLimit");
					BankAccount act = new BankAccount(sc.nextInt(), sc.next(), sc.nextDouble(), sc.nextDouble());
					axisBank[index] = act;
					index++;
				} else {
					System.out.println("---full-----");
				}
				break;
			case 2:
				  for(int i=0;i<index;i++)
				  {
					  axisBank[i].display();
				  }
				  break;
			case 3:		  
				//System.out.println("1 :create account 2: display Account 3:names  4: credilt limt 5:edit climit");
				for(int i=0;i<index;i++)
				  {
					System.out.println(axisBank[i].getName());
				  }
				break;
			case 4:
				for(int i=0;i<index;i++)
				  {
					System.out.println(axisBank[i].getCreditLimit());
				  }
				break;
			}// switch

		} // while

	}

}
