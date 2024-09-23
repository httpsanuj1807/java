class TypeCastingAndConversion {

    
    public static void main(String[] args){
        
        int num1 = 654;
        int num2 = 12;

        byte num3 = 18;

        // now i want to assign num1 into num3 (which is a byte type)
        // but byte datatype cant store such big value of num1
        // we can store num2 value into num3, because num3 can accomodate till 127
        // so here we have to do explicit type casting


        num3 = (byte)num2; // explicit casting
        num1 = num3;       // implicit conversion

        System.out.println((num3));
        System.out.println((num1));


        float fnum = 5.4f;

        num1 = (int)fnum;

        System.out.println(num1);  // output is 5 only, we lose .4


        // most important

        // int a = 257;
        // byte k = (byte)a; // output is 1, it will do 257 % 256


        byte a = 10;
        byte b = 30;

        int result = a * b; // a * b will result into 300, which is out of range for byte , so here type promotion happens and it workd perfectly

        System.out.println(result);

    }

}
