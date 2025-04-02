public class Syntax {
    
    public static void main(String[] args) {
        // Primitive types
        int age = 17;
        double gpa = 4.0;
        boolean isStudent = true;
        char initial = 'P';
    
        // Non primative types
        String name = "Pierce"; // Class based

        System.out.println("Name: " + name);
        System.out.println("Initial: " + initial);
        System.out.println("Age: " + age);
        System.out.println("Is Student: " + isStudent);
        System.out.println("GPA: " + gpa);
        
        // Operators
        int a = 10, b = 3;
        System.out.println(a + b); // 13
        System.out.println(a - b); // 7
        System.out.println(a * b); // 30
        System.out.println(a / b); // 3 (integer division)
        System.out.println(a % b); // 1 (mod, remainder)

        // Comparison
        System.out.println(a >= b); // True
        System.out.println(a == b); // False
        System.out.println(a != b); // True

        // Logical
        boolean isRed = true, isBlue = false;
        System.out.println(isRed && isBlue); // False (and)
        System.out.println(isRed || isBlue); // True (or)
        System.out.println(!isRed); // False (is NOT red)

        // Conditionals
        int temperature = 18;
        String message = "";
        
        if (temperature > 25) {
            message = "It's hot outside!";

        } else if (temperature > 15) {
            message = "It's a nice day.";

        } else {
            message = "It's cold out.";

        }

        System.out.println(message);

    }
}
