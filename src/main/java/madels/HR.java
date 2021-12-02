package madels;

/**
 * Модель данных кадровик
 * @author ArvikV
 * @version 1.0
 * @since 02.12.2021
 */
public class HR {
    private int id;
    private String name;

    public HR(int id, String name) {
        this.id = id;
        this.name = name;
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
}
