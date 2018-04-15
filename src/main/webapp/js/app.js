var messageCenterApp = angular.module('messageCenterApp', [
    'ngRoute',
    'messageModule',
]);

var userId = '';

messageCenterApp.config([
    '$locationProvider',
    '$routeProvider',
    function config($locationProvider, $routeProvider) {
        $locationProvider.hashPrefix('!');

        $routeProvider.
        when('/', {
            templateUrl: 'js/mailbox/list.template.html',
        }).
        when('/mailbox', {
            templateUrl: 'js/mailbox/list.template.html',
        }).
        when('/create-message', {
            templateUrl: 'js/message/create.template.html',
        }).
        when('/404', {
            template: 'oops',
        }).
        otherwise('/404');
    }
]);

var messageModule = angular.module('messageModule', [
    'ngRoute'
]);

messageModule.controller("CreateMessageController", ['$scope', '$http', function ($scope, $http) {
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
}]
);
