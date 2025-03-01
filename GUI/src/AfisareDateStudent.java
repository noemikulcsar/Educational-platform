import com.toedter.calendar.JDateChooser;

import javax.swing.*;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.IOException;
import java.sql.*;
import java.util.Vector;
import java.util.concurrent.atomic.AtomicReference;

public class AfisareDateStudent extends JFrame {
    private String username;
    private String numele;
    public AfisareDateStudent(String username) {
        this.username=username;
        this.numele=numele;
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
                String query = "CALL CautaStudentulDupaNume(?)";
                try (PreparedStatement statement = conn.prepareStatement(query)) {
                    statement.setString(1, username);

                    try (ResultSet resultSet = statement.executeQuery()) {
                        if (resultSet.next()) {
                            Vector<Object> row = new Vector<>();
                            model.addRow(new Object[]{"CNP", resultSet.getString("CNP_Student")});
                            model.addRow(new Object[]{"Nume", resultSet.getString("Nume_Student")});
                            model.addRow(new Object[]{"Prenume", resultSet.getString("Prenume_Student")});
                            numele=resultSet.getString("Prenume_Student");
                            model.addRow(new Object[]{"Adresa", resultSet.getString("Adresa_Student")});
                            model.addRow(new Object[]{"Telefon", resultSet.getString("Telefon_Student")});
                            model.addRow(new Object[]{"Email", resultSet.getString("Email_Student")});
                            model.addRow(new Object[]{"IBAN", resultSet.getString("ContIBAN_Student")});
                            model.addRow(new Object[]{"NumarContract", resultSet.getString("NumarContract_Student")});
                            model.addRow(new Object[]{"An studiu", resultSet.getString("AnStudiu")});
                            model.addRow(new Object[]{"Numar ore", resultSet.getString("OreSustinute_Student")});
                            //model.addRow(new Object[]{"MinOre", resultSet.getString("MinOre")});
                            //model.addRow(new Object[]{"MaxOre", resultSet.getString("MaxOre")});
                            model.addRow(new Object[]{"UserName", resultSet.getString("UserName")});
                            //((DefaultTableModel) dateContTable.getModel()).addRow(row);
                        } else {
                            JOptionPane.showMessageDialog(null, "Nu s-au găsit date personale.");
                        }
                    }
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        dateContPanel.add(dateContTable);
        tabbedPane.addTab("Date Cont", dateContPanel);
        InscriereCursTab inscriereCursTab = new InscriereCursTab();
        VizualizareNoteStergereCursTab vizualizareNoteStergereCursTab = new VizualizareNoteStergereCursTab();
        VizualizareGrupStudiuTab vizualizareGrupStudiuTab = new VizualizareGrupStudiuTab();
        InscriereParasireGrupStudiuTab inscriereParasireGrupStudiuTab = new InscriereParasireGrupStudiuTab();
        ActivitatiTab activitatiTab = new ActivitatiTab();
        CreareActivitateGrupTab creareActivitateTab = new CreareActivitateGrupTab();

        tabbedPane.addTab("Inscriere curs", inscriereCursTab);
        tabbedPane.addTab("Vizualizare note/Stergere curs", vizualizareNoteStergereCursTab);
        tabbedPane.addTab("Vizualizare grup studiu", vizualizareGrupStudiuTab);
        tabbedPane.addTab("Inscriere/Parasire grup studiu", inscriereParasireGrupStudiuTab);
        tabbedPane.addTab("Activitati", activitatiTab);
        tabbedPane.addTab("Creare activitate grup", creareActivitateTab);

        add(tabbedPane);
        setVisible(true);
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
    private void afiseazaDate(String username) {

//
    }
    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> new AfisareDateStudent(""));
    }
}

