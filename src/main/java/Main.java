import java.io.IOException;

public class Main {
    public static void main(String [] args) throws IOException {
        Data.temp();
//        Reader reader = Reader.getInstance();
        Calculate calculate = new Calculate();
        calculate.calculateContractedCount();
        Answer answer = new Answer();
    }
}
