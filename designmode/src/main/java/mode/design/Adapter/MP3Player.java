package mode.design.Adapter;

/**
 * @author : ldy
 * @version : 1.0
 */
public class MP3Player implements AudioPlayer{
    @Override
    public void playMP3(String fileName) {
        System.out.println("播放MP3格式的音乐："+fileName);
    }

    @Override
    public void playWAV(String fileName) {

    }

    @Override
    public void playFLAC(String fileName) {

    }
}
