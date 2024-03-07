package hello.itemservice.config;

import hello.itemservice.repository.ItemRepository;
import hello.itemservice.repository.jpa.JpaItemRepository;
import hello.itemservice.service.ItemService;
import hello.itemservice.service.ItemServiceV1;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import javax.persistence.EntityManager;

@Configuration
public class JpaConfig {

    private final EntityManager em;

    public JpaConfig(EntityManager em) {
        this.em = em;
    }

    //수동 빈 등록 (컴포넌트 스캔 대상에서 제외하고 구현객체를 선택후 수동 빈 등록)
    @Bean
    public ItemService itemService() {
        return new ItemServiceV1(itemRepository()); //생성자 방식, ItemService 객체(빈) 생성시 필드를 itemRepository 로 초기화
    }

    @Bean
    public ItemRepository itemRepository() {
        return new JpaItemRepository(em);
    }

}
