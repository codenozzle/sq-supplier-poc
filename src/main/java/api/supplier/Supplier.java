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
	private String supplierName;
    private String dba;
    private String otherNames;
    private String countryOfOrigin;
    private String supplierNumber;
    private String thirdPartyNumber;
    private Integer legalStructureId;
    private Integer taxIdTypeId;
    private String taxIdNumber;
    private String vatRegistrationNumber;
    
    protected Supplier() {
    	
    }
    
    public Supplier(String supplierName, String dba, String otherNames, String countryOfOrigin,
			String supplierNumber, String thirdPartyNumber, Integer legalStructure, 
			Integer taxIdType, String taxIdNumber, String vatRegistrationNumber) {
        this.supplierName = supplierName;
        this.dba = dba;
        this.otherNames = otherNames;
        this.countryOfOrigin = countryOfOrigin;
        this.supplierNumber = supplierNumber;
        this.thirdPartyNumber = thirdPartyNumber;
        this.legalStructureId = legalStructure;
        this.taxIdTypeId = taxIdType;
        this.taxIdNumber = taxIdNumber;
        this.vatRegistrationNumber = vatRegistrationNumber;
    }
	
	@Override
    public String toString() {
        return String.format("Supplier[id=%d, name='%s']", id, supplierName);
    }

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getSupplierName() {
		return supplierName;
	}

	public void setSupplierName(String supplierName) {
		this.supplierName = supplierName;
	}

	public String getDba() {
		return dba;
	}

	public void setDba(String dba) {
		this.dba = dba;
	}

	public String getOtherNames() {
		return otherNames;
	}

	public void setOtherNames(String otherNames) {
		this.otherNames = otherNames;
	}

	public String getCountryOfOrigin() {
		return countryOfOrigin;
	}

	public void setCountryOfOrigin(String countryOfOrigin) {
		this.countryOfOrigin = countryOfOrigin;
	}

	public String getSupplierNumber() {
		return supplierNumber;
	}

	public void setSupplierNumber(String supplierNumber) {
		this.supplierNumber = supplierNumber;
	}

	public String getThirdPartyNumber() {
		return thirdPartyNumber;
	}

	public void setThirdPartyNumber(String thirdPartyNumber) {
		this.thirdPartyNumber = thirdPartyNumber;
	}

	public Integer getLegalStructureId() {
		return legalStructureId;
	}

	public void setLegalStructureId(Integer legalStructureId) {
		this.legalStructureId = legalStructureId;
	}

	public Integer getTaxIdTypeId() {
		return taxIdTypeId;
	}

	public void setTaxIdType(Integer taxIdTypeId) {
		this.taxIdTypeId = taxIdTypeId;
	}

	public String getTaxIdNumber() {
		return taxIdNumber;
	}

	public void setTaxIdNumber(String taxIdNumber) {
		this.taxIdNumber = taxIdNumber;
	}

	public String getVatRegistrationNumber() {
		return vatRegistrationNumber;
	}

	public void setVatRegistrationNumber(String vatRegistrationNumber) {
		this.vatRegistrationNumber = vatRegistrationNumber;
	}

}
