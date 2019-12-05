package smarthouse.models;

import javax.persistence.*;
import java.util.Date;

@Entity
public class AlarmClockEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;
    private boolean state;
    @Temporal(TemporalType.TIME)
    private Date time;

    public AlarmClockEntity(boolean state, Date time) {
        this.state = state;
        this.time = time;
    }

    public AlarmClockEntity() {
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public boolean isState() {
        return state;
    }

    public void setState(boolean state) {
        this.state = state;
    }

    public Date getTime() {
        return time;
    }

    public void setTime(Date time) {
        this.time = time;
    }
}
