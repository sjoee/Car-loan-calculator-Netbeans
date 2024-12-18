import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.util.ArrayList;

public class Summary {
    static ArrayList<Loan> transactions = new ArrayList<>();

    public static void recordTransaction(Loan transaction) {
        transactions.add(transaction);
    }

    public static void generateSummaryReport() {
        DefaultTableModel model = new DefaultTableModel();
        model.addColumn("No. Transaction(s)");
        model.addColumn("Loan Term (Years)");
        model.addColumn("Car Type");
        model.addColumn("Loan Amount (RM)");
        model.addColumn("Insured");

        int totalTransactions = transactions.size();
        double totalLoanAmount = 0.0;
        for (Loan transaction : transactions) {
            int carType = transaction.getCarType(); // retrieve the car type of each Loan object
            model.addRow(new Object[]{totalTransactions, transaction.getTerm(), transaction.getCarTypeAsString(carType), transaction.getAmount(), transaction.getChoiceAsString()});
            totalLoanAmount += transaction.getAmount();
        }

        model.addRow(new Object[]{"Total: " + totalTransactions, "-", "-", totalLoanAmount, "-"});

        JTable table = new JTable(model);
        JScrollPane scrollPane = new JScrollPane(table);
        JOptionPane.showMessageDialog(null, scrollPane, "Summary Report", JOptionPane.PLAIN_MESSAGE);
    }

    public static ArrayList<Loan> getTransactions() {
        return transactions;
    }

    public static void setTransactions(ArrayList<Loan> transactions) {
        Summary.transactions = transactions;
    }
}
