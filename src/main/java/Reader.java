import java.util.Scanner;

public class Reader {
    private double daysToCount;
    private double contractedCount;
    private double dailyRatio;
    private static Reader single_instance = null;
    private int amountOfDaysToConsider;
    Scanner in = new Scanner(System.in);

    private Reader(){
        this.askForContractedCount();
        this.askForDaysToCount();
        this.askForAmountOfDaysToConsider();

//        this.askForRatio();
    }
    public void askForContractedCount(){
        System.out.print("Podaj ilość zakażonych");
        this.contractedCount = in.nextDouble();
    }

    public static Reader getInstance(){
        if(single_instance == null){
            single_instance = new Reader();}
        return single_instance;
    }

    public void askForDaysToCount(){
        System.out.print("Podaj ilość dni");
        this.daysToCount = in.nextDouble();
    }

    public void askForAmountOfDaysToConsider(){

            System.out.println("Podaj ile oststnich dni wziąć pod uwagę.\n wpisz zero aby wybrać wszystkie");
            this.amountOfDaysToConsider = in.nextInt();


    }

    public void askForRatio(){
        System.out.print("Podaj ratio");
        this.dailyRatio = in.nextDouble();
    }
    public void setDailyRatio(double ratio){
        this.dailyRatio = ratio;
    }

    public double getDaysToCount() {
        return daysToCount;
    }

    public double getContractedCount() {
        return contractedCount;
    }

    public double getDailyRatio() {
        return dailyRatio;
    }
    public void setContractedCount(double contractedCount){
        this.contractedCount = contractedCount;
    }

    public int getAmountOfDaysToConsider() {
        return amountOfDaysToConsider;
    }
}
