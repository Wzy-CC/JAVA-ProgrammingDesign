// �����漴��
import java.util.Random;

// ���ࣺ����������Ϸ����
public class ShootEagle
{
	public static void main(String[] args)
	{
		// TODO Auto-generated method stub
		Hero guojing = new Hero("����",100,15,3,0.3,10);
		guojing.show();
		
		Hero huangrong = new Hero("����",100,12,4,0.4,11);
		huangrong.show();
		
		// ���ù������̣�
		AttackProcess(guojing,huangrong);
	}
	
	//�������̣�
	public static void AttackProcess(Hero a,Hero b) 
	{
		int count = 0; // ���������ƻغ�
		
		// ѭ���壺ֱ��ĳһ��ɫ����
		while (true) 
		{
			// a�����غ�:
			if (count % 2 == 0)
			{
				// ����Ч����
				int TempStrikeEffect = 0;
				// ���������:
				Random randomnum = new Random();
				// �Աȱ����ʺ��������
				if (randomnum.nextDouble() <= a.PStrike)
				{
					TempStrikeEffect = a.StrikeEffect;
				}
				
				System.out.println(a.name+"attack!");
				
				// b���ܵ��˺���
				int bDamage;
				bDamage = a.ATK - b.defence +TempStrikeEffect;
				
				b.life = b.life - bDamage;
				// ��������
				
				// �ж��Ƿ�����˱�����
				if (TempStrikeEffect != 0)
				{
					System.out.println(a.name+"��"+b.name+"�������һ����");
				}
				
				System.out.println(b.name+"������"+bDamage+"���˺�");
				
				System.out.println(b.name+"��ʣ"+b.life+"����ֵ");
				
				System.out.println("�غϽ���"+"\n");
			}
			
			// b�غϣ�
			else
			{
				// ����Ч����
				int TempStrikeEffect = 0;
				// ���������:
				Random randomnum = new Random();
				// �Աȱ����ʺ��������
				if (randomnum.nextDouble() <= b.PStrike)
				{
					TempStrikeEffect = b.StrikeEffect;
				}
				
				System.out.println(b.name+"attack!");
				
				// a���ܵ��˺���
				int aDamage;
				aDamage = b.ATK - a.defence +TempStrikeEffect;
				
				a.life = a.life - aDamage;
				// ��������
				
				// �ж��Ƿ�����˱�����
				if (TempStrikeEffect != 0)
				{
					System.out.println(b.name+"��"+a.name+"�������һ����");
				}
				
				System.out.println(a.name+"������"+aDamage+"���˺�");
				
				System.out.println(a.name+"��ʣ"+a.life+"����ֵ");
				
				System.out.println("�غϽ���"+"\n");
			}
			
			
			if (a.life <= 0 && b.life > 0)
			{
				System.out.println("��Ϸ����,"+b.name+"�����ʤ��");
				break;
			}
			
			if (a.life > 0 && b.life <= 0)
			{
				System.out.println("��Ϸ����,"+a.name+"�����ʤ��");
				break;
			}
			
			count += 1;    // ��������һ��������һ�غ�
		}
	}
}
