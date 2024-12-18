import javax.swing.JFrame;
import javax.swing.JOptionPane;

public class App {
    public static void main(String[] args) {
        while(true) {
            String[] menuOptions = {"Display Car Loan Scheme", "Calculate Car Loan Installment", "Generate Summary Report", "Exit"};
            String selectedOption = (String) JOptionPane.showInputDialog(
                    null,
                    "Select an option:",
                    "Menu",
                    JOptionPane.QUESTION_MESSAGE,
                    null,
                    menuOptions,
                    menuOptions[0]
            );

            if(selectedOption == menuOptions[0]) {
                JFrame mainFrame = new JFrame("Car Loan Scheme");
                mainFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
                Scheme getScheme = new Scheme();
                getScheme.myScheme(mainFrame);
            }

            else if(selectedOption == menuOptions[1]) {
            int loanTerm;
            do {
                String chooseTerm = JOptionPane.showInputDialog(null, "Please Enter Your Loan Term\n" + "Minimum: 3 Years\n" + "Maximum: 9 Years");
                loanTerm = Integer.parseInt(chooseTerm);
                if(loanTerm < 3 || loanTerm > 9) {
                    JOptionPane.showMessageDialog(null, "Please Enter Your Loan Term\n" + "Minimum: 3 Years\n" + "Maximum: 9 Years");
                }
            } 
            while(loanTerm < 3 || loanTerm > 9);
        
            Object[] options = {"Imported", "Local","Back"};
                int carType = JOptionPane.showOptionDialog(
                null,
                "Please Choose Your Car Type",
                "Custom Confirm Dialog",
                JOptionPane.YES_NO_OPTION,
                JOptionPane.QUESTION_MESSAGE,
                null,
                options,
                options[0]);
            
            String Amount = JOptionPane.showInputDialog(null, "Please Enter Your Loan Amount");
            double amount = Double.parseDouble(Amount);
            double rate = 0;
            if(carType == JOptionPane.YES_OPTION) {
                if(amount > 300000){
                    rate = 2.35;
                }
                else if(amount>100000 && amount<300000){
                    rate = 2.55;
                }
                else if(amount<100000){
                    rate = 2.75;
                }  
            } 
        
            else if (carType == JOptionPane.NO_OPTION) {
                JOptionPane.showMessageDialog(null, "Car Type Selected: Local");
                if(amount > 10000){
                    rate = 3;
                }
                else if(amount>50000 && amount<100000){
                    rate = 3.1;
                }
                else if(amount<100000){
                    rate = 3.2;
                }  
            }
            else {
                JOptionPane.showMessageDialog(null, "Going Back...");
            }
            Loan Loan = new Loan(carType, carType, amount, amount, rate, carType);
            Loan.setTerm(loanTerm);
            Loan.setCarType(carType);
            Loan.setAmount(amount);
            Loan.setRate(rate);
            
            JOptionPane.showMessageDialog(null,"Amount: RM " + Loan.getAmount() + "\nCar Type: " + Loan.getCarTypeAsString(carType) + "\nInterest Rate: " + rate + "%" 
            + "\nLoan Interest: RM" + Loan.loanInterest() + "\nLoan Amount: RM" + Loan.loanAmount() + "\nMonthly Installment: RM" + Loan.Installment());
        
            int choice = JOptionPane.showConfirmDialog(null,
                "Do you want to buy Insurance",
                "Question",
                JOptionPane.YES_NO_OPTION,
                JOptionPane.QUESTION_MESSAGE);
            if(choice == JOptionPane.YES_OPTION) {
                Loan.Installment();
                JOptionPane.showMessageDialog(null,"Amount: RM " + Loan.newAmount() + "\nCar Type: " + Loan.getCarTypeAsString(carType) + "\nInsurance(RM200 per year): RM" + Loan.Insurance() 
                + "\nInterest Rate: " + rate + "%" + "\nLoan Interest: RM" + Loan.NewloanInterest() + "\nLoan Amount: RM" + Loan.NewloanAmount() 
                + "\nMonthly Installment: RM" + Loan.newInstallment());
            }
            Loan.setChoice(choice);

            }
            else if(selectedOption == menuOptions[2]) {
                Summary.generateSummaryReport();
            }
            
            else {
                JOptionPane.showMessageDialog(null, "Exiting Program");
                break;
            }
        }
    }
}
