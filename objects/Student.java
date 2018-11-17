package EZGrader

class StudentName implements Comparable<Name> {
      public String firstName;
      public String lastName;
      public String middleName;

      public String getFullName(){
            return this.firstName + " " + this.lastName;
      }
      // Compare using firstname
      public int compareTo(Name name1, Name name2){
            char firstLetter1 = name1.firstname.charAt(0);
            char firstLetter2 = name2.firstname.charAt(0);
            if (firstLetter1 > firstLetter2){
                  return 1;
            }else if(firstLetter1 > firstLetter2){
                  return -1;
            }else{
                  return 0;
            }
      }
}

abstract class Student {
      protected Name name;
      protected String buid;
      protected String major;
      protected String college;
      protected Double gpa;
      protected List<Course> coursesList;

      public student(Name name, String buid, String major, String college, double gpa){
            this.name = name;
            this.buid = buid;
            this.major = major;
            this.college = college;
            this.gpa = gpa;
            this.coursesList = new ArrayList<>();
      }

      public Name getName(){
            return this.name;
      }

      public String getBuid(){
            return this.buid;
      }

      public String getMajor(){
            return this.major;
      }
      
      public String getCollege(){
            return this.college;
      }

      public Double getGpa(){
            return this.gpa;
      }

      public void setName(Name name){
            this.name = name;
            return;
      }

      public void setId(String id){
            this.id = id;
            return;
      }

      public void setMajor(String major){
            this.major = major;
            return;
      }

      public void setCollege(String college){
            this.college = college;
            return;
      }

      public void setGpa(double gpa){
            this.gpa = gpa;
            return;
      }

      public boolean addCourse(Course course){
            return this.coursesList.add(course);
      }


      public Double getFinalScore(Course course){
            return course.finalScoreList.get(this);
      }
      public Score getAssignmentScore(Assignment assignment){
            return assignment.scoreList.get(this);
      }
}

class UnderGraduate extends Student {
      private String year;
      public UnderGraduate(Name name, String buid, String major, String college, double gpa, String year){
            this.name = name;
            this.buid = buid;
            this.major = major;
            this.college = college;
            this.gpa = gpa;
            this.coursesList = new ArrayList<>();
            this.year = year;
      }
}
 
class Graduate extends Student {
      private String undergraduateMajor; 
      private String specialization;
      public Graduate(Name name, String buid, String major, String college, double gpa, String undergraduateMajor, String specialization){
            this.name = name;
            this.buid = buid;
            this.major = major;
            this.college = college;
            this.gpa = gpa;
            this.coursesList = new ArrayList<>();
            this.undergraduateMajor = undergraduateMajor; 
            this.specialization = specialization;
      }
}
