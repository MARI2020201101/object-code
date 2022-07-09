package ch12;

import java.util.Arrays;

class Demo {
    public static void main(String[] args) {
        Lecture lecture = new Lecture(70,
                "oop",
                Arrays.asList(10, 76, 44, 98, 100, 33));
        String evaluate = lecture.evaluate();
        System.out.println(evaluate);
        System.out.println("----------------------------------------------------");
        Lecture gradeLecture = new GradeLecture(70,
                "java",
                Arrays.asList(
                        new Grade("A",100,95),
                        new Grade("B",94,80),
                        new Grade("C",79,70),
                        new Grade("D",69,50),
                        new Grade("F",49,0)
                ),
                        Arrays.asList(10, 76, 44, 98, 88, 92, 52, 100, 33, 89));
        String evaluateGrade = gradeLecture.evaluate();
        System.out.println(evaluateGrade);
        System.out.println("----------------------------------------------------");


        Professor professor = new Professor("홍길동",
                new Lecture(70,
                        "알고리즘",
                        Arrays.asList(88, 76, 67, 92, 44, 98, 100, 33)));
        String statistics = professor.compileStatistics();
        System.out.println(statistics);

        Professor professor2 = new Professor("성춘향", gradeLecture);
        String statistics2 = professor2.compileStatistics();
        System.out.println(statistics2);
        //부모클래스 타입으로 선언된 변수에
        // 자식클래스를 대입하는 것이 가능하다 = 업캐스팅

        // 반대로 자식클래스 타입으로 선언된 변수에 부모 클래스를 대입하는 것을 다운캐스팅이라고 한다.
        // (명시적 타입캐스팅)

        //선언된 변수가 아니라 실행되는 클래스에 해당하는 메서드가 결정된다.
        // = 동적 바인딩
        // 코드를 변경하지 않고 실행되는 메서드를 변경할 수 있다.

        //메시지를 수신한 객체는 자신을 생성한 클래스에 적합한 메서드가 있는지를 먼저 찾고, 없으면 부모 클래스로 올라간다.
        //가장 상위 클래스(Object)에도 없으면 예외를 발생시키고 탐색을 종료한다.

        System.out.println("----------------------------------------------------");
        System.out.println(lecture.stats());
        System.out.println(gradeLecture.stats());

        FormattedGradeLecture formattedGradeLecture = new FormattedGradeLecture(
                70,
                "design pattern",
                Arrays.asList(
                        new Grade("A",100,95),
                        new Grade("B",94,80),
                        new Grade("C",79,70),
                        new Grade("D",69,50),
                        new Grade("F",49,0)
                ),
                Arrays.asList(10, 76, 44, 98, 88, 92, 52, 100, 33, 89)
        );
        System.out.println("----------------------------------------------------");
        String formatAverage = formattedGradeLecture.formatAverage();
        System.out.println(formatAverage);
    }
}
