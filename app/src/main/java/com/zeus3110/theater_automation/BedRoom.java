package com.zeus3110.theater_automation;

import com.zeus3110.theater_automation.Equipment.IREquipment;
import com.zeus3110.theater_automation.Equipment.ITach;

public class BedRoom {

    static ITach ITachBed;
    static IREquipment Light;
    static IREquipment Ceol;
    static IREquipment TV;
    static IREquipment Player;
    static IREquipment AirCon;

    private static void SharpLightingAddFunc(){
        Light.AddFunction("Off","129,64,16,16,16,48,16,16,16,48,16,16,16,48,16,16,16,48,16,16,16,48,16,16,16,48,16,48,16,16,16,48,16,16,16,48,16,48,16,48,16,48,16,16,16,16,16,48,16,48,16,16,16,48,16,48,16,16,16,48,16,16,16,16,16,16,16,48,16,16,16,16,16,16,16,16,16,16,16,16,16,16,16,16,16,48,16,16,16,16,16,16,16,16,16,16,16,16,16,48,16,16,16,16,16,16,16,16,16,48,16,16,16,16,16,48,16,16,16,16,16,16,16,16,16,48,16,16,16,48,16,3799");
        Light.AddFunction("Favorites","129,64,16,16,16,48,16,16,16,48,16,16,16,48,16,16,16,48,16,16,16,48,16,16,16,48,16,48,16,16,16,48,16,16,16,48,16,48,16,48,16,48,16,16,16,16,16,48,16,48,16,16,16,48,16,48,16,16,16,48,16,16,16,16,16,16,16,48,16,16,16,16,16,16,16,16,16,16,16,16,16,16,16,48,16,16,16,48,16,16,16,48,16,48,16,16,16,48,16,48,16,16,16,16,16,16,16,16,16,48,16,16,16,16,16,48,16,16,16,16,16,16,16,16,16,48,16,48,16,16,16,3799");
        Light.AddFunction("Night","129,64,16,16,16,48,16,16,16,48,16,16,16,48,16,16,16,48,16,16,16,48,16,16,16,48,16,48,16,16,16,48,16,16,16,48,16,48,16,48,16,48,16,16,16,16,16,48,16,48,16,16,16,48,16,48,16,16,16,48,16,16,16,16,16,16,16,48,16,16,16,48,16,16,16,16,16,16,16,16,16,16,16,48,16,16,16,48,16,16,16,48,16,16,16,16,16,16,16,48,16,16,16,16,16,16,16,16,16,48,16,16,16,16,16,48,16,16,16,16,16,16,16,16,16,16,16,16,16,48,16,3799");
        Light.AddFunction("Bright10","129,64,16,16,16,48,16,16,16,48,16,16,16,48,16,16,16,48,16,16,16,48,16,16,16,48,16,48,16,16,16,48,16,16,16,48,16,48,16,48,16,48,16,16,16,16,16,48,16,48,16,16,16,48,16,48,16,16,16,48,16,16,16,16,16,16,16,16,16,16,16,48,16,48,16,48,16,16,16,16,16,16,16,48,16,48,16,16,16,48,16,16,16,48,16,16,16,16,16,48,16,16,16,16,16,16,16,16,16,48,16,16,16,16,16,48,16,16,16,16,16,16,16,48,16,16,16,48,16,48,16,3799");
        Light.AddFunction("Bright3","129,64,16,16,16,48,16,16,16,48,16,16,16,48,16,16,16,48,16,16,16,48,16,16,16,48,16,48,16,16,16,48,16,16,16,48,16,48,16,48,16,48,16,16,16,16,16,48,16,48,16,16,16,48,16,48,16,16,16,48,16,16,16,16,16,16,16,48,16,48,16,48,16,16,16,16,16,16,16,16,16,16,16,48,16,48,16,16,16,48,16,16,16,48,16,16,16,16,16,48,16,16,16,16,16,16,16,16,16,48,16,16,16,16,16,48,16,16,16,16,16,16,16,48,16,48,16,48,16,16,16,3799");
        Light.AddFunction("Bright2","129,64,16,16,16,48,16,16,16,48,16,16,16,48,16,16,16,48,16,16,16,48,16,16,16,48,16,48,16,16,16,48,16,16,16,48,16,48,16,48,16,48,16,16,16,16,16,48,16,48,16,16,16,48,16,48,16,16,16,48,16,16,16,16,16,16,16,16,16,16,16,48,16,16,16,16,16,16,16,16,16,16,16,48,16,48,16,16,16,48,16,16,16,48,16,16,16,16,16,48,16,16,16,16,16,16,16,16,16,48,16,16,16,16,16,48,16,16,16,16,16,16,16,16,16,16,16,48,16,16,16,3799");
        Light.AddFunction("Bright1","129,64,16,16,16,49,16,16,16,49,16,16,16,49,16,16,16,49,16,16,16,49,16,16,16,49,16,49,16,16,16,49,16,16,16,49,16,49,16,49,16,49,16,16,16,16,16,49,16,49,16,16,16,49,16,3799");
        Light.AddFunction("Color10","129,64,16,16,16,48,16,16,16,48,16,16,16,48,16,16,16,48,16,16,16,48,16,16,16,48,16,48,16,16,16,48,16,16,16,48,16,48,16,48,16,48,16,16,16,16,16,48,16,48,16,16,16,48,16,48,16,16,16,48,16,16,16,16,16,16,16,16,16,48,16,16,16,48,16,16,16,16,16,16,16,16,16,48,16,16,16,48,16,48,16,48,16,16,16,16,16,48,16,48,16,16,16,16,16,16,16,16,16,48,16,16,16,16,16,48,16,16,16,16,16,16,16,48,16,48,16,48,16,16,16,3799");
        Light.AddFunction("Color4","129,64,16,16,16,48,16,16,16,48,16,16,16,48,16,16,16,48,16,16,16,48,16,16,16,48,16,48,16,16,16,48,16,16,16,48,16,48,16,48,16,48,16,16,16,16,16,48,16,48,16,16,16,48,16,48,16,16,16,48,16,16,16,16,16,16,16,16,16,16,16,48,16,16,16,16,16,16,16,16,16,16,16,48,16,16,16,48,16,48,16,48,16,16,16,16,16,48,16,48,16,16,16,16,16,16,16,16,16,48,16,16,16,16,16,48,16,16,16,16,16,16,16,48,16,16,16,16,16,48,16,3799");
    }

