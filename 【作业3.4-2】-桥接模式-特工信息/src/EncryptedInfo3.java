public class EncryptedInfo3 implements AgentInfo {
    private final MessageWriter writer;

    public EncryptedInfo3(MessageWriter c) {
        writer = c;
    }

    @Override
    public String encryptName(String inputStr) {
        return this.encryptCode(inputStr);
    }

    @Override
    public String encryptCode(String code) {
        char[] encryptCode = code.toCharArray();
        int len = code.length();
        for (int i = 0; i < len; i++) {
            if (encryptCode[i] != '9' && encryptCode[i] != 'z' && encryptCode[i] != 'Z') {
                encryptCode[i] += 1;
            } else if (encryptCode[i] == 'z') {
                encryptCode[i] = 'a';
            } else if (encryptCode[i] == 'Z') {
                encryptCode[i] = 'A';
            } else {
                encryptCode[i] = '0';
            }
        }
        return String.valueOf(encryptCode);
    }

    @Override
    public void log(String lastNm, String firstNm, String code) {
        String lName = encryptName(lastNm);
        String fName = encryptName(firstNm);
        String codeStr = encryptCode(code);
        System.out.println(lName + " " + fName + " " + codeStr);
        writer.logMsg(lName, fName, codeStr);
    }
}
