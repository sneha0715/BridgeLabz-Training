public class InvoiceGenerator {
    
    public static String[] parseInvoice(String input) {
        return input.split(",");
    }
  
    public static int getTotalAmount(String[] tasks) {
        int total = 0;
        for (String task : tasks) {
            String[] parts = task.split("-");
            if (parts.length == 2) {
                String amountPart = parts[1].replaceAll("[^0-9]", "");
                total += Integer.parseInt(amountPart);
            }
        }
        return total;
    }

    public static void main(String[] args) {
        String invoiceInput = "Logo Design - 3000 INR, Web Page - 4500 INR";
        System.out.println("===== Invoice Details =====");
        String[] tasks = parseInvoice(invoiceInput);
        for (String task : tasks) {
            System.out.println(task.trim());
        }
        int totalAmount = getTotalAmount(tasks);
        System.out.println("Total Invoice Amount: ₹" + totalAmount);
    }
}
