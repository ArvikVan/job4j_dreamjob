package madels;

/**
 * @author ArvikV
 * @version 1.0
 * @since 02.12.2021
 */
public class Candidate {
    private int id;
    private String name;
    private String education;
    private String post;

    public Candidate(int id, String name, String education, String post) {
        this.id = id;
        this.name = name;
        this.education = education;
        this.post = post;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEducation() {
        return education;
    }

    public void setEducation(String education) {
        this.education = education;
    }

    public String getPost() {
        return post;
    }

    public void setPost(String post) {
        this.post = post;
    }
}
