package com.trungtamjava.object;

public class Person_equal_hashCode {
	@Override
	public boolean equals(Object obj) {
		if (obj instanceof Person_equal_hashCode) {
			return true;
		} else {
			return false;
		}
	}

	@Override
	public int hashCode() {
		return 10;
	}
}

// hai ham nay su dung de so sanh doi tuong cung nhu su dung trong collection