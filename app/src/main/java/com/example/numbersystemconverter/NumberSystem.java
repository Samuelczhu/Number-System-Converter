package com.example.numbersystemconverter;

/**
 * This number system class hold a number in decimal, and it can convert (output) to other number system very easily:.
 * It support four number systems: binary, 2's complement, hexadecimal, decimal
 */
public class NumberSystem {

    //Constants for the number systems
    public static final int BINARY = 0;
    public static final int TWOS = 1;
    public static final int HEXADECIMAL = 2;
    public static final int DECIMAL = 3;

    //Constants hold for digits in hexadecimal
    public static final String[] HEX = {"0","1","2","3","4","5","6","7","8","9","A","B","C","D","E","F"};

    private int number; //hold the number in decimal

    /**
     * default the number to 0
     */
    public NumberSystem() {
        this.number=0;
    }

    /**
     * input a number from a number system
     * basically convert to number
     * @param num String that represent a number
     * @param system the number system of the input number
     */
    public void inputNumber(String num, int system) throws IllegalArgumentException {
        if (system == BINARY) { //convert binary to decimal
            int ans=0;
            if (num.startsWith("-")) {
                for (int i=1;i<num.length();i++) {
                    if (num.charAt(i)=='0')
                        ans+=0;
                    else if (num.charAt(i)=='1')
                        ans+= Math.pow(2,num.length()-1-i);
                    else
                        throw new IllegalArgumentException("Invalid binary representation");
                }
                this.number = -ans; //found the number
                return;
            } else {
                for (int i=0;i<num.length();i++) {
                    if (num.charAt(i)=='0')
                        ans+=0;
                    else if (num.charAt(i)=='1')
                        ans+= Math.pow(2,num.length()-1-i);
                    else
                        throw new IllegalArgumentException("Invalid binary representation");
                }
                this.number = ans; //found the number
                return;
            }
        } else if (system == TWOS) { //convert 2's compliment to decimal
            int ans = 0;
            for (int i=1;i<num.length();i++) {
                if (num.charAt(i)=='0')
                    ans+=0;
                else if (num.charAt(i)=='1')
                    ans+= Math.pow(2,num.length()-1-i);
                else throw new IllegalArgumentException("Invalid 2\'s complement representation");
            }
            this.number = (num.charAt(0)=='1') ? (ans - (int)Math.pow(2,num.length()-1)) : (ans); //found the answer
            return;
        } else if (system == HEXADECIMAL) {
            int ans = 0;
            int n= num.length();
            num = num.toUpperCase(); //put them to uppercase
            if (num.startsWith("-")) {
                for (int i=1;i<n;i++) {
                    switch (num.charAt(i)) {
                        case '0':
                            break;
                        case '1':
                            ans += Math.pow(16,n-1-i);
                            break;
                        case '2':
                            ans += 2*Math.pow(16,n-1-i);
                            break;
                        case '3':
                            ans += 3*Math.pow(16,n-1-i);
                            break;
                        case '4':
                            ans += 4*Math.pow(16,n-1-i);
                            break;
                        case '5':
                            ans += 5*Math.pow(16,n-1-i);
                            break;
                        case '6':
                            ans += 6*Math.pow(16,n-1-i);
                            break;
                        case '7':
                            ans += 7*Math.pow(16,n-1-i);
                            break;
                        case '8':
                            ans += 8*Math.pow(16,n-1-i);
                            break;
                        case '9':
                            ans += 9*Math.pow(16,n-1-i);
                            break;
                        case 'A':
                            ans += 10*Math.pow(16,n-1-i);
                            break;
                        case 'B':
                            ans += 11*Math.pow(16,n-1-i);
                            break;
                        case 'C':
                            ans += 12*Math.pow(16,n-1-i);
                            break;
                        case 'D':
                            ans += 13*Math.pow(16,n-1-i);
                            break;
                        case 'E':
                            ans += 14*Math.pow(16,n-1-i);
                            break;
                        case 'F':
                            ans += 15*Math.pow(16,n-1-i);
                            break;
                        default:
                            throw new IllegalArgumentException("Invalid hexadecimal representation");
                    }
                }
                this.number = -ans;
                return;
            } else {
                for (int i=0;i<n;i++) {
                    switch (num.charAt(i)) {
                        case '0':
                            break;
                        case '1':
                            ans += Math.pow(16,n-1-i);
                            break;
                        case '2':
                            ans += 2*Math.pow(16,n-1-i);
                            break;
                        case '3':
                            ans += 3*Math.pow(16,n-1-i);
                            break;
                        case '4':
                            ans += 4*Math.pow(16,n-1-i);
                            break;
                        case '5':
                            ans += 5*Math.pow(16,n-1-i);
                            break;
                        case '6':
                            ans += 6*Math.pow(16,n-1-i);
                            break;
                        case '7':
                            ans += 7*Math.pow(16,n-1-i);
                            break;
                        case '8':
                            ans += 8*Math.pow(16,n-1-i);
                            break;
                        case '9':
                            ans += 9*Math.pow(16,n-1-i);
                            break;
                        case 'A':
                            ans += 10*Math.pow(16,n-1-i);
                            break;
                        case 'B':
                            ans += 11*Math.pow(16,n-1-i);
                            break;
                        case 'C':
                            ans += 12*Math.pow(16,n-1-i);
                            break;
                        case 'D':
                            ans += 13*Math.pow(16,n-1-i);
                            break;
                        case 'E':
                            ans += 14*Math.pow(16,n-1-i);
                            break;
                        case 'F':
                            ans += 15*Math.pow(16,n-1-i);
                            break;
                        default:
                            throw new IllegalArgumentException("Invalid hexadecimal representation");
                    }
                }
                this.number = ans;
                return;
            }
        } else if (system == DECIMAL) {
            try {
                this.number = Integer.parseInt(num);
            } catch (Exception e) {
                throw new IllegalArgumentException("Invalid decimal representation");
            }
        } else {
            throw new IllegalArgumentException("Invalid number system");
        }
    }

