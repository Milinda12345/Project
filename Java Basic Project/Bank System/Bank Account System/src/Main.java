public class Main {

    public static void main(String[] args) {
        int num2 = 0;
        final int maxAttemps = 3;
        boolean success = false;
        int attempt = 0;

        Display_Customer obj1 = new Display_Customer();
        Bank_Fuction obj3 = new Bank_Fuction();

        obj1.method1(); // Enter user input details and show detail
        obj1.method3();  // correct details
        int num1 = obj1.method4(); // 1 or 2 value assign
        num2 = num1;
        while (attempt < maxAttemps && num2 == 2) {
            obj1.method1(); // Enter user input details and show detail
            obj1.method3(); // // correct details
            num2 = obj1.method4(); // 1 or   2 value get
            attempt++;
        }

        int num15 = num2;
        if (num15 == 2) {
            System.out.println(" Sorry your details is incorrect\n please check and try again");
            System.exit(0); // system exit
        }

       while (num15 == 1) { // ensure the loop condition is boolean

            String username = obj1.getName(); // updatw customer name
            String useraccount = obj1.getAccountnumber(); // update customer account

            obj1.method2(); // call the bank system menu
            int num16 =obj1.method5() ;  // choice bank manu function 1 0r 2 0r 3 0r 4

            switch (num16) {

                    case 1:

                    obj3.function3(username, useraccount);
                    obj1.method6(); // choice pervious bank menu get the 1
                        break;

                    case 2:

                        obj3.function4();
                        int num20 = obj1.method6(); // choice pervious bank menu get the 11
                        break;

                        case 3:

                            obj3.function6();
                            int num23 = obj1.method6(); // choice pervious bank menu get the 1
                            break;

                            case 4:

                                System.out.println(" Thank you Join With us ");
                                System.exit(0);
                                break;
            }
       }
    }
}

