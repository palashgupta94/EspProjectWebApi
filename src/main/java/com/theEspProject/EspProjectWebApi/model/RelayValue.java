package com.theEspProject.EspProjectWebApi.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.boot.autoconfigure.domain.EntityScan;

import java.io.Serializable;


public class RelayValue implements Serializable {


    private String currentValue;

    public RelayValue() {
    }


    public RelayValue(String currentValue) {

        this.currentValue = currentValue;
    }

    public String getRelayValue() {
        return currentValue;
    }

    public void setRelayValue(String relayValue) {
        this.currentValue = relayValue;
    }

    @Override
    public String toString() {
        return " "+currentValue;
    }
}
