package view.AdminGUI;
import javax.swing.*;
import java.awt.event.ActionListener;

public class AdminMenuGUI extends JFrame {

    JFrame frame = new JFrame("Admin Menu");
    private JButton vizualizareUtilizatoriButton = new JButton("Vizualizare Utilizatori");
    private JButton documenteButton = new JButton("Adaugare / Stergere Documente");
    private JButton requestButton = new JButton ("Manager Request-uri");
    private JLabel adminLabel = new JLabel("MENIU ADMIN");

    public AdminMenuGUI(){

        frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        frame.setSize(600,600);

        JPanel panel = new JPanel();

        adminLabel.setBounds(260,25,200,20);
        vizualizareUtilizatoriButton.setBounds(175,100,250,50);
        documenteButton.setBounds(175,250,250,50);
        requestButton.setBounds(175,400,250,50);

        frame.add(adminLabel);
        frame.add(vizualizareUtilizatoriButton);
        frame.add(documenteButton);
        frame.add(requestButton);
        frame.add(panel);

    }

    public JFrame getFrame() {
        return frame;
    }


    public void vizualizareUtilizatoriButtonListener (ActionListener e){vizualizareUtilizatoriButton.addActionListener(e);}
    public void documenteButtonListener (ActionListener e){documenteButton.addActionListener(e);}
    public void requestButtonListener(ActionListener e){requestButton.addActionListener(e);}

}
