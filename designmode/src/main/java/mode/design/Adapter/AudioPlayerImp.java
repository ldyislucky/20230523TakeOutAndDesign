package mode.design.Adapter;

/**
 * @author : ldy
 * @version : 1.0
 */
public class AudioPlayerImp {
  private AudioPlayer player;

  public AudioPlayerImp(String fileName) {
    if (fileName.endsWith(".mp3")||fileName.endsWith(".wav")||fileName.endsWith(".flac")){
      player = new MediaAdapter(fileName);
    }else {
      System.out.println("错误的文件格式");
    }
  }

  public void play(String fileName){
    if (fileName.endsWith(".mp3")){
      player.playMP3(fileName);
    }else if (fileName.endsWith(".wav")){
      player.playWAV(fileName);
    }else if (fileName.endsWith(".flac")){
      player.playFLAC(fileName);
    }else {
      System.out.println("文档格式错误");
    }
  }
}
