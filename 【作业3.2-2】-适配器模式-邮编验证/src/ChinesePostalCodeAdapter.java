public class ChinesePostalCodeAdapter extends ChinesePostalCode implements ZipCodeValidator {
    private ChinesePostalCode chinesePostalCode;

    public ChinesePostalCodeAdapter(ChinesePostalCode pCode) {
        this.chinesePostalCode = pCode;
    }

    public boolean isValidZipCode(String zip, String state) {
        // In Chinese postal code, state parameter is not applicable
        return chinesePostalCode.isValidChinesePCode(zip);
    }
}
