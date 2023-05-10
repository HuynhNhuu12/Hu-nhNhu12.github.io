package com.hn.pojo;

import com.hn.pojo.BookingDetail;
import com.hn.pojo.Tour;
import com.hn.pojo.User;
import java.util.Date;
import javax.annotation.Generated;
import javax.persistence.metamodel.SetAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="EclipseLink-2.7.10.v20211216-rNA", date="2022-12-14T16:15:51")
@StaticMetamodel(Booking.class)
public class Booking_ { 

    public static volatile SingularAttribute<Booking, Date> createdDate;
    public static volatile SingularAttribute<Booking, String> numInfant;
    public static volatile SetAttribute<Booking, BookingDetail> bookingDetailSet;
    public static volatile SingularAttribute<Booking, Tour> tourId;
    public static volatile SingularAttribute<Booking, String> numAdult;
    public static volatile SingularAttribute<Booking, Integer> id;
    public static volatile SingularAttribute<Booking, String> numChild;
    public static volatile SingularAttribute<Booking, User> userId;

}