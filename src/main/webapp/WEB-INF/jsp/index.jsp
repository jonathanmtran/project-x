<!DOCTYPE html>
<html lang="en" ng-app="messageCenterApp">
<head>
    <meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <!-- The above 3 meta tags *must* come first in the head; any other head content must come *after* these tags -->
    <title>Message Center</title>

    <!-- Bootstrap -->
    <link href="webjars/bootstrap/3.3.7-1/css/bootstrap.min.css" rel="stylesheet">

    <style>
    body {
      padding-top: 50px;
    }
    .starter-template {
      padding: 40px 15px;
      text-align: center;
    }
    </style>

    <script src="webjars/angularjs/1.6.9/angular.min.js"></script>
    <script src="js/app.js"></script>
    <script src="js/mailbox-messages-list/mailbox-messages-list.component.js"></script>
</head>
<body>
<nav class="navbar navbar-inverse navbar-fixed-top">
    <div class="container">
        <div class="navbar-header">
            <button type="button" class="navbar-toggle collapsed" data-toggle="collapse" data-target="#navbar" aria-expanded="false" aria-controls="navbar">
                <span class="sr-only">Toggle navigation</span>
                <span class="icon-bar"></span>
                <span class="icon-bar"></span>
                <span class="icon-bar"></span>
            </button>
            <a class="navbar-brand" href="#">Message Center</a>
        </div>
        <div id="navbar" class="collapse navbar-collapse">
            <ul class="nav navbar-nav">
                <li class="active"><a href="#mailbox">Home</a></li>
                <li><a href="#create-message">Create message</a></li>
                <li><a href="#send">Send Message</a></li>
            </ul>
        </div><!--/.nav-collapse -->
    </div>
</nav>

<div class="container">

    <div class="starter-template">
        <h1>Message Center</h1>
        <p class="lead">Use this document as a way to quickly start any new project.<br> All you get is this text and a mostly barebones HTML document.</p>
    </div>

    <h1 id="mailbox">Your Messages</h1>
    <mailbox-messages-list></mailbox-messages-list>

    <h1 id="create-message">Create Message</h1>
    <div ng-controller="CreateMessageController">
        <div class="alert alert-success" role="alert" role="alert" ng-if="success">
            <button type="button" class="close" data-dismiss="alert" aria-label="Close"><span aria-hidden="true">&times;</span></button>
            <strong>Well done!</strong> The message was created.
        </div>

        <form class="form-horizontal" ng-submit="createMessage()">
            <div class="form-group">
                <label class="col-sm-2 control-label">Subject</label>
                <div class="col-sm-10">
                    <input type="text" name="subject" class="form-control" ng-model="formData.subject" />
                </div>
            </div>

            <div class="form-group">
                <label class="col-sm-2 control-label">Abstract</label>
                <div class="col-sm-10">
                    <input type="text" name="abstract" class="form-control" ng-model="formData.messageAbstract" />
                </div>
            </div>

            <div class="form-group">
                <label class="col-sm-2 control-label">Message</label>
                <div class="col-sm-10">
                    <textarea name="message" class="form-control" ng-model="formData.message"></textarea>
                </div>
            </div>

            <button type="submit" class="btn btn-default">Submit</button>
        </form>
    </div>

</div><!-- /.container -->

<!-- jQuery (necessary for Bootstrap's JavaScript plugins) -->
<script src="https://ajax.googleapis.com/ajax/libs/jquery/1.12.4/jquery.min.js"></script>
<!-- Include all compiled plugins (below), or include individual files as needed -->
<script src="webjars/bootstrap/3.3.7-1/js/bootstrap.min.js"></script>

</body>
</html>