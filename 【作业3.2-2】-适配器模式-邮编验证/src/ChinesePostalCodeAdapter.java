public class ChinesePostalCodeAdapter extends ChinesePostalCode implements ZipCodeValidator {
    private ChinesePostalCode chinesePostalCode;

    public ChinesePostalCodeAdapter(ChinesePostalCode pCode) {
        this.chinesePostalCode = pCode;
    }

    public boolean isValidZipCode(String zip, String state) {
        return chinesePostalCode.isValidChinesePCode(zip);
    }
}
