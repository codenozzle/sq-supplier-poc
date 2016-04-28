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
.controller('NewSupplierController', function($location, SupplierService) {
  // Setup
  var supplierInfo = this;
  supplierInfo.isEdit = false;

  // Dropdown options
  //editAmmoInfo.inStockOptions = inStockOptions;
  //editAmmoInfo.supplierOptions = supplierOptions;

  // Defaults to the first value
  //editAmmoInfo.inStockInit = editAmmoInfo.inStockOptions[0].id;
  //editAmmoInfo.supplierInit = editAmmoInfo.supplierOptions[0].id;

  // Allow the form to create the Supplier
  supplierInfo.create = function() {
    SupplierService.create(supplierInfo.supplier).then(function(data) {
        $location.path('/admin/suppliers');
    });
  };
})

// Controller for updating a Supplier
.controller('EditSupplierController',
  function($location, $routeParams, $http, SupplierService, supplier) {
    // Setup
    var supplierInfo = this;
    var id = $routeParams.supplierId;
    supplierInfo.supplier = supplier;
    supplierInfo.isEdit = true;

    // Dropdown options
    //supplierInfo.inStockOptions = inStockOptions;
    //supplierInfo.supplierOptions = supplierOptions;

    // Defaults to the chosen value
    //supplierInfo.inStockInit = supplierForm.inStockOptions[supplierForm.supplierInfo.inStockId-1].id;
    //supplierInfo.supplierInit = supplierForm.supplierOptions[supplierForm.supplierInfo.supplierId-1].id;

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