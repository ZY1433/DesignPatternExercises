import java.awt.Color;
import javax.swing.ImageIcon;

public class SnowingState extends WeatherState{

    public SnowingState() {
        state = SNOWING;
    }
    public String getCurrentState(){
        return state;
    }
    public String act(){
        String voice = "Snow is falling...";
        return voice;
    }
    public Color setColor(){
        return Color.white;
    }
    public ImageIcon setImgIcon(){
        ImageIcon sonwingIcon = new ImageIcon("【作业4.6-1】-状态模式-天气/src/images/Snowing.JPG");
        return sonwingIcon;
    }
}


