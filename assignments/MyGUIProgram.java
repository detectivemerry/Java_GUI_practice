import java.awt.*;
import java.awt.event.*;

public class MyGUIProgram extends Frame implements ActionListener{
    private Label lblCount ;
    private TextField tfCount;
    private Button btnCount;
    private int count = 0;

    public MyGUIProgram(){
        this.setLayout(new FlowLayout());
        // "super" Frame, which is a Container, sets its layout to FlowLayout to arrange
        // the components from left-to-right, and flow to next row from top-to-bottom.

        lblCount = new Label("Counter");
        this.add(lblCount);
        tfCount = new TextField(count + "", 10);
        tfCount.setEditable(false);
        this.add(tfCount);
        btnCount = new Button("Count");
        this.add(btnCount);

        btnCount.addActionListener(this);

        this.setTitle("AWT Counter");
        this.setSize(250, 100);
        System.out.println(this);
        System.out.println(lblCount);
        System.out.println(tfCount);
        System.out.println(btnCount);
        this.setVisible(true);

    }

    public static void main(String[] args) {
        // Invoke the constructor (to setup the GUI) by allocating an instance
        MyGUIProgram myfirstGUI = new MyGUIProgram();
    }

    public void actionPerformed(ActionEvent e) {
        ++count;
        tfCount.setText(count+"");
    }
}
