public class BmiFormula {
    private double weight;
    private double height;
    private double age;
    private String gender;
    private double bmiNo;

    public BmiFormula(double weight, double height, double age, String gender){
        this.weight = weight;
        this.height = height;
        this.age = age;
        this.gender = gender;
        this.bmiNo = (weight/height/height)*10000;
    }

    public double CountBMI(){
        return bmiNo;
    }

    public boolean isBMIRange(){
        if(bmiNo<10 || bmiNo > 30)return false;
        else return true;
    }

    public String BmiClass(){
        if(bmiNo < 18.5) return "UnderWeight";
        else if(bmiNo <= 24.9) return "Normal Weight";
        else if (bmiNo <= 29.9) return "OverWeight";
        else{
            return "Obese";
        }
    }


}
