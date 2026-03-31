class Task {
    int taskId;
    String taskName;
    int priority;
    String dueDate;
    Task next;

    Task(int taskId, String taskName, int priority, String dueDate) {
        this.taskId = taskId;
        this.taskName = taskName;
        this.priority = priority;
        this.dueDate = dueDate;
        this.next = null;
    }
}

class TaskScheduler {
    Task head;
    Task current;

    void addAtStart(int id, String name, int priority, String date) {
        Task t = new Task(id, name, priority, date);

        if (head == null) {
            head = t;
            t.next = head;
            current = head;
            return;
        }

        Task temp = head;
        while (temp.next != head) {
            temp = temp.next;
        }

        t.next = head;
        temp.next = t;
        head = t;
    }

    void addAtEnd(int id, String name, int priority, String date) {
        Task t = new Task(id, name, priority, date);

        if (head == null) {
            head = t;
            t.next = head;
            current = head;
            return;
        }

        Task temp = head;
        while (temp.next != head) {
            temp = temp.next;
        }

        temp.next = t;
        t.next = head;
    }

    void addAtPosition(int pos, int id, String name, int priority, String date) {
        if (pos == 1) {
            addAtStart(id, name, priority, date);
            return;
        }

        Task temp = head;
        for (int i = 1; i < pos - 1 && temp.next != head; i++) {
            temp = temp.next;
        }

        Task t = new Task(id, name, priority, date);
        t.next = temp.next;
        temp.next = t;
    }

    void removeById(int id) {
        if (head == null)
            return;

        Task temp = head;
        Task prev = null;

        do {
            if (temp.taskId == id) {
                if (temp == head) {
                    Task last = head;
                    while (last.next != head) {
                        last = last.next;
                    }
                    head = head.next;
                    last.next = head;
                } else {
                    prev.next = temp.next;
                }
                return;
            }
            prev = temp;
            temp = temp.next;
        } while (temp != head);
    }

    void viewCurrentTask() {
        if (current == null) {
            System.out.println("No tasks available");
            return;
        }

        displayTask(current);
        current = current.next;
    }

    void displayAllTasks() {
        if (head == null)
            return;

        Task temp = head;
        do {
            displayTask(temp);
            temp = temp.next;
        } while (temp != head);
    }

    void searchByPriority(int priority) {
        if (head == null)
            return;

        Task temp = head;
        boolean found = false;

        do {
            if (temp.priority == priority) {
                displayTask(temp);
                found = true;
            }
            temp = temp.next;
        } while (temp != head);

        if (!found)
            System.out.println("No task found");
    }

    void displayTask(Task t) {

        System.out.println("Task ID: " + t.taskId);
        System.out.println("Task Name: " + t.taskName);
        System.out.println("Priority: " + t.priority);
        System.out.println("Due Date: " + t.dueDate);
    }
}

public class TaskSchedulerSystem {
    public static void main(String[] args) {
        TaskScheduler scheduler = new TaskScheduler();

        scheduler.addAtStart(1, "Assignment", 2, "10-Feb");
        scheduler.addAtEnd(2, "Project", 1, "15-Feb");
        scheduler.addAtPosition(2, 3, "Exam Prep", 1, "12-Feb");

        scheduler.displayAllTasks();

        scheduler.viewCurrentTask();
        scheduler.viewCurrentTask();

        scheduler.searchByPriority(1);
        scheduler.removeById(1);

        scheduler.displayAllTasks();
    }
}
