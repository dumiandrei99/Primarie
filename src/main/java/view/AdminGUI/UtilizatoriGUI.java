package view.AdminGUI;
import javax.swing.*;


public class UtilizatoriGUI extends JFrame {

    JFrame frame = new JFrame("Vizualizare Utilizatori");
    JTable jt;

    public UtilizatoriGUI(String[][] data){
        frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        frame.setSize(600,600);
        JPanel panel = new JPanel();
        String[] columnNames = {"UUID","Username","Nume","Prenume"};
        jt = new JTable(data,columnNames);
        frame.add(panel);
        frame.add(jt);
    }

    public JFrame getFrame() {
        return frame;
    }
}
