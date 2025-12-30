class Item {
    String itemCode;
    String itemName;
    double price;

    void displayItem() {
        System.out.println("itemCode : " + itemCode);
        System.out.println("itemPrice : " + price);
        System.out.println("itemName : " + itemName);
        System.out.println("----------------------------");
    }

    double calculateTotalCost(int quantity) {
        return price * quantity;
    }

    public static void main(String[] args) {

        Item item1 = new Item();
        item1.itemCode = "01AA";
        item1.itemName = "Water bottle";
        item1.price = 500.0;

        Item item2 = new Item();
        item2.itemCode = "01BB";
        item2.itemName = "Rice";
        item2.price = 700.0;


        item1.displayItem();
        item2.displayItem();


        int quantity = 2;
        System.out.println("Total cost of " + quantity + " Water bottles: "
                + item1.calculateTotalCost(quantity));
    }
}
