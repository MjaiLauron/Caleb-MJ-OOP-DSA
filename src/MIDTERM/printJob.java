
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
    
    // CHILD CLASS 1: DOCUMENT
    public static class DocumentPrintJob extends printJob {

        public DocumentPrintJob(String jobID, String customerName, int copies) {
            super(jobID, customerName, copies);
        }

        @Override
        public String getPrintType() {
            return "Document";
        }
    }

    // CHILD CLASS 2: PHOTO
    public static class PhotoPrintJob extends printJob {

        public PhotoPrintJob(String jobID, String customerName, int copies) {
            super(jobID, customerName, copies);
        }

        @Override
        public String getPrintType() {
            return "Photo";
        }
    }
    
// Manual circular array queue
    public static class PrintQueue {

        private printJob[] jobs;
        private int front;
        private int rear;
        private int count;

        public PrintQueue() {
            jobs = new printJob[100];
            front = 0;
            rear = -1;
            count = 0;
        }

        // Add a job to the queue
        public boolean addJob(printJob job) {
            if (job == null || count == jobs.length) {
                return false;
            }

            rear = (rear + 1) % jobs.length;
            jobs[rear] = job;
            count++;

            return true;
        }

        // Process the first job in the queue
        public printJob processNextJob() {
            if (count == 0) {
                return null;
            }

            printJob job = jobs[front];
            jobs[front] = null;

            front = (front + 1) % jobs.length;
            count--;

            return job;
        }

        // Get the number of waiting jobs
        public int getJobCount() {
            return count;
        }

        // Check if the queue is empty
        public boolean isEmpty() {
            return count == 0;
        }

        // Get all waiting jobs in queue order
        public printJob[] getWaitingJobs() {
            printJob[] waitingJobs = new printJob[count];

            for (int i = 0; i < count; i++) {
                int index = (front + i) % jobs.length;
                waitingJobs[i] = jobs[index];
            }

            return waitingJobs;
        } 
