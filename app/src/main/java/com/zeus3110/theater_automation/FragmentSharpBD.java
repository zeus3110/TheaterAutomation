package com.zeus3110.theater_automation;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.KeyEvent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.View.OnKeyListener;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

import com.zeus3110.theater_automation.Equipment.CommandAsyncTask;
import com.zeus3110.theater_automation.Equipment.IPCommand;
import com.zeus3110.theater_automation.Equipment.IRCommand;

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link FragmentSharpBD#newInstance} factory method to
 * create an instance of this fragment.
 */
public class FragmentSharpBD extends Fragment implements OnClickListener {
    private static final String ARG_SECTION_NUMBER = "section_number";

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @return A new instance of fragment TextFragment.
     */
    // TODO: Rename and change types and number of parameters
    public static FragmentSharpBD newInstance(int sectionNumber) {
        FragmentSharpBD fragment = new FragmentSharpBD();
        Bundle args = new Bundle();

        args.putInt(ARG_SECTION_NUMBER, sectionNumber);
        fragment.setArguments(args);
        return fragment;
    }

    public FragmentSharpBD() {
        // Required empty public constructor
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        try{
            Class.forName("android.os.AsyncTask");
        }catch(ClassNotFoundException e){}
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment

        View v = inflater.inflate(R.layout.fragment_sharpbd, container, false);
        ((Button) v.findViewById(R.id.ButtonSharpBDKey1)).setOnClickListener((OnClickListener) this);
        ((Button) v.findViewById(R.id.ButtonSharpBDKey2)).setOnClickListener((OnClickListener) this);
        ((Button) v.findViewById(R.id.ButtonSharpBDKey3)).setOnClickListener((OnClickListener) this);
        ((Button) v.findViewById(R.id.ButtonSharpBDKey4)).setOnClickListener((OnClickListener) this);
        ((Button) v.findViewById(R.id.ButtonSharpBDKey5)).setOnClickListener((OnClickListener) this);
        ((Button) v.findViewById(R.id.ButtonSharpBDKey6)).setOnClickListener((OnClickListener) this);
        ((Button) v.findViewById(R.id.ButtonSharpBDKey7)).setOnClickListener((OnClickListener) this);
        ((Button) v.findViewById(R.id.ButtonSharpBDKey8)).setOnClickListener((OnClickListener) this);
        ((Button) v.findViewById(R.id.ButtonSharpBDKey9)).setOnClickListener((OnClickListener) this);
        ((Button) v.findViewById(R.id.ButtonSharpBDKey10)).setOnClickListener((OnClickListener) this);
        ((Button) v.findViewById(R.id.ButtonSharpBDKey11)).setOnClickListener((OnClickListener) this);
        ((Button) v.findViewById(R.id.ButtonSharpBDKey12)).setOnClickListener((OnClickListener) this);

        ((Button) v.findViewById(R.id.ButtonSharpBDBroadcastTD)).setOnClickListener((OnClickListener) this);
        ((Button) v.findViewById(R.id.ButtonSharpBDBroadcastBS)).setOnClickListener((OnClickListener) this);
        ((Button) v.findViewById(R.id.ButtonSharpBDBroadcastCS)).setOnClickListener((OnClickListener) this);
        ((Button) v.findViewById(R.id.ButtonSharpBDBroadcastSkyPer)).setOnClickListener((OnClickListener) this);
        ((Button) v.findViewById(R.id.ButtonSharpBDEPG)).setOnClickListener((OnClickListener) this);

        ((Button) v.findViewById(R.id.ButtonSharpBDBlue)).setOnClickListener((OnClickListener) this);
        ((Button) v.findViewById(R.id.ButtonSharpBDRed)).setOnClickListener((OnClickListener) this);
        ((Button) v.findViewById(R.id.ButtonSharpBDGreen)).setOnClickListener((OnClickListener) this);
        ((Button) v.findViewById(R.id.ButtonSharpBDYellow)).setOnClickListener((OnClickListener) this);

        ((Button) v.findViewById(R.id.ButtonSharpBDRecList)).setOnClickListener((OnClickListener) this);
        ((Button) v.findViewById(R.id.ButtonSharpBDReserveList)).setOnClickListener((OnClickListener) this);
        ((Button) v.findViewById(R.id.ButtonSharpBDChapter)).setOnClickListener((OnClickListener) this);
        ((Button) v.findViewById(R.id.ButtonSharpBDEject)).setOnClickListener((OnClickListener) this);
        ((Button) v.findViewById(R.id.ButtonSharpBDDrive)).setOnClickListener((OnClickListener) this);
        ((Button) v.findViewById(R.id.ButtonSharpBDDel)).setOnClickListener((OnClickListener) this);
        ((Button) v.findViewById(R.id.ButtonSharpBDInfo)).setOnClickListener((OnClickListener) this);

        ((Button) v.findViewById(R.id.ButtonSharpBDRew)).setOnClickListener((OnClickListener) this);
        ((Button) v.findViewById(R.id.ButtonSharpBDPlay)).setOnClickListener((OnClickListener) this);
        ((Button) v.findViewById(R.id.ButtonSharpBDFF)).setOnClickListener((OnClickListener) this);
        ((Button) v.findViewById(R.id.ButtonSharpBDPrevChapter)).setOnClickListener((OnClickListener) this);
        ((Button) v.findViewById(R.id.ButtonSharpBDNexutChapter)).setOnClickListener((OnClickListener) this);
        ((Button) v.findViewById(R.id.ButtonSharpBDPause)).setOnClickListener((OnClickListener) this);
        ((Button) v.findViewById(R.id.ButtonSharpBDStop)).setOnClickListener((OnClickListener) this);
        ((Button) v.findViewById(R.id.ButtonSharpBDSkipM10)).setOnClickListener((OnClickListener) this);
        ((Button) v.findViewById(R.id.ButtonSharpBDSkip15)).setOnClickListener((OnClickListener) this);
        ((Button) v.findViewById(R.id.ButtonSharpBDPower)).setOnClickListener((OnClickListener) this);

        v.setOnKeyListener(new OnKeyListener() {
            @Override
            public boolean onKey(View v, int keyCode, KeyEvent event) {


                switch (keyCode) {
                    case KeyEvent.KEYCODE_VOLUME_UP:
                        new CommandAsyncTask(getActivity(), new IPCommand(TheaterRoom.AVAmp,"Vol+")).execute();
                        return true;
                    case KeyEvent.KEYCODE_VOLUME_DOWN:
                        new CommandAsyncTask(getActivity(), new IPCommand(TheaterRoom.AVAmp,"Vol-")).execute();
                        return true;
                    case KeyEvent.KEYCODE_DPAD_UP:
                        new CommandAsyncTask(getActivity(), new IRCommand(TheaterRoom.SharpBD, "cursor_up")).execute();
                        return true;
                    case KeyEvent.KEYCODE_DPAD_DOWN:
                        new CommandAsyncTask(getActivity(), new IRCommand(TheaterRoom.SharpBD, "cursor_down")).execute();
                        return true;
                    case KeyEvent.KEYCODE_DPAD_LEFT:
                        new CommandAsyncTask(getActivity(), new IRCommand(TheaterRoom.SharpBD, "cursor_left")).execute();
                        return true;
                    case KeyEvent.KEYCODE_DPAD_RIGHT:
                        new CommandAsyncTask(getActivity(), new IRCommand(TheaterRoom.SharpBD, "cursor_right")).execute();
                        return true;
                    case KeyEvent.KEYCODE_BUTTON_A:
                        new CommandAsyncTask(getActivity(), new IRCommand(TheaterRoom.SharpBD, "enter")).execute();
                        return true;
                    case KeyEvent.KEYCODE_BUTTON_B:
                        new CommandAsyncTask(getActivity(), new IRCommand(TheaterRoom.SharpBD, "back")).execute();
                        return true;
                    case KeyEvent.KEYCODE_BUTTON_X:
                        return true;
                    case KeyEvent.KEYCODE_BUTTON_Y:
                        return true;
                    case KeyEvent.KEYCODE_BUTTON_L1:
                        return true;
                    case KeyEvent.KEYCODE_BUTTON_L2:
                        return true;
                    case KeyEvent.KEYCODE_BUTTON_R1:
                        return true;
                    case KeyEvent.KEYCODE_BUTTON_R2:
                        return true;
                    case KeyEvent.KEYCODE_BUTTON_SELECT:
                        new CommandAsyncTask(getActivity(), new IRCommand(TheaterRoom.SharpBD, "option")).execute();
                        return true;
                    case KeyEvent.KEYCODE_BUTTON_START:
                        new CommandAsyncTask(getActivity(), new IRCommand(TheaterRoom.SharpBD, "top_menu")).execute();
                        return true;
                    default:
                        return false;
                }
            }
        });

        // View#setFocusableInTouchMode
        v.setFocusableInTouchMode(true);
        v.requestFocus();

        return v;
    }

