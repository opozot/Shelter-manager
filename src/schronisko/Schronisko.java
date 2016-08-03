/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package schronisko;

import java.util.ArrayList;
import java.util.Scanner;


/**
 *
 * @author ASUS
 */ 
public class Schronisko {

    public String type;
    public ArrayList<String> numberOfAnimals = new ArrayList<>();
    
    public void addAnimal(String type){
        this.type=type;
        Scanner in = new Scanner(System.in);
        System.out.println("\n     Please give the animal type: ");
        type = in.nextLine();
        System.out.println("\n     You have entered: " + type);
        numberOfAnimals.add(type);
    }
   
    
    public void Status(){
        System.out.println("\n     Total number of animals: " + numberOfAnimals.size());
//        numberOfAnimals.forEach(System.out::println);
//        System.out.println(numberOfAnimals);
        
        for (int i=0;i<numberOfAnimals.size();i++) {
            System.out.println(numberOfAnimals.get(i));
        }
    }
    
     public static int menu(){
        System.out.println();
        System.out.println("     ****************************************");
        System.out.println("     *                 MENU                 *");
        System.out.println("     ****************************************");
        System.out.println("     1. Add an Animal");
        System.out.println("     2. Add several Animals");
        System.out.println("     3. Remove an Animal");
        System.out.println("     4. Status");
        System.out.println("     0. Exit");
 
        Scanner in = new Scanner(System.in);
        int menuItem = in.nextInt();
 
        return menuItem;
    }
    
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        
        int choice = menu();
        Schronisko shelter1 = new Schronisko();
        
        while(choice!=0) {
            switch(choice){
                case 1:
                    shelter1.addAnimal("");
                    break;
                case 2:
                    int i;
                    System.out.println("\n     How many Animals would you like to add?");
                    i = in.nextInt();
                        
                    while (i>0){
                    shelter1.addAnimal("");
                    i=i-1;
                    }
                    break;
                case 3:
                    System.out.println("\n     Which animal would you like to remove from your list?");
                    System.out.println(shelter1.numberOfAnimals);
//                    shelter1.numberOfAnimals.forEach(System.out::println);
                    String removeAnimal = in.nextLine();
                    shelter1.numberOfAnimals.remove(removeAnimal);
                    
                    break;
                case 4:
                    shelter1.Status();
            }   
                    choice = menu();
        }
        System.out.println("     ****************************************");
        System.out.println("\n     Thank you for using Shelter Manager\n\n");
    }

}
