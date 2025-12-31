class PalindromeChecker {
    String text;

    boolean isPalindrome() {
        String cleanText = text.replaceAll("\\s+", "").toLowerCase();

        int start = 0;
        int end = cleanText.length() - 1;

        while (start < end) {
            if (cleanText.charAt(start) != cleanText.charAt(end)) {
                return false;
            }
            start++;
            end--;
        }
        return true;
    }

    void displayResult() {
        if (isPalindrome()) {
            System.out.println(text + " is palindrome");
        } else {
            System.out.println(text + " is not Palindrome");
        }
    }

    public static void main(String[] args) {
        PalindromeChecker p1 = new PalindromeChecker();
        p1.text = "A man a plan a canal Panama";
        p1.displayResult();
    }
}
