package Arrays;

import java.util.*;

public class Page60 {

    //Your input is an array of integers, and you have to reorder its entries so that the even entries appear
    //first.
    public void evenOdd(int[] A) {

        int front = 0;
        int back = A.length - 1;
        int temp;
        //[2,1,3,5,7,9,11]
        while(front < back){
            while((A[front] % 2 != 0) && (front < back)){
                temp = A[back];
                A[back] = A[front];
                A[front] = temp;
                back--;
            }
            front++;
        }
    }

    public void another_evenOdd(int[] A){

        int front = 0;
        int back = A.length - 1;
        int temp;

        while(front < back){
            if((A[front] % 2) == 0){
                front++;
            }else{
                temp = A[back];
                A[back] = A[front];
                A[front] = temp;
                back--;
            }
        }
    }

    public static void main(String[] args) {
        int[] myArray1 = new int[] {2,1,3,5,7,9,11,2};
        int[] myArray2 = {2,1,3,5,7,9,11,2};
        Page60 mySolution = new Page60();
        mySolution.evenOdd(myArray1);
        System.out.println(Arrays.toString(myArray1));
        mySolution.another_evenOdd(myArray2);
        System.out.println(Arrays.toString(myArray2));

    }
}

class page63{

    //Write a program that takes an array A and an index i into A, and rearranges the
    //elements such that all elements less than A[i] (the "pivot") appear first, followed by
    //elements equal to the pivot, followed by elements greater than the pivot.

    public enum Color { RED, WHITE, BLUE }

    public void dutchFlagPartition(int pivotIndex , List<Color> A) {

        Color pivotColor = A.get(pivotIndex);
        int larger = A.size() - 1;
        int equal = 0;
        int index = 0;

        while(index <= larger){
            if(A.get(index).ordinal() < pivotColor.ordinal()){
                Collections.swap(A, equal, index);
                equal++;
                index++;
            }else if (A.get(index).ordinal() > pivotColor.ordinal()){
                Collections.swap(A, index, larger);
                larger--;
            }else{
                index++;
            }
        }
    }

    public static void main(String[] args) {

        List<Color> myList = new ArrayList<>();
        myList.add(Color.RED);myList.add(Color.BLUE);myList.add(Color.WHITE);
        myList.add(Color.RED);myList.add(Color.BLUE);myList.add(Color.WHITE);
        myList.add(Color.RED);myList.add(Color.BLUE);myList.add(Color.WHITE);

        page63 mySolution = new page63();
        mySolution.dutchFlagPartition(2, myList);
        System.out.println(myList);
    }
}

class page65{

    //Write a program which takes as input an array of digits encoding a decimal number D and
    //updates the array to represent the number D + 1.
    //For example, if the input  is (1,2,9) then you should update the array to (1,3,0).
    //Your algorithm should work even if it is implemented in a language that has finite-precision arithmetic.
    public List<Integer> plusOne (List<Integer> A) {

        int n = A.size() - 1;
        A.set(n, A.get(n) + 1);

        for(int i = n; i > 0 && A.get(i) == 10; i--){
            A.set(i, 0);
            A.set(i-1, A.get(i-1)+1);
        }

        if(A.get(0) == 10){
            A.set(0,0);
            A.add(0, 1);
        }
        return A;
    }

    public static void main(String[] args) {
        List<Integer> myInt = new ArrayList<>();
        myInt.add(9);myInt.add(9);myInt.add(9);myInt.add(9);
        page65 mySolution = new page65();
        System.out.println(mySolution.plusOne(myInt));
    }
}

class page66{

    //For example, (1,9,3,7,0,7,7,2,1) represents 193707721 and
    //(-7,6,1,8,3,8,2,5,7,2,8,7) represents -761838257287.
    //Write a program that takes two arrays representing integers, and returns an integer
    //representing their product. For example, since
    //193707721 X -761838257287 = -147573952589676412927, if the inputs are
    //(1,9,3,7,0,7,7, 2,1} and (-7,6,1,8,3,8,2,5,7,2,8,7), your function should return
    //(-1,4,7,5,7,3,9,5,2,5,8,9,6,7,6,4,1,2,9,2,7).

