import org.hyperic.sigar.Sigar;
import org.hyperic.sigar.SigarException;

public class ProcessListExample {
    public static void main(String[] args) {
        Sigar sigar = new Sigar();
        try {
            long[] pids = sigar.getProcList();
            for (long pid : pids) {
                System.out.println("Process ID: " + pid);
            }
        } catch (SigarException e) {
            e.printStackTrace();
        }
    }
}