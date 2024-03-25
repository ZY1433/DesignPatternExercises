import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;

public class Tuition {
    private final String STUDENT_TUITION_FILE = "【作业3.3-1】-外观模式-毕业生信息/src/Tuition.txt";
    private final String firstName;
    private final String lastName;
    private final String studNum;
    private ArrayList<String> studentTuition;

    //constructor
    public Tuition(String fname, String lname, String stuNum) {
        firstName = fname;
        lastName = lname;
        studNum = stuNum;
    }

    //Get tuition information paid by students
    public ArrayList<String> getStudentTuitionInfo(String file) {
        studentTuition = new ArrayList();
        try {
            BufferedReader reader = new BufferedReader(new FileReader(file));
            String line = reader.readLine();
            while (line != null) {
                if (line.length() != 0) {
                    String[] arr = line.split("\\,");

                    if (arr[0].trim().equals(firstName) && arr[1].trim().equals(lastName) && arr[2].trim().equals(studNum)) {
                        studentTuition.add(line);
                        break;
                    }
                }
                line = reader.readLine();
            }
        } catch (FileNotFoundException exc) {
            exc.printStackTrace();
            System.exit(1);
        } catch (IOException exc) {
            exc.printStackTrace();
            System.exit(1);
        }
        return studentTuition;
    }

    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public String getStudNumber() {
        return studNum;
    }
}

