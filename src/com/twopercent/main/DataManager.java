package com.twopercent.main;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;
import java.util.Collections;

import com.sun.javafx.collections.SortableList;

public class DataManager {

	static ObjectOutputStream outputStream = null;
	static ObjectInputStream inputStream = null;
	static ArrayList<Score> scores;

	public DataManager() {
		scores = new ArrayList<>();
	}

	public static void saveFile() {
		try {
			outputStream = new ObjectOutputStream(new FileOutputStream("save.v2a"));
			outputStream.writeObject(scores);
		} catch (Exception e) {
		} finally {
			try {
				if (outputStream != null) {
					outputStream.flush();
					outputStream.close();
				}
			} catch (Exception e2) {
			}
		}
		System.out.println("SAVED");
	}

	public static void loadFile() {
		try {
			inputStream = new ObjectInputStream(new FileInputStream("save.v2a"));
			scores = (ArrayList<Score>) inputStream.readObject();
		} catch (Exception e) {
		} finally {
			try {
				if (outputStream != null) {
					outputStream.flush();
					outputStream.close();
				}
			} catch (Exception e2) {
			}
		}
		System.out.println("LOADED");

	}

	public static void sort() {
		ScoreComparator comparator = new ScoreComparator();
		Collections.sort(scores, comparator);
	}

	public static int[] getHighscore() {
		// String highscoreString = "";
		int max = 10;
		ArrayList<Score> scores;
		scores = getScores();
		int[] aScore = new int[max];
		int i = 0;
		int x = scores.size();
		if (x > max) {
			x = max;
		}
		while (i < x) {
			aScore[i] = scores.get(i).getScore();
			i++;
		}
		return aScore;
	}

	public static void addScore(int score) {
		loadFile();
		scores.add(new Score(score));
		saveFile();
	}

	public static void printArraySize() {
		loadFile();
		System.out.println("SIZE: " + scores.size());
	}

	public static void printArray() {
		for (int i = 0; i < scores.size(); i++) {
			System.out.println((i + 1) + ". " + scores.get(i).getScore());
		}
	}

	public static ArrayList<Score> getScores() {
		loadFile();
		sort();
		return scores;
	}

	public static void setScores(ArrayList<Score> scores) {
		DataManager.scores = scores;
	}

}
