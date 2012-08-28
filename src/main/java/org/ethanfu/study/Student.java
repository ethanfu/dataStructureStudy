package org.ethanfu.study;

/**
 * 记得去哪儿曾经笔试有个题目是写一个student作为hashmap的key来重写Student，此为练习
 * 
 * @author ethanfu
 * 
 */
public class Student implements Comparable<Student> {

	private int age;
	private String name;
	private String address;
	//test
	public Student(int age, String name, String address) {
		super();
		this.age = age;
		this.name = name;
		this.address = address;
	}
	
	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((address == null) ? 0 : address.hashCode());
		result = prime * result + age;
		result = prime * result + ((name == null) ? 0 : name.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Student other = (Student) obj;
		if (address == null) {
			if (other.address != null)
				return false;
		} else if (!address.equals(other.address))
			return false;
		if (age != other.age)
			return false;
		if (name == null) {
			if (other.name != null)
				return false;
		} else if (!name.equals(other.name))
			return false;
		return true;
	}

	@Override
	public int compareTo(Student o) {
		
		int num = new Integer(this.age).compareTo(o.age);
		if(num == 0){
			return this.name.compareTo(o.name);
		}
		return num;
	}

}
