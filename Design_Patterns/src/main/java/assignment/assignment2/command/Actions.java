package assignment.assignment2.command;

import java.util.List;

public class Actions {
    private List<String> list;
    private int index;
    private boolean repeat;

    public Actions(List<String> list) {
        this.list  = list;
        index = 0;
        repeat = false;
    }

    public void play(){
        String track = list.get(index);
        System.out.println("Playing: "+track);
    }

    public void pause(){
        String track = list.get(index);
        System.out.println("Pause: "+track);
    }

    public void stop() {
        String track = list.get(index);
        System.out.println("Stopping: "+track);
    }

    public void alreadyStopped() {
        String track = list.get(index);
        System.out.println("Already Stopped: "+track);
    }

    public void next() {
        if(index == list.size()-1){
            if(repeat){
                index = 0;
                String track = list.get(index);
                System.out.println("Replaying first track: "+track);
            }else{
                System.out.println("Already on the last track");
            }
        }
        else {
            String track = list.get(++index);
            System.out.println("Playing next track: "+track);
        }


    }

    public void repeat() {
        repeat = !repeat;
        System.out.println(repeat ? "Repeat on" : "Repeat off");

    }

    public void previous() {
        if(index == 0){
            if(repeat){
                index = list.size() - 1;
                String track = list.get(index);
                System.out.println("Playing previous track: "+track);
            }else{
                System.out.println("Already on the first track");
            }
        }else {
            String track = list.get(--index);
            System.out.println("Playing previous track: "+track);
        }
    }
}
