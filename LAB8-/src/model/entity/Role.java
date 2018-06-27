package model.entity;


import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.TimeZone;

import javax.jdo.annotations.IdGeneratorStrategy;
import javax.jdo.annotations.IdentityType;
import javax.jdo.annotations.PersistenceCapable;
import javax.jdo.annotations.Persistent;
import javax.jdo.annotations.PrimaryKey;

@PersistenceCapable(identityType = IdentityType.APPLICATION)
public class Role {
    @PrimaryKey
    @Persistent(valueStrategy = IdGeneratorStrategy.IDENTITY) private Long id;
    @Persistent private String name;
    @Persistent private Date date;
    @Persistent private boolean state;

    public Role (String name,Date date, boolean state) {
    	
        this.name = name;
        this.date= date;
        this.state = state;
        
    }

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getNombre() {
		return name;
	}

	public void setNombre(String name) {
		this.name = name;
	}

	public Date getFecha() {
		return date;
	}

	public void setFecha(Date date) {
		this.date = date;
	}

	public boolean isEstado() {
		return state;
	}

	public void setEstado(boolean state) {
		this.state = state;
	}
    public String estadoDescripcion(){
    	if(state)
    		return "true";
    	return "false";
    }
    public String fechaDescripcion(){
    	
    	SimpleDateFormat format=new SimpleDateFormat("dd MMMM 'del' YYYY  HH:mm:s ");
        format.setTimeZone(TimeZone.getTimeZone("America/Lima"));
        return format.format(date);
    }
    
}