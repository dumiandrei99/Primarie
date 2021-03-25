package view;

import javax.swing.*;
import java.awt.event.ActionListener;

public class RegisterGUI {

    JFrame frame = new JFrame("Inregistrare");
    private JLabel label = new JLabel ("Completati toate campurile !");
    private JLabel username = new JLabel("Username");
    private JLabel password = new JLabel("Parola");
    private JLabel nume = new JLabel("Nume");
    private JLabel prenume = new JLabel("Prenume");
    private JButton inregistrare = new JButton("Inregistrare");
    private JLabel verificareInregistrare = new JLabel("");
    private JTextField enterUsername = new JTextField(50);
    private JPasswordField enterPassword = new JPasswordField(50);
    private JTextField enterNume = new JTextField(50);
    private JTextField enterPrenume = new JTextField(50);


    public RegisterGUI(){

        frame.setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);
        frame.setSize(600,600);

        JPanel panel = new JPanel();

        label.setBounds(225,25,400,20);
        username.setBounds(25,100,100,20);
        password.setBounds(25,150,100,20);
        nume.setBounds(25,200,100,20);
        prenume.setBounds(25,250,100,20);
        inregistrare.setBounds(250,400,100,50);
        verificareInregistrare.setBounds(175,350,300,20);
        enterUsername.setBounds(150,100,100,20);
        enterPassword.setBounds(150,150,100,20);
        enterNume.setBounds(150,200,100,20);
        enterPrenume.setBounds(150,250,100,20);

        frame.add(label);
        frame.add(username);
        frame.add(password);
        frame.add(nume);
        frame.add(prenume);
        frame.add(inregistrare);
        frame.add(enterUsername);
        frame.add(enterPassword);
        frame.add(enterNume);
        frame.add(enterPrenume);
        frame.add(verificareInregistrare);
        frame.add(panel);
    }

    public JFrame getFrame() {
        return frame;
    }

    public String getEnterUsername() {
        return enterUsername.getText();
    }

    public String getEnterPassword() {

        String pass = new String("");
        for(char i : enterPassword.getPassword()) {
            pass += i;
        }
        return pass;
    }

    public String getEnterNume() {
        return enterNume.getText();
    }

    public String getEnterPrenume() {
        return enterPrenume.getText();
    }

    public void setVerificareInregistrare(String verificareInregistrare) {
        this.verificareInregistrare.setText(verificareInregistrare);
    }

    public void emptyPasswordField(){
        this.enterPassword.setText("");
    }

    public void inregistrareButtonListener (ActionListener e){inregistrare.addActionListener(e);}
}
