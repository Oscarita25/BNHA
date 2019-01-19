package com.oscar.util;

public class Multipliers {
	private double cooldownMultiplier, activatedMultiplier;
	
		public Multipliers(double activatedMultiplier, double cooldownMultiplier) {
			this.cooldownMultiplier = cooldownMultiplier;
			this.activatedMultiplier = activatedMultiplier;
		}
	
		public double getCooldownMultiplier() {
			return cooldownMultiplier;
		}
	
		public double getActivatedMultiplier() {
			return activatedMultiplier;
		}

}
