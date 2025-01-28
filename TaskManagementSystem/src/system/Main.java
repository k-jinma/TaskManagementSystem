package system;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import data.Task;

public class Main {
	
	
	// ファイルの書き込みは３つのクラスを使う
	// 1. File
	// 2. FileWriter
	// 3. BufferedWriter
	
	// ファイルの読み込みは３つのクラスを使う
	// 1. File
	// 2. FileReader
	// 3. BufferedReader
	
	static ArrayList<Task> lists = new ArrayList<>();
	static File file = new File("data.csv");
	static FileWriter fw;
	static BufferedWriter bw;
	
	

	public static void main(String[] args) {
		
		// 保存されたファイルの読み込み
		readDataFile();


		Scanner sc = new Scanner(System.in); // System.in = 標準入力(キーボード)からの入力
		
		do {
			System.out.println("--------------------");
			System.out.println("1.タスク一覧表示");
			System.out.println("2.タスク完了");
			System.out.println("3.タスク作成");
			System.out.println("4.タスク修正");
			System.out.println("5.タスク削除");
			System.out.println("9.終了");
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
					
					
					dispList();
					
					
					
				} else if (input == 2) {
					
					int i;
					for (i = 0; i < lists.size(); i++) {
						
						if (lists.get(i).getComp().equals("済")) {
							continue;
						}
						System.out.println(i+1 + "：" + lists.get(i).getTaskName());
						
					}
					
					System.out.print("完了する番号を入力してください：");
					int no = sc.nextInt();
					sc.nextLine(); //改行までを捨てる
					
					
					if (lists.size() < no || lists.get(no-1).getComp().equals("済")) {
						System.out.println("正しい番号を入力してください");
						continue;
					}
					
					
					lists.get(no-1).setComp("済");
					System.out.println("完了しました");
					
				
					
				
				} else if (input == 3) {
					
					System.out.print("タスク名を入力してください:");
					String taskName = sc.nextLine();
					System.out.print("期限（年月日）を入力してください:");
					String timeLimit1 = sc.nextLine();
					
					
			        // 日付の形式を検証するための正規表現
			        String regex = "^\\d{4}/\\d{2}/\\d{2}$";
			        Pattern pattern = Pattern.compile(regex);
			        Matcher matcher = pattern.matcher(timeLimit1);
			        
			        if (!matcher.matches()) {
			        	System.out.println("yyyy/mm/dd形式で入力してください");
			            continue;
			        }
					
					System.out.print("時間を入力してください:");
					String timeLimit2 = sc.nextLine();
					
					//regex = "^\\d{2}:\\d{2}$";
					regex = "^(?:[01]\\d|2[0-3]):[0-5]\\d$";
					/*
					 	^：文字列の先頭を示します。
						(?:[01]\\d|2[0-3])：時間の部分を表します。
						[01]\\d：00から19までの時間を表します。
							[01]：0または1
							\\d：任意の数字（0-9）
						|：または
						2[0-3]：20から23までの時間を表します。
							2：2
							[0-3]：0から3までの任意の数字
						:：コロンを表します。
						[0-5]\\d：分の部分を表します。
						[0-5]：0から5までの任意の数字
						\\d：任意の数字（0-9）
						$：文字列の末尾を示します。
						この正規表現は、時間が00:00から23:59の範囲内であることを検証します。
					 */

					pattern = Pattern.compile(regex);
					Matcher matcher2 = pattern.matcher(timeLimit2);
					
					if (!matcher2.matches()) {
						System.out.println("hh:mm形式で入力してください");
						continue;
					}
					
					
					
					
					Task task = new Task( 1,taskName, timeLimit1, timeLimit2, "未");
					lists.add(task);

				} else if (input == 4) {
					
					if (lists.size() == 0) {
						System.out.println("タスクがありません");
						continue;
					}
					
					int no1;
					int no2;
					
					do {
						dispList();
						System.out.print("修正する番号を入力してください：");
						no1 = sc.nextInt();
						sc.nextLine(); //改行までを捨てる
						String display = """
								1：タスク名
								2：済／未
								3：期限（年月日）
								4：期限（時間）
								""";
						System.out.println(display);
						System.out.print("項目番号を入力してください：");
						no2 = sc.nextInt();
						sc.nextLine(); //改行までを捨てる
						if (no2 < 1 || no2 > 4) {
							System.out.println("1～4の数字を入力してください");
						} else {
							break;
						}
					} while (true);
					
					
					do {
						System.out.print("修正内容を入力してください：");
						String text = sc.nextLine();
						if (no2 == 1) {
							lists.get(no1 - 1).setTaskName(text);
						} else if (no2 == 2) {

							if (text.equals("済") || text.equals("未")) {
								lists.get(no1 - 1).setComp(text);
								break;
							} else {
								System.out.println("済または未を入力してください");
							}

						} else if (no2 == 3) {
							lists.get(no1 - 1).setTimeLimit1(text);
							break;
						} else if (no2 == 4) {
							lists.get(no1 - 1).setTimeLimit2(text);
							break;
						} 
					} while (true);

					
				} else if (input == 5) {
					
					for (int i = 0; i < lists.size(); i++) {
						System.out.println(i+1 + "：" + lists.get(i).getTaskName());
					}
					
					System.out.print("削除する番号を入力してください：");
					int no = sc.nextInt();
					sc.nextLine(); //改行までを捨てる
					
					lists.remove(no-1);
					


				} else if (input == 9) {
					
					fw = new FileWriter(file);
					bw = new BufferedWriter(fw);
					
					
					for (int i = 0; i < lists.size(); i++) {
						bw.write( lists.get(i).getNo() + "," + lists.get(i).getTaskName() + "," + lists.get(i).getTimeLimit1() + ","
								+ lists.get(i).getTimeLimit2() + "," + lists.get(i).getComp() + "\n");
					}
					bw.flush();
					
					System.out.println("終了します");
					break;
					
				} else {
					System.out.println("1～5,9の数字を入力してください");
					
				}
				
			} catch (Exception e) {
				System.out.println("1～5,9の数字を入力してください");
				sc.nextLine(); //改行までを捨てる
			}
			
			
		} while (true);
				
		sc.close();
	}
	
	static void readDataFile() {

		
		try {
			FileReader fr = new FileReader(file);
			BufferedReader br = new BufferedReader(fr);
			
			String line;
			while ((line = br.readLine()) != null) {
				
				String[] a = line.split(",");
				Task t = new Task(Integer.parseInt(a[0]), a[1], a[2], a[3], a[4]);
				//Task.TaskSu++;
				lists.add(t);
			}
			
			
		} catch (FileNotFoundException e) {
			System.out.println("ファイルがありません");
			
		} catch (IOException e) {
			// TODO 自動生成された catch ブロック
			e.printStackTrace();
		}
	}

	static void dispList() {
		// 11/30宿題　リストにある全てのタスク一覧表示をする
		for (int i = 0; i < lists.size(); i++) {
			System.out.print(i + 1 + "：" + lists.get(i).getTaskName() + " " +  lists.get(i).getComp() + " " + lists.get(i).getTimeLimit1() + " " + lists.get(i).getTimeLimit2() + "\n");
			
		}
	}
	
}