class InscriereCursTab extends JPanel {
    public InscriereCursTab() {
        setLayout(null);

        JTextField numeTextField = new JTextField();
        numeTextField.setBounds(200, 48, 150, 25);
        JTextField prenumeTextField = new JTextField();
        prenumeTextField.setBounds(200, 130, 150, 25);
        JTextField cnpTextField = new JTextField();
        cnpTextField.setBounds(200, 236, 150, 25);

        JLabel numeLabel = new JLabel("Nume");
        numeLabel.setBounds(68, 52, 80, 20);
        JLabel prenumeLabel = new JLabel("Prenume");
        prenumeLabel.setBounds(68, 134, 80, 20);
        JLabel cnpLabel = new JLabel("CNP");
        cnpLabel.setBounds(68, 240, 80, 20);

        JComboBox<String> cursComboBox = new JComboBox<>();
        cursComboBox.setEditable(true);
        cursComboBox.setBounds(487, 74, 250, 25);
        cursComboBox.addItem("Sisteme de operare");
        cursComboBox.addItem("Algoritmi Fundamentali");
        cursComboBox.addItem("Analiza Matematica");
        cursComboBox.addItem("Matematici speciale");
        cursComboBox.addItem("Fizica");

        JButton inscriereButton = new JButton("Inscriere");
        inscriereButton.setBounds(249, 326, 100, 25);
        inscriereButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                // Handle inscriere button click
                String nume = numeTextField.getText();
                String prenume = prenumeTextField.getText();
                String cnp = cnpTextField.getText();
                String selectedCurs = (String) cursComboBox.getSelectedItem();
                if(nume.equals("Ureche") && selectedCurs.equals("Sisteme de operare"))
                {
                    JOptionPane.showMessageDialog(null, "Inscriere la curs reusita");
                }
                else if(nume.equals("Ureche") && selectedCurs.equals("Algoritmi Fundamentali"))
                {
                    JOptionPane.showMessageDialog(null, "User-ul este deja inscris la curs");
                }
                else if(nume.equals("Repede") && selectedCurs.equals("Analiza Matematica"))
                {
                    JOptionPane.showMessageDialog(null, "User-ul este deja inscris la curs");
                }
                else if(nume.equals("Repede") && selectedCurs.equals("Matematici speciale"))
                {
                    JOptionPane.showMessageDialog(null, "Inscriere la curs reusita");
                }
                else
                {
                    JOptionPane.showMessageDialog(null, "Date incorecte!");
                }
            }
        });

        add(numeTextField);
        add(prenumeTextField);
        add(cnpTextField);
        add(numeLabel);
        add(prenumeLabel);
        add(cnpLabel);
        add(cursComboBox);
        add(inscriereButton);
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> new InscriereCursTab());
    }
}
class VizualizareNoteStergereCursTab extends JPanel {
    public VizualizareNoteStergereCursTab() {
        setLayout(null);
        DefaultTableModel tableModel = new DefaultTableModel();
        JTable noteTable = new JTable(tableModel);
        noteTable.setBounds(14, 102, 342, 200);
        tableModel.addColumn("Disciplina");
        tableModel.addColumn("Nota");
        String[] disciplinaRows = {"Sisteme de operare", "Algoritmi Fundamentali", "Analiza Matematica", "Matematici speciale", "Fizica"};
        String[] noteRows = {"8", "9", "7", "10", "4"};
        for (int i = 0; i < disciplinaRows.length; i++) {
            tableModel.addRow(new Object[]{disciplinaRows[i], noteRows[i]});
        }
        JLabel vizualizareNoteLabel = new JLabel("Vizualizare note");
        vizualizareNoteLabel.setBounds(143, 42, 150, 20);

        JLabel stergereCursLabel = new JLabel("Stergere curs");
        stergereCursLabel.setBounds(583, 42, 150, 20);

        JComboBox<String> cursStergereComboBox = new JComboBox<>();
        cursStergereComboBox.setEditable(true);
        cursStergereComboBox.setBounds(543, 110, 150, 25);
        cursStergereComboBox.addItem("Sisteme de operare");
        cursStergereComboBox.addItem("Algoritmi Fundamentali");
        cursStergereComboBox.addItem("Analiza Matematica");
        cursStergereComboBox.addItem("Matematici speciale");
        cursStergereComboBox.addItem("Fizica");

        JButton stergereButton = new JButton("Stergere");
        stergereButton.setBounds(583, 346, 100, 25);
        stergereButton.addActionListener(e -> {
            String selectedCurs = (String) cursStergereComboBox.getSelectedItem();
            // Remove the selected course and its grade from the table model
            for (int i = 0; i < tableModel.getRowCount(); i++) {
                if (tableModel.getValueAt(i, 0).equals(selectedCurs)) {
                    tableModel.removeRow(i);
                    break;
                }
            }
        });

        add(noteTable);
        add(vizualizareNoteLabel);
        add(stergereCursLabel);
        add(cursStergereComboBox);
        add(stergereButton);
    }
}

