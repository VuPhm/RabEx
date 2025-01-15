package com.rabex.express.dao.mapper;

import com.rabex.express.core.dao.*;
import com.rabex.express.model.PricingTier;
import com.rabex.express.model.enumm.ShippingRange;

import java.sql.ResultSet;
import java.sql.SQLException;

public class PricingTierMapper implements RowMapper<PricingTier> {
    private final String prefix;
    private final Convertor<String, RID> idConvertor = new StringToRidConvertor();
    private final Convertor<String, ShippingRange> enumConvertor = new StringToEnumConvertor<>(ShippingRange.class);

    public PricingTierMapper(String prefix) {
        this.prefix = prefix;
    }

    @Override
    public PricingTier mapRow(ResultSet resultSet, int row) throws SQLException {
        return PricingTier.builder()
                .id(idConvertor.convert(resultSet.getString(prefix + "id")))
//                .description(resultSet.getString(prefix + "description"))
                .description(resultSet.getString("ss_name"))
                .serviceId(idConvertor.convert(resultSet.getString(prefix + "service_id")))
                .weightStart(resultSet.getDouble(prefix + "weight_start"))
                .weightEnd(resultSet.getDouble(prefix + "weight_end"))
                .stepIncrement(resultSet.getDouble(prefix + "step_increment"))
                .pricePerStep(resultSet.getDouble(prefix + "price_per_step"))
                .shippingRange(enumConvertor.convert(resultSet.getString(prefix + "shipping_range")))
                .basePrice(resultSet.getDouble(prefix + "base_price"))
                .created_at(resultSet.getTimestamp(prefix + "created_at"))
                .updated_at(resultSet.getTimestamp(prefix + "updated_at"))

                .build();
    }

    @Override
    public String getPrefix() { return prefix; }
}
