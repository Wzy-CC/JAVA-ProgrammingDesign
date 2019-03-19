// 道具类
public class Buff {
	// 道具种类（道具名）：
	String kind;
	// 道具效果：（回血）
	int effect;
	// 道具状态：使用/未使用：
	int Status;
	
	public Buff(String kind,int effect,int Status) 
	{
		this.kind = kind;
		this.effect = effect;
		this.Status = Status;
	}
	
	// 使用函数：
	public void UseBuff(Character x)
	{
		System.out.println("使用了"+kind+"道具！");
		x.Life = x.Life + effect;
		System.out.println("生命恢复"+effect+"点！");
	}
	
	

}
