package com.hn.pojo;

import com.hn.pojo.Booking;
import com.hn.pojo.Category;
import com.hn.pojo.Comments;
import java.util.Date;
import javax.annotation.Generated;
import javax.persistence.metamodel.SetAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="EclipseLink-2.7.10.v20211216-rNA", date="2022-12-14T16:15:51")
@StaticMetamodel(Tour.class)
public class Tour_ { 

    public static volatile SingularAttribute<Tour, String> image;
    public static volatile SetAttribute<Tour, Comments> commentsSet;
    public static volatile SingularAttribute<Tour, Long> priceInfant;
    public static volatile SingularAttribute<Tour, String> description;
    public static volatile SingularAttribute<Tour, Boolean> active;
    public static volatile SingularAttribute<Tour, Long> priceAdult;
    public static volatile SingularAttribute<Tour, Long> priceChild;
    public static volatile SingularAttribute<Tour, String> name;
    public static volatile SingularAttribute<Tour, Integer> limit;
    public static volatile SetAttribute<Tour, Booking> bookingSet;
    public static volatile SingularAttribute<Tour, Integer> id;
    public static volatile SingularAttribute<Tour, Date> startDate;
    public static volatile SingularAttribute<Tour, Category> categoryId;

}