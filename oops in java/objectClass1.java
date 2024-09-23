// What is a class ?
// A class is like a blueprint or a template that defines the properties (variables/attributes) and behaviors (methods/functions) of an object. It doesn't represent any data by itself but provides a structure for creating objects.


// What is an object ?
// An object is an instance of a class. It is the actual entity created using the class blueprint. While the class is a definition, the object is something that is created based on that definition and contains actual data.

class Calculator{

    public int add(int num1, int num2){


        return num1 + num2;

    }

}

class objectClass1{
    public static void main(String args[]){


        // creating obj of calculator class type

        Calculator obj = new Calculator();

        int result = obj.add(6, 1);

        System.out.println(result);


    }

}