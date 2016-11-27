package com.zeus3110.theater_automation;

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
public class FragmentVideoSettings extends Fragment implements View.OnClickListener{
    private static final String ARG_SECTION_NUMBER = "section_number";

    TextView PM_Name;

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @return A new instance of fragment TextFragment.
     */
    // TODO: Rename and change types and number of parameters
    public static FragmentVideoSettings newInstance(int sectionNumber) {
        FragmentVideoSettings fragment = new FragmentVideoSettings();
        Bundle args = new Bundle();

        args.putInt(ARG_SECTION_NUMBER, sectionNumber);
        fragment.setArguments(args);
        return fragment;
    }

    public FragmentVideoSettings() {
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

        View v = inflater.inflate(R.layout.fragment_video_settings, container, false);
        ((Button) v.findViewById(R.id.button_PJ_PM_Film)).setOnClickListener((View.OnClickListener) this);
        ((Button) v.findViewById(R.id.button_PJ_PM_Cinema)).setOnClickListener((View.OnClickListener) this);
        ((Button) v.findViewById(R.id.button_PJ_PM_Anime)).setOnClickListener((View.OnClickListener) this);
        ((Button) v.findViewById(R.id.button_PJ_PM_Natural)).setOnClickListener((View.OnClickListener) this);
        ((Button) v.findViewById(R.id.button_PJ_PM_Stage)).setOnClickListener((View.OnClickListener) this);
        ((Button) v.findViewById(R.id.button_PJ_PM_3D)).setOnClickListener((View.OnClickListener) this);
        ((Button) v.findViewById(R.id.button_PJ_PM_User1)).setOnClickListener((View.OnClickListener) this);
        ((Button) v.findViewById(R.id.button_PJ_PM_User2)).setOnClickListener((View.OnClickListener) this);
        ((Button) v.findViewById(R.id.button_PJ_PM_THX)).setOnClickListener((View.OnClickListener) this);
        ((Button) v.findViewById(R.id.button_PJ_Gamma)).setOnClickListener((View.OnClickListener) this);
        ((Button) v.findViewById(R.id.button_PJ_ColorTemp)).setOnClickListener((View.OnClickListener) this);
        ((Button) v.findViewById(R.id.button_PJ_ColorProfile)).setOnClickListener((View.OnClickListener) this);
        ((Button) v.findViewById(R.id.button_PJ_CMD1)).setOnClickListener((View.OnClickListener) this);
        ((Button) v.findViewById(R.id.button_PJ_CMD2)).setOnClickListener((View.OnClickListener) this);
        ((Button) v.findViewById(R.id.button_PJ_CMD3)).setOnClickListener((View.OnClickListener) this);
        ((Button) v.findViewById(R.id.button_PJ_CMD4)).setOnClickListener((View.OnClickListener) this);
        ((Button) v.findViewById(R.id.button_PJ_CMDFilm)).setOnClickListener((View.OnClickListener) this);
        ((Button) v.findViewById(R.id.button_PJ_CMDOff)).setOnClickListener((View.OnClickListener) this);
        PM_Name= (TextView) v.findViewById(R.id.textView_PMName);

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
                        new CommandAsyncTask(getActivity(), new IPCommand(TheaterRoom.Projector,"CURSOR UP")).execute();
                        return true;
                    case KeyEvent.KEYCODE_DPAD_DOWN:
                        new CommandAsyncTask(getActivity(), new IPCommand(TheaterRoom.Projector,"CURSOR DOWN")).execute();
                        return true;
                    case KeyEvent.KEYCODE_DPAD_LEFT:
                        new CommandAsyncTask(getActivity(), new IPCommand(TheaterRoom.Projector,"CURSOR LEFT")).execute();
                        return true;
                    case KeyEvent.KEYCODE_DPAD_RIGHT:
                        new CommandAsyncTask(getActivity(), new IPCommand(TheaterRoom.Projector,"CURSOR RIGHT")).execute();
                        return true;
                    case KeyEvent.KEYCODE_BUTTON_A:
                        new CommandAsyncTask(getActivity(), new IPCommand(TheaterRoom.Projector,"ENTER")).execute();
                        return true;
                    case KeyEvent.KEYCODE_BUTTON_B:
                        new CommandAsyncTask(getActivity(), new IPCommand(TheaterRoom.Projector,"EXIT")).execute();
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
                        return true;
                    case KeyEvent.KEYCODE_BUTTON_START:
                        new CommandAsyncTask(getActivity(), new IPCommand(TheaterRoom.Projector,"MENU")).execute();
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
                case R.id.button_PJ_PM_Film:
                    new CommandAsyncTask(getActivity(), new IPCommand(TheaterRoom.Projector,"MODE: FILM")).execute();
                    break;
                case R.id.button_PJ_PM_Cinema:
                    new CommandAsyncTask(getActivity(), new IPCommand(TheaterRoom.Projector,"MODE: CINEMA")).execute();
                    break;
                case R.id.button_PJ_PM_Anime:
                    new CommandAsyncTask(getActivity(), new IPCommand(TheaterRoom.Projector,"MODE: ANIME")).execute();
                    break;
                case R.id.button_PJ_PM_Natural:
                    new CommandAsyncTask(getActivity(), new IPCommand(TheaterRoom.Projector,"MODE: NATURAL")).execute();
                    break;
                case R.id.button_PJ_PM_Stage:
                    new CommandAsyncTask(getActivity(), new IPCommand(TheaterRoom.Projector,"MODE: STAGE")).execute();
                    break;
                case R.id.button_PJ_PM_3D:
                    new CommandAsyncTask(getActivity(), new IPCommand(TheaterRoom.Projector,"MODE: 3D")).execute();
                    break;
                case R.id.button_PJ_PM_User1:
                    new CommandAsyncTask(getActivity(), new IPCommand(TheaterRoom.Projector,"MODE: USER1")).execute();
                    break;
                case R.id.button_PJ_PM_User2:
                    new CommandAsyncTask(getActivity(), new IPCommand(TheaterRoom.Projector,"MODE: USER2")).execute();
                    break;
                case R.id.button_PJ_PM_THX:
                    new CommandAsyncTask(getActivity(), new IPCommand(TheaterRoom.Projector,"MODE: THX")).execute();
                    break;
                case R.id.button_PJ_Gamma:
                    new CommandAsyncTask(getActivity(), new IPCommand(TheaterRoom.Projector,"GAMMA")).execute();
                    break;
                case R.id.button_PJ_ColorTemp:
                    new CommandAsyncTask(getActivity(), new IPCommand(TheaterRoom.Projector,"COLOR TEMP")).execute();
                    break;
                case R.id.button_PJ_ColorProfile:
                    new CommandAsyncTask(getActivity(), new IPCommand(TheaterRoom.Projector,"COLOR PROFILE")).execute();
                    break;
                case R.id.button_PJ_CMD1:
                    new CommandAsyncTask(getActivity(), new IPCommand(TheaterRoom.Projector,"C.M.D: Mode1")).execute();
                    break;
                case R.id.button_PJ_CMD2:
                    new CommandAsyncTask(getActivity(), new IPCommand(TheaterRoom.Projector,"C.M.D: Mode2")).execute();
                    break;
                case R.id.button_PJ_CMD3:
                    new CommandAsyncTask(getActivity(), new IPCommand(TheaterRoom.Projector,"C.M.D: Mode3")).execute();
                    break;
                case R.id.button_PJ_CMD4:
                    new CommandAsyncTask(getActivity(), new IPCommand(TheaterRoom.Projector,"C.M.D: Mode4")).execute();
                    break;
                case R.id.button_PJ_CMDFilm:
                    new CommandAsyncTask(getActivity(), new IPCommand(TheaterRoom.Projector,"C.M.D: Film")).execute();
                    break;
                case R.id.button_PJ_CMDOff:
                    new CommandAsyncTask(getActivity(), new IPCommand(TheaterRoom.Projector,"C.M.D: OFF")).execute();
                    break;
                default:
                    break;
            }
        }catch (Exception e){
            e.printStackTrace();
        }
    }
}