package questionJAVA;

public class Q11 {
	//�]�p�@Vehicle���O�A�i��J�����M�t��
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
		System.out.println("�o�O"+this.kind);
	}
	public void setKind(String kind) {
		this.kind = kind;
	}
	public void getSpeed() {
		System.out.println("�ثe�t��: "+this.speed);
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
