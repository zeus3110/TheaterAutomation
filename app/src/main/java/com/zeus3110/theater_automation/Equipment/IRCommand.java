package com.zeus3110.theater_automation.Equipment;

public class IRCommand extends AVCommand {

	private String Func;
	private IREquipment Eq;

	public IRCommand(IREquipment _Eq,String _Func){
		Eq=_Eq;
		Func=_Func;
	}

	public void Exec() throws Exception {
		Eq.SendSignal(Func);
	}
}
