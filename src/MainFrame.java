import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class MainFrame extends JFrame {
    private int screenW = Toolkit.getDefaultToolkit().getScreenSize().width;
    private int screenh = Toolkit.getDefaultToolkit().getScreenSize().height;
    private JMenuBar jmb = new JMenuBar();
    private JMenu jmm = new JMenu("Flie");
    private JMenuItem jmie = new  JMenuItem("Exit");
    private JMenu jmloto = new  JMenu("loto");
    private JDesktopPane jdp = new JDesktopPane();
    private JInternalFrame jInternalFrame = new JInternalFrame();
    private int frmw = 500, frmh = 450;
    private LoginFrame loginFrame;
    public MainFrame(LoginFrame login){
        loginFrame = login;
        initComp();
    }
private void initComp(){
        this.setBounds(screenW/2 - frmw/2,screenh/2 - frmh/2,frmw,frmh);
        this.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        this.setJMenuBar(jmb);
        jmb.add(jmm);
        jmm.add(jmie);
        jmb.add(jmloto);
    jInternalFrame.setBounds(0,0,200,80);
        jmloto.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                jdp.add(jInternalFrame);
                jInternalFrame.setVisible(true);
            }
        });
        jmie.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                System.exit(0);
            }
        });
         jmie.setAccelerator(KeyStroke.getKeyStroke('X',Toolkit.getDefaultToolkit().getMenuShortcutKeyMask()));
    }
}



