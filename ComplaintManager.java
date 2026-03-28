import java.util.*;
import java.io.*;
import java.time.LocalDate;

public class ComplaintManager {
    private List<Complaint> complaints = new ArrayList<>();
    private final String FILE_NAME = "complaints.txt";

    public ComplaintManager() {
        loadComplaints();
    }

    public void addComplaint(String name, String issue, LocalDate date) {
        complaints.add(new Complaint(name, issue, date));
        saveComplaints();
        System.out.println("Complaint registered successfully!");
    }

    public void viewComplaints() {
        if (complaints.isEmpty()) {
            System.out.println("No complaints found.");
            return;
        }

        for (int i = 0; i < complaints.size(); i++) {
            System.out.println(i + ": " + complaints.get(i));
        }
    }

    public void resolveComplaint(int index) {
        if (index >= 0 && index < complaints.size()) {
            complaints.get(index).resolve();
            saveComplaints();
            System.out.println("Complaint resolved!");
        } else {
            System.out.println("Invalid index!");
        }
    }

    private void saveComplaints() {
        try (PrintWriter writer = new PrintWriter(new FileWriter(FILE_NAME))) {
            for (Complaint c : complaints) {
                writer.println(c.toFileString());
            }
        } catch (IOException e) {
            System.out.println("Error saving data.");
        }
    }

    private void loadComplaints() {
        File file = new File(FILE_NAME);
        if (!file.exists()) return;

        try (Scanner sc = new Scanner(file)) {
            while (sc.hasNextLine()) {
                complaints.add(Complaint.fromFileString(sc.nextLine()));
            }
        } catch (Exception e) {
            System.out.println("Error loading data.");
        }
    }
}