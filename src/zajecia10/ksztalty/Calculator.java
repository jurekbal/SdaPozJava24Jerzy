package zajecia10.ksztalty;

import java.util.Random;

public class Calculator {

    Shape[] shapes = new Shape[20];
    Random random = new Random();

    public static void main(String[] args) {
        Calculator calc = new Calculator();

        calc.testCode();
        calc.createRandomShapesTable();
        calc.printShapes();

    }

    private void printShapes() {
        for (Shape s: shapes) {
            if (s != null) {
                System.out.println(
                        s.getClass().getName() +
                        String.format(" area: %.2f perimeter: %.2f", s.getArea(), s.getPerimrter() )
                );
            } else {
                System.out.println("NULL");
            }
        }
    }

    private void createRandomShapesTable() {
        int shapeType;
        for (int i = 0; i < shapes.length; i++) {
            shapeType = random.nextInt(3);
            switch (shapeType) {
                case 0:
                    shapes[i] = getRandomCircle();
                    break;
                case 1:
                    shapes[i] = getRandomTriangle();
                    break;
                case 2:
                    shapes[i] = getRandomRectangle();
                    break;
                case 3:
                    shapes[i] = getRandomSquare();
                    break;
                default:
                    shapes[i] = null;
            }
        }
    }

    private Shape getRandomSquare() {
        double edge = random.nextDouble() * 10;
        return new Square(edge);
    }

    private Shape getRandomRectangle() {
        double edgeA = random.nextDouble() * 10;
        double edgeB = random.nextDouble() * 10;
        return new Rectangle(edgeA, edgeB);
    }

    private Shape getRandomTriangle() {
        double edgeA = random.nextDouble() * 10;
        double edgeB = random.nextDouble() * 10;
        double edgeC = random.nextDouble() * 10;
        //double heightA = random.nextDouble() * 10;
        try {
            return new Triangle(edgeA,edgeB,edgeC);
        } catch (InvalidTriangleException e) {
            System.out.println(e.getMessage());
            System.out.println("Generuję ponownie...");
            return getRandomTriangle();
        }
    }

    private Shape getRandomCircle() {
        double radius = random.nextDouble() * 10;
        return new Circle(radius);
    }

    private void testCode() {
        double circleRadius = 50L;
        Circle circle = new Circle(circleRadius);
        System.out.println("Circle radius: " + circleRadius);
        System.out.println("Circle area: " + circle.getArea());
        System.out.println("Circle perimeter: " + circle.getPerimrter());

        double edgeA = 10.0;
        double edgeB = 15.0;
        Rectangle rectangle = new Rectangle(edgeA, edgeB);
        System.out.println("Rectagle edge A: " + edgeA);
        System.out.println("Rectagle edge B: " + edgeB);
        System.out.println("Rectangle area: " + rectangle.getArea());
        System.out.println("Rectangle perimeter: " + rectangle.getPerimrter());
        System.out.println("Rectangle edges#: "+ rectangle.getEdgesNum());

        Square square = new Square(edgeA);
        System.out.println("Square edge B: " + edgeB);
        System.out.println("Square area: " + square.getArea());
        System.out.println("Square perimeter: " + square.getPerimrter());
        System.out.println("Square edges#: "+ square.getEdgesNum());

        double edgeC = 10.0;
       // double height = 10;
        Triangle triangle;
        try {
            triangle = new Triangle(edgeA, edgeB, edgeC);
        } catch (InvalidTriangleException e){
            System.out.println("Błąd w testCode(): " + e.getMessage());
            triangle = null;
        }

//        Triangle triangle = new Triangle(edgeA, edgeB, edgeC,height);
        if (triangle != null) {
            System.out.println("Triangle:");
            System.out.println("Triangle area: " + triangle.getArea());
            System.out.println("Triangle perimeter: " + triangle.getPerimrter());
            System.out.println("Triangle edges#: "+ triangle.getEdgesNum());
        }
    }
}
