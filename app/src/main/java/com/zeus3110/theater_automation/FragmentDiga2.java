package com.zeus3110.theater_automation;

import android.content.Intent;
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
 * Use the {@link FragmentDiga2#newInstance} factory method to
 * create an instance of this fragment.
 */
public class FragmentDiga2 extends Fragment implements OnClickListener {
    private static final String ARG_SECTION_NUMBER = "section_number";

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @return A new instance of fragment TextFragment.
     */
    // TODO: Rename and change types and number of parameters
    public static FragmentDiga2 newInstance(int sectionNumber) {
        FragmentDiga2 fragment = new FragmentDiga2();
        Bundle args = new Bundle();

        args.putInt(ARG_SECTION_NUMBER, sectionNumber);
        fragment.setArguments(args);
        return fragment;
    }

    public FragmentDiga2() {
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

        View v = inflater.inflate(R.layout.fragment_diga2, container, false);
        ((Button) v.findViewById(R.id.ButtonDIGA2Key1)).setOnClickListener((OnClickListener) this);
        ((Button) v.findViewById(R.id.ButtonDIGA2Key2)).setOnClickListener((OnClickListener) this);
        ((Button) v.findViewById(R.id.ButtonDIGA2Key3)).setOnClickListener((OnClickListener) this);
        ((Button) v.findViewById(R.id.ButtonDIGA2Key4)).setOnClickListener((OnClickListener) this);
        ((Button) v.findViewById(R.id.ButtonDIGA2Key5)).setOnClickListener((OnClickListener) this);
        ((Button) v.findViewById(R.id.ButtonDIGA2Key6)).setOnClickListener((OnClickListener) this);
        ((Button) v.findViewById(R.id.ButtonDIGA2Key7)).setOnClickListener((OnClickListener) this);
        ((Button) v.findViewById(R.id.ButtonDIGA2Key8)).setOnClickListener((OnClickListener) this);
        ((Button) v.findViewById(R.id.ButtonDIGA2Key9)).setOnClickListener((OnClickListener) this);
        ((Button) v.findViewById(R.id.ButtonDIGA2Key10)).setOnClickListener((OnClickListener) this);
        ((Button) v.findViewById(R.id.ButtonDIGA2Key11)).setOnClickListener((OnClickListener) this);
        ((Button) v.findViewById(R.id.ButtonDIGA2Key12)).setOnClickListener((OnClickListener) this);

        ((Button) v.findViewById(R.id.ButtonDIGA2BroadcastTD)).setOnClickListener((OnClickListener) this);
        ((Button) v.findViewById(R.id.ButtonDIGA2BroadcastBS)).setOnClickListener((OnClickListener) this);
        ((Button) v.findViewById(R.id.ButtonDIGA2BroadcastCS)).setOnClickListener((OnClickListener) this);
        ((Button) v.findViewById(R.id.ButtonDIGA2EPG)).setOnClickListener((OnClickListener) this);

        ((Button) v.findViewById(R.id.ButtonDIGA2Blue)).setOnClickListener((OnClickListener) this);
        ((Button) v.findViewById(R.id.ButtonDIGA2Red)).setOnClickListener((OnClickListener) this);
        ((Button) v.findViewById(R.id.ButtonDIGA2Green)).setOnClickListener((OnClickListener) this);
        ((Button) v.findViewById(R.id.ButtonDIGA2Yellow)).setOnClickListener((OnClickListener) this);

        ((Button) v.findViewById(R.id.ButtonDIGA2RecList)).setOnClickListener((OnClickListener) this);
        ((Button) v.findViewById(R.id.ButtonDIGA2ReserveList)).setOnClickListener((OnClickListener) this);
        ((Button) v.findViewById(R.id.ButtonDIGA2Chapter)).setOnClickListener((OnClickListener) this);
        ((Button) v.findViewById(R.id.ButtonDIGA2Eject)).setOnClickListener((OnClickListener) this);
        ((Button) v.findViewById(R.id.ButtonDIGA2HDD)).setOnClickListener((OnClickListener) this);
        ((Button) v.findViewById(R.id.ButtonDIGA2BD)).setOnClickListener((OnClickListener) this);
        ((Button) v.findViewById(R.id.ButtonDIGA2Del)).setOnClickListener((OnClickListener) this);
        ((Button) v.findViewById(R.id.ButtonDIGA2Info)).setOnClickListener((OnClickListener) this);
        ((Button) v.findViewById(R.id.ButtonDIGA2PlaySettings)).setOnClickListener((OnClickListener) this);

        ((Button) v.findViewById(R.id.ButtonDIGA2Rew)).setOnClickListener((OnClickListener) this);
        ((Button) v.findViewById(R.id.ButtonDIGA2Play)).setOnClickListener((OnClickListener) this);
        ((Button) v.findViewById(R.id.ButtonDIGA2FF)).setOnClickListener((OnClickListener) this);
        ((Button) v.findViewById(R.id.ButtonDIGA2PrevChapter)).setOnClickListener((OnClickListener) this);
        ((Button) v.findViewById(R.id.ButtonDIGA2NexutChapter)).setOnClickListener((OnClickListener) this);
        ((Button) v.findViewById(R.id.ButtonDIGA2Pause)).setOnClickListener((OnClickListener) this);
        ((Button) v.findViewById(R.id.ButtonDIGA2Stop)).setOnClickListener((OnClickListener) this);
        ((Button) v.findViewById(R.id.ButtonDIGA2SkipM15)).setOnClickListener((OnClickListener) this);
        ((Button) v.findViewById(R.id.ButtonDIGA2Skip30)).setOnClickListener((OnClickListener) this);
        ((Button) v.findViewById(R.id.ButtonDIGA2Power)).setOnClickListener((OnClickListener) this);
        ((Button) v.findViewById(R.id.ButtonDIGA2App)).setOnClickListener((OnClickListener) this);

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
                case R.id.ButtonDIGA2Key1:
                    new CommandAsyncTask(getActivity(), new IRCommand(TheaterRoom.DIGA2, "1")).execute();
                    break;
                case R.id.ButtonDIGA2Key2:
                    new CommandAsyncTask(getActivity(), new IRCommand(TheaterRoom.DIGA2, "2")).execute();
                    break;
                case R.id.ButtonDIGA2Key3:
                    new CommandAsyncTask(getActivity(), new IRCommand(TheaterRoom.DIGA2, "3")).execute();
                    break;
                case R.id.ButtonDIGA2Key4:
                    new CommandAsyncTask(getActivity(), new IRCommand(TheaterRoom.DIGA2, "4")).execute();
                    break;
                case R.id.ButtonDIGA2Key5:
                    new CommandAsyncTask(getActivity(), new IRCommand(TheaterRoom.DIGA2, "5")).execute();
                    break;
                case R.id.ButtonDIGA2Key6:
                    new CommandAsyncTask(getActivity(), new IRCommand(TheaterRoom.DIGA2, "6")).execute();
                    break;
                case R.id.ButtonDIGA2Key7:
                    new CommandAsyncTask(getActivity(), new IRCommand(TheaterRoom.DIGA2, "7")).execute();
                    break;
                case R.id.ButtonDIGA2Key8:
                    new CommandAsyncTask(getActivity(), new IRCommand(TheaterRoom.DIGA2, "8")).execute();
                    break;
                case R.id.ButtonDIGA2Key9:
                    new CommandAsyncTask(getActivity(), new IRCommand(TheaterRoom.DIGA2, "9")).execute();
                    break;
                case R.id.ButtonDIGA2Key10:
                    new CommandAsyncTask(getActivity(), new IRCommand(TheaterRoom.DIGA2, "10")).execute();
                    break;
                case R.id.ButtonDIGA2Key11:
                    new CommandAsyncTask(getActivity(), new IRCommand(TheaterRoom.DIGA2, "11")).execute();
                    break;
                case R.id.ButtonDIGA2Key12:
                    new CommandAsyncTask(getActivity(), new IRCommand(TheaterRoom.DIGA2, "12")).execute();
                    break;
                case R.id.ButtonDIGA2BroadcastTD:
                    new CommandAsyncTask(getActivity(), new IRCommand(TheaterRoom.DIGA2, "Digital")).execute();
                    break;
                case R.id.ButtonDIGA2BroadcastBS:
                    new CommandAsyncTask(getActivity(), new IRCommand(TheaterRoom.DIGA2, "BS")).execute();
                    break;
                case R.id.ButtonDIGA2BroadcastCS:
                    new CommandAsyncTask(getActivity(), new IRCommand(TheaterRoom.DIGA2, "CS")).execute();
                    break;
                case R.id.ButtonDIGA2EPG:
                    new CommandAsyncTask(getActivity(), new IRCommand(TheaterRoom.DIGA2, "epg")).execute();
                    break;
                case R.id.ButtonDIGA2Blue:
                    new CommandAsyncTask(getActivity(), new IRCommand(TheaterRoom.DIGA2, "blue")).execute();
                    break;
                case R.id.ButtonDIGA2Red:
                    new CommandAsyncTask(getActivity(), new IRCommand(TheaterRoom.DIGA2, "red")).execute();
                    break;
                case R.id.ButtonDIGA2Green:
                    new CommandAsyncTask(getActivity(), new IRCommand(TheaterRoom.DIGA2, "green")).execute();
                    break;
                case R.id.ButtonDIGA2Yellow:
                    new CommandAsyncTask(getActivity(), new IRCommand(TheaterRoom.DIGA2, "yellow")).execute();
                    break;
                case R.id.ButtonDIGA2RecList:
                    new CommandAsyncTask(getActivity(), new IRCommand(TheaterRoom.DIGA2, "play_navi")).execute();
                    break;
                case R.id.ButtonDIGA2ReserveList:
                    new CommandAsyncTask(getActivity(), new IRCommand(TheaterRoom.DIGA2, "rec_list")).execute();
                    break;
                case R.id.ButtonDIGA2Chapter:
                    new CommandAsyncTask(getActivity(), new IRCommand(TheaterRoom.DIGA2, "chapter")).execute();
                    break;
                case R.id.ButtonDIGA2Eject:
                    new CommandAsyncTask(getActivity(), new IRCommand(TheaterRoom.DIGA2, "eject")).execute();
                    break;
                case R.id.ButtonDIGA2HDD:
                    new CommandAsyncTask(getActivity(), new IRCommand(TheaterRoom.DIGA2, "HDD")).execute();
                    break;
                case R.id.ButtonDIGA2BD:
                    new CommandAsyncTask(getActivity(), new IRCommand(TheaterRoom.DIGA2, "BD")).execute();
                    break;
                case R.id.ButtonDIGA2Del:
                    new CommandAsyncTask(getActivity(), new IRCommand(TheaterRoom.DIGA2, "del")).execute();
                    break;
                case R.id.ButtonDIGA2Info:
                    new CommandAsyncTask(getActivity(), new IRCommand(TheaterRoom.DIGA2, "display")).execute();
                    break;
                case R.id.ButtonDIGA2PlaySettings:
                    new CommandAsyncTask(getActivity(), new IRCommand(TheaterRoom.DIGA2, "play_setting")).execute();
                    break;
                case R.id.ButtonDIGA2Rew:
                    new CommandAsyncTask(getActivity(), new IRCommand(TheaterRoom.DIGA2, "rew")).execute();
                    break;
                case R.id.ButtonDIGA2Play:
                    new CommandAsyncTask(getActivity(), new IRCommand(TheaterRoom.DIGA2, "play")).execute();
                    break;
                case R.id.ButtonDIGA2FF:
                    new CommandAsyncTask(getActivity(), new IRCommand(TheaterRoom.DIGA2, "ff")).execute();
                    break;
                case R.id.ButtonDIGA2PrevChapter:
                    new CommandAsyncTask(getActivity(), new IRCommand(TheaterRoom.DIGA2, "chapter-")).execute();
                    break;
                case R.id.ButtonDIGA2NexutChapter:
                    new CommandAsyncTask(getActivity(), new IRCommand(TheaterRoom.DIGA2, "chapter+")).execute();
                    break;
                case R.id.ButtonDIGA2Pause:
                    new CommandAsyncTask(getActivity(), new IRCommand(TheaterRoom.DIGA2, "pause")).execute();
                    break;
                case R.id.ButtonDIGA2Stop:
                    new CommandAsyncTask(getActivity(), new IRCommand(TheaterRoom.DIGA2, "stop")).execute();
                    break;
                case R.id.ButtonDIGA2SkipM15:
                    new CommandAsyncTask(getActivity(), new IRCommand(TheaterRoom.DIGA2, "10sback-")).execute();
                    break;
                case R.id.ButtonDIGA2Skip30:
                    new CommandAsyncTask(getActivity(), new IRCommand(TheaterRoom.DIGA2, "30s_skip+")).execute();
                    break;
                case R.id.ButtonDIGA2Power:
                    new CommandAsyncTask(getActivity(), new IRCommand(TheaterRoom.DIGA2, "power")).execute();
                    break;
                case R.id.ButtonDIGA2App:
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