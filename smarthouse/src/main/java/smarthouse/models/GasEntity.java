package smarthouse.models;

import javax.persistence.*;
import java.util.Date;

@Entity
public class GasEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;
    private double value;
    @Temporal(TemporalType.TIME)
    private Date time;

    public GasEntity(double value, Date time) {
        this.value = value;
        this.time = time;
    }

    public GasEntity() {
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public double getValue() {
        return value;
    }

    public void setValue(double value) {
        this.value = value;
    }

    public Date getTime() {
        return time;
    }

    public void setTime(Date time) {
        this.time = time;
    }
}
