import com.toedter.calendar.JDateChooser;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.*;
import java.text.SimpleDateFormat;

public class ProgramareActivitateProf extends JFrame {
    private static String idCurs;
    private static int idProf;
    private static int idcu;
    public ProgramareActivitateProf(String idCurs,int idProf,int idcu) {
        this.idCurs=idCurs;
        this.idProf=idProf;
        setTitle("PROGRAMEAZĂ");
        setSize(800, 600);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(null);

        JLabel titleLabel = new JLabel("PROGRAMEAZĂ:");
        titleLabel.setFont(new Font("Arial", Font.PLAIN, 23));
        titleLabel.setBounds(59, 22, 200, 100);
        add(titleLabel);

        JLabel numeCLabel = new JLabel("Nume curs: ");
        numeCLabel.setFont(new Font("Arial", Font.PLAIN, 23));
        numeCLabel.setBounds(59, 80, 250, 100);
        add(numeCLabel);
        JComboBox<String> cursComboBox = new JComboBox<>();
        cursComboBox.setBounds(200, 118, 150, 30);
        cursComboBox.addItem(idCurs);
        if(idProf<4){
            cursComboBox.addItem("Circuite");
        }
        else{
            cursComboBox.addItem("Geometrie");
        }
        add(cursComboBox);
        JComboBox<String> activitateComboBox = new JComboBox<>();
        activitateComboBox.setBounds(200, 173, 150, 30);
        activitateComboBox.addItem("Curs");
        activitateComboBox.addItem("Seminar");
        activitateComboBox.addItem("Laborator");
        add(activitateComboBox);

        JLabel activitateLabel = new JLabel("Activitate:");
        activitateLabel.setFont(new Font("Arial", Font.PLAIN, 23));
        activitateLabel.setBounds(59, 138, 101, 100);
        add(activitateLabel);

        JLabel dataiLabel = new JLabel("Data Inceput:");
        dataiLabel.setFont(new Font("Arial", Font.PLAIN, 23));
        dataiLabel.setBounds(59, 203, 200, 100);
        add(dataiLabel);

        JComboBox<String> ora1ComboBox = new JComboBox<>();
        ora1ComboBox.setBounds(370, 238, 150, 30);
        add(ora1ComboBox);
        ora1ComboBox.addItem("Selectați oră");
        ora1ComboBox.addItem("08:00");
        ora1ComboBox.addItem("08:30");
        ora1ComboBox.addItem("09:00");
        ora1ComboBox.addItem("09:30");
        ora1ComboBox.addItem("10:00");
        ora1ComboBox.addItem("10:30");
        ora1ComboBox.addItem("11:00");
        ora1ComboBox.addItem("11:30");
        ora1ComboBox.addItem("12:00");
        ora1ComboBox.addItem("12:30");
        ora1ComboBox.addItem("13:00");
        ora1ComboBox.addItem("13:30");
        ora1ComboBox.addItem("14:00");
        ora1ComboBox.addItem("14:30");
        ora1ComboBox.addItem("15:00");
        ora1ComboBox.addItem("15:30");
        ora1ComboBox.addItem("16:00");
        ora1ComboBox.addItem("16:30");
        ora1ComboBox.addItem("17:00");
        ora1ComboBox.addItem("17:30");
        ora1ComboBox.addItem("18:00");
        ora1ComboBox.addItem("18:30");
        ora1ComboBox.addItem("19:00");
        ora1ComboBox.addItem("19:30");
        ora1ComboBox.addItem("20:00");
        ora1ComboBox.addItem("20:30");
        ora1ComboBox.addItem("21:00");
        ora1ComboBox.addItem("21:30");

        JComboBox<String> ora2ComboBox = new JComboBox<>();
        ora2ComboBox.setBounds(370, 303, 150, 30);
        add(ora2ComboBox);
        ora2ComboBox.addItem("Selectați oră");
        ora2ComboBox.addItem("08:00");
        ora2ComboBox.addItem("08:30");
        ora2ComboBox.addItem("09:00");
        ora2ComboBox.addItem("09:30");
        ora2ComboBox.addItem("10:00");
        ora2ComboBox.addItem("10:30");
        ora2ComboBox.addItem("11:00");
        ora2ComboBox.addItem("11:30");
        ora2ComboBox.addItem("12:00");
        ora2ComboBox.addItem("12:30");
        ora2ComboBox.addItem("13:00");
        ora2ComboBox.addItem("13:30");
        ora2ComboBox.addItem("14:00");
        ora2ComboBox.addItem("14:30");
        ora2ComboBox.addItem("15:00");
        ora2ComboBox.addItem("15:30");
        ora2ComboBox.addItem("16:00");
        ora2ComboBox.addItem("16:30");
        ora2ComboBox.addItem("17:00");
        ora2ComboBox.addItem("17:30");
        ora2ComboBox.addItem("18:00");
        ora2ComboBox.addItem("18:30");
        ora2ComboBox.addItem("19:00");
        ora2ComboBox.addItem("19:30");
        ora2ComboBox.addItem("20:00");
        ora2ComboBox.addItem("20:30");
        ora2ComboBox.addItem("21:00");
        ora2ComboBox.addItem("21:30");

        JDateChooser dateChooser1 = new JDateChooser();
        dateChooser1.setBounds(200, 238, 150, 30);
        add(dateChooser1);

        JDateChooser dateChooser2 = new JDateChooser();
        dateChooser2.setBounds(200, 303, 150, 30);
        add(dateChooser2);

        JLabel datasLabel = new JLabel("Data Sfarsit:");
        datasLabel.setFont(new Font("Arial", Font.PLAIN, 23));
        datasLabel.setBounds(59, 270, 200, 100);
        add(datasLabel);

        JLabel nrMaxLabel = new JLabel("Nr.max:");
        nrMaxLabel.setFont(new Font("Arial", Font.PLAIN, 23));
        nrMaxLabel.setBounds(59, 341, 82, 100);
        add(nrMaxLabel);

        JTextField nrMaxTextField = new JTextField();
        nrMaxTextField.setBounds(200, 376, 150, 30);
        add(nrMaxTextField);

        setVisible(true);

        JButton programeazaButton = new JButton("Programează");
        programeazaButton.setBounds(480, 400, 200, 100);
        add(programeazaButton);

        JButton backButton = new JButton("Back");
        backButton.setBounds(680, 420, 100, 75);
        add(backButton);
        programeazaButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

                String activity=(String)activitateComboBox.getSelectedItem();
                java.util.Date start = (java.util.Date) dateChooser1.getDate();

                SimpleDateFormat dateFormat1 = new SimpleDateFormat("dd-MM-yyyy");
                String DATAS = dateFormat1.format(start);
                java.util.Date stop = (java.util.Date) dateChooser2.getDate();
                SimpleDateFormat dateFormat2 = new SimpleDateFormat("dd-MM-yyyy");
                String DATAF = dateFormat2.format(stop);
                String ORAS=(String)ora1ComboBox.getSelectedItem();
                String ORAF=(String)ora2ComboBox.getSelectedItem();
                int nrMax = Integer.parseInt(nrMaxTextField.getText());
                String selectedCurs = (String) cursComboBox.getSelectedItem();
                try (Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/platformaStudiu", "root", "rootroot")) {

                    String callProcedure = "{CALL ProgramareActivitate(?,?,?,?,?,?,?)}";
                    try (CallableStatement callStatement = conn.prepareCall(callProcedure)) {
                        callStatement.setString(1, String.valueOf(6));
                        callStatement.setString(2,activity);
                        callStatement.setString(3,DATAS);
                        callStatement.setString(4,DATAF);
                        callStatement.setString(5,ORAS);
                        callStatement.setString(6,ORAF);
                        callStatement.setString(7, String.valueOf(nrMax));
                        callStatement.executeUpdate();

                        // Verifică dacă activitatea a fost adăugată cu succes
                        if (nrMax > 0) {
                            JOptionPane.showMessageDialog(null, "Activitate adaugată cu succes!");
                        } else {
                            JOptionPane.showMessageDialog(null, "Activitatea nu a putut fi adăugată.");
                        }
                    }
                } catch (SQLException ex) {
                    ex.printStackTrace();
                }
            }
        });

        backButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                dispose();
                PaginaLogare logareUI = new PaginaLogare();
                logareUI.setVisible(true);
            }
        });

    }
    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> new ProgramareActivitateProf(idCurs,idProf,idcu));
    }
}
