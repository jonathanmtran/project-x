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

messageModule.component('mailboxMessagesList', {
    templateUrl: 'js/message/list.template.html',
    controller: function MailboxMessagesListController($http) {
        var self = this;

        $http.get('api/v0/mailbox?userId=' + userId).then(function(response) {
            self.mailboxMessages = response.data;
        });
    }
});
