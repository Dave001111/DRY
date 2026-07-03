import java.security.SecureRandom;
public class Account {

    private String fullName;
    private String accountNumber;
    private String bvn;
    private String pin;
    private double balance;
    private boolean active = false;

    public Account() {
    this.balance = 0.0;
    this.accountNumber = generateAccountNumber();
  }

  private String generateAccountNumber() {
    SecureRandom randomNumbers = new SecureRandom();
    String accountNumber = "";

    for (int count = 0; count < 10; count++) {
        accountNumber += randomNumbers.nextInt(10);
    }

    return accountNumber;
  }
     

  public void setFullName(String fullName) {
     this.fullName = fullName;
  }

  public void setBvn(String bvn) {
     this.bvn = bvn;
  }

   public void setPin(String pin) {
     this.pin = pin;
  }
   
   public String getFullName() {
     return fullName;
   }

   public String getAccountNumber() {
      return accountNumber;
   }
  
   public String getPin() {
     return pin;
   }

  public String getBvn() {
    return bvn;
  }

  public double getBalance() {
     return balance;
  }


   public String getActive() {
    if (active) {
     return "Active";
    } else {
      return "Not Active";
     }
   }

  public void deposit(double amount) {
    if (amount > 0) {
       balance += amount;
       active = true;
   }
}

 public void transfer(double amount) {
   if(amount > 0 && amount <= balance) {
      balance -= amount;
      System.out.println("\nTransfer successful");
      System.out.println("Balance: " + balance);
        }
     else {
  System.out.println("Insufficient Balance.");
   }
}

 public void withdraw(double amount) {
  if (amount > 0 && amount <= balance) {
      balance -= amount;
    System.out.println("\nWithdrawal Successful");
    System.out.println("Your Current Balance is: " + balance);
     } else {
    System.out.println("Insufficient Balance.");
    }
}

public void changePin(String newPin) {
    pin = newPin;
    System.out.println("\nPIN changed successfully!");
  }

 public void deactivate() {
    active = false;
    System.out.println("Account deactivated successfully.");
}

  



 
     




}