package mode.design.Adapter;

/**
 * @author : ldy
 * @version : 1.0
 */
public class Main {
  public static void main(String[] args) {
    AudioPlayerImp audioPlayerImp = new AudioPlayerImp("test.mp3");
    audioPlayerImp.play("test.mp3");

    AudioPlayerImp wavPlayer = new AudioPlayerImp("test.wav");
    wavPlayer.play("test.wav");
  }
}
