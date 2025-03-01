import javax.swing.*;
import java.awt.*;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Vector;
import javax.swing.table.DefaultTableModel;
import java.sql.DriverManager;

public class ListaCursuri extends JFrame {
    private JTable table;
    private JScrollPane scrollPane;

    public ListaCursuri() {
        setTitle("Lista Cursurilor");
        setSize(800, 400);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        initUI();

        // Afișează toate cursurile la încărcarea ferestrei
        afiseazaCursuri();
    }

    private void initUI() {
        // Creează un model de tabel
        DefaultTableModel model = new DefaultTableModel();

        // Adaugă coloanele în model
        model.addColumn("ID");
        model.addColumn("Nume");
        model.addColumn("Descriere");
        model.addColumn("Max Studenti");

        // Creează un tabel cu modelul de mai sus
        table = new JTable(model);

        // Adaugă un panou de derulare pentru tabel
        scrollPane = new JScrollPane(table);

        // Adaugă panoul de derulare în cadrul ferestrei
        getContentPane().add(scrollPane, BorderLayout.CENTER);
    }

    private void afiseazaCursuri() {
        try {
            Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/platformaStudiu", "root", "rootroot");
            String query = "CALL VizualizareCursuri()";
            PreparedStatement statement = conn.prepareStatement(query);
            ResultSet resultSet = statement.executeQuery();

            while (resultSet.next()) {
                Vector<Object> row = new Vector<>();
                row.add(resultSet.getInt("ID_Curs"));
                row.add(resultSet.getString("Nume"));
                row.add(resultSet.getString("Descriere"));
                row.add(resultSet.getInt("MaxStudenti"));

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
            ListaCursuri cursuriUI = new ListaCursuri();
            cursuriUI.setVisible(true);
        });
    }
}
