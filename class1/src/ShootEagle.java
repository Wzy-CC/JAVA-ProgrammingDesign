// 导入随即库
import java.util.Random;

// 主类：代表整个游戏世界
public class ShootEagle
{
	public static void main(String[] args)
	{
		// TODO Auto-generated method stub
		Hero guojing = new Hero("郭靖",100,15,3,0.3,10);
		guojing.show();
		
		Hero huangrong = new Hero("黄蓉",100,12,4,0.4,11);
		huangrong.show();
		
		// 调用攻击过程：
		AttackProcess(guojing,huangrong);
	}
	
	//攻击过程：
	public static void AttackProcess(Hero a,Hero b) 
	{
		int count = 0; // 计数器控制回合
		
		// 循环体：直到某一角色死亡
		while (true) 
		{
			// a攻击回合:
			if (count % 2 == 0)
			{
				// 暴击效果：
				int TempStrikeEffect = 0;
				// 生成随机数:
				Random randomnum = new Random();
				// 对比暴击率和随机数：
				if (randomnum.nextDouble() <= a.PStrike)
				{
					TempStrikeEffect = a.StrikeEffect;
				}
				
				System.out.println(a.name+"attack!");
				
				// b遭受的伤害：
				int bDamage;
				bDamage = a.ATK - b.defence +TempStrikeEffect;
				
				b.life = b.life - bDamage;
				// 输出结果：
				
				// 判断是否进行了暴击：
				if (TempStrikeEffect != 0)
				{
					System.out.println(a.name+"对"+b.name+"造成致命一击！");
				}
				
				System.out.println(b.name+"遭受了"+bDamage+"点伤害");
				
				System.out.println(b.name+"还剩"+b.life+"生命值");
				
				System.out.println("回合结束"+"\n");
			}
			
			// b回合：
			else
			{
				// 暴击效果：
				int TempStrikeEffect = 0;
				// 生成随机数:
				Random randomnum = new Random();
				// 对比暴击率和随机数：
				if (randomnum.nextDouble() <= b.PStrike)
				{
					TempStrikeEffect = b.StrikeEffect;
				}
				
				System.out.println(b.name+"attack!");
				
				// a遭受的伤害：
				int aDamage;
				aDamage = b.ATK - a.defence +TempStrikeEffect;
				
				a.life = a.life - aDamage;
				// 输出结果：
				
				// 判断是否进行了暴击：
				if (TempStrikeEffect != 0)
				{
					System.out.println(b.name+"对"+a.name+"造成致命一击！");
				}
				
				System.out.println(a.name+"遭受了"+aDamage+"点伤害");
				
				System.out.println(a.name+"还剩"+a.life+"生命值");
				
				System.out.println("回合结束"+"\n");
			}
			
			
			if (a.life <= 0 && b.life > 0)
			{
				System.out.println("游戏结束,"+b.name+"获得了胜利");
				break;
			}
			
			if (a.life > 0 && b.life <= 0)
			{
				System.out.println("游戏结束,"+a.name+"获得了胜利");
				break;
			}
			
			count += 1;    // 计数器加一，到达下一回合
		}
	}
}
