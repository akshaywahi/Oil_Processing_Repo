package com.oilmgmt.util;

import java.util.Comparator;

public class DecreasingOrderComparator implements Comparator<Long> {

	@Override
	public int compare(Long o1, Long o2) {
		return (o2.compareTo(o1));
	}

}
