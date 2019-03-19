// 环境类
public class Environment {
	// 初始状态下只有一把剑和一个药包
	public Environment(Weapon w,Buff b)
	{
		System.out.println("现在周围有"+w.kind+"和"+b.kind+"!");
	}

}
