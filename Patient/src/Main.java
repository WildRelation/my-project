public class Main{
    public static void main(String[] args){
        Patient p1 = new Patient("Joseph", "1234567891");
        p1.writeJournal("Patient arrived today for the first consultation. " +
                "Reported mild chest discomfort and occasional shortness of breath. " +
                "Vitals stable. Scheduled further tests.");
        p1.writeJournal("Two weeks after medication start: " +
                "patient reports improved sleep and reduced anxiety. " +
                "No side effects observed. Continue same dosage.");
        p1.writeJournal("Patient shows steady recovery post-surgery. " +
                "Mobility increasing, pain level decreasing. " +
                "Will re-evaluate physiotherapy plan next week.");
        System.out.println(p1.toString());

    }
}