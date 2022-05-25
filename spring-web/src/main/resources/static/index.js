angular.module('app', []).controller('indexController', function ($scope, $http) {
    const contextPath = 'http://localhost:8189/app/api/v1';

    $scope.loadProducts = function (numberPage) {

        if (isNaN(numberPage)){numberPage = 1;}

        $http({
            url: contextPath + '/products',
            method: 'GET',
            params: {
                title_part: $scope.filter ? $scope.filter.title_part : null,
                min_price: $scope.filter ? $scope.filter.min_price : null,
                max_price: $scope.filter ? $scope.filter.max_price : null,
                number_page: numberPage

            }
        }).then(function (response) {
                $scope.ProductsPage = response.data;
            });
    };

    $scope.loadProductsNotFilter = function (numberPage) {

        if (isNaN(numberPage)){numberPage = 1;}

        $http({
            url: contextPath + '/products',
            method: 'GET',
            params: {
                number_page: numberPage
            }
        }).then(function (response) {
                $scope.ProductsPage = response.data;
            });
    };

    $scope.deleteProduct = function (productId) {
        $http.delete(contextPath + '/products/' + productId)
            .then(function (response) {
                $scope.loadProducts();
            });
    };

    $scope.createProductJson = function (){

        $http.post(contextPath + '/products', $scope.newProductJson
        ).then(function (response) {
            $scope.loadProducts( );
        })
    };

    $scope.addProductToCart = function (productId) {
        $http.get(contextPath + '/carts/add/' + productId)
        .then(function (response) {
            $scope.ProductAmount = response.data;
            $scope.loadCart();
        });
    };

    $scope.deleteProductFromCart = function (productId) {
        $http.get(contextPath + '/carts/delete/' + productId)
            .then(function (response) {
                $scope.loadCart();
            });
    };

    $scope.loadCart = function () {
        $http.get(contextPath + '/carts')
            .then(function (response) {
                $scope.Cart = response.data;
            });
    };

    $scope.changeAmountProduct = function (productId, delta) {
        $http({
            url: contextPath + '/carts',
            method: 'PUT',
            params: {
                productId: productId,
                delta: delta
            }
        }).then(function (response) {
            $scope.loadCart();
        });
    };

    $scope.loadCart();
    $scope.loadProducts();
});