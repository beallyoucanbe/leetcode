package greedy;

import java.util.ArrayList;
import java.util.Scanner;

/*
 * ��N��ֽ�ƣ���ŷֱ�Ϊ1��2������n��ÿ������������,��ֽ��������Ϊn�ı���.
 * ��������һ����ȡ������ֽ��,Ȼ���ƶ������ƵĹ���Ϊ���ڱ��Ϊ1��ȡ��ֽ�ƣ�ֻ���Ƶ����Ϊ2�Ķ��ϣ�
 * �ڱ��Ϊn�Ķ���ȡ��ֽ�ƣ�ֻ���Ƶ����Ϊn-1�Ķ��ϣ���������ȡ��ֽ�ƣ������Ƶ�������߻��ұߵĶ��ϡ�
 * ����Ҫ���ҳ�һ���ƶ������������ٵ��ƶ�����ʹÿ����ֽ������һ���ࡣ
 * ���磺n=4��4��ֽ�Ʒֱ�Ϊ���� 9 �� 8 �� 17 �� 6 �ƶ����ο��ԴﵽĿ�ģ��Ӣ�ȡ4���Ʒŵ��� �ٴӢ���3�ŷŵ���Ȼ��Ӣ�ȥ1�ŷŵ��١�
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
		//�����ܵ���Ŀ
		for (int i = 0; i < array.size(); i++) {
			avg += array.get(i);
		}
		//����ƽ��ֵ
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
