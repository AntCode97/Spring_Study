package hello.core;


import hello.core.member.MemberRepository;
import hello.core.member.MemoryMemberRepository;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.FilterType;

//@ComponentScan을 적어야 컴포넌트 스캔을 사용할 수 있음, AppConfig와 TestConfig가 스프링컨테이너에 등록되는 것을 막기위해 제외해줌
@Configuration
@ComponentScan(
        //basePackages로 지탐색할 패키지의 시작 위치를 지정할 수 있음, 이 패키지를 포함한 하위 패키지를 모두 탐색, 상위 패키지들은 탐색안
        //basePackages = "hello.core.member", //이걸 지정하지 않으면 ComponetScan이 붙은 설정 정보 클래스의 패키지가 시작위치가 됨
        // 스프링 부트에서 기본으로 제공하는 방법은 설정 정보 클래스를 프로젝트 최상위단에 두는 것이다 -> 그럼 자연스럽게 프로젝트 파일들을 다 스캔함
        excludeFilters = @ComponentScan.Filter(type = FilterType.ANNOTATION, classes = Configuration.class))
public class AutoAppConfig
{
    //@Bean(name = "memoryMemberRepository")
    //public MemberRepository memberRepository() { return new MemoryMemberRepository(); }

}
