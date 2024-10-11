public abstract class Book {
    private String title;
    private String author;
    private boolean isAvailable;

    public Book(Boolean available,String title, String author) {
        this.title = title;
        this.author = author;
        this.isAvailable = available;
    }

    @Override
    public String toString() {
        return title + ", " + author;
    }

    public boolean isAvailable() {
        return isAvailable;
    }

    public void borrow() {
        isAvailable = false;
    }

    public String getTitle() {
        return title;
    }
    public String getAuthor() {
        return author;
    }
}
