package com.practice;

import java.util.Arrays;

import org.junit.Test;

import com.practice.matrices.MirrorMatrix;

public class MirrorMatrixTest {

	@Test
	public void validTest() {
		MirrorMatrix mat = new MirrorMatrix();
		int[][] mirror = mat.getMirror(new int[][]{{1,2,3},{4,5,6},{7,8,9}});
		for(int i=0;i<mirror.length;i++)
		System.out.println(Arrays.toString(mirror[i]));
	}
}
