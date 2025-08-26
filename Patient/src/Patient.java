import java.time.LocalDate;
import java.util.Locale;

public class Patient{
    private final String name;
    private final String patientID;
    private String journal;
    private final LocalDate today = LocalDate.now();

    public Patient(String name, String patientID){
        this.name = name;
        this.patientID = patientID;
        journal = "";

    }

    public void writeJournal(String journal){
        this.journal = this.journal + "\n"+ journal + " " + today;
    }

    public String info(){
        return String.format("Name: %s\nPatient's ID: %s\nJournal %s", name, patientID, journal);
    }

    @Override
    public String toString(){
        return info() ;
    }
}
