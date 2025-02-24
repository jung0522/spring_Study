package hello.core.member;


import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Component;

import java.util.HashMap;
import java.util.Map;

// 인터페이스(MemberRepository)랑 구현체(MemoryMemberRepository)를
// 다른 패키지에 두는 것이 좋지만 위는 간단하게 하기 위해 같은 패키지
@Component
@Primary
public class MemoryMemberRepository implements MemberRepository {

    // 실무에선 동시성 문제 때문에 ConcurrentHashMap
    // Map<key, value> HashMap Map 인터페이스를 구현하며, 해시 테이블을 기반으로 데이터를 저장한다.
    // 중복된 키는 허용되지 않으며, null 키 및 null 값을 허용
    private static Map<Long, Member> store = new HashMap<>();

    @Override
    public void save(Member member) {
        store.put(member.getId(), member);
    }

    @Override
    public Member findById(Long memberId) {
        return store.get(memberId);
    }
}
