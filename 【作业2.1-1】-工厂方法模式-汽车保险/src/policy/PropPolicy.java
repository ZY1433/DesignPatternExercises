package policy;
//This is a sub class in the factory class hierarchy policy.PolicyProducer


import insurance.AutoInsurance;
import insurance.Property;

public class PropPolicy implements PolicyProducer {

   public AutoInsurance getInsurObj() {
      return new Property();
   }
}