class VizualizareGrupStudiuTab extends JPanel {
    public VizualizareGrupStudiuTab() {
        setLayout(null);

        JComboBox<String> cursVizualizareGrupComboBox = new JComboBox<>();
        cursVizualizareGrupComboBox.setEditable(true);
        cursVizualizareGrupComboBox.setBounds(84, 41, 150, 25);
        cursVizualizareGrupComboBox.addItem("Sisteme de operare");
        cursVizualizareGrupComboBox.addItem("Algoritmi Fundamentali");
        cursVizualizareGrupComboBox.addItem("Analiza Matematica");
        cursVizualizareGrupComboBox.addItem("Matematici speciale");
        cursVizualizareGrupComboBox.addItem("Fizica");

        JTextArea userMessagesTextArea = new JTextArea();
        userMessagesTextArea.setBounds(280, 41, 500, 340);
        userMessagesTextArea.setFont(new Font("Arial", Font.PLAIN, 14));
        userMessagesTextArea.setEditable(false);

        DefaultListModel<String> membriiListModel = new DefaultListModel<>();
        JList<String> membriiGrup = new JList<>(membriiListModel);
        membriiGrup.setBounds(59, 180, 200, 200);

        JLabel profesorSugeratLabel = new JLabel("Profesor:");
        profesorSugeratLabel.setBounds(75, 150, 200, 20);
        // Add a ListSelectionListener to the JList
        membriiGrup.addListSelectionListener(new ListSelectionListener() {
            @Override
            public void valueChanged(ListSelectionEvent e) {
                if (!e.getValueIsAdjusting()) {
                    // Handle JList selection change if needed
                    System.out.println("Selected: " + membriiGrup.getSelectedValue());
                }
            }
        });

        // Add an ActionListener to the JComboBox
        cursVizualizareGrupComboBox.addActionListener(e -> {
            // Clear the existing elements in the list
            membriiListModel.clear();

            // Populate the list based on the selected course
            String selectedCourse = (String) cursVizualizareGrupComboBox.getSelectedItem();
            if ("Sisteme de operare".equals(selectedCourse)) {
                membriiListModel.addElement("Ureche Simona");
                membriiListModel.addElement("Repede Oana");
                userMessagesTextArea.setText("");
                userMessagesTextArea.append("Oana: Buna! Ai reusit sa finalizezi proiectul?\n");
                userMessagesTextArea.append("Simona: Da, am terminat azi dimineata.\n");
                userMessagesTextArea.append("Oana: Super! Sa vedem rezultatele maine la laborator.\n");
                userMessagesTextArea.append("Simona: Cu siguranta!\n");
                userMessagesTextArea.append("Oana: Daca ai nevoie de ajutor, sunt aici.\n");
                profesorSugeratLabel.setText("Profesor: Popa Ana");
            } else if ("Analiza Matematica".equals(selectedCourse)) {
                membriiListModel.addElement("Tosa Cezar");
                membriiListModel.addElement("Luca Codorean");
                membriiListModel.addElement("Muresan Cristina");
                membriiListModel.addElement("Ureche Simona");
                userMessagesTextArea.setText("");
                userMessagesTextArea.append("Cristina: Buna! Ati reusit sa faceti fisele de lucru de la seminar?\n");
                userMessagesTextArea.append("Simona: Eu mai am doua de facut.\n");
                userMessagesTextArea.append("Simona: Ce ziceti sa ne vedem sa le discutam?\n");
                userMessagesTextArea.append("Cristina: De acord! Sa vedem ce zic si restul\n");
                userMessagesTextArea.append("Luca: Zic ca e o idee buna.\n");
                userMessagesTextArea.append("Cezar: joaca careva un meci de lol?\n");
                profesorSugeratLabel.setText("Profesor: Pop Vasile");
            } else if ("Matematici speciale".equals(selectedCourse)) {
                membriiListModel.addElement("Popescu Ion");
                membriiListModel.addElement("Ionescu Maria");
                membriiListModel.addElement("Moldovan Irina");
                userMessagesTextArea.setText("");
                userMessagesTextArea.append("Ion: Salut! Ați început să vedeți materialul de invățat?\n");
                userMessagesTextArea.append("Maria: Da, am început să rezolv problemele din culegere.\n");
                userMessagesTextArea.append("Irina: Eu am găsit și niște resurse online interesante.\n");
                userMessagesTextArea.append("Ion: Super! Haideți să ne ajutăm reciproc să înțelegem mai bine subiectul.\n");
                userMessagesTextArea.append("Maria: Sunt de acord, poate facem și niște sesiuni de studiu împreună.\n");
                profesorSugeratLabel.setText("Profesor: Potolea Rodica");
            }
            else {
                userMessagesTextArea.setText("");
                profesorSugeratLabel.setText("Profesor:");
            }

            // Optionally select the first item in the list
            if (membriiListModel.size() > 0) {
                membriiGrup.setSelectedIndex(0);
            }
        });
        JTextField messageTextField = new JTextField("");
        //messageTextField.setBounds(280, 610, 200, 25);
        JButton sendMessageButton = new JButton("Trimite mesaj");
        //sendMessageButton.setBounds(490, 610, 90, 25);
        messageTextField.setBounds(280, 440, 200, 25);
        sendMessageButton.setBounds(490, 440, 130, 25);
        sendMessageButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String message = messageTextField.getText();
                if (!message.isEmpty()) {
                    userMessagesTextArea.append("You: " + message + "\n");
                    messageTextField.setText("");
                }
            }
        });

        add(cursVizualizareGrupComboBox);
        add(membriiGrup);
        add(userMessagesTextArea);
        add(sendMessageButton);
        add(messageTextField);
        add(profesorSugeratLabel);
    }
}

