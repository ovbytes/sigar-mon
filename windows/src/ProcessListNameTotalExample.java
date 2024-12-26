import org.hyperic.sigar.Sigar;
import org.hyperic.sigar.SigarException;
import org.hyperic.sigar.ProcExe;

public class ProcessListNameTotalExample {
    public static void main(String[] args) {
        Sigar sigar = new Sigar();
        try {
            long[] pids = sigar.getProcList();
            System.out.println("Total number of processes: " + pids.length);
            
            for (long pid : pids) {
               try {
    ProcExe procExe = sigar.getProcExe(pid);
    String processName = procExe.getName();
    System.out.println("Process ID: " + pid + ", Name: " + processName);
} catch (SigarException e) {
    if (e.getMessage().contains("Access denied")) {
        System.out.println("Process ID: " + pid + ", Name: <Access Denied>");
    } else {
        System.out.println("Process ID: " + pid + ", Name: <Process Ended>");
    }
}
            }
        } catch (SigarException e) {
            e.printStackTrace();
        } finally {
            sigar.close(); // Close the Sigar instance to release resources
        }
    }
}