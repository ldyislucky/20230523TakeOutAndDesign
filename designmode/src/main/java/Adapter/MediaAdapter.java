package Adapter;

/**
 * @author : ldy
 * @version : 1.0
 */
public class MediaAdapter implements AudioPlayer{
    private AudioPlayer player;

    public MediaAdapter(String fileName) {
        if (fileName.endsWith(".mp3")){
            player=new MP3Player();
        }else if (fileName.endsWith(".wav")){
            player=new WAVPlayer();
        }else if (fileName.endsWith("flac")){
            player=new FLACPlayer();
        }else {
            System.out.println("文档格式错误");
        }
    }

    @Override
    public void playMP3(String fileName) {
        player.playMP3(fileName);
    }

    @Override
    public void playWAV(String fileName) {
        player.playWAV(fileName);
    }

    @Override
    public void playFLAC(String fileName) {
        player.playFLAC(fileName);
    }
}
