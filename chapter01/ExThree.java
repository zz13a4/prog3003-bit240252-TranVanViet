public class ExThree {
    interface Pair<K, V> {
        K getKey();
        V getValue();
    }
    static class OrderedPair<K, V> implements Pair<K, V> {
        private K key;
        private V value;
        public OrderedPair(K key, V value) {
            this.key = key;
            this.value = value;
        }
        @Override
        public K getKey() {
            return key;
        }
        @Override
        public V getValue() {
            return value;
        }
    }
    public static void main(String[] args) {
        Pair<String, Integer> studentIdPair = new OrderedPair<>("MSSV", 10170);
        Pair<String, String> studentNamePair = new OrderedPair<>("HoTen", "Nguyen Thi Hoa");
        System.out.println("=== Thông tin sinh viên ===");
        System.out.println(studentIdPair.getKey() + ": " + studentIdPair.getValue());
        System.out.println(studentNamePair.getKey() + ": " + studentNamePair.getValue());
        Pair<String, Double> gradePair = new OrderedPair<>("Điểm TB", 8.75);
        Pair<Integer, Boolean> statusPair = new OrderedPair<>(2024, true);
        System.out.println("\n=== Thông tin bổ sung ===");
        System.out.println(gradePair.getKey() + ": " + gradePair.getValue());
        System.out.println("Năm " + statusPair.getKey() + ": " + 
                          (statusPair.getValue() ? "Đang học" : "Đã tốt nghiệp"));
    }
}