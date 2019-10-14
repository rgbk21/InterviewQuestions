package PrimitiveTypes;

public class Page44 {
    //Write a program to count the number of bits that are set to 1 in an integer
    public int countBits(int x){

        int numOfSetBits = 0;
        while(x != 0){
            numOfSetBits = numOfSetBits + (x & 1);
            x = x >> 1;
            System.out.println("Decimal value of x: " + x);
            System.out.println("Same x as Binary: " + Integer.toBinaryString(x));
        }
        return numOfSetBits;
    }

    public int improved_countBits(int x){

        int numOfSetBits = 0;
        while(x != 0){
            System.out.println("Decimal value of x before AND: " + x);
            System.out.println("Same x as Binary before AND: " + Integer.toBinaryString(x));
            numOfSetBits += 1;
            x = x & (x-1);
            System.out.println("Decimal value of x after AND: " + x);
            System.out.println("Same x as Binary after AND: " + Integer.toBinaryString(x));
        }
        return numOfSetBits;
    }

    public static void main(String[] args) {
        Page44 mySolution = new Page44();
        int myInt = 64;
        System.out.println("Original Integer as Binary String: " + Integer.toBinaryString(myInt));
        System.out.println("Calling Method");
        System.out.println(mySolution.countBits(myInt));
        System.out.println(mySolution.improved_countBits(myInt));
    }
}

class page46{
    //The parity of a binary word is 1 if the number of Is in the word is odd; otherwise,
    //it is 0. For example, the parity of 1011 is 1, and the parity of 10001000 is 0.

    public boolean powerOfTwo(int x){

        if((x & (x-1)) == 0 && x !=0){
            return true;
        }else{
            return false;
        }
    }

    public int parity(int x){
        int result = 0;
        while(x != 0){
            result = result ^ (x & 1);
            x = x >>> 1;
            System.out.println("Decimal value of x: " + x);
            System.out.println("Same x as Binary: " + Integer.toBinaryString(x));
            System.out.println("Result as Binary: " + Integer.toBinaryString(result));
        }
        return result;
    }

    public int improved_parity(int x){
        int result = 0;
        while(x != 0){
            System.out.println("Decimal value of x: " + x);
            System.out.println("Same x as Binary: " + Integer.toBinaryString(x));
            result = result ^ 1;
            x = x & (x-1);//This is the reason this method is "improved"
            System.out.println("Decimal value of x after &: " + x);
            System.out.println("Same x as Binary after &: " + Integer.toBinaryString(x));
            System.out.println("Result as Binary: " + Integer.toBinaryString(result));
        }
        return result;
    }

    public int parity_with_cache(int x){

        int[] parityStore = {};//This will store the parity of numbers 0 through to 2^16 - 1
        int result = 0;
        int mask_0_15 = 0x0000ffff;
        int mask_16_31 = 0xffff0000;
        //Break x into 2 chunks of 16 bits
        //Lookup the parity of each of those 2 chunks
        //Parity of the resulting chunk  can be found out by computing the XOR of each of the parityLookups
        //XOR is addition without carry, so the order is not important.
        return result;
    }

    public int parity_with_bitshift(long x){

        int result;

        x = x ^ (x >>> 32);
        System.out.println("x after right_shift_32 " + Long.toBinaryString(x));
        x = x ^ (x >>> 16);
        System.out.println("x after right_shift_16 " + Long.toBinaryString(x));
        x = x ^ (x >>> 8);
        System.out.println("x after right_shift_8 " + Long.toBinaryString(x));
        x = x ^ (x >>> 4);
        System.out.println("x after right_shift_4 " + Long.toBinaryString(x));
        x = x ^ (x >>> 2);
        System.out.println("x after right_shift_2 " + Long.toBinaryString(x));
        x = x ^ (x >>> 1);
        System.out.println("x after right_shift_1 " + Long.toBinaryString(x));

        result = (int) (x & 0x1);
        System.out.println(result);

        return result;
    }


    public static void main(String[] args) {
        page46 mySolution = new page46();
        int myInt = 32;
        int myInt2 = -1 >>> 31;
        long myInt3 = 32;
        System.out.println("myInt2: " + Long.toBinaryString(myInt2));
        myInt3 ^= myInt3 >>> 32;
        System.out.println("myInt3: " + Long.toBinaryString(myInt3));

        System.out.println("myInt2: " + myInt2);
        System.out.println("Original Integer as Binary String: " + Integer.toBinaryString(myInt));
        System.out.println("Original Integer - 1 as Binary String: " + Integer.toBinaryString(myInt-1));
        System.out.println("myInt & (myInt - 1) :" +Integer.toBinaryString(myInt & (myInt - 1)));

        System.out.println("Calling Method");
//        System.out.println(mySolution.parity(myInt));
        System.out.println(mySolution.improved_parity(myInt));
        System.out.println(mySolution.parity_with_bitshift(-1));
    }
}

