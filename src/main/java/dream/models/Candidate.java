package dream.models;

import java.time.LocalDateTime;
import java.util.Objects;

/**
 * Модель данных кандидат
 * @author ArvikV
 * @version 1.1
 * @since 02.12.2021
 *
 */
public class Candidate {
    private int id;
    private String name;
    private String image;
    private int cityId;
    private LocalDateTime created;

    public Candidate(int id, String name) {
        this.id = id;
        this.name = name;
    }

    public Candidate(int id, String name, String image) {
        this.id = id;
        this.name = name;
        this.image = image;
    }

    public Candidate(int id, String name, int cityId, LocalDateTime created) {
        this.id = id;
        this.name = name;
        this.cityId = cityId;
        this.created = created;
    }

    public LocalDateTime getCreated() {
        return created;
    }

    public void setCreated(LocalDateTime created) {
        this.created = created;
    }

    public int getCityId() {
        return cityId;
    }

    public void setCityId(int cityId) {
        this.cityId = cityId;
    }

    public void setImage(String image) {
        this.image = image;
    }

    public String getImage() {
        return image;
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

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        Candidate candidate = (Candidate) o;
        return id == candidate.id && cityId == candidate.cityId && Objects.equals(name, candidate.name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, name, cityId);
    }
}
