package iuh.fit.se.entities;

public class ExamDetails {
	private String board;
	private double percentage;
	private int yearOfPassing;

	public ExamDetails() {
	}

	public ExamDetails(String board, double percentage, int yearOfPassing) {
		super();
		this.board = board;
		this.percentage = percentage;
		this.yearOfPassing = yearOfPassing;
	}

	public String getBoard() {
		return board;
	}

	public void setBoard(String board) {
		this.board = board;
	}

	public double getPercentage() {
		return percentage;
	}

	public void setPercentage(double percentage) {
		this.percentage = percentage;
	}

	public int getYearOfPassing() {
		return yearOfPassing;
	}

	public void setYearOfPassing(int yearOfPassing) {
		this.yearOfPassing = yearOfPassing;
	}

	@Override
	public String toString() {
		return "ExamDetails [board=" + board + ", percentage=" + percentage + ", yearOfPassing=" + yearOfPassing + "]";
	}

}
