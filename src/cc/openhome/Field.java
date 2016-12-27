package cc.openhome;

public class Field { // 公开的Field类 ，会产生.java文件, 但是编译会产生多个.class文档
	
	// 定义类
	public static void exp1() {
		// 类实例的创建使用 new 关键字。 
		// 也可以直接声明一个（Java中叫 参考）
//		Clothes c1; 
		
		// 建立实例
		Clothes c1 = new Clothes();
		Clothes c2 = new Clothes();
		// 为数据成员指定值
		c1.color = "red";
		c1.size = 'S';
		c2.color = "green";
		c2.size = 'M';
		
		System.out.printf("c1 (%s, %c)\n", c1.color, c1.size);
		System.out.printf("c2 (%s, %c)\n", c2.color, c2.size);
		
		//****************华丽的分割线****************
		Clothes2 cc1 = new Clothes2("blue", 'M');
		Clothes2 cc2 = new Clothes2("yellow", 'L');
		
		//注意：带有构造函数的类，必须使用构造函数初始化
//		Clothes2 cc3 = new Clothes2(); 
		
		System.out.printf("cc1 (%s, %c)\n", cc1.color, cc1.size);
		System.out.printf("cc2 (%s, %c)\n", cc2.color, cc2.size);
	}
	
}
/* 类定义时使用 class关键词 */
class Clothes { // 非公开的类
	String color; 	// 颜色
	char size;		// 尺寸
}
/* 带有构造函数的class */
class Clothes2 {
	String color;
	char size;
	Clothes2(String color, char size) { // 构造函数，构造函数是与类名称同名的方法，直接看范例 
		// TODO Auto-generated constructor stub
		this.color = color; // this指代当前类的当前对象
		this.size = size;
	}
}