    public List<Integer> multiply_my_BS_way(List<Integer> num1 , List<Integer > num2){

        List<Integer> total = new ArrayList<>();
        List<Integer> tempList = new ArrayList<>();
        int carry = 0;

        for(int i = num2.size() - 1; i >= 0; i--){
            int currInt1 = num2.get(i);
            for(int j = num1.size() - 1; j >= 0; j--){
                int currInt2 = num1.get(j);
                int temp = currInt1 * currInt2 + carry;
                tempList.add(0, temp % 10);
                if (temp > 9){
                    carry = temp / 10;
                }else{
                    carry = 0;
                }
            }
            if(carry > 0){
                tempList.add(0, carry);
            }
            total = computeSum(tempList, total);
        }
        return total;
    }

    private List<Integer> computeSum(List<Integer> tempList, List<Integer> total){

        List<Integer> result = new ArrayList<Integer>();

        int carry = 0;
        for(int index = Math.min(tempList.size()-1, total.size()-1); index >= 0; index--){
            result.add(0, total.get(index) + tempList.get(index) + carry);
            if(result.get(0) > 9){
                result.set(0, result.get(0) % 10);
                carry = 1;
            }else{
                carry = 0;
            }
        }

        return result;
    }

    public List<Integer> multiply(List<Integer> num1 , List<Integer > num2){

        List<Integer> result = new ArrayList<>(Collections.nCopies(num1.size() + num2.size(), 0));
        //Check this entire for loop. You spent wayyy more time than you should have on this.
        for(int i = num1.size() - 1; i >= 0; i--){
            for(int j = num2.size() - 1; j >= 0; j--){
                result.set(i+j+1, result.get(i+j+1) + (num1.get(i) * num2.get(j)));
                result.set(i+j, result.get(i+j) + result.get(i+j+1) / 10);
                result.set(i+j+1, result.get(i+j+1) % 10);
            }
        }

        //WE need to remove the leading zeroes that are present in the result
        int resultStartIdx;
        for(resultStartIdx = 0; resultStartIdx < result.size(); resultStartIdx++){
            if(result.get(resultStartIdx) != 0) break;
        }
        result = result.subList(resultStartIdx, result.size());//Check this method

        return result;
    }

    public static void main(String[] args) {

        page66 mySolution = new page66();
        List<Integer> myInt1 = new ArrayList<>();
        myInt1.add(1);myInt1.add(9);myInt1.add(2);
        List<Integer> myInt2 = new ArrayList<>();
        myInt2.add(2);myInt2.add(9);
        System.out.println(mySolution.multiply(myInt1, myInt2));
    }


}

class page69{

    //Returns the number of valid entries after deletion.
    //[2,3,5,5,7,11,11,11,13]
    public int deleteDuplicates(List<Integer> A){

        int numValidEntries = 0;
        int swapIndex = 0;
        HashSet<Integer> elementsSeen = new HashSet<>();

        for(int i = 0; i < A.size(); i++){
            if(!elementsSeen.contains(A.get(i))){
                elementsSeen.add(A.get(i));
                numValidEntries++;
                Collections.swap(A, swapIndex, i);
                swapIndex++;
            }else{

            }
        }

        return numValidEntries;
    }

    public static void main(String[] args) {
        List<Integer> myList = new ArrayList<>();
        myList.add(2); myList.add(3); myList.add(5); myList.add(6);
        myList.add(7); myList.add(10); myList.add(12); myList.add(13); myList.add(14);
        page69 mySolution = new page69();
        System.out.println(mySolution.deleteDuplicates(myList));
        System.out.println(myList);
    }

}

class page70{

    //(310,315, 275, 295, 260, 270, 290, 230, 255, 250)
    public double computeMaxProfit(List<Double> prices) {

        double minPrice = Double.MAX_VALUE;
        double maxProfit = 0;
        double currProfit = 0;
        double currPrice = 0;

        for(int i = 0; i < prices.size(); i++){
            currPrice = prices.get(i);
            currProfit = currPrice - minPrice;
            if(currProfit > maxProfit){
                maxProfit = currProfit;
            }
            if(currPrice < minPrice){
                minPrice = currPrice;
            }
        }
        return maxProfit;
    }

    public static void main(String[] args) {

        List<Double> myList = new ArrayList<>();
        myList.add(310.0); myList.add(315.0); myList.add(275.0); myList.add(295.0);
        myList.add(260.0); myList.add(270.0); myList.add(290.0); myList.add(230.0);
        myList.add(255.0); myList.add(255.0);
        page70 mySolution = new page70();
        System.out.println("Max profit: " + mySolution.computeMaxProfit(myList));

    }

}

class page71{

    //Write a program that computes the maximum profit that can be made by buying and
    //selling a share at most twice. The second buy must be made on another date after the first sale.

