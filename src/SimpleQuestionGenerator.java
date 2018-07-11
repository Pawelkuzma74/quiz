import java.util.ArrayList;
import java.util.List;

public class SimpleQuestionGenerator implements QuestionGenerator {
    @Override
    public List<Question> generateQuestions() {

        List<Question> questionList = new ArrayList<>();

        questionList.add(new Question("Czy Polska leży w Europie", true));
        questionList.add(new Question("Czy 2+5=87", false));
        questionList.add(new Question(" Czy 2^10=10247", true));
        questionList.add(new Question(" Czy Chopin urodził się w Warszaie ", false));


        return questionList;
    }
}
