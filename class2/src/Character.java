// ������
public class Character {
	// ��ɫ������
	String Name;
	
	// ��������
	int ATK;
	
	// ����ֵ��
	int Life;
	
	// ��Ʒ��(��Я����Ʒ����)��
	int baggage;
	
	public Character(String name,int ATK,int Life,int baggage)
	{
		this.Name = name;
		this.ATK = ATK;
		this.Life = Life;
		this.baggage = baggage;
	}
	
	// ��������ɫ�Ļ�������Ӧ��
	public void Response(Character x,String words)
	{
		if (words.equalsIgnoreCase("���ѺõĻش�") || words.equalsIgnoreCase("A"))
		{
			attack(x);
		}
		else
		{
			System.out.println("��õ�һ���ѺõĻش�");
		}
	}
	
	// �����Է���ɫ��
	public void attack(Character x)
	{
		System.out.println(x.Name+"���ܵ�"+ATK+"������");
		x.Life = x.Life - ATK;
	}


}
