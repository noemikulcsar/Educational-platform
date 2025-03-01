import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.*;
import java.util.Vector;

public class AfisareDateProfesor extends JFrame {
    private String username;
    private String numele;
    private String prenumele;
    private String adresa;
    private String Telefon;
    private String email;
    private String IBAN;
    private String nrContract;
    private String cursPredat;
    private int idProf;
    private String idCurs;
    private int ID;
    private int idStud;

    public AfisareDateProfesor(String username) {
        this.username=username;
        this.numele=numele;
        this.ID=ID;
        this.idStud=idStud;
        setTitle("Main Page");
        setSize(800, 600);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        // Create components
        JTabbedPane tabbedPane = new JTabbedPane();

        // First tab - Date Cont
        JPanel dateContPanel = new JPanel();
        DefaultTableModel model = new DefaultTableModel(new Object[]{"", ""}, 0);
        JTable dateContTable = new JTable(model);
        dateContTable.setPreferredSize(new Dimension(450, 450));

        try {
            try (Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/platformaStudiu", "root", "rootroot")) {
                String query = "CALL CautaProfesorDupaUserName(?)";
                try (PreparedStatement statement = conn.prepareStatement(query)) {
                    statement.setString(1, username);

                    try (ResultSet resultSet = statement.executeQuery()) {
                        if (resultSet.next()) {
                            Vector<Object> row = new Vector<>();
                            idProf=Integer.parseInt(resultSet.getString("ID_Profesor"));
                            model.addRow(new Object[]{"CNP", resultSet.getString("CNP_Profesor")});
                            model.addRow(new Object[]{"Nume", resultSet.getString("Nume_Profesor")});
                            model.addRow(new Object[]{"Prenume", resultSet.getString("Prenume_Profesor")});
                            numele=resultSet.getString("Prenume_Profesor");
                            idCurs=(resultSet.getString("CursuriPredate"));
                            model.addRow(new Object[]{"Adresa", resultSet.getString("Adresa_Profesor")});
                            model.addRow(new Object[]{"Telefon", resultSet.getString("Telefon_Profesor")});
                            model.addRow(new Object[]{"Email", resultSet.getString("Email_Profesor")});
                            model.addRow(new Object[]{"IBAN", resultSet.getString("ContIBAN_Profesor")});
                            model.addRow(new Object[]{"NumarContract", resultSet.getString("NumarContract_Profesor")});
                            model.addRow(new Object[]{"Cursuri", resultSet.getString("CursuriPredate")});
                            model.addRow(new Object[]{"Departament", resultSet.getString("Departament")});
                            model.addRow(new Object[]{"MinOre", resultSet.getString("MinOre")});
                            model.addRow(new Object[]{"MaxOre", resultSet.getString("MaxOre")});
                            model.addRow(new Object[]{"UserName", resultSet.getString("UserName")});
                            ((DefaultTableModel) dateContTable.getModel()).addRow(row);
                        } else {
                            JOptionPane.showMessageDialog(null, "Nu s-au găsit date personale.");
                        }
                    }
                }
                String query1 = "CALL CautaCursDupaNume(?)";
                try (PreparedStatement statement1 = conn.prepareStatement(query1)) {
                    statement1.setString(1, username);

                    try (ResultSet resultSet = statement1.executeQuery()) {
                        statement1.setString(1, idCurs);
                        if (resultSet.next()) {
                            ID=resultSet.getInt("ID_Curs");
                        }
                    }
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        dateContPanel.add(dateContTable);
        tabbedPane.addTab("Date Cont", dateContPanel);

        // Second tab - Cursuri
            JPanel cursuriPanel = new JPanel();
            cursuriPanel.setLayout(null);

            JLabel seminarLabel = new JLabel("SEMINAR");
            seminarLabel.setBounds(184, 180, 100, 50);
            JLabel laboratorLabel = new JLabel("LABORATOR");
            laboratorLabel.setBounds(184, 250, 100, 50);
            JLabel cursLabel = new JLabel("CURS");
            cursLabel.setBounds(184, 320, 100, 50);

            JTextField seminarTextField = new JTextField();
            seminarTextField.setBounds(284, 183, 70, 50);

            JTextField laboratorTextField = new JTextField();
            laboratorTextField.setBounds(284, 250, 70, 50);

            JTextField cursTextField = new JTextField();
            cursTextField.setBounds(284, 320, 70, 50);

            JButton confirmaButton = new JButton("Confirma");
            confirmaButton.setBounds(210, 442, 100, 50);

            JComboBox<String> cursComboBox = new JComboBox<>(new String[]{"Cursuri"});
        try {
            try (Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/platformaStudiu", "root", "rootroot")) {
                String query = "CALL CautaProfesorDupaUserName(?)";
                try (PreparedStatement statement = conn.prepareStatement(query)) {
                    statement.setString(1, username);
                    try (ResultSet resultSet = statement.executeQuery()) {
                        if (resultSet.next()) {
                            cursPredat=resultSet.getString("CursuriPredate");
                        } else {
                            JOptionPane.showMessageDialog(null, "Nu s-au găsit date personale.");
                        }
                    }
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
            cursComboBox.addItem(cursPredat);
            if(idProf<4){
                cursComboBox.addItem("Circuite");
            }
            else{
                cursComboBox.addItem("Geometrie");
            }
            cursComboBox.setBounds(200, 71, 150, 75);

        confirmaButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                int procSeminar = Integer.parseInt(seminarTextField.getText());
                int procLab = Integer.parseInt(laboratorTextField.getText());
                int procCurs = Integer.parseInt(cursTextField.getText());
                String selectedCurs = (String) cursComboBox.getSelectedItem();
                try (Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/platformaStudiu", "root", "rootroot")) {
                    String findCourse = "{CALL CautaCursDupaNume(?)}";
                    try (CallableStatement findStatement = conn.prepareCall(findCourse)) {
                        findStatement.setString(1, selectedCurs);

                        try (ResultSet resultSet = findStatement.executeQuery()) {
                            if (resultSet.next()) {
                                ID = resultSet.getInt("ID_Curs");
                                String updateQuery = "{CALL SetPonderiActivitate(?, ?, ?, ?)}";
                                try (CallableStatement updateStatement = conn.prepareCall(updateQuery)) {
                                    updateStatement.setInt(1, ID);
                                    updateStatement.setDouble(2, procCurs);
                                    updateStatement.setDouble(3, procSeminar);
                                    updateStatement.setDouble(4, procLab);
                                    int rowsAffected = updateStatement.executeUpdate();
                                    JOptionPane.showMessageDialog(null, "Procentaj confirmat cu succes!");
                                }
                            } else {
                                JOptionPane.showMessageDialog(null, "Cursul nu a fost găsit.");
                            }
                        }
                    }
                } catch (SQLException ex) {
                    ex.printStackTrace();
                }
            }
        });
        cursuriPanel.add(seminarLabel);
            cursuriPanel.add(laboratorLabel);
            cursuriPanel.add(cursLabel);
            cursuriPanel.add(seminarTextField);
            cursuriPanel.add(laboratorTextField);
            cursuriPanel.add(cursTextField);
            cursuriPanel.add(confirmaButton);
            cursuriPanel.add(cursComboBox);

            tabbedPane.addTab("Cursuri", cursuriPanel);

            // Third tab - Activități
            JPanel activitatiPanel = new JPanel();
            JList<String> activitatiList = new JList<>(new DefaultListModel<>());
            activitatiList.setPreferredSize(new Dimension(259, 448));
            // Crează un model pentru lista
            DefaultListModel<String> listModel = new DefaultListModel<>();

            try (Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/platformaStudiu", "root", "rootroot")) {
                String callProcedure = "{CALL VizualizareActivitatiProfesor(?)}";
                try (CallableStatement callStatement = conn.prepareCall(callProcedure)) {
                    callStatement.setInt(1,idProf);
                    try (ResultSet resultSet = callStatement.executeQuery()) {
                        while (resultSet.next()) {
                            String rez1 = resultSet.getString("TipActivitate");
                            String rez2 = resultSet.getString("DataInceput");
                            String rez3 = resultSet.getString("DataSfarsit");
                            String rez4 = resultSet.getString("MaxParticipanti");
                            String rez5 = resultSet.getString("NumeCurs");
                            listModel.addElement(rez5);
                            listModel.addElement(rez1);
                            listModel.addElement(rez2);
                            listModel.addElement(rez3);
                        }
                    }
                }
            } catch (SQLException e) {
                e.printStackTrace();
            }

            activitatiList.setModel(listModel);
            activitatiPanel.add(new JScrollPane(activitatiList));
            JLabel activitatiLabel = new JLabel("Activități programate");
            activitatiPanel.add(activitatiLabel);
            JButton programeazaButton = new JButton("Programeaza activități");
            activitatiPanel.add(programeazaButton);
            tabbedPane.addTab("Activități", activitatiPanel);

            programeazaButton.addActionListener(new ActionListener() {
                    @Override
                    public void actionPerformed(ActionEvent e) {
                        ProgramareActivitateProf prgActProf = new ProgramareActivitateProf(idCurs,idProf,ID);
                        setVisible(false);
                        prgActProf.setVisible(true);
                    }
            });

            // Fourth tab - Catalog
            JPanel catalogPanel = new JPanel();
            catalogPanel.setLayout(null);
            JComboBox<String> cursCatalogComboBox = new JComboBox<>();
            cursCatalogComboBox.setBounds(40, 20, 150, 100);
            if(idProf<4){
                cursCatalogComboBox.addItem("Circuite");
            }
            else{
                cursCatalogComboBox.addItem("Geometrie");
            }
            cursCatalogComboBox.addItem(idCurs);

            JComboBox<String> activityComboBox = new JComboBox<>();
            activityComboBox.setBounds(40, 70, 150, 100);
            activityComboBox.addItem("Curs");
            activityComboBox.addItem("Seminar");
            activityComboBox.addItem("Laborator");
            JComboBox<String> studentComboBox = new JComboBox<>();
            studentComboBox.setBounds(40, 120, 150, 100);
            //studentComboBox.addItem("Student");
            cursCatalogComboBox.addActionListener(e-> {
            if(cursCatalogComboBox.getSelectedItem().equals("Circuite")){
                studentComboBox.removeAllItems();
                studentComboBox.addItem("Popescu Ion");
                studentComboBox.addItem("Tosa Cezar");
                studentComboBox.addItem("Jarda Adina");
                studentComboBox.addItem("Moldovan Irina");
            }
                if(cursCatalogComboBox.getSelectedItem().equals("Geometrie")){
                    studentComboBox.removeAllItems();
                    studentComboBox.addItem("Muresan Cristina");
                    studentComboBox.addItem("Jarda Adina");
                    studentComboBox.addItem("Ureche Simona");
                    studentComboBox.addItem("Repede Oana");
                }
                if(cursCatalogComboBox.getSelectedItem().equals(cursPredat)){
                        studentComboBox.removeAllItems();
                        studentComboBox.addItem("Popescu Ion");
                        studentComboBox.addItem("Kulcsar Noemi");
                        studentComboBox.addItem("Ionescu Maria");
                        studentComboBox.addItem("Codorean Luca");
                        studentComboBox.addItem("Moldovan Irina");
                }
            });

            String nume=new String();
        switch (nume) {
            case "Popescu Ion":
                idStud = 1;
                break;
            case "Tosa Cezar":
                idStud = 2;
                break;
            case "Jarda Adina":
                idStud = 3;
                break;
            case "Moldovan Irina":
                idStud = 4;
                break;
            case "Ureche Simona":
                idStud = 5;
                break;
            case "Kulcsar Noemi":
                idStud = 6;
                break;
            case "Ionescu Maria":
                idStud = 7;
                break;
            case "Codorean Luca":
                idStud = 8;
                break;
            case "Repede Oana":
                idStud = 9;
                break;
            default:
                idStud = 10;
                break;
        }
            JTextField notaTextField = new JTextField();
            notaTextField.setBounds(40, 220, 100, 75);
            JButton notareButton = new JButton("Confirma");
            notareButton.setBounds(340, 400, 100, 50);
            notareButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String course=(String)cursCatalogComboBox.getSelectedItem();
                String ceaActiv=(String)activityComboBox.getSelectedItem();
                String nume=(String)studentComboBox.getSelectedItem();
                switch (nume) {
                    case "Popescu Ion":
                        idStud = 1;
                        break;
                    case "Tosa Cezar":
                        idStud = 2;
                        break;
                    case "Jarda Adina":
                        idStud = 3;
                        break;
                    case "Moldovan Irina":
                        idStud = 4;
                        break;
                    case "Ureche Simona":
                        idStud = 5;
                        break;
                    case "Kulcsar Noemi":
                        idStud = 6;
                        break;
                    case "Ionescu Maria":
                        idStud = 7;
                        break;
                    case "Codorean Luca":
                        idStud = 8;
                        break;
                    case "Repede Oana":
                        idStud = 9;
                        break;
                    default:
                        idStud = 10;
                        break;
                }
                int idActiv;
                if(ceaActiv.equals("Curs")) {
                    idActiv = 1;
                } else {
                    if (ceaActiv.equals("Seminar")) {
                        idActiv = 2;
                    } else {
                        idActiv = 3;
                    }
                }
                String notaText = notaTextField.getText();
                int nota = Integer.parseInt(notaText);
                try (Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/platformaStudiu", "root", "rootroot")){
                        // Verifică dacă nota a fost adăugată cu succes
                        if (idStud > 0) {
                            JOptionPane.showMessageDialog(null, "Nota adaugată cu succes!");
                        } else {
                            JOptionPane.showMessageDialog(null, "Nota nu a putut fi adăugată.");
                        }

                } catch (SQLException ex) {
                    ex.printStackTrace();
                }
            }
        });

            catalogPanel.add(cursCatalogComboBox);
            catalogPanel.add(activityComboBox);
            catalogPanel.add(studentComboBox);
            catalogPanel.add(notaTextField);
            catalogPanel.add(notareButton);
            tabbedPane.addTab("Catalog", catalogPanel);

            // Main panel
            JPanel mainPanel = new JPanel(new BorderLayout());
            mainPanel.add(tabbedPane, BorderLayout.CENTER);

            JLabel numeLabel = new JLabel("Bună, "+numele+"!");
            numeLabel.setBounds(621, 41, 110, 56);
            JButton logoutButton = new JButton("Log out");
            logoutButton.setBounds(608, 502, 150, 50);
            logoutButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                dispose();
                PaginaLogare logareUI = new PaginaLogare();
                logareUI.setVisible(true);
            }
        });

            mainPanel.add(numeLabel, BorderLayout.NORTH);
            mainPanel.add(logoutButton, BorderLayout.SOUTH);

            add(mainPanel);
            setVisible(true);
    }
    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> new AfisareDateProfesor(""));
    }
}
