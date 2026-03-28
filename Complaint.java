import java.time.LocalDate;

public class Complaint {
    private String studentName;
    private String issue;
    private LocalDate date;
    private String status;

    public Complaint(String studentName, String issue, LocalDate date) {
        this.studentName = studentName;
        this.issue = issue;
        this.date = date;
        this.status = "Pending";
    }

    public void resolve() {
        status = "Resolved";
    }

    public String toFileString() {
        return studentName + "," + issue + "," + date + "," + status;
    }

    public static Complaint fromFileString(String line) {
        String[] parts = line.split(",");
        Complaint c = new Complaint(parts[0], parts[1], LocalDate.parse(parts[2]));
        if (parts[3].equals("Resolved")) {
            c.resolve();
        }
        return c;
    }

    @Override
    public String toString() {
        return studentName + " | " + issue + " | " + date + " | " + status;
    }
}