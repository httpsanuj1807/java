// java program is platform independent because of JVM (Java Virtual Machine). Our code execute irrespective of hardware, os and machine. JVM execute our code.

// but jvm itself is platform dependent, we can run jvm on ios, means our code/application is platform independent not the jvm

//  we write code in english -> it goes to javac that converts it into bytes/machine code -> this bytes code is passed to jvm which only understand bytes code

// now we have a big application having 100s of files, now its our reponsibility to tell jvm the starting file or the entry point of the program, we need to specify the main method there in the first file. It follows a signature that is
// public static void main(String args[])

// java is a object oriented language so everything is written inside a class

// when we do javac Hello.java, it gives us a Hello.class which has has bytes code, now we have to run this class file using command java Hello

// jvm is a part of jre (Java runtime environment)
// jre is a part of jdk (Java development kit)


class Hello {


    public static void main(String args[]){


        System.out.print("Hello World");

    }

}

