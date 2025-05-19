public class ReverseEachWordInPlace {

    public static void reverseWords(char[] s) {
        int start = 0;

        for (int i = 0; i <= s.length; i++) {
            if (i == s.length || s[i] == ' ') {
                // Reverse characters from start to i - 1
                int left = start;
                int right = i - 1;

                while (left < right) {
                    // Swap characters using a temp variable (allowed)
                    char temp = s[left];
                    s[left] = s[right];
                    s[right] = temp;

                    left++;
                    right--;
                }

                start = i + 1;
            }
        }
    }

    public static void main(String[] args) {
        String input = "i love programming very much";
        char[] charArray = input.toCharArray();

        reverseWords(charArray);

        System.out.println(new String(charArray));
    }
}
