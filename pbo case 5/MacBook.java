class MacBook implements Laptop {
    private int volume = 50;
    private boolean isOn = false;

    @Override
    public void turnOn() {
        isOn = true;
        System.out.println("MacBook dinyalakan.");
    }

    @Override
    public void turnOff() {
        isOn = false;
        System.out.println("MacBook dimatikan.");
    }

    @Override
    public void volumeUp() {
        if (isOn) {
            volume += 10;
            if (volume > 100) volume = 100;
            System.out.println("Volume MacBook: " + volume);
        } else {
            System.out.println("Nyalakan laptop dulu!");
        }
    }

    @Override
    public void volumeDown() {
        if (isOn) {
            volume -= 10;
            if (volume < 0) volume = 0;
            System.out.println("Volume MacBook: " + volume);
        } else {
            System.out.println("Nyalakan laptop dulu!");
        }
    }
}