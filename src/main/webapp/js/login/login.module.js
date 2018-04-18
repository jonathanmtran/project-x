var loginModule = angular.module('loginModule', [
    'ngRoute'
]);

loginModule.controller("LoginController", ['$scope', '$http', '$window', '$location', function ($scope, $http, $window, $location) {
    $scope.formData = {};

    $scope.logIn = function() {
        $http.post('login', JSON.stringify($scope.formData), {
            headers: {
                'Content-Type': 'application/json'
            }
        })
        .then(function successCallback(response) {
            $window.localStorage.setItem('userId', response.data.userId);

            $scope.formData = {};

            $location.path('/mailbox')
        });
    };
}]
);
