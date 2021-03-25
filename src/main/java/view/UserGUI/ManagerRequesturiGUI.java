package view.UserGUI;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.event.ActionListener;

public class ManagerRequesturiGUI extends JFrame {

    private JFrame frame = new JFrame("Manager Requesturi");
    private JButton adaugaButton = new JButton ("Adauga Request");
    private JButton stergeButton = new JButton("Sterge Request");
    private JLabel outputResult = new JLabel("");
    private JLabel adresaLabel = new JLabel ("Adresa (Adauga Request):");
    private JLabel tipCerereLabel = new JLabel("Tip Cerere (Adauga Request):");
    private JLabel idLabel = new JLabel ("ID (Stergere Request):");
    private JTextField inputAdresaField = new JTextField(50);
    private JTextField inputTipCerereField = new JTextField(50);
    private JTextField inputIdField = new JTextField(50);
    private JTable jt;
    private DefaultTableModel model;
    private JPanel panel = new JPanel();

    private String[] columnNames = {"Id Cerere", "Tip Cerere","Data","Adresa","Numar Cereri","Aprobare"};
    private String[][] cereri;

    public void initialize(){
        this.frame.setSize(900,900);
        this.frame.setDefaultCloseOperation(DISPOSE_ON_CLOSE);
        this.model = new DefaultTableModel(cereri, columnNames);
        this.jt = new JTable(model);
        this.outputResult.setBounds(175,325,500,20);
        this.adaugaButton.setBounds(200,400,150,20);
        this.stergeButton.setBounds(600,400,150,20);
        this.adresaLabel.setBounds(150,450,200,20);
        this.tipCerereLabel.setBounds(150,475,200,20);
        this.idLabel.setBounds(150,500,200,20);
        this.inputAdresaField.setBounds(400,450,200,20);
        this.inputTipCerereField.setBounds(400,475,200,20);
        this.inputIdField.setBounds(400,500,200,20);

        this.frame.add(inputAdresaField);
        this.frame.add(inputTipCerereField);
        this.frame.add(inputIdField);
        this.frame.add(adresaLabel);
        this.frame.add(tipCerereLabel);
        this.frame.add(idLabel);
        this.frame.add(adaugaButton);
        this.frame.add(stergeButton);
        this.frame.add(outputResult);
        this.frame.add(panel);
        this.frame.add(jt);

    }

    public void updateViewAfterInsert(){
        model.addRow(cereri[cereri.length-1]);
    }

    public JFrame getFrame() {
        return frame;
    }

    public void setCereri(String[][] cereri) {
        this.cereri = cereri;
    }

    public void setOutputResult(String result){
        this.outputResult.setText(result);
    }
    public void updateViewAfterDelete(int index){ model.removeRow(index);}
    public void adaugaButtonListener(ActionListener e){adaugaButton.addActionListener(e);}
    public void stergeButtonListener(ActionListener e) {stergeButton.addActionListener(e);}

    public String getInputAdresaField() {
        return inputAdresaField.getText();
    }

    public String getInputTipCerereField() {
        return inputTipCerereField.getText();
    }

    public String getInputIdField() {
        return inputIdField.getText();
    }
}
