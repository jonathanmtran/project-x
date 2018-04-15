messageCenterApp.component('mailboxMessagesList', {
    templateUrl: 'js/mailbox-messages-list/mailbox-messages-list.template.html',
    controller: function MailboxMessagesListController($http) {
        var self = this;

        $http.get('api/v0/mailbox?userId=' + userId).then(function(response) {
            self.mailboxMessages = response.data;
        });
    }
});
