public class ChinesePostalCode {

    public boolean isValidChinesePCode(String pcode) {
        // �й���������Ӧ�� 6 λ�������
        return pcode.matches("\\d{6}");
    }
}
