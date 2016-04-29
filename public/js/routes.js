angular.module('routes', [])

.config(['$routeProvider', '$locationProvider', function($routeProvider, $locationProvider) {

  $routeProvider
    .when('/', {
      templateUrl: 'views/dashboard.html',
      controller: 'DashboardController as dashboard'
    })
    .when('/search', {
      templateUrl: 'views/search.html',
      controller: 'SearchController'
    })
    .when('/admin/suppliers', {
      templateUrl: 'views/supplier-list.html',
      controller: 'SupplierListController as supplierList',
      resolve: {
		suppliers: function(SupplierService) {
		  return SupplierService.fetchAll();
		},
        legalStructures: function(SupplierService) {
        	return SupplierService.fetchAllLegalStructures();
        }
      }
    })
    .when('/admin/suppliers/new', {
      templateUrl: 'views/supplier-info.html',
      controller:'NewSupplierController as supplierInfo',
      resolve: {
          legalStructures: function(SupplierService) {
          	return SupplierService.fetchAllLegalStructures();
          },
          taxIdTypes: function(SupplierService) {
          	return SupplierService.fetchAllTaxIdTypes();
          },
          countryOfOrigins: function(SupplierService) {
          	return SupplierService.fetchAllCountryOfOrigins();
          }
        }
    })
    .when('/admin/suppliers/:supplierId', {
      templateUrl: 'views/supplier-info.html',
      controller: 'EditSupplierController as supplierInfo',
      resolve: {
        supplier: function($route, SupplierService) {
        	return SupplierService.fetchOne($route.current.pathParams.supplierId);
        },
        legalStructures: function(SupplierService) {
        	return SupplierService.fetchAllLegalStructures();
        },
        taxIdTypes: function(SupplierService) {
        	return SupplierService.fetchAllTaxIdTypes();
        },
        countryOfOrigins: function(SupplierService) {
        	return SupplierService.fetchAllCountryOfOrigins();
        }
      }
    })
    .otherwise({
      redirectTo: '/'
    });

}]);
