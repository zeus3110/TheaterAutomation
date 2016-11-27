package com.zeus3110.theater_automation.Equipment;

public class IRKitCommand extends AVCommand {
    private IRKitEquipment eq;
    private String func;

    public IRKitCommand(IRKitEquipment _eq,String _func){
        super();
        eq=_eq;
        func=_func;
    }

    public void Exec() throws Exception {
        eq.SendSignal(func);
    }
}