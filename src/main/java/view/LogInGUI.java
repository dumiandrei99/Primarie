package view;
import javax.swing.*;
import java.awt.event.ActionListener;


public class LogInGUI extends JFrame{

    JFrame frame = new JFrame("Log In Aplicatie Primarie");
    private JButton loginButton = new JButton("Log-In");
    private JButton registerButton = new JButton("Inregistrare");
    private JLabel usernameLabel = new JLabel("Username:");
    private JLabel passwordLabel = new JLabel("Password:");
    private JLabel connection = new JLabel ("");
    private JTextField enterUserName = new JTextField(50);
    private JPasswordField enterPassword = new JPasswordField(50);

    public LogInGUI(){

        frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        frame.setSize(600,600);

        JPanel panel = new JPanel();

        connection.setBounds(50,100,600,20);
        loginButton.setBounds(250,300,100,20);
        registerButton.setBounds(250,340,100,20);
        usernameLabel.setBounds(50,200,100,20);
        passwordLabel.setBounds(50,250,100,20);
        enterUserName.setBounds(175,200,250,20);
        enterPassword.setBounds(175,250,250,20);

        frame.add(connection);
        frame.add(enterUserName);
        frame.add(enterPassword);
        frame.add(usernameLabel);
        frame.add(passwordLabel);
        frame.add(registerButton);
        frame.add(loginButton);
        frame.add(panel);

        frame.show();
    }


    public String getEnterUserName() {
        return enterUserName.getText();
    }

    public String getEnterPassword() {
        String pass = new String("");
        for(char i : enterPassword.getPassword()) {
            pass += i;
        }
        return pass;
    }

    public void setConnection(String connection) {
        this.connection.setText(connection);
    }
    public void loginButtonListener(ActionListener e){loginButton.addActionListener(e);}
    public void registerButtonListener(ActionListener e){registerButton.addActionListener(e);}

    public JFrame getFrame() {
        return frame;
    }
}
