/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package schronisko;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.ListIterator;
import java.util.Scanner;

/**
 *
 * @author ASUS
 */ 
public class Schronisko {           //everything's pubic for now

    public String type;             // the type of animal to fill the list
    public String removeAnimal;     //the String used when removing elements from the list
    public ArrayList<String> numberOfAnimals = new ArrayList<>();
    
    public void addAnimal(String type){
        this.type=type;
        Scanner in = new Scanner(System.in);
        System.out.print("     Please give the animal type: ");
        type = in.nextLine();
        System.out.println("     You have entered: " + type);
        numberOfAnimals.add(type);
    }
   
    public void Status(){       //Status method to see hpw many elements there're on the list
        System.out.println("     Total number of animals: " + numberOfAnimals.size());
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
        Schronisko shelter1 = new Schronisko();                  //create a new object from my shelter class
        
        while(choice!=0) {
            switch(choice){
                case 1:
                    shelter1.addAnimal("");
                    break;
                case 2:
                    int i = 0;
                    System.out.print("     Enter how many Animals you would like to add: ");
                    try {
                        i = in.nextInt();
                    } catch (Exception e) {
                        System.out.println("    Please enter only numeric values.");
                    }
                        
                    while (i>0){
                        shelter1.addAnimal("");
                        i=i-1;
                    }
                break;
                
                case 3:
                    System.out.println("     Which animal would you like to remove from your list?");
                    
                    Iterator iterator = shelter1.numberOfAnimals.iterator();        //used an Iterator to go through the elements
                    while(iterator.hasNext()){                                      //could've used a for loop,
                        Object element = iterator.next();
                        System.out.println(element);
                    }
                    Scanner in2 = new Scanner (System.in);
                    shelter1.removeAnimal = in2.nextLine();
                    ListIterator listIter = shelter1.numberOfAnimals.listIterator();  //used a listIterator to modify the list
                        while(listIter.hasNext()){
                            if(listIter.next().equals(shelter1.removeAnimal)){
                                listIter.remove();
                            System.out.println("    You have removed: " +shelter1.removeAnimal ); 
                            }
                            else if(!(shelter1.numberOfAnimals.contains(shelter1.removeAnimal)));
                                System.out.println("    There is no " + "\"" + shelter1.removeAnimal+"\"" + " on the list");
                                }
                                                  
                    
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
