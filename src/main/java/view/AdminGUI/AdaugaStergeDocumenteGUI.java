package view.AdminGUI;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableModel;
import java.awt.*;
import java.awt.event.ActionListener;
import java.util.Arrays;

public class AdaugaStergeDocumenteGUI extends JFrame {

    private JFrame frame = new JFrame("Adauga sau sterge documente");
    private JButton adaugaButton = new JButton ("Adauga Document");
    private JButton stergeButton = new JButton("Sterge Document");
    private JLabel label = new JLabel ("Introduceti in chenar numele documentului pe care doriti sa-l adaugati / stergeti");
    private JLabel label2 = new JLabel (" si apasati butonul corespunzator actiunii pe care doriti sa o efectuati!");
    private JLabel outputResult = new JLabel("");
    private JTable jt;
    private DefaultTableModel model;
    private JTextField inputField = new JTextField(50);
    private JPanel panel = new JPanel();

    private String[] columnNames = {"Nume Documente"};
    private String[][] availableDocs;

    public void initialize(){
        this.frame.setSize(600,600);
        this.frame.setDefaultCloseOperation(DISPOSE_ON_CLOSE);
        this.model = new DefaultTableModel(availableDocs, columnNames);
        this.jt = new JTable(model);
        this.label.setBounds(50,375,500,20);
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
        model.addRow(availableDocs[availableDocs.length-1]);
    }

    public void updateViewAfterDelete(int index){ model.removeRow(index);
    }

    public JFrame getFrame() {
        return frame;
    }

    public void setAvailableDocs(String[][] availableDocs) {
        this.availableDocs = availableDocs;
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
