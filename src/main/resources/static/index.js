angular.module('app', []).controller('indexController', function ($scope, $http) {
    const contextPath = 'http://localhost:8187/app';

    $scope.loadProducts = function () {
        $http.get(contextPath + '/products')
            .then(function (response) {
                $scope.ProductsList = response.data;
            });
    };

    $scope.deleteProduct = function (productId) {
        $http.get(contextPath + '/products/delete/' + productId)
            .then(function (response) {
                $scope.loadProducts();
            });
    }

    $scope.changeCoast = function (productId, delta) {
        $http({
            url: contextPath + '/products/change_coast',
            method: 'GET',
            params: {
                productId: productId,
                delta: delta
            }
        }).then(function (response) {
            $scope.loadProducts();
        });
    }

    $scope.getCustomersByProductId = function (){

        $http.post(contextPath + '/products/customer_orders', $scope.newProduct
       ).then(function (response) {
            $scope.loadProducts();
  //          $scope.OrdersList = response.data;
       })
    }

    $scope.updateProduct = function (){

       $http.post(contextPath + '/products/update_product', $scope.newProduct
       ).then(function (response) {
           $scope.loadProducts();

       })
    }

    // $scope.loadOrders = function () {
    //     $http.get(contextPath + '/orders')
    //         .then(function (response) {
    // //            $scope.OrdersList = response.data;
    //         });
    // };

    $scope.loadProducts();
});