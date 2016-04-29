package api.enums;

import java.util.ArrayList;
import java.util.Collection;

public enum CountryOfOriginEnum {

	US(1, "United States"),
	CN(2, "China"), 
	DE(3, "Germany"), 
	JP(4, "Japan"), 
	SK(5, "South Korea"), 
	SZ(6, "Switzerland"), 
	UK(7, "United Kingdom");

	private final Integer id;
    private final String name;
    
    CountryOfOriginEnum(Integer id, String name) {
        this.id = id;
        this.name = name;
    }
    
    public Integer getId() { 
    	return id; 
    }
    
    public String getName() { 
    	return name; 
    }
    
	public static CountryOfOriginEnum getEnum(Integer id) {
		for (CountryOfOriginEnum value : values()) {
			if (value.getId().equals(id)) {
				return value;
			}
		}
		throw new IllegalArgumentException();
	}

	public static Collection<EnumEntity> getValues() {
		Collection<EnumEntity> values = new ArrayList<>();
		for (CountryOfOriginEnum value : values()) {
			values.add(new EnumEntity(value.getId(), value.getName()));
		}
		return values;
	}
}
