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

    public GoodBean(double price, String name) {

        this.price = price;
        this.name = name;
    }

    public GoodBean(int num, double price, String name) {
        this.num = num;
        this.price = price;
        this.name = name;
    }
    @Generated(hash = 1528809783)
    public GoodBean(int num, double price, @NotNull String name, Long id) {
        this.num = num;
        this.price = price;
        this.name = name;
        this.id = id;
    }
    @Generated(hash = 1348485518)
    public GoodBean() {
    }
}
