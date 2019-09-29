package com.daocun.test;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.TreeMap;
import java.util.TreeSet;

public class Poker2 {

	public static void main(String[] args) {
		/**
		 * * A:������ʾ   ������plus
		 * ģ�⶷����ϴ�ƺͷ��ƣ�������
		 * 
		 * ����:
		 * 1,��һ���˿�,��ʵ�����Լ�����һ�����϶���,���˿��ƴ洢��ȥ
		 * 2,ϴ��
		 * 3,����
		 * 4,����
		 */
		String[] num= {"3","4","5","6","7","8","9","10","J","Q","K","A","2"};
		String[] color= {"��Ƭ","����","����","÷��"};
		HashMap<Integer, String> hm=new HashMap<>();
		ArrayList<Integer> list=new ArrayList<>();
		int index=0;
		for(String s1:num) {							
			for(String s2:color) {
				hm.put(index, s2.concat(s1));						//����������������ӵ�hm���ϣ�index������
				list.add(index);									//��������ӵ�list�����
				index++;
			}
		}
		hm.put(index, "С��");										//��Ӵ�С��
		list.add(index);
		index++;
		hm.put(index, "����");
		list.add(index);
		Collections.shuffle(list);									//ϴ��--��������
		TreeSet<Integer> p1=new TreeSet<>();						//���ƣ�������Ҽ��Ͻ���
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
		//����
		lookPoker(hm,p1,"���1");
		lookPoker(hm,p2,"���2");
		lookPoker(hm,p3,"���3");
		lookPoker(hm,dipai,"����");
	}
public static void lookPoker(HashMap<Integer, String> hm,TreeSet<Integer> ts,String name) {
	System.out.print(name+"������:");
	for(Integer i:ts) {
		System.out.print(hm.get(i)+",");
	}
	System.out.println();
}
}
