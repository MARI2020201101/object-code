package ch12;

import java.util.List;

public class FormattedGradeLecture extends GradeLecture{
    public FormattedGradeLecture(int pass, String title, List<Grade> grades, List<Integer> scores) {
        super(pass, title, grades, scores);
    }
    public String formatAverage(){
        //super -> 부모클래스에서부터 메서드 탐색을 시작하세요
        return String.format("Avg: %1.1f", super.average());
    }
}
