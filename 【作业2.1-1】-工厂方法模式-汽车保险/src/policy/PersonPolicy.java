package policy;

//This is a sub class in the factory class hierarchy policy.PolicyProducer


import insurance.AutoInsurance;
import insurance.PersonInjur;

public class PersonPolicy implements PolicyProducer {

   public AutoInsurance getInsurObj() {
      return new PersonInjur();
   }
}
