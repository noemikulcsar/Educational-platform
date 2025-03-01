import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;


public class PaginaLogare extends JFrame {
    private JTextField username;
    private JLabel title;
    private JPasswordField password;
    private JButton submit;
    private JButton signInButton;
    private FormularInregistrare formularInregistrare;


    public PaginaLogare() {
        setTitle("Sign in");
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        //setLayout(new BoxLayout(getContentPane(), BoxLayout.Y_AXIS));
        setLayout(new BorderLayout());
        Font titleFont = new Font("Arial", Font.PLAIN, 25);



        try {
            setContentPane(new JLabel(new ImageIcon(ImageIO.read(new File("/Users/oanarepede/Downloads/Images/markus.png")))));
        } catch (IOException e) {
            e.printStackTrace();
        }

        pack();
        setBounds(700, 140, 500, 620);

        Font font1 = new Font("Consolas", Font.ITALIC, 20);
        Font font2 = new Font("Consolas", Font.PLAIN, 27);

        JPanel mainPanel = new JPanel(new GridBagLayout());
        mainPanel.setOpaque(false);
        GridBagConstraints gbc = new GridBagConstraints();
        gbc.gridwidth = GridBagConstraints.REMAINDER;
        gbc.fill = GridBagConstraints.HORIZONTAL;
        gbc.insets = new Insets(5, 5, 5, 5);

        title = new JLabel("Sign in");
        title.setForeground(Color.darkGray);
        title.setBounds(190, 20, 200, 30);
        title.setFont(titleFont);
        add(title);


        username = new JTextField("username");
        username.setBounds(150, 100, 200, 30);
        username.setPreferredSize(new Dimension(300, 50));
        username.setFont(font1);
        username.setHorizontalAlignment(JTextField.CENTER);
        add(username);

        password = new JPasswordField("password");
        password.setBounds(150, 140, 200, 30);
        password.setPreferredSize(new Dimension(200, 30));
        password.setFont(font1);
        password.setHorizontalAlignment(JTextField.CENTER);
        add(password);

        submit = new JButton("SUBMIT");
        submit.setBackground(Color.BLACK);
        submit.setForeground(Color.BLACK);
        submit.setBounds(150, 200, 200, 30);
        submit.setFont(font1);
        submit.setHorizontalAlignment(JButton.CENTER);
        submit.setPreferredSize(new Dimension(300, 50));
        submit.setVerticalAlignment(JTextField.BOTTOM);
        submit.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String tipUtilizator = autentificare(username.getText(), new String(password.getPassword()));
                if (!tipUtilizator.isEmpty()) {
                    JOptionPane.showMessageDialog(null, "Logare reușită! Deschide 'Contul Meu'.");
                    afisareInterfataUtilizator(username.getText(), tipUtilizator);
                    setVisible(false);
                } else {
                    JOptionPane.showMessageDialog(null, "Logare eșuată. Verificați username-ul și parola.");
                }
            }
        });
        add(submit);

        signInButton = new JButton("SignIn");
        signInButton.setBounds(280, 500, 200, 30);
        signInButton.setFont(font1);
        signInButton.setBackground(Color.BLACK);
        signInButton.setForeground(Color.BLACK);
        signInButton.setHorizontalAlignment(JButton.CENTER);
        signInButton.setVerticalAlignment(JTextField.BOTTOM);
        signInButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (formularInregistrare == null) {
                    formularInregistrare = new FormularInregistrare(PaginaLogare.this);
                }
                // Setăm pagina de logare invizibilă
                setVisible(false);
                // Afișăm formularul de înregistrare
                formularInregistrare.setVisible(true);
            }
        });
        add(signInButton);
    }

    private void deschideFormularInregistrare() {
        // Deschide fereastra de înregistrare
        FormularInregistrare formularInregistrare = new FormularInregistrare(this);
        formularInregistrare.setVisible(true);
    }

    private void afisareInterfataUtilizator(String username, String tipUtilizator) {
        switch (tipUtilizator) {
            case "studenti":
                AfisareDateStudent afisareDateStudent = new AfisareDateStudent(username);
                afisareDateStudent.setVisible(true);
                break;
            case "profesori":
                AfisareDateProfesor afisareDateProfesor = new AfisareDateProfesor(username);
                afisareDateProfesor.setVisible(true);
                break;
            case "administratori":
                AfisareDateAdministrator afisareDateAdministrator = new AfisareDateAdministrator(username);
                afisareDateAdministrator.setVisible(true);
                break;
            case "superadministratori":
                AfisareDateSuperAdministrator afisareDateSuperAdministrator = new AfisareDateSuperAdministrator(username);
                afisareDateSuperAdministrator.setVisible(true);
                break;
        }
    }

    private String autentificare(String username, String password) {
        try {
            Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/platformaStudiu", "root", "rootroot");

            // Alege tipul de utilizator în funcție de tabelul în care caută
            String[] tipuriUtilizatori = {"studenti", "profesori", "administratori", "superadministratori"};
            for (String tip : tipuriUtilizatori) {
                String query = "SELECT * FROM " + tip + " WHERE UserName = ? AND Parola = ?";
                PreparedStatement statement = conn.prepareStatement(query);
                statement.setString(1, username);
                statement.setString(2, password);

                ResultSet resultSet = statement.executeQuery();
                if (resultSet.next()) {
                    resultSet.close();
                    statement.close();
                    conn.close();
                    return tip;
                }

                resultSet.close();
                statement.close();
            }

            conn.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return "";
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            PaginaLogare logareUI = new PaginaLogare();
            logareUI.setVisible(true);
        });
    }
}

