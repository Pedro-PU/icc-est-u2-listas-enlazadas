package Model;

import java.util.Objects;

public class Contact {
    private String name;
    private String phone;

    public Contact(String name, String phone) {
        this.name = name;
        this.phone = phone;
    }

    public Contact(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public String getPhone() {
        return phone;
    }

    @Override
    public String toString() {
        return "Nombre: " + name + " | Teléfono: " + phone;
    }

    @Override
    public boolean equals(Object obj) {
        if (obj == null || getClass() != obj.getClass()) return false;
        if (this == obj) return true;
        Contact c = (Contact) obj;
        return name != null && name.equals(c.getName());
    }

    @Override
    public int hashCode() {
        return Objects.hash(name);
    }
}
