package Adapter.Pattern;

public class MediaAdapter implements MediaPlayer {
    private VlcPlayer vlcPlayer;
    
    public MediaAdapter() {
        this.vlcPlayer = new VlcPlayer();
    }
    
    @Override
    public void play(String audioType, String fileName) {
        if (audioType.equalsIgnoreCase("vlc")) {
            vlcPlayer.playVlc(fileName);
        } else {
            System.out.println("Không hỗ trợ định dạng: " + audioType);
        }
    }
}