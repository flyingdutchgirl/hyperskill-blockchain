import java.util.*;

class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String input = sc.nextLine();
        
        // just to show that both methods work well
        boolean result = Math.random() < 0.5 
        ? isPalindrome1(input)
        : isPalindrome2(input);
        
        System.out.println(result ? "yes" : "no");
    }
    
    // low-level solution
    public static boolean isPalindrome1(String str) {
        for (int i = 0, n = str.length() - 1; i < str.length() / 2; i++, n--) {
            if (str.charAt(i) != str.charAt(n)) {
                return false;
            }
        }
        
        return true;
    }    
    
    
    // high-level solution
    public static boolean isPalindrome2(String str) {
        StringBuilder sb = new StringBuilder(str);
        
        return sb.toString().equals(sb.reverse().toString());
    }
    
}
