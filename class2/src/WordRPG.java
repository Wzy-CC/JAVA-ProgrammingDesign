import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

// 主类：游戏世界
public class WordRPG {

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		
		// 初始化剑和道具：
		Weapon weapon = new Weapon("剑",10,0);
		Buff buff = new Buff("医药包",100,0);
		
		// 初始化周围环境；
		Environment environment = new Environment(weapon,buff);
		
		// 游戏本体：
		// 键盘输入：
	    String command;
	    InputStreamReader in = new InputStreamReader(System.in);
	    BufferedReader br = new BufferedReader(in);
	    System.out.println("请输入英雄的名字：");
	    command = br.readLine();
	    
	    // 初始化角色：
	    Character YourHero = new Character(command,10,100,2);
	    Character NPC = new Character("NPC",10,100,2);
	    
	    do 
	    {
	    	System.out.println("输入命令：");
	    	System.out.println(" A：攻击NPC | Talk：与NPC对话 | B：使用道具 | W：捡起武器  | layW：放下武器 | quit:退出游戏");
	    	command = br.readLine();
	    	System.out.println("你输入的命令为："+command);
	    	
	    	// 攻击NPC：
	    	if(command.equalsIgnoreCase("A"))
	    	{
	    		System.out.println(YourHero.Name+"攻击了"+NPC.Name);
	    		NPC.Response(YourHero,command);
	    	}
	    	
	    	// 和NPC交谈：
	    	else if(command.equalsIgnoreCase("Talk"))
	        {
	    		String word;
	    		InputStreamReader inw = new InputStreamReader(System.in);
	    		BufferedReader brw = new BufferedReader(inw);
	    		word = brw.readLine();
	    		
	    		System.out.println("和NPC交谈");
	    		NPC.Response(YourHero,word);
	        }
	    	
	    	// 使用道具：
	    	else if(command.equalsIgnoreCase("B"))
	        {
	    		if(buff.Status == 1)
	    		{
	    			System.out.println("无道具可用");
	    		}
	    		else
	    		{
	    			buff.Status = 1;
	    		    buff.UseBuff(YourHero);
	    		}
	        }
	    	
	    	// 捡起武器：
	    	else if(command.equalsIgnoreCase("W"))
	        {
	    		if(weapon.Status == 1)
	    		{
	    			System.out.println("无武器可用");
	    		}
	    		else
	    		{
	    			weapon.PickUp(YourHero);	
	    		}
	        }
	    	
	    	// 放下武器：
	    	else if(command.equalsIgnoreCase("layW"))
	        {
	    		if(weapon.Status == 0)
	    		{
	    			System.out.println("手中没有武器");
	    		}
	    		else
	    		{
	    			weapon.LayDown(YourHero);
	    		}
	        }
	    	
	    	// 退出游戏：
	    	else if(command.equalsIgnoreCase("quit"))
	        {
	    		System.out.println("退出游戏！");
	        }
	    	
	    	// 不是合法命令：
	    	else
	    	{
	    		System.out.println("你输入的不是合法命令");
	    	}
	    	
	    }while (!command.equalsIgnoreCase("quit"));

	}

}
