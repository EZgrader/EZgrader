
public class Score implements Comparable<Score>{
    private double maxScore;
    private double pointsLost;
    private double curvedScore;
    private double percentage;
    private String comment;
    private static final double DEFAULTCURVE = 0;
    private static final String DEFAULTCOMMENT = "";
    private static final double DEFAULTPERCENTAGE = 0;
    private boolean hasComment = false;
    
    public Score(double pointsLost, double maxScore) {
    		this.maxScore = maxScore;
    		this.pointsLost = pointsLost;
    		this.curvedScore = DEFAULTCURVE;
    		this.comment = DEFAULTCOMMENT;
    		this.percentage = DEFAULTPERCENTAGE;
    }
    
    public double calculateScore() {
    		return this.maxScore - this.pointsLost;
    }

    public double calculatePercentage() {
    		double percentage = (this.maxScore - this.pointsLost) / this.maxScore;
    		setPercentage(percentage);
    		return percentage;
    }
    
    public double getPercentage() {
    		return this.percentage;
    }
    
    public double getMaxScore() {
		return maxScore;
	}

	public void setMaxScore(double maxScore) {
		this.maxScore = maxScore;
	}

	public double getPointsLost() {
		return pointsLost;
	}

	public void setPointsLost(double pointsLost) {
		this.pointsLost = pointsLost;
	}

	public Double getCurvedScore() {
		return curvedScore;
	}

	public void setCurvedScore(double curvedScore) {
		this.curvedScore = curvedScore;
	}

	public boolean isHasComment() {
		return hasComment;
	}

	public void setHasComment(boolean hasComment) {
		this.hasComment = hasComment;
	}

	public void setPercentage(Double percentage) {
		this.percentage = percentage;
	}

	public void setComment(String comment) {
    		this.comment = comment;
    		this.hasComment = true;
    }
    
    public String getComment() {
    		return this.comment;
    }

	@Override
	public int compareTo(Score two) {
		// TODO Auto-generated method stub
		return (int)(this.calculateScore() - two.calculateScore());
	}
}
