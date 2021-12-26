package dream.models;

import java.time.LocalDateTime;
import java.util.Objects;

/**
 * @author ArvikV
 * @version 1.0
 * @since 05.12.2021
 */
public class Post {
    private int id;
    private String name;
    private String description;
    private LocalDateTime created;

    public Post(int id, String name, String description, LocalDateTime created) {
        this.id = id;
        this.name = name;
        this.description = description;
        this.created = created;
    }

    public Post(int id, String name) {
        this.id = id;
        this.name = name;
    }

    public Post(String name, String description, LocalDateTime created) {
        this.name = name;
        this.description = description;
        this.created = created;
    }

    public LocalDateTime getCreated() {
        return created;
    }

    public void setCreated(LocalDateTime created) {
        this.created = created;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public int getID() {
        return id;
    }

    public void setID(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        Post post = (Post) o;
        return id == post.id && Objects.equals(name, post.name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, name);
    }
}
