package db.javaschool.session_3.Problems;

public class Main {
    public static void main(String[] args) {
        Account account = new Account();
        account.deposit(100);
        try {
            account.withdraw(80);
        } catch (Account.NotEnoughMoneyException e) {
            System.out.println(e.getMessage());
        }
        try {
            account.withdraw(50);
        } catch (Account.NotEnoughMoneyException e) {
            System.out.println(e.getMessage());
        }
        try {
            account.linkToNationalId(123);
        } catch (Account.InvalidNationalIdException e) {
            System.out.println(e.getMessage());
        }
        try {
            account.linkToNationalId(12345678);
        } catch (Account.InvalidNationalIdException e) {
            System.out.println(e.getMessage());
        }
    }
}