    /**
     * Get the binary representation of the number
     * @return binary representation of this number
     */
    public String toBinary() {
        if (this.number==0)
            return "0";
        StringBuilder ansB = new StringBuilder();
        int deci = Math.abs(this.number);
        while (deci>0) {
            ansB.insert(0,deci%2);
            deci/=2;
        }
        return (this.number>0) ? (ansB.toString()) : ("-"+ansB.toString());
    }

    /**
     * Get the 2's complement representation of the number
     * @return 2's complement representation of this number
     */
    public String toTwosComplement() {
        if (this.number==0)
            return "0";
        StringBuilder ansB = new StringBuilder();
        int deci = Math.abs(this.number);
        while (deci > 0) {
            ansB.insert(0, deci % 2);
            deci /= 2;
        }
        if (this.number==-1) {
            return "1111";
        }
        if (this.number>0)
            return "0"+ansB.toString();
        else
            return "1"+twosCompliment(ansB.toString());

    }

    /*  code from stack overflow to find 2's compliment
     https://stackoverflow.com/questions/42595963/how-to-get-2s-complement-of-a-binary-number-in-java-programmatically
     */
    public String twosCompliment(String bin) {
        String twos = "", ones = "";

        for (int i = 0; i < bin.length(); i++) {
            ones += flip(bin.charAt(i));
        }
        int number0 = Integer.parseInt(ones, 2);
        StringBuilder builder = new StringBuilder(ones);
        boolean b = false;
        for (int i = ones.length() - 1; i > 0; i--) {
            if (ones.charAt(i) == '1') {
                builder.setCharAt(i, '0');
            } else {
                builder.setCharAt(i, '1');
                b = true;
                break;
            }
        }
        if (!b)
            builder.append("1", 0, 7);

        twos = builder.toString();

        return twos;
    }
    // Returns '0' for '1' and '1' for '0'
    public char flip(char c) {
        return (c == '0') ? '1' : '0';
    }

    /**
     * Get the hexadecimal representation of the number
     * @return hexadecimal representation of this number
     */
    public String toHexadecimal() {
        if (this.number==0)
            return "0";
        StringBuilder ansB = new StringBuilder();
        int deci = Math.abs(this.number);
        while (deci>0) {
            ansB.insert(0,HEX[deci%16]);
            deci/=16;
        }
        return (this.number>0) ? (ansB.toString()) : ("-"+ansB.toString());
    }

    /**
     * Get the decimal representation of the number
     * @return decimal representation of this number
     */
    public String toDecimal() {
        return String.valueOf(this.number);
    }
}

