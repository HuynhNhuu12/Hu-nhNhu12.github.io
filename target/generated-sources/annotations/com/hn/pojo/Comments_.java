package com.hn.pojo;

import com.hn.pojo.Tour;
import com.hn.pojo.User;
import java.util.Date;
import javax.annotation.Generated;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="EclipseLink-2.7.10.v20211216-rNA", date="2022-12-14T16:15:51")
@StaticMetamodel(Comments.class)
public class Comments_ { 

    public static volatile SingularAttribute<Comments, Date> createdDate;
    public static volatile SingularAttribute<Comments, Tour> tourId;
    public static volatile SingularAttribute<Comments, Integer> id;
    public static volatile SingularAttribute<Comments, User> userId;
    public static volatile SingularAttribute<Comments, String> content;

}