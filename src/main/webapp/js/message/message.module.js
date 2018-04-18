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
    $scope.formData = {};
    $scope.step = 'choose';
    $scope.success = false;

    $http.get('api/v0/messages').
    then(function successCallback(response) {
        $scope.messages = response.data;
    });

    $http.get('api/v0/messaging-services').
    then(function successCallback(response) {
        $scope.services = response.data;
    });

    $scope.doReview = function() {
        $scope.step = 'review'
    }

    $scope.sendMessage = function() {
        var services = [];
        var targetServices = $scope.formData.targetServices;

        for(service in targetServices) {
            if(targetServices[service]) {
                services.push(service);
            }
        }

        var data = {
            'messageId': $scope.formData.message,
            'services': services
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
