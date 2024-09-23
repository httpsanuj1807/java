class Literals {
    

    public static void main(String[] args){
        
        int num1 = 9;    // decimal number

        // lets say we want to store binary number

        int bin = 0b101; // binary of 5
        int hexa = 0x7E; // hex od 126

        System.out.println(bin);
        System.out.println(hexa);

        // int bignum = 1000000000;

        // now in above number it is hard to count zero and it
        // is not readble at all

        int bignum = 10_00_00_00_00;
        System.out.println(bignum);


        boolean flag = true; /// only true false allowed, no 0 or 1

        


    }


}
