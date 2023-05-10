package com.hn.pojo;

import com.hn.pojo.Booking;
import com.hn.pojo.BookingDetail;
import com.hn.pojo.Comments;
import com.hn.pojo.News;
import javax.annotation.Generated;
import javax.persistence.metamodel.SetAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="EclipseLink-2.7.10.v20211216-rNA", date="2022-12-14T16:15:51")
@StaticMetamodel(User.class)
public class User_ { 

    public static volatile SingularAttribute<User, String> lastName;
    public static volatile SingularAttribute<User, String> image;
    public static volatile SetAttribute<User, Comments> commentsSet;
    public static volatile SetAttribute<User, News> newsSet;
    public static volatile SingularAttribute<User, Boolean> active;
    public static volatile SingularAttribute<User, String> firstName;
    public static volatile SingularAttribute<User, String> password;
    public static volatile SetAttribute<User, BookingDetail> bookingDetailSet;
    public static volatile SingularAttribute<User, String> phone;
    public static volatile SetAttribute<User, Booking> bookingSet;
    public static volatile SingularAttribute<User, Integer> id;
    public static volatile SingularAttribute<User, String> userRole;
    public static volatile SingularAttribute<User, String> email;
    public static volatile SingularAttribute<User, String> username;

}