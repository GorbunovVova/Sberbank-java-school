package smarthouse.models;

import javax.persistence.*;
import java.util.Date;

@Entity
public class KettleEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;
    private boolean toggle;
    @Temporal(TemporalType.TIME)
    private Date time;

    public KettleEntity(boolean toggle, Date time) {
        this.toggle = toggle;
        this.time = time;
    }

    public KettleEntity() {
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public boolean isToggle() {
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

