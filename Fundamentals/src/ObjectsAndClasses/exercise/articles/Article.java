package ObjectsAndClasses.exercise.articles;

public class Article {

    private String title;
    private String content;
    private String author;

    Article(String title, String content, String author) {
        this.title = title;
        this.content = content;
        this.author = author;
    }

    public void editContent(String content) {
        this.content = content;
    }

    public void changeAuthor(String author) {
        this.author = author;
    }

    public void renameTitle(String title) {
        this.title = title;
    }

    @Override
    public String toString() {
        return String.format("%s - %s: %s",this.title,this.content,this.author).trim();
    }
}
