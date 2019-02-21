package cn.itcast.demo5;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;

/*
 * 斗地主洗牌发牌排序
 */
public class Poker {

	public static void main(String[] args) {

		//准备花色
		ArrayList<String> color = new ArrayList<String>();
		color.add("♠");
		color.add("♥");
		color.add("♦");
		color.add("♣");
		
		//准备数字
		ArrayList<String> number = new ArrayList<String>();
Collections.addAll(number,"3","4","5","6","7","8","9","10","J","Q","K","A","2");
		
		//定义一个map集合：用来将数字与每一张牌进行对应
		HashMap<Integer, String> map = new HashMap<Integer, String>();
		
		int index = 0;
		for (String thisNumber : number) {
			for (String thisColor : color) {
				map.put(index++, thisColor+thisNumber);
			}
		}
		System.out.println(index);
		//加入大小王
		map.put(index++, "小☺");
		map.put(index++, "大☻");//++多余了
		System.out.println(index);
		System.out.println(map);
		//一副54张的牌 ArrayList里边为0-53的数的新牌
		ArrayList<Integer> cards = new ArrayList<Integer>();
		
		for (int i = 0; i <= 53; i++) {
			cards.add(i);
		}
		
		//洗牌
		Collections.shuffle(cards);
		
		//创建三个玩家和底牌
		ArrayList<Integer> iPlayer = new ArrayList<Integer>();
		ArrayList<Integer> iPlayer2 = new ArrayList<Integer>();
		ArrayList<Integer> iPlayer3 = new ArrayList<Integer>();
		ArrayList<Integer> itCards = new ArrayList<Integer>();
		
		//遍历这副洗好的牌，遍历过程中，将牌发到三个玩家和底牌中
		for (int i = 0; i < cards.size(); i++) {
			if(i>=51) {
				itCards.add(cards.get(i));
			} else {
				if(i%3==0) {
					iPlayer.add(cards.get(i));
				}else if(i%3==1) {
					iPlayer2.add(cards.get(i));
				}else {
					iPlayer3.add(cards.get(i));
				}
			}
		}
		
		//对每个人手中的牌排序
		Collections.sort(iPlayer);
		Collections.sort(iPlayer2);
		Collections.sort(iPlayer3);
		
		//对应数字形式的每个人手中的牌，定义字符串形式的牌
		ArrayList<String> sPlayer = new ArrayList<String>();
		ArrayList<String> sPlayer2 = new ArrayList<String>();
		ArrayList<String> sPlayer3 = new ArrayList<String>();
		ArrayList<String> sCards = new ArrayList<String>();
		
		for (Integer key : iPlayer) {
			sPlayer.add(map.get(key));
		}
		for (Integer key : iPlayer2) {
			sPlayer2.add(map.get(key));
		}
		for (Integer key : iPlayer3) {
			sPlayer3.add(map.get(key));
		}
		for (Integer key : itCards) {
			sCards.add(map.get(key));
		}
		
		//看牌
		System.out.println(sPlayer);
		System.out.println(sPlayer2);
		System.out.println(sPlayer3);
		System.out.println(sCards);
	}
}

