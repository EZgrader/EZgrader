import java.util.ArrayList;

class Graduate extends Student {
      private String undergraduateMajor; 
      private String specialization;
      public Graduate(StudentName name, String buid, String major, String college, double gpa, String undergraduateMajor, String specialization){
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
