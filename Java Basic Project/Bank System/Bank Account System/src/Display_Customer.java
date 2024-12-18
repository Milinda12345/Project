import java.util.InputMismatchException;
import java.util.Scanner;
public class Display_Customer  {
    public String name ; public String accountnumber ;

    public void method1() {
        int details;
        Scanner sc = new Scanner(System.in);
        System.out.println("\n.....Please Enter Account Detail.....");
        System.out.println("Please Enter Account Name : ");
        this.name = sc.nextLine();
        System.out.println("Please Enter Account Number : ");
        this.accountnumber = sc.nextLine();
        System.out.println("\nAccount Holder : " + name);
        System.out.println("Account Number : " + accountnumber);
    }

    public void method2() {
        System.out.println("\n.....Bank System Menu.....");
        System.out.println("1. View Account Detail  \n2. Deposit Money \n3. Withdraw Money \n4. Exit\n");
    }

    public void method3() {
        System.out.println("\n .....Your Detail is Correct.....");
        System.out.println("1.Yes \n2.No ");
    }

    public int method4() {
        Scanner sc = new Scanner(System.in);
        int details = 0;
        boolean validInput = false;
        int attempts = 0 ;
        int maxAttempts = 3;

        while (!validInput && attempts < maxAttempts) {
            try {
                System.out.println("\n Please Enter Your Choice : ");
                details = sc.nextInt();
                if (details == 1 || details == 2) {
                    validInput = true;
                } else {
                    System.out.println("\n Please Enter Correct Your Choice 1 or 2 ");
                }
            } catch (InputMismatchException e) {
                System.out.println("Yout input is not correct  Please Enter Correct Your Choice of 1 or 2 :");
                sc.nextLine();
            } catch (Exception e) {
                System.out.println(e);
                sc.nextLine();
            }
            attempts++;
        }
        if (!validInput) {
            System.out.println("\n Maximum attempts reached. Exiting");
            details = -1 ;
        }
        return details;
    }

    public int method5() {
        Scanner sc = new Scanner(System.in);
        int details1 = 0;
        boolean validInput = false;
        int attempts1 = 0 ;
        int maxAttempts = 3;

        while (!validInput && attempts1 < maxAttempts) {
            try {
                System.out.println("\n Please Enter Your Choice : ");
                details1 = sc.nextInt();
                if (details1 == 1 || details1 == 2 || details1 == 3 || details1 == 4) {
                    validInput = true;
                }else {
                    System.out.println("\n Please Enter Correct Your Choice 1 or 2 or 3 or 4  ");
                }
            } catch (InputMismatchException E){
                System.out.println("Yout input is not correct  Please Enter Correct Your Choice of 1 or 2 or 3 or 4:");
                sc.nextLine();
            }
            catch (Exception e) {
                System.out.println(e);
            }
            attempts1++;
        }
        if (!validInput) {
            System.out.println("\n Maximum attempts reached. Exiting");
            details1 = -1 ;
        }
        return details1;
    }

    public String getName(){
        return name;
    }

    public String getAccountnumber(){
        return accountnumber;
    }

    public int method6() {
        Scanner sc = new Scanner(System.in);
        int details2 = 0;
        boolean validInput = false;
        int attempts3 = 0 ;
        int maxAttempts = 3;

        while (!validInput && attempts3 < maxAttempts) {
            try {
                System.out.println("\nPlease Enter 1  pervious bank menu :");
                details2 = sc.nextInt();
                if (details2 == 1 ) {
                    validInput = true;
                }else {
                    System.out.println("\n Please Enter 1 bank menu : ");
                }
            }catch (InputMismatchException e){
                System.out.println("\n Please Enter 1 bank menu : ");
            }catch (Exception e) {
                System.out.println(e);
            }
            attempts3++;
        }
        if (!validInput) {
            System.out.println("\n Maximum attempts reached. Exiting");
        }
        return details2;
    }
}

