
import java.util.ArrayList;

public class Y2KFixer implements FileUpdateInterface {
    private ArrayList<String> inFile;

    public Y2KFixer(ArrayList<String> inFile) {
        this.inFile = inFile;
    }

    public ArrayList<String> update() {
        for (int m = 0; m < inFile.size(); m++) {
            String line = inFile.get(m);
            String updatedLine = line.replaceAll("\\b(\\d{2})-(\\d{2})-(\\d{2})\\b", "19$1-$2-$3");
            inFile.set(m, updatedLine);
        }
        return inFile;
    }
}
