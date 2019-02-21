package cn.itcast.demo5;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;

public class DouDiZhu {

	public static void main(String[] args) {
		HashMap<Integer, String> pooker = new HashMap<Integer, String>();
		ArrayList<Integer> pookerNumber = new ArrayList<Integer>();
		String[] numbers = {"2","A","K","Q","J","10","9","8","7","6","5","4","3"};
		String[] colors = {"♠","♥","♣","♦"};
		int index = 2;
		for(String number:numbers){
			for (String color : colors) {
				pooker.put(index, color+number);
				pookerNumber.add(index);
				index++;
			}
		}
		pooker.put(0, "大王");
		pooker.put(1, "小王");
		pookerNumber.add(0);
		pookerNumber.add(1);
		
		Collections.shuffle(pookerNumber);
		ArrayList<Integer> player1 = new ArrayList<Integer>();
		ArrayList<Integer> player2 = new ArrayList<Integer>();
		ArrayList<Integer> player3 = new ArrayList<Integer>();
		ArrayList<Integer> bottom = new ArrayList<Integer>();
		
		for(int i = 0;i<pookerNumber.size();i++){
			if(i>=pookerNumber.size()-3){
				bottom.add(pookerNumber.get(i));
				continue;
			}
			if(i%3==0){
				player1.add(pookerNumber.get(i));
			}else if(i%3==1){
				player2.add(pookerNumber.get(i));
			}else if(i%3==2){
				player3.add(pookerNumber.get(i));
			}
		}
		Collections.sort(player1);
		Collections.sort(player2);
		Collections.sort(player3);
		
		look(player1,pooker);
		look(player2,pooker);
		look(player3,pooker);
		look(bottom,pooker);
		
	}
	public static void look(ArrayList<Integer> player,HashMap<Integer,String> pooker){
		for (Integer key : player) {
			String value = pooker.get(key);
			System.out.print(value+"  ");
		}
		System.out.println();
	}
}
