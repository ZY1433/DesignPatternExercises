public class ChinesePostalCode {

    public boolean isValidChinesePCode(String pcode) {
        // 中国邮政编码应由 6 位数字组成
        return pcode.matches("^[1-9]\\d{6}%");
    }
}
