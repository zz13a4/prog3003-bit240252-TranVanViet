class TV {
    public void turnOn() {
        System.out.println(" TV is ON");
    }
    
    public void setInput(String input) {
        System.out.println(" Input set to: " + input);
    }
    
    public void turnOff() {
        System.out.println(" TV is OFF");
    }
}

class SoundSystem {
    public void turnOn() {
        System.out.println(" Sound System is ON");
    }
    
    public void setVolume(int level) {
        System.out.println(" Volume set to: " + level);
    }
    
    public void setMode(String mode) {
        System.out.println(" Mode set to: " + mode);
    }
    
    public void turnOff() {
        System.out.println(" Sound System is OFF");
    }
}

class DVDPlayer {
    public void turnOn() {
        System.out.println(" DVD Player is ON");
    }
    
    public void play(String movie) {
        System.out.println(" Playing: " + movie);
    }
    
    public void turnOff() {
        System.out.println(" DVD Player is OFF");
    }
}

class Lights {
    public void dim(int level) {
        System.out.println(" Lights dimmed to " + level + "%");
    }
    
    public void turnOn() {
        System.out.println(" Lights turned ON");
    }
}

class HomeTheaterFacade {
    private TV tv;
    private SoundSystem sound;
    private DVDPlayer dvd;
    private Lights lights;
    public HomeTheaterFacade() {
        this.tv = new TV();
        this.sound = new SoundSystem();
        this.dvd = new DVDPlayer();
        this.lights = new Lights();
    }
    
    public void watchMovie(String movie) {
        System.out.println("\n STARTING MOVIE: " + movie);
        System.out.println("------------------------");
        lights.dim(20);
        tv.turnOn();
        tv.setInput("HDMI 1");
        sound.turnOn();
        sound.setVolume(75);
        sound.setMode("Dolby Surround");
        dvd.turnOn();
        dvd.play(movie);
        System.out.println("------------------------");
        System.out.println(" Movie setup complete!");
    }
    
    public void endMovie() {
        System.out.println("\n ENDING MOVIE...");
        System.out.println("------------------------");
        
        dvd.turnOff();
        sound.turnOff();
        tv.turnOff();
        lights.turnOn();
        
        System.out.println("------------------------");
        System.out.println(" System shut down complete!");
    }
    
    public void listenToRadio() {
        System.out.println("\n STARTING RADIO...");
        lights.dim(50);
        sound.turnOn();
        sound.setVolume(50);
        sound.setMode("Radio");
        System.out.println(" Radio is playing!");
    }
}

public class HomeTheater {
    public static void main(String[] args) {
        System.out.println("=== HOME THEATER FACADE DEMO ===\n");
        HomeTheaterFacade theater = new HomeTheaterFacade();
        theater.watchMovie("The Matrix");
        System.out.println("\n[2 hours later...]");
        theater.endMovie();
        System.out.println("\n--- Using another function ---");
        theater.listenToRadio();
    }
}