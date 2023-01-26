import javax.swing.*;
import java.util.*;

/**
 * A class to test the BankAccount class.
 * @author jacob5257
 * @version 1.0
 * @since 2023-01-26
 * @see BankAccount
 */
public class BankAccountTest {
    /**
     * The main method.
     * @param args The command line arguments (not used).
     */
    public static void main(String[] args) {
        // Creates new text fields for input.
        JTextField nameInput = new JTextField(5);
        JTextField startBalInput = new JTextField(5);
        JTextField intRateInput = new JTextField(5);
        JTextField overFeeInput = new JTextField(5);
        // Creates a panel and adds the text fields to it.
        JPanel myPanel = new JPanel();
        myPanel.add(new JLabel("Name: "));
        myPanel.add(nameInput);
        myPanel.add(new JLabel("Starting balance: $"));
        myPanel.add(startBalInput);
        myPanel.add(new JLabel("Interest Rate: "));
        myPanel.add(intRateInput);
        myPanel.add(new JLabel("% Overdraft Fee: $"));
        myPanel.add(overFeeInput);
        int result = JOptionPane.showConfirmDialog(null, myPanel, "Bank account creation tool.", JOptionPane.OK_CANCEL_OPTION);
        // If the user clicks OK, the program will continue. If the user clicks cancel, the program will exit.
        if (result == JOptionPane.OK_OPTION) {
            try {
                // Creates a new BankAccount object with the user's input.
                BankAccount account = new BankAccount(nameInput.getText(), Integer.parseInt(startBalInput.getText()), Double.parseDouble(intRateInput.getText()), Double.parseDouble(overFeeInput.getText()));
                // Creates a loop that will continue until the user clicks cancel.
                while (true) {
                    // Creates a panel with the user's account information and options.
                    Object[] options = {"Deposit", "Withdraw", "Add Interest"};
                    JPanel panel = new JPanel();
                    String balance = String.format("%.2f", account.getBalance());
                    double formattedBal = Double.parseDouble(balance);
                    panel.add(new JLabel("<html>Welcome " + account.getName() + "!<br>You have $" + formattedBal + " in your account.<br>What would you like to do?<br>Amount:</html>"));
                    JTextField input = new JTextField(5);
                    panel.add(input);
                    int selection = ( JOptionPane.showOptionDialog(null, panel, "Select an option.",
                            JOptionPane.YES_NO_CANCEL_OPTION, JOptionPane.PLAIN_MESSAGE, null, options, null));
            
                    if (Objects.equals(selection, 0)) account.deposit(Integer.parseInt(input.getText()));
                    else if (Objects.equals(selection, 1)) account.withdraw(Integer.parseInt(input.getText()));
                    else if (Objects.equals(selection, 2)) account.addInterest();
                    else {
                        JOptionPane.showMessageDialog(null, "Cancelled.");
                        return;
                    }
                }
            }
            catch (Exception e) {
                e.printStackTrace();
                JOptionPane.showMessageDialog(null, "Invalid input.");
                return;
            }
        }
        else {
            JOptionPane.showMessageDialog(null, "Cancelled.");
            return;
        }
    }
}
