package system;

import java.util.ArrayList;
import java.util.Scanner;

import data.Task;

public class Main {

	public static void main(String[] args) {
		

		ArrayList<Task> lists = new ArrayList<>();
		Scanner sc = new Scanner(System.in); // System.in = 標準入力(キーボード)からの入力
		
		do {
			System.out.println("--------------------");
			System.out.println("1.タスク一覧表示");
			System.out.println("2.タスク作成");
			System.out.println("3.タスク修正");
			System.out.println("4.タスク削除");
			System.out.println("5.終了");
			System.out.println("--------------------");
			System.out.print("入力:");
			
			try {
				int input = sc.nextInt();
				sc.nextLine(); //改行までを捨てる
				
				if (input == 1) {
					
					if (lists.size() == 0) {
						System.out.println("タスクがありません");
						continue;
					}
					
					// 11/30宿題　リストにある全てのタスク一覧表示をする
					System.out.println( lists.get(0).getTaskName() );
					System.out.println( lists.get(1).getTaskName() );
					
					
				} else if (input == 2) {
					
					Task task = new Task( 1,"タスク1", "2024/12/24", "23:59", "未");
					lists.add(task);

				} else if (input == 3) {

					
				} else if (input == 4) {


				} else if (input == 5) {
					System.out.println("終了します");
					break;
					
				} else {
					System.out.println("1～5の数字を入力してください");
					
				}
				
			} catch (Exception e) {
				System.out.println("1～5の数字を入力してください");
				sc.nextLine(); //改行までを捨てる
			}
			
			
		} while (true);
				
		sc.close();
	}

}
