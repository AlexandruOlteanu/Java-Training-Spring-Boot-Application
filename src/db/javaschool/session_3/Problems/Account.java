package db.javaschool.session_3.Problems;

public class Account {

    private String accountNo;
    private double amount;
    private int nationalId;

    static class NotEnoughMoneyException extends Exception {
        NotEnoughMoneyException(String message) {
            super(message);
        }
    }

    static class InvalidNationalIdException extends Exception {

        InvalidNationalIdException (String message){
            super(message);
        }

    }

    public Account() {

    }

    public void deposit(int amount) {
        this.amount += amount;
    }

    public void withdraw(int amount) throws NotEnoughMoneyException {
        if (this.amount - amount < 0) {
            throw new NotEnoughMoneyException("Not enough money :(");
        }
        this.amount = this.amount - amount;

    }


    public void linkToNationalId( int nationalId) throws InvalidNationalIdException{
        if( nationalId < 10000000){
            throw new InvalidNationalIdException("Invalid nationalId");
        }

        this.nationalId = nationalId;
    }

}
