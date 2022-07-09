package ch12;

import java.util.List;

import static java.util.stream.Collectors.joining;

class GradeLecture extends Lecture{
    private List<Grade> grades;

    public GradeLecture(int pass, String title, List<Grade> grades, List<Integer> scores) {
        super(pass, title, scores);
        this.grades = grades;
    }

    @Override
    public String evaluate() {
        return super.evaluate() + " , " + gradeStatistics();
    }

    private String gradeStatistics() {
        return grades.stream()
                .map(g -> format(g))
                .collect(joining(" "));
    }

    private String format(Grade g) {
        return String.format(" %s : %d ", g.getName() , gradeCount(g));
    }

    private long gradeCount(Grade g) {
        return getScores()
                .stream()
                .filter(g::include)
                .count();
    }

    public double average(String gradeName){
        return grades
                .stream()
                .filter(each -> each.isName(gradeName))
                .findFirst()
                .map(this::gradeAverage)
                .orElse(0d);
    }

    private double gradeAverage(Grade grade) {
        return getScores()
                .stream()
                .filter(grade::include)
                .mapToInt(Integer::intValue)
                .average()
                .orElse(0);
    }

    @Override
    public String getEvaluationMethod() {
        return "Grade";
    }
}
