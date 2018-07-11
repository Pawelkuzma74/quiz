import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main extends JFrame implements ActionListener {

    // ma zawierać pytanie
    // ma zawierać 2 przyciski tak i nie

    private JButton buttonYes;
    private JButton buttonNo;
    private JLabel labelQuestion;

    private QuestionGenerator questionGenerator;
    private int currentQuestion = 0;
    private int numberOfPoints = 0;
    private List<Question> questionList = new ArrayList<>();

    public void setQuestionGenerator(QuestionGenerator questionGenerator) {
        this.questionGenerator = questionGenerator;
        questionList = questionGenerator.generateQuestions();
    }

    public Main() {
        super("miliarderzy");
        createDefaultComponents();
        labelQuestion = new JLabel(questionList.get(0).getContent(), 0);
        add(labelQuestion);
        add(buttonYes);
        add(buttonNo);

        setLayout(new GridLayout(3, 1));

    }

    private void createDefaultComponents() {
        setSize(500, 500);
        setDefaultCloseOperation(1); // sprawia, ze działa przycisk exit
        setVisible(true); //
        setQuestionGenerator(new SimpleQuestionGenerator());
        buttonYes = new JButton("Tak");
        buttonNo = new JButton("Nie");
        buttonYes.addActionListener(this);
        buttonNo.addActionListener(this);  //wskazuje na obiekt, w którym jest
    }

    public static void main(String[] args) {

        SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {
                Main main = new Main();
            }
        });


    }

    @Override
    public void actionPerformed(ActionEvent e) {
        // kolejne pytanie musi się miesić w liście
        if (currentQuestion < questionList.size()) {
            JButton clikedButton = (JButton) e.getSource();
            Question currentQuestion = questionList.get(this.currentQuestion);
            if (clikedButton == buttonYes
                    && currentQuestion.isCorrect()
                    ) {
                numberOfPoints++;
            }
            if (clikedButton == buttonNo
                    && !currentQuestion.isCorrect()
                    ) {
                numberOfPoints++;
            }
        }
        if (currentQuestion + 1 < questionList.size()) {
            labelQuestion.setText(questionList.get(++currentQuestion).getContent());
        } else {
            JOptionPane.showMessageDialog(this, "Koniec quizu zdobyłeś" + numberOfPoints + " punkty");
            buttonNo.setEnabled(false);
            buttonYes.setEnabled(false);
        }
    }

        }
