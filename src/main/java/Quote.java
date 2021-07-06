import java.io.Serializable;

public class Quote implements Serializable {
    private long id;
    private String content;
    private Author author; //Author object is being passed ; gives all the info.

    public Quote() {

    }

    public Quote(long id, String content, Author author) {
        this.id = id;
        this.content = content;
        this.author = author;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public Author getAuthor() {
        return author;
    }

    public void setAuthor(Author author) {
        this.author = author;
    }
}