    //(310, 315, 275, 295, 260, 270, 290, 230, 255, 250)
    public double buyAndSellStockTwice(List<Double> prices) {

        List<Double> myProfit = new ArrayList<>();
        //Going in the forward direction to figure out where to sell to get the max profit
        double minPrice = Double.MAX_VALUE;
        double maxProfit = 0;

        for(int i = 0; i < prices.size(); i++){
            maxProfit = Math.max(maxProfit, prices.get(i) - minPrice);
            minPrice = Math.min(minPrice, prices.get(i));
            myProfit.add(maxProfit);
        }

        //Going in the backward direction to figure out where to buy to get the max profit
        double maxPrice = Double.MIN_VALUE;
        maxProfit = 0;
        for(int i = prices.size()-1; i >= 0; i--){
            maxProfit = Math.max(maxProfit, myProfit.get(i) + maxPrice - prices.get(i));
            maxPrice = Math.max(maxPrice, prices.get(i));
        }
        return maxProfit;
    }

    public static void main(String[] args) {

        List<Double> myList = new ArrayList<>();
        myList.add(12.0); myList.add(11.0); myList.add(13.0); myList.add(9.0);
        myList.add(12.0); myList.add(8.0); myList.add(14.0); myList.add(13.0);
        myList.add(15.0);
        page71 mySolution = new page71();
        System.out.println("Max possible profit: " + mySolution.buyAndSellStockTwice(myList));
    }



}

class page73{

    //Enumerate all primes to n: Write a program that takes an integer argument and returns all the primes between 1
    //and that integer. For example, if the input is 18, you should return (2,3,5,7,11,13,17).
    public List<Integer> generatePrimes(int n){

        List<Integer> result = new ArrayList<>();
        boolean[] isPrime = new boolean[n+1];
        Arrays.fill(isPrime, true);
        result.add(1);
        for(int i = 2; i <= n; i++){
            if(isPrime[i]){
                result.add(i);
                int j = 2;
                int index = i * j++ ;
                while(index <= n){
                    isPrime[index] = false;
                    index = i * j++;
                }
            }
        }
        return result;
    }

    public static void main(String[] args) {
        page73 mySolution = new page73();
        System.out.println(mySolution.generatePrimes(18));
    }
}

class page75{

    public void applyShittyPermutation(List<Integer> p, List<Integer> A){

        int temp1 = -1;
        int temp2 = -1;
        int index;

        for(int i = 0; i < p.size(); i++){
            index = i;
            temp1 = A.get(i);
            while(p.get(index) >= 0){
                int copyToIndex = p.get(i);
                temp2 = A.get(copyToIndex);
                A.set(copyToIndex, temp1);

                temp1 = A.get(copyToIndex);
                index = p.get(copyToIndex);
            }
        }
    }

    public void applyPermutation(List<Integer> p, List<Integer> A){

        int index;
        for(int i = 0; i < p.size(); i++){
            index = i;
            while(p.get(index) >= 0) {
                Collections.swap(A, i, p.get(index));
                int temp = p.get(index);
                p.set(index, p.get(index) - p.size());
                index = temp;
            }
        }
    }

    public static void main (String[] args) {

        page75 mySolution = new page75();
        List<Integer> perm = new ArrayList<>();
        List<Integer> A = new ArrayList<>();
        perm.add(5); perm.add(4); perm.add(3); perm.add(2); perm.add(1); perm.add(0);
        A.add(5); A.add(4); A.add(3); A.add(2); A.add(1); A.add(0);
        mySolution.applyPermutation(perm, A);
        System.out.println(A);
    }
}

class page77{

    public List<Integer> nextPermutation(List<Integer> p){

        int index = p.size() - 2;
        while (index >= 0 && p.get(index) > p.get(index+1)){
            index--;
        }

        //If index == 0 this means that the permutation is already sorted in the decreasing order
        //like 5 4 3 2 1 0. Hence the permutation can not be incremented.
        if(index == -1) return Collections.emptyList();
        for(int i = p.size() - 1; i > index; i--){
            if(p.get(i) > p.get(index)){
                Collections.swap(p, index, i);
                break;
            }
        }
        Collections.reverse(p.subList(index + 1, p.size())) ;
        return p;
    }

    public static void main(String[] args) {
        page77 mySolution = new page77();
        List<Integer> p = new ArrayList<>();
        p.add(1); p.add(3); p.add(2); p.add(7); p.add(6); p.add(5);p.add(4);
        System.out.println(mySolution.nextPermutation(p));
    }


}