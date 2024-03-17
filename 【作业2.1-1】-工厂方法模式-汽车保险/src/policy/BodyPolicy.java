package policy;
//This is a sub class in the factory class hierarchy policy.PolicyProducer

import insurance.AutoInsurance;
import insurance.BodyInjur;

public class BodyPolicy implements PolicyProducer {
    public AutoInsurance getInsurObj() {
       return new BodyInjur();
    }
}
