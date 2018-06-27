/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model.entity;

import javax.jdo.annotations.IdGeneratorStrategy;
import javax.jdo.annotations.IdentityType;
import javax.jdo.annotations.PersistenceCapable;
import javax.jdo.annotations.Persistent;
import javax.jdo.annotations.PrimaryKey;

@PersistenceCapable(identityType = IdentityType.APPLICATION)
public class Usuario {
    @PrimaryKey
    @Persistent(valueStrategy = IdGeneratorStrategy.IDENTITY) private Long id;
    @Persistent private String name;
    @Persistent private String lastName;
    @Persistent private String email;
    @Persistent private Long idRol;
    @Persistent private boolean state;
    public Usuario(String name, String lastName, String email,Long idRol,boolean state) {
    	
        this.name = name;
        this.lastName = lastName;
        this.email = email;
        this.state = state;
        this.idRol = idRol;
    
    }
    public void setIdRol(Long idRol){
    	this.idRol = idRol;
    }
    public Long getIdRol(){
    	return idRol;
    }
    public boolean getState() {
		return state;
	}

	public void setEstado(boolean estado) {
		this.state = estado;
	}

	public Long getCodigo() {
        return id;
    }
    public String getName() {
        return name;
    }

    public void seName(String name) {
        this.name = name;
    }

    public String getLasName() {
        return lastName;
    }

    public void setApellido(String apellidos) {
        this.lastName = apellidos;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }
    public String State(){
    	if(state)
    		return "ACTIVO";
    	return "INACTIVO";
    }
    
    
    
}