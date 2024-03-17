


/*=======================*/
/* Represents an air Wing      */
/*=======================*/

public class Wing extends AirUnit{

    public static final String FEATURES = "A Wing with 216 aircrafts";
    Airforce[] fighters = new Airforce[162];
    Airforce[] bombers = new Airforce[18];
    Airforce[] transporters= new Airforce[18];
    Airforce[] eAircrafts = new Airforce[18];

    public Wing(){
       for(int k=0;k<162;k++){
           fighters[k] = new F22();
           super.attach(fighters[k]);
	   }
       for(int k=0;k<18;k++){
           bombers[k] = new B52();
           super.attach(bombers[k] );
	   }
       for(int k=0;k<18;k++){
           transporters[k] = new C130J();
           super.attach(transporters[k]);
	   }
       for(int k=0;k<18;k++){
           eAircrafts[k] = new E9A();
           super.attach(eAircrafts[k]);
	   }
    }

    public String getDescription(){
	return FEATURES;
    }

    public String fight(){
	    return super.fight();
	}
}