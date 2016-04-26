package api.enums;

import java.util.ArrayList;
import java.util.Collection;

public enum InStockEnum {
	
	YES(1, "Yes"), NO(2, "No");

	private final Integer id;
    private final String name;
    
    InStockEnum(Integer id, String name) {
        this.id = id;
        this.name = name;
    }
    
    public Integer getId() { 
    	return id; 
    }
    
    public String getName() { 
    	return name; 
    }
    
	public static InStockEnum getEnum(Integer id) {
		for (InStockEnum value : values()) {
			if (value.getId().equals(id)) {
				return value;
			}
		}
		throw new IllegalArgumentException();
	}

	public static Collection<EnumEntity> getValues() {
		Collection<EnumEntity> values = new ArrayList<>();
		for (InStockEnum value : values()) {
			values.add(new EnumEntity(value.getId(), value.getName()));
		}
		return values;
	}
}
