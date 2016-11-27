package com.zeus3110.theater_automation;

import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.KeyEvent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

import com.zeus3110.theater_automation.Equipment.CommandAsyncTask;
import com.zeus3110.theater_automation.Equipment.IPCommand;

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link FragmentSharpBD#newInstance} factory method to
 * create an instance of this fragment.
 */
public class FragmentAudioSettings extends Fragment implements View.OnClickListener{
    private static final String ARG_SECTION_NUMBER = "section_number";

    TextView SFC_Name;

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @return A new instance of fragment TextFragment.
     */
    // TODO: Rename and change types and number of parameters
    public static FragmentAudioSettings newInstance(int sectionNumber) {
        FragmentAudioSettings fragment = new FragmentAudioSettings();
        Bundle args = new Bundle();

        args.putInt(ARG_SECTION_NUMBER, sectionNumber);
        fragment.setArguments(args);
        return fragment;
    }

    public FragmentAudioSettings() {
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

        View v = inflater.inflate(R.layout.fragment_audio_settings, container, false);
        ((Button) v.findViewById(R.id.button_Amp_SFC_Movie)).setOnClickListener((View.OnClickListener) this);
        ((Button) v.findViewById(R.id.button_Amp_SFC_Enter)).setOnClickListener((View.OnClickListener) this);
        ((Button) v.findViewById(R.id.button_Amp_SFC_Live)).setOnClickListener((View.OnClickListener) this);
        ((Button) v.findViewById(R.id.button_Amp_SFC_Classic)).setOnClickListener((View.OnClickListener) this);
        ((Button) v.findViewById(R.id.button_Amp_SFC_Stereo)).setOnClickListener((View.OnClickListener) this);
        ((Button) v.findViewById(R.id.button_Amp_SFC_Dolby)).setOnClickListener((View.OnClickListener) this);
        ((Button) v.findViewById(R.id.button_Amp_Straight)).setOnClickListener((View.OnClickListener) this);
        ((Button) v.findViewById(R.id.button_Amp_Direct)).setOnClickListener((View.OnClickListener) this);
        ((Button) v.findViewById(R.id.button_Au_Mute)).setOnClickListener((View.OnClickListener) this);
        ((Button) v.findViewById(R.id.button_Yamaha_App)).setOnClickListener((View.OnClickListener) this);
        ((Button) v.findViewById(R.id.button_Au_Woofer_PS1)).setOnClickListener((View.OnClickListener) this);
        ((Button) v.findViewById(R.id.button_Au_Woofer_PS2)).setOnClickListener((View.OnClickListener) this);
        ((Button) v.findViewById(R.id.button_Au_Woofer_PS3)).setOnClickListener((View.OnClickListener) this);
        ((Button) v.findViewById(R.id.button_Au_Woofer_PS4)).setOnClickListener((View.OnClickListener) this);
        ((Button) v.findViewById(R.id.button_Au_Woofer_PS5)).setOnClickListener((View.OnClickListener) this);
        ((Button) v.findViewById(R.id.button_Au_Woofer_PS6)).setOnClickListener((View.OnClickListener) this);
        SFC_Name= (TextView) v.findViewById(R.id.textView_SFCName);

        v.setOnKeyListener(new View.OnKeyListener() {
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
                        new CommandAsyncTask(getActivity(), new IPCommand(TheaterRoom.AVAmp,"MenuUp")).execute();
                        return true;
                    case KeyEvent.KEYCODE_DPAD_DOWN:
                        new CommandAsyncTask(getActivity(), new IPCommand(TheaterRoom.AVAmp,"MenuDown")).execute();
                        return true;
                    case KeyEvent.KEYCODE_DPAD_LEFT:
                        new CommandAsyncTask(getActivity(), new IPCommand(TheaterRoom.AVAmp,"MenuLeft")).execute();
                        return true;
                    case KeyEvent.KEYCODE_DPAD_RIGHT:
                        new CommandAsyncTask(getActivity(), new IPCommand(TheaterRoom.AVAmp,"MenuRight")).execute();
                        return true;
                    case KeyEvent.KEYCODE_BUTTON_A:
                        new CommandAsyncTask(getActivity(), new IPCommand(TheaterRoom.AVAmp,"MenuEnter")).execute();
                        return true;
                    case KeyEvent.KEYCODE_BUTTON_B:
                        new CommandAsyncTask(getActivity(), new IPCommand(TheaterRoom.AVAmp,"MenuReturn")).execute();
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
                        new CommandAsyncTask(getActivity(), new IPCommand(TheaterRoom.AVAmp,"MenuOption")).execute();
                        return true;
                    case KeyEvent.KEYCODE_BUTTON_START:
                        new CommandAsyncTask(getActivity(), new IPCommand(TheaterRoom.AVAmp,"MenuOSD")).execute();
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
                case R.id.button_Amp_SFC_Movie:
                    new CommandAsyncTask(getActivity(), new IPCommand(TheaterRoom.AVAmp,"SPMovie")).execute();
                    break;
                case R.id.button_Amp_SFC_Enter:
                    new CommandAsyncTask(getActivity(), new IPCommand(TheaterRoom.AVAmp,"SPEntertainment")).execute();
                    break;
                case R.id.button_Amp_SFC_Live:
                    new CommandAsyncTask(getActivity(), new IPCommand(TheaterRoom.AVAmp,"SPLiveClub")).execute();
                    break;
                case R.id.button_Amp_SFC_Classic:
                    new CommandAsyncTask(getActivity(), new IPCommand(TheaterRoom.AVAmp,"SPClassical")).execute();
                    break;
                case R.id.button_Amp_SFC_Stereo:
                    new CommandAsyncTask(getActivity(), new IPCommand(TheaterRoom.AVAmp,"SPStereo")).execute();
                    break;
                case R.id.button_Amp_SFC_Dolby:
                    new CommandAsyncTask(getActivity(), new IPCommand(TheaterRoom.AVAmp,"SPDolby")).execute();
                    break;
                case R.id.button_Amp_Straight:
                    new CommandAsyncTask(getActivity(), new IPCommand(TheaterRoom.AVAmp,"SPStraight")).execute();
                    break;
                case R.id.button_Amp_Direct:
                    new CommandAsyncTask(getActivity(), new IPCommand(TheaterRoom.AVAmp,"PureDirect")).execute();
                    break;
                case R.id.button_Au_Mute:
                    new CommandAsyncTask(getActivity(), new IPCommand(TheaterRoom.AVAmp,"Mute")).execute();
                    break;
                case R.id.button_Yamaha_App:
                    Intent intent = new Intent();
                    intent.setClassName("com.yamaha.av.avcontroller", "com.yamaha.av.avcontroller.activity.DeviceSelectParent");
                    startActivity(intent);                    // アプリを起動
                    break;
                case R.id.button_Au_Woofer_PS1:
                    new CommandAsyncTask(getActivity(), new IPCommand(TheaterRoom.Woofer,"EQ1")).execute();
                    break;
                case R.id.button_Au_Woofer_PS2:
                    new CommandAsyncTask(getActivity(), new IPCommand(TheaterRoom.Woofer,"EQ2")).execute();
                    break;
                case R.id.button_Au_Woofer_PS3:
                    new CommandAsyncTask(getActivity(), new IPCommand(TheaterRoom.Woofer,"EQ3")).execute();
                    break;
                case R.id.button_Au_Woofer_PS4:
                    new CommandAsyncTask(getActivity(), new IPCommand(TheaterRoom.Woofer,"EQ4")).execute();
                    break;
                case R.id.button_Au_Woofer_PS5:
                    new CommandAsyncTask(getActivity(), new IPCommand(TheaterRoom.Woofer,"EQ5")).execute();
                    break;
                case R.id.button_Au_Woofer_PS6:
                    new CommandAsyncTask(getActivity(), new IPCommand(TheaterRoom.Woofer,"EQ6")).execute();
                    break;
                default:
                    break;
            }
        }catch (Exception e){
            e.printStackTrace();
        }
    }
}