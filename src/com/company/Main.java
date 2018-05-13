package com.company;

public class Main {

    public static void main(String[] args) {
	    Person egor = new Person(true, "Egor");
	    Person svetlana = new Person(false, "Svetlana");
        Person valentin = new Person(true, "Valentin");

	    System.out.println(svetlana.marry(valentin));
        System.out.println(egor.marry(svetlana));

        System.out.println(egor.getSpouse());
        System.out.println(svetlana.getSpouse());
        System.out.println(valentin.getSpouse());
    }
}
