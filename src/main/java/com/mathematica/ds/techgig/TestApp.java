package com.mathematica.ds.techgig;

public class TestApp {

    static void doIt(int x, int y, int m) {
        if (x == 5) m = y;
        else m = x;
    }

    static class key{
//        @Override
        public int hashcode(){
            return 47;
        }
    }

    public static void main(String[] args) {
        int i = 6, j = 4, k = 9;
        doIt(i, j, k);
//        System.out.println(k);
        System.out.println(2 + 4 * 9 -3);
        System.out.println((2 + 4) * 9 -3);
        System.out.println(2 + (4 * 9) -3);
        System.out.println(2 + 4 * (9 -3));
        System.out.println((2 + 4  * 9) -3);

/*     int z = 1;
     if(i++ == --i){
         System.out.println(0);
     }else{
         System.out.println(1);
     }*/

    String s1 = new String("micheal");
    String s2 ="micheal";
        System.out.println( s1 == s2);

        System.out.println( s1.equals(s2));
    }
}
