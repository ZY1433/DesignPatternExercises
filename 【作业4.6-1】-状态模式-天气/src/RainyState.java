import java.awt.Color;
import javax.swing.ImageIcon;

public class RainyState extends WeatherState{

   public RainyState() {
       state = RAINY;
   }
   public String getCurrentState(){
       return state;
   }
   public String act(){
	   String voice = " It is raining hard outside...";
	   return voice;
   }
   public Color setColor(){
      return Color.gray;
   }
   public ImageIcon setImgIcon(){
      ImageIcon rainyIcon = new ImageIcon("【作业4.6-1】-状态模式-天气/src/images/Rainy.JPG");
      return rainyIcon;
   }
}


