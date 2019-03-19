// 武器类
public class Weapon {
	// 武器类型：
	String kind;
    // 攻击力：1-100整数
	int ATK;
	// 状态：捡起:1/未捡起:0
	int Status;

	public Weapon(String kind,int ATK,int Status)
	{
		this.kind = kind;
		this.ATK = ATK;
		this.Status = Status;
	}
	
	// 武器被捡起状态改变：
	public void PickUp(Character x)
	{
		System.out.println("武器"+kind+"被捡起!");
		Status = 1;
		// 角色攻击力增加：
		x.ATK = x.ATK + ATK;
		System.out.println(x.Name+"攻击力大增！");
	}
	
	// 武器被放下状态改变：
	public void LayDown(Character x)
	{
		System.out.println("武器"+kind+"被"+x.Name+"放下!");
		Status = 0;
		// 角色攻击力降低：
		x.ATK = x.ATK - ATK;
	}
	

}
