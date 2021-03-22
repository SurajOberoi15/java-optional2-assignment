package com.knoldus;

import java.util.Optional;
import java.util.Scanner;


public class PhonebookCrawler extends Phonebook {

    // Object of Phonebook to use its methods
    Phonebook obj2 = new Phonebook();

    public String findPhoneNumberByNameAndPrintIfNothingFound(String name){
        return obj2.findPhoneNumberByName(name).orElse("No match found");
    }

    public String findPhoneByNameAndPrintPhoneBookIfNothingFound(String name){
       return obj2.findPhoneNumberByName(name).orElse("Printing PhoneBook: " + obj2.getMap());
    }

        public String StreamFindPhoneNumberByNameAndPrintIfNothingFound(String name){
        String USER = phonebook.keySet().stream().filter(userName -> userName.equals(name)).findFirst().orElse(null);
        if(USER!=null){
            return phonebook.get(USER);
        }
        else {
            return null;
        }
    }

    public String StreamFindPhoneByNameAndPrintPhoneBookIfNothingFound(String name){
        String USER = phonebook.keySet().stream().filter(userName -> userName.equals(name)).findFirst().orElse(null);
        if(USER!=null){
            return phonebook.get(USER);
        }
        else {
           return null;
        }

    }

    public String FindPhoneNumberByNameOrNameByPhoneNumber(String name,String number){
        if(obj2.findPhoneNumberByName(name).isPresent()){
            return obj2.findPhoneNumberByName(name).orElse(null);
        }
        else if(obj2.findNameByPhoneNumber(number).isPresent()){
            return obj2.findNameByPhoneNumber(number).orElse(null);
        }
        else{
            return "No match Found";
        }
    }


    public static void main(String[] args) {
        PhonebookCrawler obj = new PhonebookCrawler();
        Phonebook obj1 = new Phonebook();
        Scanner input = new Scanner(System.in);

        // Enter name to search in phonebook
        System.out.println("Enter Name to search :");
        String userName = input.nextLine();

        System.out.println("Exercise 1");
        Optional<String> number = obj.findPhoneNumberByName(userName);
        System.out.println("Found Number by " + userName +" is:" + number.orElse(null));
        System.out.println("////////////////////////");
        System.out.println("Exercise 2");
        String number1 = obj.findPhoneNumberByNameAndPrintIfNothingFound(userName);
        System.out.println("Found Number by " + userName +" is:" + number1);
        System.out.println("////////////////////////");
        System.out.println("Exercise 3");
        String number2 = obj.findPhoneByNameAndPrintPhoneBookIfNothingFound(userName);
        System.out.println("Found Number by " + userName +" is:" + number2);
        System.out.println("////////////////////////");
        //overriding the Phonebook toString method and printing "Hello"
        System.out.println("Exercise 4 (overloading toString method");
        System.out.println(obj1);
        System.out.println("////////////////////////");
        System.out.println("Exercise 5");
        String number3 = obj.StreamFindPhoneNumberByNameAndPrintIfNothingFound(userName);
        if(number3 != null  ){
            System.out.println("Found Number by " + userName + "is :" + number3);
        }
        else
        {
            System.out.println("No match found");
        }
        System.out.println("////////////////////////");
        System.out.println("Exercise 6");
        String number4 = obj.StreamFindPhoneByNameAndPrintPhoneBookIfNothingFound(userName);
        if(number4 != null){
            System.out.println("Found Number by " + userName + "is :" + number4);
        }
        else
        {
            System.out.println("No match found, printing PhoneBook");
            System.out.println(obj1.getMap());
        }

        System.out.println("////////////////////////");
        System.out.println("Exercise 7-1");
        System.out.println("Enter number to search: ");
        String searchNumber = input.nextLine();

        Optional<String> str =obj1.findNameByPhoneNumber(searchNumber);
        System.out.println("Name found by number is :" + str.orElse(null));
        System.out.println("////////////////////////");

        System.out.println("Exercise 7-2");
        System.out.println("Enter Phone number and Name: ");
        String Name = input.nextLine();
        String PhoneNumber = input.nextLine();
        String str2 = obj.FindPhoneNumberByNameOrNameByPhoneNumber(Name,PhoneNumber);
        System.out.println("Result found: " + str2);
    }
}
