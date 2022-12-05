package strings;

public class Palindrome {

    public static void main(String[] args) {
        System.out.println(isPalindrome1("A man, a plan, a canal: Panama"));
        System.out.println(isPalindrome2("race a car"));
        System.out.println(isPalindrome3(" "));
    }

    // Slow method, 1500ms
    public static boolean isPalindrome1(String s) {
        s = s.replaceAll("[^a-zA-Z0-9]+", "").toLowerCase();
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append(s);
        return stringBuilder.reverse().toString().equals(s);
    }


    // Still slow 1500ms
    public static boolean isPalindrome2(String s) {
        s = s.replaceAll("[^a-zA-Z0-9]+", "").toLowerCase();
        if (s.isEmpty()) {
            return true;
        }
        char[] arr = s.toCharArray();
        boolean isPalindrome = true;
        for (int i = 0; i<arr.length/2; i++) {
            if (arr[i] != arr[arr.length - (i + 1)]) {
                isPalindrome = false;
                break;
            }
        }
        return isPalindrome;
    }

    // faster 5ms
    public static boolean isPalindrome3(String s) {
        if (s.isEmpty()) {
            return true;
        }

        int head = 0, tail = s.length()-1;
        char cHead, cTail;

        while (head < tail) {
            cHead = s.charAt(head);
            cTail = s.charAt(tail);

            if (!Character.isLetterOrDigit(cHead)) {
                head++;
            } else if (!Character.isLetterOrDigit(cTail)) {
                tail--;
            } else {
                if (Character.toLowerCase(cHead) != Character.toLowerCase(cTail)) {
                    return false;
                }
                head++;
                tail--;
            }
        }

        return true;
    }
}
