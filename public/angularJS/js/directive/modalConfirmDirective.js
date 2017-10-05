myApp.directive("modalConfirmDirective", function(){
	var ddo = {};

    ddo.restrict = "E";

    ddo.transclude = true;

    ddo.scope = {
        show:          "=",
        title :        "@",
        confirmAction: "&",
        cancelAction:  "&"
    };

    ddo.templateUrl = "public/angularJS/view/modalConfirm.html";

    return ddo;
});