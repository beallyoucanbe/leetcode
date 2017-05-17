package greedy;

import java.util.ArrayList;
import java.util.Scanner;

/*
 * 有N堆纸牌，编号分别为1，2，…，n。每堆上有若干张,但纸牌总数必为n的倍数.
 * 可以在任一堆上取若干张纸牌,然后移动。移牌的规则为：在编号为1上取的纸牌，只能移到编号为2的堆上；
 * 在编号为n的堆上取的纸牌，只能移到编号为n-1的堆上；其他堆上取的纸牌，可以移到相邻左边或右边的堆上。
 * 现在要求找出一种移动方法，用最少的移动次数使每堆上纸牌数都一样多。
 * 例如：n=4，4堆纸牌分别为：① 9 ② 8 ③ 17 ④ 6 移动三次可以达到目的：从③取4张牌放到④ 再从③区3张放到②然后从②去1张放到①。
 */

public class GreedyExample {

	public static void main(String[] args) {
		int n = 0, avg = 0, s = 0;
		Scanner scanner = new Scanner(System.in);
		ArrayList<Integer> array = new ArrayList<Integer>();
		System.out.println("Please input the number of heaps:");
		n = scanner.nextInt();
		System.out.println("Please input heap number:");
		for (int i = 0; i < n; i++) {
			array.add(scanner.nextInt());
		}
		//计算总的数目
		for (int i = 0; i < array.size(); i++) {
			avg += array.get(i);
		}
		//计算平均值
		avg = avg / array.size();
		System.out.println(array.size());
		System.out.println(avg);
		for (int i = 0; i < array.size() - 1; i++) {
			s++;
			array.set(i + 1, array.get(i + 1) + array.get(i) - avg);
		}
		System.out.println("s:" + s);
	}

}
