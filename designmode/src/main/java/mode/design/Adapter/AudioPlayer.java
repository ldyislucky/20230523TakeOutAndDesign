package mode.design.Adapter;

/**
 * @author : ldy
 * @version : 1.0
 */
public interface AudioPlayer {
    void playMP3(String fileName);
    void playWAV(String fileName);
    void playFLAC(String fileName);
}
