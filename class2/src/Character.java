// 人物类
public class Character {
	// 角色姓名：
	String Name;
	
	// 攻击力：
	int ATK;
	
	// 生命值：
	int Life;
	
	// 物品栏(可携带物品数量)：
	int baggage;
	
	public Character(String name,int ATK,int Life,int baggage)
	{
		this.Name = name;
		this.ATK = ATK;
		this.Life = Life;
		this.baggage = baggage;
	}
	
	// 对其他角色的话做出回应：
	public void Response(Character x,String words)
	{
		if (words.equalsIgnoreCase("不友好的回答") || words.equalsIgnoreCase("A"))
		{
			attack(x);
		}
		else
		{
			System.out.println("你得到一个友好的回答！");
		}
	}
	
	// 攻击对方角色：
	public void attack(Character x)
	{
		System.out.println(x.Name+"遭受到"+ATK+"攻击！");
		x.Life = x.Life - ATK;
	}


}
