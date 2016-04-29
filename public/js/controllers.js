angular.module('controllers', ['chart.js'])

// Controller for displaying the Dashboard
.controller("DashboardController", function (SupplierService) {
	var dashboard = this;
	
	var legalStructureMap = new Map();
	dashboard.legalStructureHeading = 'Suppliers by Legal Structure';
	dashboard.legalStructureLabels = [];
	dashboard.legalStructureData = [];
	
	var countryMap = new Map();
	dashboard.countryHeading = 'Suppliers by Country';
	dashboard.countryLabels = [];
	dashboard.countryData = [];
	
	// Fetch all of the data for Suppliers, Legal Structures, and Country of Origins
	SupplierService.fetchChartData().then(function(data) {
		// Count the Legal Structures and Country of Origins by Supplier
		angular.forEach(data.suppliers, function (supplier) {
			// Count the Legal Structures
			if (!legalStructureMap.has(supplier.legalStructureId)) {
				legalStructureMap.set(supplier.legalStructureId, {
					name: data.legalStructures[supplier.legalStructureId-1].name,
					count: 0
				});
			}
			legalStructureMap.get(supplier.legalStructureId).count++;
			
			// Count Country of Origins
			if (!countryMap.has(supplier.countryOfOriginId)) {
				countryMap.set(supplier.countryOfOriginId, {
					name: data.countryOfOrigins[supplier.countryOfOriginId-1].name,
					count: 0
				});
			}
			countryMap.get(supplier.countryOfOriginId).count++;
	    });
		
		// Build the key and value arrays for the Legal Structure pie chart
		legalStructureMap.forEach(function (value, key, map) {
			dashboard.legalStructureLabels.push(value.name);
			dashboard.legalStructureData.push(value.count);
		});
		
		// Build the key and value arrays for the Country of Origin pie chart
		countryMap.forEach(function (value, key, map) {
			dashboard.countryLabels.push(value.name);
			dashboard.countryData.push(value.count);
		});
    });
})

// Controller for searching for a Supplier
.controller('SearchController', function (SupplierService) {
	var search = this;
	search.headingTitle = 'Search for Suppliers';
	SupplierService.fetchAll().then(function(data) {
		search.suppliers = data;
    });
})

// Filter for searching Suppliers
.filter('supplierFilter', function(){
    return function(suppliers, query){
    	var output = [];
    	angular.forEach(suppliers, function (supplier) {
    		if (query != null) {
        		if (supplier.supplierName.toLowerCase().search(query.toLowerCase()) > -1) {
        			output.push(supplier);
        		} else if (supplier.dba.toLowerCase().search(query.toLowerCase()) > -1) {
        			output.push(supplier);
        		} else if (supplier.otherNames.toLowerCase().search(query.toLowerCase()) > -1) {
        			output.push(supplier);
        		}
        	} else {
        		output = suppliers;
        	}
        });
        return output;
    };
})

// Controller for displaying the list of all Suppliers
.controller('SupplierListController', function(suppliers, legalStructures) {
	var supplierList = this;
	supplierList.headingTitle = 'Manage Suppliers';
	supplierList.suppliers = suppliers;
	
	supplierList.getLegalStructure = function(id) {
		return legalStructures[id-1].name;
	}
})

// Controller for creating a Supplier
.controller('NewSupplierController', function($location, SupplierService, legalStructures, taxIdTypes, countryOfOrigins) {
  // Setup
  var supplierInfo = this;
  supplierInfo.isEdit = false;

  //Dropdown options
  supplierInfo.legalStructures = legalStructures;
  supplierInfo.taxIdTypes = taxIdTypes;
  supplierInfo.countryOfOrigins = countryOfOrigins;

  // Defaults to the first value
  supplierInfo.legalStructuresInit = supplierInfo.legalStructures[0].id;
  supplierInfo.taxIdTypesInit = supplierInfo.taxIdTypes[0].id;
  supplierInfo.countryOfOriginsInit = supplierInfo.countryOfOrigins[0].id;

  // Allow the form to create the Supplier
  supplierInfo.create = function() {
    SupplierService.create(supplierInfo.supplier).then(function(data) {
        $location.path('/admin/suppliers');
    });
  };
})

// Controller for updating a Supplier
.controller('EditSupplierController',
  function($location, $routeParams, $http, SupplierService, supplier, legalStructures, taxIdTypes, countryOfOrigins) {
    // Setup
    var supplierInfo = this;
    var id = $routeParams.supplierId;
    supplierInfo.supplier = supplier;
    supplierInfo.isEdit = true;

    // Dropdown options
    supplierInfo.legalStructures = legalStructures;
    supplierInfo.taxIdTypes = taxIdTypes;
    supplierInfo.countryOfOrigins = countryOfOrigins;

    // Defaults to the chosen value
    supplierInfo.legalStructuresInit = supplierInfo.legalStructures[supplierInfo.supplier.legalStructureId-1].id;
    supplierInfo.taxIdTypesInit = supplierInfo.taxIdTypes[supplierInfo.supplier.taxIdTypeId-1].id;
    supplierInfo.countryOfOriginsInit = supplierInfo.countryOfOrigins[supplierInfo.supplier.countryOfOriginId-1].id;

    // Allow the form to delete the Supplier
    supplierInfo.delete = function() {
      SupplierService.delete(id).then(function(data) {
          $location.path('/admin/suppliers');
      });
    };

    // Allow the form to update the Supplier
    supplierInfo.update = function() {
      SupplierService.update(id, supplierInfo.supplier).then(function(data) {
          $location.path('/admin/suppliers');
      });
    };
});