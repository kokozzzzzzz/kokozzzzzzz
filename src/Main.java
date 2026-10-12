import java.util.Scanner;
public class Main {
    public static void main(String[] args) {
        System.out.println("--- Тесты ---");
        System.out.println("5 + 3 = " + calculate(5, 3, "+"));   // ожидается: 8
        System.out.println("5 / 2 = " + calculate(5, 2, "/"));   // ожидается: 2
        System.out.println("10 - 3 = " + calculate(10, 3, "-")); // ожидается: 7
        System.out.println("4 * 6 = " + calculate(4, 6, "*"));   // ожидается: 24
        System.out.println("--- Конец тестов ---\n");
        Scanner scanner = new Scanner(System.in);
        while (true) {
            System.out.println("> ");
            String primer  = scanner.nextLine();
            if(primer.equals("exit")) {
                break;
            }
            String [] parts =  primer.trim().split("\\s+");
            if(parts.length != 3){
                System.out.println("Ошибка: неверный формат. Используйте: число оператор число");
                continue;
            }
            try {
                int a= Integer.parseInt(parts[0]);
                int b= Integer.parseInt(parts[2]);
                String op = parts [1];
                int result =  calculate(a,b,op);
                System.out.println(a + " " + op + " " + b + " " + "= " +result);
            }
            catch(NumberFormatException e) {
                System.out.println("Ошибка: неверный формат. Используйте: число оператор число");
            }
            catch(ArithmeticException | IllegalArgumentException e) {
                System.out.println("Ошибка"+ e.getMessage());
            }
        }
    }
    private static int  calculate(int a, int b, String op) {
        switch(op) {
            case "+":
                return a + b;


            case "-":
                return a-b;


            case "/":
                if (b==0 ){
                    throw new ArithmeticException(" деление на 0");
                }
                return a/b;

            case"*":
                return a*b;

            default:
                throw new IllegalArgumentException("неизвестный оператор " + op);
        }
    }
}