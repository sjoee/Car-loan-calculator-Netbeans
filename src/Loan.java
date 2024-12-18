import javax.swing.JOptionPane;

public class Loan {
    private int loanTerm;
    private int carType;
    private double amount;
    private double installment;
    private double rate;
    private int choice;

    public Loan(int loanTerm, int carType, double amount, double installment, double rate, int choice) {
        this.loanTerm = loanTerm;
        this.carType = carType;
        this.amount = amount;
        this.installment = installment;
        this.rate = rate;
        this.choice = choice;
        Summary.recordTransaction(this);
    }

    public String carTypeToString() {
        return getCarTypeAsString(carType);
    }

    //setter
    public void setTerm(int loanTerm) {
        this.loanTerm = loanTerm;
    }
    //getter
    public int getTerm() {
        return loanTerm;
    }
    
    public void setCarType(int carType) {
        this.carType = carType;
    }
    
    public int getCarType() {
        return this.carType;
    }
    
    public void setAmount(double amount) {
        this.amount = amount;
    }

    public double getAmount() {
        return amount;
    }

    public void setRate(double rate) {
        this.rate = rate/100;
    }

    public double getRate() {
        return rate;
    }

    public double loanInterest() {
        double loanInterest = getAmount() * getTerm() * getRate();
        return loanInterest;
    }

    public double loanAmount() {
        double loanAmount = getAmount() + loanInterest();
        return loanAmount;
    }

    public double Installment() {
        installment = loanAmount()/(5 * 12);
        return installment;
    }

    //Insurance
    public void setChoice(int choice) {
        this.choice = choice;
    }

    public double getChoice() {
        return choice;
    }

    public double Insurance() {
        double insurance = getTerm() * 200;
        return insurance;
    }

    public double newAmount() {
        double newAmount = getAmount() + Insurance();
        return newAmount;
    }

    public double NewloanInterest() {
        double loanInterest = newAmount() * getTerm() * getRate();
        return loanInterest;
    }

    public double NewloanAmount() {
        double loanAmount = newAmount() + NewloanInterest();
        return loanAmount;
    }

    public double newInstallment() {
        installment = NewloanAmount()/(5 * 12);
        return installment;
    }
    
    // Method to convert carType index to string
    public String getCarTypeAsString(int carType) {
        switch (carType) {
            case 0:
                return "Imported";
            case 1:
                return "Local";
            default:
                return "Unknown";
        }
    }

    // Override toString() method to provide a custom string representation
    @Override
    public String toString() {
        return "Loan{loanTerm='" + loanTerm + "', carType='" + getCarTypeAsString(carType) + "', amount=" + amount + ", rate=" + rate + ", choice=" + choice + "}";
    }

    // Method to convert insurance choice to string
    public String getChoiceAsString() {
        return choice == JOptionPane.YES_OPTION ? "Yes" : "No";
    }

}   