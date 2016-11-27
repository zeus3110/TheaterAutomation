package com.zeus3110.theater_automation.Equipment;

import java.util.ArrayList;
import java.util.concurrent.Callable;

/**
 * Created by super on 2016/06/05.
 */
public class GetParamsCallable implements Callable< ArrayList<byte[]> > {

    private ArrayList<IPCommand> Command;
    private String Err=null;
    private int i=0;

    // constructor
    public GetParamsCallable(ArrayList<IPCommand> com){
        Command=new ArrayList<IPCommand>();
        Command.addAll(com);
    }

    @Override
    public ArrayList<byte[]> call() throws Exception {
        ArrayList<byte[]> res;
        res=new ArrayList<byte[]>();

        try {
            for(IPCommand e:Command){
                res.add(e.GetParam());
            }
        } catch (Exception e) {
            Err = e.toString();
        }
        return res;
    }
}
