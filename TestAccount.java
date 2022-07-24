import java.util.Scanner;

// test account
public class TestAccount {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
//create object of BankAccount
  
    System.out.println("Testing clone");
     System.out.println("Testing clone");

    BankAccount act1;
    act1=new BankAccount();
	//
    act1.createAccount(101, "Ram", 50000);
    act1.showAccount();//display all details abt BankAccount
	
    Scanner sc=new  Scanner(System.in);
    System.out.println("Enter Amount to Withdraw");
    double amt=sc.nextDouble();
    
    act1.withdraw(amt);
    act1.showAccount();//after withdraw show all details again
    
    
    
    BankAccount act2=new BankAccount();
    act2.createAccount(303, "Kiran", 70000);
    act2.showAccount();
    act2.withdraw(30000);//
    act2.deposite(50000);//
    
    act1.showAccount();//
    
   
   act2.showAccount(); 
    
    
    
    
    
	}

}
