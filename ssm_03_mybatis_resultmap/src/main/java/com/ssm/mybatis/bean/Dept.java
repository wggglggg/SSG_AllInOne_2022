package com.ssm.mybatis.bean;

import java.util.List;

/**
 * ClassName: Dept
 * Description:
 *
 * @Author wggglggg
 * @Create 2023/8/2 14:47
 * @Version 1.0
 */
public class Dept {
    private Integer deptId;
    private String deptName;

    private List<Emp> empList;

    public Dept() {
    }

    public Dept(Integer deptId, String deptName, List<Emp> empList) {
        this.deptId = deptId;
        this.deptName = deptName;
        this.empList = empList;
    }

    public Integer getDeptId() {
        return deptId;
    }

    public void setDeptId(Integer deptId) {
        this.deptId = deptId;
    }

    public String getDeptName() {
        return deptName;
    }

    public void setDeptName(String deptName) {
        this.deptName = deptName;
    }

    public List<Emp> getEmpList() {
        return empList;
    }

    public void setEmpList(List<Emp> empList) {
        this.empList = empList;
    }

    @Override
    public String toString() {
        return "Dept{" +
                "deptId=" + deptId +
                ", deptName='" + deptName + '\'' +
                ", empList=" + empList +
                '}';
    }
}
