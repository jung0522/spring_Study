package hello.core.singleton;

public class StatefulService {
//    private int price; // 상태를 유지하는 필드

    // 반환값을 void에서 int로 지역변수로
    public int order(String name, int price) {
        System.out.println(name + " ordered " + price);
        return price; // 여기가 문제
    }
//    public int getPrice() {
//        return price;
//    }
}
