package com.linkedin.collections;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Iterator;

public class Application {

	public static void main(String[] args) {

		Room cambridge = new Room("Cambridge", "Premiere Room", 4, 175.00);
		Room manchester = new Room("Manchester", "Suite", 5, 250.00);
		Room oxford = new Room("Oxford", "Suite", 5, 225.0);
		Room victoria = new Room("Victoria", "Suite", 5, 225.00);
		
		Collection<Room> rooms = new ArrayList<>(Arrays.asList(cambridge, oxford, victoria, manchester));
		oxford.setPetFriendly(true);
		victoria.setPetFriendly(true);
		

		// This will throw thw ConcurrentModificationException
		// as we are trying to remove the element from the collection that is being traversed 
		// for(Room room : rooms) {
			
		// 	if(room.isPetFriendly()) {
		// 		rooms.remove(room);
		// 	}
			
		// }

		// This can be solved by following code-

		Collection<Room> removeRooms = new ArrayList<>();

		for(Room room : rooms){
			if(room.isPetFriendly()){
				removeRooms.add(room);
			}
		}
		rooms.removeAll(removeRooms);

		// Another way to solve this problem is by using the iterators-
		Collection<Room> rooms2 = new ArrayList<>(Arrays.asList(cambridge, oxford, victoria, manchester));
		oxford.setPetFriendly(true);
		victoria.setPetFriendly(true);

		Iterator<Room> iterator =  rooms2.iterator();

		while(iterator.hasNext()){
			Room r = iterator.next();
			if(r.isPetFriendly()){
				iterator.remove();
			}
		}

		
		System.out.println(rooms);
		System.out.println(rooms2);
		
	}
}
