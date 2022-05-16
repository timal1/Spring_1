angular.module('app', []).controller('indexController', function ($scope, $http) {
    const contextPath = 'http://localhost:8189/app/api/v1';

    $scope.loadProducts = function (pageIndex = 1) {

        $http({
            url: contextPath + '/products',
            method: 'GET',
            params: {
                title_part: $scope.filter ? $scope.filter.title_part : null,
                min_price: $scope.filter ? $scope.filter.min_price : null,
                max_price: $scope.filter ? $scope.filter.max_price : null

            }
        }).then(function (response) {
                $scope.ProductsList = response.data.content;
            });
    };

    $scope.deleteProduct = function (productId) {
        $http.delete(contextPath + '/products/' + productId)
            .then(function (response) {
                $scope.loadProducts();
            });
    }

    $scope.createProductJson = function (){

       $http.post(contextPath + '/products', $scope.newProductJson
       ).then(function (response) {
           $scope.loadProducts( );
       })
    }

    $scope.updateProductJson = function (){

       $http.put(contextPath + '/products', $scope.newProductJson
       ).then(function (response) {
           $scope.loadProducts( );
       })
    }

    $scope.loadProducts();
});