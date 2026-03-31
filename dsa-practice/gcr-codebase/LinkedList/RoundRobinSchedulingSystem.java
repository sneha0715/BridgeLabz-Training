class Process {
    int pid;
    int burstTime;
    int remainingTime;
    int priority;
    int waitingTime;
    int turnAroundTime;
    Process next;

    Process(int pid, int burstTime, int priority) {
        this.pid = pid;
        this.burstTime = burstTime;
        this.remainingTime = burstTime;
        this.priority = priority;
        this.waitingTime = 0;
        this.turnAroundTime = 0;
        this.next = null;
    }
}

class RoundRobinScheduler {
    Process head;
    int timeQuantum;
    int currentTime = 0;

    RoundRobinScheduler(int timeQuantum) {
        this.timeQuantum = timeQuantum;
    }

    void addProcess(int pid, int burstTime, int priority) {
        Process p = new Process(pid, burstTime, priority);

        if (head == null) {
            head = p;
            p.next = head;
            return;
        }

        Process temp = head;
        while (temp.next != head) {
            temp = temp.next;
        }

        temp.next = p;
        p.next = head;
    }

    void removeProcess(Process prev, Process current) {
        if (current == head && current.next == head) {
            head = null;
            return;
        }

        if (current == head) {
            head = head.next;
        }

        prev.next = current.next;
    }

    void execute() {
        if (head == null)
            return;

        Process current = head;
        Process prev = null;

        while (head != null) {
            if (current.remainingTime > 0) {
                int execTime = Math.min(timeQuantum, current.remainingTime);
                current.remainingTime -= execTime;
                currentTime += execTime;
            }

            if (current.remainingTime == 0) {
                current.turnAroundTime = currentTime;
                current.waitingTime = current.turnAroundTime - current.burstTime;

                removeProcess(prev == null ? getLast() : prev, current);
                current = (prev == null) ? head : prev.next;
                displayQueue();
                continue;
            }

            prev = current;
            current = current.next;
            displayQueue();
        }
    }

    Process getLast() {
        Process temp = head;
        while (temp.next != head) {
            temp = temp.next;
        }
        return temp;
    }

    void displayQueue() {
        if (head == null) {
            System.out.println("Queue Empty");
            return;
        }

        Process temp = head;
        do {
            System.out.print("[PID " + temp.pid + " | RT " + temp.remainingTime + "] ");
            temp = temp.next;
        } while (temp != head);
        System.out.println();
    }

    void displayAverageTimes(Process[] completed) {
        double totalWT = 0, totalTAT = 0;

        for (Process p : completed) {
            totalWT += p.waitingTime;
            totalTAT += p.turnAroundTime;
        }

        System.out.println("Average Waiting Time: " + totalWT / completed.length);
        System.out.println("Average Turnaround Time: " + totalTAT / completed.length);
    }
}

public class RoundRobinSchedulingSystem {
    public static void main(String[] args) {
        RoundRobinScheduler scheduler = new RoundRobinScheduler(3);

        Process[] completed = new Process[3];
        completed[0] = new Process(1, 10, 1);
        completed[1] = new Process(2, 5, 2);
        completed[2] = new Process(3, 8, 1);

        for (Process p : completed) {
            scheduler.addProcess(p.pid, p.burstTime, p.priority);
        }

        scheduler.execute();
        scheduler.displayAverageTimes(completed);
    }
}
