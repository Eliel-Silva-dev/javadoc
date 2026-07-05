package entities;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.Serializable;
import java.util.Objects;

public class CategoryEntity implements Serializable {
    private static final Logger log = LoggerFactory.getLogger(CategoryEntity.class);
    private static final long serialVersionUID = 1L;

    private Long id;
    private String name;

    public CategoryEntity() {
    }

    public CategoryEntity(Long id, String name) {
        super();
        this.id = id;
        this.name = name;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
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
        if (!(o instanceof CategoryEntity that)) return false;
        return Objects.equals(getId(), that.getId()) && Objects.equals(getName(), that.getName());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getId(), getName());
    }
}
