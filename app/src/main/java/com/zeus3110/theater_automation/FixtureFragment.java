package com.zeus3110.theater_automation;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.KeyEvent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import com.zeus3110.theater_automation.Equipment.CommandAsyncTask;
import com.zeus3110.theater_automation.Equipment.IPCommand;
import com.zeus3110.theater_automation.Equipment.IRCommand;

/**
 * Created by Ratan on 7/9/2015.
 */
public class FixtureFragment extends Fragment  implements View.OnClickListener {

    // Theater Equipment Definition
    TheaterRoom Tr;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        Tr=new TheaterRoom();
    }

    public void onClick(View v) {
        try{
            switch (v.getId()) {

                case R.id.ButtonPreset1:
                    new CommandAsyncTask(getActivity(), new IRCommand(TheaterRoom.LightManager, "Preset1")).execute();
                    break;
                case R.id.ButtonPreset2:
                    new CommandAsyncTask(getActivity(), new IRCommand(TheaterRoom.LightManager, "Preset2")).execute();
                    break;
                case R.id.ButtonPreset3:
                    new CommandAsyncTask(getActivity(), new IRCommand(TheaterRoom.LightManager, "Preset3")).execute();
                    break;
                case R.id.ButtonPreset4:
                    new CommandAsyncTask(getActivity(), new IRCommand(TheaterRoom.LightManager, "Preset4")).execute();
                    break;
                case R.id.ButtonPreset5:
                    new CommandAsyncTask(getActivity(), new IRCommand(TheaterRoom.LightManager, "Preset5")).execute();
                    break;
                case R.id.ButtonPreset6:
                    new CommandAsyncTask(getActivity(), new IRCommand(TheaterRoom.LightManager, "Preset6")).execute();
                    break;
                case R.id.ButtonPreset7:
                    new CommandAsyncTask(getActivity(), new IRCommand(TheaterRoom.LightManager, "Preset7")).execute();
                    break;
                case R.id.ButtonPreset8:
                    new CommandAsyncTask(getActivity(), new IRCommand(TheaterRoom.LightManager, "Preset8")).execute();
                    break;
                case R.id.ButtonAllOff:
                    new CommandAsyncTask(getActivity(), new IRCommand(TheaterRoom.LightManager, "AllOff")).execute();
                    break;
                case R.id.ButtonR1ON:
                    new CommandAsyncTask(getActivity(), new IPCommand(TheaterRoom.AVAmp, "PowerOn")).execute();
                    break;
                case R.id.ButtonR1OFF:
                    new CommandAsyncTask(getActivity(), new IPCommand(TheaterRoom.Projector, "POWER ON")).execute();
                    break;
                default:
                    break;
            }
        }catch (Exception e){
            e.printStackTrace();
        }
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {

        View v=inflater.inflate(R.layout.fixture_layout, container, false);

        ((Button)v.findViewById(R.id.ButtonPreset1)).setOnClickListener((View.OnClickListener) this);
        ((Button)v.findViewById(R.id.ButtonPreset1)).setOnClickListener((View.OnClickListener) this);
        ((Button)v.findViewById(R.id.ButtonPreset2)).setOnClickListener((View.OnClickListener) this);
        ((Button)v.findViewById(R.id.ButtonPreset3)).setOnClickListener((View.OnClickListener) this);
        ((Button)v.findViewById(R.id.ButtonPreset4)).setOnClickListener((View.OnClickListener) this);
        ((Button)v.findViewById(R.id.ButtonPreset5)).setOnClickListener((View.OnClickListener) this);
        ((Button)v.findViewById(R.id.ButtonPreset6)).setOnClickListener((View.OnClickListener) this);
        ((Button)v.findViewById(R.id.ButtonPreset7)).setOnClickListener((View.OnClickListener) this);
        ((Button)v.findViewById(R.id.ButtonPreset8)).setOnClickListener((View.OnClickListener) this);
        ((Button)v.findViewById(R.id.ButtonAllOff)).setOnClickListener((View.OnClickListener) this);
        ((Button)v.findViewById(R.id.ButtonR1ON)).setOnClickListener((View.OnClickListener) this);
        ((Button)v.findViewById(R.id.ButtonR1OFF)).setOnClickListener((View.OnClickListener) this);

        v.setOnKeyListener(new View.OnKeyListener() {
            @Override
            public boolean onKey(View v, int keyCode, KeyEvent event) {


                switch (keyCode) {
                    case KeyEvent.KEYCODE_VOLUME_UP:
                        // TODO:音量増加キーが押された時のイベント
//                        new CommandAsyncTask(getActivity(),Tr.Eq.Ceol.VolPlus).execute();
                        return true;
                    case KeyEvent.KEYCODE_VOLUME_DOWN:
                        // TODO:音量減少キーが押された時のイベント
//                        new CommandAsyncTask(getActivity(),Tr.Eq.Ceol.VolMinus).execute();
                        return true;
                    default:
                        return false;
                }
            }
        });

        // View#setFocusableInTouchModeでtrueをセットしておくこと
        v.setFocusableInTouchMode(true);
        v.requestFocus();

        return v;

//        return inflater.inflate(R.layout.fixture_layout,null);
    }
}
