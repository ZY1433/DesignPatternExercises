package policy;
//This is the super class in the factory class hierarchy policy.PolicyProducer


import insurance.AutoInsurance;

public interface PolicyProducer
{
    public AutoInsurance getInsurObj();
}
