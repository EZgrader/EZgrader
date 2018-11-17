
class Course implements Gradeable{
	
        String courseid;
        private CourseName courseName;
        List<Student> studentList;
        List<Assignment> assignmentList;
		HashMap<Student, Double> finalScoreList;  
		 
		public boolean addStudent(File file) {}
		public boolean addStudent(Student s) {}
		public boolean deleteStudent() {}
		 
		public boolean addAssignment(Assignment assignment) {
			assignmentList.add(assignment);
		}
		public boolean deleteAssignment(Assignment assignment) {
			assignmentList.remove(assignment);
		}
		 
		public boolean weightEqualsOne(){} 
		public double calculateFinalScore() {
			
			
		}
		public boolean curve(Assignment assignment , int value) {}
		public boolean changeWeight(Assignment assignment, Double newWeight) {}
		public boolean changeWeight(String type, Double newWeight) {}
		public double getMax() {}
		public double getMin() {}
		public double calculateAverage() {}
		public double calculateMedian() {}
		public void printStatistics(){}
}