    private static void LS700AddFunc(){
        Player.AddFunction("Power","339,169,22,63,22,20,22,63,22,20,22,20,22,20,22,20,22,63,22,63,22,63,22,20,22,20,22,20,22,63,22,63,22,63,22,63,22,63,22,63,22,20,22,20,22,63,22,20,22,20,22,63,22,20,22,63,22,63,22,63,22,20,22,20,22,20,22,1502,339,84,22,3624,339,84,22,50576");
    }

    private static void CeolPiccoloAddFunc(){
        Ceol.AddFunction("Power","128,64,16,16,16,16,16,48,16,16,16,48,16,16,16,48,16,16,16,16,16,48,16,16,16,16,16,48,16,48,16,16,16,16,16,16,16,16,16,16,16,16,16,48,16,16,16,48,16,16,16,48,16,16,16,16,16,16,16,48,16,48,16,16,16,16,16,16,16,16,16,16,16,16,16,16,16,16,16,48,16,16,16,48,16,16,16,16,16,16,16,16,16,48,16,16,16,16,16,3810");
        Ceol.AddFunction("VolPlus","128,64,16,16,16,16,16,48,16,16,16,48,16,16,16,48,16,16,16,16,16,48,16,16,16,16,16,48,16,48,16,16,16,16,16,16,16,16,16,16,16,16,16,48,16,16,16,48,16,16,16,48,16,16,16,16,16,16,16,16,16,16,16,48,16,16,16,16,16,16,16,16,16,16,16,16,16,16,16,48,16,16,16,48,16,16,16,16,16,16,16,48,16,16,16,48,16,16,16,3810");
        Ceol.AddFunction("VolMinus","128,64,16,16,16,16,16,48,16,16,16,48,16,16,16,48,16,16,16,16,16,48,16,16,16,16,16,48,16,48,16,16,16,16,16,16,16,16,16,16,16,16,16,48,16,16,16,48,16,16,16,48,16,16,16,16,16,16,16,48,16,16,16,48,16,16,16,16,16,16,16,16,16,16,16,16,16,16,16,48,16,16,16,48,16,16,16,16,16,16,16,16,16,16,16,48,16,16,16,3810");
        Ceol.AddFunction("FunctionDLNA","128,64,16,16,16,16,16,48,16,16,16,48,16,16,16,48,16,16,16,16,16,48,16,16,16,16,16,48,16,48,16,16,16,16,16,16,16,16,16,16,16,16,16,48,16,16,16,48,16,16,16,48,16,48,16,48,16,16,16,48,16,16,16,48,16,16,16,16,16,16,16,16,16,48,16,16,16,16,16,48,16,16,16,48,16,48,16,48,16,48,16,16,16,16,16,48,16,16,16,3810");
        Ceol.AddFunction("FunctionAUX","128,64,16,16,16,16,16,48,16,16,16,48,16,16,16,48,16,16,16,16,16,48,16,16,16,16,16,48,16,48,16,16,16,16,16,16,16,16,16,16,16,16,16,48,16,16,16,48,16,16,16,16,16,48,16,16,16,16,16,16,16,48,16,48,16,48,16,16,16,16,16,16,16,16,16,16,16,16,16,48,16,16,16,16,16,48,16,16,16,16,16,48,16,48,16,48,16,48,16,3810");
    }

