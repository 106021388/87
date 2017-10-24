import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class LoginFrame extends JFrame {
    private JLabel jlbID = new JLabel("ID");
    private JLabel jlbPw = new JLabel("Passsword");
    private JTextField jtfID = new  JTextField();
    // private JTextField jtfpw = new  JTextField();
    private JPasswordField jtfpw = new JPasswordField();
    private JButton jbtnexit = new JButton("Exit");
    private JButton jbnlogin = new JButton("Login");
    private Container cp;
    private Dimension dim = Toolkit.getDefaultToolkit().getScreenSize();
    private int frmW = 300,frmH = 150, screenW,screenH;

    public LoginFrame(){
        initComp();
    }
    private void initComp() {
        screenH = dim.height;
        screenW = dim.width;
        this.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        this.setBounds(screenW/2-frmW/2,screenH/2-frmH/2,frmW,frmH);
        cp = this.getContentPane();
        cp.setLayout(new GridLayout(3,2,3,3));
        jlbID.setHorizontalAlignment(SwingConstants.RIGHT);
        jlbPw.setHorizontalAlignment(SwingConstants.RIGHT);
        jbtnexit.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                System.exit(0);
            }
        });
        jbnlogin.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if(jtfID.getText().equals("1")  &&
                        (new String(jtfpw.getPassword())).equals("1")) {
                    MainFrame mainFrame = new MainFrame(LoginFrame.this);
                    mainFrame.setVisible(true);
                    LoginFrame.this.setVisible(false);
                } else{
                    JOptionPane.showMessageDialog(LoginFrame.this,"Error");
                    System.out.print("no"+jtfID.getText() + "\tpw");
                }
            }

        });
        cp.add(jlbID);
        cp.add(jtfID);
        cp.add(jlbPw);
        cp.add(jtfpw);
        cp.add(jbtnexit);
        cp.add(jbnlogin);
    }
}