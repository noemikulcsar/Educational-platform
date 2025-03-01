import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;


public class FormularInregistrare extends JDialog {
    private JTextField cnpField;
    private JTextField numeField;
    private JTextField prenumeField;
    private JTextField adresaField;
    private JTextField telefonField;
    private JTextField emailField;
    private JTextField contIbanField;
    private JTextField numarContractField;
    private JTextField anStudiuField;
    private JTextField oreSustinuteField;
    private JTextField usernameField;
    private JPasswordField passwordField;
    private JButton registerButton;

    public FormularInregistrare(JFrame parinte) {
        super(parinte, "Formular Înregistrare", true);
        setLayout(new BorderLayout());
        pack();
        JPanel formPanel = new JPanel(new GridLayout(13, 2));
        formPanel.setOpaque(false);
        formPanel.setSize(500, 620);

        // Adaugăm etichete și câmpurile de text
        formPanel.add(new JLabel("CNP:"));
        cnpField = new JTextField();
        formPanel.add(cnpField);

        formPanel.add(new JLabel("Nume:"));
        numeField = new JTextField();
        formPanel.add(numeField);

        formPanel.add(new JLabel("Prenume:"));
        prenumeField = new JTextField();
        formPanel.add(prenumeField);

        formPanel.add(new JLabel("Adresa:"));
        adresaField = new JTextField();
        formPanel.add(adresaField);

        formPanel.add(new JLabel("Telefon:"));
        telefonField = new JTextField();
        formPanel.add(telefonField);

        formPanel.add(new JLabel("Email:"));
        emailField = new JTextField();
        formPanel.add(emailField);

        formPanel.add(new JLabel("Cont IBAN:"));
        contIbanField = new JTextField();
        formPanel.add(contIbanField);

        formPanel.add(new JLabel("Numar Contract:"));
        numarContractField = new JTextField();
        formPanel.add(numarContractField);

        formPanel.add(new JLabel("An Studiu:"));
        anStudiuField = new JTextField();
        formPanel.add(anStudiuField);

        formPanel.add(new JLabel("Ore Sustinute:"));
        oreSustinuteField = new JTextField();
        formPanel.add(oreSustinuteField);

        formPanel.add(new JLabel("Username:"));
        usernameField = new JTextField();
        formPanel.add(usernameField);

        formPanel.add(new JLabel("Parola:"));
        passwordField = new JPasswordField();
        formPanel.add(passwordField);

        // Adăugăm butonul de înregistrare
        registerButton = new JButton("Înregistrare");
        registerButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                AdaugareStudent();
                dispose();
            }
        });
        formPanel.add(registerButton);

        JButton backButton = new JButton("Back");
        backButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                dispose();
                PaginaLogare logareUI = new PaginaLogare();
                logareUI.setVisible(true);
            }
        });
        formPanel.add(backButton);
        add(formPanel, BorderLayout.CENTER);
        pack();
        setLocationRelativeTo(parinte);
    }

    private void AdaugareStudent() {
        try {
            Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/platformaStudiu", "root", "rootroot");

            String procedura = "{CALL AdaugaStudenti(?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)}";

            try (PreparedStatement stmt = conn.prepareCall(procedura)) {
                stmt.setString(1, cnpField.getText());
                stmt.setString(2, numeField.getText());
                stmt.setString(3, prenumeField.getText());
                stmt.setString(4, adresaField.getText());
                stmt.setString(5, telefonField.getText());
                stmt.setString(6, emailField.getText());
                stmt.setString(7, contIbanField.getText());
                stmt.setInt(8, Integer.parseInt(numarContractField.getText()));
                stmt.setInt(9, Integer.parseInt(anStudiuField.getText()));
                stmt.setInt(10, Integer.parseInt(oreSustinuteField.getText()));
                stmt.setString(11, usernameField.getText());
                stmt.setString(12, new String(passwordField.getPassword()));
                stmt.executeUpdate();
            }
            conn.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            PaginaLogare logareUI = new PaginaLogare();
            logareUI.setVisible(true);
        });
    }
}
