package com.practice;

import org.junit.Test;

import com.practice.maze.MazeRatPath;
import com.practice.sf.RatMazePath;

import junit.framework.Assert;

public class MazeRatPathTest {

	@Test
	public void validPathTest() {
		int maze[][] = { { 1, 1, 1, 0 }, { 1, 0, 1, 1 }, { 0, 1, 0, 1 }, { 1, 0, 0, 1 } };
		MazeRatPath mazeObj = new MazeRatPath();
		Assert.assertTrue(mazeObj.printPath(maze,4));
	}

	@Test
	public void invalidPathTest() {
		int maze[][] = { { 1, 0, 0, 0 }, { 1, 1, 0, 1 }, { 0, 1, 0, 0 }, { 1, 0, 1, 1 } };
		MazeRatPath mazeObj = new MazeRatPath();
		Assert.assertFalse(mazeObj.printPath(maze,4));
	}
}
