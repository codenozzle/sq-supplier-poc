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
	public @ResponseBody SupplierEntity createAmmo(@RequestBody SupplierEntity supplierEntity) {
		Supplier supplier = new Supplier(
			supplierEntity.getName(),
			supplierEntity.getUrl()
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
			supplierEntity.getName(),
			supplierEntity.getUrl()
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
		if (!ApiUtils.isEqual(supplier.getName(), supplierEntity.getName(), true)) {
			supplier.setName(supplierEntity.getName());
		}
		if (!ApiUtils.isEqual(supplier.getUrl(), supplierEntity.getUrl(), true)) {
			supplier.setUrl(supplierEntity.getUrl());
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
	
}
