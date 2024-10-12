package hello.HelloSpring.Controller;

import hello.HelloSpring.Service.MemberService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class MemberController {



//        1. 생성자 주입 (의존관계가 실행중에 동적으로 변하는 경우는
//        거의 없으므로 생성자 주입을 권장)
       private final MemberService memberService;

        @Autowired
        public MemberController(MemberService memberService) {
           this.memberService = memberService;
//            CGLIB는 바이트코드 조작 라이브러리,  CGLIB는 클래스를 상속하여 프록시를 생성
           System.out.println("memberService" + memberService.getClass());
        }

    // 2. 필드 주입
    //    @Autowired private MemberService memberService;

    // 3. setter 주입
    //    private MemberService memberService;
    //
    //    @Autowired
    //    public void setMemberService(MemberService memberService) {
    //        this.memberService = memberService;
    //    }
}
