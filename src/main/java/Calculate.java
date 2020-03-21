import java.util.ArrayList;
import java.util.List;

public class Calculate {




    public void calculateContractedCount(){
        Reader reader = Reader.getInstance();
        reader.setDailyRatio(calculateRatioFromDays());
        reader.setContractedCount(this.calculateContracted(reader.getDaysToCount(),reader.getDailyRatio(),reader.getContractedCount()));
    }

    private double calculateContracted(double days, double ratio, double contracted) {

        if (days == 0) {
            return contracted;
        } else {
            System.out.println(days + "  " + ratio + "  " + contracted);
            return calculateContracted(days - 1, ratio, contracted * ratio);
        }
    }

    private static double calculateRatioFromDays() {
        Reader reader = Reader.getInstance();

        Calculate calculate = new Calculate();
        Data data = new Data();
        int firstKey = data.map.size() - reader.getAmountOfDaysToConsider();
        int lastKey = data.map.size() - 1;
        List<Double> ratios = new ArrayList<>();
        double prevValue;
        double nextValue;

        for (int i = firstKey; i <= lastKey; i++) {
            prevValue = Double.parseDouble(data.map.get(i));
            nextValue = Double.parseDouble(data.map.get(i + 1));
            double tempRatio = nextValue / prevValue;

            ratios.add(tempRatio);
        }
        return calculate.calculateAverage(ratios);
    }

    private double calculateAverage(List<Double> ratios) {
        double sum = 0;
        double ratio1;
        if (!ratios.isEmpty()) {
            for (Double ratio : ratios) {
                sum = sum + ratio;

            }
        }
        ratio1 = sum / ratios.size();
        System.out.println("ratio wynosi: " + ratio1);
        return ratio1;
    }
}
