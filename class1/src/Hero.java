//��Ϸ��ɫ��������Ϸ�е�Ӣ��
public class Hero {
	//Ӣ��������
	String name;
	
	//Ӣ��Ѫ����
	int life;
	
	//Ӣ�۹�������
	int ATK;
	
	//Ӣ�۷�������
	int defence;
	
	//Ӣ�۱����ʣ�
	double PStrike;
	
	//Ӣ�۱���Ч����
	int StrikeEffect;
	
	//���캯����
	public Hero(String name,int life,int ATK,int defence,double PStrike,int StrikeEffect) {
		this.name = name;
		this.ATK = ATK;
		this.life = life;
		this.defence = defence;
		this.PStrike = PStrike;
		this.StrikeEffect = StrikeEffect;
	}
	
	//Ӣ�����෽��
	public void show() {
		System.out.println("����"+name+"!");
	}

}
