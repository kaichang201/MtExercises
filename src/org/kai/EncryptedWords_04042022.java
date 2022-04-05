package org.kai;


//
/*
 * Start 4/4/2022 7:47pm. 7:57pm. 10mins
 * You've devised a simple encryption method for alphabetic strings that shuffles the charactesr in such a way that the resulting
 * sting is hard to quickly read, but it is easy to conver back to the original string.
 * When you encrypt Strin S, you start with an initially-empty resulting string R and append the characters to it as follows:
 *  - Append the middle character of S. if S has even length, then we define the middle character as the left-most of the two central characters.
 *  - Append the encrypted version of substring of S that's to the left of the middle character, if non-empty.
 *  - Append the encrypted version of the substring of S that's to the right of the middle chracter, if non-empty.
 * For example to encrpy the string "abc", we first take b, then append a, then append c.
 * If we encrypt abc,xcba, we take x, then append cba
 * INput
 * S contains only lower-case chracters length 1 to 10,000
 *
*/
public class EncryptedWords_04042022 {

    // Examples

    public static void main (String[] args) {
        EncryptedWords_04042022 me = new EncryptedWords_04042022();

        String testcase1 = "abc"; // bac
        String testcase2 = "abcd"; // bacd
        String testcase3 = "abcxcba"; // xbacbca
        String testcase4 = "facebook"; // eafcobok


        long startTime = System.currentTimeMillis();

        // Strategy 1
       System.out.println(me.findEncryptedWord(testcase1)); // 3
        System.out.println(me.findEncryptedWord(testcase2)); // 3
        System.out.println(me.findEncryptedWord(testcase3)); // 3
        System.out.println(me.findEncryptedWord(testcase4)); // 3


        System.out.println("Time taken " + (System.currentTimeMillis() - startTime));

    }

    /*
     * Strategy 1:
     * recursion.  stop when length of s 1 or less.
     */
    String findEncryptedWord(String s) {
        if (s.length()<=1)
            return s;

        int mid = (s.length()-1)/2;
        StringBuilder sb = new StringBuilder();
        sb.append(s.charAt(mid));
        if (mid > 0)
            sb.append(findEncryptedWord(s.substring(0,mid)));
        if (mid < s.length())
            sb.append(findEncryptedWord(s.substring(mid+1)));
        return sb.toString();

    }




}