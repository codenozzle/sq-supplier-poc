package api.enums;

import java.util.ArrayList;
import java.util.Collection;

/**
 * @author codenozzle
 *
 */
public enum TaxIdTypeEnum {

	FEDERAL_ID(1, "Federal ID"), 
	SSN(2, "SSN");

	private final Integer id;
    private final String name;
    
    TaxIdTypeEnum(Integer id, String name) {
        this.id = id;
        this.name = name;
    }
    
    public Integer getId() { 
    	return id; 
    }
    
    public String getName() { 
    	return name; 
    }
    
	public static TaxIdTypeEnum getEnum(Integer id) {
		for (TaxIdTypeEnum value : values()) {
			if (value.getId().equals(id)) {
				return value;
			}
		}
		throw new IllegalArgumentException();
	}

	public static Collection<EnumEntity> getValues() {
		Collection<EnumEntity> values = new ArrayList<>();
		for (TaxIdTypeEnum value : values()) {
			values.add(new EnumEntity(value.getId(), value.getName()));
		}
		return values;
	}
}
