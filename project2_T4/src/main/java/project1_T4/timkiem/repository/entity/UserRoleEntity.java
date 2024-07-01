//package project1_T4.timkiem.repository.entity;
//
//import java.sql.Timestamp;
//
//import javax.persistence.Column;
//import javax.persistence.Entity;
//import javax.persistence.GeneratedValue;
//import javax.persistence.GenerationType;
//import javax.persistence.Id;
//import javax.persistence.JoinColumn;
//import javax.persistence.ManyToOne;
//import javax.persistence.Table;
//
//@Entity
//@Table(name = "user_role")
//public class UserRoleEntity {
//	@Id
//    @GeneratedValue(strategy = GenerationType.IDENTITY)
//    @Column(name = "id")
//    private Long id;
//
//    @ManyToOne
//    @JoinColumn(name = "roleid")
//    private RoleEntity role;
//    
//    @ManyToOne
//    @JoinColumn(name = "userid")
//    private UserEntity user;
//
//    @Column(name = "createddate")
//    private Timestamp createdDate;
//
//    @Column(name = "modifieddate")
//    private Timestamp modifiedDate;
//
//    @Column(name = "createdby", length = 255)
//    private String createdBy;
//
//    @Column(name = "modifiedby", length = 255)
//    private String modifiedBy;
//
//    // Getters and Setters
//    public Long getId() {
//        return id;
//    }
//
//    public void setId(Long id) {
//        this.id = id;
//    }
//
//
//    public Timestamp getCreatedDate() {
//        return createdDate;
//    }
//
//    public void setCreatedDate(Timestamp createdDate) {
//        this.createdDate = createdDate;
//    }
//
//    public Timestamp getModifiedDate() {
//        return modifiedDate;
//    }
//
//    public void setModifiedDate(Timestamp modifiedDate) {
//        this.modifiedDate = modifiedDate;
//    }
//
//    public String getCreatedBy() {
//        return createdBy;
//    }
//
//    public void setCreatedBy(String createdBy) {
//        this.createdBy = createdBy;
//    }
//
//    public String getModifiedBy() {
//        return modifiedBy;
//    }
//
//    public void setModifiedBy(String modifiedBy) {
//        this.modifiedBy = modifiedBy;
//    }
//}
