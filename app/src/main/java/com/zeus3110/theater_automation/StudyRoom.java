package com.zeus3110.theater_automation;

import com.zeus3110.theater_automation.Equipment.IPAVC;
import com.zeus3110.theater_automation.Equipment.IRKit;
import com.zeus3110.theater_automation.Equipment.IRKitEquipment;


// Study Room Equipment Signal Class
public class StudyRoom {
    static IRKit IRKitStudy;
    static IRKitEquipment MaruzenLight;
    static IRKitEquipment CoronaAircon;
    static IRKitEquipment PioneerAudio;
    static IPAVC IoTWeatherKit;

    private static void MaruzenLightAddFunc(){
        MaruzenLight.AddFunction("OnOff","[9379,4878,1319,1679,1319,3458,1190,3458,1190,1679,1275,3458,1275,3458,1275,1738,1232,1738,1232,1738,1232,3458,1232,3458,1232,1738,1232,3458,1319,3458,1319,3458,1319,1622,1232,1622,1232,3458,1232,1738,1232,1738,1232,1738,1232,1738,1232,3458,1232,1738,1232,1738,1232,1738,1232,1738,1232,1738,1232,1738,1232,1738,1232,1738,1232,1738,1232,32360,9379,4878,1319,1679,1319,3458,1319,3458,1319,1679,1319,3458,1319,3458,1319,1679,1319,1679,1319,1679,1319,3458,1319,3458,1319,1679,1319,3458,1319,3458,1319,3458,1319,1679,1319,1679,1319,3458,1319,1679,1319,1679,1319,1679,1319,1679,1319,3458,1319,1679,1319,1679,1319,1679,1319,1679,1319,1679,1319,1679,1319,1679,1319,1679,1319,1679,1319]");
    }

    private static void CoronaAirconAddFunc() {
        CoronaAircon.AddFunction("Off", "[6881,3341,873,873,873,873,873,873,873,2537,873,873,873,2537,873,873,873,873,873,2537,873,873,873,873,873,873,873,873,873,2537,873,2537,873,873,873,2537,873,873,873,2537,873,2537,873,2537,873,2537,873,873,873,873,873,873,873,2537,873,873,873,873,873,2537,873,873,873,873,873,873,873,2537,873,873,873,2537,873,2537,873,873,873,2537,873,2537,873,2537,873,2537,873,2537,873,873,873,873,873,873,873,2537,873,873,873,873,873,873,873,873,873,2537,873,2537,873,2537,873,873,873,2537,873,2537,873,21415,6881,3341,873,873,873,873,873,873,873,2537,873,873,873,2537,873,873,873,873,873,2537,873,873,873,873,873,873,873,873,873,2537,873,2537,873,873,873,2537,873,873,873,2537,873,2537,873,873,873,2537,873,2537,873,873,873,2537,873,2537,873,2537,873,2537,873,2537,873,2537,873,2537,873,2537,873,873,873,873,873,873,873,873,873,873,873,873,873,873,873,873,873,2537,873,2537,873,2537,873,2537,873,2537,873,2537,873,2537,873,2537,873,873,873,873,873,873,873,873,873,873,873,873,873,873,873,873,873,21415,6881,3341,873,873,873,873,873,873,873,2537,873,873,873,2537,873,873,873,873,873,2537,873,873,873,873,873,873,873,873,873,2537,873,2537,873,873,873,2537,873,873,873,2537,873,2537,873,873,873,873,873,2537,873,2537,873,2537,873,2537,873,2537,873,2537,873,2537,873,2537,873,2537,873,2537,873,873,873,873,873,873,873,873,873,873,873,873,873,873,873,873,873,2537,873,2537,873,2537,873,2537,873,2537,873,2537,873,2537,873,2537,873,873,873,873,873,873,873,873,873,873,873,873,873,873,873,873,873]");
    }

    private static void PioneerAudioAddFunc(){

    }

    private static void IoTWeatherKitAddFunc(){
        IoTWeatherKit.AddFunction("GetTemp","TMP   ");
        IoTWeatherKit.AddFunction("GetHumid","HMD   ");
        IoTWeatherKit.AddFunction("GetPress","PRS   ");
        IoTWeatherKit.AddFunction("GetLux","ILM   ");
        IoTWeatherKit.AddFunction("GetCO2","CO2   ");
        IoTWeatherKit.AddFunction("GetInput1","INP1   ");
        IoTWeatherKit.AddFunction("GetInput2","INP1   ");
        IoTWeatherKit.AddFunction("GetInput3","INP1   ");
        IoTWeatherKit.AddFunction("GetInput4","INP1   ");
        IoTWeatherKit.AddFunction("GetOptIn","OPT    ");
        IoTWeatherKit.AddFunction("Out1On","OUT1ON ");
        IoTWeatherKit.AddFunction("Out1Off","OUT1OFF");
        IoTWeatherKit.AddFunction("Out2On","OUT2ON ");
        IoTWeatherKit.AddFunction("Out2Off","OUT2OFF");
        IoTWeatherKit.AddFunction("Out3On","OUT3ON ");
        IoTWeatherKit.AddFunction("Out3Off","OUT3OFF");
        IoTWeatherKit.AddFunction("Out4On","OUT4ON ");
        IoTWeatherKit.AddFunction("Out4Off","OUT4OFF");
    }

    static void Init(){
        IRKitStudy=new IRKit("http://192.168.0.95/messages");
        MaruzenLight=new IRKitEquipment(IRKitStudy,"raw","38");
        CoronaAircon=new IRKitEquipment(IRKitStudy,"raw","38");
        PioneerAudio=new IRKitEquipment(IRKitStudy,"raw","38");
        IoTWeatherKit=new IPAVC("192.168.0.25",12345);

        MaruzenLightAddFunc();
        CoronaAirconAddFunc();
        IoTWeatherKitAddFunc();
        PioneerAudioAddFunc();
    }
}
