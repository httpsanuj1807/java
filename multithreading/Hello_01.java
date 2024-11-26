// threads can be created in java by extending tread class or by implementing Runnable interface

// Method 1 -> Implements Runnabale

// public class Hello_01 {

//     public static void main(String args[]){

//         World world = new World();
//         Thread thread1 = new Thread(world); 
//         thread1.start();

//         for(; ;){

//             System.out.println("Hello");
            

//         }
        

//     }

// }


// class World implements Runnable{
//     @Override

//     public void run(){

//         for(; ;){
//             System.out.println("World");
//         }

//     }


// }






// Method 2 -> Extend Thread class

// class World extends Thread{
//     @Override

//     public void run(){

//         for(; ;){
//             System.out.println("World");
//         }

//     }


// }

// public class Hello_01 {

//     public static void main(String args[]){

//         World world = new World();
//         world.start();

//         for(; ;){

//             System.out.println("Hello");
            

//         }
        
//     }

// }