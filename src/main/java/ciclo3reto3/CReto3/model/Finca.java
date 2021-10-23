package ciclo3reto3.CReto3.model;

import ciclo3reto3.CReto3.model.Categoria;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import java.io.Serializable;
import java.util.List;
import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name = "finca")
public class Finca implements Serializable{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private String address;
    private Integer exension;
    private Integer category_id;
    private String name;
    
    @ManyToOne
    @JoinColumn(name = "category")
    @JsonIgnoreProperties("finca")
    private Categoria category;

    @OneToMany(cascade = {CascadeType.PERSIST},mappedBy = "finca")
    @JsonIgnoreProperties({"finca", "client"})
    private List<Mensaje> messages;
    
    @OneToMany(cascade = {CascadeType.PERSIST},mappedBy = "finca")
    @JsonIgnoreProperties({"finca", "message"})
    private List<Reservaciones> reservations;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public Integer getExension() {
        return exension;
    }

    public void setExension(Integer exension) {
        this.exension = exension;
    }

    public Integer getCategory_id() {
        return category_id;
    }

    public void setCategory_id(Integer category_id) {
        this.category_id = category_id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Categoria getCategory() {
        return category;
    }

    public void setCategory(Categoria category) {
        this.category = category;
    }

    public List<Mensaje> getMessages() {
        return messages;
    }

    public void setMessages(List<Mensaje> message) {
        this.messages = message;
    }

    public List<Reservaciones> getReservations() {
        return reservations;
    }

    public void setReservations(List<Reservaciones> reservations) {
        this.reservations = reservations;
    }
    
    
}
