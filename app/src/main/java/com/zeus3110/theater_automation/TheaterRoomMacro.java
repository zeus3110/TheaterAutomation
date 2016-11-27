package com.zeus3110.theater_automation;

import com.zeus3110.theater_automation.Equipment.AVCommand;
import com.zeus3110.theater_automation.Equipment.IPCommand;
import com.zeus3110.theater_automation.Equipment.IRCommand;
import com.zeus3110.theater_automation.Equipment.WaitCommand;

import java.util.ArrayList;

/**
 * Created by super on 2016/10/23.
 */

public class TheaterRoomMacro {
    static ArrayList<AVCommand> MacroActivityCoreVisualOn;
    static ArrayList<AVCommand> MacroActivityCoreAudioOn;
    static ArrayList<AVCommand> MacroActivityCoreVisualOff;
    static ArrayList<AVCommand> MacroActivityCoreAudioOff;
    static ArrayList<AVCommand> MacroActivitySourceVisualOff;

    static void MacroInit(){
        MacroActivityCoreVisualOn=new ArrayList<AVCommand>();
        MacroActivityCoreAudioOn=new ArrayList<AVCommand>();
        MacroActivityCoreVisualOff=new ArrayList<AVCommand>();
        MacroActivityCoreAudioOff=new ArrayList<AVCommand>();
        MacroActivitySourceVisualOff=new ArrayList<AVCommand>();

        // MacroActivityCoreVisualOn
        MacroActivityCoreVisualOn.add(new IPCommand(TheaterRoom.Projector,"POWER ON"));
        MacroActivityCoreVisualOn.add(new WaitCommand(200));

        // MacroActivityCoreAudioOn
        MacroActivityCoreAudioOn.add(new IPCommand(TheaterRoom.AVAmp,"PowerOn"));
        MacroActivityCoreAudioOn.add(new WaitCommand(200));
        MacroActivityCoreAudioOn.add(new IPCommand(TheaterRoom.Woofer,"Power on"));
        MacroActivityCoreAudioOn.add(new WaitCommand(200));

        // MacroActivityCoreVisualOff
        MacroActivityCoreVisualOff.add(new IPCommand(TheaterRoom.Projector,"POWER OFF"));
        MacroActivityCoreVisualOff.add(new WaitCommand(200));

        // MacroActivityCoreAudioOff
        MacroActivityCoreAudioOff.add(new IPCommand(TheaterRoom.AVAmp,"PowerOff"));
        MacroActivityCoreAudioOff.add(new WaitCommand(200));
        MacroActivityCoreAudioOff.add(new IPCommand(TheaterRoom.Woofer,"Power off"));
        MacroActivityCoreAudioOff.add(new WaitCommand(200));

        // MacroActivitySourceVisualOff
        MacroActivitySourceVisualOff.add(new IRCommand(TheaterRoom.DIGA1,"power_off"));
        MacroActivityCoreAudioOff.add(new WaitCommand(200));
        MacroActivitySourceVisualOff.add(new IRCommand(TheaterRoom.DIGA2,"power_off"));
        MacroActivityCoreAudioOff.add(new WaitCommand(200));
    }

}
