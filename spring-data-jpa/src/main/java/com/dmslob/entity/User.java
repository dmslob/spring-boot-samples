package com.dmslob.entity;

import javax.persistence.*;

import org.joda.time.DateTime;
import org.joda.time.LocalDate;

@Entity
@Table(name = "USERS")
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "ID")
    private long id;

    // Mapped as DATETIME (on MySQL)
    // For JSON binding use the format: "1970-01-01T00:00:00.000+0000"
    // @Type(type = "org.jadira.usertype.dateandtime.joda.PersistentDateTime")
    @Column(name = "CREATE_DATE")
    private DateTime createTime;

    // Mapped as DATE (on MySQL)
    // For JSON binding use the format: "1970-01-01" (yyyy-MM-dd)
    // @Type(type = "org.jadira.usertype.dateandtime.joda.PersistentLocalDate")
    @Column(name = "BIRTHDAY_DATE")
    private LocalDate birthdayDate;

    public long getId() {
        return id;
    }

    public DateTime getCreateTime() {
        return createTime;
    }

    public LocalDate getBirthdayDate() {
        return birthdayDate;
    }

    public void setId(long id) {
        this.id = id;
    }

    public void setCreateTime(DateTime createTime) {
        this.createTime = createTime;
    }

    public void setBirthdayDate(LocalDate birthdayDate) {
        this.birthdayDate = birthdayDate;
    }
}
