package application.order;

public enum SUGER {
    NOMAL("正常糖"), HALF("半糖"), NONE("无糖");


    String desc;


    SUGER(String desc) {
        this.desc = desc;

    }

    public String toString() {
        return desc;
    }
}
