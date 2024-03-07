package hello.itemservice.domain;

import lombok.Data;

import javax.persistence.*;

@Data
@Entity //테이블과 매핑되어 관리되는 객체
public class Item {

    @Id @GeneratedValue(strategy = GenerationType.IDENTITY) //auto Increase 와 같음
    private Long id;

    @Column(name = "item_name", length = 10) //컬럼객체명 item_name, 컬럼의 길이값 varchar(10)
    private String itemName;
    private Integer price;
    private Integer quantity;

    public Item() {
    }

    public Item(String itemName, Integer price, Integer quantity) {
        this.itemName = itemName;
        this.price = price;
        this.quantity = quantity;
    }
}
