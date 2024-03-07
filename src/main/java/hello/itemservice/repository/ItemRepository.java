package hello.itemservice.repository;

import hello.itemservice.domain.Item;

import java.util.List;
import java.util.Optional;

public interface ItemRepository {

    Item save(Item item);

    //이 아이디에 대해 이렇게 업데이트 해라라는 데이터
    void update(Long itemId, ItemUpdateDto updateParam);

    Optional<Item> findById(Long id);

    //검색조건 리스트
    List<Item> findAll(ItemSearchCond cond);

}
