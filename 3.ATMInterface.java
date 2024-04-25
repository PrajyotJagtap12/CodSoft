import java.util.Scanner;

class BankAccount{
    private double balance;

    public BankAccount(double intialBalance){
        balance=intialBalance;

    }
    public double getBalance(){
        return balance;

    }
    public void deposit(double amount){
        balance +=amount;

    }
    public boolean withdraw(double amount){
        if (balance >= amount) {
            balance -= amount;
            return true;
        }else{
            System.out.println("Insufficient funds");
            return false;
        }
    }
}

class ATM {
    private BankAccount account;
    public ATM(BankAccount account){
        this.account=account;
    }
    public void displayMenu(){
        System.out.println("Welcome to the ATM!");
        System.out.println("1 . Check balance");
        System.out.println("2. Deposite");
        System.out.println("3. Withdraw");
        System.out.println("4. Exit");
    }

    public void checkBalance() {
        System.out.println("Your balance is : " + account.getBalance() );
    }

    public void deposit(double amount) {
        account.deposit(amount);
        System.out.println("Deposit successful.");
    }

    public void withdraw(double amount ) {
        if (account.withdraw(amount)){
            System.out.println("Withdrawal successful.");
        }
    }
}

public class ATMInterface {
    public static void main (String[] args ) {
        BankAccount userAccount = new BankAccount(1000);
        ATM atm = new ATM(userAccount);
        Scanner scanner = new Scanner(System.in);
        int choice;
        do{
            atm.displayMenu();
            System.out.println("Enter your choice:");
            choice = scanner.nextInt();
            switch (choice ) {
                case 1 :
                    atm.checkBalance();
                    break;
                case 2 :
                    System.out.print("Enter deposit amount:");
                    double depositAmount = scanner.nextDouble();
                    atm.deposit(depositAmount);
                    break;
                case 3 :
                    System.out.print("Enter withdrawal amount:");
                    double withdrawAmount = scanner.nextDouble();
                    atm.withdraw(withdrawAmount);
                    break;
                case 4 :
                    System.out.println("Thank you for using the ATM. Visit Again!! ");
                    break;
                default:
                    System.out.println("Invalid choice . Please try again .  ");
            }
        } while (choice != 4 );
        scanner.close();
    }
}