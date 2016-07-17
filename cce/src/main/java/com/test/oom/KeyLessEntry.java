package com.test.oom;

import java.util.HashMap;
import java.util.Map;

public class KeyLessEntry {

	static class Key {
		Integer id;

		Key(Integer id) {
			this.id = id;
		}

		/*
		 * @Override public boolean equals(Object o) { boolean response = false;
		 * if (o instanceof Key) { response = (((Key)o).id).equals(this.id); }
		 * return response; }
		 * 
		 * @Override public int hashCode() { return id.hashCode(); }
		 */
	}

	public static void main(String[] args) {
		Map m = new HashMap();
		while (true)
			for (int i = 0; i < 10000; i++)
				if (!m.containsKey(new Key(i)))
					m.put(new Key(i), "Number:" + i);
	}
}