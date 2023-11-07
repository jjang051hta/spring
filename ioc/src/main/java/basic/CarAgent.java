package basic;



public class CarAgent {

    // 강한 결합
    private Kia kia;

    public CarAgent() {
        kia = new Kia();
    }

    public void order() {
        Money money = new Money(500000000);
        System.out.println("k9 차 가격: "+money.getAmount());

        Car car = kia.sell(money);
        System.out.println("기아에 가서 차 가져옴 : "+car.getName());

    }
}
