import java.util.Scanner;

public class AccountTest {

   
  public static void main(String[] args) {

        Scanner input = new Scanner(System.in);

        String[] options ={"Create Account", "Deposit", "Transfer", "Withdrawal", "Change Pin", "Deactivation",};
        Account account = new Account();


        System.out.println("Welcome To David Bank");
        System.out.println("================================");

        String answer = "yes";
        while (answer.equalsIgnoreCase("yes")) {

        int count = 1;

        for (int index = 0; index < options.length; index++) {
        System.out.printf("%d.%s%n",count,options[index]);
        count++;
         }

        System.out.print("\nSelect an option: ");
        int choice = input.nextInt();
        input.nextLine(); 


         switch (choice) {

           case 1:

       System.out.println("\n========== Create Your Account ============");
       System.out.println("------------------------------------------");

       System.out.print("Enter  Your Full Name: ");
       String fullName = input.nextLine();
       account.setFullName(fullName);

       System.out.print("Enter Your BVN: ");
       String bvn = input.nextLine();

       while (!account.validateBvn(bvn)) {
       System.out.println("Invalid BVN. BVN must not be less or higher than 11 digits.");
       System.out.print("Re Enter Your BVN: ");
       bvn = input.nextLine();
          }

       account.setBvn(bvn);

       System.out.print("Set-up a 4-digit PIN: ");
       String pin = input.nextLine();

       while (!account.validatePin(pin)) {
       System.out.println("Invalid PIN. PIN should not be less or higher than 4 digits.");
       System.out.print("Re enter your PIN: ");
       pin = input.nextLine();
         }

       account.setPin(pin);

       System.out.println("\nAccount Created Successfully");
       System.out.println("================================");
       System.out.println("Full Name      : " + account.getFullName());
       System.out.println("Account Number : " + account.getAccountNumber());
       System.out.println("BVN            : " + account.getBvn());
       System.out.println("PIN            : " + account.getPin());
       System.out.println("Balance        : " + account.getBalance());
       System.out.println("Status         : " + account.getActive());

        break;

          case 2:

       System.out.println("========== Deposit Money ==========");
       System.out.println("--------------------------------------");

       System.out.print("Enter your Account Number: ");
       String accountNumber = input.nextLine();

       while (!account.validateAccountNumber(accountNumber)) {
       System.out.println("Invalid Account Number. Account Number must be exactly 10 digits.");
       System.out.print("Re enter your Account Number: ");
       accountNumber = input.nextLine();
         }

       while (!account.verifyAccountNumber(accountNumber)) {
       System.out.println("Account number not found.");
       System.out.print("Re enter your Account Number: ");
       accountNumber = input.nextLine();
        }

      System.out.print("Enter your PIN: ");
      pin = input.nextLine();

      while (!account.validatePin(pin)) {
      System.out.println("Invalid PIN. PIN must be exactly 4 digits.");
      System.out.print("Re enter your PIN: ");
      pin = input.nextLine();
        }

      while (!account.verifyPin(pin)) {
      System.out.println("Incorrect PIN.");
      System.out.print("Enter your PIN again: ");
      pin = input.nextLine();
        }

      System.out.print("Enter amount: ");
      double amount = input.nextDouble();

      while (!account.validateAmount(amount)) {
      System.out.println("Amount must be higher than 0.");
      System.out.print("Enter amount again: ");
      amount = input.nextDouble();
        }

       input.nextLine();

       account.deposit(amount);


       System.out.println("\nMoney Deposited Successfully");
       System.out.println("================================");
       System.out.println("Full Name   : " + account.getFullName());
       System.out.println("Balance     : " + account.getBalance());
       System.out.println("Status      : " + account.getActive());

         break;


          case 3:

       System.out.println("========== Transfer ==========");
       System.out.println("---------------------------------");

       System.out.print("Enter your Account Number: ");
       accountNumber = input.nextLine();

       while (!account.validateAccountNumber(accountNumber)) {
       System.out.println("Invalid Account Number. Account Number must be exactly 10 digits.");
       System.out.print("Re enter your Account Number: ");
       accountNumber = input.nextLine();
           }

       while (!account.verifyAccountNumber(accountNumber)) {
       System.out.println("Account number not found.");
       System.out.print("Re enter your Account Number: ");
       accountNumber = input.nextLine();
         }

      System.out.print("Enter The Receiver's Account Number: ");
      String receiverAccount = input.nextLine();

      while (!account.validateAccountNumber(receiverAccount)) {
      System.out.println("Invalid Account Number. Account Number must be exactly 10 digits.");
      System.out.print("Re enter Receiver Account Number: ");
      receiverAccount = input.nextLine();
        }

     System.out.print("Enter amount: ");
     amount = input.nextDouble();

    while (!account.validateAmount(amount)) {
    System.out.println("Amount must be higher than 0.");
    System.out.print("Enter amount again: ");
     amount = input.nextDouble();
       }

    input.nextLine();

    System.out.print("Enter your PIN: ");
    pin = input.nextLine();

    while (!account.validatePin(pin)) {
    System.out.println("Invalid PIN. PIN must be exactly 4 digits.");
    System.out.print("Re enter your PIN: ");
    pin = input.nextLine();
       }

    while (!account.verifyPin(pin)) {
    System.out.println("Incorrect PIN.");
    System.out.print("Enter your PIN again: ");
    pin = input.nextLine();
      }

    account.transfer(amount);

    break;

	
         case 4:

     System.out.println("========== Withdrawal ==========");
     System.out.println("---------------------------------");


    System.out.print("Enter your Account Number: ");
    accountNumber = input.nextLine();

    while (!account.validateAccountNumber(accountNumber)) {
    System.out.println("Invalid Account Number. Account Number must be exactly 10 digits.");
    System.out.print("Re enter your Account Number: ");
    accountNumber = input.nextLine();
       }

    while (!account.verifyAccountNumber(accountNumber)) {
    System.out.println("Account number not found.");
    System.out.print("Re enter your Account Number: ");
    accountNumber = input.nextLine();
      }

    System.out.print("Enter your PIN: ");
    pin = input.nextLine();

    while (!account.validatePin(pin)) {
    System.out.println("Invalid PIN. PIN must be exactly 4 digits.");
    System.out.print("Re enter your PIN: ");
    pin = input.nextLine();
      }

    while (!account.verifyPin(pin)) {
    System.out.println("Incorrect PIN.");
    System.out.print("Enter your PIN again: ");
    pin = input.nextLine();
       }

    System.out.print("Enter amount: ");
    amount = input.nextDouble();

    while (!account.validateAmount(amount)) {
    System.out.println("Amount must be higher than 0.");
    System.out.print("Enter amount again: ");
    amount = input.nextDouble();
      }

    input.nextLine();

    account.withdraw(amount);

    break;
     


         case 5:

    System.out.println("========== Change Pin ==========");
    System.out.println("---------------------------------");

    
    System.out.print("Enter your Account Number: ");
    accountNumber = input.nextLine();

    while (!account.validateAccountNumber(accountNumber)) {
    System.out.println("Invalid Account Number. Account Number must be exactly 10 digits.");
    System.out.print("Re enter your Account Number: ");
    accountNumber = input.nextLine();
       }

    while (!account.verifyAccountNumber(accountNumber)) {
    System.out.println("Account number not found.");
    System.out.print("Re enter your Account Number: ");
    accountNumber = input.nextLine();
      }

    System.out.print("Enter your PIN: ");
    pin = input.nextLine();

    while (!account.validatePin(pin)) {
    System.out.println("Invalid PIN. PIN must be exactly 4 digits.");
    System.out.print("Re enter your PIN: ");
    pin = input.nextLine();
      }

    while (!account.verifyPin(pin)) {
    System.out.println("Incorrect PIN.");
    System.out.print("Enter your PIN again: ");
    pin = input.nextLine();
      }

    System.out.print("Enter Your New PIN: ");
    String newPin = input.nextLine();

    while (!account.validatePin(newPin)) {
    System.out.println("Invalid PIN. PIN must be exactly 4 digits.");
    System.out.print("Re enter your new PIN: ");
    newPin = input.nextLine();
      }

    account.changePin(newPin);

    break;


        case 6:

     System.out.println("========== Deactivate Account ==========");
     System.out.println("-----------------------------------------");


    System.out.print("Enter your Account Number: ");
    accountNumber = input.nextLine();

    while (!account.validateAccountNumber(accountNumber)) {
    System.out.println("Invalid Account Number. Account Number must be exactly 10 digits.");
    System.out.print("Re enter your Account Number: ");
    accountNumber = input.nextLine();
      }

    while (!account.verifyAccountNumber(accountNumber)) {
    System.out.println("Account number not found.");
    System.out.print("Re enter your Account Number: ");
    accountNumber = input.nextLine();
      }

    System.out.print("Enter your PIN: ");
    pin = input.nextLine();

    while (!account.validatePin(pin)) {
    System.out.println("Invalid PIN. PIN must be exactly 4 digits.");
    System.out.print("Re enter your PIN: ");
    pin = input.nextLine();
      }

    while (!account.verifyPin(pin)) {
    System.out.println("Incorrect PIN.");
    System.out.print("Enter your PIN again: ");
    pin = input.nextLine();
      }

    System.out.print("Do you want to deactivate your account? (yes/no): ");
    String deactivate = input.nextLine();

    if (deactivate.equalsIgnoreCase("yes")) {
        account.deactivate();
     } else {
        System.out.println("Account deactivation cancelled.");
    }

    break;

   

   }


       
       System.out.print("\nDo you want to continue? (yes/no): ");
       answer = input.nextLine();

       if (answer.equalsIgnoreCase("no")) {
       System.out.println("\nThanks for banking with us.");

            }
      }


 
   }

}