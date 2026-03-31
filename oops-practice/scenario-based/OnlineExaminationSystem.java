import java.util.*;

class ExamTimeExpiredException extends Exception {
    public ExamTimeExpiredException(String message) {
        super(message);
    }
}

interface EvaluationStrategy {
    int evaluate(String answer, String correctAnswer);
}

class ObjectiveEvaluation implements EvaluationStrategy {
    public int evaluate(String answer, String correctAnswer) {
        return answer.equalsIgnoreCase(correctAnswer) ? 1 : 0;
    }
}

class DescriptiveEvaluation implements EvaluationStrategy {
    public int evaluate(String answer, String correctAnswer) {
        return answer.length() >= correctAnswer.length() / 2 ? 1 : 0;
    }
}

class Question {
    private int questionId;
    private String questionText;
    private String correctAnswer;
    private EvaluationStrategy strategy;

    public Question(int questionId, String questionText, String correctAnswer, EvaluationStrategy strategy) {
        this.questionId = questionId;
        this.questionText = questionText;
        this.correctAnswer = correctAnswer;
        this.strategy = strategy;
    }

    public int evaluateAnswer(String answer) {
        return strategy.evaluate(answer, correctAnswer);
    }

    public int getQuestionId() {
        return questionId;
    }
}

class Student {
    private int studentId;
    private String name;

    public Student(int studentId, String name) {
        this.studentId = studentId;
        this.name = name;
    }

    public int getStudentId() {
        return studentId;
    }

    public String getName() {
        return name;
    }
}

class Exam {
    private int examId;
    private List<Question> questions;
    private Map<Integer, Map<Integer, String>> submissions;
    private boolean examOpen;

    public Exam(int examId) {
        this.examId = examId;
        questions = new ArrayList<>();
        submissions = new HashMap<>();
        examOpen = true;
    }

    public void addQuestion(Question question) {
        questions.add(question);
    }

    public void closeExam() {
        examOpen = false;
    }

    public void submitAnswer(int studentId, int questionId, String answer) throws ExamTimeExpiredException {
        if (!examOpen) {
            throw new ExamTimeExpiredException("Exam time expired");
        }
        submissions.putIfAbsent(studentId, new HashMap<>());
        submissions.get(studentId).put(questionId, answer);
    }

    public void generateResult(int studentId) {
        Map<Integer, String> answers = submissions.get(studentId);
        if (answers == null) {
            System.out.println("No submission found");
            return;
        }

        int score = 0;
        for (Question q : questions) {
            String ans = answers.get(q.getQuestionId());
            if (ans != null) {
                score += q.evaluateAnswer(ans);
            }
        }
        System.out.println("Student ID: " + studentId + " | Score: " + score);
    }
}

public class OnlineExaminationSystem {
    public static void main(String[] args) {

        Exam exam = new Exam(1);

        Question q1 = new Question(
                101,
                "Java is platform independent?",
                "Yes",
                new ObjectiveEvaluation()
        );

        Question q2 = new Question(
                102,
                "Explain OOP concepts",
                "Object Oriented Programming",
                new DescriptiveEvaluation()
        );

        exam.addQuestion(q1);
        exam.addQuestion(q2);

        Student s1 = new Student(1, "Sneha");

        try {
            exam.submitAnswer(s1.getStudentId(), 101, "Yes");
            exam.submitAnswer(s1.getStudentId(), 102, "OOP uses objects and classes");
        } catch (ExamTimeExpiredException e) {
            System.out.println(e.getMessage());
        }

        exam.closeExam();

        exam.generateResult(s1.getStudentId());
    }
}
