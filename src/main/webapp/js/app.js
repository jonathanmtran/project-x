var app = angular.module('messageCenterApp', [
    'ngRoute',
    'loginModule',
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
            redirectTo: '/login'
        }).
        when('/login', {
            templateUrl: 'js/login/login.template.html',
        }).
        when('/mailbox', {
            templateUrl: 'js/mailbox/list.template.html',
        }).
        when('/create-message', {
            templateUrl: 'js/message/create.template.html',
        }).
        when('/send', {
            templateUrl: 'js/message/send.template.html',
        }).
        when('/404', {
            template: 'oops',
        }).
        otherwise('/404');
    }
]);
