package social.app.backoffice.users.domain;

import java.io.Serializable;
import java.util.HashMap;
import java.util.Map;
import java.util.Objects;

public final class BackofficeUser {
    private final String id;
    private final String name;
    private final String email;

    public BackofficeUser() {
        id       = null;
        name     = null;
        email    = null;
    }

    public BackofficeUser(String id, String name, String email) {
        this.id       = id;
        this.name     = name;
        this.email    = email;
    }

    public static BackofficeUser fromPrimitives(Map<String, Object> plainData) {
        return new BackofficeUser(
            (String) plainData.get("id"),
            (String) plainData.get("name"),
            (String) plainData.get("email")
        );
    }

    public String id() {
        return id;
    }

    public String name() {
        return name;
    }

    public String email() {
        return email;
    }

    public HashMap<String, Serializable> toPrimitives() {
        return new HashMap<String, Serializable>() {{
            put("id", id);
            put("name", name);
            put("email", email);
        }};
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        BackofficeUser that = (BackofficeUser) o;
        return id.equals(that.id) &&
               name.equals(that.name) &&
               email.equals(that.email);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, name, email);
    }
}
