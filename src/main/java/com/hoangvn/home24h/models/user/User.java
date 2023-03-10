package com.hoangvn.home24h.models.user;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

import javax.persistence.*;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotNull;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.hoangvn.home24h.models.post.BaiDang;

@Entity
@Table(name = "users")
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    @Column(name = "ho_ten")
    @NotNull(message = "Ho ten thieu!")
    private String hoTen;

    @Column(name = "so_dien_thoai", unique = true)
    private String soDienThoai;

    @Column(name = "email", unique = true)
    @Email(message = "Email chưa đúng hoặc đã tồn tại")
    private String email;

    @Column(name = "dia_chi")
    private String diaChi;

    @Column(name = "user_name", unique = true)
    private String username;

    private String password;

    @ManyToMany(cascade = CascadeType.REFRESH)
    @JoinTable(name = "user_role", joinColumns = { @JoinColumn(name = "user_id") }, inverseJoinColumns = {
            @JoinColumn(name = "role_id") })
    @JsonIgnore
    private Set<Role> role = new HashSet<>();

    @OneToMany(mappedBy = "user", cascade = CascadeType.ALL)
    @JsonIgnore
    private List<BaiDang> cacBaiDang;

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getHoTen() {
        return hoTen;
    }

    public void setHoTen(String hoTen) {
        this.hoTen = hoTen;
    }

    public String getSoDienThoai() {
        return soDienThoai;
    }

    public void setSoDienThoai(String soDienThoai) {
        this.soDienThoai = soDienThoai;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getDiaChi() {
        return diaChi;
    }

    public void setDiaChi(String diaChi) {
        this.diaChi = diaChi;
    }

    public void setId(long id) {
        this.id = id;
    }

    public List<BaiDang> getCacBaiDang() {
        return cacBaiDang;
    }

    public void setCacBaiDang(List<BaiDang> cacBaiDang) {
        this.cacBaiDang = cacBaiDang;
    }

    public Set<Role> getRole() {
        return role;
    }

    public void setRole(Set<Role> role) {
        this.role = role;
    }

}
