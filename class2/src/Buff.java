// ������
public class Buff {
	// �������ࣨ����������
	String kind;
	// ����Ч��������Ѫ��
	int effect;
	// ����״̬��ʹ��/δʹ�ã�
	int Status;
	
	public Buff(String kind,int effect,int Status) 
	{
		this.kind = kind;
		this.effect = effect;
		this.Status = Status;
	}
	
	// ʹ�ú�����
	public void UseBuff(Character x)
	{
		System.out.println("ʹ����"+kind+"���ߣ�");
		x.Life = x.Life + effect;
		System.out.println("�����ָ�"+effect+"�㣡");
	}
	
	

}
