package hello.itemservice.repository;

import lombok.Data;

@Data
public class ItemSearchCond { //아이템 검색 조건

    private String itemName;
    private Integer maxPrice;

    public ItemSearchCond() {
    }

    public ItemSearchCond(String itemName, Integer maxPrice) {
        this.itemName = itemName;
        this.maxPrice = maxPrice;
    }
}
