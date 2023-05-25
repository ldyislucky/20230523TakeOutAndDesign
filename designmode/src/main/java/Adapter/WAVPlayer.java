package Adapter;

/**
 * @author : ldy
 * @version : 1.0
 */
public class WAVPlayer implements AudioPlayer{
    @Override
    public void playMP3(String fileName) {

    }

    @Override
    public void playWAV(String fileName) {
        System.out.println("播放WAV格式的音乐："+fileName);
    }

    @Override
    public void playFLAC(String fileName) {

    }
}
