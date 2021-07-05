package com.teerjustin.ninjagame.model;

public class Activity {
	public String text;
	public boolean gain;
	public String date;
	
	public Activity() {
		
	}
	
	public Activity(String text) {
		
	}
	
	public Activity(String t, boolean g) {
		this.text = t;
		this.gain = g;
	}
	
	public Activity(String t, boolean g, String d) {
		this.text = t;
		this.gain = g;
		this.date = d;
	}
	
	public String getText() {
		return this.text;
	}
	
	public boolean getGain() {
		return this.gain;
	}
	
	public String getDate() {
		return this.date;
	}
	
	
	public void setText(String value) {
		this.text = value;
	}
	
	public void setGain(boolean value) {
		this.gain = value;
	}
}
