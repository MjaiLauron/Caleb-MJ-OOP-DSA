
package MIDTERM;

public class printJob {

    // PRIVATE ATTRIBUTES
    private String jobID;
    private String customerName;
    private int copies;

    // CONSTRUCTOR
    public printJob(String jobID, String customerName, int copies) {
        this.jobID = jobID;
        this.customerName = customerName;
        this.copies = copies;
    }

    // GETTERS
    public String getJobID() {
        return jobID;
    }

    public String getCustomerName() {
        return customerName;
    }

    public int getCopies() {
        return copies;
    }

    // PRINT TYPE METHOD
    public String getPrintType() {
        return "General";
    }
}