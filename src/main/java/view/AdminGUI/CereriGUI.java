package view.AdminGUI;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.event.ActionListener;

public class CereriGUI extends JFrame {
    private JFrame frame = new JFrame("Manager Requesturi");
    private JButton acceptaButon = new JButton ("Accepta Cerere");
    private JButton stergeButton = new JButton("Sterge Cerere");
    private JLabel label = new JLabel ("Introduceti in chenar ID-ul cererii pe care doriti sa o acceptati / refuzati / stergeti");
    private JLabel label2 = new JLabel (" si apasati butonul corespunzator actiunii pe care doriti sa o efectuati!");
    private JLabel outputResult = new JLabel("");
    private JTable jt;
    private DefaultTableModel model;
    private JTextField inputField = new JTextField(50);
    private JPanel panel = new JPanel();

    private String[] columnNames = {"ID","Tip Cerere","Adresa","Status"};
    private String[][] cereri;

    public void initialize(){
        this.frame.setSize(600,600);
        this.frame.setDefaultCloseOperation(DISPOSE_ON_CLOSE);
        this.model = new DefaultTableModel(cereri, columnNames);
        this.jt = new JTable(model);
        this.label.setBounds(50,375,500,20);
        this.label2.setBounds(75,400,500,20);
        this.outputResult.setBounds(175,325,500,20);
        this.acceptaButon.setBounds(50,450,150,20);
        this.stergeButton.setBounds(350,450,150,20);
        this.inputField.setBounds(150,500,250,20);
        this.inputField.setEditable(true);

        this.frame.add(label);
        this.frame.add(label2);
        this.frame.add(acceptaButon);
        this.frame.add(stergeButton);
        this.frame.add(inputField);
        this.frame.add(outputResult);
        this.frame.add(panel);
        this.frame.add(jt);

    }

    public JFrame getFrame() {
        return frame;
    }

    public String getInputField() {
        return inputField.getText();
    }
    public void setOutputResult(String result){
        this.outputResult.setText(result);
    }
    public void setCereri(String[][] cereri) {
        this.cereri = cereri;
    }
    public void updateViewAfterDelete(int index){ model.removeRow(index);}
    public void updateViewAfterAccept(int index){ model.setValueAt("acceptat",index,3);}
    public void acceptaButtonListener(ActionListener e){acceptaButon.addActionListener(e);}
    public void stergeButtonListener(ActionListener e) {stergeButton.addActionListener(e);}
}
