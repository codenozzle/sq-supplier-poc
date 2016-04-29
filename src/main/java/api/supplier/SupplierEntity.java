package api.supplier;

import java.util.ArrayList;
import java.util.Collection;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

/**
 * @author codenozzle
 *
 */
@ApiModel(description="Supplier")
public class SupplierEntity {
	
	@ApiModelProperty(value = "ID", position = 1)
    private Long id;
	
	@ApiModelProperty(value = "Supplier name", position = 2)
    private String supplierName;
	
	@ApiModelProperty(value = "Doing business as", position = 3)
    private String dba;
	
	@ApiModelProperty(value = "Other names", position = 4)
    private String otherNames;
	
	@ApiModelProperty(value = "Country of origin", position = 5)
    private Integer countryOfOriginId;
	
	@ApiModelProperty(value = "Supplier number", position = 6)
    private String supplierNumber;
	
	@ApiModelProperty(value = "Third party number", position = 7)
    private String thirdPartyNumber;
	
	@ApiModelProperty(value = "Legal structure", position = 8)
    private Integer legalStructureId;
	
	@ApiModelProperty(value = "Tax ID type", position = 9)
    private Integer taxIdTypeId;
	
	@ApiModelProperty(value = "Tax ID number", position = 10)
    private String taxIdNumber;
	
	@ApiModelProperty(value = "VAT registration number", position = 11)
    private String vatRegistrationNumber;
	
	public SupplierEntity() {
		
	}
	
	public SupplierEntity(long id, String supplierName, String dba, String otherNames, Integer countryOfOriginId,
			String supplierNumber, String thirdPartyNumber, Integer legalStructureId, Integer taxIdTypeId, 
			String taxIdNumber, String vatRegistrationNumber) {
        this.id = id;
        this.supplierName = supplierName;
        this.dba = dba;
        this.otherNames = otherNames;
        this.countryOfOriginId = countryOfOriginId;
        this.supplierNumber = supplierNumber;
        this.thirdPartyNumber = thirdPartyNumber;
        this.legalStructureId = legalStructureId;
        this.taxIdTypeId = taxIdTypeId;
        this.taxIdNumber = taxIdNumber;
        this.vatRegistrationNumber = vatRegistrationNumber;
    }
    
    public SupplierEntity(Supplier supplier) {
    	this.id = supplier.getId();
        this.supplierName = supplier.getSupplierName();
        this.dba = supplier.getDba();
        this.otherNames = supplier.getOtherNames();
        this.countryOfOriginId = supplier.getCountryOfOriginId();
        this.supplierNumber = supplier.getSupplierNumber();
        this.thirdPartyNumber = supplier.getThirdPartyNumber();
        this.legalStructureId = supplier.getLegalStructureId();
        this.taxIdTypeId = supplier.getTaxIdTypeId();
        this.taxIdNumber = supplier.getTaxIdNumber();
        this.vatRegistrationNumber = supplier.getVatRegistrationNumber();
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

	public Integer getCountryOfOriginId() {
		return countryOfOriginId;
	}

	public void setCountryOfOriginId(Integer countryOfOriginId) {
		this.countryOfOriginId = countryOfOriginId;
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

	public void setTaxIdTypeId(Integer taxIdTypeId) {
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
