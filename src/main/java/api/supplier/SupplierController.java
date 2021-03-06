package api.supplier;

import java.util.Collection;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import api.core.ApiUtils;
import api.enums.CountryOfOriginEnum;
import api.enums.EnumEntity;
import api.enums.LegalStructureEnum;
import api.enums.TaxIdTypeEnum;

/**
 * @author codenozzle
 *
 */
@Controller
@RequestMapping(value = "/api/supplier", produces = "application/json")
@Api(value = "Supplier", tags = { "Supplier" })
public class SupplierController {

	@Autowired
	SupplierRepository repository;

	@RequestMapping(method = RequestMethod.GET)
	@ApiOperation(value = "Get a list of all Suppliers")
	public @ResponseBody Collection<SupplierEntity> getAllSuppliers() {
		return SupplierEntity.get(repository.findAll());
	}
	
	@RequestMapping(method = RequestMethod.GET, value = "/{id}")
	@ApiOperation(value = "Gets a single Supplier")
	public @ResponseBody ResponseEntity<SupplierEntity> getSupplier(@PathVariable Long id) {
		if (!repository.exists(id)) {
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}
		return new ResponseEntity<>(new SupplierEntity(repository.findOne(id)), HttpStatus.OK);
	}
	
	@RequestMapping(method = RequestMethod.POST)
	@ApiOperation(value = "Add a single Supplier")
	public @ResponseBody SupplierEntity createSupplier(@RequestBody SupplierEntity supplierEntity) {
		Supplier supplier = new Supplier(
			supplierEntity.getSupplierName(),
			supplierEntity.getDba(),
			supplierEntity.getOtherNames(),
			supplierEntity.getCountryOfOriginId(),
			supplierEntity.getSupplierNumber(),
			supplierEntity.getThirdPartyNumber(),
			supplierEntity.getLegalStructureId(),
			supplierEntity.getTaxIdTypeId(),
			supplierEntity.getTaxIdNumber(),
			supplierEntity.getVatRegistrationNumber()
		);
		return new SupplierEntity(repository.save(supplier));
	}
	
	@RequestMapping(method = RequestMethod.PUT, value = "/{id}")
	@ApiOperation(value = "Overwrite a single Supplier")
	public @ResponseBody ResponseEntity<SupplierEntity> overwriteSupplier(@PathVariable Long id, @RequestBody SupplierEntity supplierEntity) {
		if (!repository.exists(id)) {
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}
		Supplier supplier = new Supplier(
			supplierEntity.getSupplierName(),
			supplierEntity.getDba(),
			supplierEntity.getOtherNames(),
			supplierEntity.getCountryOfOriginId(),
			supplierEntity.getSupplierNumber(),
			supplierEntity.getThirdPartyNumber(),
			supplierEntity.getLegalStructureId(),
			supplierEntity.getTaxIdTypeId(),
			supplierEntity.getTaxIdNumber(),
			supplierEntity.getVatRegistrationNumber()
		);
		supplier.setId(id);
		repository.save(supplier);
		return new ResponseEntity<>(new SupplierEntity(supplier), HttpStatus.OK);
	}
	
	@RequestMapping(method = RequestMethod.PATCH, value = "/{id}")
	@ApiOperation(value = "Update a single Supplier")
	public @ResponseBody ResponseEntity<SupplierEntity> updateSupplier(@PathVariable Long id, @RequestBody SupplierEntity supplierEntity) {
		if (!repository.exists(id)) {
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}
		Supplier supplier = repository.findOne(id);
		
		// Merge the Supplier Entity into the Supplier
		if (!ApiUtils.isEqual(supplier.getSupplierName(), supplierEntity.getSupplierName(), true)) {
			supplier.setSupplierName(supplierEntity.getSupplierName());
		}
		if (!ApiUtils.isEqual(supplier.getDba(), supplierEntity.getDba(), true)) {
			supplier.setDba(supplierEntity.getDba());
		}
		if (!ApiUtils.isEqual(supplier.getOtherNames(), supplierEntity.getOtherNames(), true)) {
			supplier.setOtherNames(supplierEntity.getOtherNames());
		}
		if (!ApiUtils.isEqual(supplier.getCountryOfOriginId(), supplierEntity.getCountryOfOriginId(), true)) {
			supplier.setCountryOfOriginId(supplierEntity.getCountryOfOriginId());
		}
		if (!ApiUtils.isEqual(supplier.getSupplierNumber(), supplierEntity.getSupplierNumber(), true)) {
			supplier.setSupplierNumber(supplierEntity.getSupplierNumber());
		}
		if (!ApiUtils.isEqual(supplier.getThirdPartyNumber(), supplierEntity.getThirdPartyNumber(), true)) {
			supplier.setThirdPartyNumber(supplierEntity.getThirdPartyNumber());
		}
		if (!ApiUtils.isEqual(supplier.getLegalStructureId(), supplierEntity.getLegalStructureId(), true)) {
			supplier.setLegalStructureId(supplierEntity.getLegalStructureId());
		}
		if (!ApiUtils.isEqual(supplier.getTaxIdTypeId(), supplierEntity.getTaxIdTypeId(), true)) {
			supplier.setTaxIdType(supplierEntity.getTaxIdTypeId());
		}
		if (!ApiUtils.isEqual(supplier.getTaxIdNumber(), supplierEntity.getTaxIdNumber(), true)) {
			supplier.setTaxIdNumber(supplierEntity.getTaxIdNumber());
		}
		if (!ApiUtils.isEqual(supplier.getVatRegistrationNumber(), supplierEntity.getVatRegistrationNumber(), true)) {
			supplier.setVatRegistrationNumber(supplierEntity.getVatRegistrationNumber());
		}
		
		repository.save(supplier);
		return new ResponseEntity<>(new SupplierEntity(supplier), HttpStatus.OK);
	}

	@RequestMapping(method = RequestMethod.DELETE, value = "/{id}")
	@ApiOperation(value = "Delete a single Supplier")
	public @ResponseBody ResponseEntity<SupplierEntity> deleteSupplier(@PathVariable Long id) {
		if (!repository.exists(id)) {
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}
		Supplier supplier = repository.findOne(id);
		repository.delete(id);
		return new ResponseEntity<>(new SupplierEntity(supplier), HttpStatus.OK);
	}
	
	@RequestMapping(method = RequestMethod.GET, value = "/legalStructures")
	@ApiOperation(value = "Get Legal Structure options")
	public @ResponseBody Collection<EnumEntity> getLegalStructures() {
		return LegalStructureEnum.getValues();
	}
	
	@RequestMapping(method = RequestMethod.GET, value = "/taxIdTypes")
	@ApiOperation(value = "Get Tax ID Type options")
	public @ResponseBody Collection<EnumEntity> getTaxIdTypes() {
		return TaxIdTypeEnum.getValues();
	}
	
	@RequestMapping(method = RequestMethod.GET, value = "/countryOfOrigins")
	@ApiOperation(value = "Get Country of Origin options")
	public @ResponseBody Collection<EnumEntity> getCountryOfOrigins() {
		return CountryOfOriginEnum.getValues();
	}
	
}