class page48{

    //A 64-bit integer can be viewed as an array of 64 bits, with the bit at index 0 corre¬
    //sponding to the least significant bit (LSB), and the bit at index 63 corresponding to
    //the most significant bit (MSB). Implement code that takes as input a 64-bit integer
    //and swaps the bits at indices i and y.

    public long swapBits(long x, int i, int j) {

        long result = 0L;
        //First we need to check if the bits at the indices i and j are same or different
        if(((x >>> i) & 1) != ((x >>> j) & 1)){
            //Because we reached here, it means that the bits at these locations were different
            //So, now we have to swap the bits
            //First we need to create the correct masks
            long bitMask = 1L << i | 1L << j;
            System.out.println("BitMask: " + Long.toBinaryString(bitMask));
            result = x ^ bitMask;
        }
        System.out.println("Result: " + result);
        return result;
    }

    public static void main(String[] args) {

        page48 mySolution = new page48();
        int myNum = 64;
        System.out.println("Long in Binary: " + Integer.toBinaryString(myNum));
        System.out.println(Long.toBinaryString(mySolution.swapBits(64L, 0,6)));
    }
}

class page50{


    //This means the smallest k1 can be is the rightmost bit that's different from the LSB, and k2 must be
    //the very next bit. In summary, the correct approach is to swap the two rightmost
    //consecutive bits that differ.
    public long closestIntSameBitCount(long x) {
        long y = x;
        int bitPosition = 0;
        while(y != 0){
            if((y & 0b1) != (y & 0b10)){
                long bitMask = (1L << bitPosition) | (1L << (bitPosition+1));
                System.out.println("Bit Mask: " + Long.toBinaryString(bitMask));
                x = x ^ bitMask;
                break;
            }
            y = y >>> 1;
            bitPosition++;
        }
        return x;
    }

    public static void main(String[] args) {
        page50 mySolution = new page50();
        int myNum = 64;
        System.out.println(Long.toBinaryString(myNum));
        System.out.println(Long.toBinaryString(mySolution.closestIntSameBitCount(myNum)));
    }

}

class page52{

    public long multiply(long x, long y) {

        long result = 0;
        int numBits = 0;

        while(y != 0){
            numBits++;
            if((y & 0b1) != 0b0){
                result = sum(x << numBits, result);
            }
            y = y >>> 1;
        }


        return result;
    }

    private long sum(long x, long result){

        long temp_x = x; long temp_result = result; boolean carry = false;
        long partial_sum;

        while(temp_x != 0 || temp_result != 0){
            partial_sum = (temp_x & 1L) + (temp_result & 1L);

            temp_x = temp_x >>> 1;
            temp_result = temp_result >>> 1;
        }

        return result;
    }


    public static void main(String[] args) {
        page52 mySolution = new page52();
        mySolution.multiply(13L, 9L);
    }

}

class page54{

    //Write a program which takes an integer and returns the integer corresponding to the
    //digits of the input written in reverse order.
    public long reverse(long x){

        long digit;
        long reverseNum = 0L;
        while(x != 0){
            digit = x % 10;
            reverseNum = reverseNum * 10 + digit;
            x = x / 10;
        }
        return reverseNum;
    }

    public static void main(String[] args) {

        page54 mySolution = new page54();
        System.out.println(mySolution.reverse(6457));

    }

}

class page56{

    //A palindromic string is one which reads the same forwards and backwards
    //For example, you program should return true for the inputs 0,1,7,11,121,333, and 2147447412, and
    //false for the inputs -1,12,100, and 2147483647

    public boolean isPalindromeNumber (int x) {

        boolean result = true;
        int numOfDigits = (int) Math.floor(Math.log10(x)) + 1;
        int msdMask = (int) Math.pow(10,numOfDigits - 1);//Note the -1

        while( x != 0){
            if((x / msdMask) != (x % 10)){
                return false;
            }
            x = x % msdMask;    //Remove the most significant digit of x
            x = x / 10;         //Remove the least significant digit of x
            msdMask = msdMask / 100;
        }
        return result;
    }

    public static void main(String[] args) {
        int myNum = 1234321;
        page56 mySolution = new page56();
        System.out.println(mySolution.isPalindromeNumber(myNum));
    }

}