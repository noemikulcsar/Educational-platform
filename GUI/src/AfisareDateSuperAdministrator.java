import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.*;
import java.util.Arrays;
import java.util.Vector;
import javax.swing.table.TableCellRenderer;
import javax.swing.table.TableColumn;

public class AfisareDateSuperAdministrator extends JFrame {

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
    private JTextField cnpField2;
    private JTextField numeField2;
    private JTextField prenumeField2;
    private JTextField adresaField2;
    private JTextField telefonField2;
    private JTextField emailField2;
    private JTextField contIbanField2;
    private JTextField numarContractField2;
    private JTextField cursuriPredateField2;
    private JTextField  departamentField2;
    private JTextField  minimOreField2;
    private JTextField   maximOreField2;
    private JTextField usernameField2;
    private JPasswordField passwordField2;

    private JTextField cnpField3;
    private JTextField numeField3;
    private JTextField prenumeField3;
    private JTextField adresaField3;
    private JTextField telefonField3;
    private JTextField emailField3;
    private JTextField contIbanField3;
    private JTextField numarContractField3;

    private JTextField usernameField3;
    private JPasswordField passwordField3;

    private String username;
    private String numele;
    public AfisareDateSuperAdministrator(String username)
    {

        JTextField cnpStudentTextField;


        cnpField2 = new JTextField();
        numeField2 = new JTextField();
        prenumeField2 = new JTextField();
        adresaField2 = new JTextField();
        telefonField2 = new JTextField();
        emailField2 = new JTextField();
        contIbanField2 = new JTextField();
        numarContractField2 = new JTextField();
        usernameField2 = new JTextField();
        passwordField2 = new JPasswordField();


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
                String query = "CALL CautaSuperAdministratoriDupaUserName(?)";
                try (PreparedStatement statement = conn.prepareStatement(query)) {
                    statement.setString(1, username);

                    try (ResultSet resultSet = statement.executeQuery()) {
                        if (resultSet.next()) {
                            Vector<Object> row = new Vector<>();
                            model.addRow(new Object[]{"CNP", resultSet.getString("CNP_SuperAdministratori")});
                            model.addRow(new Object[]{"Nume", resultSet.getString("Nume_SuperAdministratori")});
                            model.addRow(new Object[]{"Prenume", resultSet.getString("Prenume_SuperAdministratori")});
                            numele=resultSet.getString("Prenume_SuperAdministratori");
                            model.addRow(new Object[]{"Adresa", resultSet.getString("Adresa_SuperAdministratori")});
                            model.addRow(new Object[]{"Telefon", resultSet.getString("Telefon_SuperAdministratori")});
                            model.addRow(new Object[]{"Email", resultSet.getString("Email_SuperAdministratori")});
                            model.addRow(new Object[]{"IBAN", resultSet.getString("ContIBAN_SuperAdministratori")});
                            model.addRow(new Object[]{"NumarContract", resultSet.getString("NumarContract_SuperAdministratori")});

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


        // Cautare Studenti tab
        JPanel cautareStudentiPanel = new JPanel();
        cautareStudentiPanel.setLayout(new BorderLayout());  // Use BorderLayout for better layout management

// Panel for the search text field
        JPanel searchPanel = new JPanel();
        searchPanel.setLayout(new FlowLayout(FlowLayout.CENTER));

        JLabel nameLabel = new JLabel("Nume student: ");
        searchPanel.add(nameLabel);

        JTextField cautareStudentTextField = new JTextField();
        cautareStudentTextField.setPreferredSize(new Dimension(156, 30));
        searchPanel.add(cautareStudentTextField);

        JButton searchButton = new JButton("Cauta");
        searchPanel.add(searchButton);
        cautareStudentiPanel.add(searchPanel, BorderLayout.NORTH);

        JPanel studentDetailsPanel = new JPanel();
        studentDetailsPanel.setLayout(new FlowLayout(FlowLayout.LEFT));  // Adjust the layout as needed
        cautareStudentiPanel.add(studentDetailsPanel, BorderLayout.SOUTH);


        Vector<Vector<Object>> studentData = new Vector<>();

// Simulated data (replace this with your actual data fetching logic)
        Vector<Object> student1 = new Vector<>(Arrays.asList("1234567890100", "Ureche", "Simona", "Strada Garii nr. 1082", "0764224194", "simona.ureche@yahoo.com"));
        Vector<Object> student2 = new Vector<>(Arrays.asList("2345678901111", "Repede", "Oana", "Strada Avram Iancu nr. 410", "0784059519", "oana.repede@yahoo.com"));
        Vector<Object> student3 = new Vector<>(Arrays.asList("2345678901457", "Kulcsar", "Noaemi", "Strada Aleeea Zorilor nr 6", "0754617850", "kulcsar.noemi@yahoo.com"));
        Vector<Object> student4 = new Vector<>(Arrays.asList("1234567890123", "Popescu", "Ion", "Strada Principala nr. 10", "0712345678", "ion.popescu@example.com"));
        Vector<Object> student5 = new Vector<>(Arrays.asList("2345678901234","Ionescu", "Maria", "Bulevardul Libertatii nr. 5", "0723456789", "maria.ionescu@example.com"));


        studentData.add(student1);
        studentData.add(student2);
        studentData.add(student3);
        studentData.add(student4);
        studentData.add(student5);

        DefaultTableModel model2 = new DefaultTableModel(new Object[]{"CNP_Student", "Nume", "Prenume", "Adresa", "Telefon", "Email"}, 0);
        JTable dateContTable2 = new JTable(model2);



// Action listener for the search button
        searchButton.addActionListener(e -> {
            String searchedName = cautareStudentTextField.getText();
            Vector<Object> studentDetails = searchStudentByName(searchedName, studentData);

            // Display the details in the details panel
            displayStudentDetails(studentDetails, studentDetailsPanel);
        });



        try (Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/platformaStudiu", "root", "rootroot")) {
            String query = "CALL VizualizareStudenti()";  // Assuming the stored procedure doesn't take any parameters
            try (PreparedStatement statement = conn.prepareStatement(query)) {
                try (ResultSet resultSet = statement.executeQuery()) {
                    while (resultSet.next()) {
                        Vector<Object> row = new Vector<>();
                        row.add(resultSet.getString("CNP_Student"));
                        row.add(resultSet.getString("Nume_Student"));
                        row.add(resultSet.getString("Prenume_Student"));
                        row.add(resultSet.getString("Adresa_Student"));
                        row.add(resultSet.getString("Telefon_Student"));
                        row.add(resultSet.getString("Email_Student"));
                        row.add(resultSet.getString("NumarContract_Student"));
                        model2.addRow(row);
                    }
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        JScrollPane scrollPane = new JScrollPane(dateContTable2);
        cautareStudentiPanel.add(scrollPane, BorderLayout.CENTER);

        tabbedPane.addTab("Cautare Studenti", cautareStudentiPanel);


        // Cautare Profesori tab
        JPanel cautareProfesoriPanel = new JPanel();
        cautareProfesoriPanel.setLayout(new BorderLayout());

// Panel for the search text field
        JPanel searchPanelProfesori = new JPanel();
        searchPanelProfesori.setLayout(new FlowLayout(FlowLayout.CENTER));

        JLabel nameLabelProfesori = new JLabel("Nume profesor: ");
        searchPanelProfesori.add(nameLabelProfesori);

        JTextField cautareProfesorTextField = new JTextField();
        cautareProfesorTextField.setPreferredSize(new Dimension(156, 30));
        searchPanelProfesori.add(cautareProfesorTextField);

        JButton searchButtonProfesori = new JButton("Cauta");
        searchPanelProfesori.add(searchButtonProfesori);
        cautareProfesoriPanel.add(searchPanelProfesori, BorderLayout.NORTH);


        JPanel profesorDetailsPanel = new JPanel();
        profesorDetailsPanel.setLayout(new FlowLayout(FlowLayout.LEFT));
        cautareProfesoriPanel.add(profesorDetailsPanel, BorderLayout.SOUTH);


        Vector<Vector<Object>> profesorData = new Vector<>();


        Vector<Object> profesor1 = new Vector<>(Arrays.asList("3456789012999", "Pop", "Vasile", "Strada Bulevardul Eroilor nr. 10", "0734567890", "vasile.pop@example.com", "Analiza"));
        Vector<Object> profesor2 = new Vector<>(Arrays.asList("4567890123888", "Potolea", "Rodica", "Strada Gheorge Baritiu nr. 26", "0745678908", "rodi.poto@example.com", "Alogoritmi Fundamentali"));
        Vector<Object> profesor3 = new Vector<>(Arrays.asList("3456789012777", "Oprisa", "Ciprian", "Strada Parang nr. 14", "0734567111", "op.cipri@example.com", "Sisteme de operare"));
        Vector<Object> profesor4 = new Vector<>(Arrays.asList("3456789012345", "Popa", "Ana", "Strada Mihai Viteazu nr. 15", "0734567890", "ana.popa@example.com", "Matematica"));
        Vector<Object> profesor5 = new Vector<>(Arrays.asList("4567890123456", "Radu", "Alexandru", "Aleea Florilor nr. 8", "0745678901", "alex.radu@example.com", "Fizica"));

        profesorData.add(profesor1);
        profesorData.add(profesor2);
        profesorData.add(profesor3);
        profesorData.add(profesor4);
        profesorData.add(profesor5);

        DefaultTableModel modelProfesori = new DefaultTableModel(new Object[]{"CNP_Profesor", "Nume", "Prenume", "Adresa", "Telefon", "Email","IBAN","Numar Contract", "Departament", "MinOre", "MaxOre"}, 0);
        JTable dateContTableProfesori = new JTable(modelProfesori);

        searchButtonProfesori.addActionListener(e -> {
            String searchedNameProfesori = cautareProfesorTextField.getText();
            Vector<Object> profesorDetails = searchProfesorByName(searchedNameProfesori, profesorData);
            displayProfesorDetails(profesorDetails, profesorDetailsPanel);
        });

        try (Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/platformaStudiu", "root", "rootroot")) {
            String query = "CALL VizualizareProfesori()";
            try (PreparedStatement statement = conn.prepareStatement(query)) {
                try (ResultSet resultSet = statement.executeQuery()) {
                    while (resultSet.next()) {
                        Vector<Object> row = new Vector<>();
                        row.add(resultSet.getString("CNP_Profesor"));
                        row.add(resultSet.getString("Nume_Profesor"));
                        row.add(resultSet.getString("Prenume_Profesor"));
                        row.add(resultSet.getString("Adresa_Profesor"));
                        row.add(resultSet.getString("Telefon_Profesor"));
                        row.add(resultSet.getString("Email_Profesor"));
                        row.add(resultSet.getString("ContIBAN_Profesor"));
                        row.add(resultSet.getString("NumarContract_Profesor"));
                        row.add(resultSet.getString("Departament"));
                        row.add(resultSet.getString("MinOre"));
                        row.add(resultSet.getString("MaxOre"));
                        modelProfesori.addRow(row);
                    }
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        JScrollPane scrollPaneProfesori = new JScrollPane(dateContTableProfesori);
        cautareProfesoriPanel.add(scrollPaneProfesori, BorderLayout.CENTER);

        tabbedPane.addTab("Cautare Profesori", cautareProfesoriPanel);

        // Inregistrare Profesori tab
        JPanel inregistrareProfesoriPanel = new JPanel();
        inregistrareProfesoriPanel.setLayout(new GridLayout(13, 2));


        inregistrareProfesoriPanel.add(new JLabel("CNP:"));
        JTextField cnpProfesorTextField = new JTextField();
        inregistrareProfesoriPanel.add(cnpProfesorTextField);

        inregistrareProfesoriPanel.add(new JLabel("Nume:"));
        JTextField numeProfesorTextField = new JTextField();
        inregistrareProfesoriPanel.add(numeProfesorTextField);

        inregistrareProfesoriPanel.add(new JLabel("Prenume:"));
        JTextField prenumeProfesorTextField = new JTextField();
        inregistrareProfesoriPanel.add(prenumeProfesorTextField);

        inregistrareProfesoriPanel.add(new JLabel("Adresa:"));
        JTextField adresaProfesorTextField = new JTextField();
        inregistrareProfesoriPanel.add(adresaProfesorTextField);

        inregistrareProfesoriPanel.add(new JLabel("Telefon:"));
        JTextField telefonProfesorTextField = new JTextField();
        inregistrareProfesoriPanel.add(telefonProfesorTextField);

        inregistrareProfesoriPanel.add(new JLabel("Email:"));
        JTextField emailProfesorTextField = new JTextField();
        inregistrareProfesoriPanel.add(emailProfesorTextField);

        inregistrareProfesoriPanel.add(new JLabel("IBAN:"));
        JTextField ibanProfesorTextField = new JTextField();
        inregistrareProfesoriPanel.add(ibanProfesorTextField);

        inregistrareProfesoriPanel.add(new JLabel("Numar Contract:"));
        JTextField contractProfesorTextField = new JTextField();
        inregistrareProfesoriPanel.add(contractProfesorTextField);

        inregistrareProfesoriPanel.add(new JLabel("Departament:"));
        JTextField departamentProfesorTextField = new JTextField();
        inregistrareProfesoriPanel.add(departamentProfesorTextField);

        inregistrareProfesoriPanel.add(new JLabel("UserName:"));
        JTextField usernameProfesorTextField = new JTextField();
        inregistrareProfesoriPanel.add(usernameProfesorTextField);

        inregistrareProfesoriPanel.add(new JLabel("Parola:"));
        JTextField parolaProfesorTextField = new JTextField();
        inregistrareProfesoriPanel.add(parolaProfesorTextField);



        JButton registerButton = new JButton("Înregistrare");
        registerButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                JOptionPane.showMessageDialog(null, "Profesorul a fost adaugat cu succes!");
                AdaugareProfesor();
            }
        });
        inregistrareProfesoriPanel.add(registerButton);


        JButton StergereProfbuttonent = new JButton("Stergere Profesor");
        StergereProfbuttonent.setBounds(100, 350, 150, 50);
        StergereProfbuttonent.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                dispose();
                StergereProfesor stergereProfesor= new StergereProfesor();
                stergereProfesor.setVisible(true);
            }
        });

        inregistrareProfesoriPanel.add(StergereProfbuttonent, BorderLayout.CENTER);
        tabbedPane.addTab("Inregistrare Profesori", inregistrareProfesoriPanel);


        // Inregistrare Studenti tab

        JPanel inregistrareStudentiPanel = new JPanel();
        inregistrareStudentiPanel.setLayout(new GridLayout(13, 2));



        inregistrareStudentiPanel.add(new JLabel("CNP:"));
        cnpStudentTextField = new JTextField();
        inregistrareStudentiPanel.add(cnpStudentTextField);

        inregistrareStudentiPanel.add(new JLabel("Nume:"));
        JTextField numeStudentTextField = new JTextField();
        inregistrareStudentiPanel.add(numeStudentTextField);

        inregistrareStudentiPanel.add(new JLabel("Prenume:"));
        JTextField prenumeStudentTextField = new JTextField();
        inregistrareStudentiPanel.add(prenumeStudentTextField);

        inregistrareStudentiPanel.add(new JLabel("Adresa:"));
        JTextField adresaStudentTextField = new JTextField();
        inregistrareStudentiPanel.add(adresaStudentTextField);

        inregistrareStudentiPanel.add(new JLabel("Telefon:"));
        JTextField telefonStudentTextField = new JTextField();
        inregistrareStudentiPanel.add(telefonStudentTextField);

        inregistrareStudentiPanel.add(new JLabel("Email:"));
        JTextField emailStudentTextField = new JTextField();
        inregistrareStudentiPanel.add(emailStudentTextField);

        inregistrareStudentiPanel.add(new JLabel("IBAN:"));
        JTextField ibanStudentTextField = new JTextField();
        inregistrareStudentiPanel.add(ibanStudentTextField);

        inregistrareStudentiPanel.add(new JLabel("Numar Contract:"));
        JTextField contractStudentTextField = new JTextField();
        inregistrareStudentiPanel.add(contractStudentTextField);

        inregistrareStudentiPanel.add(new JLabel("Ore sustinute"));
        JTextField oreSustinuteStudentTextField = new JTextField();
        inregistrareStudentiPanel.add(oreSustinuteStudentTextField);

        inregistrareStudentiPanel.add(new JLabel("An studiu"));
        JTextField anStudentTextField = new JTextField();
        inregistrareStudentiPanel.add(anStudentTextField);




        inregistrareStudentiPanel.add(new JLabel("Username:"));
        JTextField usernameField = new JTextField();
        inregistrareStudentiPanel.add(usernameField);

        inregistrareStudentiPanel.add(new JLabel("Parola:"));
        JPasswordField passwordField = new JPasswordField();
        inregistrareStudentiPanel.add(passwordField);


        JButton registerButton2 = new JButton("Înregistrare");
        registerButton2.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                JOptionPane.showMessageDialog(null, "Studentul a fost adaugat cu succes!");
                AdaugareStudent(); // Invoke the registration logic
            }
        });
        inregistrareStudentiPanel.add(registerButton2);

        JButton StergereStudbuttonent = new JButton("Stergere Student");
        StergereStudbuttonent.setBounds(100, 350, 150, 50);
        StergereStudbuttonent.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                dispose();
                StergereStudent stergereStudent = new StergereStudent();
                stergereStudent.setVisible(true);
            }
        });

        inregistrareStudentiPanel.add(StergereStudbuttonent, BorderLayout.CENTER);
        tabbedPane.addTab("Inregistrare Studenti", inregistrareStudentiPanel);


        // Afisare Cursuri tab
        JPanel afisareCursuriPanel = new JPanel();
        afisareCursuriPanel.setLayout(new BorderLayout());  // Use BorderLayout for better layout management


        JPanel searchPanelCursuri = new JPanel();
        searchPanelCursuri.setLayout(new BoxLayout(searchPanelCursuri, BoxLayout.Y_AXIS));


        JLabel numeCursLabel = new JLabel("Nume curs: ");
        searchPanelCursuri.add(numeCursLabel);

        JTextField cautareCursTextField = new JTextField();
        cautareCursTextField.setPreferredSize(new Dimension(156, 30));
        searchPanelCursuri.add(cautareCursTextField);

        JButton searchCursButton = new JButton("Cauta");
        searchPanelCursuri.add(searchCursButton);
        afisareCursuriPanel.add(searchPanelCursuri, BorderLayout.NORTH);

        JPanel cursDetailsPanel = new JPanel();
        cursDetailsPanel.setLayout(new FlowLayout(FlowLayout.LEFT));  // Adjust the layout as needed
        afisareCursuriPanel.add(cursDetailsPanel, BorderLayout.SOUTH);

        Vector<Vector<Object>> cursData = new Vector<>();


        Vector<Object> curs1 = new Vector<>(Arrays.asList(1, 3, "Sisteme de operare", "Curs de sisteme de operare", 30));
        Vector<Object> curs2 = new Vector<>(Arrays.asList(2, 2, "Alogoritmi Fundamentali", "Curs introductiv in alogoritmi", 25));
        Vector<Object> curs3 = new Vector<>(Arrays.asList(3, 1, "Analiza", "Curs de analiza numerica", 25));
        Vector<Object> curs4 = new Vector<>(Arrays.asList(4, 4, "Matematica", "Curs de matematica avansata", 30));
        Vector<Object> curs5 = new Vector<>(Arrays.asList(5, 5, "Fizica", "Curs de fizica cuantica", 25));

        cursData.add(curs1);
        cursData.add(curs2);
        cursData.add(curs3);
        cursData.add(curs4);
        cursData.add(curs5);

        DefaultTableModel modelCurs = new DefaultTableModel(new Object[]{"ID_Profesor", "Nume Curs", "Descriere Curs", "Maxim Studenti"}, 0);
        JTable cursuriTable = new JTable(modelCurs);


        searchCursButton.addActionListener(e -> {
            String searchedCurs = cautareCursTextField.getText();
            Vector<Object> cursDetails = searchCursByName(searchedCurs, cursData);


            displayCursDetails(cursDetails, cursDetailsPanel);
        });

        try (Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/platformaStudiu", "root", "rootroot")) {
            String query = "CALL VizualizareCursuri()";
            try (PreparedStatement statement = conn.prepareStatement(query)) {
                try (ResultSet resultSet = statement.executeQuery()) {
                    while (resultSet.next()) {
                        Vector<Object> row = new Vector<>();
                        row.add(resultSet.getInt("ID_Curs"));
                        row.add(resultSet.getInt("ID_Profesor"));
                        row.add(resultSet.getString("Nume"));
                        row.add(resultSet.getString("Descriere"));
                        row.add(resultSet.getInt("MaxStudenti"));
                        modelCurs.addRow(row);
                    }
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        JScrollPane scrollPaneCurs = new JScrollPane(cursuriTable);
        afisareCursuriPanel.add(scrollPaneCurs, BorderLayout.CENTER);

        String[] profesori = {"Alege Profesor","Pop Vasile", "Potolea Rodica", "Oprisa Ciprian",
                "Popa Ana", "Radu Alexandru"};


        JComboBox<String> profesoriDropdown = new JComboBox<>(profesori);
        profesoriDropdown.setBounds(100, 100, 100, 100);
        //profesoriDropdown.setLayout(new FlowLayout());
        searchPanelCursuri.add(profesoriDropdown);

        String[] cursuri = {"Alege Curs","Analiza Matematica", "Curs introductiv in alogoritmi", "Curs de analiza numerica",
                "Curs de matematica avansata", "Curs de fizica cuantica", "Curs de Java", "Curs de SGBD",
                "Curs de procesoare", "Curs de limbaj de asamblare", "Curs de automate"};


        JComboBox<String> cursuriDropdown = new JComboBox<>(cursuri);
        cursuriDropdown.setBounds(100, 100, 100, 100);
        //cursuriDropdown.setLayout(new FlowLayout());
        searchPanelCursuri.add(cursuriDropdown);

        JButton asignare = new JButton("Asignare Profesor-Curs");
        asignare.setSize(30, 30);
        asignare.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String profesorSelectat = (String) profesoriDropdown.getSelectedItem();
                String cursSelectat = (String) cursuriDropdown.getSelectedItem();


                if (!"Alege Profesor".equals(profesorSelectat) && !"Alege Curs".equals(cursSelectat)) {

                    JOptionPane.showMessageDialog(afisareCursuriPanel, "Profesorului " + profesorSelectat + " i-a fost asignat cursul " + cursSelectat);
                } else {

                    JOptionPane.showMessageDialog(afisareCursuriPanel, "Selectați un profesor și un curs!");
                }
            }
        });
        searchPanelCursuri.add(asignare, BorderLayout.SOUTH);

        tabbedPane.addTab("Afisare Cursuri", afisareCursuriPanel);

