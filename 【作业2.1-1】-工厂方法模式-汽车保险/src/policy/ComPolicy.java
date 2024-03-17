package policy;
//This is a sub class in the factory class hierarchy policy.PolicyProducer

import insurance.AutoInsurance;
import insurance.ComCover;

public class ComPolicy implements PolicyProducer {

    public AutoInsurance getInsurObj() {
        return new ComCover();
    }
}
