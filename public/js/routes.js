angular.module('routes', [])

.config(['$routeProvider', '$locationProvider', function($routeProvider, $locationProvider) {

  $routeProvider
    .when('/', {
      templateUrl: 'views/dashboard.html',
      controller: 'DashboardController'
    })
    .when('/search', {
      templateUrl: 'views/search.html',
      controller: 'SearchController as search',
      resolve: {
  		suppliers: function(SupplierService) {
  		  return SupplierService.fetchAll();
  		}
      }
    })
    .when('/admin/suppliers', {
      templateUrl: 'views/supplier-list.html',
      controller: 'SupplierListController as supplierList',
      resolve: {
		suppliers: function(SupplierService) {
		  return SupplierService.fetchAll();
		}
      }
    })
    .when('/admin/suppliers/new', {
      templateUrl: 'views/supplier-info.html',
      controller:'NewSupplierController as supplierInfo',
      resolve: {
          legalStructures: function($route, SupplierService) {
          	return SupplierService.fetchAllLegalStructures();
          },
          taxIdTypes: function($route, SupplierService) {
          	return SupplierService.fetchAllTaxIdTypes();
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
        legalStructures: function($route, SupplierService) {
        	return SupplierService.fetchAllLegalStructures();
        },
        taxIdTypes: function($route, SupplierService) {
        	return SupplierService.fetchAllTaxIdTypes();
        }
      }
    })
    .otherwise({
      redirectTo: '/'
    });

}]);
