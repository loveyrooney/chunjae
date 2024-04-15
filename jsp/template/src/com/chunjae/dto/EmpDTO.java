package com.chunjae.dto;

public class EmpDTO {
    private int empId;
    private String first_name;

    public EmpDTO(int empId, String first_name) {
        this.empId = empId;
        this.first_name = first_name;
    }

    public int getEmpId() {
        return empId;
    }

    public void setEmpId(int empId) {
        this.empId = empId;
    }

    public String getFirst_name() {
        return first_name;
    }

    public void setFirst_name(String first_name) {
        this.first_name = first_name;
    }
}
