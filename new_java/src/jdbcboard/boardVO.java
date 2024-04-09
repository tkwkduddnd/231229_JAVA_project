package jdbcboard;

public class boardVO {
    private int bno;
    private String title;
    private String writer;
    private String content;
    private String regdate;
    private String moddate;

    //생성자
    public boardVO() {}

    // 게시글 등록
    public boardVO(String title, String writer, String content) {
        this.title = title;
        this.writer = writer;
        this.content = content;
    }

    // 게시글 목록
    public boardVO(int bno, String title, String writer, String content, String regdate) {
        this.bno = bno;
        this.title = title;
        this.writer = writer;
        this.content = content;
        this.regdate = regdate;
    }

    // 게시글 수정
    public boardVO(int bno, String title, String writer, String content) {
        this.bno = bno;
        this.title = title;
        this.writer = writer;
        this.content = content;
    }

    // 상품 검색
    public boardVO(int bno, String title, String writer, String content, String regdate, String moddate) {
        this(bno, title, writer, content);
        this.regdate = regdate;
        this.moddate = moddate;
    }

    public int getBno() {
        return bno;
    }

    public void setBno(int bno) {
        this.bno = bno;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getWriter() {
        return writer;
    }

    public void setWriter(String writer) {
        this.writer = writer;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public String getRegdate() {
        return regdate;
    }

    public void setRegdate(String regdate) {
        this.regdate = regdate;
    }

    public String getModdate() {
        return moddate;
    }

    public void setModdate(String moddate) {
        this.moddate = moddate;
    }

    @Override
    public String toString() {
        return "boardVO [bno=" + bno + ", title=" + title + ", writer=" + writer + ", content=" + content + ", regdate="
                + regdate + ", moddate=" + moddate + "]";
    }

}
