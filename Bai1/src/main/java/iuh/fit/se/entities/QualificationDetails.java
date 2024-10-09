package iuh.fit.se.entities;

public class QualificationDetails {
	private ExamDetails classX;
	private ExamDetails classXII;
	private ExamDetails graduation;
	private ExamDetails masters;

	public QualificationDetails() {
	}

	public QualificationDetails(ExamDetails classX, ExamDetails classXII, ExamDetails graduation, ExamDetails masters) {
		super();
		this.classX = classX;
		this.classXII = classXII;
		this.graduation = graduation;
		this.masters = masters;
	}

	public ExamDetails getClassX() {
		return classX;
	}

	public void setClassX(ExamDetails classX) {
		this.classX = classX;
	}

	public ExamDetails getClassXII() {
		return classXII;
	}

	public void setClassXII(ExamDetails classXII) {
		this.classXII = classXII;
	}

	public ExamDetails getGraduation() {
		return graduation;
	}

	public void setGraduation(ExamDetails graduation) {
		this.graduation = graduation;
	}

	public ExamDetails getMasters() {
		return masters;
	}

	public void setMasters(ExamDetails masters) {
		this.masters = masters;
	}

	@Override
	public String toString() {
		return "QualificationDetails [classX=" + classX + ", classXII=" + classXII + ", graduation=" + graduation
				+ ", masters=" + masters + "]";
	}

}
