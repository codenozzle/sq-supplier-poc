angular.module('controllers', [])

// Controller for displaying the Dashboard
.controller('DashboardController', function($scope) {
    $scope.heading = 'Find a Supplier!';
    $scope.tagline = 'Find the right Supplier for all your needs!';
})

// Controller for searching for a Supplier
.controller('SearchController', function (suppliers) {
	var search = this;
	search.headingTitle = 'Search for Suppliers';
	search.suppliers = suppliers;
})

// Controller for displaying the list of all Suppliers
.controller('SupplierListController', function(suppliers) {
	var supplierList = this;
	supplierList.headingTitle = 'Manage Suppliers';
	supplierList.suppliers = suppliers;
})

// Controller for creating a Supplier
.controller('NewSupplierController', function($location, SupplierService, legalStructures, taxIdTypes) {
  // Setup
  var supplierInfo = this;
  supplierInfo.isEdit = false;

  //Dropdown options
  supplierInfo.legalStructures = legalStructures;
  supplierInfo.taxIdTypes = taxIdTypes;

  // Defaults to the first value
  supplierInfo.legalStructuresInit = supplierInfo.legalStructures[0].id;
  supplierInfo.taxIdTypesInit = supplierInfo.taxIdTypes[0].id;

  // Allow the form to create the Supplier
  supplierInfo.create = function() {
    SupplierService.create(supplierInfo.supplier).then(function(data) {
        $location.path('/admin/suppliers');
    });
  };
})

// Controller for updating a Supplier
.controller('EditSupplierController',
  function($location, $routeParams, $http, SupplierService, supplier, legalStructures, taxIdTypes) {
    // Setup
    var supplierInfo = this;
    var id = $routeParams.supplierId;
    supplierInfo.supplier = supplier;
    supplierInfo.isEdit = true;

    // Dropdown options
    supplierInfo.legalStructures = legalStructures;
    supplierInfo.taxIdTypes = taxIdTypes;

    // Defaults to the chosen value
    supplierInfo.legalStructuresInit = supplierInfo.legalStructures[supplierInfo.supplier.legalStructureId-1].id;
    supplierInfo.taxIdTypesInit = supplierInfo.taxIdTypes[supplierInfo.supplier.taxIdTypeId-1].id;

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