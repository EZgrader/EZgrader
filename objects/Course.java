import java.util.*;

import com.sun.xml.internal.ws.policy.privateutil.PolicyUtils.Collections;


class Course implements Gradeable{
	
        String courseid;
        private CourseName courseName;
        List<Student> studentList;
        List<Assignment> assignmentList;
		Map<Student, Double> finalScoreList; 
		
		public Course() {
			finalScoreList = new HashMap<>();
		}
		
		public boolean addStudent(File file) {
			return true;
		}
		public boolean addStudent(Student s) {
			return studentList.add(s);
		}
		public boolean deleteStudent(Student s) {
			return studentList.remove(s);
		}
		 
		public boolean addAssignment(Assignment assignment) {
			return assignmentList.add(assignment);
		}
		public boolean deleteAssignment(Assignment assignment) {
			return assignmentList.remove(assignment);
		}
		 
		public boolean weightEqualsOne(){
			double sumOfWeights = 0;
			for(Assignment assignment: assignmentList) {
				sumOfWeights += assignment.getWeight();
			}
			if(sumOfWeights == 1.0) {
				return true;
			}
			else{
				return false;
			}
		} 
		public boolean calculateFinalScore() {

			for(Student student : studentList) {
				double finalGrade = 0.0;
				for(Assignment assignment:  assignmentList) {
					double currentStudentRawScore = student.getAssignmentScore(assignment).calculateScore();
					double currentStudentCurvedScore = currentStudentRawScore+student.getAssignmentScore(assignment).getCurvedScore();
					if(currentStudentCurvedScore > student.getAssignmentScore(assignment).getMaxScore()) {
						currentStudentCurvedScore = student.getAssignmentScore(assignment).getMaxScore();
					}
					finalGrade += (currentStudentCurvedScore * assignment.getWeight());
				}
				
				this.finalScoreList.put(student, finalGrade);
			}
			return true;
			
		}
		public boolean curve(Assignment assignment , double value) {
			
			for(Map.Entry<Student, Score> studentScores : assignment.getScoreList().entrySet()) {
				studentScores.getValue().setCurvedScore(value);
			}
			return true;
		}
		public boolean changeWeight(Assignment assignment, double newWeight) {
			
			assignment.setWeight(newWeight);
			return true;
			
		}
		
		public boolean changeWeight(String category, double newWeight) {
			double numberOfCategories = 0;
			for(Assignment assignment : assignmentList) {
				if(assignment.getCategory().equals(category)) {
					numberOfCategories++;
				}
			double newCategoryWeight = newWeight/numberOfCategories;
			for(Assignment assignment : assignmentList) {
				if(assignment.getCategory().equals(category)) {
					assignment.setWeight(newCategoryWeight);
				}
			}
			return true;
		}
		public double getMax() {
			double max = Integer.MIN_VALUE;
			for (Map.Entry<Student, Score> studentFinalScores : finalScoreList.entrySet()) {
				max = Math.max(max, studentFinalScores.getValue().calculateScore());
			}
			return max;
			
		}
		public double getMin() {
			double min = Integer.MAX_VALUE;
			for (Map.Entry<Student, Score> studentFinalScores : finalScoreList.entrySet()) {
				min = Math.min(min, studentFinalScores.getValue().calculateScore());
			}
			return min;
		}
		public double calculateAverage() {
			double = runningSum;
			double = numberOfStudents;
			for(Map.Entry<Student, Double> studentFinalScores : finalScoreList.entrySet()) {
				runningSum +=studentFinalScores;
				numberOfStudents++;
				
			}
			double average = runningSum/numberOfStudents;
			return average;
		}
		@Override
		public double calculateMedian() {
			// TODO Auto-generated method stub
			double[] scores = new double[finalScoreList.size()];
			int index = 0;
			for (Map.Entry<Student, Score> studentFinalScores : finalScoreList.entrySet()) {
				scores[index++] = studentFinalScores.getValue().calculateScore();
			}
			Arrays.sort(scores);
			if (scores.length % 2 == 0) {
				return (scores[scores.length/2] +scores[scores.length/2 + 1])/2;
			} else {
				return scores[scores.length/2];
			}
		}
		public void printStatistics(){
			System.out.println("Statistics for this course: ");
			System.out.println("Median Final Score: " + calculateMedian());
			System.out.println("Average Final Score: " + calculateAverage());
			System.out.println("Highest Final Score: " + getMax());
			System.out.println("Lowest Final Score: " + getMin());

		}
}


