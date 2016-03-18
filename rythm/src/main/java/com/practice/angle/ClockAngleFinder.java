package com.practice.angle;

public class ClockAngleFinder {

	public double getTheAngle(int hours, int mins, int secs) {

		// find the hours angle from 00
		// every hour it moves 30 + every min it moves 30/60 + every sec it
		// moves 30/60 * 60
		double hrsangle = (hours % 12 * 30) + (mins % 60 * 0.5) + ((secs % 60 * 30) / (60 * 60));
		// find the mins angle from 00
		// every min it moves 6 + every sec it moves 6/60
		double minsangle = (mins % 60 * 6) + ((secs % 60 * 6) / 60);
		// subtract hours angle from mins angle
		System.out.println("hrsangle::" + hrsangle);
		System.out.println("minsangle::" + minsangle);
		double angle = Math.abs(minsangle - hrsangle);

		System.out.println("angle::" + angle);
		return angle;
	}

}
