import java.awt.*;
import java.awt.event.*;

public class AWTCounter extends Frame{

    private TextField tfCount;
    private Label lblCount;
    private Button countUp;
    private Button countDown;
    private Button reset;
    int count = 0;

    public AWTCounter(){
        this.setLayout(new FlowLayout());

        lblCount = new Label("Counter");
        add(lblCount);
        tfCount = new TextField(10);
        add(tfCount);
        tfCount.setEditable(false);

        countUp = new Button("Count Up");

        // Allocate an instance of the "named" inner class BtnListener.
        BtnListener listener = new BtnListener();
        countUp.addActionListener(listener);

        add(countUp);
        countDown = new Button("Count Down");
        countDown.addActionListener(listener);
        add(countDown);
        reset = new Button("Reset");
        reset.addActionListener(listener);

        add(reset);
        setTitle("AWT Counter");
        setSize(400, 100);
        setVisible(true);

    }
    public static void main(String[] args) {
        // Invoke the constructor (to setup the GUI) by allocating an instance
        AWTCounter a1 = new AWTCounter();
    }
    public class BtnListener implements ActionListener{
        public void actionPerformed(ActionEvent e) {
            // the getActionCommand() returns the Button's label
            String btnLabel = e.getActionCommand();
            if (btnLabel.equals("Count Up")) {
                ++count;
            } else if (btnLabel.equals("Count Down")) {
                --count;
            } else {
                count = 0;
            }
            tfCount.setText(count + "");
        }
        }
}


