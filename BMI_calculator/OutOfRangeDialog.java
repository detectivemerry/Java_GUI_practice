import java.awt.*;
import java.awt.event.*;

public class OutOfRangeDialog {
    private Dialog d;
    public OutOfRangeDialog(){
        Frame f = new Frame();
        d = new Dialog(f,"Error, input out of range", true);
        d.setLayout(new FlowLayout());
        Button b = new Button("Confirm");
        b.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
               d.setVisible(false);
            }
        });
        d.add(new Label("Please enter a valid height and weight!"));
        d.add(b);
        d.setSize(250,100);
        d.setVisible(true);
    }
    public static void main(String args[])
    {
        new OutOfRangeDialog();
    }
    public OutOfRangeDialog getDialog(){
        return this;
    }


}
