package com.zeus3110.theater_automation.Equipment;

import java.util.HashMap;

/**
 * Created by super on 2016/06/17.
 */
public class IRKitEquipment {
    private IRKit irkit;
    private String format;
    private String freq;
    private HashMap<String,String> DB;

    public IRKitEquipment(IRKit kit, String _format, String _freq){
        irkit=kit;
        format=_format;
        freq=_freq;
        DB=new HashMap<String,String>();
    }

    public void AddFunction(String Func, String Signal){
        DB.put(Func,Signal);
    }

    public void SendSignal(String Func) throws Exception {
        String irdata=DB.get(Func);
        if(irdata!= null && irdata.length()> 0)
            irkit.SendCommand(format,freq,DB.get(Func));
        else{
            throw new IllegalArgumentException();
        }
    }
}
