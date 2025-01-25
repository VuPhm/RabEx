package com.rabex.express.services.impl;

import com.rabex.express.core.dao.RID;
import com.rabex.express.dao.OrderDao;
import com.rabex.express.dto.OrderCreateForm;
import com.rabex.express.model.Address;
import com.rabex.express.model.Order;
import com.rabex.express.model.PersonInfo;
import com.rabex.express.model.ShippingServ;
import com.rabex.express.model.enumm.AddressType;
import com.rabex.express.services.OrderService;
import jakarta.inject.Inject;

public class OrderServiceImpl implements OrderService {
    @Inject
    private OrderDao orderDao;

    @Override
    public Order findByCode(String code) {
        return orderDao.findByCode(code);
    }

    @Override
    public boolean addOrder(RID cId, OrderCreateForm request) {
        //address format province/district/ward dung split de cat ra
        String[] paths = request.getSenderAddress().split("/");

        if (paths.length != 3)
            return false;
        // người gửi
        Address addressSender = Address.builder()
                .id(RID.fast())
                .description(request.getSenderAddressDetail())
                .ward(paths[2].trim())
                .district(paths[1].trim())
                .province(paths[0].trim())
                .build();
        PersonInfo senderInfo = PersonInfo.builder()
                .id(RID.fast())
                .fullName(request.getSenderFullName())
                .phoneNumber(request.getSenderPhoneNumber())
                .build();

        // Mới làm tới đây nè thằng lồn

        return false;
    }
}
