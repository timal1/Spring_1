angular.module('app', []).controller('userController',

    function ($scope, $http) {

        const contextPath = 'http://localhost:8189/app/api/v1/users';

        $scope.getUser = function () {
            $http.get(contextPath + "/")
                .then(function (resp) {
                })
        };
        $scope.login = function () {
            $http.post(contextPath + '/login', $scope.user)
                .then(function () {
                    $scope.getUser()
                });
        };
    });