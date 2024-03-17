package insurance;

//This is a sub class in the product class hierarchy insurance.AutoInsurance


public class Property implements AutoInsurance {
   private String description;

   public String getInfo() {
	   description = "insurance.Property-Damage Liability Coverage: \n\n"+
	                  "This coverage pays for the repair "+
	                  "and replacement of vehicles and "+
	                  "other property damaged when you "+
	                  "or another authorized driver  "+
	                  "causes an accident";
	   return description;
   }
}
