package com.daocun.test;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.TreeMap;
import java.util.TreeSet;

public class Poker2 {

	public static void main(String[] args) {
		/**
		 * * A:案例演示   斗地主plus
		 * 模拟斗地主洗牌和发牌，并排序
		 * 
		 * 分析:
		 * 1,买一副扑克,其实就是自己创建一个集合对象,将扑克牌存储进去
		 * 2,洗牌
		 * 3,发牌
		 * 4,看牌
		 */
		String[] num= {"3","4","5","6","7","8","9","10","J","Q","K","A","2"};
		String[] color= {"方片","红桃","黑桃","梅花"};
		HashMap<Integer, String> hm=new HashMap<>();
		ArrayList<Integer> list=new ArrayList<>();
		int index=0;
		for(String s1:num) {							
			for(String s2:color) {
				hm.put(index, s2.concat(s1));						//把牌连接起来并添加到hm集合，index是索引
				list.add(index);									//把索引添加到list结合中
				index++;
			}
		}
		hm.put(index, "小王");										//添加大小王
		list.add(index);
		index++;
		hm.put(index, "大王");
		list.add(index);
		Collections.shuffle(list);									//洗牌--索引打乱
		TreeSet<Integer> p1=new TreeSet<>();						//发牌，建立玩家集合接收
		TreeSet<Integer> p2=new TreeSet<>();
		TreeSet<Integer> p3=new TreeSet<>();
		TreeSet<Integer> dipai=new TreeSet<>();
		for(int i=0;i<list.size();i++) {
			if(i>=list.size()-3) {
				dipai.add(list.get(i));
			}else if(i%3==1) {
				p1.add(list.get(i));
			}else if(i%3==2) {
				p2.add(list.get(i));
			}else {
				p3.add(list.get(i));
			}
		}
		//看牌
		lookPoker(hm,p1,"玩家1");
		lookPoker(hm,p2,"玩家2");
		lookPoker(hm,p3,"玩家3");
		lookPoker(hm,dipai,"底牌");
	}
public static void lookPoker(HashMap<Integer, String> hm,TreeSet<Integer> ts,String name) {
	System.out.print(name+"的牌是:");
	for(Integer i:ts) {
		System.out.print(hm.get(i)+",");
	}
	System.out.println();
}
}
