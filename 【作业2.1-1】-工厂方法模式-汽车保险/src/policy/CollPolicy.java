package policy;
//This is a sub class in the factory class hierarchy policy.PolicyProducer

import insurance.AutoInsurance;
import insurance.Collision;

public class CollPolicy implements PolicyProducer {
    public AutoInsurance getInsurObj() {
        return new Collision();
    }
}
