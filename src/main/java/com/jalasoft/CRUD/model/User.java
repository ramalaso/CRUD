/**
 * Copyright (c) 2019 Jalasoft.
 *
 * This software is the confidential and proprietary information of Jalasoft.
 * ("Confidential Information"). You shall not
 * disclose such Confidential Information and shall use it only in
 * accordance with the terms of the license agreement you entered into
 * with Jalasoft.
 */
package com.jalasoft.CRUD.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

/**
 * User model for using in our controller
 *
 * @author Raul Laredo on 10/13/2019.
 * @version v1.0
 */
@AllArgsConstructor
@NoArgsConstructor
@Data
@Entity
public class User {
    /**
     * Data params of user
     */
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
    private String email;
    private String phone;

    /**
     * Gets user's name
     * @return name
     */
    public String getName() {
        return name;
    }

    /**
     * Sets user's name
     * @param name of user
     */
    public void setName(String name) {
        this.name = name;
    }

    /**
     * Gets user's email
     * @return email
     */
    public String getEmail() {
        return email;
    }

    /**
     * Sets user's email
     * @param email of user
     */
    public void setEmail(String email) {
        this.email = email;
    }

    /**
     * Gets user's phone
     * @return phone
     */
    public String getPhone() {
        return phone;
    }

    /**
     * Sets user's phone
     * @param phone of user
     */
    public void setPhone(String phone) {
        this.phone = phone;
    }

    /**
     * Gets user's id
     * @return id
     */
    public Long getId() {
        return id;
    }

    /**
     * Sets user's id
     * @param id of user
     */
    public void setId(Long id) {
        this.id = id;
    }
}
