package com.rabex.express.dao.mapper;


import com.rabex.express.core.dao.*;
import com.rabex.express.model.*;
import lombok.Builder;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Builder
public class ShippingServExtractor implements ResultSetExtractor<List<ShippingServ>> {
    private final RowMapper<ShippingServ> serviceMapper;
    private final RowMapper<PricingTier> pricingTierMapper;


    private final Convertor<String, RID> ridConvertor = new StringToRidConvertor();

    public ShippingServExtractor(RowMapper<ShippingServ> serviceMapper, RowMapper<PricingTier> pricingTierMapper) {
        this.serviceMapper = serviceMapper;
        this.pricingTierMapper = pricingTierMapper;
    }

    @Override
    public List<ShippingServ> extractData(ResultSet resultSet) throws SQLException {
        Map<RID, ShippingServ> services = new HashMap<>();
        int i = 0;
        while (resultSet.next()) {
            RID id = ridConvertor.convert(resultSet.getString(serviceMapper.getPrefix() + "id"));
            ShippingServ service = services.get(id);

            if (service == null) {
                service = serviceMapper.mapRow(resultSet, i);
                service.setPricingTiers(new ArrayList<>());

                services.put(id, service);
            }

            service.getPricingTiers().add(pricingTierMapper.mapRow(resultSet, i));

            i++;
        }
        return services.values().stream().toList();
    }
}
