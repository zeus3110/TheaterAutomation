package com.zeus3110.theater_automation;

import android.content.Intent;
import android.content.pm.PackageManager;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.KeyEvent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.View.OnKeyListener;
import android.view.ViewGroup;
import android.widget.Button;

import com.zeus3110.theater_automation.Equipment.CommandAsyncTask;
import com.zeus3110.theater_automation.Equipment.IPCommand;
import com.zeus3110.theater_automation.Equipment.IRCommand;

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link FragmentDiga1#newInstance} factory method to
 * create an instance of this fragment.
 */
public class FragmentDiga1 extends Fragment implements OnClickListener {
    private static final String ARG_SECTION_NUMBER = "section_number";

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @return A new instance of fragment TextFragment.
     */
    // TODO: Rename and change types and number of parameters
    public static FragmentDiga1 newInstance(int sectionNumber) {
        FragmentDiga1 fragment = new FragmentDiga1();
        Bundle args = new Bundle();

        args.putInt(ARG_SECTION_NUMBER, sectionNumber);
        fragment.setArguments(args);
        return fragment;
    }

    public FragmentDiga1() {
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

        View v = inflater.inflate(R.layout.fragment_diga1, container, false);
        ((Button) v.findViewById(R.id.ButtonDIGA1Key1)).setOnClickListener((OnClickListener) this);
        ((Button) v.findViewById(R.id.ButtonDIGA1Key2)).setOnClickListener((OnClickListener) this);
        ((Button) v.findViewById(R.id.ButtonDIGA1Key3)).setOnClickListener((OnClickListener) this);
        ((Button) v.findViewById(R.id.ButtonDIGA1Key4)).setOnClickListener((OnClickListener) this);
        ((Button) v.findViewById(R.id.ButtonDIGA1Key5)).setOnClickListener((OnClickListener) this);
        ((Button) v.findViewById(R.id.ButtonDIGA1Key6)).setOnClickListener((OnClickListener) this);
        ((Button) v.findViewById(R.id.ButtonDIGA1Key7)).setOnClickListener((OnClickListener) this);
        ((Button) v.findViewById(R.id.ButtonDIGA1Key8)).setOnClickListener((OnClickListener) this);
        ((Button) v.findViewById(R.id.ButtonDIGA1Key9)).setOnClickListener((OnClickListener) this);
        ((Button) v.findViewById(R.id.ButtonDIGA1Key10)).setOnClickListener((OnClickListener) this);
        ((Button) v.findViewById(R.id.ButtonDIGA1Key11)).setOnClickListener((OnClickListener) this);
        ((Button) v.findViewById(R.id.ButtonDIGA1Key12)).setOnClickListener((OnClickListener) this);

        ((Button) v.findViewById(R.id.ButtonDIGA1BroadcastTD)).setOnClickListener((OnClickListener) this);
        ((Button) v.findViewById(R.id.ButtonDIGA1BroadcastBS)).setOnClickListener((OnClickListener) this);
        ((Button) v.findViewById(R.id.ButtonDIGA1BroadcastCS)).setOnClickListener((OnClickListener) this);
        ((Button) v.findViewById(R.id.ButtonDIGA1EPG)).setOnClickListener((OnClickListener) this);

        ((Button) v.findViewById(R.id.ButtonDIGA1Blue)).setOnClickListener((OnClickListener) this);
        ((Button) v.findViewById(R.id.ButtonDIGA1Red)).setOnClickListener((OnClickListener) this);
        ((Button) v.findViewById(R.id.ButtonDIGA1Green)).setOnClickListener((OnClickListener) this);
        ((Button) v.findViewById(R.id.ButtonDIGA1Yellow)).setOnClickListener((OnClickListener) this);

        ((Button) v.findViewById(R.id.ButtonDIGA1RecList)).setOnClickListener((OnClickListener) this);
        ((Button) v.findViewById(R.id.ButtonDIGA1ReserveList)).setOnClickListener((OnClickListener) this);
        ((Button) v.findViewById(R.id.ButtonDIGA1Chapter)).setOnClickListener((OnClickListener) this);
        ((Button) v.findViewById(R.id.ButtonDIGA1Eject)).setOnClickListener((OnClickListener) this);
        ((Button) v.findViewById(R.id.ButtonDIGA1HDD)).setOnClickListener((OnClickListener) this);
        ((Button) v.findViewById(R.id.ButtonDIGA1BD)).setOnClickListener((OnClickListener) this);
        ((Button) v.findViewById(R.id.ButtonDIGA1Del)).setOnClickListener((OnClickListener) this);
        ((Button) v.findViewById(R.id.ButtonDIGA1Info)).setOnClickListener((OnClickListener) this);
        ((Button) v.findViewById(R.id.ButtonDIGA1PlaySettings)).setOnClickListener((OnClickListener) this);

        ((Button) v.findViewById(R.id.ButtonDIGA1Rew)).setOnClickListener((OnClickListener) this);
        ((Button) v.findViewById(R.id.ButtonDIGA1Play)).setOnClickListener((OnClickListener) this);
        ((Button) v.findViewById(R.id.ButtonDIGA1FF)).setOnClickListener((OnClickListener) this);
        ((Button) v.findViewById(R.id.ButtonDIGA1PrevChapter)).setOnClickListener((OnClickListener) this);
        ((Button) v.findViewById(R.id.ButtonDIGA1NexutChapter)).setOnClickListener((OnClickListener) this);
        ((Button) v.findViewById(R.id.ButtonDIGA1Pause)).setOnClickListener((OnClickListener) this);
        ((Button) v.findViewById(R.id.ButtonDIGA1Stop)).setOnClickListener((OnClickListener) this);
        ((Button) v.findViewById(R.id.ButtonDIGA1SkipM15)).setOnClickListener((OnClickListener) this);
        ((Button) v.findViewById(R.id.ButtonDIGA1Skip30)).setOnClickListener((OnClickListener) this);
        ((Button) v.findViewById(R.id.ButtonDIGA1Power)).setOnClickListener((OnClickListener) this);
        ((Button) v.findViewById(R.id.ButtonDIGA1App)).setOnClickListener((OnClickListener) this);

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
                case R.id.ButtonDIGA1Key1:
                    new CommandAsyncTask(getActivity(), new IRCommand(TheaterRoom.DIGA1, "1")).execute();
                    break;
                case R.id.ButtonDIGA1Key2:
                    new CommandAsyncTask(getActivity(), new IRCommand(TheaterRoom.DIGA1, "2")).execute();
                    break;
                case R.id.ButtonDIGA1Key3:
                    new CommandAsyncTask(getActivity(), new IRCommand(TheaterRoom.DIGA1, "3")).execute();
                    break;
                case R.id.ButtonDIGA1Key4:
                    new CommandAsyncTask(getActivity(), new IRCommand(TheaterRoom.DIGA1, "4")).execute();
                    break;
                case R.id.ButtonDIGA1Key5:
                    new CommandAsyncTask(getActivity(), new IRCommand(TheaterRoom.DIGA1, "5")).execute();
                    break;
                case R.id.ButtonDIGA1Key6:
                    new CommandAsyncTask(getActivity(), new IRCommand(TheaterRoom.DIGA1, "6")).execute();
                    break;
                case R.id.ButtonDIGA1Key7:
                    new CommandAsyncTask(getActivity(), new IRCommand(TheaterRoom.DIGA1, "7")).execute();
                    break;
                case R.id.ButtonDIGA1Key8:
                    new CommandAsyncTask(getActivity(), new IRCommand(TheaterRoom.DIGA1, "8")).execute();
                    break;
                case R.id.ButtonDIGA1Key9:
                    new CommandAsyncTask(getActivity(), new IRCommand(TheaterRoom.DIGA1, "9")).execute();
                    break;
                case R.id.ButtonDIGA1Key10:
                    new CommandAsyncTask(getActivity(), new IRCommand(TheaterRoom.DIGA1, "10")).execute();
                    break;
                case R.id.ButtonDIGA1Key11:
                    new CommandAsyncTask(getActivity(), new IRCommand(TheaterRoom.DIGA1, "11")).execute();
                    break;
                case R.id.ButtonDIGA1Key12:
                    new CommandAsyncTask(getActivity(), new IRCommand(TheaterRoom.DIGA1, "12")).execute();
                    break;
                case R.id.ButtonDIGA1BroadcastTD:
                    new CommandAsyncTask(getActivity(), new IRCommand(TheaterRoom.DIGA1, "Digital")).execute();
                    break;
                case R.id.ButtonDIGA1BroadcastBS:
                    new CommandAsyncTask(getActivity(), new IRCommand(TheaterRoom.DIGA1, "BS")).execute();
                    break;
                case R.id.ButtonDIGA1BroadcastCS:
                    new CommandAsyncTask(getActivity(), new IRCommand(TheaterRoom.DIGA1, "CS")).execute();
                    break;
                case R.id.ButtonDIGA1EPG:
                    new CommandAsyncTask(getActivity(), new IRCommand(TheaterRoom.DIGA1, "epg")).execute();
                    break;
                case R.id.ButtonDIGA1Blue:
                    new CommandAsyncTask(getActivity(), new IRCommand(TheaterRoom.DIGA1, "blue")).execute();
                    break;
                case R.id.ButtonDIGA1Red:
                    new CommandAsyncTask(getActivity(), new IRCommand(TheaterRoom.DIGA1, "red")).execute();
                    break;
                case R.id.ButtonDIGA1Green:
                    new CommandAsyncTask(getActivity(), new IRCommand(TheaterRoom.DIGA1, "green")).execute();
                    break;
                case R.id.ButtonDIGA1Yellow:
                    new CommandAsyncTask(getActivity(), new IRCommand(TheaterRoom.DIGA1, "yellow")).execute();
                    break;
                case R.id.ButtonDIGA1RecList:
                    new CommandAsyncTask(getActivity(), new IRCommand(TheaterRoom.DIGA1, "play_navi")).execute();
                    break;
                case R.id.ButtonDIGA1ReserveList:
                    new CommandAsyncTask(getActivity(), new IRCommand(TheaterRoom.DIGA1, "rec_list")).execute();
                    break;
                case R.id.ButtonDIGA1Chapter:
                    new CommandAsyncTask(getActivity(), new IRCommand(TheaterRoom.DIGA1, "chapter")).execute();
                    break;
                case R.id.ButtonDIGA1Eject:
                    new CommandAsyncTask(getActivity(), new IRCommand(TheaterRoom.DIGA1, "eject")).execute();
                    break;
                case R.id.ButtonDIGA1HDD:
                    new CommandAsyncTask(getActivity(), new IRCommand(TheaterRoom.DIGA1, "HDD")).execute();
                    break;
                case R.id.ButtonDIGA1BD:
                    new CommandAsyncTask(getActivity(), new IRCommand(TheaterRoom.DIGA1, "BD")).execute();
                    break;
                case R.id.ButtonDIGA1Del:
                    new CommandAsyncTask(getActivity(), new IRCommand(TheaterRoom.DIGA1, "del")).execute();
                    break;
                case R.id.ButtonDIGA1Info:
                    new CommandAsyncTask(getActivity(), new IRCommand(TheaterRoom.DIGA1, "display")).execute();
                    break;
                case R.id.ButtonDIGA1PlaySettings:
                    new CommandAsyncTask(getActivity(), new IRCommand(TheaterRoom.DIGA1, "play_setting")).execute();
                    break;
                case R.id.ButtonDIGA1Rew:
                    new CommandAsyncTask(getActivity(), new IRCommand(TheaterRoom.DIGA1, "rew")).execute();
                    break;
                case R.id.ButtonDIGA1Play:
                    new CommandAsyncTask(getActivity(), new IRCommand(TheaterRoom.DIGA1, "play")).execute();
                    break;
                case R.id.ButtonDIGA1FF:
                    new CommandAsyncTask(getActivity(), new IRCommand(TheaterRoom.DIGA1, "ff")).execute();
                    break;
                case R.id.ButtonDIGA1PrevChapter:
                    new CommandAsyncTask(getActivity(), new IRCommand(TheaterRoom.DIGA1, "chapter-")).execute();
                    break;
                case R.id.ButtonDIGA1NexutChapter:
                    new CommandAsyncTask(getActivity(), new IRCommand(TheaterRoom.DIGA1, "chapter+")).execute();
                    break;
                case R.id.ButtonDIGA1Pause:
                    new CommandAsyncTask(getActivity(), new IRCommand(TheaterRoom.DIGA1, "pause")).execute();
                    break;
                case R.id.ButtonDIGA1Stop:
                    new CommandAsyncTask(getActivity(), new IRCommand(TheaterRoom.DIGA1, "stop")).execute();
                    break;
                case R.id.ButtonDIGA1SkipM15:
                    new CommandAsyncTask(getActivity(), new IRCommand(TheaterRoom.DIGA1, "10sback-")).execute();
                    break;
                case R.id.ButtonDIGA1Skip30:
                    new CommandAsyncTask(getActivity(), new IRCommand(TheaterRoom.DIGA1, "30s_skip+")).execute();
                    break;
                case R.id.ButtonDIGA1Power:
                    new CommandAsyncTask(getActivity(), new IRCommand(TheaterRoom.DIGA1, "power")).execute();
                    break;
                case R.id.ButtonDIGA1App:
                    Intent intent = new Intent();
                    intent.setClassName("com.panasonic.avc.diga.digaremote", "com.panasonic.avc.diga.digaremote.MainActivity");
                    startActivity(intent);
                    break;
                default:
                    break;
            }
        }catch (Exception e){
            e.printStackTrace();
        }
    }
}