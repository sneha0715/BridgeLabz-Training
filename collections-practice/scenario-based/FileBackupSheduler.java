import java.util.*;

class InvalidBackupPathException extends Exception {
    public InvalidBackupPathException(String message) {
        super(message);
    }
}

class BackupTask implements Comparable<BackupTask> {
    private String folderPath;
    private boolean critical;
    private int priority;

    public BackupTask(String folderPath, boolean critical) throws InvalidBackupPathException {
        if (folderPath == null || folderPath.trim().isEmpty()) {
            throw new InvalidBackupPathException("Invalid backup path");
        }
        this.folderPath = folderPath;
        this.critical = critical;
        this.priority = critical ? 1 : 2;
    }

    public String getFolderPath() {
        return folderPath;
    }

    public boolean isCritical() {
        return critical;
    }

    @Override
    public int compareTo(BackupTask other) {
        return Integer.compare(this.priority, other.priority);
    }

    @Override
    public String toString() {
        return "BackupTask{path='" + folderPath + "', critical=" + critical + "}";
    }
}

class BackupScheduler {
    private PriorityQueue<BackupTask> queue = new PriorityQueue<>();

    public void scheduleBackup(String path, boolean critical) {
        try {
            BackupTask task = new BackupTask(path, critical);
            queue.offer(task);
            System.out.println("Scheduled: " + task);
        } catch (InvalidBackupPathException e) {
            System.out.println(e.getMessage());
        }
    }

    public void executeBackups() {
        System.out.println("Executing backup tasks by priority:");
        while (!queue.isEmpty()) {
            BackupTask task = queue.poll();
            System.out.println("Backing up folder: " + task.getFolderPath() + (task.isCritical() ? " [CRITICAL]" : ""));
        }
    }
}

public class FileBackupSheduler {
    public static void main(String[] args) {
        BackupScheduler scheduler = new BackupScheduler();

        scheduler.scheduleBackup("C:/Users/Documents", false);
        scheduler.scheduleBackup("C:/System/Config", true);
        scheduler.scheduleBackup("", true);
        scheduler.scheduleBackup("D:/Projects", false);
        scheduler.scheduleBackup("C:/Database", true);

        scheduler.executeBackups();
    }
}
