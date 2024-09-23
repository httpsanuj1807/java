class Calculator{


    public int add(int n1, int n2){

        return n1 + n2;

    }

    public int add(int n1, int n2, int n3){ // only number of parameters changes

        return n1 + n2 + n3;
    }

    public double add(double n1, int n2, int n3){ // parameter type change

        return n1 + n2 + n3;
    }


    // in overloading we cannot distinguish by the return type of the function, we either can differ the number of parameters if same datatype arguments are there or we have to differ the datatype if same number of arguments.

}


public class overloading4 {
    

    public static void main(String args[]){


        Calculator obj = new Calculator();

        int result1 = obj.add(2, 3);  // only two paramters

        int result2 = obj.add(2, 3, 6);  // only three paramters

        double result3 = obj.add(2.5, 3, 6);  // parameter type change

        System.out.println(result1);
        System.out.println(result2);
        System.out.println(result3);



    }

}
