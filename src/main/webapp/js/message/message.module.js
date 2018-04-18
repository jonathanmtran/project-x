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

messageModule.controller("SendMessageController", ['$scope', '$http', function($scope, $http) {
    $scope.availableServices = [];
    $scope.formData = {};
    $scope.messages = {};
    $scope.services = [];
    $scope.step = 'choose';
    $scope.success = false;

    $http.get('api/v0/messages').
    then(function successCallback(response) {
        $scope.messages = response.data;
    });

    $http.get('api/v0/messaging-services').
    then(function successCallback(response) {
        $scope.availableServices = response.data;
    });

    $scope.messageChange = function() {
        $scope.message = $scope.messages.filter(function(message) {
            return message.id === $scope.formData.message;
        });

        $scope.message = $scope.message[0];
    }

    $scope.servicesChange = function() {
        var targetServices = $scope.formData.services;

        var newServices = [];

        // TODO: Clean this up
        for(service in $scope.availableServices) {
            for(targetSvc in targetServices) {
                if(($scope.availableServices[service].systemName == targetSvc) && (targetServices[targetSvc] === true)) {
                    newServices.push($scope.availableServices[service]);
                }
            }
        }

        $scope.services = newServices;
    }

    $scope.doReview = function() {
        $scope.step = 'review'
    }

    $scope.sendMessage = function() {
        var targetServices = [];

        for(svc in $scope.services) {
            targetServices.push(svc.systemName);
        }

        var data = {
            'messageId': $scope.message.id,
            'services': targetServices
        };

        $http({
            method: 'POST',
            url: 'api/v0/mailbox/send',
            data: JSON.stringify(data),
            headers: {
                'Content-Type': 'application/json'
            }
        }).then(function successCallback(response) {
            $scope.success = true;

            $scope.step = 'choose';

            $scope.formData = {};
        });
    }
}]
);

messageModule.component('mailboxMessagesList', {
    templateUrl: 'js/message/list.template.html',
    controller: function MailboxMessagesListController($http) {
        var self = this;

        $http.get('api/v0/mailbox?userId=' + window.localStorage.getItem('userId')).then(function(response) {
            self.mailboxMessages = response.data;
        });
    }
});
