package nataya.pilipili.bean;

import org.greenrobot.greendao.annotation.Entity;
import org.greenrobot.greendao.annotation.Id;
import org.greenrobot.greendao.annotation.NotNull;
import org.greenrobot.greendao.annotation.Generated;

/**
 * Created by 191624 on 2017/3/28.
 */
@Entity
public class User {
    @Id
    private Long id;
    @NotNull
    private String username;
    @NotNull
    private String pwd;

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPwd() {
        return pwd;
    }

    public void setPwd(String pwd) {
        this.pwd = pwd;
    }

    public Long getId() {
        return this.id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public User(String username, String pwd) {
        this.username = username;
        this.pwd = pwd;
    }

    @Generated(hash = 684235364)
    public User(Long id, @NotNull String username, @NotNull String pwd) {
        this.id = id;
        this.username = username;
        this.pwd = pwd;
    }

    @Generated(hash = 586692638)
    public User() {
    }
}
