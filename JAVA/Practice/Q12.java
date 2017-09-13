package questionJAVA;

public class Q12 {
	/*�Ӥu�t���T�����O�����u: 1.SalaryWorker �H�u�~�~�v�]���~���~�~���H12�^�p���~���C
					   2.HourlyWorker �H�u���~�v�p���~���C
					   3.Manager �����O SalaryWorker�A���O���F�~�~���~�A�C���٦����Q�C
	      �C�W���u�����s���C
                  �Ыŧi�@�� SalaryWorker ���O�C����u�s���� 96001�A�~�~��180000�A���g monthPay ��k�H�p��o�W���u�Ӥ몺���J�C
	      �Ыŧi�@�� HourlyWorker���O�C����u�s���� 96002�A�C��u��160�p�ɡA���~100�A���gmonthPay��k�p��o�W���u�Ӥ몺���J�C
	      �Ыŧi�@��Manager���O�C����u�s���� 97001�A�~�~�� 240000�A�C�몺���Q�� 5000�A���g monthPay��k�p��o�W���u�Ӥ몺���J�C*/	 
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
		System.out.println("���u�s��"+getNumber()+"�����~��: "+(yearPay/12));
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
		System.out.println("���u�s��"+getNumber()+"�����~��: "+(hour*hourPay));
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
		System.out.println("���u�s��"+getNumber()+"�����~��: "+(yearPay/12 + bouns));
	};
}