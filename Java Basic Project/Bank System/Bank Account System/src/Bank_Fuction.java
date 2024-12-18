import java.util.InputMismatchException;
import java.util.Scanner;

public class Bank_Fuction  {
    double accountbalance = 1000 ;

    public void function3(String customername, String cusomeraccount) {
        System.out.println(".....Your Account Details.....");
        System.out.println("\nAccount Holder : " + customername);
        System.out.println("Account Number : " + cusomeraccount);
        System.out.println("Your Current Balance  Is : " + accountbalance);
    }

    public void function4() {
        Scanner sc = new Scanner(System.in);

        try {
            System.out.println("\nPlease Enter Deposit Amount : ");
            double num5 = sc.nextDouble();
            double updateaccountbalance = num5 + accountbalance;
            System.out.println("Succefully Deposited \n Your new Account Banance is : " + updateaccountbalance);
            this.accountbalance = updateaccountbalance;

        } catch (InputMismatchException e) {
            System.out.println("please deposit value money");
        } catch (Exception e) {
            System.out.println(e);
        }
    }

    public void function6() {
        Scanner sc = new Scanner(System.in);

        try {
            System.out.println("\nPlease Enter Withdrwal Amount : ");
            double num6 = sc.nextDouble();
            double updateaccountbalancew= accountbalance - num6;
            System.out.println("Succefully Withdrwal \n Your new Account Balancece is : " + updateaccountbalancew);
            this.accountbalance = updateaccountbalancew;

        } catch (InputMismatchException e) {
            System.out.println("please Withdrwal value money");
        } catch (Exception e) {
            System.out.println(e);
        }
    }
}


