package view.UserGUI;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.event.ActionListener;

public class ListaCereriGUI extends JFrame {


    private JFrame frame = new JFrame("Adauga sau sterge documente");
    private JTable jt;
    private DefaultTableModel model;
    private JPanel panel = new JPanel();
    private String[] columnNames = {"Nume Documente"};
    private String[][] availableDocs;

    public void initialize(){
        this.frame.setSize(600,600);
        this.frame.setDefaultCloseOperation(DISPOSE_ON_CLOSE);
        this.model = new DefaultTableModel(availableDocs, columnNames);
        this.jt = new JTable(model);
        this.frame.add(panel);
        this.frame.add(jt);

    }

    public JFrame getFrame() {
        return frame;
    }

    public void setAvailableDocs(String[][] availableDocs) {
        this.availableDocs = availableDocs;
    }
}
