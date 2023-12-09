package helpers;

public class Formatter {
    public static String repeatChar(int width, char ch) {
        return String.valueOf(ch).repeat(Math.max(0, width));
    }
    
    public static String centerText(String str, int width) {
        return centerTextWithDecor(str, width, ' ');
    }

    public static String centerTextWithDecor(String str, int width, char ch) {
        int spaces = 0;
        
        if (width > str.length()) {
            spaces =  (width - str.length()) / 2;
        }
        
        StringBuilder sb = new StringBuilder();
        String repeat = String.valueOf(ch).repeat(Math.max(0, spaces));
        return sb.append(repeat).append(str).append(repeat).toString();
    }
    
    public static String leftPad(String str, int width) {
        StringBuilder sb = new StringBuilder();
        String repeat = String.valueOf(' ').repeat(Math.max(0, width));
        return sb.append(repeat).append(str).toString();
    }
}
