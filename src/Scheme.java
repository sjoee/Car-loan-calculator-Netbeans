import javax.swing.*;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.JTableHeader;
import java.awt.*;

public class Scheme {
    public void myScheme(JFrame parentFrame) {
        JDialog dialog = new JDialog(parentFrame, "Car Loan Scheme", true);

        String[][] data = {
                {"Imported", ">300,000", "2.35%"},
                {"", "100,000-300,000", "2.55%"},
                {"", "<100,000", "2.75%"},
                {"Local ", ">100,000", "3.0%"},
                {"", "50,000-100,000", "3.1%"},
                {"", "<50,000", "3.2%"},
        };

        String[] columnNames = {"Car Type", "Loan Amount(RM)", "Interest Rate(%)"};

        JTable j = new JTable(data, columnNames);
        Font font = new Font("Verdana", Font.TRUETYPE_FONT, 15);
        j.setFont(font);
        j.setRowHeight(30);
        j.setBackground(new Color(242, 242, 242));
        j.setForeground(new Color(96, 96, 96));

        JTableHeader jHeader = j.getTableHeader();
        jHeader.setBackground(new Color(51, 153, 255));
        jHeader.setForeground(new Color(255, 255, 255));
        Font headerFont = new Font("Italic & BOLD ", Font.TRUETYPE_FONT | Font.BOLD, 18);
        jHeader.setFont(headerFont);

        DefaultTableCellRenderer centerRenderer = new DefaultTableCellRenderer();
        centerRenderer.setHorizontalAlignment(JLabel.CENTER);
        j.getColumnModel().getColumn(0).setCellRenderer(centerRenderer);
        j.getColumnModel().getColumn(1).setCellRenderer(centerRenderer);
        j.getColumnModel().getColumn(2).setCellRenderer(centerRenderer);

        JScrollPane sp = new JScrollPane(j);
        dialog.add(sp);

        dialog.setSize(500, 260);
        dialog.setLocationRelativeTo(parentFrame);
        dialog.setVisible(true);
    }
}
