package Adapter.Pattern;

public class Main {
    public static void main(String[] args) {
        System.out.println("=== TEST ADAPTER PATTERN ===\n");
        
        AudioPlayer audioPlayer = new AudioPlayer();
        
        audioPlayer.play("mp3", "bai-hat.mp3");
        audioPlayer.play("vlc", "video.vlc");
        audioPlayer.play("mp4", "phim.mp4");
    }
}