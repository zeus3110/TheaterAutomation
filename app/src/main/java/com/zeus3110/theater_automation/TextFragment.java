package com.zeus3110.theater_automation;


import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.KeyEvent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.Button;

import com.zeus3110.theater_automation.Equipment.AVCommand;
import com.zeus3110.theater_automation.Equipment.CommandAsyncTask;
import com.zeus3110.theater_automation.Equipment.IRCommand;
import com.zeus3110.theater_automation.Equipment.WaitCommand;

import java.util.ArrayList;

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link TextFragment#newInstance} factory method to
 * create an instance of this fragment.
 *
 */
public class TextFragment extends Fragment implements OnClickListener{
    private static final String ARG_SECTION_NUMBER = "section_number";

    // Theater Equipment Definition
    BedRoom Tr;

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @return A new instance of fragment TextFragment.
     */
    // TODO: Rename and change types and number of parameters
    public static TextFragment newInstance(int sectionNumber) {
        TextFragment fragment = new TextFragment();
        Bundle args = new Bundle();

        args.putInt(ARG_SECTION_NUMBER, sectionNumber);
        fragment.setArguments(args);
        return fragment;
    }
    public TextFragment() {
        // Required empty public constructor
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        Tr=new BedRoom();
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment

        View v=inflater.inflate(R.layout.fragment_text, container, false);
        ((Button)v.findViewById(R.id.ButtonSharpBDKey1)).setOnClickListener((OnClickListener) this);
        ((Button)v.findViewById(R.id.Button_Ceol_Power)).setOnClickListener((OnClickListener) this);
        ((Button)v.findViewById(R.id.Button_LS700_Power)).setOnClickListener((OnClickListener) this);
        ((Button)v.findViewById(R.id.Button_Ceol_AUX)).setOnClickListener((OnClickListener) this);
        ((Button)v.findViewById(R.id.Button_Ceol_DLNA)).setOnClickListener((OnClickListener) this);
        ((Button)v.findViewById(R.id.Button_BUPNP)).setOnClickListener((OnClickListener) this);
        ((Button)v.findViewById(R.id.Button_SHLight_Off)).setOnClickListener((OnClickListener) this);
        ((Button)v.findViewById(R.id.Button_SHLight_Night)).setOnClickListener((OnClickListener) this);
        ((Button)v.findViewById(R.id.Button_SHLight_Work)).setOnClickListener((OnClickListener) this);
        ((Button)v.findViewById(R.id.Button_SHLight_Relax)).setOnClickListener((OnClickListener) this);
        ((Button)v.findViewById(R.id.Button_PanaAir_Off)).setOnClickListener((OnClickListener) this);
        ((Button)v.findViewById(R.id.Button_PanaAir_Cool)).setOnClickListener((OnClickListener) this);


        v.setOnKeyListener(new View.OnKeyListener() {
            @Override
            public boolean onKey(View v, int keyCode, KeyEvent event) {
                try {
                    switch (keyCode) {
                        case KeyEvent.KEYCODE_VOLUME_UP:
                            new CommandAsyncTask(getActivity(), new IRCommand(BedRoom.Ceol, "VolPlus")).execute();
                            return true;
                        case KeyEvent.KEYCODE_VOLUME_DOWN:
                            new CommandAsyncTask(getActivity(), new IRCommand(BedRoom.Ceol, "VolMinus")).execute();
                            return true;
                        default:
                            return false;

                    }
                }catch (Exception e){
                    e.printStackTrace();
                }
                return false;
            }
        });

        // View#setFocusableInTouchModeでtrueをセットしておくこと
        v.setFocusableInTouchMode(true);
        v.requestFocus();

        return v;
    }

    // ボタンイベント
    public void onClick(View v) {
        try{
            switch (v.getId()) {

                //DMR-BZT910 Activity
                case R.id.ButtonSharpBDKey1:
                    new CommandAsyncTask(getActivity(), new IRCommand(BedRoom.TV, "Power")).execute();
                    break;

                case R.id.Button_Ceol_Power:
                    new CommandAsyncTask(getActivity(), new IRCommand(BedRoom.Ceol, "Power")).execute();
                    break;

                case R.id.Button_LS700_Power:
                    new CommandAsyncTask(getActivity(), new IRCommand(BedRoom.Player, "Power")).execute();
                    break;

                case R.id.Button_Ceol_AUX:
                    new CommandAsyncTask(getActivity(), new IRCommand(BedRoom.Ceol, "FunctionAUX")).execute();
                    break;

                case R.id.Button_Ceol_DLNA:
                    new CommandAsyncTask(getActivity(), new IRCommand(BedRoom.Ceol, "FunctionDLNA")).execute();
                    break;

                //BubbleUPNP
                case R.id.Button_BUPNP:
                    Intent intent = new Intent();
                    // パッケージ名, クラス名をセット
                    intent.setClassName("com.bubblesoft.android.bubbleupnp", "com.bubblesoft.android.bubbleupnp.MainActivity");
                    // アプリを起動
                    startActivity(intent);
                    break;

                case R.id.Button_SHLight_Off:
                    new CommandAsyncTask(getActivity(), new IRCommand(BedRoom.Light, "Off")).execute();
                    break;

                case R.id.Button_SHLight_Night:
                    new CommandAsyncTask(getActivity(), new IRCommand(BedRoom.Light, "Night")).execute();
                    break;

                case R.id.Button_SHLight_Work:
                    ArrayList<AVCommand> MacroActivityBedRoomLightWork=new ArrayList<AVCommand>();
                    MacroActivityBedRoomLightWork.add(new IRCommand(BedRoom.Light,"Favorites"));
                    MacroActivityBedRoomLightWork.add(new WaitCommand(1000));
                    MacroActivityBedRoomLightWork.add(new IRCommand(BedRoom.Light,"Bright10"));
                    MacroActivityBedRoomLightWork.add(new WaitCommand(1000));
                    MacroActivityBedRoomLightWork.add(new IRCommand(BedRoom.Light,"Color4"));
                    new CommandAsyncTask(getActivity(),MacroActivityBedRoomLightWork).execute();
                    break;

                case R.id.Button_SHLight_Relax:
                    ArrayList<AVCommand> MacroActivityBedRoomLightRelax=new ArrayList<AVCommand>();
                    MacroActivityBedRoomLightRelax.add(new IRCommand(BedRoom.Light,"Favorites"));
                    MacroActivityBedRoomLightRelax.add(new WaitCommand(1000));
                    MacroActivityBedRoomLightRelax.add(new IRCommand(BedRoom.Light,"Bright2"));
                    MacroActivityBedRoomLightRelax.add(new WaitCommand(1000));
                    MacroActivityBedRoomLightRelax.add(new IRCommand(BedRoom.Light,"Color10"));
                    new CommandAsyncTask(getActivity(),MacroActivityBedRoomLightRelax).execute();
                    break;

                case R.id.Button_PanaAir_Off:
                    new CommandAsyncTask(getActivity(), new IRCommand(BedRoom.AirCon, "PowerOff")).execute();
                    break;

                case R.id.Button_PanaAir_Cool:
                    new CommandAsyncTask(getActivity(), new IRCommand(BedRoom.AirCon, "Cool")).execute();
                    break;

                default:
                    break;
            }
        }catch (Exception e){
            e.printStackTrace();
        }

    }

}