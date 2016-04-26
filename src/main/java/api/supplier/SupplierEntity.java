package api.supplier;

import java.util.ArrayList;
import java.util.Collection;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

/**
 * @author codenozzle
 *
 */
@ApiModel(description="Supplier of ammunition")
public class SupplierEntity {
	
	@ApiModelProperty(value = "ID", position = 1)
    private Long id;
	
	@ApiModelProperty(value = "Name", position = 2)
    private String name;
	
	@ApiModelProperty(value = "Website URL", position = 3)
    private String url;
	
	public SupplierEntity() {
		
	}
	
	public SupplierEntity(long id, String name, String url) {
        this.id = id;
        this.name = name;
        this.url = url;
    }
    
    public SupplierEntity(Supplier supplier) {
    	this.id = supplier.getId();
        this.name = supplier.getName();
        this.url = supplier.getUrl();
	}
    
    public static Collection<SupplierEntity> get(Iterable<Supplier> suppliers) {
		Collection<SupplierEntity> supplierEntities = new ArrayList<>();
    	for (Supplier supplier : suppliers) {
    		supplierEntities.add(new SupplierEntity(supplier));
		}
		return supplierEntities;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
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

}
