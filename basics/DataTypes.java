public class DataTypes {

    
    public static void main(String[] args) {
        
        

        // size of datatypes (Integer)
        // int -> 4 bytes
        // long -> 8 bytes
        // short -> 2 bytes
        // byte -> 1 byte

        // Float
        // float -> 4 bytes
        // double -> 8 bytes (better, more precision)
        // by default java works with double only

        // float num = 5.3; // error
        // float num = 5.3f; // explicit declaration and it works

        // Characters 
        // char -> 2 bytes
        // java doesnt follow ascii, it follows UNICODE 
        // and supports widely used characters
        // char c = 'a'    // only single quote


        // Boolean
        // boolean flag = true;   // 1 bytes

        int num = 9;
        // byte bynum = 129; // error because range is -128 to 127
        byte bynum = 127;
        short shortnum = 554;
        long longnum = 39282l; // we have to place l at last


        float f = 5.5f;
        double d = 39.2;

        char c = 'a';

        boolean flag = true;


    }

}

