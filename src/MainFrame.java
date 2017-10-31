import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class MainFrame extends JFrame {
    private int screenW = Toolkit.getDefaultToolkit().getScreenSize().width;
    private int screenh = Toolkit.getDefaultToolkit().getScreenSize().height;
    private JMenuBar jmb = new JMenuBar();
    private JMenu jmm = new JMenu("Flie");
    private JMenu jmloto = new  JMenu("loto");
    private JMenu jmset = new  JMenu("Set");
    private JMenuItem jmisetfont = new  JMenu("seting");
    private JMenuItem jmiexit = new  JMenuItem("Exit");
    private JPanel jpanel1 = new JPanel(new GridLayout(2,3,5,5));
    private JLabel jlbFontFamily = new JLabel("Family");
    private JLabel jlbFontStyle = new JLabel("Style");
    private JLabel jlbFontSize = new JLabel("Size");
    private JTextField jtfFamily = new JTextField("Times New Romans");
    private JTextField jtfSytle = new JTextField("PLAIN");
    private JTextField jtfSize = new JTextField("23");
    private String[] options ={"PLAIN","BOLD","ITALIC","BOLD+ITALIC"};
    private JComboBox jcbFStyle = new JComboBox(options);
    private JDesktopPane jdp = new JDesktopPane();
    private JInternalFrame jInternalFrame = new JInternalFrame();
    private int frmw = 500, frmh = 450;
    private LoginFrame loginFrm;
    public MainFrame(LoginFrame frm){
        loginFrm = frm;
        initComp();
    }
     private void initComp(){
        this.setBounds(screenW/2 - frmw/2,screenh/2 - frmh/2,frmw,frmh);
        this.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        this.setJMenuBar(jmb);
        jmb.add(jmm);
        jmm.add(jmiexit);
        jmb.add(jmloto);
        jmb.add(jmset);
        jmset.add(jmisetfont);

        jpanel1.setBounds(0,0,200,400);
        jpanel1.add(jlbFontFamily);
        jpanel1.add(jlbFontSize);
        jpanel1.add(jlbFontStyle);
        jpanel1.add(jtfFamily);
        jpanel1.add(jtfSize);
        jpanel1.add(jcbFStyle);


                 jmisetfont.addActionListener(new ActionListener() {
                     @Override
                     public void actionPerformed(ActionEvent actionEvent) {
                         int result = JOptionPane.showConfirmDialog(MainFrame.this, jpanel1, "Font setting", JOptionPane.OK_CANCEL_OPTION);
                         int fontstyle = 0;
                         switch (jcbFStyle.getSelectedIndex()) {
                             case 0:
                                 fontstyle = Font.PLAIN;
                                 break;
                             case 1:
                                 fontstyle = Font.BOLD;
                                 break;
                             case 2:
                                 fontstyle = Font.ITALIC;
                                 break;
                             case 3:
                                 fontstyle = Font.BOLD + Font.ITALIC;
                                 break;
                         }
                         if (result == JOptionPane.OK_OPTION) {
                             UIManager.put("Menu.font", new Font(jtfFamily.getText(), fontstyle, Integer.parseInt(jtfSize.getText())));
                         }
                     }


                 });
    jInternalFrame.setBounds(0,0,200,80);
        jmloto.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                jdp.add(jInternalFrame);
                jInternalFrame.setVisible(true);
            }
        });
        jmiexit.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                System.exit(0);
            }
        });
         jmiexit.setAccelerator(KeyStroke.getKeyStroke('X',Toolkit.getDefaultToolkit().getMenuShortcutKeyMask()));
    }
}



