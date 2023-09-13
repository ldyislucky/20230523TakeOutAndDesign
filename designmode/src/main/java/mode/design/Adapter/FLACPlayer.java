package mode.design.Adapter;

/**
 * @author : ldy
 * @version : 1.0
 */
public class FLACPlayer implements AudioPlayer{
    @Override
    public void playMP3(String fileName) {

    }

    @Override
    public void playWAV(String fileName) {

    }

    @Override
    public void playFLAC(String fileName) {
        System.out.println("播放FLAC格式的音乐："+fileName);
    }
}
