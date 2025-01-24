package com.rabex.express.dao.mapper;

import com.rabex.express.core.dao.*;
import com.rabex.express.dto.PricingTiersTable;
import com.rabex.express.model.PricingTier;
import com.rabex.express.model.enumm.ShippingRange;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class PricingTierTableExtractor implements ResultSetExtractor<List<PricingTiersTable>> {

    Convertor<String, RID> ridConvertor = new StringToRidConvertor();
    Convertor<String, ShippingRange> rangeConvertor = new StringToEnumConvertor<>(ShippingRange.class);

    @Override
    public List<PricingTiersTable> extractData(ResultSet resultSet) throws SQLException {
        Map<Double, PricingTiersTable> tiers = new HashMap<>();
        int i = 0;
        while (resultSet.next()) {
            double wStart = resultSet.getDouble("pt_" + "weight_start");
            PricingTiersTable tier = tiers.get(wStart);
            if (tier == null) {
                tier = PricingTiersTable.builder()
                        .id(ridConvertor.convert(resultSet.getString("pt_id")))
                        .description(resultSet.getString("pt_" + "description"))
                        .weightStart(resultSet.getDouble("pt_" + "weight_start"))
                        .weightEnd(resultSet.getDouble("pt_" + "weight_end"))
                        .stepIncrement(resultSet.getDouble("pt_" + "step_increment"))

                        .build();
                tiers.put(wStart, tier);
            }

            boolean isInProvince = tier.getStepIncrement() * 1000 == 0;
            if (isInProvince) {
                tier.setInPricePerStep(resultSet.getDouble("pt_" + "price_per_step"));
                tier.setInProvinceBasePrice(resultSet.getDouble("pt_" + "base_price"));
            } else {
                tier.setOutPricePerStep(resultSet.getDouble("pt_" + "price_per_step"));
                tier.setOutProvinceBasePrice(resultSet.getDouble("pt_" + "base_price"));
            }

            i++;
        }
        return tiers.values().stream().toList();
    }
}
