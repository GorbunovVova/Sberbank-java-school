package smarthouse.models;

import javax.persistence.*;
import java.util.Date;

@Entity
public class LightEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;
    private boolean toggle;
    @Temporal(TemporalType.DATE)
    private Date time;

    public LightEntity(boolean toggle, Date time) {
        this.toggle = toggle;
        this.time = time;
    }

    public LightEntity() {
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public boolean getToggle() {
        return toggle;
    }

    public void setToggle(boolean toggle) {
        this.toggle = toggle;
    }

    public Date getTime() {
        return time;
    }

    public void setTime(Date time) {
        this.time = time;
    }

}