    // �{�^���C�x���g
    public void onClick(View v) {
        try{
            switch (v.getId()) {
                // 10Key
                case R.id.ButtonSharpBDKey1:
                    new CommandAsyncTask(getActivity(), new IRCommand(TheaterRoom.SharpBD, "1")).execute();
                    break;
                case R.id.ButtonSharpBDKey2:
                    new CommandAsyncTask(getActivity(), new IRCommand(TheaterRoom.SharpBD, "2")).execute();
                    break;
                case R.id.ButtonSharpBDKey3:
                    new CommandAsyncTask(getActivity(), new IRCommand(TheaterRoom.SharpBD, "3")).execute();
                    break;
                case R.id.ButtonSharpBDKey4:
                    new CommandAsyncTask(getActivity(), new IRCommand(TheaterRoom.SharpBD, "4")).execute();
                    break;
                case R.id.ButtonSharpBDKey5:
                    new CommandAsyncTask(getActivity(), new IRCommand(TheaterRoom.SharpBD, "5")).execute();
                    break;
                case R.id.ButtonSharpBDKey6:
                    new CommandAsyncTask(getActivity(), new IRCommand(TheaterRoom.SharpBD, "6")).execute();
                    break;
                case R.id.ButtonSharpBDKey7:
                    new CommandAsyncTask(getActivity(), new IRCommand(TheaterRoom.SharpBD, "7")).execute();
                    break;
                case R.id.ButtonSharpBDKey8:
                    new CommandAsyncTask(getActivity(), new IRCommand(TheaterRoom.SharpBD, "8")).execute();
                    break;
                case R.id.ButtonSharpBDKey9:
                    new CommandAsyncTask(getActivity(), new IRCommand(TheaterRoom.SharpBD, "9")).execute();
                    break;
                case R.id.ButtonSharpBDKey10:
                    new CommandAsyncTask(getActivity(), new IRCommand(TheaterRoom.SharpBD, "10")).execute();
                    break;
                case R.id.ButtonSharpBDKey11:
                    new CommandAsyncTask(getActivity(), new IRCommand(TheaterRoom.SharpBD, "11")).execute();
                    break;
                case R.id.ButtonSharpBDKey12:
                    new CommandAsyncTask(getActivity(), new IRCommand(TheaterRoom.SharpBD, "12")).execute();
                    break;
                case R.id.ButtonSharpBDBroadcastTD:
                    new CommandAsyncTask(getActivity(), new IRCommand(TheaterRoom.SharpBD, "terrestrial")).execute();
                    break;
                case R.id.ButtonSharpBDBroadcastBS:
                    new CommandAsyncTask(getActivity(), new IRCommand(TheaterRoom.SharpBD, "BS")).execute();
                    break;
                case R.id.ButtonSharpBDBroadcastCS:
                    new CommandAsyncTask(getActivity(), new IRCommand(TheaterRoom.SharpBD, "CS")).execute();
                    break;
                case R.id.ButtonSharpBDBroadcastSkyPer:
                    new CommandAsyncTask(getActivity(), new IRCommand(TheaterRoom.SharpBD, "SkyHD")).execute();
                    break;
                case R.id.ButtonSharpBDEPG:
                    new CommandAsyncTask(getActivity(), new IRCommand(TheaterRoom.SharpBD, "epg")).execute();
                    break;
                case R.id.ButtonSharpBDBlue:
                    new CommandAsyncTask(getActivity(), new IRCommand(TheaterRoom.SharpBD, "blue")).execute();
                    break;
                case R.id.ButtonSharpBDRed:
                    new CommandAsyncTask(getActivity(), new IRCommand(TheaterRoom.SharpBD, "red")).execute();
                    break;
                case R.id.ButtonSharpBDGreen:
                    new CommandAsyncTask(getActivity(), new IRCommand(TheaterRoom.SharpBD, "green")).execute();
                    break;
                case R.id.ButtonSharpBDYellow:
                    new CommandAsyncTask(getActivity(), new IRCommand(TheaterRoom.SharpBD, "yellow")).execute();
                    break;
                case R.id.ButtonSharpBDRecList:
                    new CommandAsyncTask(getActivity(), new IRCommand(TheaterRoom.SharpBD, "home")).execute();
                    break;
                case R.id.ButtonSharpBDReserveList:
                    new CommandAsyncTask(getActivity(), new IRCommand(TheaterRoom.SharpBD, "reserve")).execute();
                    break;
                case R.id.ButtonSharpBDChapter:
                    new CommandAsyncTask(getActivity(), new IRCommand(TheaterRoom.SharpBD, "chapter_write")).execute();
                    break;
                case R.id.ButtonSharpBDEject:
                    new CommandAsyncTask(getActivity(), new IRCommand(TheaterRoom.SharpBD, "eject")).execute();
                    break;
                case R.id.ButtonSharpBDDrive:
                    new CommandAsyncTask(getActivity(), new IRCommand(TheaterRoom.SharpBD, "HDD/DISC")).execute();
                    break;
                case R.id.ButtonSharpBDDel:
                    new CommandAsyncTask(getActivity(), new IRCommand(TheaterRoom.SharpBD, "end")).execute();
                    break;
                case R.id.ButtonSharpBDInfo:
                    new CommandAsyncTask(getActivity(), new IRCommand(TheaterRoom.SharpBD, "display")).execute();
                    break;
                case R.id.ButtonSharpBDRew:
                    new CommandAsyncTask(getActivity(), new IRCommand(TheaterRoom.SharpBD, "rew")).execute();
                    break;
                case R.id.ButtonSharpBDPlay:
                    new CommandAsyncTask(getActivity(), new IRCommand(TheaterRoom.SharpBD, "play")).execute();
                    break;
                case R.id.ButtonSharpBDFF:
                    new CommandAsyncTask(getActivity(), new IRCommand(TheaterRoom.SharpBD, "ff")).execute();
                    break;
                case R.id.ButtonSharpBDPrevChapter:
                    new CommandAsyncTask(getActivity(), new IRCommand(TheaterRoom.SharpBD, "chapter-")).execute();
                    break;
                case R.id.ButtonSharpBDNexutChapter:
                    new CommandAsyncTask(getActivity(), new IRCommand(TheaterRoom.SharpBD, "chapter+")).execute();
                    break;
                case R.id.ButtonSharpBDPause:
                    new CommandAsyncTask(getActivity(), new IRCommand(TheaterRoom.SharpBD, "pause")).execute();
                    break;
                case R.id.ButtonSharpBDStop:
                    new CommandAsyncTask(getActivity(), new IRCommand(TheaterRoom.SharpBD, "stop")).execute();
                    break;
                case R.id.ButtonSharpBDSkipM10:
                    new CommandAsyncTask(getActivity(), new IRCommand(TheaterRoom.SharpBD, "flush-")).execute();
                    break;
                case R.id.ButtonSharpBDSkip15:
                    new CommandAsyncTask(getActivity(), new IRCommand(TheaterRoom.SharpBD, "flush+")).execute();
                    break;
                case R.id.ButtonSharpBDPower:
                    new CommandAsyncTask(getActivity(), new IRCommand(TheaterRoom.SharpBD, "power")).execute();
                    break;
                default:
                    break;
            }
        }catch (Exception e){
            e.printStackTrace();
        }
    }
}