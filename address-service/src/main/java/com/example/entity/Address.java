package com.example.entity;

import jakarta.persistence.*;

//@NamedStoredProcedureQueries(
//        @NamedStoredProcedureQuery(name = "",
//                        procedureName = "",
//                        parameters = {
//                            @StoredProcedureParameter(mode = ParameterMode.IN, name="name",  type= Integer.class)
//                        }))
@Entity
public class Address {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column(name = "lane1")
    private String lane1;

    @Column(name = "lane2")
    private String lane2;

    @Column(name = "zip")
    private int zip;

    @Column(name = "emp_id")
    private int employeeId;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getLane1() {
        return lane1;
    }

    public void setLane1(String lane1) {
        this.lane1 = lane1;
    }

    public String getLane2() {
        return lane2;
    }

    public void setLane2(String lane2) {
        this.lane2 = lane2;
    }

    public int getZip() {
        return zip;
    }

    public void setZip(int zip) {
        this.zip = zip;
    }

    public int getEmployeeId() {
        return employeeId;
    }

    public void setEmployeeId(int employeeId) {
        this.employeeId = employeeId;
    }

}
