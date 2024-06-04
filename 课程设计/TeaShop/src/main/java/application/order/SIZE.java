package application.order;

public enum SIZE {
    S("小杯"), M("中杯"), L("大杯");

    String desc;


    SIZE(String desc) {
        this.desc = desc;

    }

    public String toString() {
        return desc;
    }
}
