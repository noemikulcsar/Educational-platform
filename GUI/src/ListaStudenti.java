import java.awt.*;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Vector;
import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.sql.DriverManager;


public class ListaStudenti extends JFrame {
    private JTable table;
    private JScrollPane scrollPane;

    public ListaStudenti() {
        setTitle("Lista Studentilor");
        setSize(800, 400);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        initUI();

        // Afișează toți studenții la încărcarea ferestrei
        afiseazaStudenti();
    }

    private void initUI() {
        // Creează un model de tabel
        DefaultTableModel model = new DefaultTableModel();

        // Adaugă coloanele în model
        model.addColumn("ID");
        model.addColumn("Nume");
        model.addColumn("Prenume");
        model.addColumn("Adresa");
        model.addColumn("Telefon");
        model.addColumn("Email");
        model.addColumn("An Studiu");
        model.addColumn("Ore Sustinute");

        // Creează un tabel cu modelul de mai sus
        table = new JTable(model);

        // Adaugă un panou de derulare pentru tabel
        scrollPane = new JScrollPane(table);

        // Adaugă panoul de derulare în cadrul ferestrei
        getContentPane().add(scrollPane, BorderLayout.CENTER);
    }

    private void afiseazaStudenti() {
        try {

            Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/platformaStudiu", "root", "rootroot");


            String query = "CALL VizualizareStudenti()";
            PreparedStatement statement = conn.prepareStatement(query);


            ResultSet resultSet = statement.executeQuery();


            while (resultSet.next()) {
                Vector<Object> row = new Vector<>();
                row.add(resultSet.getInt("ID_Student"));
                row.add(resultSet.getString("Nume_Student"));
                row.add(resultSet.getString("Prenume_Student"));
                row.add(resultSet.getString("Adresa_Student"));
                row.add(resultSet.getString("Telefon_Student"));
                row.add(resultSet.getString("Email_Student"));
                row.add(resultSet.getInt("AnStudiu"));
                row.add(resultSet.getInt("OreSustinute_Student"));


                ((DefaultTableModel) table.getModel()).addRow(row);
            }

            // Închide resursele
            resultSet.close();
            statement.close();
            conn.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            ListaStudenti studentiUI = new ListaStudenti();
            studentiUI.setVisible(true);
        });
    }
}
