import java.awt.*;        // Uses AWT's Layout Managers
import java.awt.event.*;  // Uses AWT's Event Handlers

public class BMICalculator extends Frame {
    //intialize variables and components
    private double weight;
    private double height;
    private int age;
    private Button btnSubmit;
    private TextField tfWeight;
    private TextField tfHeight;
    private CheckboxGroup sex;
    private Checkbox cbM, cbF;
    private TextField tfAge;
    private TextField tfOutput;
    private boolean isSubmited;


    public BMICalculator(){
        isSubmited = false;
        setLayout(new GridBagLayout());
        GridBagConstraints gbc = new GridBagConstraints();
        //setup gridbag constraint object
        gbc.insets =  new Insets(1,10,10,10);
        gbc.fill = GridBagConstraints.HORIZONTAL;

        //Header
        gbc.gridwidth =  2;
        gbc.gridx = 1;
        add(new Label("Welcome to BMI and calories calculator!"),gbc);

        //Weight label and input
        gbc.gridwidth = 1;
        gbc.gridx = 1;
        gbc.gridy = 1;
        add(new Label("Enter Weight (in kg)"),gbc);
        gbc.gridx = 2;
        gbc.gridy = 1;
        tfWeight = new TextField(10);
        // tfWeight.addKeyListener(new KeyEnteredListener());
        tfWeight.addKeyListener(new KeyAdapter(){
            public void keyTyped(KeyEvent e) {
                char c = e.getKeyChar();
                if (!((c >= '0') && (c <= '9') ||
                        (c == KeyEvent.VK_BACK_SPACE) ||
                        (c == KeyEvent.VK_DELETE))) {
                    getToolkit().beep();
                    e.consume();
                }
                if(tfWeight.getText().length()>=3)e.consume();
            }
        });
        add(tfWeight, gbc);

        //Height label and input
        gbc.gridx = 1;
        gbc.gridy = 2;
        add(new Label("Enter Height (in cm)"), gbc);
        gbc.gridx = 2;
        gbc.gridy = 2;
        tfHeight = new TextField(10);
        tfHeight.addKeyListener(new KeyAdapter(){
            public void keyTyped(KeyEvent e) {
                char c = e.getKeyChar();
                if (!((c >= '0') && (c <= '9') ||
                        (c == KeyEvent.VK_BACK_SPACE) ||
                        (c == KeyEvent.VK_DELETE))) {
                    getToolkit().beep();
                    e.consume();
                }
                if(tfHeight.getText().length()>=3)e.consume();
            }
        });
        add(tfHeight, gbc);

        //Gender label and input, both checkboxes are placed into a panel
        gbc.fill = GridBagConstraints.HORIZONTAL;
        gbc.gridx = 1;
        gbc.gridy = 3;
        add(new Label("Enter Sex"), gbc);
        sex = new CheckboxGroup();
        cbM = new Checkbox("Male", sex,false);
        cbF = new Checkbox("Female", sex,false);
        gbc.gridx = 2;
        gbc.gridy = 3;
        Panel pnlRadio = new Panel(new FlowLayout());
        pnlRadio.add(cbM);
        pnlRadio.add(cbF);
        add(pnlRadio, gbc);

        //Age label and input
        gbc.gridx = 1;
        gbc.gridy = 4;
        add(new Label("Enter Age"), gbc);
        gbc.gridx = 2;
        gbc.gridy = 4;
        tfAge = new TextField(3);
        tfAge.addKeyListener(new KeyAdapter(){
            public void keyTyped(KeyEvent e) {
                char c = e.getKeyChar();
                if (!((c >= '0') && (c <= '9') ||
                        (c == KeyEvent.VK_BACK_SPACE) ||
                        (c == KeyEvent.VK_DELETE))) {
                    getToolkit().beep();
                    e.consume();
                }
                if(tfAge.getText().length()>=2)e.consume();
            }
        });
        add(tfAge, gbc);

        //Submit button calling BtnListener
        gbc.gridx = 1;
        gbc.gridy = 5;
        gbc.gridwidth = 2;
        btnSubmit = new Button("Submit");
        btnSubmit.addActionListener(new BtnListener());
        add(btnSubmit, gbc);

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
    public boolean getIsSubmited(){
        return isSubmited;
    }

    public BMICalculator SecondFrame(){
        return this;
    }

    public static void main(String[] args) {
        BMICalculator a1 = new BMICalculator();
        System.out.println(a1.isVisible());
        while(a1.isVisible()){
             System.out.println(a1.getIsSubmited());
            if(a1.getIsSubmited()){
                System.out.println("is submitted");
                a1.setVisible(false);
            }
        }

    }

    //listener
    public class BtnListener implements ActionListener {
        public void actionPerformed(ActionEvent e) {
            double weight = Double.parseDouble(tfWeight.getText());
            double height = Double.parseDouble(tfHeight.getText());
            double age = Double.parseDouble(tfAge.getText());
            String gender = sex.getSelectedCheckbox().getLabel();

            BmiFormula bmi = new BmiFormula(weight, height, age, gender);
            double outputBMI = bmi.CountBMI();
            CaloriesFormula calo = new CaloriesFormula(weight, gender);
            double outputCalories = calo.CountCalories();
            String bmiClass = bmi.BmiClass();

            if(bmi.isBMIRange() && calo.isCaloriesRange()){
                BMIResults redirect = new BMIResults(outputBMI, outputCalories, bmiClass);
                isSubmited = true;
                redirect.SecondFrame();
                redirect.setVisible(true);
            }
            else{
                OutOfRangeDialog dialog = new OutOfRangeDialog();
                dialog.getDialog();
                tfWeight.setText("");
                tfHeight.setText("");
            }

        }
    }
}
