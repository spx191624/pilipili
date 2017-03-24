package nataya.pilipili.bean;

import org.greenrobot.greendao.annotation.Entity;
import org.greenrobot.greendao.annotation.Id;
import org.greenrobot.greendao.annotation.NotNull;
import org.greenrobot.greendao.annotation.Generated;

/**
 * Created by 191624 on 2017/3/24.
 */
@Entity
public class History {
    @Id
    private Long id;
    @NotNull
    private String text;
    @Generated(hash = 1807118791)
    public History(Long id, @NotNull String text) {
        this.id = id;
        this.text = text;
    }
    @Generated(hash = 869423138)
    public History() {
    }
    public Long getId() {
        return this.id;
    }
    public void setId(Long id) {
        this.id = id;
    }
    public String getText() {
        return this.text;
    }
    public void setText(String text) {
        this.text = text;
    }
}
