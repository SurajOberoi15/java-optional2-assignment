package com.knoldus;

import java.util.Map;
import java.util.Optional;

    public class Phonebook {

      public Map<String,String> phonebook = new java.util.HashMap<>(){
          {
              put("A","123456789" );
              put("B","987654321" );
              put("C","753954268" );
              put("D","862479310" );
              put("E","741258963" );
          }
      };

/*        void insertRecords(int n){
            Scanner input = new Scanner(System.in);
            for(int i = 0; i < n; i++)
            {
                String name = input.next();
                long phone = input.nextLong();
                phonebook.put(name, phone);
            }
        }*/

/*        void printPhoneBook(){
            for (Map.Entry<String,Long> entry : phonebook.entrySet())
                System.out.println("Name = " + entry.getKey() +
                        ", PhoneNumber = " + entry.getValue());
        }*/

        public Optional<String> findPhoneNumberByName(String name){
            try{
                boolean getName;
                getName=phonebook.containsKey(name);
                if (getName){
                    return Optional.of(phonebook.get(name));
                }
            }
            catch (Exception e){
                System.out.println("exception: " + e.getMessage()   );
            }
            return Optional.empty();
        }

        Optional<String> findNameByPhoneNumber(final String phoneNumber) {
            try {
                for (Map.Entry<String, String> phonebook : phonebook.entrySet()) {
                    if (phonebook.getValue().equals(phoneNumber)) {
                        return Optional.of(phonebook.getKey());
                    }
                }
            } catch (Exception e) {
                System.out.println("exception: " + e.getMessage());
            }
            return Optional.empty();
        }

        public Map<String, String> getMap() {
            return phonebook;
        }


        @Override
        public String toString(){
            return "Hello from Phonebook";
        }

    }

