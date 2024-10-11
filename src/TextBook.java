public class TextBook extends Book{
    public enum SubjectArea {SCIENCE, ART, BUSINESS, LAW};

    private SubjectArea subjectArea;

    public TextBook(Boolean available, String title, String author, SubjectArea subjectArea) {
        super(available,title, author);
        this.subjectArea = subjectArea;
    }

    public SubjectArea getSubjectArea() {
        return subjectArea;
    }

    @Override
    public String toString() {
        return "Textbook in " + subjectArea.toString() + ": " + super.toString();
    }
}
