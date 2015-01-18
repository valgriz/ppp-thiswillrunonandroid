package com.twopercent.main;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.security.KeyStore.LoadStoreParameter;
import java.util.ArrayList;
import java.util.Collections;

import com.sun.javafx.collections.SortableList;

public class DataManager {

	static ObjectOutputStream outputStream = null;
	static ObjectInputStream inputStream = null;
	static ArrayList<Score> scores;
	public static ArrayList<Stat> stats;
	private static String[] initStatId = { "totalStarCount", "bankStarCount", "penguinInUse", "totalTime",
			"totalBounces", "totalGames", "totalStars", "muted" };
	private static Penguin[] penguinArray = { new Penguin(0, 0, true, "A PENGUIN"),
			new Penguin(1, 100, false, "BLUE BEAK"), new Penguin(2, 250, false, "WU-TANG-PENG"),
			new Penguin(3, 300, false, "SASSY"), new Penguin(4, 400, false, "GREEN PENGUIN WITH A MOHAWK"),
			new Penguin(5, 500, false, "BALLIN"), new Penguin(6, 600, false, "GABEN") };

	public DataManager() {
		scores = new ArrayList<>();
		stats = new ArrayList<>();

		loadFile();
		initStat();

		Global.penguinInUse = getStatValue("penguinInUse");
	}

	public static Penguin[] getPenguinArray() {
		return penguinArray;
	}

	public static void setPenguinArray(Penguin[] penguinArray) {
		DataManager.penguinArray = penguinArray;
	}

	public static void saveFile() {
		try {
			outputStream = new ObjectOutputStream(new FileOutputStream("save.v2a"));
			outputStream.writeObject(scores);
			outputStream.writeObject(stats);
			outputStream.writeObject(penguinArray);
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
			stats = (ArrayList<Stat>) inputStream.readObject();
			penguinArray = (Penguin[]) inputStream.readObject();
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

	// ///////////////////////////////////

	public static int getStatIndex(String statId) {
		for (int i = 0; i < stats.size(); i++) {
			if (stats.get(i).getId().equals(statId)) {
				return i;
			}
		}
		return -1;
	}

	public static boolean isStat(String statId) {
		for (int i = 0; i < stats.size(); i++) {
			if (stats.get(i).getId().equals(statId)) {
				return true;
			}

		}
		return false;
	}

	public static void initStat() {
		loadFile();
		for (int i = 0; i < initStatId.length; i++) {
			if (!isStat(initStatId[i])) {
				stats.add(new Stat(initStatId[i], 0));
			}
		}
		saveFile();
	}

	public static int getStatArraySize() {
		return stats.size();
	}

	public static int getStatValue(String statId) {
		loadFile();
		return stats.get(getStatIndex(statId)).getValue();

	}

	public static void setStatValue(String statId, int newValue) {
		loadFile();
		stats.get(getStatIndex(statId)).setValue(newValue);
		System.out.println("MAJ");
		saveFile();
	}

	public static void pringAllStatValues() {
		for (int i = 0; i < stats.size(); i++) {
			System.out.println(stats.get(i).getId() + " = " + stats.get(i).getValue());
		}
	}

	// private static int getStatIndex(String statId) {
	// int retIndex = 0;
	// for (int i = 0; i < stats.size(); i++) {
	// if (stats.get(i).getId() == statId) {
	// retIndex = i;
	// }
	// }
	// System.out.println("StatArraySize " + stats.size());
	// return retIndex;
	// }

	// public static int getStat(String statId) {
	// saveFile();
	// loadFile();
	// return stats.get(getStatIndex(statId)).getValue();
	// }

	// public static void updateStat(String statId, int newValue) {
	// loadFile();
	// stats.get(getStatIndex(statId)).setValue(newValue);
	// saveFile();
	// }

	// //////////////////////////////////////

	public static void sort() {
		ScoreComparator comparator = new ScoreComparator();
		Collections.sort(scores, comparator);
	}

	public static int[] getHighscore() {
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

	public static boolean isInHighScores(int score) {
		int[] temp = getHighscore();
		if (score >= temp[9]) {
			return true;
		} else {
			return false;
		}
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
