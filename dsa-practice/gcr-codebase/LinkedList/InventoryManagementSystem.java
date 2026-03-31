class Item {
    int itemId;
    String itemName;
    int quantity;
    double price;
    Item next;

    Item(int itemId, String itemName, int quantity, double price) {
        this.itemId = itemId;
        this.itemName = itemName;
        this.quantity = quantity;
        this.price = price;
        this.next = null;
    }
}

class InventoryList {
    Item head;

    void addAtStart(int id, String name, int qty, double price) {
        Item item = new Item(id, name, qty, price);
        item.next = head;
        head = item;
    }

    void addAtEnd(int id, String name, int qty, double price) {
        Item item = new Item(id, name, qty, price);

        if (head == null) {
            head = item;
            return;
        }

        Item temp = head;
        while (temp.next != null) {
            temp = temp.next;
        }
        temp.next = item;
    }

    void addAtPosition(int pos, int id, String name, int qty, double price) {
        if (pos == 1) {
            addAtStart(id, name, qty, price);
            return;
        }

        Item temp = head;
        for (int i = 1; i < pos - 1 && temp != null; i++) {
            temp = temp.next;
        }

        if (temp == null) {
            addAtEnd(id, name, qty, price);
            return;
        }

        Item item = new Item(id, name, qty, price);
        item.next = temp.next;
        temp.next = item;
    }

    void removeById(int id) {
        if (head == null)
            return;

        if (head.itemId == id) {
            head = head.next;
            return;
        }

        Item temp = head;
        while (temp.next != null && temp.next.itemId != id) {
            temp = temp.next;
        }

        if (temp.next != null)
            temp.next = temp.next.next;
    }

    void updateQuantity(int id, int newQty) {
        Item temp = head;
        while (temp != null) {
            if (temp.itemId == id) {
                temp.quantity = newQty;
                return;
            }
            temp = temp.next;
        }
    }

    void searchById(int id) {
        Item temp = head;
        while (temp != null) {
            if (temp.itemId == id) {
                displayItem(temp);
                return;
            }
            temp = temp.next;
        }
        System.out.println("Item not found");
    }

    void searchByName(String name) {
        Item temp = head;
        boolean found = false;

        while (temp != null) {
            if (temp.itemName.equalsIgnoreCase(name)) {
                displayItem(temp);
                found = true;
            }
            temp = temp.next;
        }

        if (!found)
            System.out.println("Item not found");
    }

    void totalInventoryValue() {
        double total = 0;
        Item temp = head;

        while (temp != null) {
            total += temp.price * temp.quantity;
            temp = temp.next;
        }

        System.out.println("Total Inventory Value: " + total);
    }

    void sortByName(boolean ascending) {
        head = mergeSortByName(head, ascending);
    }

    void sortByPrice(boolean ascending) {
        head = mergeSortByPrice(head, ascending);
    }

    Item mergeSortByName(Item node, boolean asc) {
        if (node == null || node.next == null)
            return node;

        Item mid = getMiddle(node);
        Item nextMid = mid.next;
        mid.next = null;

        Item left = mergeSortByName(node, asc);
        Item right = mergeSortByName(nextMid, asc);

        return mergeByName(left, right, asc);
    }

    Item mergeByName(Item a, Item b, boolean asc) {
        if (a == null) return b;
        if (b == null) return a;

        Item result;
        if ((a.itemName.compareToIgnoreCase(b.itemName) <= 0) == asc) {
            result = a;
            result.next = mergeByName(a.next, b, asc);
        } else {
            result = b;
            result.next = mergeByName(a, b.next, asc);
        }
        return result;
    }

    Item mergeSortByPrice(Item node, boolean asc) {
        if (node == null || node.next == null)
            return node;

        Item mid = getMiddle(node);
        Item nextMid = mid.next;
        mid.next = null;

        Item left = mergeSortByPrice(node, asc);
        Item right = mergeSortByPrice(nextMid, asc);

        return mergeByPrice(left, right, asc);
    }

    Item mergeByPrice(Item a, Item b, boolean asc) {
        if (a == null) return b;
        if (b == null) return a;

        Item result;
        if ((a.price <= b.price) == asc) {
            result = a;
            result.next = mergeByPrice(a.next, b, asc);
        } else {
            result = b;
            result.next = mergeByPrice(a, b.next, asc);
        }
        return result;
    }

    Item getMiddle(Item node) {
        if (node == null)
            return node;

        Item slow = node, fast = node.next;
        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }
        return slow;
    }

    void displayInventory() {
        Item temp = head;
        while (temp != null) {
            displayItem(temp);
            temp = temp.next;
        }
    }

    void displayItem(Item i) {
        System.out.println("ID: " + i.itemId);
        System.out.println("Name: " + i.itemName);
        System.out.println("Quantity: " + i.quantity);
        System.out.println("Price: " + i.price);
    }
}

public class InventoryManagementSystem {
    public static void main(String[] args) {
        InventoryList inventory = new InventoryList();

        inventory.addAtStart(101, "Laptop", 5, 50000);
        inventory.addAtEnd(102, "Mouse", 20, 500);
        inventory.addAtPosition(2, 103, "Keyboard", 10, 1500);

        inventory.displayInventory();

        inventory.updateQuantity(102, 30);
        inventory.searchByName("Laptop");

        inventory.totalInventoryValue();

        inventory.sortByName(true);
        inventory.displayInventory();

        inventory.sortByPrice(false);
        inventory.displayInventory();
    }
}
