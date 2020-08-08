import java.awt.*;        // Uses AWT's Layout Managers
import java.awt.event.*;  // Uses AWT's Event Handlers

public class BMIResults extends Frame{
        private TextField tfBMI;
        private TextField tfBmiClass;
        private TextField tfCalories;

        public BMIResults(double outputBMI, double outputCalories, String bmiClass){
                setLayout(new GridBagLayout());
                GridBagConstraints gbc = new GridBagConstraints();
                gbc.insets =  new Insets(1,10,10,10);
                gbc.fill = GridBagConstraints.HORIZONTAL;

                //Header
                gbc.gridwidth =  2;
                gbc.gridx = 1;
                add(new Label("Here are the health results"),gbc);

                //BMI label and input
                gbc.gridwidth = 1;
                gbc.gridx = 1;
                gbc.gridy = 1;
                add(new Label("BMI: "),gbc);
                gbc.gridx = 2;
                gbc.gridy = 1;
                tfBMI = new TextField(10);
                tfBMI.setText(String.format("%.2f",outputBMI));
                tfBMI.setEditable(false);
                add(tfBMI, gbc);

                //bmi class label and input
                gbc.gridx = 1;
                gbc.gridy = 2;
                add(new Label("Bmi class"), gbc);
                gbc.gridx = 2;
                gbc.gridy = 2;
                tfCalories = new TextField(10);
                tfCalories.setText(bmiClass);
                add(tfCalories, gbc);

                //Calories label and input
                gbc.gridx = 1;
                gbc.gridy = 3;
                add(new Label("Recommended Daily Calorie Intake"), gbc);
                gbc.gridx = 2;
                gbc.gridy = 3;
                tfBmiClass = new TextField(10);
                tfBmiClass.setText(String.format("%.2f",outputCalories));
                add(tfBmiClass, gbc);

                addWindowListener(new WindowAdapter(){
                        public void windowClosing(WindowEvent e) {
                                System.exit(0);
                        }
                });

                //Setting up rest of the frame
                setTitle("BMI and Calories Calculator");
                setSize(400, 400);
                setVisible(true);
        }

        public BMIResults SecondFrame(){
                return this;
        }

        // public static void main(String[] args) {
        // }
}
