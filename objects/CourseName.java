
public class CourseName {
	private final String name;
    private final String code;
    private final String section;
    private final String semester;
    
    public CourseName(String name, String code, String section, String semester) {
    		this.name = name;
    		this.code = code;
    		this.section = section;
    		this.semester = semester;
    }
    
    public String getName() {
    		return this.name;
    }
    
    public String getCode() {
    		return this.code;
    }
    
    public String getSection() {
    		return this.section;
    }
    
    public String getSemester() {
    		return this.semester;
    }
}
