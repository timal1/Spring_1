angular.module('app', []).controller('indexController', function ($scope, $http) {
    const contextPath = 'http://localhost:8189/app';


    let numPage;

    $scope.loadProductsByNumberPage = function (numberPage) {

        numPage = numberPage;
        $http({
            url: contextPath + '/products',
            method: 'GET',
            params: {
                numberPage: numberPage
            }
        }).then(function (response) {
                $scope.ProductsList = response.data;
            });
    };

    $scope.loadProductsByNumberPage(1);

    $scope.findAllByCoastBetween = function (){
        var minCoast, maxCoast;
        minCoast = document.getElementById('min_coast').value;
        minCoast = parseInt(minCoast);
        if (isNaN(minCoast)){minCoast = 0;}

        maxCoast = document.getElementById('max_coast').value;
        maxCoast = parseInt(maxCoast);
        if (isNaN(maxCoast)){maxCoast = 10000;}

        $http({
            url: contextPath + '/products/coast_between',
            method: 'GET',
            params: {
                minCoast: minCoast,
                maxCoast: maxCoast,

            }
        }).then(function (response) {
            $scope.ProductsList = response.data;
        });
    }

    $scope.deleteProduct = function (productId) {
        $http.get(contextPath + '/products/delete/' + productId)
            .then(function (response) {
                $scope.loadProductsByNumberPage(numPage);
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
            $scope.loadProductsByNumberPage(numPage);
        });
    }

    $scope.updateProduct = function (){

       $http.post(contextPath + '/products/save_or_update', $scope.newProduct
       ).then(function (response) {
           $scope.loadProductsByNumberPage(numPage);
       })
    }

});