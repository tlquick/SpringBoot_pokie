package com.tlquick.pokie.models.utils;

import lombok.AllArgsConstructor;

import lombok.Getter;
import lombok.Setter;

@AllArgsConstructor
@Getter
@Setter
public class Record {
    protected int number;
    public String toString()
    {
    	return "" + number;
    }
}

