public class ExOne {
    @FunctionalInterface
    interface MathOperation {
        int compute(int a, int b);
    }
    public static void main(String[] args) {
        MathOperation addition = (a, b) -> a + b;
        MathOperation subtraction = (a, b) -> a - b;
        MathOperation multiplication = (a, b) -> a * b;
        MathOperation division = (a, b) -> {
            if (b == 0) throw new ArithmeticException("Không thể chia cho 0");
            return a / b;
        };
        MathOperation powerOperation = (a, b) -> {
            int result = 1;
            for (int i = 0; i < b; i++) {
                result *= a;
            }
            return result;
        };
        System.out.println("  Tính lũy thừa: 2^3 = " + powerOperation.compute(2, 3));
        System.out.println("  Tính lũy thừa: 5^2 = " + powerOperation.compute(5, 2));
        MathOperation modulo = (x, y) -> x % y;
        System.out.println("  Phép modulo: 17 % 5 = " + modulo.compute(17, 5));
        System.out.println("\n--- THÍ DỤ 3: Sử dụng trong phương thức ---");
        System.out.println("Tính toán biểu thức: (12 + 8) × (20 ÷ 4) - 15");
        int step1 = calculate(12, 8, addition, "cộng");
        int step2 = calculate(20, 4, division, "chia");
        int step3 = calculate(step1, step2, multiplication, "nhân");
        int finalResult = calculate(step3, 15, subtraction, "trừ");
        System.out.println("Kết quả cuối cùng: " + finalResult);
    }
    private static int calculate(int a, int b, MathOperation operation, String operationName) {
        int result = operation.compute(a, b);
        System.out.println("  " + a + " " + operationName + " " + b + " = " + result);
        return result;
    }
}