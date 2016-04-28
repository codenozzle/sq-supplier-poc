package api.enums;

import java.util.ArrayList;
import java.util.Collection;

/**
 * @author codenozzle
 *
 */
public enum LegalStructureEnum {

	INDIVIDUAL_SOLE_PROPRIETOR(1, "Individual/Sole Proprietor"), 
	C_CORPORATION(2, "C Corporation"),
	S_CORPORATION(3, "S Corporation"),
	PARTNERSHIP(4, "Partnership"),
	OTHER(5, "Other");

	private final Integer id;
    private final String name;
    
    LegalStructureEnum(Integer id, String name) {
        this.id = id;
        this.name = name;
    }
    
    public Integer getId() { 
    	return id; 
    }
    
    public String getName() { 
    	return name; 
    }
    
	public static LegalStructureEnum getEnum(Integer id) {
		for (LegalStructureEnum value : values()) {
			if (value.getId().equals(id)) {
				return value;
			}
		}
		throw new IllegalArgumentException();
	}

	public static Collection<EnumEntity> getValues() {
		Collection<EnumEntity> values = new ArrayList<>();
		for (LegalStructureEnum value : values()) {
			values.add(new EnumEntity(value.getId(), value.getName()));
		}
		return values;
	}
}
