// ������
public class Weapon {
	// �������ͣ�
	String kind;
    // ��������1-100����
	int ATK;
	// ״̬������:1/δ����:0
	int Status;

	public Weapon(String kind,int ATK,int Status)
	{
		this.kind = kind;
		this.ATK = ATK;
		this.Status = Status;
	}
	
	// ����������״̬�ı䣺
	public void PickUp(Character x)
	{
		System.out.println("����"+kind+"������!");
		Status = 1;
		// ��ɫ���������ӣ�
		x.ATK = x.ATK + ATK;
		System.out.println(x.Name+"������������");
	}
	
	// ����������״̬�ı䣺
	public void LayDown(Character x)
	{
		System.out.println("����"+kind+"��"+x.Name+"����!");
		Status = 0;
		// ��ɫ���������ͣ�
		x.ATK = x.ATK - ATK;
	}
	

}
