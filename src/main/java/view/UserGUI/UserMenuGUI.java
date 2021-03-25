package view.UserGUI;

import javax.swing.*;
import java.awt.event.ActionListener;

public class UserMenuGUI {

    JFrame frame = new JFrame("Admin Menu");
    private JButton adaugareStergereLocuinteButton = new JButton("Adaugare / Stergere Locuinte");
    private JButton requestButton = new JButton ("Manager Request-uri");
    private JLabel adminLabel = new JLabel("MENIU USER");

    public UserMenuGUI(){

        frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        frame.setSize(600,600);

        JPanel panel = new JPanel();

        adminLabel.setBounds(260,25,200,20);
        adaugareStergereLocuinteButton.setBounds(175,100,250,50);
        requestButton.setBounds(175,400,250,50);

        frame.add(adminLabel);
        frame.add(adaugareStergereLocuinteButton);
        frame.add(requestButton);
        frame.add(panel);

    }

    public JFrame getFrame() {
        return frame;
    }
    public void adaugaStergeLocuinteButtonListener (ActionListener e){
        adaugareStergereLocuinteButton.addActionListener(e);}
    public void requestButtonListener(ActionListener e){requestButton.addActionListener(e);}

}
