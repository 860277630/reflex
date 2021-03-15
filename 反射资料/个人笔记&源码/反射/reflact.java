package com.example.demo.fileLoad;

import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

import org.junit.Test;

import com.example.demo.entity.Books;
import com.example.demo.entity.HaveBooks;
import com.example.demo.entity.Image;

public class reflact {


	@Test
	public void testReflect() throws ClassNotFoundException, InstantiationException, IllegalAccessException, NoSuchMethodException, SecurityException, IllegalArgumentException, InvocationTargetException, NoSuchFieldException {
		Books books = new Books();
		books.setBookname("钢铁是怎样炼成的");
		books.setId(1);
		books.setPrices(35.3);
		books.setCounts(1111);
		books.setTypeid(888888);
		Class cls = Books.class;
		Field[] fields = cls.getDeclaredFields();
		for (int i = 0; i < fields.length; i++) {
			try {
				// 得到属性
				Field field = fields[i];
				// 打开私有访问
				field.setAccessible(true);
				// 获取属性
				String name = field.getName();
				// 获取属性值
				Object value = field.get(books);
				// 得到此属性的类型
				String type = field.getType().toString();
				System.out.println("===name===" + name + "===value===" + value + "===type===" + type);
				// 设置属性值    方法一
				if (type.endsWith("String")) {
					field.set(books, "鲁宾孙漂流记"); // 给属性设值
				} else if (type.endsWith("int") || type.endsWith("Integer")) {
					field.set(books, 12); // 给属性设值
				} else {
					System.out.println(field.getType() + "\t");
				}

			} catch (IllegalAccessException e) {
				e.printStackTrace();
			}
		}
		try {
			//设置属性值   方法二
			/* 
			* 得到类中的方法 
			*/
			Method[] methods = Books.class.getMethods();
			for (int i = 0; i < methods.length; i++) {
				Method method = methods[i];

				if (method.getName().startsWith("get")) {
					System.out.print("methodName:" + method.getName() + "\t");
					System.out.println("value:" + method.invoke(books));//得到get 方法的值  
				}
			} 
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}  		
		//根据字符串生成bean并设置属性
		System.out.println("====================根据字符串生成bean并设置属性====================================");
		System.out.println("=============第一种方式，需要提供空的构造方法==================");
		String  className = "Books";
		Class<?> clazz = Class.forName("com.example.demo.entity."+className);
		Object obj = clazz.newInstance();
		if(obj instanceof Books) {
			Books books2 = (Books) obj;
			books2.setId(1);
			books2.setBookname("骆驼祥子");
			System.out.println(books2.toString());
		}
		System.out.println("============第二种方式  需要对应的构造函数  空的话不需要===================");
		
		String className2 = "HaveBooks";
		Class<?> clazz2 = Class.forName("com.example.demo.entity."+className2);
		Constructor<?> constructor = clazz2.getConstructor(String.class);//需要对应的构造函数  空的话不需要
		Object obj2 = constructor.newInstance("ppppppppppp");
		System.out.println("============="+obj2.getClass());
		if(obj2 instanceof HaveBooks) {
			HaveBooks HaveBooks = (HaveBooks) obj2;
			System.out.println(HaveBooks.toString());
		}
		System.out.println("============第三种方式=======================================");
		
		String className3 = "Image";
		Class<?> clazz3 = Class.forName("com.example.demo.entity."+className3);
		Object obj3 = Class.forName("com.example.demo.entity."+className3).newInstance();
		Field idField = clazz3.getDeclaredField("id");
		Field imageField = clazz3.getDeclaredField("image");
		//设为私有属性可访问
		idField.setAccessible(true);
		imageField.setAccessible(true);
		idField.set(obj3, 1);
		imageField.set(obj3, "testImage");
		if(obj3 instanceof Image) {
			Image image1 = (Image)obj3;
			System.out.println(image1.toString());
		}
		
		System.out.println("===============实际应用===========================");

		String className4 = "Data";
		Class<?> clazz4 = Class.forName("com.example.demo.entity."+className4);
		Object obj4 = clazz4.newInstance();
		Method m = obj4.getClass().getMethod("setTop", double.class);
		m.invoke(obj4, 12.0);
		System.out.println(obj4.toString()+"======="+obj4.getClass());
		//得到top这个值
		Method m2 = obj4.getClass().getMethod("getTop");
		Double invoke = (Double) m2.invoke(obj4);
		System.out.println(invoke);				
	}
}
