public class SentenceFormatter {
  
    public static String formatParagraph(String paragraph) {
       
        if (paragraph == null || paragraph.trim().isEmpty()) {
            return "";
        }
        
        paragraph = paragraph.trim().replaceAll("\\s+", " ");
        StringBuilder result = new StringBuilder();
        boolean capitalizeNext = true;
        for (int i = 0; i < paragraph.length(); i++) {
            char ch = paragraph.charAt(i);
           
            if (capitalizeNext && Character.isLetter(ch)) {
                result.append(Character.toUpperCase(ch));
                capitalizeNext = false;
            } else {
                result.append(ch);
            }
            
            if (ch == '.' || ch == '?' || ch == '!') {
                capitalizeNext = true;
                
                if (i + 1 < paragraph.length() && paragraph.charAt(i + 1) != ' ') {
                    result.append(" ");
                }
            }
        }
        return result.toString();
    }
    public static void main(String[] args) {
        String input = "  hello   world.this is   a test!how are you?i am fine. ";
        System.out.println("OriginalText:");
        System.out.println(input);
        String formattedText = formatParagraph(input);
        System.out.println("\nFormattedText:");
        System.out.println(formattedText);
    }
}
