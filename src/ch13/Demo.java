package ch13;

class Demo {
    public static void main(String[] args) {
        Square square = new Square(10,10,10);
        Rectangle rectangle = new Rectangle(10,10,15,30);
        resize(rectangle, 50,100);
        resize(square, 50, 100);
        //리스코프 치환원칙을 위반한다.
        //클라이언트가 기대하는 행동을 호환하지 않음.
        //자식 클래스가 부모 클래스를 대체하지 못하고 있다.
        //본질적으로 square 와 rectangle 이 다르기 때문이다.
        //대체 가능성을 결정하는 것은 클라이언트이다. 어휘적 관계가 결정하지 않는다.
    }
    static void resize(Rectangle rectangle, int width, int height){
        rectangle.setHeight(height);
        rectangle.setWidth(width);
        System.out.println(rectangle);
        if(rectangle.getWidth() != width || rectangle.getHeight() != height){
            throw new IllegalStateException();
        }
        else{
            System.out.println("사각형 resizing 완료");
        }
    }
}
