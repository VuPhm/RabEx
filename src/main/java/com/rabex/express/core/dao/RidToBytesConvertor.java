package com.rabex.express.core.dao;

public class RidToBytesConvertor implements Convertor<RID, byte[]>{
    @Override
    public byte[] convert(RID rid) {
        return rid.toBytes();
    }
}
