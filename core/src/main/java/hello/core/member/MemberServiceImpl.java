package hello.core.member;

public class MemberServiceImpl implements MemberService {

    // 인터체이스(MemberRepository) 참조 하는 구현체(MemoryMemberRepository) 생성
    // private final MemberRepository memberRepository = new MemoryMemberRepository();private final MemberRepository memberRepository = new MemoryMemberRepository();
    // 위는 구체클래스 MemoryMemberRepository에 의존하고 있어
    // DIP를 위반하고 잇다
    // 따라서 구페클래스를 생성하고 연결시켜주는 별도의 클래스 AppConfig 생성!!

    // 의존하는 인터페이스 선언만 해주고
    private final MemberRepository memberRepository;

    // 생성자 주입
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
