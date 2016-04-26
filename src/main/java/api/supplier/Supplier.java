package api.supplier;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * @author codenozzle
 *
 */
@Entity
@Table(name = "supplier")
public final class Supplier {
	
	@Id
    @GeneratedValue(strategy=GenerationType.AUTO)
    private long id;
    private String name;
    private String url;
    
    protected Supplier() {
    	
    }
    
    public Supplier(String name, String url) {
    	this.name = name;
    	this.url = url;
    }
    
	public long getId() {
		return id;
	}
	public void setId(long id) {
		this.id = id;
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
	
	@Override
    public String toString() {
        return String.format("Supplier[id=%d, name='%s']", id, name);
    }

}
