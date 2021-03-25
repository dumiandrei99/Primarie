package view.UserGUI;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.event.ActionListener;

public class AdaugaStergeLocuinteGUI extends JFrame {

    private JFrame frame = new JFrame("Adauga sau sterge locuinte");
    private JButton adaugaButton = new JButton ("Adauga Locuinta");
    private JButton stergeButton = new JButton("Sterge Locuinta");
    private JLabel label = new JLabel ("Introduceti in chenar adresa locuintei pe care doriti sa o adaugati / stergeti");
    private JLabel label2 = new JLabel (" si apasati butonul corespunzator actiunii pe care doriti sa o efectuati!");
    private JLabel outputResult = new JLabel("");
    private JTable jt;
    private DefaultTableModel model;
    private JTextField inputField = new JTextField(50);
    private JPanel panel = new JPanel();

    private String[] columnNames = {"ADRESA LOCUINTA"};
    private String[][] locuinte;

    public void initialize(){
        this.frame.setSize(600,600);
        this.frame.setDefaultCloseOperation(DISPOSE_ON_CLOSE);
        this.model = new DefaultTableModel(locuinte, columnNames);
        this.jt = new JTable(model);
        this.label.setBounds(60,375,500,20);
        this.label2.setBounds(75,400,500,20);
        this.outputResult.setBounds(175,325,500,20);
        this.adaugaButton.setBounds(50,450,150,20);
        this.stergeButton.setBounds(350,450,150,20);
        this.inputField.setBounds(150,500,250,20);
        this.inputField.setEditable(true);

        this.frame.add(label);
        this.frame.add(label2);
        this.frame.add(adaugaButton);
        this.frame.add(stergeButton);
        this.frame.add(inputField);
        this.frame.add(outputResult);
        this.frame.add(panel);
        this.frame.add(jt);

    }

    public void updateViewAfterInsert(){
        model.addRow(locuinte[locuinte.length-1]);
    }
    public void updateViewAfterDelete(int index){ model.removeRow(index);}

    public JFrame getFrame() {
        return frame;
    }

    public void setLocuinte(String[][] locuinte) {
        this.locuinte = locuinte;
    }

    public String getInputField() {
        return inputField.getText();
    }

    public void setOutputResult(String result){
        this.outputResult.setText(result);
    }

    public void adaugaButtonListener(ActionListener e){adaugaButton.addActionListener(e);}
    public void stergeButtonListener(ActionListener e) {stergeButton.addActionListener(e);}
}
