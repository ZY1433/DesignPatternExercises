package policy;

import insurance.AutoInsurance;
import insurance.LuxeryCarInsurance;

public class LuxeryCarInsuranceProducer implements PolicyProducer{
    @Override
    public AutoInsurance getInsurObj() {
        return new LuxeryCarInsurance();
    }
}
