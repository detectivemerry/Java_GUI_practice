public class CaloriesFormula {
    private double weight;
    private String gender;

    public CaloriesFormula(double weight, String gender){
        this.weight = weight;
        this.gender = gender;
    }

    public double CountCalories(){
        return (weight * 2.204623)*16;
    }

    public boolean isCaloriesRange(){
        double calories = (weight * 2.204623)*16;
        if(calories < 900 || calories > 10000)return false;
        else return true;
    }


}
