package com.matchApp.enitity;

import org.hibernate.annotations.Generated;
import org.hibernate.annotations.GenerationTime;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import java.io.Serializable;
import java.sql.Date;
import java.sql.Time;

@Entity
@Table(name = "VolleyballMatch")

public class VolleyballMatch implements Serializable {

    @Id
    @Column(name = "id", columnDefinition = "serial")
    @Generated(GenerationTime.INSERT)
    private Integer id;

    @Column(name = "owner_id", nullable = false, unique = true)
    private Integer owner_id;

    @Column(name = "location", nullable = false)
    private String location;

    @Column(name = "cost", nullable = false)
    private Double cost;

    @Column(name = "level", nullable = false)
    private String level;

    @Column(name = "time", nullable = false)
    private Time time;

    @Column(name = "date", nullable = false)
    private Date date;

    @Column(name = "description", nullable = false)
    private String description;

    @Column(name = "slots", nullable = false)
    private Integer slots;

    @Column(name = "sex", nullable = false)
    private Sex sex;

    public enum Sex {
        male {
            @Override
            public String toString() {
                return "male";
            }
        },
        female {
            @Override
            public String toString() {
                return "female";
            }
        },
        mixed {
            @Override
            public String toString() {
                return "mixed";
            }
        }

    }


    public VolleyballMatch(Integer id, Integer owner_id, String location, Double cost, String level,Time time, Date date, String description, Integer slots, Sex sex) {
        this.id = id;
        this.owner_id = owner_id;
        this.location = location;
        this.cost = cost;
        this.level = level;
        this.time = time;
        this.date = date;
        this.description = description;
        this.slots = slots;
        this.sex = sex;
    }


    public VolleyballMatch() {
        this.id = 0;
        this.owner_id = 0;
        this.location = "null";
        this.cost = 0.0;
        this.level = "none";
        this.date=Date.valueOf("2000-01-01");
        this.time=new Time(00,00,00);
        this.description = "none";
        this.slots = 0;
        this.sex = Sex.male
        ;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getOwner_id() {
        return owner_id;
    }

    public void setOwner_id(Integer owner_id) {
        this.owner_id = owner_id;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public Double getCost() {
        return cost;
    }

    public void setCost(Double cost) {
        this.cost = cost;
    }

    public String getLevel() {
        return level;
    }

    public void setLevel(String level) {
        this.level = level;
    }


    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Integer getSlots() {
        return slots;
    }

    public void setSlots(Integer slots) {
        this.slots = slots;
    }

    public Sex getSex() {
        return sex;
    }

    public void setSex(Sex sex) {
        this.sex = sex;
    }

    public Time getTime() {
        return time;
    }

    public void setTime(Time time) {
        this.time = time;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }
}

