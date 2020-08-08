import java.awt.*;
import java.awt.event.*;

public class AWTAccumulator extends Frame implements
                                          ActionListener, WindowListener{

    private Label lblInteger;
    private Label lblAccum;
    private TextField tfInteger;
    private TextField tfAccum;
    private int sum=0;

    public AWTAccumulator(){
        this.setLayout(new FlowLayout());
        lblInteger = new Label("Enter an integer");
        add(lblInteger);

        tfInteger = new TextField(10);

        tfInteger.addActionListener(this);

        add(tfInteger);
        lblAccum = new Label("Accumulated Sum is");
        add(lblAccum);

        tfAccum = new TextField(10);
        tfAccum.setEditable(false);
        add(tfAccum);

        addWindowListener(this);

        this.setTitle("AWT Accumulator");
        this.setSize(350, 120);
        this.setVisible(true);
    }

    public static void main(String[] args) {
        AWTAccumulator a1 =  new AWTAccumulator();
    }

    public void actionPerformed(ActionEvent e) {
        int num = Integer.parseInt(tfInteger.getText());
        sum += num;
        tfInteger.setText(""); // clear input field
        tfAccum.setText(sum+"");
    }

    public void windowClosing(WindowEvent e) {
        System.exit(0);
    }
    @Override public void windowClosed(WindowEvent evt) { }
    // For Debugging
    @Override public void windowIconified(WindowEvent evt) { System.out.println("Window Iconified"); }
    @Override public void windowDeiconified(WindowEvent evt) { System.out.println("Window Deiconified"); }
    @Override public void windowActivated(WindowEvent evt) { System.out.println("Window Activated"); }
    @Override public void windowDeactivated(WindowEvent evt) { System.out.println("Window Deactivated");}
    @Override public void windowOpened(WindowEvent evt) { }
}

