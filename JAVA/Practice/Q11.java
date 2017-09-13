package questionJAVA;

public class Q11 {
	//設計一Vehicle類別，可輸入種類和速度
	public static void main(String[] args) {
		Vehicle train = new Vehicle();
		train.setKind("Train");
		train.setSpeed(100);
		train.move();
		train.getKind();
		train.getSpeed();
		train.speedUp(12);
		train.speedUp(8);
		train.speedDown(10);
		train.getSpeed();		
	}

}
class Vehicle{
	private String kind;
	private int speed;
	
	public void getKind() {
		System.out.println("這是"+this.kind);
	}
	public void setKind(String kind) {
		this.kind = kind;
	}
	public void getSpeed() {
		System.out.println("目前速度: "+this.speed);
	}
	public void setSpeed(int speed) {
		this.speed = speed;
	}
		
	public void move() {
		System.out.println(this.kind+" moving");
	}
	public void speedUp(int quick) {
		this.speed += quick;
	}
	public void speedDown(int slow) {
		this.speed -= slow;
	}
	
}
