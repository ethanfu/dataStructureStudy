package org.ethanfu.study;

/**
 * 记得去哪儿曾经笔试有个题目是写一个student作为hashmap的key来重写Student，此为练习
 * 
 * @author ethanfu
 * 
 */
public class Student implements Comparable<Student> {
	private String name;
	private int age;
	private String address;

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	Student(String name, int age) {
		this.name = name;
		this.age = age;
	}// 用来初始化实例

	public void setName(String name) {
		this.name = name;
	}

	public String getName() {
		return name;
	}

	public void setAge(int age) {
		this.age = age;
	}

	public int getAge() {
		return age;
	}

	public String toString() {
		return this.name + "..." + this.age;
	}

	/* 只要是哈希表结构的集合 都需要覆写这两个方法 */
	public int hashCode() {
		return name.hashCode() + age * 23;
	}

	public boolean equals(Object obj) {
		if (!(obj instanceof Student)) {
			throw new ClassCastException("类型不匹配");
		}
		Student s = (Student) obj;
		return this.name.equals(s.name) && this.age == s.age; // 别什么都写成this.age.equals(s.age)
	}

	// 如果存储对象使用到二叉树结构集合，则需要进行内部排序。
	public int compareTo(Student s) {
		int num = new Integer(this.age).compareTo(new Integer(s.age));
		if (num == 0) {
			return this.name.compareTo(s.name);
		}
		return num;
	}
}
