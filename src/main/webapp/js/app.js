var messageCenterApp = angular.module('messageCenterApp', []);


messageCenterApp.controller("CreateMessageController", function($scope, $http) {
    $scope.success = false;

    $scope.formData = {};

    $scope.createMessage = function() {
        $http({
            method: 'POST',
            url: 'api/v0/message',
            data: JSON.stringify($scope.formData),
            headers: {
                'Content-Type': 'application/json'
            }
        }).then(function successCallback(response) {
            $scope.success = true;

            $scope.formData = {};
        });
    };
});