import java.util.Map;
import java.util.HashMap;


class Course implements Gradeable{
	
        String courseid;
        private CourseName courseName;
        List<Student> studentList;
        List<Assignment> assignmentList;
		Map<Student, Double> finalScoreList;  
		
		public boolean addStudent(File file) {}
		public boolean addStudent(Student s) {
			studentList.add(s);
		}
		public boolean deleteStudent(Student s) {
			studentList.remove(s);
		}
		 
		public boolean addAssignment(Assignment assignment) {
			assignmentList.add(assignment);
		}
		public boolean deleteAssignment(Assignment assignment) {
			assignmentList.remove(assignment);
		}
		 
		public boolean weightEqualsOne(){} 
		public double calculateFinalScore() {
			Map finalScoreList = new Map<>();
			for(Student student : studentList) {
				double finalGrade = 0.0;
				for(Assignment assignment:  assignmentList) {
					double currentStudentRawScore = student.getAssignmentScore(assignment);
					double currentStudentCurvedScore = currentStudentRawScore + Score.getCurvedScore();
					if(currentStudentCurvedScore > Score.getMaxScore()) {
						currentStudentCurvedScore = Score.getMaxScore();
					}
					finalGrade += (currentStudentCurvedScore * assignment.getWeight());
				}
				
				this.finalScoreList.put(student, finalGrade);
			}
			
		}
		public boolean curve(Assignment assignment , double value) {
			
			for(Map.entry<Student, Score> studentScores : assignment.getscoreList) {
				studentScores.getValue().setCurvedScore(value);
			}
		}
		public boolean changeWeight(Assignment assignment, double newWeight) {}
		public boolean changeWeight(String type, Double newWeight) {}
		public double getMax() {}
		public double getMin() {}
		public double calculateAverage() {
			for(Map.entry<Student, Score> studentFinalScores : finalScoreList
		}
		public double calculateMedian() {}
		public void printStatistics(){}
}


