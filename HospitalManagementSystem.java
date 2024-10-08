import java.util.*;

public class HospitalManagementSystem {
    private static HospitalDatabase database = new HospitalDatabase();
    private static Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        System.out.println("Welcome to the Hospital Management System");
        
        while (true) {
            System.out.println("\nMain Menu:");
            System.out.println("1. Patient Registration");
            System.out.println("2. Appointment Scheduling");
            System.out.println("3. Electronic Health Records");
            System.out.println("4. Billing and Invoicing");
            System.out.println("5. Inventory Management");
            System.out.println("6. Staff Management");
            System.out.println("0. Exit");
            
            System.out.print("Enter your choice: ");
            int choice = scanner.nextInt();
            scanner.nextLine(); 
            
            switch (choice) {
                case 1:
                    patientRegistration();
                    break;
                case 2:
                    appointmentScheduling();
                    break;
                case 3:
                    electronicHealthRecords();
                    break;
                case 4:
                    billingAndInvoicing();
                    break;
                case 5:
                    inventoryManagement();
                    break;
                case 6:
                    staffManagement();
                    break;
                case 0:
                    System.out.println("Thank you for using the Hospital Management System. Goodbye!");
                    System.exit(0);
                default:
                    System.out.println("Invalid choice. Please try again.");
            }
        }
    }

    private static void patientRegistration() {
        System.out.println("Patient Registration");
        System.out.print("Enter patient name: ");
        String name = scanner.nextLine();
        System.out.print("Enter patient date of birth (YYYY-MM-DD): ");
        String dob = scanner.nextLine();
        System.out.print("Enter patient contact info: ");
        String contactInfo = scanner.nextLine();

        Patient patient = new Patient(database.getNextPatientId(), name, dob, contactInfo);
        System.out.println("Patient registered successfully with ID: " + patient.getId());
    }

    private static void appointmentScheduling() {
        System.out.println();
        System.out.println("Appointment Scheduling");
        System.out.print("Enter patient ID: ");
        int patientId = scanner.nextInt();
        scanner.nextLine(); 
        
        System.out.print("Enter appointment date (YYYY-MM-DD): ");
        String appointmentDate = scanner.nextLine();
        
        System.out.print("Enter appointment time (HH:MM): ");
        String appointmentTime = scanner.nextLine();
        
        System.out.print("Enter doctor's name: ");
        String doctorName = scanner.nextLine();
        
        // Assuming all appointments will be booked successfully
        database.scheduleAppointment(patientId, appointmentDate, appointmentTime, doctorName);
        
        System.out.println("Appointment scheduled successfully.");
    }

    private static void electronicHealthRecords() {
        System.out.println("Electronic Health Records");
        System.out.print("Enter patient ID: ");
        int patientId = scanner.nextInt();
        scanner.nextLine(); // Consume newline

        // In a real system, we would fetch the patient's record from a database
        // For now, we'll just display a mock record
        System.out.println("\nElectronic Health Record for Patient ID: " + patientId);
        System.out.println("Name: Rajesh Kumar");
        System.out.println("Date of Birth: 1980-01-01");
        System.out.println("Blood Type: A+");
        System.out.println("Allergies: Penicillin");
        System.out.println("Recent Visits:");
        System.out.println("- 2023-05-15: Annual checkup");
        System.out.println("- 2023-03-02: Flu symptoms");
        System.out.println("Current Medications:");
        System.out.println("- Lisinopril 10mg daily");
        System.out.println("- Metformin 500mg twice daily");

        System.out.print("\nPress Enter to continue...");
        scanner.nextLine();
    }

    private static void billingAndInvoicing() {
        System.out.println("Billing and Invoicing");
        System.out.print("Enter patient ID: ");
        int patientId = scanner.nextInt();
        scanner.nextLine(); // Consume newline

        // In a real system, we would fetch the patient's billing information from a database
        // For now, we'll just display mock billing and invoice data
        System.out.println("\nBilling and Invoice Information for Patient ID: " + patientId);
        System.out.println("Name: Vivek Bhargav");
        System.out.println("Insurance Provider: HealthCare Plus");
        System.out.println("Policy Number: HCP-123456");

        System.out.println("\nRecent Invoices:");
        System.out.println("1. Invoice #INV-001");
        System.out.println("   Date: 2023-05-20");
        System.out.println("   Description: Annual checkup");
        System.out.println("   Amount: Rs.11,000.00");
        System.out.println("   Status: Paid");

        System.out.println("\n2. Invoice #INV-002");
        System.out.println("   Date: 2023-06-15");
        System.out.println("   Description: X-ray and consultation");
        System.out.println("   Amount: Rs.25,500.00");
        System.out.println("   Status: Pending");

        System.out.println("\nTotal Amount Due: Rs.25,500.00");

        System.out.print("\nPress Enter to continue...");
        scanner.nextLine();
    }

    private static void inventoryManagement() {
        System.out.println("Inventory Management");
        System.out.println("\nCurrent Inventory:");
        
        System.out.println("1. Surgical Masks");
        System.out.println("   Quantity: 5000");
        System.out.println("   Reorder Level: 1000");
        System.out.println("   Last Restocked: 2023-06-01");
        
        System.out.println("\n2. Disposable Gloves");
        System.out.println("   Quantity: 10000");
        System.out.println("   Reorder Level: 2000");
        System.out.println("   Last Restocked: 2023-05-15");
        
        System.out.println("\n3. Antibiotics (Amoxicillin)");
        System.out.println("   Quantity: 500");
        System.out.println("   Reorder Level: 100");
        System.out.println("   Expiry Date: 2024-03-31");
        
        System.out.println("\n4. IV Fluids");
        System.out.println("   Quantity: 200");
        System.out.println("   Reorder Level: 50");
        System.out.println("   Last Restocked: 2023-06-10");
        
        System.out.println("\nItems to Reorder:");
        System.out.println("- None at this time");
        
        System.out.print("\nPress Enter to continue...");
        scanner.nextLine();
    }

    private static void staffManagement() {
        System.out.println("Staff Management");
        System.out.println("\nCurrent Staff Records:");
        System.out.println("----------------------------------------------------------------------------------------------------");
        System.out.printf("%-20s %-20s %-25s %-15s %-15s\n", "Name", "Position", "Contact Information", "Shifts", "Salary");
        System.out.println("----------------------------------------------------------------------------------------------------");
        System.out.printf("%-20s %-20s %-25s %-15s Rs.%-14s\n", "Dr. Rajesh Kumar", "Senior Physician", "rajesh.k@hospital.com", "Mon-Fri 9-5", "150,000.00");
        System.out.printf("%-20s %-20s %-25s %-15s Rs.%-14s\n", "Priya Sharma", "Head Nurse", "priya.s@hospital.com", "Tue-Sat 7-3", "80,000.00");
        System.out.printf("%-20s %-20s %-25s %-15s Rs.%-14s\n", "Amit Patel", "Radiologist", "amit.p@hospital.com", "Mon-Thu 10-6", "120,000.00");
        System.out.printf("%-20s %-20s %-25s %-15s Rs.%-14s\n", "Sneha Gupta", "Pharmacist", "sneha.g@hospital.com", "Wed-Sun 8-4", "70,000.00");
        System.out.printf("%-20s %-20s %-25s %-15s Rs.%-14s\n", "Vikram Singh", "Lab Technician", "vikram.s@hospital.com", "Mon-Fri 7-3", "60,000.00");
        System.out.println("----------------------------------------------------------------------------------------------------");

        System.out.print("\nPress Enter to continue...");
        scanner.nextLine();
    }
}

class HospitalDatabase {
    private List<Patient> patients = new ArrayList<>();
    private int nextPatientId = 1000;

    public int getNextPatientId() {
        return nextPatientId++;
    }

    public void addPatient(Patient patient) {
        patients.add(patient);
    }

    public void scheduleAppointment(int patientId, String appointmentDate, String appointmentTime, String doctorName) {
        // In a real system, we would add this appointment to a list or database
        // For now, we'll just print the details
        System.out.println();
        System.out.println("Appointment scheduled:");
        System.out.println("Patient ID: " + patientId);
        System.out.println("Date: " + appointmentDate);
        System.out.println("Time: " + appointmentTime);
        System.out.println("Doctor: " + doctorName);
    }
}

class Patient {
    private int id;
    private String name;
    private String dateOfBirth;
    private String contactInfo;

    public Patient(int id, String name, String dateOfBirth, String contactInfo) {
        this.id = id;
        this.name = name;
        this.dateOfBirth = dateOfBirth;
        this.contactInfo = contactInfo;
    }

    public int getId() {
        return id;
    }
}