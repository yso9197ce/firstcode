package questionJAVA;

public class Q12 {
	/*該工廠有三種類別的員工: 1.SalaryWorker 以「年薪」（月薪為年薪除以12）計算薪水。
					   2.HourlyWorker 以「時薪」計算薪水。
					   3.Manager 必須是 SalaryWorker，但是除了年薪之外，每月還有紅利。
	      每名員工都有編號。
                  請宣告一個 SalaryWorker 類別。其員工編號為 96001，年薪為180000，撰寫 monthPay 方法以計算這名員工該月的收入。
	      請宣告一個 HourlyWorker類別。其員工編號為 96002，每月工時160小時，時薪100，撰寫monthPay方法計算這名員工該月的收入。
	      請宣告一個Manager類別。其員工編號為 97001，年薪為 240000，每月的紅利為 5000，撰寫 monthPay方法計算這名員工該月的收入。*/	 
	public static void main(String[] args) {
		Employee a = new SalaryWorker(96001,180000);
		a.monthpay();
		Employee b = new HourlyWorker(96002,160,100);
		b.monthpay();
		Employee c = new Manager(97001,240000);
		c.monthpay();
	}
}
class Employee{
	private int number;
	public Employee(int number){
		this.number = number;
	}
	public int getNumber() {
		return number;
	}
	public void monthpay() {};
}

class SalaryWorker extends Employee{
	private int yearPay;
	public SalaryWorker(int number,int yearPay) {
		super(number);
		this.yearPay = yearPay;
	}	
	public void monthpay() {
		System.out.println("員工編號"+getNumber()+"的月薪為: "+(yearPay/12));
	};
}

class HourlyWorker extends Employee{
	private int hour;
	private int hourPay;
	public HourlyWorker(int number,int hour,int hourPay) {
		super(number);
		this.hour = hour;
		this.hourPay = hourPay;
	}
	public void monthpay() {
		System.out.println("員工編號"+getNumber()+"的月薪為: "+(hour*hourPay));
	};
}

class Manager extends Employee{
	private int yearPay;
	private int bouns = 5000;
	public Manager(int number,int yearPay) {
		super(number);
		this.yearPay = yearPay;		
	}
	public void monthpay() {
		System.out.println("員工編號"+getNumber()+"的月薪為: "+(yearPay/12 + bouns));
	};
}