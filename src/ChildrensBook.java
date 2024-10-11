public class ChildrensBook extends Book{
    private int recommendedAge;

    public ChildrensBook(Boolean available,String title, String author, int recommendedAge) {
        super(available,title, author);
        this.recommendedAge = recommendedAge;
    }

    public int getRecommendedAge() {
        return recommendedAge;
    }

    @Override
    public String toString() {
        return "Childrens book, age: " + recommendedAge + ": " + super.toString();
    }
}
