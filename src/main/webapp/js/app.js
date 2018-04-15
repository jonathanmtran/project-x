var app = angular.module('messageCenterApp', [
    'ngRoute',
    'messageModule',
]);

var userId = '';

app.config([
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
