package com.hn.pojo;

import com.hn.pojo.User;
import java.util.Date;
import javax.annotation.Generated;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="EclipseLink-2.7.10.v20211216-rNA", date="2022-12-14T16:15:51")
@StaticMetamodel(News.class)
public class News_ { 

    public static volatile SingularAttribute<News, Integer> quantityLike;
    public static volatile SingularAttribute<News, Integer> quantityView;
    public static volatile SingularAttribute<News, Integer> id;
    public static volatile SingularAttribute<News, Date> updatedDate;
    public static volatile SingularAttribute<News, String> title;
    public static volatile SingularAttribute<News, String> contentl;
    public static volatile SingularAttribute<News, User> userId;
    public static volatile SingularAttribute<News, Date> postedDate;

}