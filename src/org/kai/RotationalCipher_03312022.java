package org.kai;


//
/*
 * Start 3/31/2022 8:49pm. complete 9:09pm. 20mins, including 4 minutes to setup IntelliJ SDK.
 * Rotational Cipher - One simple way to encrypt a string is to rotate every alphanumeric character by a certain amount.
 * Rotating a character means replacing it with another character that is a certain number of steps away in normal alphabetic
 * or numeric order.
 * For example, if the string "Zebra-493?" is rotated 3 places, the resulting string is Cheaud-726?".  Every alphabetic character
 * is replaced with character 3 letters higher (wrapping from Z to A) and every numeric character replaced with the character
 * 3 digits higher (wrapping around 9 to 0).  Note thta the non-alphanumeric characters remain uchanged.
 *
 * Given a string and a rotation factor, return an unencrypted string.
 * Input length 1 to 1mm
 * rotation factor 1 to 1mm
 * Output Return the result of the rotating input a number of times equal to rotation Factor.
*/
public class RotationalCipher_03312022 {

    // Examples

    public static void main (String[] args) {
        RotationalCipher_03312022 me = new RotationalCipher_03312022();

        String testcase1a = "Zebra-493?";
        int testcase1i = 3; // Cheud-726?

        String testcase2a = "abcdefghijklmNOPQRSTUVWXYZ0123456789";
        int testcase2i = 39; // nopqrstuvwxyzABCDEFGHIJKLM9012345678

        String testcase3a = "All-convoYs-9-be:Alert1.";
        int testcase3i = 4;  // "Epp-gsrzsCw-3-fi:Epivx5.";

        String testcase4a = "abcdZXYzxy-999.@";
        int testcase4i = 200;  // stuvRPQrpq-999.@"

        long startTime = System.currentTimeMillis();

        // Strategy 1
        System.out.println(me.rotationalCipher(testcase1a, testcase1i));
        System.out.println(me.rotationalCipher(testcase2a, testcase2i));
        System.out.println(me.rotationalCipher(testcase3a, testcase3i));
        System.out.println(me.rotationalCipher(testcase4a, testcase4i));


        System.out.println("Time taken " + (System.currentTimeMillis() - startTime));

    }

    /*
     * Strategy 1:
     *  A-Z is 65 to 90.
     * a-z is 97 to 122
     * 0-9 is 48 to 57
     */
    boolean debug = true;
    String rotationalCipher(String input, int rotationFactor) {
        // Write your code here
        StringBuilder sb = new StringBuilder();
        for (char c: input.toCharArray()) {
            if (c >=65 && c <=90) { // A-Z
                int rot = rotationFactor % 26;
                c+=rot;
                if (c>90)
                    c-=26;  // wrap
            } else if (c >=97 && c <=122) { // a-z
                int rot = rotationFactor % 26;
                c+=rot;
                if (c>122)
                    c-=26;  // wrap
            } else if (c >=48 && c <=57) {  // 0-9
                int rot = rotationFactor % 10;
                c+=rot;
                if (c>57)
                    c-=10;  // wrap
            }
            sb.append(c);

        }

        return sb.toString();
    }


}