package model;

import java.util.Observable;

public class OnOffModel extends Observable implements model {

    private boolean istAn;

    public OnOffModel() {
        this.istAn = false;
    }


    @Override
    public boolean isAn() {
        return istAn;
    }

    @Override
    public boolean isAus() {
        return !istAn;
    }

    @Override
    public void setAn() {
        if (!istAn) {
            istAn = true;
            this.setChanged();
            this.notifyObservers();
        }
    }

    @Override
    public void setAus() {
        if (istAn) {
            istAn = false;
            this.setChanged();
            this.notifyObservers();
        }
    }

    @Override
    public void toogle() {
        istAn = !istAn;
        this.setChanged();
        this.notifyObservers();
    }


}
