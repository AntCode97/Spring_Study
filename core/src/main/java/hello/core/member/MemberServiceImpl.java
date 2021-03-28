package hello.core.member;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class MemberServiceImpl implements MemberService{
    //구현체가 하나 밖에 없을 때에는 그냥 인터페이스 이름뒤에 Impl를 붙이는 것으로 클래스명일 지칭하는 관행이 있다.

    private final MemberRepository memberRepository ;

    //Component 스캔을 사용할 때 Appconfig를 사용하지 않게 되면, 의존관계주입을 해줄 수 없기 떄문에, Autowired를 붙여야한다.
    //붙이면 필요한 것을 알아서 의존관계 주입해줌
    @Autowired
    public MemberServiceImpl(MemberRepository memberRepository) {
        this.memberRepository = memberRepository;
    }

    @Override
    public void join(Member member) {
        memberRepository.save(member);
    }

    @Override
    public Member findMember(Long memberId) {
        return memberRepository.findById(memberId);
    }

    //테스트 용도
    public MemberRepository getMemberRepository(){
        return memberRepository;
    }

}
