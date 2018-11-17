import java.util.Map;
import java.util.HashMap;
import java.util.List;


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
			return true;
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
			return true;
		}
		public boolean changeWeight(String type, Double newWeight) {
			return true;
		}
		public double getMax() {
			return 0;
		}
		public double getMin() {
			return 0;
		}
		public double calculateAverage() {
			for(Map.Entry<Student, Double> studentFinalScores : finalScoreList.entrySet()) {
				
			}
			return 0;
		}
		public double calculateMedian() {
			return 0;
		}
		public void printStatistics(){}
}


