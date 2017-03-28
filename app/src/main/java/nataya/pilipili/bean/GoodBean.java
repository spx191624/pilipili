package nataya.pilipili.bean;


import org.greenrobot.greendao.annotation.Entity;
import org.greenrobot.greendao.annotation.Id;
import org.greenrobot.greendao.annotation.NotNull;

import java.io.Serializable;
import org.greenrobot.greendao.annotation.Generated;


/**
 * Created by 191624 on 2017/3/28.
 */
@Entity
public class GoodBean implements Serializable{
    public String getUrl() {
        return url;
    }

    private String url;

    public int getShuid() {
        return shuid;
    }

    public void setShuid(int shuid) {
        this.shuid = shuid;
    }

    private int shuid;
    private int num = 0;
    @NotNull
    private double price;
    @NotNull
    private String name;
    @Id
    private Long id;
    private static final long serialVersionUID = 1L;

    public double getPrice() {
        return price;
    }
    public int getNum() {
        return num;
    }

    public void setNum(int num) {
        this.num = num;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Long getId() {
        return this.id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public GoodBean(int num, double price, String name,int shuid,String url) {
        this.num = num;
        this.price = price;
        this.name = name;
        this.shuid =shuid;
        this.url =url;
    }

    @Generated(hash = 1912222350)
    public GoodBean(String url, int shuid, int num, double price,
            @NotNull String name, Long id) {
        this.url = url;
        this.shuid = shuid;
        this.num = num;
        this.price = price;
        this.name = name;
        this.id = id;
    }

    @Generated(hash = 1348485518)
    public GoodBean() {
    }


}
