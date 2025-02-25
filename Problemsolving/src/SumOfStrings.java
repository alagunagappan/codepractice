/**
 * Given two non-negative integers num1 and num2 represented as string, return the sum of num1 and num2.
 *
 * The length of both num1 and num2 is < 5100.
 * Both num1 and num2 contains only digits 0-9.
 * Both num1 and num2 does not contain any leading zero.
 * You must not use any built-in BigInteger library or convert the inputs to integer directly.
 *
 * Example : String A: "123"
 *           String B: "456"
 *           and the method should return "579".
 */
public class SumOfStrings {

    public static void main(String[] args) {
        SumOfStrings sumOfStrings = new SumOfStrings();
        String s1 = "236";
        String s2 = "50";
        String result = sumOfStrings.doSum(s1, s2);
        System.out.println(result);
    }

    public String doSum(String s1, String s2) {
        int p1 = s1.length() - 1, p2 = s2.length() - 1;
        int sum, carry = 0;
        StringBuilder result = new StringBuilder();
        while( p1 >= 0 && p2 >= 0) {
            int op1 = s1.charAt(p1--) - '0';
            int op2 = s2.charAt(p2--) - '0';
            sum = op1 + op2 + carry;
            carry = sum > 9 ? 1 : 0;
            if(sum > 9)
                sum = sum % 10;
            result.append(sum);
        }

        if(p1 >= 0) {
            while(p1 >= 0) {
                int op1 = s1.charAt(p1--) - '0';
                sum = op1 + carry;
                carry = sum > 9 ? 1 : 0;
                if(sum > 9)
                    sum = sum % 10;
                result.append(sum);
            }
        }

        if(p2 >= 0) {
            while(p2 >= 0) {
                int op1 = s2.charAt(p2--) - '0';
                sum = op1 + carry;
                carry = sum > 9 ? 1 : 0;
                if(sum > 9)
                    sum = sum % 10;
                result.append(sum);
            }
        }

        if(carry > 0)
            result.append(carry);

        /*while(p1 >= 0 || p2 >=0 || carry > 0) {
            int op1 = (p1 >= 0) ? s1.charAt(p1--) - '0' : 0;
            int op2 = (p2 >= 0) ? s2.charAt(p2--) - '0' : 0;
            sum = op1 + op2 + carry;
            carry = sum/10;

            result.append(sum % 10);
        }*/
        return result.reverse().toString();
    }
}
