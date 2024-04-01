
import java.util.Vector;

public class ShoeInfoVisitor extends Visitor{

   private String[] s = new String[9];

   public String describeShoes() {
	   String infoStr ="\n";
	   for(int n=0; n< 9; n++){
	      if(s[n] != null){
	         infoStr = infoStr + s[n]+"\n";
		  }
	   }
	   return infoStr;
    }

	public void visitAdidas(Adidas e){
		s[0] = e.getDescription();
	   // write code here. 给s[0]赋值
	}
	public void visitSalomon(Salomon e){
		s[1] = e.getDescription();
        // write code here。给s[1]赋值
	}
	public void visitPonyMexico(PonyMexico e){
		s[2] = e.getDescription();
        // write code here
    }
	public void visitNorthFace (NorthFace e){
		s[3] = e.getDescription();
        // write code here
	}
	public void visitNike(Nike e){
		s[4] = e.getDescription();
        // write code here
    }
	public void visitMephisto(Mephisto e){
		s[5] = e.getDescription();
        // write code here
	}
	public void visitGlobeBlitz (GlobeBlitz e){
		s[6] = e.getDescription();
        // write code here
    }
	public void visitGlobeAppleyard(GlobeAppleyard e){
		s[7] = e.getDescription();
        // write code here
	}
    public void visitDCShoesRover(DCShoesRover e){
		s[8] = e.getDescription();
        // write code here。给s[8]赋值
	}
}

