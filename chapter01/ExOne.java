public class ExOne {
    public static class Test<T> {
        private T value;
        public void set(T t) {
            this.value = t;
        }
        public T get() {
            return value;
        }
    }
    public static void main(String[] args) {
        Test<Integer> intTest = new Test<>();
        intTest.set(100);
        System.out.println("Giá trị Integer: " + intTest.get());
        Test<String> stringTest = new Test<>();
        stringTest.set("Hello Generics");
        System.out.println("Giá trị String: " + stringTest.get());
        Test<Double> doubleTest = new Test<>();
        doubleTest.set(3.14159);
        System.out.println("Giá trị Double: " + doubleTest.get());
    }
}