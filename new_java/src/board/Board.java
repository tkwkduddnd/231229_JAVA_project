package board;

public class Board {
    private String title;
    private String content;
    private String name;
    private int number;
    private String date;

    
    public Board(String title, String content, String name, int number, String date) {
        this.title = title;
        this.content = content;
        this.name = name;
        this.number = number;
        this.date = date;
    }

    
    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getNumber() {
        return number;
    }

    public void setNumber(int number) {
        this.number = number;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }
}
