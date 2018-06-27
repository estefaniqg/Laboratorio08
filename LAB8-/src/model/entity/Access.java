package model.entity;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

import javax.jdo.PersistenceManager;

import javax.jdo.annotations.IdGeneratorStrategy;
import javax.jdo.annotations.IdentityType;
import javax.jdo.annotations.PersistenceCapable;
import javax.jdo.annotations.Persistent;
import javax.jdo.annotations.PrimaryKey;

import controller.users.PMF;
import model.entity.Resource;
import model.entity.Role;

@PersistenceCapable(identityType = IdentityType.APPLICATION)
public class Access {
    @PrimaryKey
    @Persistent(valueStrategy = IdGeneratorStrategy.IDENTITY) private Long id;
    @Persistent private Long idRole;
    @Persistent private Long idResource;
    @Persistent private boolean state;
    @Persistent private String name;
    @Persistent private String url;

    public  Access (Long idRole,Long idResource, boolean state) {
        this.idRole = idRole;
        this.idResource = idResource;
        this.state = state;
        
    }
	
    public Access(Long id2, String name, String url, boolean state2) {
		this.id=id2;
		this.name=name;
		this.url=url;
		this.state=state2;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getUrl() {
		return url;
	}

	public void setUrl(String url) {
		this.url = url;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Long getIdRole() {
		return idRole;
	}

	public void setIdRole(Long idRole) {
		this.idRole = idRole;
	}

	public Long getIdResource() {
		return idResource;
	}

	public void setIdResource(Long idRecurso) {
		this.idResource = idRecurso;
	}

	public boolean getState() {
		return state;
	}

	public void setState(boolean state) {
		this.state = state;
	}

	public String State(){
    	if(state)
    		return "true";
    	return "false";
    }

}