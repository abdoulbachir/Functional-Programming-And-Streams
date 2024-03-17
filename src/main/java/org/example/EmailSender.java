package org.example;

@FunctionalInterface
public interface EmailSender {
    void send(String email);  //Abstract method

//    String name = "Bachir"; // constant variable declaration (static final variables)
//
//    // static method
//    static void hello(){
//        System.out.println("Hello world!");
//    }
//
//    // default method
//    default String unSend(){
//        // some code
//        return null;
//    }
}
