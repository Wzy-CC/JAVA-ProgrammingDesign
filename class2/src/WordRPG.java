import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

// ���ࣺ��Ϸ����
public class WordRPG {

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		
		// ��ʼ�����͵��ߣ�
		Weapon weapon = new Weapon("��",10,0);
		Buff buff = new Buff("ҽҩ��",100,0);
		
		// ��ʼ����Χ������
		Environment environment = new Environment(weapon,buff);
		
		// ��Ϸ���壺
		// �������룺
	    String command;
	    InputStreamReader in = new InputStreamReader(System.in);
	    BufferedReader br = new BufferedReader(in);
	    System.out.println("������Ӣ�۵����֣�");
	    command = br.readLine();
	    
	    // ��ʼ����ɫ��
	    Character YourHero = new Character(command,10,100,2);
	    Character NPC = new Character("NPC",10,100,2);
	    
	    do 
	    {
	    	System.out.println("�������");
	    	System.out.println(" A������NPC | Talk����NPC�Ի� | B��ʹ�õ��� | W����������  | layW���������� | quit:�˳���Ϸ");
	    	command = br.readLine();
	    	System.out.println("�����������Ϊ��"+command);
	    	
	    	// ����NPC��
	    	if(command.equalsIgnoreCase("A"))
	    	{
	    		System.out.println(YourHero.Name+"������"+NPC.Name);
	    		NPC.Response(YourHero,command);
	    	}
	    	
	    	// ��NPC��̸��
	    	else if(command.equalsIgnoreCase("Talk"))
	        {
	    		String word;
	    		InputStreamReader inw = new InputStreamReader(System.in);
	    		BufferedReader brw = new BufferedReader(inw);
	    		word = brw.readLine();
	    		
	    		System.out.println("��NPC��̸");
	    		NPC.Response(YourHero,word);
	        }
	    	
	    	// ʹ�õ��ߣ�
	    	else if(command.equalsIgnoreCase("B"))
	        {
	    		if(buff.Status == 1)
	    		{
	    			System.out.println("�޵��߿���");
	    		}
	    		else
	    		{
	    			buff.Status = 1;
	    		    buff.UseBuff(YourHero);
	    		}
	        }
	    	
	    	// ����������
	    	else if(command.equalsIgnoreCase("W"))
	        {
	    		if(weapon.Status == 1)
	    		{
	    			System.out.println("����������");
	    		}
	    		else
	    		{
	    			weapon.PickUp(YourHero);	
	    		}
	        }
	    	
	    	// ����������
	    	else if(command.equalsIgnoreCase("layW"))
	        {
	    		if(weapon.Status == 0)
	    		{
	    			System.out.println("����û������");
	    		}
	    		else
	    		{
	    			weapon.LayDown(YourHero);
	    		}
	        }
	    	
	    	// �˳���Ϸ��
	    	else if(command.equalsIgnoreCase("quit"))
	        {
	    		System.out.println("�˳���Ϸ��");
	        }
	    	
	    	// ���ǺϷ����
	    	else
	    	{
	    		System.out.println("������Ĳ��ǺϷ�����");
	    	}
	    	
	    }while (!command.equalsIgnoreCase("quit"));

	}

}
