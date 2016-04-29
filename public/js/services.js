angular.module('services', [])

// Service for interacting with Supplier API
.service('SupplierService', function($routeParams, $http, $q) {

  // Gets all of the Suppliers
  this.fetchAll = function () {
    var deferred = $q.defer();
    $http.get('/api/supplier/').success(function(data) {
      deferred.resolve(data);
    });
    return deferred.promise;
  };

  // Gets a single Supplier
  this.fetchOne = function (id) {
    var deferred = $q.defer();
    $http.get('/api/supplier/' + id).success(function(data) {
      deferred.resolve(data);
    });
    return deferred.promise;
  };

  // Creates a single Supplier
  this.create = function(supplier) {
    var deferred = $q.defer();
    $http.post('/api/supplier/', supplier).success(function(data) {
      deferred.resolve(data);
    });
    return deferred.promise;
  };

  // Updates a single Supplier
  this.update = function(id, supplier) {
    var deferred = $q.defer();
    $http.put('/api/supplier/' + id, supplier).success(function(data) {
      deferred.resolve(data);
    });
    return deferred.promise;
  }

  // Deletes a single Supplier
  this.delete = function(id) {
    var deferred = $q.defer();
    $http.delete('/api/supplier/' + id).success(function(data) {
      deferred.resolve(data);
    });
    return deferred.promise;
  };
  
  //Gets all of the Legal Structure options
  this.fetchAllLegalStructures = function () {
    var deferred = $q.defer();
    $http.get('/api/supplier/legalStructures/').success(function(data) {
      deferred.resolve(data);
    });
    return deferred.promise;
  };
  
  //Gets all of the Tax ID Types options
  this.fetchAllTaxIdTypes = function () {
    var deferred = $q.defer();
    $http.get('/api/supplier/taxIdTypes/').success(function(data) {
      deferred.resolve(data);
    });
    return deferred.promise;
  };
  
  //Gets all of the Country of Origin options
  this.fetchAllCountryOfOrigins = function () {
    var deferred = $q.defer();
    $http.get('/api/supplier/countryOfOrigins/').success(function(data) {
      deferred.resolve(data);
    });
    return deferred.promise;
  };
  
  this.fetchChartData = function() {
	  let promises = {
		suppliers: this.fetchAll(),
		legalStructures: this.fetchAllLegalStructures(),
		countryOfOrigins: this.fetchAllCountryOfOrigins()
	  }
      var deferred = $q.defer();
      $q.all(promises).then(function(values) {
        deferred.resolve(values);
      });
      return deferred.promise;
  }

});