    private static void HisenseTVAddFunc(){
        TV.AddFunction("Power","341,171,21,21,22,21,22,21,21,21,22,21,22,21,21,21,22,21,22,63,22,64,21,64,22,63,22,64,21,64,22,21,21,64,22,63,22,21,22,63,22,64,21,21,22,21,22,21,21,21,22,21,22,63,22,21,22,21,21,64,22,63,22,64,21,64,22,1559,341,85,22,3787");
    }

    private static void PanasonicAirConAddFunc(){
        AirCon.AddFunction("PowerOff","128,64,16,16,16,48,16,16,16,16,16,16,16,16,16,16,16,16,16,16,16,16,16,16,16,16,16,16,16,48,16,16,16,16,16,16,16,16,16,16,16,16,16,16,16,48,16,48,16,48,16,16,16,16,16,48,16,16,16,16,16,16,16,16,16,16,16,16,16,16,16,16,16,16,16,16,16,16,16,16,16,16,16,16,16,16,16,16,16,16,16,16,16,16,16,16,16,16,16,16,16,16,16,16,16,16,16,16,16,16,16,16,16,16,16,16,16,48,16,48,16,16,16,16,16,16,16,16,16,16,16,22,128,64,16,16,16,48,16,16,16,16,16,16,16,16,16,16,16,16,16,16,16,16,16,16,16,16,16,16,16,48,16,16,16,16,16,16,16,16,16,16,16,16,16,16,16,48,16,48,16,48,16,16,16,16,16,48,16,16,16,16,16,16,16,16,16,16,16,16,16,16,16,16,16,16,16,16,16,16,16,16,16,16,16,16,16,16,16,16,16,16,16,48,16,48,16,16,16,16,16,16,16,16,16,16,16,48,16,48,16,48,16,16,16,16,16,16,16,16,16,16,16,16,16,16,16,16,16,16,16,48,16,48,16,48,16,48,16,48,16,48,16,16,16,48,16,16,16,16,16,16,16,16,16,16,16,16,16,16,16,16,16,16,16,16,16,16,16,16,16,16,16,16,16,16,16,16,16,16,16,16,16,48,16,48,16,16,16,16,16,16,16,16,16,16,16,16,16,16,16,16,16,16,16,16,16,48,16,48,16,16,16,16,16,16,16,16,16,16,16,16,16,16,16,16,16,16,16,16,16,16,16,16,16,16,16,16,16,16,16,16,16,16,16,16,16,16,16,16,16,16,16,16,16,16,16,16,16,48,16,16,16,16,16,16,16,16,16,16,16,16,16,16,16,16,16,16,16,48,16,48,16,16,16,16,16,16,16,16,16,16,16,48,16,16,16,16,16,48,16,48,16,48,16,16,16,16,16,49233");
        AirCon.AddFunction("Cool","128,64,16,16,16,48,16,16,16,16,16,16,16,16,16,16,16,16,16,16,16,16,16,16,16,16,16,16,16,48,16,16,16,16,16,16,16,16,16,16,16,16,16,16,16,48,16,48,16,48,16,16,16,16,16,48,16,16,16,16,16,16,16,16,16,16,16,16,16,16,16,16,16,16,16,16,16,16,16,16,16,16,16,16,16,16,16,16,16,16,16,16,16,16,16,16,16,16,16,16,16,16,16,16,16,16,16,16,16,16,16,16,16,16,16,16,16,48,16,48,16,16,16,16,16,16,16,16,16,16,16,22,128,64,16,16,16,48,16,16,16,16,16,16,16,16,16,16,16,16,16,16,16,16,16,16,16,16,16,16,16,48,16,16,16,16,16,16,16,16,16,16,16,16,16,16,16,48,16,48,16,48,16,16,16,16,16,48,16,16,16,16,16,16,16,16,16,16,16,16,16,16,16,16,16,16,16,16,16,16,16,16,16,16,16,48,16,16,16,16,16,16,16,48,16,48,16,16,16,16,16,16,16,48,16,16,16,48,16,48,16,48,16,16,16,16,16,16,16,16,16,16,16,16,16,16,16,16,16,16,16,48,16,48,16,48,16,48,16,48,16,16,16,48,16,16,16,48,16,16,16,16,16,16,16,16,16,16,16,16,16,16,16,16,16,16,16,16,16,16,16,16,16,16,16,16,16,16,16,16,16,16,16,48,16,48,16,16,16,16,16,16,16,16,16,16,16,16,16,16,16,16,16,16,16,16,16,48,16,48,16,16,16,16,16,16,16,16,16,16,16,16,16,16,16,16,16,16,16,16,16,16,16,16,16,16,16,16,16,16,16,16,16,16,16,16,16,16,16,16,16,16,16,16,16,16,16,16,16,48,16,16,16,16,16,16,16,16,16,16,16,16,16,16,16,16,16,16,16,48,16,48,16,16,16,48,16,16,16,16,16,16,16,16,16,16,16,48,16,48,16,48,16,16,16,16,16,48,16,49233");
    }

    static void Init(){
        ITachBed=new ITach("192.168.0.32",4000,2000);
        //IR機器初期化
        Ceol=new IREquipment("1:1",(char)38000,ITachBed);
        Light=new IREquipment("1:3",(char)37993,ITachBed);
        TV=new IREquipment("1:1",(char)37878,ITachBed);
        Player=new IREquipment("1:1",(char)38000,ITachBed);
        AirCon=new IREquipment("1:3",(char)36764,ITachBed);

        SharpLightingAddFunc();
        LS700AddFunc();
        CeolPiccoloAddFunc();
        HisenseTVAddFunc();
        PanasonicAirConAddFunc();
    }
}
