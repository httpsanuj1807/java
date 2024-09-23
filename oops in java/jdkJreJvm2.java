// JDK (Java Development Kit)
// What it is: The JDK is a software development environment used to develop Java applications. It contains everything you need to write, compile, and run Java programs.

// What it includes:

// JRE (Java Runtime Environment): Provides the libraries, Java Virtual Machine (JVM), and other components to  //run Java programs.
// Java Compiler (javac): Used to convert Java source code (.java files) into bytecode (.class files).



// JRE (Java Runtime Environment)
// What it is: The JRE is a part of the JDK and is used to run Java programs. It provides the libraries, JVM, and other components required to execute a Java program but does not include tools for developing Java applications like the compiler.

// What it includes:

// JVM (Java Virtual Machine): Runs the Java bytecode on your machine.
// Class Libraries: Provides the standard libraries (e.g., java.util, java.io) required for running Java applications.


// JVM (Java Virtual Machine)
// What it is: The JVM is the runtime environment where Java bytecode is executed. It’s the heart of the Java platform's "write once, run anywhere" philosophy.

// Role:

// Bytecode Execution: When you compile Java code, it is converted into platform-independent bytecode. The JVM interprets this bytecode and runs it on the specific machine it’s installed on.
// Memory Management: The JVM manages memory for Java applications, including garbage collection.
// Platform Independence: Since Java bytecode can be run on any platform that has a JVM, Java applications are platform-independent.
// Purpose: The JVM makes Java programs platform-independent by abstracting the underlying machine architecture. It provides an environment to execute Java bytecode.

// Relationship between JDK, JRE, and JVM:
// The JVM is the engine that executes Java bytecode.
// The JRE provides the JVM along with libraries and other components necessary to run Java programs.
// The JDK includes the JRE, JVM, and development tools such as the compiler (javac) to develop Java applications.


// JDK
// │
// ├── JRE
// │   ├── JVM
// │   └── Class Libraries
// ├── Java Compiler (javac)
// └── Other development tools
