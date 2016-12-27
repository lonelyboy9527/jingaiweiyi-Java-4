package cc.openhome;

public class IntegerDemo {
	
	// 打包基本类型
	public static void exp1() {
		/* Java中有两个类型系统，即基本类型与类类型，使用基本类型在于效率，然而更多时候，会使用类建立实例，因为对象本身可以携带更多信息。
		 * 如果要让基本类型像对象一样操作，可以使用Long、Integer、Double、Boolean、Byte等类来打包基本类型。
		 * */
		
		/* Long、Integer、Double、Boolean、Byte等类是所谓等打包器。将基本类型打包在对象之中，这样就可以操作这个对象。*/
		
		int data1 = 10;
		int data2 = 20;
		Integer wrapper1 = new Integer(data1);
		Integer wrapper2 = new Integer(data2);
		System.out.println(data1 / 3); // 基本类型运算
		System.out.println(wrapper1.doubleValue() / 3); // 操作打包器方法
		System.out.println(wrapper1.compareTo(wrapper2)); // compareTo比较，产生-1 0 1；
		
		/* 基本类型打包器都是归于java.lang包中，如果要使用Integer打包int类型数据
		 * 方法1：用new创建Integer实例，传入int类型数据
		 * 2：valueOf
		 * */
	}
	// 自动装箱、拆箱
	public static void exp2() {
		/* 在J2SE 5.0之后提供了自动装箱功能，用来打包基本类型
		 * */
		Integer wrapper = 10;
		/* 编译程序会自动判断是否进行自动装箱，在上例中 wrapper会参考Integer实例；同样等动作可适用于其他集合了类型。*/
		
		Integer data1 = 10;
		Integer data2 = 20;
		System.out.println(data1.doubleValue() /3);
		System.out.println(data1.compareTo(data2));
		
		//还可以直接用变量赋值
		int i = 10;
		Integer wrapper2 = i;
		System.out.println(wrapper2);
		
		// 也可以使用更一般化的Number类来自动化装箱
		Number number = 3.14f;
		System.out.println(number); // 3.14f会被自动化装箱为float，然后在指定给number
		
		/* J2SE 5.0后可以自动装箱，也可以自动拆箱（auto unboxing），也就是自动取出打包器中的基本形态信息。
		 * 例如：
		 * */
		Integer wrapper3 = 10; // 自动装箱
		int foo = wrapper3; // wrapper3会参考至Integer，若被指定int型变量foo，则会自动取得打包的int类型再指定给foo
		
		// 在运算时，也可以自动装箱和 拆箱。
		Integer integer = 10;
		System.out.println(i + 10);
		System.out.println(i++);
		
		Boolean fooo = true;
		System.out.println(fooo && false);
	}
	// 装箱的内幕
	public static void exp3() {
		/* 自动装箱与拆箱的功能事实上时编译程序蜜糖（compiler sugar）
		 * 也就是编译程序让你撰写程序时吃点甜头，编译时期根据所撰写的语法，决定是否进行装箱或拆箱动作
		 * 例如：
		 * */
		Integer i = 100;
		// 在Oracle/Sun的JDK上，编译程序会自动将程序代码展开为:
//		Integer i = Integer.valueOf(100); // 使用JAD可以反编译.class文档
		// valueOf也是为基本类型建立打包器的方式之一
		/* 注意下面的错误写法
		 * 
		 *  		Integer ii = null;
					int i = ii.intValue();
		 *  null是一个空对象，没有指向任何实体，就不能操作intValue方法，指明用int取值
		 * */
		
		// 例子：
		Integer i1 = 100;
		Integer i2 = 100; // (其实取得时上一个100的缓存)
		if (i1 == i2) {
			System.out.println("i1 == i2"); // 执行
		} else {
			 System.out.println("i1 != i2");
		}
		
		Integer ii1 = 200;
		Integer ii2 = 200; // (超过127，取得不是缓存，new的对象)
		if (ii1 == ii2) {
			System.out.println("ii1 == ii2");
		} else {
			 System.out.println("ii1 != ii2"); // 执行
		}
		// 所以注意：比较内容，使用equale()，不应该使用 == 或者 != 
		if (ii2.equals(ii1)) {
			System.out.println("ii1 == ii2");
		} else {
			 System.out.println("ii1 != ii2");
		}
		
		/* 在IDE中，可以指定JVM启动时可用的一些自变量
		 * 在Eclipse中，可以执行Run |Run configurations命令，在
		 * Java Application -> New -> 在新增的配置文件中更改
		 * 
		 * */
	}
	
}
