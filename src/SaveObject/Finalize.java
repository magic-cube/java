package SaveObject;
/**
 * 对象的自我救赎  finalize
 * 要真正宣告一个对象死亡，至少要经历两次标记过程
 * 1.进行可达性分析后发现没有与GC Roots 相连接的引用链，被第一次标记并进行一次筛选，看它是否有必要执行finalize方法
 *   如果对象没有自己去覆盖finalize方法或是虚拟机已经调用过finalize方法，这两种情况被虚拟机视为“没必要执行”
 * 2.若果有必要指向finalize方法，那么这个对象会被放置在一个F—Queue的队列中，
 *   finalize方法是对象逃脱死亡命运的最后一次机会，GC将对F-Queue队列中的对象进行第二次小规模的标记
 *   如果对象要在finalize中拯救自己，只需重新与引用链上的任何一个对象建立关联即可
 *   譬如，把自己（this关键字）赋值给某个类变量或对象的成员变量，那么第二次标记时她将被移除出“即将回收”的集合，
 *   如果对象这时候还没有逃脱，那基本上他就真的被回收了
 *   
 * PS：任何对象的finalize方法只会被执行一次
 * @author hc
 *
 */
public class Finalize {
	public static Finalize SAVE_HOOK;
	protected void finalize() throws Throwable{
		super.finalize();
		System.out.println("finalize mehtod executed");
		Finalize.SAVE_HOOK=this;
	}
	public void isAlive(){
		System.out.println("yes,i am alive :)");
	}
	public static void main(String args[]) throws InterruptedException{
		SAVE_HOOK=new Finalize();
		
		//对象的救赎之路。。。
		SAVE_HOOK=null; /*断开引用*/
		System.gc();
		
		//finalize方法优先级很低，暂停0.5秒等待它
		Thread.sleep(500);
		if(SAVE_HOOK!=null){
			SAVE_HOOK.isAlive();
		}else{
			System.out.println("no,i am dead :(");
		}
		
		//对象的第二次救赎！！！
		SAVE_HOOK=null; /*断开引用*/
		System.gc();
		
		//finalize方法优先级很低，暂停0.5秒等待它
		Thread.sleep(500);
		if(SAVE_HOOK!=null){
			SAVE_HOOK.isAlive();
		}else{
			System.out.println("no,i am dead :(");
		}
	}
}
