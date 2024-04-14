import java.awt.Color;
import javax.swing.ImageIcon;


public class SunnyState extends WeatherState {

   public SunnyState() {
   	   state = SUNNY;
   }
   public String getCurrentState(){
      return state;
   }
   public String act() {
	  String voice = "  The sun is shining...";
	  return voice;
   }
   public Color setColor(){
      return Color.green;
   }
   public ImageIcon setImgIcon(){
      ImageIcon sunnyIcon = new ImageIcon("【作业4.6-1】-状态模式-天气/src/images/Sunny.jpg");
      return sunnyIcon;
   }
}

