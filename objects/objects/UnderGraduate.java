import java.util.ArrayList;

class UnderGraduate extends Student {
      private String year;
      public UnderGraduate(StudentName name, String buid, String major, String college, double gpa, String year){
            this.name = name;
            this.buid = buid;
            this.major = major;
            this.college = college;
            this.gpa = gpa;
            this.coursesList = new ArrayList<>();
            this.year = year;
      }
}