class InscriereParasireGrupStudiuTab extends JPanel {
    public InscriereParasireGrupStudiuTab() {
        setLayout(null);

        JComboBox<String> cursInscriereComboBox = new JComboBox<>();
        cursInscriereComboBox.setEditable(true);
        cursInscriereComboBox.setBounds(48, 136, 150, 25);
        cursInscriereComboBox.addItem("Fizica");
        cursInscriereComboBox.addItem("Algoritmi Fundamentali");

        JComboBox<String> cursParasireComboBox = new JComboBox<>();
        cursParasireComboBox.setEditable(true);
        cursParasireComboBox.setBounds(522, 136, 150, 25);

        JButton inscriereButton = new JButton("Inscriere");
        inscriereButton.setBounds(93, 343, 100, 25);

        inscriereButton.addActionListener(e -> {
            String selectedCurs = cursInscriereComboBox.getSelectedItem().toString();

            for(int i = 0;i < cursInscriereComboBox.getItemCount();i++)
                if(selectedCurs.equals(cursInscriereComboBox.getSelectedItem()))
                {
                    cursInscriereComboBox.removeItemAt(i);
                    break;
                }
            cursParasireComboBox.addItem(selectedCurs);
        });

        JLabel inscriereLabel = new JLabel("Inscriere");
        inscriereLabel.setBounds(101, 73, 150, 20);


        JLabel parasireLabel = new JLabel("Parasire");
        parasireLabel.setBounds(576, 64, 150, 20);

        cursParasireComboBox.addItem("Analiza Matematica");
        cursParasireComboBox.addItem("Sisteme de operare");

        JButton parasireButton = new JButton("Parasire");
        parasireButton.setBounds(582, 343, 100, 25);
        parasireButton.addActionListener(e -> {
            String selectedCurs = cursParasireComboBox.getSelectedItem().toString();

            for(int i=0; i< cursParasireComboBox.getItemCount();i++)
                if(selectedCurs.equals(cursParasireComboBox.getItemAt(i)))
                {
                    cursParasireComboBox.removeItemAt(i);
                    break;
                }
            cursInscriereComboBox.addItem(selectedCurs);
        });

        add(cursInscriereComboBox);
        add(inscriereButton);
        add(inscriereLabel);
        add(parasireLabel);
        add(cursParasireComboBox);
        add(parasireButton);
    }
}

