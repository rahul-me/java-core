package com.core.object;

import java.util.HashMap;
import java.util.Map;

public class ViolatingHashCodeContract {
	
	public static void main(String[] args) {
		Team jule = new Team("newyork", "sales");
		Team haul = new Team("newyork", "sales");
		
		boolean isJuleEqualhaul = jule.equals(haul);
		System.out.println("isJuleEqualhaul: "+isJuleEqualhaul);
		
		boolean isSameHashcode = jule.hashCode() == haul.hashCode();
		System.out.println("isJuleHashEqualhaulHash: "+isSameHashcode);
		
		// check how hashmap works if Team has overridden equals method
		
		Map<Team, String> leaders = new HashMap<>();
		
		leaders.put(new Team("New York", "development"), "Anne");
		leaders.put(new Team("Boston", "development"), "Brian");
		leaders.put(new Team("Boston", "marketing"), "Chalie");
		
		String leader = leaders.get(new Team("New York","development"));
		System.out.println("Leader: "+leader);
		
		Team bassi = new Team("London", "marketing");
		
		leaders.put(bassi, "Sakki");
		
		String lead = leaders.get(bassi);
		System.out.println("Marketing lead for bassi in london is: "+lead);
		
		bassi.setCity("Aloha");
		lead = leaders.get(bassi);
		System.out.println("Marketing lead for bassi in london is: "+lead);
		
		System.out.println("city of bassi team: "+bassi.getCity());
		System.out.println("department of bassi team: "+bassi.getDepartment());
		
		Team newBassi = new Team("Aloha", "marketing");
		
		boolean isBassiAndNewBassiAreSame = bassi.equals(newBassi);
		
		System.out.println("Is Bassi and new bassi are same: "+isBassiAndNewBassiAreSame);
		
		String marketingLeadBassiAloha = leaders.get(newBassi);
		lead = leaders.get(bassi);
		System.out.println("Lead for new bassi: "+marketingLeadBassiAloha);
		System.out.println("Lead for old bassi: "+lead);
		System.out.println("\n\n");
		int hashcode = bassi.hashCode();
		int rightshift16times = hashcode >>> 16;
		System.out.println("Hashcode of bassi in int format: "+hashcode);
		System.out.println("Hashcode of bassi in binary format: "+Integer.toBinaryString(hashcode));
		System.out.println("Righ Shifting bassi's hash 16 times in int format: "+rightshift16times);
		System.out.println("Righ Shifting bassi's hash 16 times in binary format: "+Integer.toBinaryString(rightshift16times));
		
		int xorOfhashAndRightShiftedhash = hashcode ^ rightshift16times;
		System.out.println("XOR of hash and shifted hash in int: "+xorOfhashAndRightShiftedhash);
		System.out.println("XOR of hash and shifted hash in binary format: "+Integer.toBinaryString(xorOfhashAndRightShiftedhash));
		
		int bitandhash = 1301651255 & 15;
		System.out.println("hash in binary: "+Integer.toBinaryString(1301651255));
		System.out.println("15 in binary: "+Integer.toBinaryString(15));
		
		System.out.println("Bitwise and between 15 and hash in int: "+bitandhash);
		System.out.println("Bitwise and between 15 and hash in binary: "+Integer.toBinaryString(bitandhash));
		
	}
}
