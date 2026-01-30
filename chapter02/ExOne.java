public class DatabaseConnection {
    private static DatabaseConnection instance;
    
    private DatabaseConnection() {
        System.out.println("Database connection created");
    }
    
    public static DatabaseConnection getInstance() {
        if (instance == null) {
            instance = new DatabaseConnection();
        }
        return instance;
    }
    
    public void connect() {
        System.out.println("Connected to database");
    }
    
    public void disconnect() {
        System.out.println("Disconnected from database");
    }
    
    public static void main(String[] args) {
        DatabaseConnection conn1 = DatabaseConnection.getInstance();
        conn1.connect();
        
        DatabaseConnection conn2 = DatabaseConnection.getInstance();
        conn2.connect();
        
        System.out.println("Same instance? " + (conn1 == conn2));
        
        conn1.disconnect();
    }
}