import java.util.Arrays;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

public class Assignment implements Gradeable{
    private String name;
    private String category;
    private double weight;
    private HashMap<Student, Score> scoreList;
	@Override
	public double getMax() {
		// TODO Auto-generated method stub
		double max = Integer.MIN_VALUE;
		for (Map.Entry<Student, Score> studentScores : this.scoreList.entrySet()) {
			max = Math.max(max, studentScores.getValue().calculateScore());
		}
		return max;
	}
	@Override
	public double getMin() {
		// TODO Auto-generated method stub
		double min = Integer.MAX_VALUE;
		for (Map.Entry<Student, Score> studentScores : this.scoreList.entrySet()) {
			min = Math.min(min, studentScores.getValue().calculateScore());
		}
		return min;
	}
	@Override
	public double calculateAverage() {
		// TODO Auto-generated method stub
		double average = 0;
		for (Map.Entry<Student, Score> studentScores : this.scoreList.entrySet()) {
			average += studentScores.getValue().calculateScore();
		}
		return average / this.scoreList.size();
	}
	@Override
	public double calculateMedian() {
		// TODO Auto-generated method stub
		double[] scores = new double[this.scoreList.size()];
		int index = 0;
		for (Map.Entry<Student, Score> studentScores : this.scoreList.entrySet()) {
			scores[index++] = studentScores.getValue().calculateScore();
		}
		Arrays.sort(scores);
		if (scores.length % 2 == 0) {
			return (scores[scores.length/2] +scores[scores.length/2 + 1])/2;
		} else {
			return scores[scores.length/2];
		}
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getCategory() {
		return category;
	}
	public void setCategory(String category) {
		this.category = category;
	}
	public double getWeight() {
		return weight;
	}
	public void setWeight(double weight) {
		this.weight = weight;
	}
	public HashMap<Student, Score> getScoreList() {
		return scoreList;
	}
	public void setScoreList(HashMap<Student, Score> scoreList) {
		this.scoreList = scoreList;
	}
    
}
