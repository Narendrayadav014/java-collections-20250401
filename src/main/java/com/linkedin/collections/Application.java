package com.linkedin.collections;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Iterator;

public class Application {

	public static void main(String[] args) {
		
		Room cambridge = new Room("Cambridge", "Premiere Room", 4, 175.00);
		Room piccadilly = new Room("Piccadilly", "Guest Room", 3, 125.00);
		Room westminister = new Room("Westminister", "Premiere Room", 4, 200.00);
		
		Collection<Room> rooms = new ArrayList<>(Arrays.asList(piccadilly, cambridge, westminister));

		Iterator<Room> iterator = rooms.iterator();

		// iterator.next() method will iterate throw the next element 
		System.out.println(iterator.next().getName());
		System.out.println(iterator.next().getName());
		System.out.println(iterator.next().getName());

		// New instance of iterator will be created and will start from the first element
		Iterator<Room> iterator2 = rooms.iterator();
		System.out.println(iterator2.next().getName());

		// Generally iterator is used with while loop as follows
		Iterator<Room> iterator3 = rooms.iterator();

		while(iterator3.hasNext()){
			Room room = iterator3.next();
			System.out.println(room.getName());
		}

		// Iterators can be replaced with the enhanced forEach loop as follows -

		for(Room room1 : rooms){
			System.out.println(room1.getName());
		}
			
	}
}
