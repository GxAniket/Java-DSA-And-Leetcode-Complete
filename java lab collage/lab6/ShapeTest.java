// Abstract class Shape
abstract class Shape {
    int dimension1;
    int dimension2;

    // Constructor to initialize dimensions
    Shape(int d1, int d2) {
        this.dimension1 = d1;
        this.dimension2 = d2;
    }

    // Abstract method to print area
    abstract void printArea();
}

// Rectangle class extending Shape
class Rectangle extends Shape {

    Rectangle(int length, int width) {
        super(length, width);
    }

    @Override
    void printArea() {
        int area = dimension1 * dimension2;
        System.out.println("Rectangle Area: " + area);
    }
}

// Triangle class extending Shape
class Triangle extends Shape {

    Triangle(int base, int height) {
        super(base, height);
    }

    @Override
    void printArea() {
        double area = 0.5 * dimension1 * dimension2;
        System.out.println("Triangle Area: " + area);
    }
}

// Circle class extending Shape
class Circle extends Shape {

    Circle(int radius) {
        super(radius, 0); // Only one dimension is needed for a circle
    }

    @Override
    void printArea() {
        double area = Math.PI * dimension1 * dimension1;
        System.out.println("Circle Area: " + area);
    }
}

// Main class to test the shapes
public class ShapeTest {
    public static void main(String[] args) {
        // Create objects of each shape
        Shape rectangle = new Rectangle(25, 18); // Length = 25, Width = 18
        Shape triangle = new Triangle(18, 11);    // Base = 18, Height = 11
        Shape circle = new Circle(11);          // Radius = 11

        // Print areas
        rectangle.printArea();
        triangle.printArea();
        circle.printArea();
    }
}