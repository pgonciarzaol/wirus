public class Answer {
    public Answer(){
        Reader reader = Reader.getInstance();
        System.out.println("Ilość zakażonyuch zakażonych, to: " + reader.getContractedCount());
    }
}
