package api.enums;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

/**
 * @author codenozzle
 *
 */
@ApiModel(description="Enumeration")
public class EnumEntity {

	@ApiModelProperty(value = "ID", position = 1)
    private Integer id;
	
	@ApiModelProperty(value = "Name", position = 2)
    private String name;
	
	public EnumEntity() {
		
	}
	
	public EnumEntity(Integer id, String name) {
		this.id = id;
		this.name = name;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}
	
	
}
