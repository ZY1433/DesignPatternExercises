package insurance;

public class LuxeryCarInsurance implements AutoInsurance{
    private String description;

    @Override
    public String getInfo(){
        description = "豪车保险优点包括: \n\n" +
                "给您的豪车有更好的保障，赔付上限更高；\n"+
                "专人帮您处理突发的事情，您无需操心；\n"+
                "赔付快，服务好，效益高！";
        return description;
    }
}