// Inregistrare Administrator tab
        JPanel inregistrareAdministratorPanel = new JPanel();
        inregistrareAdministratorPanel.setLayout(new GridLayout(13, 2));

// Create labels and text fields for the registration form
        inregistrareAdministratorPanel.add(new JLabel("CNP:"));
        JTextField cnpAdministratorTextField = new JTextField();
        inregistrareAdministratorPanel.add(cnpAdministratorTextField);

        inregistrareAdministratorPanel.add(new JLabel("Nume:"));
        JTextField numeAdministratorTextField = new JTextField();
        inregistrareAdministratorPanel.add(numeAdministratorTextField);

        inregistrareAdministratorPanel.add(new JLabel("Prenume:"));
        JTextField prenumeAdministratorTextField = new JTextField();
        inregistrareAdministratorPanel.add(prenumeAdministratorTextField);

        inregistrareAdministratorPanel.add(new JLabel("Adresa:"));
        JTextField adresaAdministratorTextField = new JTextField();
        inregistrareAdministratorPanel.add(adresaAdministratorTextField);

        inregistrareAdministratorPanel.add(new JLabel("Telefon:"));
        JTextField telefonAdministratorTextField = new JTextField();
        inregistrareAdministratorPanel.add(telefonAdministratorTextField);

        inregistrareAdministratorPanel.add(new JLabel("Email:"));
        JTextField emailAdministratorTextField = new JTextField();
        inregistrareAdministratorPanel.add(emailAdministratorTextField);

        inregistrareAdministratorPanel.add(new JLabel("IBAN:"));
        JTextField ibanAdministratorTextField = new JTextField();
        inregistrareAdministratorPanel.add(ibanAdministratorTextField);

        inregistrareAdministratorPanel.add(new JLabel("Numar Contract:"));
        JTextField contractAdministratorTextField = new JTextField();
        inregistrareAdministratorPanel.add(contractAdministratorTextField);

        inregistrareAdministratorPanel.add(new JLabel("Username:"));
        JTextField adminUsernameField = new JTextField();
        inregistrareAdministratorPanel.add(adminUsernameField);

        inregistrareAdministratorPanel.add(new JLabel("Parola:"));
        JPasswordField adminPasswordField = new JPasswordField();
        inregistrareAdministratorPanel.add(adminPasswordField);


        JButton registerAdminButton = new JButton("Înregistrare");
        registerAdminButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e)
            {
                JOptionPane.showMessageDialog(null, "Administratorul a fost adaugat cu succes!");
                AdaugareAdministrator();
            }
        });
        inregistrareAdministratorPanel.add(registerAdminButton);
        tabbedPane.addTab("Inregistrare Administrator", inregistrareAdministratorPanel);

        JButton StergereAdminbuttonent = new JButton("Stergere Admin");
        StergereAdminbuttonent.setBounds(100, 350, 150, 50);
        StergereAdminbuttonent.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                dispose();
                StergereAdmin stergereAdmin= new StergereAdmin();
                stergereAdmin.setVisible(true);
            }
        });

        inregistrareAdministratorPanel.add(StergereAdminbuttonent, BorderLayout.CENTER);
        // Main panel
        JPanel mainPanel = new JPanel(new BorderLayout());
        mainPanel.add(tabbedPane, BorderLayout.CENTER);

        JLabel numeLabel = new JLabel("Bună SuperAdministrator, "+numele+"!");
        numeLabel.setForeground(Color.red);

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


    private void populateTable(DefaultTableModel model, JTable table, Vector<Vector<Object>> data) {
        for (Vector<Object> row : data) {
            model.addRow(row);
        }
    }

    private Vector<Object> searchStudentByName(String name, Vector<Vector<Object>> data) {
        for (Vector<Object> row : data) {
            if (row.get(1).toString().equalsIgnoreCase(name)) {
                return row;
            }
        }
        return null;
    }
    private void displayStudentDetails(Vector<Object> studentDetails, JPanel detailsPanel) {
        detailsPanel.removeAll();  // Clear previous details

        if (studentDetails != null) {
            for (Object detail : studentDetails) {
                JLabel detailLabel = new JLabel(detail.toString());
                detailsPanel.add(detailLabel);
            }
        } else {
            JLabel notFoundLabel = new JLabel("Studentul nu a fost gasit.");
            detailsPanel.add(notFoundLabel);
        }

        detailsPanel.revalidate();
        detailsPanel.repaint();
    }

    private Vector<Object> searchProfesorByName(String name, Vector<Vector<Object>> data) {
        for (Vector<Object> row : data) {
            if (row.get(1).toString().equalsIgnoreCase(name)) {
                return row;
            }
        }
        return null;
    }

    // Function to display profesor details in the details panel
    private void displayProfesorDetails(Vector<Object> profesorDetails, JPanel detailsPanel) {
        detailsPanel.removeAll();

        if (profesorDetails != null) {
            for (Object detail : profesorDetails) {
                JLabel detailLabel = new JLabel(detail.toString());
                detailsPanel.add(detailLabel);
            }
        } else {
            JLabel notFoundLabel = new JLabel("Profesorul nu a fost gasit.");
            detailsPanel.add(notFoundLabel);
        }

        detailsPanel.revalidate();
        detailsPanel.repaint();
    }

    private void AdaugareStudent() {

        try {
            Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/platformaStudiu", "root", "rootroot");

            String procedura = "{CALL AdaugaStudenti(?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)}";

            try (CallableStatement stmt = conn.prepareCall(procedura)) {
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
    private void AdaugareProfesor()
    {
        try {
            Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/platformaStudiu", "root", "rootroot");

            String procedura = "{CALL AdaugaProfesor(?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)}";

            try (PreparedStatement stmt = conn.prepareCall(procedura)) {
                stmt.setString(1, cnpField2.getText());
                stmt.setString(2, numeField2.getText());
                stmt.setString(3, prenumeField2.getText());
                stmt.setString(4, adresaField2.getText());
                stmt.setString(5, telefonField2.getText());
                stmt.setString(6, emailField2.getText());
                stmt.setString(7, contIbanField2.getText());
                stmt.setInt(8, Integer.parseInt(numarContractField2.getText()));
                stmt.setString(9, cursuriPredateField2.getText());
                stmt.setString(10, departamentField2.getText());
                stmt.setInt(11, Integer.parseInt(minimOreField2.getText()));
                stmt.setInt(12, Integer.parseInt(maximOreField2.getText()));
                stmt.setString(13, usernameField2.getText());
                stmt.setString(14, new String(passwordField2.getPassword()));

                stmt.executeUpdate();
            }

            conn.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
    private void AdaugareAdministrator()
    {
        try {
            Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/platformaStudiu", "root", "rootroot");

            String procedura = "{CALL AdaugaAdministrator(?, ?, ?, ?, ?, ?, ?, ?, ?, ?)}";

            try (PreparedStatement stmt = conn.prepareCall(procedura)) {
                stmt.setString(1, cnpField3.getText());
                stmt.setString(2, numeField3.getText());
                stmt.setString(3, prenumeField3.getText());
                stmt.setString(4, adresaField3.getText());
                stmt.setString(5, telefonField3.getText());
                stmt.setString(6, emailField3.getText());
                stmt.setString(7, contIbanField3.getText());
                stmt.setInt(8, Integer.parseInt(numarContractField3.getText()));
                stmt.setString(9, usernameField3.getText());
                stmt.setString(10, new String(passwordField3.getPassword()));

                stmt.executeUpdate();
            }

            conn.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }


    private Vector<Object> searchCursByName(String searchedCurs, Vector<Vector<Object>> cursData) {
        Vector<Object> result = new Vector<>();

        for (Vector<Object> curs : cursData) {
            String numeCurs = curs.get(2).toString(); // Assuming the name is in the third column
            if (numeCurs.equalsIgnoreCase(searchedCurs)) {
                result = curs;
                break;
            }
        }

        return result;
    }

    private void displayCursDetails(Vector<Object> cursDetails, JPanel cursDetailsPanel) {
        cursDetailsPanel.removeAll();

        if (cursDetails != null) {
            for (Object detail : cursDetails) {
                JLabel detailLabel = new JLabel(detail.toString());
                cursDetailsPanel.add(detailLabel);
            }
        } else {
            JLabel notFoundLabel = new JLabel("Profesorul nu a fost gasit.");
            cursDetailsPanel.add(notFoundLabel);
        }

        cursDetailsPanel.revalidate();
        cursDetailsPanel.repaint();
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> new AfisareDateSuperAdministrator("AndronesiAna"));
    }
}
class StergereAdmin extends JFrame {
    private Vector<Vector<Object>> studentData = new Vector<>();
    private JTable dateContTable2;
    public StergereAdmin() {
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(new Dimension(800, 600));
        setTitle("Stergere Administratori");

        Vector<Object> student1 = new Vector<>(Arrays.asList("9012345678901", "Dragomir", "Alina", "Bulevardul Iancu de Hunedoara nr. 12", "0790123456", "alina.dragomir@example.com"));
        Vector<Object> student2 = new Vector<>(Arrays.asList("8901234567890", "Popescu", "Ionel", "Strada Libertatii nr. 5", "0789012345", "ionel.popescu@example.com"));
        Vector<Object> student3 = new Vector<>(Arrays.asList("7890123456789", "Ionescu", "Ana", "Calea Dorobantilor nr. 40", "0778901234", "ana.ionescu@example.com"));
        Vector<Object> student4 = new Vector<>(Arrays.asList("5678901234567", "Dumitrescu", "Elena", "Bulevardul Unirii nr. 30", "0756789012", "elena.dumitrescu@example.com"));
        Vector<Object> student5 = new Vector<>(Arrays.asList("6789012345678", "Constantin", "Mihai", "Strada Victoriei nr. 25", "0767890123", "mihai.constantin@example.com"));
        Vector<Object> student6 = new Vector<>(Arrays.asList("6011231231230", "Vasilescu", "Olguta", "Strada Garii,Nr.1082", "078889871", "olgutaSuper@email.com"));


        studentData.add(student1);
        studentData.add(student2);
        studentData.add(student3);
        studentData.add(student4);
        studentData.add(student5);
        studentData.add(student6);

        DefaultTableModel model2 = new DefaultTableModel(new Object[]{"CNP_Admin", "Nume", "Prenume", "Adresa", "Telefon", "Email"}, 0);

        // Adaugă datele la modelul tabelului
        for (Vector<Object> student : studentData) {
            model2.addRow(student);
        }

        JTable dateContTable2 = new JTable(model2);
        JPanel buttonPanel = new JPanel(new FlowLayout(FlowLayout.LEFT));


        JScrollPane scrollPane = new JScrollPane(dateContTable2);


        // Adaugă butonul de ștergere la fiecare rând
        TableColumn column = dateContTable2.getColumnModel().getColumn(model2.getColumnCount() - 1);
        column.setCellRenderer(new ButtonRenderer());
        column.setCellEditor(new ButtonEditor(new JCheckBox(), dateContTable2));


        JButton backButton = new JButton("Back");
        backButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                dispose();

                PaginaLogare logareUI = new PaginaLogare();
                logareUI.setVisible(true);
                setVisible(false);
            }
        });
        buttonPanel.add(backButton);


        getContentPane().setLayout(new BorderLayout());
        getContentPane().add(buttonPanel, BorderLayout.NORTH);
        getContentPane().add(scrollPane, BorderLayout.CENTER);

        pack();
        setLocationRelativeTo(null);
        setVisible(true);
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> new StergereAdmin());
    }
}
