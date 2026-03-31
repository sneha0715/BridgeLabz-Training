import java.util.*;

class Ticket {
    int price;

    Ticket(int price) {
        this.price = price;
    }
}

class TicketSorter {

    void quickSort(Ticket[] tickets, int low, int high) {
        if (low < high) {
            int pivotIndex = partition(tickets, low, high);
            quickSort(tickets, low, pivotIndex - 1);
            quickSort(tickets, pivotIndex + 1, high);
        }
    }

    int partition(Ticket[] tickets, int low, int high) {
        int pivot = tickets[high].price;
        int i = low - 1;

        for (int j = low; j < high; j++) {
            if (tickets[j].price <= pivot) {
                i++;
                Ticket temp = tickets[i];
                tickets[i] = tickets[j];
                tickets[j] = temp;
            }
        }

        Ticket temp = tickets[i + 1];
        tickets[i + 1] = tickets[high];
        tickets[high] = temp;

        return i + 1;
    }
}

public class EventManager {
    public static void main(String[] args) {

        Ticket[] tickets = {
                new Ticket(1500),
                new Ticket(500),
                new Ticket(2500),
                new Ticket(1000),
                new Ticket(800),
                new Ticket(3000)
        };

        TicketSorter sorter = new TicketSorter();
        sorter.quickSort(tickets, 0, tickets.length - 1);

        System.out.println("Sorted Ticket Prices:");
        for (Ticket t : tickets) {
            System.out.print(t.price + " ");
        }

        System.out.println("Top 3 Cheapest Tickets:");
        for (int i = 0; i < 3; i++) {
            System.out.println(tickets[i].price);
        }
    }
}
