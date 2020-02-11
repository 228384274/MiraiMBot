package com.mumu.msg;


import cc.plural.jsonij.JSON;
import cc.plural.jsonij.parser.ParserException;

import java.io.IOException;

public class RE_MSG_AdminChange extends RE_MSG
{
    private String act;
    private String subType;
    private String sendTime;
    private String fromGroup;
    private String beingOperateQQ;
    
    public RE_MSG_AdminChange(String msg) {
        super(msg);
        try {

            JSON json = JSON.parse(msg);
            this.act = String.format("%s", json.get("act"));
            this.subType = String.format("%s", json.get("subType"));
            this.sendTime = String.format("%s", json.get("sendTime"));
            this.fromGroup = String.format("%s", json.get("fromGroup"));
            this.beingOperateQQ = String.format("%s", json.get("beingOperateQQ"));
            this.type = 101;
        }
        catch (ParserException | IOException e) {
            e.printStackTrace();
        }
    }
    
    public String getAct() {
        return this.act;
    }
    
    public String getSubType() {
        return this.subType;
    }
    
    public String getSendTime() {
        return this.sendTime;
    }
    
    public String getFromGroup() {
        return this.fromGroup;
    }
    
    public String getBeingOperateQQ() {
        return this.beingOperateQQ;
    }
}