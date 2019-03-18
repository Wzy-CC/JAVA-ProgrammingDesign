//游戏角色：代表游戏中的英雄
public class Hero {
	//英雄姓名：
	String name;
	
	//英雄血量：
	int life;
	
	//英雄攻击力：
	int ATK;
	
	//英雄防御力：
	int defence;
	
	//英雄暴击率：
	double PStrike;
	
	//英雄暴击效果：
	int StrikeEffect;
	
	//构造函数：
	public Hero(String name,int life,int ATK,int defence,double PStrike,int StrikeEffect) {
		this.name = name;
		this.ATK = ATK;
		this.life = life;
		this.defence = defence;
		this.PStrike = PStrike;
		this.StrikeEffect = StrikeEffect;
	}
	
	//英雄亮相方法
	public void show() {
		System.out.println("我是"+name+"!");
	}

}
