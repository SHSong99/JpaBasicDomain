package hello.itemservice;

import hello.itemservice.config.*;
import hello.itemservice.repository.ItemRepository;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Import;
import org.springframework.context.annotation.Profile;

//앞서 설정한 MemoryConfig를 설정 파일로 사용
@Import(JpaConfig.class)
//컨트롤러만 컴포넌트 스캔을 사용하고, 나머지는 (config 에서 service 와 Repository 를 수동 빈 등록) 직접 수동 등록
@SpringBootApplication(scanBasePackages = "hello.itemservice.web") //hello.itemservice.web 하위 폴더만 컴포넌트 스캔
public class ItemServiceApplication {
	public static void main(String[] args) {
		SpringApplication.run(ItemServiceApplication.class, args);
	}

	//테스트는 스프링 컨테이너가 초기화된 이후에 호출
	//TestDataInit 생성자
	@Bean
	@Profile("local")
	public TestDataInit testDataInit(ItemRepository itemRepository) {
		return new TestDataInit(itemRepository);
	}

}
