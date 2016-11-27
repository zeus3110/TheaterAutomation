package com.zeus3110.theater_automation.Equipment;

/**
 * Created by super_000 on 13/06/06.
 */
public class WaitCommand extends AVCommand {

	int Ms;

	public WaitCommand(int ms){
		Ms=ms;
	}


	public void Exec() throws Exception {
		Thread.sleep(Ms);
	}
}