class ActivitatiTab extends JPanel {
    public ActivitatiTab() {
        setLayout(null);

        JLabel activitatiZiCurentaLabel = new JLabel("Activitati zi curenta");
        activitatiZiCurentaLabel.setBounds(108, 58, 150, 20);

        JLabel activitatiGrupStudiuLabel = new JLabel("Lista activitati grup studiu");
        activitatiGrupStudiuLabel.setBounds(552, 58, 250, 20);

        DefaultListModel<String> listModel = new DefaultListModel<>();

        JList<String> activitatiZiCurentaList = new JList<>(listModel);
        activitatiZiCurentaList.setBounds(58, 136, 200, 200);

        listModel.addElement("Laborator Baze de date : ora 10");
        listModel.addElement("Curs PLA: ora 14");
        listModel.addElement("Curs OOP: ora 16");
        listModel.addElement("Curs BD: ora 18");

        DefaultListModel<String> listModel1 = new DefaultListModel<>();

        JList<String> activitatiGrupStudiuList = new JList<>(listModel1);
        activitatiGrupStudiuList.setBounds(495, 136, 300, 200);

        listModel1.addElement("Luni: Proiectare sisteme numerice - ora 20");
        listModel1.addElement("Joi: Arhitectura calculatoarelor - ora 19");
        listModel1.addElement("Sambata: Programare Assembly - ora 10");

        JButton orar = new JButton("Descarcare orar");
        orar.setBounds(300, 400, 150, 30);
        orar.addActionListener(e -> {
            openPdfFile("/Users/oanarepede/Downloads/Orar.pdf");
        });

        add(activitatiZiCurentaLabel);
        add(activitatiGrupStudiuLabel);
        add(activitatiZiCurentaList);
        add(activitatiGrupStudiuList);
        add(orar);
    }

    private static void openPdfFile(String filePath) {
        try {
            File file = new File(filePath);

            if (file.exists()) {
                Desktop.getDesktop().open(file);
            } else {
                System.out.println("File does not exist: " + filePath);
            }
        } catch (IOException ex) {
            ex.printStackTrace();
        }
    }
}

class CreareActivitateGrupTab extends JPanel {
    public CreareActivitateGrupTab() {
        setLayout(null);

        JComboBox<String> cursCreareActivitateComboBox = new JComboBox<>();
        cursCreareActivitateComboBox.setEditable(true);
        // Make the JComboBox wider
        cursCreareActivitateComboBox.setBounds(38, 43, 200, 25);
        cursCreareActivitateComboBox.addItem("Arhitectura Calculatoarelor");
        cursCreareActivitateComboBox.addItem("Programare Assembly");
        cursCreareActivitateComboBox.addItem("Matematici speciale");
        cursCreareActivitateComboBox.addItem("Baze de date");

        JLabel dataProgramariiLabel = new JLabel("Data programarii");
        dataProgramariiLabel.setBounds(242, 165, 150, 20);
        JDateChooser datePickerInceput = new JDateChooser();
        datePickerInceput.setBounds(242, 185, 150, 25);

        JLabel dataDeadlineInscriereLabel = new JLabel("Data Deadline Inscriere");
        dataDeadlineInscriereLabel.setBounds(242, 244, 150, 20);
        JDateChooser datePickerSfarsit = new JDateChooser();
        datePickerSfarsit.setBounds(242, 264, 150, 25);

        JLabel oraActivitate = new JLabel("Ora activitate");
        oraActivitate.setBounds(242, 303, 150, 25);
        JTextField ora = new JTextField("");
        ora.setBounds(242, 324, 150, 25);

        JLabel nrMaxim = new JLabel("Numar maxim de participanti");
        nrMaxim.setBounds(242, 354, 200, 25);

        JTextField numarMinimParticipantiTextField = new JTextField();
        numarMinimParticipantiTextField.setBounds(242, 375, 150, 25);

        JButton adaugaButton = new JButton("Adauga");
        adaugaButton.setBounds(270, 403, 100, 25);
        adaugaButton.addActionListener(e -> {
            if (ora.getText().equals("16")) {
                JOptionPane.showMessageDialog(null, "Program indisponibil");
            } else
                JOptionPane.showMessageDialog(null, "Activitate creata cu succes");
        });

        add(cursCreareActivitateComboBox);
        add(dataProgramariiLabel);
        add(datePickerInceput);
        add(dataDeadlineInscriereLabel);
        add(datePickerSfarsit);
        add(oraActivitate);
        add(ora);
        add(nrMaxim);
        add(numarMinimParticipantiTextField);
        add(adaugaButton);
    }
}