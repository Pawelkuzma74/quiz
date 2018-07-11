public class Question { // klasa question, która jest odpowidzialna za przechowywanie konkretne pytania
    // pytanie tylko ma opcje TAK i NIE


    private String content;  // treść pytania

    private boolean isCorrect; // czy TAK jest poprawne

    public Question(String content, boolean isCorrect) { // konstruktor 2 parametrowy
        this.content = content;
        this.isCorrect = isCorrect;
    }

    public String getContent() {
        return content;
    }   // getter otrzymuje dane

    public void setContent(String content) {
        this.content = content;
    } // setter zmienia treśc pytania

    public boolean isCorrect() {
        return isCorrect;
    }   //getter dla boolenana

    public void setCorrect(boolean correct) {
        isCorrect = correct;
    }   //setter dla boolena

    @Override
    public String toString() {
        return "Question{" +
                "content='" + content + '\'' +
                ", isCorrect=" + isCorrect +
                '}';
    }






}
