
package computer;

public class Computer {
    private String HDD;
    private String RAM;
    private boolean isBluetoothEnabled;

    private Computer(ComputerBuilder builder) {
        this.HDD = builder.HDD;
        this.RAM = builder.RAM;
        this.isBluetoothEnabled = builder.isBluetoothEnabled;
    }

    public static class ComputerBuilder {
        private String HDD;
        private String RAM;
        private boolean isBluetoothEnabled;

        public ComputerBuilder(String hdd, String ram) {
            this.HDD = hdd;
            this.RAM = ram;
        }

        public ComputerBuilder setBluetoothEnabled(boolean enabled) {
            this.isBluetoothEnabled = enabled;
            return this;
        }

        public Computer build() {
            return new Computer(this);
        }
    }

    @Override
    public String toString() {
        return "Computer [HDD=" + HDD + ", RAM=" + RAM +
               ", Bluetooth=" + (isBluetoothEnabled ? "Có" : "Không") + "]";
    }

    public static void main(String[] args) {
        Computer pc1 = new Computer.ComputerBuilder("1TB", "16GB")
                .setBluetoothEnabled(true)
                .build();

        Computer pc2 = new Computer.ComputerBuilder("512GB", "8GB")
                .setBluetoothEnabled(false)
                .build();

        System.out.println(pc1);
        System.out.println(pc2);
    }
}
