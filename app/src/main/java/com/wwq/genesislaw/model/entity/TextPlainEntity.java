package com.wwq.genesislaw.model.entity;

/**
 * Created by wwq on 2017/6/9.
 */

public class TextPlainEntity {
    private int stringId;
    private String title;

    public TextPlainEntity(int stringId, String title) {
        this.stringId = stringId;
        this.title = title;
    }

    public int getStringId() {
        return stringId;
    }

    public String getTitle() {
        return title;
    }
}
