package hello.core.member;

public class MemberServiceImpl implements MemberService{
    //구현체가 하나 밖에 없을 때에는 그냥 인터페이스 이름뒤에 Impl를 붙이는 것으로 클래스명일 지칭하는 관행이 있다.

    private final MemberRepository memberRepository ;

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

}
