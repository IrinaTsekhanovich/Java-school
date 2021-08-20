package com.db.radioalarm;

/**
 * TODO Class Description
 *
 * @author IrinaTsekhanovich
 * @since 20.08.2021
 */
public class RadioAlarmDevice implements RadioService, AlarmService {
	@Override
	public void cFunction() {
		System.out.println("Say something about CCCC");
	}

	@Override
	public void dFunction() {
		System.out.println("Say something about DDDD");
	}

	@Override
	public void aFunction() {
		System.out.println("Say something about AAA");
	}

	@Override
	public void bFunction() {
		System.out.println("Say something about BBBBBBBB");
	}
}
