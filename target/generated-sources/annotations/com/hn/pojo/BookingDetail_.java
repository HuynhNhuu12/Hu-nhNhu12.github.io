package com.hn.pojo;

import com.hn.pojo.Booking;
import com.hn.pojo.User;
import javax.annotation.Generated;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="EclipseLink-2.7.10.v20211216-rNA", date="2022-12-14T16:15:51")
@StaticMetamodel(BookingDetail.class)
public class BookingDetail_ { 

    public static volatile SingularAttribute<BookingDetail, String> isPayment;
    public static volatile SingularAttribute<BookingDetail, String> customerPhone;
    public static volatile SingularAttribute<BookingDetail, User> customerId;
    public static volatile SingularAttribute<BookingDetail, Integer> id;
    public static volatile SingularAttribute<BookingDetail, String> customerName;
    public static volatile SingularAttribute<BookingDetail, Booking> bookingId;

}