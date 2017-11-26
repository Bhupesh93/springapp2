package backend.model;

import java.util.List;
import java.util.stream.Collectors;

public class Question {
    private String id;
    private String description;
    private String correctAnswer;
    private List<String> options;

    public Question() {

    }

    public Question(String id, String description, String correctAnswer, List<String> options) {
        this.id = id;
        this.description = description;
        this.correctAnswer = correctAnswer;
        this.options = options;
    }

    @Override
    public String toString() {
        return String.format("Question [id='%s', description='%s', correctAnswer='%s', options=%s]"
                , id, description, correctAnswer, options.stream().collect(Collectors.joining(",")));
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Question question = (Question) o;

        return id.equals(question.id);
    }

    @Override
    public int hashCode() {
        return id.hashCode();
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getCorrectAnswer() {
        return correctAnswer;
    }

    public void setCorrectAnswer(String correctAnswer) {
        this.correctAnswer = correctAnswer;
    }

    public List<String> getOptions() {
        return options;
    }

    public void setOptions(List<String> options) {
        this.options = options;
    }
}
