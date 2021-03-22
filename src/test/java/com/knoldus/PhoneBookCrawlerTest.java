package com.knoldus;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

class PhoneBookCrawlerTest {
    PhonebookCrawler obj = new PhonebookCrawler();

    String name ="Suraj";
    String number = "98765432";

    @Test
    void findPhoneNumberByNameAndPrintIfNothingFound() {
        String num = obj.findPhoneNumberByNameAndPrintIfNothingFound(name);
        assert (num.equals("123456789"));
   }

 @Test
    void findPhoneByNameAndPrintPhoneBookIfNothingFound() {
        String num = obj.findPhoneByNameAndPrintPhoneBookIfNothingFound(name);
        assert (num.equals("123456789"));
    }

    @Test
    void findPhoneNumberByNameUsingStream() {
        String num= obj.StreamFindPhoneNumberByNameAndPrintIfNothingFound(name);
        Assertions.assertEquals(num,"123456789");
    }

        @Test
    void findPhoneByNameAndPrintPhoneBookIfNothingFoundUsingToStringMethod() {
        String num = obj.StreamFindPhoneByNameAndPrintPhoneBookIfNothingFound(name);
        Assertions.assertEquals(num,"123456789");
    }

    @Test
    void findPhoneNumberByNameOrNameByPhoneNumber(){
        String num = obj.FindPhoneNumberByNameOrNameByPhoneNumber(name,number);
        Assertions.assertEquals(num,"123456789");
    }

}
