package main.java.ch03_class.basic.ch08.sec04;

public class Television implements RemoteControl{

    private int volume;

    @Override
    public void turnOn() {
        System.out.println("TV를 켭니다.");
    }

    @Override
    public void turnOff() {
        System.out.println("TV를 끕니다.");
    }

    @Override
    public void setVolume(int volume) {
        if(volume > MAX_VOLUME) {
            volume = MAX_VOLUME;
        }else if (volume < MIN_VOLUME){
            volume = MIN_VOLUME;
        }
        this.volume = volume;

        System.out.println("현재 TV 볼륨 : " + this.volume);
    }
}
